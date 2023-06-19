package com.swipeapp.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.swipeapp.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ProductActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(ProductActivity::class.java)

    @Test
    fun productActivityTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.search_suggest),
                childAtPosition(
                    allOf(
                        withId(R.id.search_container),
                        childAtPosition(
                            withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(pressImeActionButton())

        val floatingActionButton = onView(
            allOf(
                withId(R.id.fb_button),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val appCompatImageView = onView(
            allOf(
                withId(R.id.choose_image),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    0
                )
            )
        )
        appCompatImageView.perform(scrollTo(), click())

        val linearLayout = onView(
            allOf(
                withId(com.github.dhaval2404.imagepicker.R.id.lytCameraPick),
                childAtPosition(
                    childAtPosition(
                        withId(androidx.appcompat.R.id.custom),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        linearLayout.perform(click())

        val actionMenuItemView = onView(
            allOf(
                withId(com.github.dhaval2404.imagepicker.R.id.menu_crop),
                withContentDescription("Crop"),
                childAtPosition(
                    childAtPosition(
                        withId(com.github.dhaval2404.imagepicker.R.id.toolbar),
                        2
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView.perform(click())

        val textInputEditText = onView(
            allOf(
                withId(R.id.item_name),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.item_name_label),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText.perform(scrollTo(), replaceText("Mobile"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.item_name), withText("Mobile"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.item_name_label),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText2.perform(pressImeActionButton())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.item_type),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.item_type_label),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText3.perform(scrollTo(), replaceText("Electronic"), closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.item_type), withText("Electronic"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.item_type_label),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText4.perform(pressImeActionButton())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.item_price),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.item_price_label),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText5.perform(scrollTo(), replaceText("120000"), closeSoftKeyboard())

        val textInputEditText6 = onView(
            allOf(
                withId(R.id.item_price), withText("120000"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.item_price_label),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText6.perform(pressImeActionButton())

        val textInputEditText7 = onView(
            allOf(
                withId(R.id.item_tax),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.item_tax_label),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText7.perform(scrollTo(), replaceText("10000"), closeSoftKeyboard())

        val textInputEditText8 = onView(
            allOf(
                withId(R.id.item_tax), withText("10000"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.item_tax_label),
                        0
                    ),
                    0
                )
            )
        )
        textInputEditText8.perform(pressImeActionButton())

        val materialButton = onView(
            allOf(
                withId(R.id.save_action), withText("Save"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    5
                )
            )
        )
        materialButton.perform(scrollTo(), click())
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
