package commands

import modules.CommandOption
import modules.CommandType
import modules.ICommand
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent

class TestCmd : ICommand {
    override var name: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var description: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var type: CommandType
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun execution(event: SlashCommandEvent) {
        TODO("Not yet implemented")
    }

    override fun options(): HashMap<CommandOption, Boolean> {
        TODO("Not yet implemented")
    }
}