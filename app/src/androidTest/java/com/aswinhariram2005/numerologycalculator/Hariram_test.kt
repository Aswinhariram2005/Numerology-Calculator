package com.aswinhariram2005.numerologycalculator


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class Hariram_test {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun hariram_test() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(500)

        val textInputEditText = onView(
            allOf(
                withId(R.id.name_edt),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.name_lay),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText.perform(scrollTo(), replaceText("hariram"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.dob_edt),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.dob_lay),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText2.perform(scrollTo(), click())

        val materialTextView = onView(
            allOf(
                withClassName(`is`("com.google.android.material.textview.MaterialTextView")),
                withText("2023"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.LinearLayout")),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())

        val materialTextView2 = onData(anything())
            .inAdapterView(
                allOf(
                    withClassName(`is`("android.widget.YearPickerView")),
                    childAtPosition(
                        withClassName(`is`("com.android.internal.widget.DialogViewAnimator")),
                        1
                    )
                )
            )
            .atPosition(72)
        materialTextView2.perform(scrollTo(), click())

        val appCompatImageButton = onView(
            allOf(
                withClassName(`is`("androidx.appcompat.widget.AppCompatImageButton")),
                withContentDescription("Next month"),
                childAtPosition(
                    allOf(
                        withClassName(`is`("android.widget.DayPickerView")),
                        childAtPosition(
                            withClassName(`is`("com.android.internal.widget.DialogViewAnimator")),
                            0
                        )
                    ),
                    2
                )
            )
        )
        appCompatImageButton.perform(scrollTo(), click())

        val appCompatImageButton2 = onView(
            allOf(
                withClassName(`is`("androidx.appcompat.widget.AppCompatImageButton")),
                withContentDescription("Next month"),
                childAtPosition(
                    allOf(
                        withClassName(`is`("android.widget.DayPickerView")),
                        childAtPosition(
                            withClassName(`is`("com.android.internal.widget.DialogViewAnimator")),
                            0
                        )
                    ),
                    2
                )
            )
        )
        appCompatImageButton2.perform(scrollTo(), click())

        val appCompatImageButton3 = onView(
            allOf(
                withClassName(`is`("androidx.appcompat.widget.AppCompatImageButton")),
                withContentDescription("Next month"),
                childAtPosition(
                    allOf(
                        withClassName(`is`("android.widget.DayPickerView")),
                        childAtPosition(
                            withClassName(`is`("com.android.internal.widget.DialogViewAnimator")),
                            0
                        )
                    ),
                    2
                )
            )
        )
        appCompatImageButton3.perform(scrollTo(), click())

        val appCompatImageButton4 = onView(
            allOf(
                withClassName(`is`("androidx.appcompat.widget.AppCompatImageButton")),
                withContentDescription("Next month"),
                childAtPosition(
                    allOf(
                        withClassName(`is`("android.widget.DayPickerView")),
                        childAtPosition(
                            withClassName(`is`("com.android.internal.widget.DialogViewAnimator")),
                            0
                        )
                    ),
                    2
                )
            )
        )
        appCompatImageButton4.perform(scrollTo(), click())

        val appCompatImageButton5 = onView(
            allOf(
                withClassName(`is`("androidx.appcompat.widget.AppCompatImageButton")),
                withContentDescription("Next month"),
                childAtPosition(
                    allOf(
                        withClassName(`is`("android.widget.DayPickerView")),
                        childAtPosition(
                            withClassName(`is`("com.android.internal.widget.DialogViewAnimator")),
                            0
                        )
                    ),
                    2
                )
            )
        )
        appCompatImageButton5.perform(scrollTo(), click())

        val appCompatImageButton6 = onView(
            allOf(
                withClassName(`is`("androidx.appcompat.widget.AppCompatImageButton")),
                withContentDescription("Next month"),
                childAtPosition(
                    allOf(
                        withClassName(`is`("android.widget.DayPickerView")),
                        childAtPosition(
                            withClassName(`is`("com.android.internal.widget.DialogViewAnimator")),
                            0
                        )
                    ),
                    2
                )
            )
        )
        appCompatImageButton6.perform(scrollTo(), click())

        val materialButton = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton.perform(scrollTo(), click())

        val materialButton2 = onView(
            allOf(
                withId(R.id.calculate_btn), withText("Calculate"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton2.perform(scrollTo(), click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
