package itz.peaxel.asuka.core.managers

import itz.peaxel.asuka.commands.info.HelpCmd
import itz.peaxel.asuka.commands.info.PingCmd
import itz.peaxel.asuka.commands.info.ProfileCmd
import itz.peaxel.asuka.commands.owner.ShutdownCmd
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.commands.OptionType

object CommandManager {

    private val commands = HashMap<String, ICommand>()

    val getCommands: HashMap<String, ICommand>
        get() = commands

    fun loadCommands(){
        //OWNER CMDs
        registerCommand(ShutdownCmd())

        //INFO CMDs
        registerCommand(HelpCmd())
        registerCommand(PingCmd())
        registerCommand(ProfileCmd())
    }

    private fun registerCommand(command: ICommand){
        if(commands.containsKey(command.name)) return
        commands[command.name] = command
    }

}

interface ICommand {
    fun execution(event: SlashCommandEvent)
    val name: String
    val description: String
    val type: CommandType
    val sigma: Boolean
    fun options(): HashMap<CommandOption, Boolean>
}

class CommandOption(val type: OptionType, val name: String, val desc: String){}

enum class CommandType {
    INFO, MODERATION, OWNER, MUSIC, OTHER
}