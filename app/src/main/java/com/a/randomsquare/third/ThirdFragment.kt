package com.a.randomsquare.third

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.databinding.FragmentThirdBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

@SuppressLint("CheckResult")
class ThirdFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: ThirdViewModel
    private var _binding: FragmentThirdBinding? = null
    private val binding get()= _binding!!
    private lateinit var rootView: View

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        viewModel.observable.subscribe {binding.nameTextView.text = it }
        return rootView
    }

    private fun init() {
        _binding = FragmentThirdBinding.inflate(layoutInflater)
        rootView = binding.root
        viewModel = ViewModelProvider(this, viewModelFactory).get(ThirdViewModel::class.java)
    }

}