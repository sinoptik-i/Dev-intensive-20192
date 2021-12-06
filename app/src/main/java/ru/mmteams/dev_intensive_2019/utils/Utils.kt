package ru.mmteams.dev_intensive_2019.utils

import java.io.File
import java.util.*

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts = fullName?.split(" ")?.filter { it.isNotBlank() }
        val firstName = parts?.getOrNull(0)
        val secondName = parts?.getOrNull(1)
        return firstName to secondName
    }

    fun toInitial(firstName: String, lastName: String): String? {
        val first = firstName.firstOrNull()
        val second = lastName.firstOrNull()
        return if (first == null && second == null) {
            null
        } else {
            "$first$second"
        }
        /*return firstName.getOrNull(0)?.toString() +
                lastName.getOrNull(1)?.toString()?:""*/
//        return firstName?.getOrNull(0)+lastName?.getOrNull(0)
    }

    fun readFile() {
        File("file2.txt").useLines { lines -> lines.forEach { println(it) } }
    }

    fun createDict() {

        val allLetters: List<String> = str2.split(",")
        dictionary = arrayListOf()// mutableListOf<Pair<String,String>>()// arrayListOf()  // MutableList(0)->Pair<String,String>
        //var c = 0
        for (string in allLetters) {
            val str = string.split("\"", ": ", "\n").filter { it.isNotEmpty() }
            if (str.size > 1) {
                dictionary.add(str[0] to str[1])
          //      println("${c++}) str[0]: ${str[0]}, str[1]: ${str[1]}")
            }
            dictionary.add("ъ" to "")
            dictionary.add("ь" to "")
        }

    }
    fun transChar(symbol:String):String{
        for(pair in dictionary){
            if(symbol.equals(pair.first)) return pair.second
        }
        return symbol
    }
    lateinit var dictionary: MutableList<Pair<String, String>>

    fun transliteration(name: String, divider: String = " "): String {
        createDict()
        dictionary.add(" " to divider)
        var newName = ""
        for (c in name) {
            newName += transChar(c.lowercaseChar().toString())
        }
        var names = newName.split(divider).toMutableList()
        names[0] = names[0][0].uppercase()+names[0].substring(1)
        names[1] = names[1][0].uppercase()+names[1].substring(1)
        newName = "${names[0]}$divider${names[1]}"
        return newName
    }



    val str2 = """
        "а": "a",

        "б": "b",

        "в": "v",

        "г": "g",

        "д": "d",

        "е": "e",

        "ё": "e",

        "ж": "zh",

        "з": "z",

        "и": "i",

        "й": "i",

        "к": "k",

        "л": "l",

        "м": "m",

        "н": "n",

        "о": "o",

        "п": "p",

        "р": "r",

        "с": "s",

        "т": "t",

        "у": "u",

        "ф": "f",

        "х": "h",

        "ц": "c",

        "ч": "ch",

        "ш": "sh",

        "щ": "sh'",

        "ъ": "",

        "ы": "i",

        "ь": "",

        "э": "e",

        "ю": "yu",

        "я": "ya",
        
    """.trimIndent()
}