package itz.peaxel.asuka.core.managers

import itz.peaxel.asuka.listeners.CommandManagerListener
import itz.peaxel.asuka.listeners.LoggerListener
import itz.peaxel.asuka.listeners.ReadyListener
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import net.dv8tion.jda.api.utils.cache.CacheFlag
import java.util.*

object JDAManager {

    lateinit var instance: JDA

    fun startJda(token: String, motd: String){
        instance = JDABuilder.create(token, EnumSet.allOf(GatewayIntent::class.java))
            .enableCache(CacheFlag.ONLINE_STATUS, CacheFlag.MEMBER_OVERRIDES, CacheFlag.ACTIVITY)
            .setActivity(Activity.streaming(motd, "https://twitch.tv/itzpeaxel"))
            .setStatus(OnlineStatus.INVISIBLE)
            .addEventListeners(CommandManagerListener())
            .addEventListeners(LoggerListener())
            .addEventListeners(ReadyListener())
            .build().awaitReady()
    }
}
