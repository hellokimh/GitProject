package com.example.testproject.DownLoad;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;

import androidx.core.content.FileProvider;

public class DownLoadUtils {
    private DownloadManager mDownloadManager;
    private DownloadManager.Request mRequest;
    private Context mContext;
    private Builder mBuilder;
    private long downloadId;
    private Cursor cursor;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkStatus();
        }
    };

    public DownLoadUtils(Context context, Builder builder) {
        mContext = context;
        this.mBuilder = builder;
    }

    public void createDownload() throws DownLoadException {
        if (haveit()) {
            return;
        }
        /*LogUtil.e("already:","createdDownload");*/
        mDownloadManager = (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
        if (TextUtils.isEmpty(mBuilder.getFileUrl())) {
            throw new DownLoadException("file path is null");
        }
        mRequest = new DownloadManager.Request(Uri.parse(mBuilder.getFileUrl()));

        //将下载文件的本地目标设置为公共外部存储目录中的路径 subpath:外部目录中的路径，包括目标文件名
        if (TextUtils.isEmpty(mBuilder.getFileName())) {
            throw new DownLoadException("file name is null");
        }
        mRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, mBuilder.getFileName());

        mRequest.setAllowedOverRoaming(mBuilder.getAllowedOverRoaming());
        //设置允许使用的网络类型，这里是移动网络和wifi都可以
        mRequest.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        //设置此下载的MIME内容类型。这将覆盖服务器响应中声明的内容类型。
        mRequest.setMimeType("application/vnd.android.package-archive");
        //设置通知栏
        mRequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        mRequest.setTitle(mBuilder.getNotificationTitle());
        mRequest.setDescription(mBuilder.getNotificationTitle());
        downloadId = mDownloadManager.enqueue(mRequest);
        mContext.registerReceiver(mBroadcastReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    /**
     * 检查下载状态
     */
    private void checkStatus() {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(downloadId);
        cursor = mDownloadManager.query(query);
//        cursor.getInt(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
        if (cursor.moveToFirst()) {
            int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
            switch (status) {
                //下载暂停
                case DownloadManager.STATUS_PAUSED:
                    break;
                //下载延迟
                case DownloadManager.STATUS_PENDING:
                    break;
                //正在下载
                case DownloadManager.STATUS_RUNNING:
                    break;
                //下载完成
                case DownloadManager.STATUS_SUCCESSFUL:
                    File apkFile =
                            new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), mBuilder.getFileName());
                    installAPK(apkFile);
                    break;
                //下载失败
                case DownloadManager.STATUS_FAILED:
                    Toast.makeText(mContext.getApplicationContext(), "下载失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        cursor.close();
    }

    private boolean haveit() {
        File apkFile =
                new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), mBuilder.getFileName());
        if (apkFile.exists()) {
            installAPK(apkFile);
            return true;
        } else {
            return false;
        }

    }

    private void installAPK(File apkFile) {


        /*LogUtil.e("filepath:",apkFile.getPath());
        LogUtil.e("filename:",apkFile.getName());
        LogUtil.e("fileAbspath:",apkFile.getAbsolutePath());
        LogUtil.e("filesize",apkFile.length()+"");*/
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri apkUri = FileProvider.getUriForFile(mContext, mContext.getPackageName() + ".fileprovider", apkFile);
            /*LogUtil.e("apkUri:",apkUri.toString());*/
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        mContext.startActivity(intent);


    }

    public static class Builder {
        //下载的文件名称
        private String fileName;
        //下载的file Url
        private String fileUrl;
        //下载的文件保存路径
        private String saveFilePath;
        //下载apk通知提示的titie
        private String notificationTitle;
        //下载apk通知展示的提示信息
        private String notificationShowText;
        //设置此下载是否可以通过漫游连接进行。默认情况下，允许漫游。
        private boolean allowedOverRoaming = true;

        public String getFileName() {
            return fileName;
        }

        public Builder setFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public boolean getAllowedOverRoaming() {
            return allowedOverRoaming;
        }

        public Builder setAllowedOverRoaming(boolean allowedOverRoaming) {
            this.allowedOverRoaming = allowedOverRoaming;
            return this;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public Builder setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
            return this;
        }

        public String getSaveFilePath() {
            return saveFilePath;
        }

        public Builder setSaveFilePath(String saveFilePath) {
            this.saveFilePath = saveFilePath;
            return this;
        }

        public String getNotificationTitle() {
            return notificationTitle;
        }

        public Builder setNotificationTitle(String notificationTitle) {
            this.notificationTitle = notificationTitle;
            return this;
        }

        public String getNotificationShowText() {
            return notificationShowText;
        }

        public Builder setNotificationShowText(String notificationShowText) {
            this.notificationShowText = notificationShowText;
            return this;
        }

        public DownLoadUtils create(Context context) {
            return new DownLoadUtils(context, this);
        }
    }

    public class DownLoadException extends Exception {
        public DownLoadException(String message) {
            super(message);
        }

        public DownLoadException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}