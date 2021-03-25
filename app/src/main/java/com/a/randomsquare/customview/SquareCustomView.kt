package com.a.randomsquare.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.a.randomsquare.databinding.SquareCustomViewBinding


@SuppressLint("ResourceAsColor")
class SquareCustomView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private var root: View
    private var binding: SquareCustomViewBinding
    var text: String = "ExAmPlE"
        set(value) {
            Log.d("Set", value)
            field = value
            binding.customTextView.text = field
        }
    var color: Int = -12341
        set(value) {
            field = value
            binding.customView.setBackgroundColor(value)
        }

    init {
        binding = SquareCustomViewBinding.inflate(LayoutInflater.from(context), this, true)
        root = binding.root
        binding.customView.setBackgroundColor(Color.GRAY)
        binding.customTextView.text = "Example"
    }

}