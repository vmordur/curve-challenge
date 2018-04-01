package com.challenge.curve.vmorapp.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.TimeInterval
import rx.subscriptions.CompositeSubscription
import java.util.concurrent.TimeUnit

/**
 * Flashing TextView based on Rx Observable.
 */
class RxFlashingTextView : FlashingTextView {

    private var flashing: Boolean = false
    private val subscription: CompositeSubscription = CompositeSubscription()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun toggleFlashing() {
        if (!flashing) {
            flashing = true
            subscription.add(getFlashingObservable().observeOn(AndroidSchedulers.mainThread()).subscribe{ _-> toggleVisibility()})
        } else {
            flashing = false
            subscription.clear()
            visibility = View.VISIBLE
        }
    }

    private fun getFlashingObservable() : Observable<TimeInterval<Long>> {
        return Observable.interval(500L, TimeUnit.MILLISECONDS).timeInterval()
    }

}