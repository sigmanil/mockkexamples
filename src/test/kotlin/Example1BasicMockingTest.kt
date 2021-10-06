import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Example1BasicMockingTest {

    /**
     * Nothing in this test actually has anything to do with the ClassyClassWithAGazillionFields. As such,
     * initializing it is wrong for the test according to normal unit test practice - doing so would
     * make the test dependent on code which is not interresting. Mocking the object also lets you avoid
     * having to initialize the gazillion fields.
     *
     * The test will fail if add10ToInput suddenly starts depending on the object in the future. Whether this
     * is fine is a bit of taste. Purists will say "but that's testing implementation". Sure, you can argue that.
     * I'm not a purist. I find it useful to be alerted if such an assumption changes.
     */
    @Test
    fun testSomethingWhereTheClassParameterShouldNotMatter() {
        val mockedClassyObject = mockk<ClassyClassWithAGazillionFields>()
        val objectUnderTest = Example1BasicMocking(mockedClassyObject)

        val initial = 5
        val expected = 15
        val result = objectUnderTest.add10ToInput(initial)
        assertEquals(expected, result)
    }

    @Test
    fun testSomethingWhereWeNeedToStub() {
        val mockedClassyObject = mockk<ClassyClassWithAGazillionFields>()
        val objectUnderTest = Example1BasicMocking(mockedClassyObject)

        val initial = 5
        val expectedInputFromClassNotUnderTest = 7
        val expected = 12

        //NOTE! We're stubbing a _field_ - well, actually we're stubbing the implicit getter. But
        // in general, with mockk and kotlin, stubbing methods and fields work the same.
        every { mockedClassyObject.classyField } returns expectedInputFromClassNotUnderTest

        val result = objectUnderTest.addValueOfClassyFieldToInput(initial)
        assertEquals(expected, result)
    }
}