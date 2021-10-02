
class Example6DynamicStubbing(val dependency: FolkeregisterAdapter) {

//    fun addOneToResultOfHardComputation(names: List<String>): Int {
//        return 1 + dependency.lookupNamesInFolkeRegAndSumAges(input)
//    }

}

interface FolkeregisterAdapter {
    fun lookupNamesInFolkeRegAndSumAges(list: Int): Int
}