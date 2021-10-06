import java.util.*

class Example9SpyingWithoutStubbing(val math: MathService) {

    fun addTwoToInt(theInt: Int): Int {
        return math.add(theInt, 2)
    }

    fun addTwoToIntInAWastefulWay(theInt: Int): Int {
        return math.addCrazy(theInt, ClassyClassWithAGazillionFields(2, "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf", "asdf"))
    }

}

class MathService {
    fun add(a: Int, b: Int): Int = a + b
    fun addCrazy(a: Int, crazyShit: ClassyClassWithAGazillionFields): Int = a + crazyShit.classyField
}

