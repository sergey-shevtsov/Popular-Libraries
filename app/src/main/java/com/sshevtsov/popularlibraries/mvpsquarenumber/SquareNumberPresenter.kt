package com.sshevtsov.popularlibraries.mvpsquarenumber

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter

class SquareNumberPresenter : MvpPresenter<SquareNumberView>() {

    private val compositeDisposable = CompositeDisposable()

    private val subject = BehaviorSubject.create<String>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        observeChanges()
    }

    fun onCountButtonClicked(number: String) {
        if (!isValid(number)) {
            viewState.showEmptyFieldError()
            viewState.requestFocusOnField()
            viewState.showKeyboard()
            return
        }

        subject.onNext(number)
    }

    private fun observeChanges() {
        val disposable = subject
            .map { it.toDouble() }
            .map { it * it }
            .map { removeTail(it) }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { viewState.setResult(it) }

        compositeDisposable.add(disposable)
    }

    private fun removeTail(number: Double): String =
        number.toString().replace(".0", "")

    private fun isValid(number: String): Boolean = number.isNotEmpty()

    fun onFieldTextChanged() {
        viewState.cleanFieldError()
    }

    fun onEmptyAreaClicked() {
        viewState.hideKeyboard()
        viewState.clearFocus()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

}