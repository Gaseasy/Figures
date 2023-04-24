package com.rakhimberdin.lab_1

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path

class Triangle(
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
        val line = lineLength
        val h = centerH + 8f

        val path = Path()
        path.moveTo(centerW.toFloat(), h)
        path.lineTo((centerW-line-8f), h)
        path.lineTo(centerW.toFloat(), h-line-16f)
        path.lineTo((centerW+line+8f), h)
        path.close()

        canvas.drawPath(path, paint)
    }

    override fun drawFigure(canvas: Canvas) {
        val centerW = canvas.width / 2
        val centerH = canvas.height / 2
        val paint = Paint()
        changePaintColor(innerColor, depth, paint)

        val path = Path()
        path.moveTo(centerW.toFloat(), centerH.toFloat())
        path.lineTo((centerW-lineLength).toFloat(), centerH.toFloat())
        path.lineTo(centerW.toFloat(), (centerH-lineLength).toFloat())
        path.lineTo((centerW+lineLength).toFloat(), centerH.toFloat())
        path.close()

        canvas.drawPath(path, paint)
    }
}