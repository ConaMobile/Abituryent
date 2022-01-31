package com.abituriyentuz.abituriyent.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abituriyentuz.abituriyent.Models.GroupModel
import com.abituriyentuz.abituriyent.databinding.ItemRvGroupBinding

class GroupAdapter (val list: List<GroupModel>):RecyclerView.Adapter<GroupAdapter.Vh>(){

    inner class Vh(var itemRv:ItemRvGroupBinding):RecyclerView.ViewHolder(itemRv.root){
        fun onBind(groupModel: GroupModel){
            itemRv.txtGroupName.text = groupModel.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}