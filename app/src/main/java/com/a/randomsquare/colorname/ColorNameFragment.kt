package com.a.randomsquare.colorname

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.a.randomsquare.R
import com.a.randomsquare.databinding.FragmentColorNameBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ColorNameFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ColorNameViewModel by navGraphViewModels(
        R.id.mobile_navigation
    ) { viewModelFactory }
    private var _binding: FragmentColorNameBinding? = null
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
            binding.secondTextView.text = viewModel.colorCodeLiveData.value!!
        })
        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                false -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }
        return rootView
    }

    private fun init() {
        _binding = FragmentColorNameBinding.inflate(layoutInflater)
        rootView = binding.root
        binding.themeSwitch.isChecked = AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES
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