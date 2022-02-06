package com.c0de_h0ng.library.util

import java.util.regex.Pattern

/**
 * Created by c0de_h0ng on 2022/02/06.
 */
fun isEmojiText(emojiText: String?): Boolean {
    if (emojiText == null) return false
    val emojiPattern = Pattern.compile("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+")
    val emojiMatcher = emojiPattern.matcher(emojiText)
    return emojiMatcher.find()
}

fun isEmailFormat(emailStr: String?): Boolean {
    if (emailStr == null) return false
    val regex = "^[_a-zA-Z0-9-.]+@[.a-zA-Z0-9-]+\\.[a-zA-Z]+$"
    val pattern = Pattern.compile(regex)
    val matcher = pattern.matcher(emailStr)
    return matcher.matches()
}

fun isPasswordFormat(password: String?): Boolean {
    if (password == null) return false
    val regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9!@#$%^&*()?_~.|-]{10,20}$"
    val pattern = Pattern.compile(regex)
    val matcher = pattern.matcher(password)
    return matcher.matches()
}