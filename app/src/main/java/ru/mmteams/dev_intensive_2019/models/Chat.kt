package ru.mmteams.dev_intensive_2019.models

class Chat(
    val id:String,
    val members:MutableList<User> = mutableListOf(),
    val messages:MutableList<BaseMessage> = mutableListOf()
) {
}