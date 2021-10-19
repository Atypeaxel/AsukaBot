package itz.peaxel.asuka.commands.owner


import itz.peaxel.asuka.Asuka
import itz.peaxel.asuka.core.managers.CommandManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import java.awt.Color

class ShutdownCmd : CommandManager.ICommand {

    override fun execution(event: SlashCommandEvent) {
        val eb = EmbedBuilder().setTitle(":warning: Shutting down...")
            .setDescription("Asuka is now shutting down. You need to restart it manually through CLI server or computer in order to use it again !")
            .setColor(Color.orange)

        event.replyEmbeds(eb.build()).queue()
        Asuka.stop()
    }

    override val name: String
        get() = "shutdown"

    override val description: String
        get() = "Shutdown the bot. You need to restart it manually"

    override val type: CommandManager.CommandType
        get() = CommandManager.CommandType.OWNER

    override val sigma: Boolean
        get() = false

    override fun options(): HashMap<CommandManager.CommandOption, Boolean> {
        return HashMap()
    }
}