package com.challenge.curve.vmorapp.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

/**
 * Flashing TextView abstract entity.
 */
abstract class FlashingTextView : TextView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {
        isClickable = true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let { if (it.action == MotionEvent.ACTION_UP) toggleFlashing() }
        return super.onTouchEvent(event)
    }

    abstract fun toggleFlashing()

    fun toggleVisibility() {
        visibility = if (this.visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
    }

}