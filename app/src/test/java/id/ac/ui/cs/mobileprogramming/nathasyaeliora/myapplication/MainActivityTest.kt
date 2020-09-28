package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

class MainActivityTest{
    val mainAct = MainActivity()

    @Test
    fun testInputNameEmpty(){
        assertEquals(mainAct.validateInputName(""),false)
    }

    @Test
    fun testInputNameValid() {
        assertEquals(mainAct.validateInputName("Squishy"),true)
    }

}