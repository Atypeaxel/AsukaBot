package itz.peaxel.asuka.utils

import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message

/**
 * This object class is used as a multiple cache for the bot.
 */
object ACache {
    val memberCache = ArrayList<Member>()
    val messageCache = ArrayList<Message>()
}