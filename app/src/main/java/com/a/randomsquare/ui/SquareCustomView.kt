package com.a.randomsquare.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.a.randomsquare.R


@SuppressLint("ResourceAsColor")
class SquareCustomView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private var squareView: View
    private var textView: TextView

    init {
        var view = LayoutInflater.from(context).inflate(R.layout.square_custom_view, this)
        val a = context.obtainStyledAttributes(attrs, R.styleable.SquareCustomView)
        val titleText = a.getString(R.styleable.SquareCustomView_customText)
        val valueColor = a.getColor( R.styleable.SquareCustomView_customBackground, R.color.purple_200)
        a.recycle()

        squareView = view.findViewById(R.id.customView)
        squareView.setBackgroundColor(valueColor)
        textView = view.findViewById(R.id.customTextView)
        textView.text = titleText
    }

    fun setCustomText(text:String){
        textView.text = text
    }

    fun setCustomBackground(color: Int){
        squareView.setBackgroundColor(color)
    }

}