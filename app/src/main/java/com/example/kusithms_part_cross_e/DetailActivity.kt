package com.example.kusithms_part_cross_e

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.kusithms_part_cross_e.databinding.ActivityDetailBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DetailActivity : AppCompatActivity() {

    lateinit var activityDetailBinding: ActivityDetailBinding
    private var articleId = 0
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        articleId = intent.getIntExtra("article_id",-1)
        viewModel.getArticleDetail(articleId)

        viewModel.article.observe(this) {
            Log.d("taag",it.toString())
            activityDetailBinding.editTextDetailTitle.setText(it.title)
            activityDetailBinding.textInputEditTextDetailCotent.setText(it.description)
        }

        activityDetailBinding.run {

            editTextDetailTitle.isEnabled = false
            textInputEditTextDetailCotent.isEnabled = false
            buttonDetailComplete.visibility = View.GONE
            chipDetailTag1.isCheckable = false
            chipDetailTag2.isCheckable = false
            chipDetailTag3.isCheckable = false
            chipDetailTag4.isCheckable = false


            toolbarDetail.run {
                title = "게시글 상세"

                inflateMenu(R.menu.detail_menu)

                setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.item_edit -> {
                            // 게시글 수정
                            editTextDetailTitle.isEnabled = true
                            textInputEditTextDetailCotent.isEnabled = true
                            textInputLayoutDetailContent.hint = ""
                            buttonDetailComplete.visibility = View.VISIBLE
                            chipDetailTag1.isCheckable = true
                            chipDetailTag2.isCheckable = true
                            chipDetailTag3.isCheckable = true
                            chipDetailTag4.isCheckable = true



                        }

                        R.id.item_delete -> {
                            // 게시글 삭제 후 메인 화면 전환
                            val builder = MaterialAlertDialogBuilder(this@DetailActivity)
                            builder.setMessage("게시글을 삭제하시겠습니까?")
                            builder.setNegativeButton("취소", null)
                            builder.setPositiveButton("삭제") { dialogInterface: DialogInterface, i: Int ->
                                var mainIntent =
                                    Intent(this@DetailActivity, MainActivity::class.java)
                                startActivity(mainIntent)
                            }
                            builder.show()
                        }

                        else -> {}
                    }
                    true
                }
            }

            buttonDetailComplete.setOnClickListener {
                editTextDetailTitle.isEnabled = false
                textInputEditTextDetailCotent.isEnabled = false
                buttonDetailComplete.visibility = View.GONE
                chipGroupDetailTag.isClickable = false
                chipDetailTag1.isCheckable = false
                chipDetailTag2.isCheckable = false
                chipDetailTag3.isCheckable = false
                chipDetailTag4.isCheckable = false
            }
        }
    }
}