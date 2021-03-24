package com.a.randomsquare.ui

import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.R
import com.a.randomsquare.viewmodel.FirstViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class FirstFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: FirstViewModel
    lateinit var generateButton: Button
    lateinit var instanceButton: Button
    lateinit var callButton: Button
    lateinit var progressBar: ProgressBar
    lateinit var customView: SquareCustomView

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
            progressBar.visibility = View.VISIBLE
            viewModel.getColorObservable()
                .subscribe { onNext -> customView.setCustomBackground(onNext) }
            viewModel.getBackgroundColorObservable().subscribe(
                { next ->
                    Log.d("Fragment", next.code.toString())
                    view.setBackgroundColor(next.code)
                    customView.setCustomText(next.name)
                    progressBar.visibility = View.INVISIBLE
                },
                {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(context, "Произошла ошибка", Toast.LENGTH_SHORT).show()
                    Log.d("Fragment", " error")
                },
                {
                    progressBar.visibility = View.INVISIBLE
                    Log.d("Fragment", " completed")
                })
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
        customView = view.findViewById(R.id.firstSquare)
        progressBar = view.findViewById(R.id.progressBar)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FirstViewModel::class.java)
    }

}