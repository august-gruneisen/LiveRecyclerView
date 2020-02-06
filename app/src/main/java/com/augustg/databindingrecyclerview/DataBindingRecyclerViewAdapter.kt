package com.augustg.databindingrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.augustg.databindingrecyclerview.databinding.ScanResultViewBinding

class DataBindingRecyclerViewAdapter(private val viewModel: ScanViewModel) : RecyclerView.Adapter<DataBindingRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: ScanResultViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, lifecycleOwner: LifecycleOwner) {
            binding.position = position
            binding.viewModel = viewModel
            binding.lifecycleOwner = lifecycleOwner
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = ScanResultViewBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(position, holder.itemView.context as LifecycleOwner)

        holder.itemView.setOnClickListener {
            viewModel.incrementScanResult(position)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.scanResults.value!!.size
    }

}