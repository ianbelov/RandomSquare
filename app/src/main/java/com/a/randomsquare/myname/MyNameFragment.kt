package com.a.randomsquare.myname

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.a.randomsquare.R
import com.a.randomsquare.databinding.FragmentMyNameBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

@SuppressLint("CheckResult")
class MyNameFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MyNameViewModel by navGraphViewModels(
        R.id.mobile_navigation
    ) { viewModelFactory }
    private var _binding: FragmentMyNameBinding? = null
    private val binding get() = _binding!!
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        viewModel.observable.subscribe { binding.nameTextView.text = it }
        return rootView
    }

    private fun init() {
        _binding = FragmentMyNameBinding.inflate(layoutInflater)
        rootView = binding.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}