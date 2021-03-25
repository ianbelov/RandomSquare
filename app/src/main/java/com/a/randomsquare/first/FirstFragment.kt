package com.a.randomsquare.first

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.databinding.FragmentFirstBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FirstFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: FirstViewModel
    private lateinit var binding: FragmentFirstBinding
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
        binding = FragmentFirstBinding.inflate(layoutInflater)
        rootView = binding.root
        viewModel = ViewModelProvider(this, viewModelFactory).get(FirstViewModel::class.java)
    }

}