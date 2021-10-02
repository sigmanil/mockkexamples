
class Example2MultilevelMock(val wrappyMcWrapface: WrapperClass) {
    fun doSomethingHardSomewhereElse(input: Int): Int {
        return input + wrappyMcWrapface.withinOuterWrappingLayer.withinInnerWrappingLayer.doSomethingHard()
    }
}

data class WrapperClass(val withinOuterWrappingLayer: InternalWrappingClass)

data class InternalWrappingClass(val withinInnerWrappingLayer: InterrestingClass)

class InterrestingClass {
    fun doSomethingHard() = 1 //This isn't easy. This is complicated stuff.
}
