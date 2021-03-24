package com.a.randomsquare.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.a.randomsquare.R


@SuppressLint("ResourceAsColor")
class SquareCustomView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    var square: View
    var textView: TextView

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.square_custom_view, this)
        val a = context.obtainStyledAttributes(attrs, R.styleable.SquareCustomView)
        val titleText = a.getString(R.styleable.SquareCustomView_customText)
        val valueColor = a.getColor( R.styleable.SquareCustomView_customBackground, R.color.purple_200)
        a.recycle()

        square = view.findViewById(R.id.customView)
        square.setBackgroundColor(valueColor)
        textView = view.findViewById(R.id.customTextView)
        textView.text = titleText
    }

}