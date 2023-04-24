package com.rakhimberdin.lab_1

import android.graphics.Canvas
import android.graphics.Paint

class Square(
    depth: Int,
    innerColor: ArrayList<Int>?,
    lineColor: ArrayList<Int>?,
    private val lineLength: Int)
    : Figure(depth, innerColor, lineColor) {
    override fun drawLine(canvas: Canvas) {
        val centerW = canvas.width / 2
        val centerH = canvas.height / 2
        val paint = Paint()
        changePaintColor(lineColor, depth, paint)
        val line = lineLength + 16f

        canvas.drawRect(centerW-line/2, centerH-line/2,
            centerW+line/2, centerH+line/2, paint)
    }

    override fun drawFigure(canvas: Canvas) {
        val centerW = canvas.width / 2
        val centerH = canvas.height / 2
        val paint = Paint()
        changePaintColor(innerColor, depth, paint)

        canvas.drawRect((centerW-lineLength/2).toFloat(), (centerH-lineLength/2).toFloat(),
            (centerW+lineLength/2).toFloat(), (centerH+lineLength/2).toFloat(), paint)
    }
}