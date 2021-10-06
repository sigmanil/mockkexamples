import java.util.*

class Example8SimpleVerification(val db: Database, val client: SomeSortOfClient) {

    fun storeTheString(theString: String): Int {
        return db.storeStringAndReturnId(theString)
    }

    fun doSomeRemoteWork() {
        client.connect()
        client.work()
        client.disconnect()
    }

}

interface Database {
    fun storeStringAndReturnId(theString: String): Int
    fun deleteTheDbAndSendDrunkenTextsToYourEx()
}

interface SomeSortOfClient {
    fun connect()
    fun work()
    fun disconnect()
    fun ddos()
}