package itz.peaxel.asuka.commands.info

import itz.peaxel.asuka.core.managers.CommandOption
import itz.peaxel.asuka.core.managers.CommandType
import itz.peaxel.asuka.core.managers.ICommand
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent

class BotinfoCmd : ICommand {
    override fun execution(event: SlashCommandEvent) {
        TODO("Not yet implemented")
    }

    override val name: String
        get() = "botinfo"

    override val description: String
        get() = "Get Asuka's info such as version, and many more"

    override val type: CommandType
        get() = CommandType.INFO

    override val sigma: Boolean
        get() = false

    override fun options(): HashMap<CommandOption, Boolean> {
        return HashMap()
    }
}