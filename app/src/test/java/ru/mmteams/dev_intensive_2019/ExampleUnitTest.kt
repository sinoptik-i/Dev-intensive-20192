package ru.mmteams.dev_intensive_2019

import junit.runner.Version.id
import org.junit.Test

import org.junit.Assert.*
import ru.mmteams.dev_intensive_2019.extentions.*
import ru.mmteams.dev_intensive_2019.models.User
import ru.mmteams.dev_intensive_2019.utils.Utils
import java.io.File
import java.util.*

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
        var user3 = user.copy(lastVisit = user.lastVisit?.add(3, TimeUnits.DAY))

        println(user3)
        println(1000L)
    }

    @Test
    fun testTU() {

        assertEquals(TimeUnits.SECOND.plural(1), "1 секунду")
        assertEquals(TimeUnits.MINUTE.plural(4), "4 минуты")
        assertEquals(TimeUnits.HOUR.plural(19), "19 часов")
        assertEquals(TimeUnits.DAY.plural(222), "222 дня")
    }

    @Test
    fun stringTruncate() {
        var str = "qqq 5ww 9ee "//12
        var str2 = "qqq 5ww 9ee"//11
        assertEquals("qqq...", str.truncate(3))
        assertEquals("qqq...", str.truncate(4))
        assertEquals("qqq 5...", str.truncate(5))
        assertEquals("qqq 5ww 9ee...", str.truncate(12))
        assertEquals(str2, str2.truncate(11))
    }


    @Test
    fun proverka() {
        println("qqq ".last())
        println("qqq ".removeSuffix(" "))
        println("qqq ".removeSuffix(" ").last())

    }

    @Test
    fun humanizeDiffTest() {

        assertEquals(Date().add(-2, TimeUnits.HOUR).humanizeDiff(), "2 часа назад")
        assertEquals(Date().add(-5, TimeUnits.DAY).humanizeDiff(), "5 дней назад")
        assertEquals(Date().add(2, TimeUnits.MINUTE).humanizeDiff(), "через 2 минуты")
        assertEquals(Date().add(7, TimeUnits.DAY).humanizeDiff(), "через 7 дней")
        assertEquals(Date().add(-400, TimeUnits.DAY).humanizeDiff(), "более года назад")
        assertEquals(Date().add(400, TimeUnits.DAY).humanizeDiff(), "более чем через год")
    }

}