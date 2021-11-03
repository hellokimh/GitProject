package com.example.testproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.DownLoad.DownLoadUtils
import com.example.testproject.DownLoad.DownLoadUtils.DownLoadException

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        try {
            initView()
        } catch (e: DownLoadException) {
            e.printStackTrace()
        }
    }

    @Throws(DownLoadException::class)
    private fun initView() {
        DownLoadUtils.Builder()
                .setAllowedOverRoaming(false) //.setFileName(this.getPackageName() + appEntity.ver + "_" + System.currentTimeMillis() + ".apk")
                .setFileName(this.packageName + 5 + "_" + System.currentTimeMillis() + ".apk") //.setFileUrl(appEntity.url)
                .setFileUrl("httt:sssss") //.setNotificationTitle("新版本_" + appEntity.ver)
                .setNotificationTitle("新版本_" + "55555")
                .setNotificationShowText("下载中")
                .create(this).createDownload()
    }
}