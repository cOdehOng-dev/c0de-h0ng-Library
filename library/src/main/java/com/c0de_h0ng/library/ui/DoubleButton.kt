package com.c0de_h0ng.library.ui

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.c0de_h0ng.library.R

/**
 * Created by c0de_h0ng on 2022/02/07.
 */
class DoubleButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {

    private var listener: OnClickListener? = null
    private val leftButtonTextView: TextView
    private val rightButtonTextView: TextView

    init {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.chlib_double_button, this, false)
        addView(view)
        leftButtonTextView = findViewById(R.id.left_button)
        rightButtonTextView = findViewById(R.id.right_button)
        leftButtonTextView.setOnClickListener(this)
        rightButtonTextView.setOnClickListener(this)
        getAttrs(attrs, defStyleAttr)
    }

    //만들어 놓은 attrs을 참조합니다.
    private fun getAttrs(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.DoubleButton, defStyleAttr, 0)
        setTypeArray(typedArray)
    }

    //여기서 값을 세팅해줍니다.
    private fun setTypeArray(typedArray: TypedArray) {
        val leftButtonContent = typedArray.getString(R.styleable.DoubleButton_leftButtonText)
        val rightButtonContent = typedArray.getString(R.styleable.DoubleButton_rightButtonText)

        leftButtonTextView.text = leftButtonContent
        rightButtonTextView.text = rightButtonContent
        typedArray.recycle()
    }

    override fun onClick(v: View) {
        listener?.onClick(v)
    }

    fun setLeftButtonText(buttonText: String?) {
        leftButtonTextView.text = buttonText ?: ""
    }

    fun setLeftButtonText(buttonText: Int) {
        leftButtonTextView.text = context.getString(buttonText)
    }

    fun setRightButtonText(buttonText: String?) {
        rightButtonTextView.text = buttonText ?: ""
    }

    fun setRightButtonText(buttonText: Int) {
        rightButtonTextView.text = context.getString(buttonText)
    }

    //버튼 클릭 리스너
    fun setButtonClickListener(listener: OnClickListener) {
        this.listener = listener
    }

}