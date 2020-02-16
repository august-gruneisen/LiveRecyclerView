package com.augustg.databindingrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.augustg.databindingrecyclerview.databinding.ListItemBinding
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * An implementation of RecyclerView.Adapter incorporating data binding
 * Each View is bound to specific data for its position
 * As data in the list changes, the UI updates without having to notify the adapter
 *
 * @param viewModel The ViewModel that binding expressions use to bind data
 * @param clickListener Lets implementing classes define how each individual View should react to click events
 */
class LiveBoundRecyclerViewAdapter(
    private val viewModel: MainViewModel,
    private val clickListener: (View, Int) -> Unit
) : RecyclerView.Adapter<LiveBoundRecyclerViewAdapter.ViewHolder>() {

    // use your list item's binding class
    inner class ViewHolder(private var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Gives each View a reference to its position in the adapter
         *
         * @param position Used to bind specific data to each View
         * @param lifecycleOwner Makes each individual View the lifecycle owner of the data it observes
         */
        fun bind(position: Int, lifecycleOwner: LifecycleOwner) {
            binding.position = position
            binding.viewModel = viewModel
            binding.lifecycleOwner = lifecycleOwner
            binding.executePendingBindings()
        }
    }

    /**
     * Inflates a binding layout for each View
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType The view type of the new View
     *
     * @return A new ViewHolder that holds a View of the given view type
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    /**
     * Binds each ViewHolder to the data for its adapter position
     *
     * @param holder The ViewHolder which binds to data at the given position
     * @param position The position of the item within the data set
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, holder.itemView.context as LifecycleOwner)
        holder.itemView.button.setOnClickListener {
            clickListener.invoke(it, position)
        }
    }

    /**
     * Returns the total number of items that can be laid out
     *
     * @return The number of items currently available
     */
    override fun getItemCount(): Int {
        return viewModel.listItems.value!!.size
    }
}