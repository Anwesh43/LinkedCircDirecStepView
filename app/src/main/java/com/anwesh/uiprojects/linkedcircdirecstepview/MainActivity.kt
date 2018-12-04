package com.anwesh.uiprojects.linkedcircdirecstepview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.circdirecstepview.CircDirecStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CircDirecStepView.create(this)
    }
}
