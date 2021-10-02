class Example5Spying() {

    fun addOneToResultOfSomething(): Int {
        return 1 + functionThatNeedsStubbing()
    }

    fun addOneToResultOfSomethingPrivate(): Int {
        return 1 + privateFunctionThatNeedsStubbing()
    }

    internal fun functionThatNeedsStubbing(): Int {
        //Pretend this does a call to a web service or something
        return 1
    }

    private fun privateFunctionThatNeedsStubbing(): Int {
        //Pretend this does a call to a web service or something
        return 1
    }

}