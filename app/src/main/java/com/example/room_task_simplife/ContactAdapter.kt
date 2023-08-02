package com.example.test_

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room_task_simplife.databinding.RecyicleListBinding
class ContactAdapter(var list: List<RecycleDataClass>, var onClick: OnClick) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding =
            RecyicleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var listPosition = list[position]
        holder.binding.nameListText.text = listPosition.name
        holder.binding.phoneListText.text = listPosition.phone
    }

    class ContactViewHolder(var binding: RecyicleListBinding, onClick: OnClick) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                onClick.viewClick()
            }
        }
    }

    interface OnClick {

        fun viewClick()
    }


}