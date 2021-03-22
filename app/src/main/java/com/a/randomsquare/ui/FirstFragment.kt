package com.a.randomsquare.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.a.randomsquare.R
import com.a.randomsquare.viewmodel.FirstViewModel
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FirstFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: FirstViewModel
    lateinit var generateButton: Button
    lateinit var instanceButton: Button
    lateinit var callButton: Button
    lateinit var square: View
    lateinit var textView: TextView

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
            viewModel.getColorObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { onNext -> square.setBackgroundColor(onNext) }
            viewModel.getBackgroundColorObservable()
                .subscribe { onNext ->
                    view.setBackgroundColor(onNext.code)
                    textView.text = onNext.name
                 }
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
        textView = view.findViewById(R.id.firstTextView)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FirstViewModel::class.java)
    }

}