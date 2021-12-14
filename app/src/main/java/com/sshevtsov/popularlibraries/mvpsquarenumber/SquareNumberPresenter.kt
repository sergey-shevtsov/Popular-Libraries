package com.sshevtsov.popularlibraries.mvpsquarenumber

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter

class SquareNumberPresenter : MvpPresenter<SquareNumberView>() {

    private val subject = BehaviorSubject.create<String>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        observeChanges()
    }

    fun onCountButtonClicked(number: String) {
        subject.onNext(number)
    }

    private fun observeChanges() {
        subject
            .map { it.toDouble() }
            .map { it * it }
            .map { removeTail(it) }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { viewState.setResult(it) }
    }

    private fun removeTail(number: Double): String =
        number.toString().replace(".0", "")

}