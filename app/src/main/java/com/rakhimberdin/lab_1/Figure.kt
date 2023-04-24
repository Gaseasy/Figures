package com.rakhimberdin.lab_1

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

open class Figure(
    protected val depth: Int,
    protected val innerColor: ArrayList<Int>?,
    protected val lineColor: ArrayList<Int>?)
    {

    protected open fun drawLine(canvas: Canvas) {}
    protected open fun drawFigure(canvas: Canvas) {}

    fun draw(canvas: Canvas) {
        drawLine(canvas)
        drawFigure(canvas)
    }

    protected fun changePaintColor(color: ArrayList<Int>?, depth: Int, paint: Paint) {
        val r = color!![0]
        val g = color[1]
        val b = color[2]
        paint.color = Color.argb(depth, r,g,b)
    }

}