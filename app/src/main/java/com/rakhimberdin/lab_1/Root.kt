package com.rakhimberdin.lab_1

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

open class Root {
    var name: String? = null
    var centerX = 0
    var centerY = 0
    var radius = 0
    var depth = 0
    var innerColor: ArrayList<Int>? = null
    var lineColor: ArrayList<Int>? = null
    var lineLength = 0
    var vertices = 0
    var lineLengthA = 0
    var lineLengthB = 0

    fun draw(canvas: Canvas) {
        when(name) {
            "Circle" -> Circle(depth, innerColor, lineColor, centerX, centerY, radius).draw(canvas)
            "Triangle" -> Polygon(depth, innerColor, lineColor, 3).draw(canvas)
                          //Triangle(depth, innerColor, lineColor, lineLength).draw(canvas)
            "Square" -> Polygon(depth, innerColor, lineColor, 4).draw(canvas)
                        //Square(depth, innerColor, lineColor, lineLength).draw(canvas)
            "Polygon" -> Polygon(depth, innerColor, lineColor, vertices).draw(canvas)
            "Ellipse" -> Ellipse(depth, innerColor, lineColor, lineLengthA, lineLengthB).draw(canvas)
        }
    }
}