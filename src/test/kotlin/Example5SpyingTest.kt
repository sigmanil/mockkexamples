import io.mockk.every
import io.mockk.spyk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Example5SpyingTest {

    @Test
    fun testSpyingOnFunction() {
        val dependencyInput1 = 19
        val expectedResult = 20

        val objectUnderTest = spyk<Example5Spying> {
            every { functionThatNeedsStubbing() } returns dependencyInput1
        }

        val result = objectUnderTest.addOneToResultOfSomething()

        assertEquals(expectedResult, result)
    }

    @Test
    fun testSpyingOnPrivateFunction() {
        val dependencyInput1 = 19
        val expectedResult = 20

        //NEVER DO THIS UNLESS YOU _REALLY_ HAVE TO, WORKING WITH LEGACY JAVA CODE OR SOMETHING
        //REWRITE THE CODE UNDER TEST TO AVOID IT! REFERRING TO METHODS AS STRINGS IS BAD!

        val objectUnderTest = spyk<Example5Spying>(recordPrivateCalls = true)
        every { objectUnderTest invokeNoArgs "privateFunctionThatNeedsStubbing" } returns dependencyInput1

        val result = objectUnderTest.addOneToResultOfSomethingPrivate()

        assertEquals(expectedResult, result)
    }
}