package com.kln.android.robolectrictesting.robolectric

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.kln.android.robolectrictesting.FirstFragment
import com.kln.android.robolectrictesting.MainActivity
import com.kln.android.robolectrictesting.R
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FirstFragmentTest {

    private var activity: MainActivity? = null
    private var fragment: FirstFragment? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        fragment = FirstFragment()
        activity = Robolectric.buildActivity(
            MainActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment!!, null)
        fragmentTransaction.commit()
    }

    @Test
    fun validateTextViewContent() {
        val tvFragment : TextView = activity!!.findViewById<TextView>(R.id.fragmentTextView)
        Assert.assertNotNull("TextView could not be found", tvFragment)
        Assert.assertTrue(
            "TextView contains incorrect text",
            "This is text on a Fragment" == tvFragment.text.toString()
        )
    }
}