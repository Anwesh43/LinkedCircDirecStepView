package com.anwesh.uiprojects.circdirecstepview

/**
 * Created by anweshmishra on 04/12/18.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.RectF
import android.graphics.Color
import android.content.Context

val nodes : Int = 5
val sizeFactor : Float = 2.4f
val strokeFactor : Int = 60
val scDiv : Double = 0.51
val scGap : Float = 0.05f

fun Int.getInverse() : Float = 1f / this

fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.getInverse(), Math.max(0f, this - i * n.getInverse())) * n

fun Float.scaleFactor() : Float = Math.floor(this / scDiv).toFloat()

fun Float.updateScale(dir : Float) = dir * scGap

fun Canvas.drawCDSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = w / (nodes + 1)
    val size : Float = gap / sizeFactor
    val sf : Float = 1f - 2 * (i % 2)
    val sc1 : Float = scale.divideScale(0, 2)
    val sc2 : Float = scale.divideScale(1, 2)
    save()
    translate(gap * (i + 1) + (w/2) * sc2 * sf, h/2)
    rotate(90f * sc1 * sf)
    drawArc(RectF(-size, -size, size, size), 60f, 300f, true, paint)
    val x : Float = 1.5f * size * Math.cos(Math.PI/3).toFloat()
    val y : Float = 1.5f * size * Math.sin(Math.PI/3).toFloat()
    drawLine(0f, 0f, x, y, paint)
    drawLine(0f, 0f, -x, y, paint)
    restore()
}