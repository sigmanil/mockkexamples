import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Example3RelaxThoseUnitsTest {

    @Test
    fun doAllTheThings() {
        val expectedDependencyInput = 1
        val expectedResult = 2

        //Nice, we can use a block to initialize the mock!
        val mock = mockk<SomeDependency> {
            every { doTheFirstThing() } just Runs
            every { doTheSecondThing() } just Runs
            every { doTheThirdThingAndReturnSomething() } returns expectedDependencyInput
            every { doTheFourthThing() } just Runs
        }

        val result = Example3RelaxThoseUnits(mock).doAllTheThings()

        assertEquals(expectedResult, result)
    }

    @Test
    fun doAllTheThingsWithLessHassle() {
        val expectedDependencyInput = 1
        val expectedResult = 2

        //Nice, we can just ignore the unit-returning functions!
        val mock = mockk<SomeDependency>(relaxUnitFun = true) {
            every { doTheThirdThingAndReturnSomething() } returns expectedDependencyInput
        }

        val result = Example3RelaxThoseUnits(mock).doAllTheThings()

        assertEquals(expectedResult, result)
    }
}