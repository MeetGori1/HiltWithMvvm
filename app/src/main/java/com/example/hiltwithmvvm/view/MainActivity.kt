package com.example.hiltwithmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.hiltwithmvvm.databinding.ActivityMainBinding
import com.example.hiltwithmvvm.viewmodels.MainViewModel
import com.example.mvvmapp.adapter.ProductListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ProductListAdapter
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        callApiAndSetData()
    }

    private fun callApiAndSetData() {
        adapter = ProductListAdapter()
        binding.rwRecyclerView.adapter = adapter
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.productsLiveData.observe(this) { it ->
//            android.widget.Toast.makeText(this@MainActivity, it[0].title, Toast.LENGTH_SHORT).show()
            adapter.submitList(it)
        }
    }
}