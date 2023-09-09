package com.example.kusithms_part_cross_e

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kusithms_part_cross_e.RetrofitInstance.service
import com.example.kusithms_part_cross_e.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MainViewModel>()

    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        articleAdapter = ArticleAdapter()

        articleAdapter.setData(List(3) {"1"})

        binding.rvArticle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = articleAdapter
            setHasFixedSize(true)
        }


        binding.fabMain.setOnClickListener {
            startActivity(Intent(this, WriteActivity::class.java))
        }
    }
}