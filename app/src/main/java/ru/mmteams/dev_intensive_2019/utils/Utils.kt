package ru.mmteams.dev_intensive_2019.utils

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
}