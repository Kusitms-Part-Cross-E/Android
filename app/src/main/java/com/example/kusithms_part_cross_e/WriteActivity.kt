package com.example.kusithms_part_cross_e

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kusithms_part_cross_e.databinding.ActivityWriteBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class WriteActivity : AppCompatActivity() {

    lateinit var activityWriteBinding: ActivityWriteBinding

    var tagList = mutableListOf<String>()
    var title = ""
    var content = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityWriteBinding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(activityWriteBinding.root)

        activityWriteBinding.run {
            toolbarWrite.run {
                title = "게시글 작성"
            }

//            textInputEditTextWriteCotent.click {
//                textInputLayoutWriteContent.hint = ""
//            }


            buttonWriteComplete.setOnClickListener {
                writeArticle()
            }
        }
    }

    fun writeArticle() {


        activityWriteBinding.run {
            editTextWriteTitle.text.toString()
            textInputEditTextWriteCotent.text.toString()

            if (chipWriteTag1.isChecked) {
                tagList.add("STUDY")
            }
            if (chipWriteTag2.isChecked) {
                tagList.add("HEALTH")
            }
            if (chipWriteTag3.isChecked) {
                tagList.add("DRINK")
            }
            if (chipWriteTag4.isChecked) {
                tagList.add("OTHER")
            }
        }
        Log.d("kusitms","tagList : $tagList")


        var a1 = WriteArticleRequest(title,"",content,tagList)

        RetrofitInstance.service.writeArticle(a1)?.enqueue(object : Callback<WriteArticleResponse> {
            override fun onResponse(call: Call<WriteArticleResponse>, response: Response<WriteArticleResponse>) {
                if(response.isSuccessful) {
                    // 정상적으로 통신이 성공된 경우
                    var result: WriteArticleResponse? = response.body()
                    Log.d("##", "onResponse 성공: " + result?.toString())
                    var detailIntent =
                        Intent(this@WriteActivity, DetailActivity::class.java)
                    startActivity(detailIntent)
                } else {
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    var result: WriteArticleResponse? = response.body()
                    val errorBody = response.errorBody()?.string() // 에러 응답 데이터를 문자열로 얻음
                    Log.d("##","Error Response: $errorBody")
                    Log.d("##", "onResponse 실패")
                    Log.d("##", "onResponse 실패: " + response.code())
                }
            }

            override fun onFailure(call: Call<WriteArticleResponse>, t: Throwable) {
                // 통신 실패
                Log.d("##", "onFailure 에러: " + t.message.toString());
            }
        })
    }
}