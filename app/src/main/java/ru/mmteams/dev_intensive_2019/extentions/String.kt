package ru.mmteams.dev_intensive_2019.extentions

fun String.truncate(count: Int = 16): String {
    if (length > count) {
                return "${removeLastSpaces(this.dropLast(length-count))}..."
    }
    if(last() == ' ') {
        return "${removeLastSpaces(this)}..."
    }
    else
        return this
}

fun removeLastSpaces(str: String): String {
    var res=str
    while (res.last() == ' ') {
        res=res.removeSuffix(" ")
    }
    return res
}