package com.a.randomsquare.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.a.randomsquare.ColorsGenerator
import com.a.randomsquare.MyApp
import com.a.randomsquare.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class MainFragment : Fragment() {

    @Inject lateinit var colorsGenerator: ColorsGenerator
    lateinit var generateButton: Button
    lateinit var square: View

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        init(view)
        generateButton.setOnClickListener {
            square.setBackgroundColor(colorsGenerator.getColor((1..5).random()))
        }
        return view
    }

    private fun init(view: View) {
        generateButton = view.findViewById(R.id.generateButton)
        square = view.findViewById(R.id.square)
        square.setBackgroundColor(colorsGenerator.getCurrentColor())
    }

}