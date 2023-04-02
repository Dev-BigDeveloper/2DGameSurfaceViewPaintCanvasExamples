package com.example.myapplication.objectWalk

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context, attrs: AttributeSet? = null,defaultAttrs:Int = 0) : View(context,attrs,defaultAttrs) {
    private val painter = Paint().apply {
        color = Color.YELLOW
        style = Paint.Style.FILL
        isAntiAlias = true
        strokeWidth = 30f
    }

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
            val centerX = (width / 2).toFloat()
            val centerY = (height / 2).toFloat()
            drawColor(Color.WHITE)
            drawCircle(centerX,centerY, SMILE_RADIUS,painter)
            painter.color = Color.BLACK
            drawCircle(centerX - 100,centerY - 100,EYE_RADIUS,painter)
            drawCircle(centerX + 100,centerY - 100,EYE_RADIUS,painter)
            drawLine(centerX - 130,centerY + 130,centerX + 130,centerY + 130,painter)

        }
    }

    companion object {
        private const val SMILE_RADIUS = 300f
        private const val EYE_RADIUS = 35f
    }

}