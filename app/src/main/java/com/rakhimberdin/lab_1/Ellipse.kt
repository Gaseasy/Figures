package com.rakhimberdin.lab_1

import android.graphics.Canvas
import android.graphics.Paint

class Ellipse(
    depth: Int,
    innerColor: ArrayList<Int>?,
    lineColor: ArrayList<Int>?,
    private val lineLengthA: Int,
    private val lineLengthB: Int)
    : Figure(depth, innerColor, lineColor) {
    override fun drawLine(canvas: Canvas) {
        val centerW = canvas.width / 2
        val centerH = canvas.height / 2
        val paint = Paint()
        changePaintColor(lineColor, depth, paint)

        val lineA = lineLengthA + 16f
        val lineB = lineLengthB + 16f

        canvas.drawOval(centerW-lineB/2, centerH-lineA/2,
                        centerW+lineB/2, centerH+lineA/2, paint)
    }

    override fun drawFigure(canvas: Canvas) {
        val centerW = canvas.width / 2
        val centerH = canvas.height / 2
        val paint = Paint()
        changePaintColor(innerColor, depth, paint)

        canvas.drawOval((centerW-lineLengthB/2).toFloat(), (centerH-lineLengthA/2).toFloat(),
            (centerW+lineLengthB/2).toFloat(), (centerH+lineLengthA/2).toFloat(), paint)
    }
}