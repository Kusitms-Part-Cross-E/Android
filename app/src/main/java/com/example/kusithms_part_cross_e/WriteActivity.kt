package com.example.kusithms_part_cross_e

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kusithms_part_cross_e.databinding.ActivityWriteBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class WriteActivity : AppCompatActivity() {

    lateinit var activityWriteBinding: ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityWriteBinding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(activityWriteBinding.root)

        activityWriteBinding.run {
            toolbarWrite.run {
                title = "게시글 작성"
            }
        }
    }
}