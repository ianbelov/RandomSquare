package com.a.randomsquare.customview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.a.randomsquare.databinding.SquareCustomViewBinding


@SuppressLint("ResourceAsColor")
class SquareCustomView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private var root: View
    private var _binding: SquareCustomViewBinding? = null
    private val binding get()= _binding!!
    var text: String = ""
        set(value) {
            field = value
            binding.customTextView.text = field
        }
    var color: Int = -12341
        set(value) {
            field = value
            binding.customView.setBackgroundColor(value)
        }

    init {
        _binding = SquareCustomViewBinding.inflate(LayoutInflater.from(context), this, true)
        root = binding.root
    }

}