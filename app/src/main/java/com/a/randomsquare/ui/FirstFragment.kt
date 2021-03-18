package com.a.randomsquare.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.R
import com.a.randomsquare.util.heavyobjects.HeavyObject
import com.a.randomsquare.viewmodel.FirstViewModel
import dagger.Lazy
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class FirstFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: FirstViewModel
    lateinit var generateButton: Button
    lateinit var instanceButton: Button
    lateinit var callButton: Button
    lateinit var square: View

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        init(view)
        generateButton.setOnClickListener {
            viewModel.generateNewColor(((1..5).random()))
        }
        instanceButton.setOnClickListener {
            Toast.makeText(context, viewModel.instanceCount().toString(), Toast.LENGTH_SHORT).show()
        }
        callButton.setOnClickListener {
            viewModel.callObject()
            Toast.makeText(context, "Lazy called", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    private fun init(view: View) {
        generateButton = view.findViewById(R.id.generateFirstButton)
        instanceButton = view.findViewById(R.id.instanceCounterFirstButton)
        callButton = view.findViewById(R.id.callFirstObjectButton)
        square = view.findViewById(R.id.firstSquare)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FirstViewModel::class.java)
        viewModel.colorCode.observe(viewLifecycleOwner, Observer {
            square.setBackgroundColor(viewModel.colorCode.value!!)
        })
    }

}