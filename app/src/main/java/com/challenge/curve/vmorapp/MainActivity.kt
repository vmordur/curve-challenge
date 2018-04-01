package com.challenge.curve.vmorapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.challenge.curve.vmorapp.utils.toValidInt
import com.challenge.curve.vmorapp.view.TextWatcherWrapper
import kotlinx.android.synthetic.main.activity_main.*
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * App main screen
 */
class MainActivity : AppCompatActivity() {

    lateinit private var subscription: CompositeSubscription

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as VmorApplication).vmorAppComponent().inject(this)

        setContentView(R.layout.activity_main)

        configureFields()
    }

    private fun configureFields() {
        editText1.addTextChangedListener(TextWatcherWrapper(editTextListener(0)))
        editText1.setOnFocusChangeListener { _, hasFocus ->  if (!hasFocus && editText1.text.isEmpty()) editText1.text.insert(0, "0")}
        editText2.addTextChangedListener(TextWatcherWrapper(editTextListener(1)))
        editText2.setOnFocusChangeListener { _, hasFocus ->  if (!hasFocus && editText2.text.isEmpty()) editText2.text.insert(0, "0")}
        editText3.addTextChangedListener(TextWatcherWrapper(editTextListener(2)))
        editText3.setOnFocusChangeListener { _, hasFocus ->  if (!hasFocus && editText3.text.isEmpty()) editText3.text.insert(0, "0")}
        editText4.addTextChangedListener(TextWatcherWrapper(editTextListener(3)))
        editText4.setOnFocusChangeListener { _, hasFocus ->  if (!hasFocus && editText4.text.isEmpty()) editText4.text.insert(0, "0")}
        editText5.addTextChangedListener(TextWatcherWrapper(editTextListener(4)))
        editText5.setOnFocusChangeListener { _, hasFocus ->  if (!hasFocus && editText5.text.isEmpty()) editText5.text.insert(0, "0")}
        editText6.addTextChangedListener(TextWatcherWrapper(editTextListener(5)))
        editText6.setOnFocusChangeListener { _, hasFocus ->  if (!hasFocus && editText6.text.isEmpty()) editText6.text.insert(0, "0")}
    }

    private fun editTextListener(position: Int) : TextWatcherWrapper.Listener = object: TextWatcherWrapper.Listener {
        override fun onTextChanged(s: CharSequence?) {
            mainActivityViewModel.updateGridValue(position, s.toValidInt())
        }
    }

    public override fun onResume() {
        super.onResume()
        subscription = CompositeSubscription()
        subscription.add(mainActivityViewModel.getResult().observeOn(AndroidSchedulers.mainThread()).subscribe({result -> updateResult(result)}))
        subscription.add(mainActivityViewModel.getFields().observeOn(AndroidSchedulers.mainThread()).subscribe({fields -> initFields(fields)}))

    }

    private fun initFields(fields: List<Int>?) {
        fields?.let {
            editText1.text.replace(0, 1, fields[0].toString())
            editText2.text.replace(0, 1, fields[1].toString())
            editText3.text.replace(0, 1, fields[2].toString())
            editText4.text.replace(0, 1, fields[3].toString())
            editText5.text.replace(0, 1, fields[4].toString())
            editText6.text.replace(0, 1, fields[5].toString())
        }
    }

    override fun onPause() {
        super.onPause()
        subscription.unsubscribe()
    }

    private fun updateResult(result: Int) {
        resultTextView.text = result.toString()
    }
}
