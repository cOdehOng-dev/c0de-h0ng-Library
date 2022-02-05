package com.c0de_h0ng.library

import android.content.DialogInterface
import android.text.Spanned
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.databinding.DataBindingUtil
import com.c0de_h0ng.library.databinding.ChlibAlertBinding

/**
 * Created by c0de_h0ng on 2022/02/06.
 */
class ChlibAlert constructor(builder: Builder) : View.OnClickListener {

    private var activity: AppCompatActivity? = null

    private var title: String? = null //제목
    private var content: String? = null //내용

    private var positiveString: String? = null
    private var negativeString: String? = null

    private var isPositiveButton = true
    private var isNegativeButton = true

    private var htmlText: Spanned? = null

    private var onPositiveClick: OnDialogClick? = null
    private var onNegativeClick: OnDialogClick? = null

    private var currentAlert: AppCompatDialog? = null

    interface OnDialogClick {
        fun onDialogClick()
    }

    class Builder constructor(val activity: AppCompatActivity) {
        var title: String? = null
        var content: String? = null
        var positiveString: String? = null
        var negativeString: String? = null

        var isPositiveButton = true
        var isNegativeButton = true
        var htmlText: Spanned? = null

        var onPositiveClick: OnDialogClick? = null
        var onNegativeClick: OnDialogClick? = null

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setTitle(title: Int): Builder {
            this.title = activity.resources.getString(title)
            return this
        }

        fun setContent(content: String): Builder {
            this.content = content
            return this
        }

        fun setContent(content: Int): Builder {
            this.content = activity.resources.getString(content)
            return this
        }

        fun setPositiveString(positiveString: String): Builder {
            this.positiveString = positiveString
            return this
        }

        fun setPositiveString(positiveString: Int): Builder {
            this.positiveString = activity.resources.getString(positiveString)
            return this
        }

        fun setNegativeString(negativeString: String): Builder {
            this.negativeString = negativeString
            return this
        }

        fun setNegativeString(negativeString: Int): Builder {
            this.negativeString = activity.resources.getString(negativeString)
            return this
        }

        fun setHtmlText(htmlText: Spanned): Builder {
            this.htmlText = htmlText
            return this
        }

        fun setPositiveButton(isPositiveButton: Boolean): Builder {
            this.isPositiveButton = isPositiveButton
            return this
        }

        fun setNegativeButton(isNegativeButton: Boolean): Builder {
            this.isNegativeButton = isNegativeButton
            return this
        }

        fun setPositiveClick(onPositiveClick: OnDialogClick): Builder {
            this.onPositiveClick = onPositiveClick
            return this
        }

        fun setNegativeClick(onNegativeClick: OnDialogClick): Builder {
            this.onNegativeClick = onNegativeClick
            return this
        }

        fun build(): ChlibAlert {
            return ChlibAlert(this)
        }
    }

    init {
        this.activity = builder.activity
        this.title = builder.title
        this.content = builder.content
        this.positiveString = builder.positiveString ?: "확인"
        this.negativeString = builder.negativeString ?: "취소"
        this.isPositiveButton = builder.isPositiveButton
        this.isNegativeButton = builder.isNegativeButton
        this.htmlText = builder.htmlText
        this.onPositiveClick = builder.onPositiveClick
        this.onNegativeClick = builder.onNegativeClick
    }

    fun show() {
        activity?.let {
            if (!it.isDestroyed) {
                val alert: ChlibAlertBinding = DataBindingUtil.inflate(it.layoutInflater, R.layout.chlib_alert, null, false)
                if (title != null && title!!.isNotEmpty()) {
                    alert.alertTitle.text = title
                }
                if (content != null && content!!.isNotEmpty()) {
                    alert.alertContent.text = content
                } else {
                    alert.alertContent.text = htmlText
                }

                alert.positiveClick = this
                alert.negativeClick = this
                alert.positiveString = positiveString
                alert.negativeString = negativeString
                alert.isPositiveBtn = isPositiveButton
                alert.isNegativeBtn = isNegativeButton

                if (!isNegativeButton) alert.btnLeft.visibility = View.GONE
                if (!isPositiveButton) alert.btnRight.visibility = View.GONE

                currentAlert = AppCompatDialog(it, R.style.ChlibAlertDialog)
                currentAlert!!.setContentView(alert.root)
                currentAlert!!.setCancelable(false)
                currentAlert!!.setOnKeyListener { _: DialogInterface?, keyCode: Int, _: KeyEvent? -> KeyEvent.KEYCODE_BACK == keyCode }
                val window = currentAlert!!.window
                window?.let { window.attributes.windowAnimations = R.style.ChlibAlertAnim }
                currentAlert!!.show()
            }
        }
    }


    override fun onClick(v: View) {
        if (activity != null && !activity!!.isDestroyed && currentAlert != null) {
            currentAlert!!.dismiss()
        }
        when (v.id) {
            R.id.btn_right -> {
                onPositiveClick?.onDialogClick()
            }
            R.id.btn_left -> {
                onNegativeClick?.onDialogClick()
            }
            else -> {}
        }
    }

}