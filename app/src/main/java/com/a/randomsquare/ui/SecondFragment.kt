package com.a.randomsquare.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.R
import com.a.randomsquare.viewmodel.SecondViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SecondFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: SecondViewModel
    lateinit var generateButton: Button
    lateinit var instanceButton: Button
    lateinit var callButton: Button
    lateinit var square: View

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        init(view)
        generateButton.setOnClickListener {
            viewModel.generateNewColor(((1..5).random()))
        }
        instanceButton.setOnClickListener {
            Toast.makeText(context, viewModel.instanceCount().toString(), Toast.LENGTH_SHORT).show()
        }
        callButton.setOnClickListener {
            viewModel.callObject()
            Toast.makeText(context, "Provider called", Toast.LENGTH_SHORT).show()
        }
        viewModel.colorCode.observe(viewLifecycleOwner, Observer {
            square.setBackgroundColor(viewModel.colorCode.value!!)
        })

        return view
    }


    private fun init(view: View) {
        generateButton = view.findViewById(R.id.generateSecondButton)
        instanceButton = view.findViewById(R.id.instanceCounterSecondButton)
        callButton = view.findViewById(R.id.callSecondObjectButton)
        square = view.findViewById(R.id.secondSquare)
        viewModel = ViewModelProvider(this, viewModelFactory).get(SecondViewModel::class.java)
    }
}