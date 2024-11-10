package com.example.ku_rum.MyPage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_rum.Dialog.DialogConfirmFragment
import com.example.ku_rum.MyPage.data.FriendData
import com.ku_rum.front_end.databinding.ItemMyFriendBinding

class MyFriendRVAdapter(val context: Context,
    private var MyFriendList: List<FriendData>) : RecyclerView.Adapter<MyFriendRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemMyFriendBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item:FriendData){
            binding.tvMyFriendName.text = item.name
            binding.ivMyFriendRemove.setOnClickListener{
                // 확인 알림 띄우기
                // 친구 삭제
                // 검색 결과가 없을 때
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMyFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return MyFriendList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = MyFriendList[position]
        holder.bind(item)
    }

    fun update(newList:List<FriendData>){
        MyFriendList = newList
        notifyDataSetChanged()
    }
}