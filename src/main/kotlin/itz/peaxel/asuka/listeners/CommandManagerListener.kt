package itz.peaxel.asuka.listeners

import itz.peaxel.asuka.Asuka
import itz.peaxel.asuka.core.AConfiguration
import itz.peaxel.asuka.core.managers.CommandManager
import itz.peaxel.asuka.utils.ALogger
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.build.CommandData
import java.awt.Color
import java.lang.Exception
import java.time.Instant

class CommandManagerListener : ListenerAdapter() {

    private val logger = ALogger(this::class.java.simpleName)

    override fun onSlashCommand(event: SlashCommandEvent) {

        for(commands in CommandManager.getCommands) logger.debug(commands.key)


        if(!CommandManager.getCommands.containsKey(event.name)) return

        val command = CommandManager.getCommands[event.name]


        if(command!!.sigma == Asuka.isSigma){
            if(!Asuka.config.ownerIds.contains(event.member!!.id)) return
        }

        GlobalScope.launch {
            try{
                command.execution(event)
            } catch (e: Exception){
                val builder = EmbedBuilder()
                    .setTitle("An error has occurred.")
                    .setDescription("```${e.message.toString()}```")
                    .setColor(Color.RED)
                    .setFooter("Please watch the console for more information.")

                event.replyEmbeds(builder.build()).queue()
            }
        }
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if(event.message.contentRaw == "//uc"){
            if(!Asuka.config.ownerIds.contains(event.author.id)) return

            val eb = EmbedBuilder().setTitle("Commands updated !").setDescription("✅ Slash commands will be updated soon.").setTimestamp(Instant.now()).setColor(Color.GREEN)
            event.message.replyEmbeds(eb.build()).queue()

            val jda = event.jda
            val guild = event.guild
            val commands = CommandManager.getCommands

            jda.getGuildById(guild.id)!!.updateCommands()

            for(command in commands) {
                val commandValue = command.value
                val commandData = CommandData(commandValue.name, commandValue.description)

                if (commandValue.options().isNotEmpty()) {
                    for (option in commandValue.options()) {
                        val value = option.value
                        val key = option.key
                        commandData.addOption(key.type, key.name, key.desc, value)
                    }
                }
                jda.upsertCommand(commandData).queue()
            }
        }

        if(event.message.contentRaw == "//cc"){
            if(!Asuka.config.ownerIds.contains(event.author.id)) return

            val eb = EmbedBuilder().setTitle("Commands cleared !").setDescription("✅ Slash commands will be updated soon.").setTimestamp(Instant.now()).setColor(Color.GREEN)
            event.message.replyEmbeds(eb.build()).queue()

            event.jda.getGuildById(event.guild.id)!!.updateCommands().queue()
        }
    }
}