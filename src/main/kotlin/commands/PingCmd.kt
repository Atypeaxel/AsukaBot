package commands

import modules.CommandOption
import modules.CommandType
import modules.ICommand
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import java.awt.Color

class PingCmd : ICommand {

    override var name: String
        get() = "ping"
        set(value) {}

    override var description: String
        get() = "Ping the discord's gateway servers."
        set(value) {}

    override var type: CommandType
        get() = CommandType.INFO
        set(value) {}

    override fun execution(event: SlashCommandEvent) {
        val builder = EmbedBuilder().setTitle(":ping_pong: **Pong !**")
            .setDescription("There is `${event.jda.gatewayPing} ms` between ${event.jda.selfUser.asMention} and Discord !")
            .setColor(Color.GREEN)
        event.replyEmbeds(builder.build()).queue()
    }

    override fun options(): HashMap<CommandOption, Boolean> {
        return HashMap<CommandOption, Boolean>()
    }
}