package com.augustg.databindingrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.augustg.databindingrecyclerview.databinding.ListItemBinding

class LiveBoundRecyclerViewAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<LiveBoundRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, lifecycleOwner: LifecycleOwner) {
            binding.position = position
            binding.viewModel = viewModel
            binding.lifecycleOwner = lifecycleOwner
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(position, holder.itemView.context as LifecycleOwner)

        holder.itemView.setOnClickListener {
            viewModel.incrementItem(position)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.listItems.value!!.size
    }
}