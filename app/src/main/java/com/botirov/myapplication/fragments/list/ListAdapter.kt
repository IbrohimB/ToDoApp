package com.botirov.myapplication.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.botirov.myapplication.R
import com.botirov.myapplication.data.models.Priority
import com.botirov.myapplication.data.models.ToDoData
import com.botirov.myapplication.databinding.RowLayoutBinding


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = RowLayoutBinding.bind(itemView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowLayoutBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.titleTxt.text = dataList[position].title
        holder.binding.descriptionTxt.text = dataList[position].description


        when(dataList[position].priority){
            Priority.HIGH -> holder.binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(
                holder.itemView.context,
                R.color.red))

            Priority.MEDIUM -> holder.binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(
                holder.itemView.context,
                R.color.yellow))

            Priority.LOW -> holder.binding.priorityIndicator.setCardBackgroundColor(ContextCompat.getColor(
                holder.itemView.context,
                R.color.green))
        }
    }

    fun setData(toDoData: List<ToDoData>){
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}