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
