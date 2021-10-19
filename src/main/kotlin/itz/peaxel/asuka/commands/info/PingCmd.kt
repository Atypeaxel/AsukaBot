package itz.peaxel.asuka.commands.info


import itz.peaxel.asuka.core.managers.CommandManager
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import java.awt.Color

class PingCmd : CommandManager.ICommand {

    override val name: String
        get() = "ping"

    override val description: String
        get() = "Ping the discord's gateway servers."

    override val type: CommandManager.CommandType
        get() = CommandManager.CommandType.INFO

    override val sigma: Boolean
        get() = false

    override fun execution(event: SlashCommandEvent) {
        val builder = EmbedBuilder().setTitle(":ping_pong: **Pong !**")
            .setDescription("There is `${event.jda.gatewayPing} ms` between ${event.jda.selfUser.asMention} and Discord !")
            .setColor(Color.GREEN)
        event.replyEmbeds(builder.build()).queue()
    }

    override fun options(): HashMap<CommandManager.CommandOption, Boolean> {
        return HashMap<CommandManager.CommandOption, Boolean>()
    }
}