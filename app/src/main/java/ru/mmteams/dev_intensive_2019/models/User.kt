package ru.mmteams.dev_intensive_2019.models

import ru.mmteams.dev_intensive_2019.utils.Utils
import java.util.Date

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String = "",
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {


    /*constructor(id:String,firstName: String?,lastName: String?):this{
        id=id

    }*/

    private constructor(builder: Builder) : this(
        builder.id,
        builder.firstName,
        builder.lastName,
        builder.avatar,
        builder.rating,
        builder.respect,
        builder.lastVisit,
        builder.isOnline
    )


    class Builder {
        var id: String = ""
        var firstName = ""
        var lastName = ""
        var avatar: String = ""
        var rating: Int = 0
        var respect: Int = 0
        var lastVisit: Date? = Date()
        var isOnline: Boolean = false

        fun id(id: String) = apply { this.id = id }
        fun firstName(firstname: String) = apply { this.firstName = firstname }
        fun lastname(lastname: String) = apply { this.lastName = lastname }
        fun avatar(avatar: String) = apply { this.avatar = avatar }
        fun rating(rating: Int) = apply { this.rating = rating }
        fun respect(respect: Int) = apply { this.respect = respect }
        fun lastVisi(lastVisit: Date) = apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline }

        fun build(): User {
            return User(this)
        }
    }


    companion object Factory {
        private var lastId = -1
        fun makeUser(fullname: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullname)
            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }
}
