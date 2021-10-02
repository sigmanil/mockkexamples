import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Example2MultilevelMockTest {

    @Test
    fun doSomethingHardSomewhereElse() {
        val mockedWrapper = mockk<WrapperClass>()
        val objectUnderTest = Example2MultilevelMock(mockedWrapper)

        val initial = 5
        val expectedResultOfReallyHardComputationNotTestedHere = 1
        val expected = 6

        //System.err.println(mockedWrapper.dependency)

        //This actually sets up mocks for both the inner wrapper and the "interresting" class automagically!
        every {
            mockedWrapper.withinOuterWrappingLayer.withinInnerWrappingLayer.doSomethingHard()
        } returns expectedResultOfReallyHardComputationNotTestedHere


        val result = objectUnderTest.doSomethingHardSomewhereElse(initial)
        assertEquals(expected, result)
        //System.err.println(mockedWrapper.dependency)
    }
}

//NOTE: If you need to use this often, your models may need some work. Learn some OO.
// Put another way, here we ARE testing the implementation in a horrible way, but we're doing it
// because we wrote the code in a manner that forces us to.
// Regrettably, while "write good code" is a worthy goal, you came to see Mockk-magic, not great code.