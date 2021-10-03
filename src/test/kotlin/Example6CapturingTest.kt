import io.mockk.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class Example6CapturingTest {

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

        val capturedInput = slot<List<EnrichedSomething>>()

        val dbMock = mockk<DatabaseAdapter> {
            every { storeEnrichedDataObjects(capture(capturedInput)) } just Runs
        }

        val data = listOf("kake", "sjokolade", "brus")

        Example6Capturing(externalMock, dbMock).enrichAndStoreData(data)

        val assertions = listOf(
            { assertEquals(data.size, capturedInput.captured.size) },
            { assertEquals(data.toSet(), capturedInput.captured.map{ it.data }.toSet()) }
        ) + capturedInput.captured.map {
            { assertTrue(it.moreData.contains(it.id), "Expecting ${it.moreData} to contain ${it.id}") }
        }

        assertAll(assertions)
    }
}