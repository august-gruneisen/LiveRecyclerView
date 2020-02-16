package com.augustg.databindingrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = LiveBoundRecyclerViewAdapter(viewModel)

        recycler_view.apply {
            this.hasFixedSize()
            this.adapter = adapter
            layoutManager = LinearLayoutManager(applicationContext)
        }

        clear_button.setOnClickListener {
            viewModel.clearList()
            adapter.notifyDataSetChanged()
        }

        add_item_button.setOnClickListener {
            viewModel.addItem()
            adapter.notifyDataSetChanged()
        }

    }
}
