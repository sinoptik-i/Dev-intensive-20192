package ru.mmteams.dev_intensive_2019.models

import ru.mmteams.dev_intensive_2019.extentions.humanizeDiff
import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text: String
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String="id:$id ${from?.firstName} "+
            " ${if(isIncoming) "получил" else "отправил"} сообщение \"$text \" ${date.humanizeDiff()}"
}


