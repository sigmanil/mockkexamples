import io.mockk.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class Example7MultiCapturingTest {

    @Test
    fun storeDataAndTellTheExternalDependency() {
        val capturingSlot = slot<List<SomethingWithAnId>>()

        val externalMock = mockk<ExternalAdapter> {
            every { alertAboutNewDataAndReturnAssociatedData(capture(capturingSlot)) } answers {
                capturingSlot.captured.map{
                    EnrichedSomething(it.id, it.data, "Tulledata for testdata med id ${it.id}")
                }
            }
        }

        //Here's the change. No longer a slot, but a list of captured elements.
        val capturedInput = mutableListOf<EnrichedSomething>()

        val dbMock = mockk<DatabaseAdapter> {
            every { storeEnrichedDataObject(capture(capturedInput)) } just Runs
        }

        val data = listOf("kake", "sjokolade", "brus")

        Example7MultiCapturing(externalMock, dbMock).enrichAndStoreData(data)

        val assertions = listOf(
            { assertEquals(data.size, capturedInput.size) },
            { assertEquals(data.toSet(), capturedInput.map{ it.data }.toSet()) }
        ) + capturedInput.map {
            { assertTrue(it.moreData.contains(it.id), "Expecting ${it.moreData} to contain ${it.id}") }
        }

        assertAll(assertions)
    }
}