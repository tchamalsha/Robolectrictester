package com.kln.android.robolectrictesting.robolectric

import android.view.View
import android.widget.TextView
import com.kln.android.robolectrictesting.MainActivity
import com.kln.android.robolectrictesting.R
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private var activity: MainActivity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    fun validateTextViewContent() {
        val tvActivity = activity!!.findViewById<View>(R.id.activityTextView) as TextView
        assertNotNull("TextView could not be found", tvActivity)
        assertTrue(
            "TextView contains incorrect text",
            "This is text on an Activity" == tvActivity.text.toString()
        )
    }

}