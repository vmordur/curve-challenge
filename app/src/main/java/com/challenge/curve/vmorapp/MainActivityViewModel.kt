package com.challenge.curve.vmorapp

import rx.Observable
import rx.subjects.PublishSubject


/**
 * Created by sage_vmor on 28/3/18.
 */
class MainActivityViewModel {

    private val gridValues: ArrayList<Int> = arrayListOf(0, 0, 0, 0, 0, 0)

    private val resultTextSubject: PublishSubject<Int> = PublishSubject.create()

    fun getResult() : Observable<Int> {
        return resultTextSubject.asObservable()
    }

    fun getFields() : Observable<List<Int>> {
        val array: ArrayList<Int> = arrayListOf()
        array.addAll(gridValues)
        return Observable.just(array)
    }

    fun updateGridValue(position: Int, value: Int) {
        if(position in 0..5) {
            gridValues[position] = value
            updateResult(gridValues.sum())
        }
    }

    private fun updateResult(result: Int) {
        resultTextSubject.onNext(result)
    }

}