import java.util.*

class Example6Capturing(val externalDependency: ExternalAdapter, val db: DatabaseAdapter) {

    //Trivial example, but we generally use capturing when there's something being generated that we
    //don't know about.

    fun enrichAndStoreData(data: List<String>) {
        val dataObjects = data.map { SomethingWithAnId(UUID.randomUUID().toString(), it) }

        val enrichedData = externalDependency.alertAboutNewDataAndReturnAssociatedData(dataObjects)

        db.storeEnrichedDataObjects(enrichedData)
    }

}

data class SomethingWithAnId(val id: String, val data: String)
data class EnrichedSomething(val id: String, val data: String, val moreData: String)

interface ExternalAdapter {
    fun alertAboutNewDataAndReturnAssociatedData(ids: List<SomethingWithAnId>): List<EnrichedSomething>
}

interface DatabaseAdapter {
    fun storeEnrichedDataObject(obj: EnrichedSomething)
    fun storeEnrichedDataObjects(objs: List<EnrichedSomething>)
}