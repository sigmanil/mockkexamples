
class Example1BasicMocking(val classyObject: ClassyClassWithAGazillionFields) {

    fun add10ToInput(input: Int): Int {
        return input + 10
    }

    fun addValueOfClassyFieldToInput(input: Int): Int {
        return input + classyObject.classyField
    }
}

data class ClassyClassWithAGazillionFields(
    val classyField: Int,
    val field1: String,
    val field2: String,
    val field3: String,
    val field4: String,
    val field5: String,
    val field11: String,
    val field12: String,
    val field13: String,
    val field14: String,
    val field15: String,
    val field21: String,
    val field22: String,
    val field23: String,
    val field24: String,
    val field25: String,
    val field31: String,
    val field32: String,
    val field33: String,
    val field34: String,
    val field35: String,
    val field41: String,
    val field42: String,
    val field43: String,
    val field44: String,
    val field45: String)


