import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Example4StaticsTest {

    @Test
    fun testyMcTestface() {
        val dependencyInput1 = 3
        val dependencyInput2 = 7
        val expectedResult = 10

        mockkObject(YoureNotInstantiatingMe)
        every { YoureNotInstantiatingMe.overrideThisYouFilthyAnimal() } returns dependencyInput1

        //In earlier Mockk versions you had to refer to the filename.
        mockkStatic(::imNotEvenAMemberOfSomethingYouCanMock)
        every { imNotEvenAMemberOfSomethingYouCanMock() } returns dependencyInput2

        val result = Example4Statics().sumResultsOfObnoxiousFunctions()

        assertEquals(expectedResult, result)
    }
}

//Note: Similar stuff works with java-statics
