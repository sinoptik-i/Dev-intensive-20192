package ru.mmteams.dev_intensive_2019.extentions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs
import kotlin.math.absoluteValue

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this

}

fun Date.humanizeDiff(): String {
    val difference = Date().time - this.time

    var result = ""
    when (difference.absoluteValue) {
        in DAY * 360..Long.MAX_VALUE -> {
            if (difference > 0)
                return "более года назад"
            else
                return "более чем через год"
        }
        in 26 * HOUR..DAY * 360 -> {
            val days = difference.absoluteValue / DAY
            result = "$days ${correctDays(days)}"
        }
        in 22 * HOUR..26 * HOUR -> result = "день"
        in 75 * MINUTE..22 * HOUR -> {
            val hours = difference.absoluteValue / HOUR
            result = "$hours ${correctHours(hours)}"
        }
        in 45 * MINUTE..75 * MINUTE -> return "час"
        in 45 * SECOND..45 * MINUTE -> {
            val minutes = difference.absoluteValue / MINUTE
            result = "$minutes ${correctMinutes(minutes)}"
        }
        in 45 * SECOND..75 * SECOND -> result = "минуту"
        in SECOND..45 * SECOND -> result = "несколько секунд"
        else -> return "только что"
    }
    if (difference > 0)
        return "$result назад"
    else
        return "через $result"
}

fun correctSeconds(seconds: Long): String {
    when (seconds % 10L) {
        1L -> return "секунду"
        in 2..4 -> return "секунды"
        else -> return "секунд"
    }
}fun correctMinutes(minutes: Long): String {
    when (minutes % 10L) {
        1L -> return "минуту"
        in 2..4 -> return "минуты"
        else -> return "минут"
    }
}

fun correctHours(hours: Long): String {
    when (hours % 10L) {
        1L -> return "час"
        in 2..4 -> return "часа"
        else -> return "часов"
    }

}

fun correctDays(days: Long): String {
    when (days % 10) {
        1L -> return "день"
        in 2..4 -> return "дня"
        else -> return "дней"
    }

}


enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;
    fun plural(value:Int):String{
          when (this){
            SECOND-> return "$value ${correctSeconds(value.toLong())}"
            MINUTE-> return "$value ${correctMinutes(value.toLong())}"
            HOUR-> return "$value ${correctHours(value.toLong())}"
            DAY-> return "$value ${correctDays(value.toLong())}"
        }
    }
}
