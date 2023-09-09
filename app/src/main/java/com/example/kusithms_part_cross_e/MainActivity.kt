package com.example.kusithms_part_cross_e

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kusithms_part_cross_e.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
//    private viewModel by

    private lateinit var articleAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        articleAdapter = ArticleAdapter()

        binding.rvArticle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = articleAdapter
            setHasFixedSize(true)
        }


    }
}