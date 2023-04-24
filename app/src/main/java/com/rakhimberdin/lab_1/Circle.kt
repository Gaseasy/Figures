package com.rakhimberdin.lab_1

import android.graphics.Canvas
import android.graphics.Paint

class Circle(
    depth: Int,
    innerColor: ArrayList<Int>?,
    lineColor: ArrayList<Int>?,
    private val centerX: Int,
    private val centerY: Int,
    private val radius: Int)
    : Figure(depth, innerColor, lineColor) {
        override fun drawLine(canvas: Canvas) {
            val centerW = canvas.width / 2 + centerX
            val centerH = canvas.height / 2 + centerY
            val paint = Paint()
            changePaintColor(lineColor, depth, paint)
            canvas.drawCircle(centerW.toFloat(), centerH.toFloat(), radius.toFloat() + 8f, paint)
        }

        override fun drawFigure(canvas: Canvas) {
            val centerW = canvas.width / 2 + centerX
            val centerH = canvas.height / 2 + centerY
            val paint = Paint()
            changePaintColor(innerColor, depth, paint)
            canvas.drawCircle(centerW.toFloat(), centerH.toFloat(), radius.toFloat(), paint)
        }
}