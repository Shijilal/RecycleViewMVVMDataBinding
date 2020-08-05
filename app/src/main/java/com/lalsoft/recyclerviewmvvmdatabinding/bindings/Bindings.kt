package com.lalsoft.recyclerviewmvvmdatabinding.bindings

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object Bindings {
    @BindingAdapter("isVisible") @JvmStatic
    fun setIsVisible(v: View, isVisible: Boolean) {
        v.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    @BindingAdapter("setAdapter") @JvmStatic
    fun bindRecyclerViewAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>?) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context,2,LinearLayoutManager.VERTICAL,false)
        //recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
    }


}