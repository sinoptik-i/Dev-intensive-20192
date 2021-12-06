package ru.mmteams.dev_intensive_2019.models

import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {
    abstract fun formatMessage(): String

    companion object AbstractFactory {
        val lastId = -1
        fun makeMessage(
            from: User?, chat: Chat, date: Date = Date(),
            type: String, payload: Any?, isIncoming: Boolean = false
        ): BaseMessage? {
            when (type) {
                "text" -> return TextMessage("$lastId", from, chat, isIncoming, date,payload as String)
                else -> return TextMessage("$lastId", from, chat, isIncoming, date,payload as String)
            }
        }

    }
}