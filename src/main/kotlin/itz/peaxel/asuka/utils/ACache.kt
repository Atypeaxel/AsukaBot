package itz.peaxel.asuka.utils

import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message

object ACache {

    val memberCache = ArrayList<Member>()
    val messageCache = ArrayList<Message>()
}