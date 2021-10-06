package modules

import managers.IModule
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import utils.ALogger

class CacheModule : IModule, ListenerAdapter() {

    companion object{
        lateinit var messageCache: HashMap<String, String>
        lateinit var memberCache: HashMap<String, String>
    }

    override var name: String
        get() = "CacheManager"
        set(value) {}

    override fun execution() {
        messageCache = HashMap()
        memberCache = HashMap()

        ALogger.system("Cache Manager Loaded !")
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        messageCache[event.messageId] = event.message.contentRaw
    }
}