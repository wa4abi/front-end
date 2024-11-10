package com.example.ku_rum.Notice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ku_rum.front_end.databinding.ItemNoticeImportantBinding
import com.ku_rum.front_end.databinding.ItemNoticeNormalBinding
import com.ku_rum.front_end.ui.theme.Announcement.data.NoticeData

class NoticeRVAdapter(private val context: Context,
    private val noticeList:List<NoticeData>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        companion object{
            const val NORMAL = 0
            const val IMPORTANT = 1
        }

    inner class ViewHolderNormal(private val binding: ItemNoticeNormalBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoticeData){
            binding.tvNoticeTitle.text = item.title
            binding.tvNoticeDate.text = item.date
        }
    }

    inner class ViewHolderImportant(private val binding: ItemNoticeImportantBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoticeData){
            binding.tvNoticeTitle.text = item.title
            binding.tvNoticeDate.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            0 -> {
                val binding = ItemNoticeNormalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderNormal(binding)
            }
            else -> {
                val binding = ItemNoticeImportantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ViewHolderImportant(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = noticeList[position]
        when (holder) {
            is ViewHolderNormal -> holder.bind(item)
            is ViewHolderImportant -> holder.bind(item)
        }
    }

    override fun getItemCount() = noticeList.size

    override fun getItemViewType(position: Int): Int {
        val item = noticeList[position]
        return when (item.important) {
            0 -> NORMAL
            else -> IMPORTANT
        }
    }

}