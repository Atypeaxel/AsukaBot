package modules

import commands.PingCmd
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import managers.IModule
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.CommandData
import utils.ALogger
import java.awt.Color
import java.lang.Exception

class CommandModule : IModule, ListenerAdapter() {

    private val commands = HashMap<String, ICommand>()

    override var name: String
        get() = "CommandModule"
        set(value) {}

    override fun execution() {
        registerCommand(PingCmd())
        ALogger.system("Command Manager Loaded !")
    }

    private fun registerCommand(command: ICommand){
        if(commands.containsKey(command.name)) return
        commands[command.name] = command
        ALogger.system("Registering ${command.name} command to HashMap")
    }

    override fun onReady(event: ReadyEvent) {
        val slashCommands = event.jda.getGuildById("612042933004402688")!!.updateCommands()

        for(command in commands){
            val commandValue = command.value
            val commandData = CommandData(commandValue.name, commandValue.description)

            if(commandValue.options().isNotEmpty()){
                for(option in commandValue.options()){
                    val value = option.value
                    val key = option.key
                    commandData.addOption(key.type, key.name, key.desc, value)
                }
            }
            slashCommands.addCommands(commandData).queue()
            ALogger.system("${commandValue.name} command is loaded !")
        }
    }

    override fun onSlashCommand(event: SlashCommandEvent) {
        val command = commands[event.name]

        GlobalScope.launch {
            try{
                command!!.execution(event)
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
}

interface ICommand{
    var name: String
    var description: String
    var type: CommandType
    fun execution(event: SlashCommandEvent)
    fun options(): HashMap<CommandOption, Boolean>
}
class CommandOption(val type: OptionType, val name: String, val desc: String){}

enum class CommandType{
    INFO, MODERATION, OWNER, MUSIC, OTHER
}