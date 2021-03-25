package com.a.randomsquare.second

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.a.randomsquare.R
import com.a.randomsquare.databinding.FragmentSecondBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SecondFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: SecondViewModel by navGraphViewModels(
        R.id.mobile_navigation
    ) { viewModelFactory }
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        binding.generateSecondButton.setOnClickListener {
            viewModel.generateRandomColor()
        }
        viewModel.colorCodeLiveData.observe(viewLifecycleOwner, {
            binding.secondSquare.setBackgroundColor(viewModel.colorCodeLiveData.value!!)
        })

        return rootView
    }

    private fun init() {
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        rootView = binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}