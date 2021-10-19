package itz.peaxel.asuka.commands.info

import itz.peaxel.asuka.Asuka
import itz.peaxel.asuka.core.managers.CommandOption
import itz.peaxel.asuka.core.managers.CommandType
import itz.peaxel.asuka.core.managers.ICommand
import itz.peaxel.asuka.utils.ACache
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import java.awt.Color
import java.time.Instant
import java.time.format.DateTimeFormatter

class BotinfoCmd : ICommand {
    override fun execution(event: SlashCommandEvent) {
        val eb = EmbedBuilder()
            .setTitle("Asuka's bot informations.")
            .setDescription("Asuka is a private Discord made for a private server called 'The server'. ")
            .addField("Full name", event.jda.selfUser.asTag, true)
            .addField("Developed by", "ItzPeaxel", true)
            .addField("Version", Asuka.config.version, true)
            .addField("Language", "Kotlin", true)
            .addField("Kotlin Version", KotlinVersion.CURRENT.toString(), true)
            .addField("Library", "[JDA](https://github.com/DV8FromTheWorld/JDA)", true)
            .addField("Members", ACache.memberCache.size.toString(), true)
            .addField("Created", event.jda.selfUser.timeCreated.format(DateTimeFormatter.ofPattern("D/MM/YYYY - hh:mm:ss")), false)
            .setTimestamp(Instant.now())
            .setColor(Color.PINK)
            .setThumbnail(event.jda.selfUser.avatarUrl)

        event.replyEmbeds(eb.build()).queue()
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