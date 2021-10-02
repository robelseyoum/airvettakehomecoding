package com.robelseyoum.airvettakehomecoding.ui.randomuseroverview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.robelseyoum.airvettakehomecoding.data.model.Results
import com.robelseyoum.airvettakehomecoding.databinding.ListRandomUserBinding

class RandomUserAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Results, RandomUserAdapter.RandomUserViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomUserViewHolder =
        RandomUserViewHolder(ListRandomUserBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: RandomUserViewHolder, position: Int) {
        val results = getItem(position)
        holder.itemView.setOnClickListener { onClickListener.onClick(results) }
        holder.bind(results)
    }

    class RandomUserViewHolder(private var binding: ListRandomUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Results) {
            binding.randomUseList = result
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener: (result: Results) -> Unit) {
        fun onClick(results: Results) = clickListener(results)
    }

}