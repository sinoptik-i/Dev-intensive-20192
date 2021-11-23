package ru.mmteams.dev_intensive_2019

import org.junit.Test

import org.junit.Assert.*
import ru.mmteams.dev_intensive_2019.extentions.TimeUnits
import ru.mmteams.dev_intensive_2019.extentions.add
import ru.mmteams.dev_intensive_2019.extentions.format
import ru.mmteams.dev_intensive_2019.models.User
import ru.mmteams.dev_intensive_2019.utils.Utils

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun outputUser() {
        var user = User.Factory.makeUser("Alen Delon")
        var user2 = User.makeUser("QQ AA")
        println(user)
        println(user2.lastVisit?.format())
        var user3=user.copy(lastVisit = user.lastVisit?.add(3,TimeUnits.DAY))

        println(user3)
        println(1000L)
    }


    @Test
    fun proverka() {
     //   assertEquals(null to null, Utils.parseFullName(" "))
        println(Utils.toInitial("",""))
    }
}