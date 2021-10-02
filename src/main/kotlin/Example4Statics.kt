/**
 * Note: You rarely have to do this. "Static" methods and functions generally do predictable stuff and can be
 * tested indirectly by your test without problems. This tests more of your code and is generally better than
 * mocking them. But the need still arises sometimes.
 */

class Example4Statics() {

    fun sumResultsOfObnoxiousFunctions(): Int {
        return YoureNotInstantiatingMe.overrideThisYouFilthyAnimal() +
            imNotEvenAMemberOfSomethingYouCanMock()
    }

}

object YoureNotInstantiatingMe {
    fun overrideThisYouFilthyAnimal(): Int = 1
}

fun imNotEvenAMemberOfSomethingYouCanMock(): Int = 1