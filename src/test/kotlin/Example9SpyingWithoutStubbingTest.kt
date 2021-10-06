import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Example9SpyingWithoutStubbingTest {

    @Test
    fun testAddTwoToInt() {
        val ex = Example9SpyingWithoutStubbing(spyk())

        assertEquals(7, ex.addTwoToInt(5))

        verify { ex.math.add(5,2)}
    }

    @Test
    fun testAddTwoToIntInAWastefulWay() {
        val ex = Example9SpyingWithoutStubbing(spyk())

        assertEquals(7, ex.addTwoToIntInAWastefulWay(5))

        verify { ex.math.addCrazy(5, withArg { assertEquals(2, it.classyField) }) }
    }

    @Test
    fun testAddTwoToIntInAWastefulWayAgain() {
        val ex = Example9SpyingWithoutStubbing(spyk())

        assertEquals(7, ex.addTwoToIntInAWastefulWay(5))

        verify { ex.math.addCrazy(5, match { it.classyField == 2 } ) }
    }

}