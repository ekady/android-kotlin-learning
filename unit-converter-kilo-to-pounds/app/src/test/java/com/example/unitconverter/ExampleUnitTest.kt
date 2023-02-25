package com.example.unitconverter

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun convert_to_pounds() {
        val converter = Converter()
        assertTrue("5 kilos equal to 11.0231 pounds", 11.0231 == converter.convertToPounds(5.0))
    }

}