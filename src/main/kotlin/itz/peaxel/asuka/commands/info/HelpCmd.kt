package itz.peaxel.asuka.commands.info

import itz.peaxel.asuka.core.managers.CommandOption
import itz.peaxel.asuka.core.managers.CommandType
import itz.peaxel.asuka.core.managers.ICommand
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.commands.OptionType

class HelpCmd : ICommand {

    override fun execution(event: SlashCommandEvent) {
        if(event.getOption("command") == null){
            TODO("BASIC HELP COMMAND")
        }
        else{
            TODO("PRECISE HELP COMMAND")
        }
    }

    override val name: String
        get() = "help"

    override val description: String
        get() = "Get command list or some info about a command"

    override val type: CommandType
        get() = CommandType.INFO

    override val sigma: Boolean
        get() = true

    override fun options(): HashMap<CommandOption, Boolean> {
        val hm = HashMap<CommandOption, Boolean>()
        val cm = CommandOption(OptionType.STRING, "command", "get help and more information about a command")
        hm[cm] = false
        return hm
    }
}