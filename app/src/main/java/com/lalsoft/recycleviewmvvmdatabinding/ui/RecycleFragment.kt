package com.lalsoft.recycleviewmvvmdatabinding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.lalsoft.recycleviewmvvmdatabinding.R
import com.lalsoft.recycleviewmvvmdatabinding.adapter.RecycleAdapter
import com.lalsoft.recycleviewmvvmdatabinding.databinding.RecycleFragmentBinding
import com.lalsoft.recycleviewmvvmdatabinding.model.User
import com.lalsoft.recycleviewmvvmdatabinding.viewmodel.RecycleViewModel

class RecycleFragment : Fragment() {
    lateinit var dataBinding: RecycleFragmentBinding
    lateinit var viewModel:RecycleViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.recycle_fragment, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(RecycleViewModel::class.java)
        viewModel.userList.observe(viewLifecycleOwner,userListObserver)
        viewModel.adapter.observe(viewLifecycleOwner,adapterObserver)



    }
    private val adapterObserver= Observer<RecycleAdapter> {
        dataBinding.viewModel=viewModel
    }
    private val userListObserver=Observer<ArrayList<*>>{
        viewModel.setAdapter(it as ArrayList<User>)
    }
}