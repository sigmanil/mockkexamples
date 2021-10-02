
class Example3RelaxThoseUnits(val dependency: SomeDependency) {

    fun doAllTheThings(): Int {
        dependency.doTheFirstThing()
        dependency.doTheSecondThing()
        val dependencyInput = dependency.doTheThirdThingAndReturnSomething()
        dependency.doTheFourthThing()

        //What we really want to test is that 1 is added...
        return 1 + dependencyInput
    }

}

interface SomeDependency {
    fun doTheFirstThing()
    fun doTheSecondThing()
    fun doTheThirdThingAndReturnSomething(): Int
    fun doTheFourthThing()
}