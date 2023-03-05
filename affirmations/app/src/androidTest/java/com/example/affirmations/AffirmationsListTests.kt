package com.example.affirmations

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AffirmationsListTests {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun scroll_to_item() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(
            RecyclerViewActions
                .scrollTo<RecyclerView.ViewHolder>(
                    ViewMatchers.hasDescendant(ViewMatchers.withText(R.string.affirmation10))
                )
        )

        Espresso.onView(ViewMatchers.withText(R.string.affirmation10))
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
    }
}