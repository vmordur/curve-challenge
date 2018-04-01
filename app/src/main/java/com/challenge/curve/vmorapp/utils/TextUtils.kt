package com.challenge.curve.vmorapp.utils

/**
 * Text utility methods.
 */
fun CharSequence?.toValidInt(): Int {
    if (this == null) return 0
    val value = if (this.isNullOrEmpty()) "0" else this.toString().trim()
    val result = if (value.isEmpty()) "0" else value
    return result.toInt()
}