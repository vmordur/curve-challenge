package com.challenge.curve.vmorapp.view

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Flashing TextView based on handler.
 */
class HandlerFlashingTextView : FlashingTextView {

    private var flashing: Boolean = false

    private val flashingHandler: Handler = Handler()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun toggleFlashing() {
        if (!flashing) {
            flashing = true
            flashingHandler.postDelayed(flashingRunnable(), 500L)
        } else {
            flashing = false
            visibility = View.VISIBLE
        }
    }

    private fun flashingRunnable() : Runnable = object: Runnable {
        override fun run() {
            if (flashing) {
                toggleVisibility()
                flashingHandler.postDelayed(flashingRunnable(), 500L)
            }
        }
    }

}