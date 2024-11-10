package com.example.ku_rum.MyPage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_rum.MyPage.data.FriendData
import com.ku_rum.front_end.databinding.ItemMoreFriendBinding

class MoreFriendRVAdapter(val context: Context,
    private var MoreFriendList:List<FriendData>): RecyclerView.Adapter<MoreFriendRVAdapter.ViewHolder>() {

        inner class ViewHolder(private var binding: ItemMoreFriendBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(item:FriendData){
                binding.tvMoreFriendName.text = item.name
                binding.ivMoreFriendAdd.setOnClickListener{
                    // 내친구 목록에 친구 추가
                    // 확인 알림 띄우기
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMoreFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return MoreFriendList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = MoreFriendList[position]
        holder.bind(item)
    }

    fun update(newList:List<FriendData>){
        MoreFriendList = newList
        notifyDataSetChanged()
    }
}