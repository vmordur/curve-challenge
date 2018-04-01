package com.challenge.curve.vmorapp

import com.challenge.curve.vmorapp.utils.toValidInt
import org.junit.Assert
import org.junit.Test

/**
 * Tests for text utility methods.
 */
class TextUtilsTest {

    private val emptyReference: CharSequence? = null
    private val list: ArrayList<CharSequence> = arrayListOf("", "   ", "2", "456", "-25", " 34", "0000 ")

    @Test
    fun testToValidInt() {
        Assert.assertTrue(emptyReference.toValidInt() == 0)
        Assert.assertTrue(list[0].toValidInt() == 0)
        Assert.assertTrue(list[1].toValidInt() == 0)
        Assert.assertTrue(list[2].toValidInt() == 2)
        Assert.assertTrue(list[3].toValidInt() == 456)
        Assert.assertTrue(list[4].toValidInt() == -25)
        Assert.assertTrue(list[5].toValidInt() == 34)
        Assert.assertTrue(list[6].toValidInt() == 0)
    }
}