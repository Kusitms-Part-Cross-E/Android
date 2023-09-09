package com.example.kusithms_part_cross_e

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kusithms_part_cross_e.databinding.ItemBoardBinding
import com.example.kusithms_part_cross_e.databinding.ItemTagBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ArticleAdapter(
    context: Context
): RecyclerView.Adapter<ArticleAdapter.CustomViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private var articleList = listOf<ArticleResult>()

    inner class CustomViewHolder(private val binding: ItemBoardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArticleResult) {
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.description

            val time = item.createdAt.replace("-", ".").replace("T"," ").substring(0,16)
            binding.tvTime.text = time

            binding.rvTag.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = TagAdapter(item.tagList)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = ItemBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleAdapter.CustomViewHolder, position: Int) {
        holder.bind(articleList[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    fun setData(newList: List<ArticleResult>) {
        articleList = newList
        notifyDataSetChanged()
    }
    override fun getItemCount() = articleList.size

    inner class TagAdapter(val tagList: List<String>) : RecyclerView.Adapter<TagAdapter.CustomViewHolder>() {
        inner class CustomViewHolder(private val binding: ItemTagBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(item: String) {
                binding.tvTag.text = "#$item"
            }
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            holder.bind(tagList[position])
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val view = ItemTagBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return CustomViewHolder(view)
        }

        override fun getItemCount()= tagList.size
    }
}