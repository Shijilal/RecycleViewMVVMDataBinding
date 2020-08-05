package com.lalsoft.recyclerviewmvvmdatabinding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lalsoft.recyclerviewmvvmdatabinding.R
import com.lalsoft.recyclerviewmvvmdatabinding.adapter.RecyclerAdapter
import com.lalsoft.recyclerviewmvvmdatabinding.databinding.RecyclerFragmentBinding
import com.lalsoft.recyclerviewmvvmdatabinding.model.User
import com.lalsoft.recyclerviewmvvmdatabinding.viewmodel.RecyclerViewModel

class RecyclerFragment : Fragment() {
    lateinit var dataBinding: RecyclerFragmentBinding
    lateinit var viewModel:RecyclerViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.recycler_fragment, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(RecyclerViewModel::class.java)
        viewModel.userList.observe(viewLifecycleOwner,userListObserver)
        viewModel.adapter.observe(viewLifecycleOwner,adapterObserver)



    }
    private val adapterObserver= Observer<RecyclerAdapter> {
        dataBinding.viewModel=viewModel
    }
    private val userListObserver=Observer<ArrayList<*>>{
        viewModel.setAdapter(it as ArrayList<User>)
    }
}