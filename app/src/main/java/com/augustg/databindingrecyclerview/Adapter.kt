package com.augustg.databindingrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.augustg.databindingrecyclerview.databinding.ScanResultViewBinding

class Adapter(private val viewModel: ScanViewModel) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(var binding: ScanResultViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, viewModel: ScanViewModel) {
            binding.position = position
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = ScanResultViewBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.lifecycleOwner = holder.itemView.context as LifecycleOwner
        holder.bind(position, viewModel)

        holder.itemView.setOnClickListener {
            viewModel.incrementScanResult(position)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.scanResults.value!!.size
    }

}