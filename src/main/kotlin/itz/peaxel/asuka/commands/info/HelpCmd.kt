package itz.peaxel.asuka.commands.info

import itz.peaxel.asuka.Asuka
import itz.peaxel.asuka.core.managers.CommandManager
import itz.peaxel.asuka.core.managers.CommandOption
import itz.peaxel.asuka.core.managers.CommandType
import itz.peaxel.asuka.core.managers.ICommand
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.commands.OptionType
import java.awt.Color
import java.lang.StringBuilder
import java.time.Instant

class HelpCmd : ICommand {

    override fun execution(event: SlashCommandEvent) {

        val commands = CommandManager.getCommands

        if(event.getOption("command") == null){
            val ownerCommands = ArrayList<ICommand>()
            val modCommands = ArrayList<ICommand>()
            val musicCommands = ArrayList<ICommand>()
            val infoCommands = ArrayList<ICommand>()
            val otherCommands = ArrayList<ICommand>()

            for (command in commands.values){
                when(command.type){
                    CommandType.OWNER -> ownerCommands.add(command)
                    CommandType.MODERATION -> modCommands.add(command)
                    CommandType.MUSIC -> musicCommands.add(command)
                    CommandType.INFO -> infoCommands.add(command)
                    CommandType.OTHER -> otherCommands.add(command)
                }
            }

            val eb = EmbedBuilder()
                .setTitle("List of Asuka's commands")
                .setDescription("Here's the list of all available commands for Asuka. For specific command information, type `/help <command>`.")
                .setColor(Color.CYAN)
                .setTimestamp(Instant.now())
                .setFooter("Made with ❤️ by ItzPeaxel")
                .setThumbnail(event.jda.selfUser.avatarUrl)

            if(ownerCommands.isNotEmpty() && Asuka.config.ownerIds.contains(event.member!!.id)){
                val sb = StringBuilder()
                for(command in ownerCommands) sb.append("`${command.name}` ")
                eb.addField("Owner Commands", sb.toString(), false)
            }

            if(modCommands.isEmpty() && event.member!!.hasPermission(Permission.ADMINISTRATOR)){
                val sb = StringBuilder()
                for(command in modCommands) sb.append("`${command.name}` ")
                eb.addField("Moderation Commands", sb.toString(), false)
            }

            if(musicCommands.isNotEmpty()){
                val sb = StringBuilder()
                for(command in musicCommands) sb.append("`${command.name}` ")
                eb.addField("Music Commands", sb.toString(), false)
            }

            if(infoCommands.isNotEmpty()){
                val sb = StringBuilder()
                for(command in infoCommands) sb.append("`${command.name}` ")
                eb.addField("Info Commands", sb.toString(), false)
            }

            if(otherCommands.isNotEmpty()){
                val sb = StringBuilder()
                for(command in otherCommands) sb.append("`${command.name}` ")
                eb.addField("Other Commands", sb.toString(), false)
            }

            event.replyEmbeds(eb.build()).queue()
        }
        else{
            val option = event.getOption("command")!!.asString

            if(commands.containsKey(option)){
                val command = commands.getValue(option)

                val eb = EmbedBuilder()
                    .setTitle("Info about $option's command")
                    .addField("Description", command.description, false)
                    .setColor(Color.cyan)
                    .setTimestamp(Instant.now())

                if(command.options().isNotEmpty()){
                    val sb = StringBuilder()
                    for(option in command.options()){
                        sb.append("`${option.key.name}` - ${option.key.desc}\n")
                    }
                    eb.addField("Options", sb.toString(), false)
                }

                event.replyEmbeds(eb.build()).queue()
            }
            else {
                val eb = EmbedBuilder()
                    .setTitle("Command not found")
                    .setDescription("The command `$option` does not exists in Asuka's database.\nType `/help` for the complete list of commands.")
                    .setTimestamp(Instant.now())
                    .setColor(Color.RED)

                event.replyEmbeds(eb.build()).queue()
            }
        }
    }

    override val name: String
        get() = "help"

    override val description: String
        get() = "Get command list or some info about a command"

    override val type: CommandType
        get() = CommandType.INFO

    override val sigma: Boolean
        get() = false

    override fun options(): HashMap<CommandOption, Boolean> {
        val hm = HashMap<CommandOption, Boolean>()
        val cm = CommandOption(OptionType.STRING, "command", "get help and more information about a command")
        hm[cm] = false
        return hm
    }
}