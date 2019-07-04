package com.upsa.mimo.placesfinder.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.SeekBar

class MySeekBar : SeekBar {

    val paint = Paint()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val thumbX  = (this.progress.toDouble() / this.max * this.width.toDouble()).toFloat()
        val middle = this.height.toFloat()
        paint.color = Color.WHITE
        c.drawText("" + this.progress, thumbX, middle, paint)
    }
}
