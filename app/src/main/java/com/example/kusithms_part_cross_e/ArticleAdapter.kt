package com.example.kusithms_part_cross_e

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kusithms_part_cross_e.databinding.ItemBoardBinding

class ArticleAdapter(

): RecyclerView.Adapter<ArticleAdapter.CustomViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener
    private var articleList = listOf<String>()

    inner class CustomViewHolder(private val binding: ItemBoardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
//            binding.tvTitle.text =
//            binding.tvDescription.text =
//            binding.tvTime.text =
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

    fun setData(newList: List<String>) {
        articleList = newList
        notifyDataSetChanged()
    }
    override fun getItemCount() = articleList.size
}