import io.mockk.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class Example8SimpleVerificationTest {

    //Note: It's clear from the context what kind of mocks we want, so we don't need to specify type.
    val classUnderTest = Example8SimpleVerification(mockk(relaxUnitFun = true), mockk(relaxUnitFun = true))

    @BeforeEach
    fun resetMocks() {
        clearMocks(classUnderTest.db, classUnderTest.client)
    }

    @Test
    fun storeTheString() {
        every { classUnderTest.db.storeStringAndReturnId("cake") } returns 876
        assertEquals(876, classUnderTest.storeTheString("cake"))
        verify(exactly = 1) { classUnderTest.db.storeStringAndReturnId(any()) }
        verify(exactly = 0) { classUnderTest.db.deleteTheDbAndSendDrunkenTextsToYourEx() }
    }

    @Test
    fun doSomeRemoteWork() {
        classUnderTest.doSomeRemoteWork()

        //Use verifyAll if order doesn't matter
        verifySequence {
            classUnderTest.client.connect()
            classUnderTest.client.work()
            classUnderTest.client.disconnect()
        }
        //verifySequence and verifyAll also checks that no other calls were made

        verify { classUnderTest.db wasNot called}
    }
}