package com.example.ku_rum.MyPage.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ku_rum.MyPage.data.InformData
import com.ku_rum.front_end.databinding.ItemMyPageInformBinding
import com.ku_rum.front_end.databinding.ItemMyPageInformHighlightBinding

class MyInformRVAdapter(val context: Context,
    private var InformList:List<InformData>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        companion object{
            const val TYPE_ONE = 1
            const val TYPE_TWO = 2
        }

        inner class ViewHolderTypeOne(var binding: ItemMyPageInformHighlightBinding):RecyclerView.ViewHolder(binding.root){
            fun bind(item:InformData){
                val informMainText = "${item.name}님이 친구 요청을 보냈어요."
                val informTime = "${item.time} 전"
                binding.tvMyPageInformMain.text = informMainText
                binding.tvMyPageInformTime.text = informTime

                binding.btnMyInformYes.setOnClickListener{
                    // 친구 목록에 추가
                }
                binding.btnMyInformNo.setOnClickListener{
                    // 알림 삭제
                }
            }
        }

    inner class ViewHolderTypeTwo(var binding: ItemMyPageInformBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:InformData){
            val informMainText = "${item.name}님이 친구 요청을 보냈어요."
            val informTime = "${item.time} 전"
            binding.tvMyPageInformMain.text = informMainText
            binding.tvMyPageInformTime.text = informTime

            binding.btnMyInformYes.setOnClickListener{
                // 친구 목록에 추가
            }
            binding.btnMyInformNo.setOnClickListener{
                // 알림 삭제
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position % 2 == 0) TYPE_ONE else TYPE_TWO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            TYPE_ONE -> {
                val binding = ItemMyPageInformHighlightBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolderTypeOne(binding)
            }
            else -> {
                val binding = ItemMyPageInformBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolderTypeTwo(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return InformList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = InformList[position]
        when (holder) {
            is ViewHolderTypeOne -> holder.bind(item)
            is ViewHolderTypeTwo -> holder.bind(item)
        }
    }
}