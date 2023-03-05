package com.example.affirmations

import android.content.Context
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.model.Affirmation
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito


class AffirmationsAdapterTests {
    private val context = Mockito.mock(Context::class.java)

    @Test()
    fun adapter_size() {
        val data = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2)
        )
        val adapter = ItemAdapter(context, data)
        Assert.assertEquals("ItemAdapter is not the correct size", data.size, adapter.itemCount)
    }
}