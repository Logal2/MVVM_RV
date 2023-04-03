package com.example.homewordroman.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.example.homewordroman.adapter.HomeAdapter
import com.example.homewordroman.data.AlbumId
import androidx.fragment.app.viewModels
import androidx.activity.viewModels
import com.example.homewordroman.databinding.HomeLayoutBinding
import kotlinx.coroutines.launch


class FirsPage : Fragment() {

    private var _binding: HomeLayoutBinding? = null
    private val binding get() = _binding!!

    private lateinit var  adapter: HomeAdapter
    private val viewModel: FirsPageViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeLayoutBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            //Я не понимаю почему не ставиться адаптер, я к нему обращаюсь после ленивой инициализации
        //Но все равно выходит ошибка о том, что адаптер не установлен
        val album = listOf<AlbumId>()
        adapter = HomeAdapter(album)
        val layoutManager = LinearLayoutManager(context,VERTICAL, false)
        binding.rvHome.layoutManager = layoutManager
        binding.rvHome.adapter = adapter

        viewModel.viewModelScope.launch {
            viewModel.makeApiCall()
        }

    }



}