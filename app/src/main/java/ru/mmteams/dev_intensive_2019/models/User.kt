package ru.mmteams.dev_intensive_2019.models

import ru.mmteams.dev_intensive_2019.utils.Utils
import java.util.Date

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String="",
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {


    /*constructor(id:String,firstName: String?,lastName: String?):this{
        id=id

    }*/
    companion object Factory {
        private var lastId = -1
        fun makeUser(fullname: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullname)
            return User(id="$lastId",firstName= firstName,lastName= lastName)
        }
    }
}
