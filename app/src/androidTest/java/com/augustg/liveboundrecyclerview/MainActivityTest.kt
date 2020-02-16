package com.augustg.liveboundrecyclerview

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun initial_noItemsDisplayed() {
        onView(withId(R.id.recycler_view)).check(matches(hasChildCount(0)))
    }

    @Test
    fun addItem_oneItemDisplayed() {
        // add one item
        onView(withId(R.id.add_item_button)).perform(ViewActions.click())
        // check matches
        onView(withId(R.id.recycler_view)).check(matches(hasChildCount(1)))
    }

    @Test
    fun twoAddItems_twoItemsDisplayed() {
        // add two items
        onView(withId(R.id.add_item_button)).perform(ViewActions.click())
        onView(withId(R.id.add_item_button)).perform(ViewActions.click())
        // check matches
        onView(withId(R.id.recycler_view)).check(matches(hasChildCount(2)))
    }

    @Test
    fun clear_noItemsDisplayed() {
        // add items
        onView(withId(R.id.add_item_button)).perform(ViewActions.click())
        onView(withId(R.id.add_item_button)).perform(ViewActions.click())
        // clear list
        onView(withId(R.id.clear_button)).perform(ViewActions.click())
        // check
        onView(withId(R.id.recycler_view)).check(matches(hasChildCount(0)))
    }
}