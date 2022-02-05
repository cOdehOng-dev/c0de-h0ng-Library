package com.c0de_h0ng.library.base

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.c0de_h0ng.library.const.Const.WEB_VIEW_URL

/**
 * Created by c0de_h0ng on 2022/02/05.
 */
abstract class BaseBindingActivity<VD : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: VD

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        bindingProperty()
    }

    abstract fun bindingProperty()

    fun openActivity(dest: Class<*>) {
        val intent = Intent(applicationContext, dest)
        startActivity(intent)
    }

    fun openActivity(dest: Class<*>, key: String, value: Long) {
        val intent = Intent(applicationContext, dest)
        intent.putExtra(key, value)
        startActivity(intent)
    }

    fun openActivity(dest: Class<*>, key: String, value: String) {
        val intent = Intent(applicationContext, dest)
        intent.putExtra(key, value)
        startActivity(intent)
    }

    fun openActivity(dest: Class<*>, key: String, value: Int) {
        val intent = Intent(applicationContext, dest)
        intent.putExtra(key, value)
        startActivity(intent)
    }

    fun openActivity(dest: Class<*>, key: String, value: Float) {
        val intent = Intent(applicationContext, dest)
        intent.putExtra(key, value)
        startActivity(intent)
    }

    fun openActivity(dest: Class<*>, key: String, value: Double) {
        val intent = Intent(applicationContext, dest)
        intent.putExtra(key, value)
        startActivity(intent)
    }

    fun openActivity(dest: Class<*>, key: String, value: Boolean) {
        val intent = Intent(applicationContext, dest)
        intent.putExtra(key, value)
        startActivity(intent)
    }

    /**
     * 웹뷰로 이동
     * @param url WebView Load Url(key: web_view_url)
     */
    fun openWebView(dest: Class<*>, url: String) {
        val intent = Intent(this, dest)
        intent.putExtra(WEB_VIEW_URL, url)
        startActivity(intent)
    }

    fun openPhoneApp(phoneNumber: String?) {
        if (phoneNumber != null && phoneNumber.isNotEmpty()) {
            val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(callIntent)
        }
    }

    /**
     * 스키마로 외부앱 오픈
     * @param scheme         스키마
     * @param appPackageName 미설치된 앱 패키지명
     */
    fun openSchemeExternalApp(scheme: String, appPackageName: String) {
        val packageIntent = packageManager.getLaunchIntentForPackage(appPackageName)
        if (packageIntent != null) {
            //설치시
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(scheme))
            startActivity(intent)
        } else {
            //미설치 시 플레이스토어 연동
            openAppInPlayStore(appPackageName)
        }
    }

    fun openAppInPlayStore(appPackageName: String) {
        val url = "market://details?id=$appPackageName"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    /**
     * 외부 브라우저
     * @param url 외부 브라우저 URL
     */
    fun openExternalWeb(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 권한 설정
     */
    fun openAppPermissionSetting() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:$packageName"))
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    open fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        currentFocus?.let {
            imm.hideSoftInputFromWindow(it.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
        }
    }

    open fun hideKeyboard(editText: EditText) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }

    open fun showKeyboard(editText: EditText) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

}