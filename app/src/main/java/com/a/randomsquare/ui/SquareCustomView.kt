package com.a.randomsquare.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.a.randomsquare.R


@SuppressLint("ResourceAsColor")
class SquareCustomView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private var square: View
    private var textView: TextView
    var text: String = "ExAmPlE"
        set(value){
            field = value
            textView.text = field
        }
    var color: Int = -12341
        set(value) {
            field = value
            square.setBackgroundColor(value)
        }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.square_custom_view, this)

        square = view.findViewById(R.id.customView)
        square.setBackgroundColor(Color.GRAY)
        textView = view.findViewById(R.id.customTextView)
        textView.text = "Example"
    }

}