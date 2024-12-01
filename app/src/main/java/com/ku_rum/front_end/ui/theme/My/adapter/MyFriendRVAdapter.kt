package com.example.ku_rum.MyPage.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_rum.MyPage.data.FriendData
import com.ku_rum.front_end.databinding.ItemMyFriendBinding

class MyFriendRVAdapter(val context: Context,
    private var MyFriendList: List<FriendData>) : RecyclerView.Adapter<MyFriendRVAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemMyFriendBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item:FriendData){
            binding.tvMyFriendName.text = item.name
            binding.ivMyFriendRemove.setOnClickListener{
                // 확인 알림 띄우고 친구 삭제
                showConfirmDialog(context, item)
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

    fun showConfirmDialog(context: Context, item: FriendData) {
        val builder = AlertDialog.Builder(context)
        with(builder) {
            setTitle("확인")
            setMessage("삭제하시겠습니끼?")
            setPositiveButton("확인") { dialog, which ->
                val newList = MyFriendList.filterNot { it.id == item.id }
                update(newList)
            }
            setNegativeButton("취소") {dialog, which ->
                dialog.dismiss()
            }
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }
}