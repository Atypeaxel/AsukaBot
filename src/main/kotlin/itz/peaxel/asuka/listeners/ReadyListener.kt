package itz.peaxel.asuka.listeners

import itz.peaxel.asuka.utils.ACache
import itz.peaxel.asuka.utils.ALogger
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.lang.reflect.Member
import kotlin.math.log

class ReadyListener : ListenerAdapter() {

    private val logger = ALogger(this::class.java.simpleName)

    override fun onReady(event: ReadyEvent) {

        val guild = event.jda.getGuildById("612042933004402688")!!

        val loadMembers = guild.loadMembers()

        for(member in guild.memberCache){
            if(member.user.isBot) return

            ACache.memberCache.add(member)
        }
        logger.debug("Loaded members : ${ACache.memberCache.size}")
    }
}