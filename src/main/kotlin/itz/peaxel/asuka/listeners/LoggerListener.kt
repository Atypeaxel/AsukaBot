package itz.peaxel.asuka.listeners

import itz.peaxel.asuka.Asuka
import itz.peaxel.asuka.utils.ALogger
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class LoggerListener : ListenerAdapter() {

    private val logger = ALogger(this::class.java.simpleName)

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if(event.author.isBot) return
        if(Asuka.isSigma) return
        logger.log("(#${event.channel.name} - ${event.author.asTag}) > ${event.message.contentRaw}")
    }

    override fun onGuildMemberJoin(event: GuildMemberJoinEvent) {
        if(Asuka.isSigma) return
        logger.log("JOIN > ${event.member.user.asTag}")
    }

    override fun onGuildMemberRemove(event: GuildMemberRemoveEvent) {
        if(Asuka.isSigma) return
        logger.log("LEAVE > ${event.member!!.user.asTag}")
    }
}