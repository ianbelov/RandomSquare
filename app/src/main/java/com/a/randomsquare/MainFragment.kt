package com.a.randomsquare

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.a.randomsquare.di.DaggerAppComponent
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class MainFragment : Fragment() {

    @Inject
    lateinit var colorsGenerator: ColorsGenerator
    lateinit var generateButton: Button
    lateinit var square: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        init(view)
        DaggerAppComponent.create().inject(this)
        generateButton.setOnClickListener {
            val color = colorsGenerator.getColor(requireContext(), (1..5).random())
            square.setBackgroundColor(color)
        }
        return view
    }

    private fun init(view: View){
        generateButton = view.findViewById(R.id.generateButton)
        square = view.findViewById(R.id.square)
    }


}