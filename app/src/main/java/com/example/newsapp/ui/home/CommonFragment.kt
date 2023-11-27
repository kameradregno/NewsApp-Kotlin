package com.example.newsapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.data.repository.NewsRepository
import com.example.newsapp.databinding.FragmentCommonBinding
import com.example.newsapp.ui.NewsViewModel
import com.example.newsapp.utils.NewsViewModelFactory


class CommonFragment : Fragment() {

    lateinit var binding: FragmentCommonBinding
    private val commonViewModel: NewsViewModel by viewModels{
        NewsViewModelFactory(NewsRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()

        if (commonViewModel.commonMuslimNews.value == null){
            commonViewModel.getCommonMuslimNews()
        }

        commonViewModel.commonMuslimNews.observe(viewLifecycleOwner) {dataNews ->
            mAdapter.setData(dataNews.articles)
            binding.rvCommonNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        commonViewModel.isLoading.observe(viewLifecycleOwner){
            showLoading(it)
        }


    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.loadingView.root.visibility = View.VISIBLE
        } else {
            binding.loadingView.root.visibility = View.GONE
        }
    }

}