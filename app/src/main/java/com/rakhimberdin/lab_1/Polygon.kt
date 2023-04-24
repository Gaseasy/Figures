package com.rakhimberdin.lab_1

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import kotlin.math.cos
import kotlin.math.sin

class Polygon (
    depth: Int,
    innerColor: ArrayList<Int>?,
    lineColor: ArrayList<Int>?,
    private val vertices: Int)
    : Figure(depth, innerColor, lineColor) {
    override fun drawLine(canvas: Canvas) {
        val x = canvas.width / 2
        val y = canvas.height / 2
        val paint = Paint()
        changePaintColor(lineColor, depth, paint)

        val section = 2.0 * Math.PI / vertices
        val radius = 250f
        val mPath = Path()
        mPath.moveTo(
            (x + radius * cos(0.0)).toFloat(), (y + radius
                    * sin(0.0)).toFloat()
        )
        for (i in 1 until vertices) {
            mPath.lineTo(
                (x + radius * cos(section * i)).toFloat(),
                (y + radius * sin(section * i)).toFloat()
            )
        }
        mPath.close()

        canvas.drawPath(mPath, paint)
    }

    override fun drawFigure(canvas: Canvas) {
        val x = canvas.width / 2
        val y = canvas.height / 2
        val paint = Paint()
        changePaintColor(innerColor, depth, paint)

        val section = 2.0 * Math.PI / vertices
        val radius = 230f
        val mPath = Path()
        mPath.moveTo(
            (x + radius * cos(0.0)).toFloat(), (y + radius
                    * sin(0.0)).toFloat()
        )
        for (i in 1 until vertices) {
            mPath.lineTo(
                (x + radius * cos(section * i)).toFloat(),
                (y + radius * sin(section * i)).toFloat()
            )
        }
        mPath.close()

        canvas.drawPath(mPath, paint)
    }
}