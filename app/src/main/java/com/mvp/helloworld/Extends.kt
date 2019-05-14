package com.mvp.helloworld

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.StringRes
import android.support.v4.content.res.ResourcesCompat
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import java.io.Serializable
import java.util.*

/**
 * 描述：
 * 日期：2019/5/14
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */

fun Int.resToColor(): Int = ResourcesCompat.getColor(CustomeApplication.instance.resources, this, null)

fun Int.resToString(vararg params: Any): String = CustomeApplication.instance.resources.getString(this, *params)

@JvmOverloads
fun Int.inflate(viewGroup: ViewGroup? = null, attachView: Boolean = false, context: Context = CustomeApplication.instance.applicationContext): View = LayoutInflater.from(context).inflate(this, viewGroup, attachView)

fun Float.dpToPx(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, CustomeApplication.instance.resources.displayMetrics)

fun Float.spToPx(): Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, this, CustomeApplication.instance.resources.displayMetrics)

fun Int.resToDrawable(): Drawable = ResourcesCompat.getDrawable(CustomeApplication.instance.resources, this, null)!!

fun Activity.toast(message: String) {
    this.runOnUiThread {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

fun Activity.toast(@StringRes message: Int) {
    this.runOnUiThread {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

fun Activity.hideKeyBoard() {
    val inputMethodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.window.decorView.windowToken, 0)
}

infix fun <T> Boolean.then(value: T?) = if (this) value else null

fun <T> Boolean.then(value: T?, default: T) = if (this) value else default

inline fun <T> Boolean.then(function: () -> T, default: T) = if (this) function() else default

inline fun <T> Boolean.then(function: () -> T, default: () -> T) = if (this) function() else default()

inline infix fun <reified T> Boolean.then(function: () -> T) = if (this) function() else null


fun Bundle.put(params: Array<out Pair<String, Any?>>): Bundle {

    params.forEach {
        val key = it.first
        val value = it.second
        when (value) {
            is Int -> putInt(key, value)
            is IntArray -> putIntArray(key, value)
            is Long -> putLong(key, value)
            is LongArray -> putLongArray(key, value)
            is CharSequence -> putCharSequence(key, value)
            is String -> putString(key, value)
            is Float -> putFloat(key, value)
            is FloatArray -> putFloatArray(key, value)
            is Double -> putDouble(key, value)
            is DoubleArray -> putDoubleArray(key, value)
            is Char -> putChar(key, value)
            is CharArray -> putCharArray(key, value)
            is Short -> putShort(key, value)
            is ShortArray -> putShortArray(key, value)
            is Boolean -> putBoolean(key, value)
            is BooleanArray -> putBooleanArray(key, value)

            is Serializable -> putSerializable(key, value)
            is Parcelable -> putParcelable(key, value)
            is Bundle -> putAll(value)
        }
    }
    return this
}