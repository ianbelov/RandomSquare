package com.a.randomsquare.color

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navGraphViewModels
import com.a.randomsquare.R
import com.a.randomsquare.databinding.FragmentColorBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ColorFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: ColorViewModel by navGraphViewModels(
        R.id.mobile_navigation
    ) { viewModelFactory }
    private var _binding: FragmentColorBinding? = null
    private val binding get() = _binding!!
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        binding.generateColorButton.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getColorObservable()
                .subscribe { onNext -> binding.customSquare.color = onNext }
            viewModel.getBackgroundColorObservable().subscribe(
                { next ->
                    binding.root.setBackgroundColor(next.code)
                    binding.customSquare.text = next.name
                    binding.progressBar.visibility = View.INVISIBLE
                },
                {
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(context, "Произошла ошибка", Toast.LENGTH_SHORT).show()
                },
                {
                    binding.progressBar.visibility = View.INVISIBLE
                })
        }
        return rootView
    }

    private fun init() {
        _binding = FragmentColorBinding.inflate(layoutInflater)
        rootView = binding.root
        binding.root.setBackgroundColor(viewModel.customSquareColor.code)
        binding.customSquare.color = viewModel.backgroundColorCode
        binding.customSquare.text = viewModel.customSquareColor.name
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}