import java.util.*

class Example7MultiCapturing(val externalDependency: ExternalAdapter, val db: DatabaseAdapter) {

    fun enrichAndStoreData(data: List<String>) {
        val dataObjects = data.map { SomethingWithAnId(UUID.randomUUID().toString(), it) }

        val enrichedData = externalDependency.alertAboutNewDataAndReturnAssociatedData(dataObjects)

        enrichedData.forEach {
            db.storeEnrichedDataObject(it)
        }
    }

}
