package com.challenge.curve.vmorapp

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Tests for app main screen
 */
class MainActivityTest {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var subscription: CompositeSubscription
    private lateinit var view: MockView

    @Test
    fun testInitEmpty() {
        initMVVM()
        assertEquals(view.gridValues, arrayListOf(0, 0, 0, 0, 0, 0))
        assertTrue(view.result == 0)
    }

    @Test
    fun testResult() {
        initMVVM()
        mainActivityViewModel.updateGridValue(0, 5)
        assertTrue(view.result == 5)

        mainActivityViewModel.updateGridValue(0, 3)
        assertTrue(view.result == 3)

        mainActivityViewModel.updateGridValue(3, 7)
        mainActivityViewModel.updateGridValue(4, 2)
        assertTrue(view.result == 12)

        mainActivityViewModel.updateGridValue(3, 0)
        assertTrue(view.result == 5)

        mainActivityViewModel.updateGridValue(0, 5)
        mainActivityViewModel.updateGridValue(1, 5)
        mainActivityViewModel.updateGridValue(2, 5)
        mainActivityViewModel.updateGridValue(3, 5)
        mainActivityViewModel.updateGridValue(4, 5)
        mainActivityViewModel.updateGridValue(5, 5)
        assertTrue(view.result == 30)
    }

    private fun initMVVM() {
        view = MockView()
        mainActivityViewModel = MainActivityViewModel()
        subscription = CompositeSubscription()

        subscription.add(mainActivityViewModel.getResult().observeOn(Schedulers.immediate()).subscribe({ result -> view.updateResult(result)}))
        subscription.add(mainActivityViewModel.getFields().observeOn(Schedulers.immediate()).subscribe({ fields -> view.initFields(fields)}))
    }
}

class MockView {

    val gridValues: ArrayList<Int> = arrayListOf(0, 0, 0, 0, 0, 0)
    var result: Int = 0

    fun initFields(fields: List<Int>?) {
        fields?.let {
            for (position in 0..5) {
                gridValues[position] = fields[position]
            }
        }
    }

    fun updateResult(result: Int) {
        this.result = result
    }
}