package itz.peaxel.asuka.commands.info

import itz.peaxel.asuka.core.managers.CommandOption
import itz.peaxel.asuka.core.managers.CommandType
import itz.peaxel.asuka.core.managers.ICommand
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.MessageBuilder
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.utils.TimeUtil
import java.awt.Color
import java.time.Instant
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class ProfileCmd : ICommand {
    override fun execution(event: SlashCommandEvent) {

        val user: User =
            if(event.getOption("user") == null){
                event.member!!.user
            }
            else{
                event.getOption("user")!!.asUser
            }

        val member: Member = event.guild!!.getMemberById(user.id)!!

        val dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss a")

        val sb = StringBuilder()
        for(role: Role in member.roles){
            sb.append("${role.asMention} ")
        }

        val builder = EmbedBuilder()
            .setTitle("${member.effectiveName}'s profile")
            .setThumbnail(user.avatarUrl)
            .addField("\uD83D\uDD0D Full name", "`${user.name}#${user.discriminator}`", true)
            .addField("\uD83D\uDC41\u200D\uD83D\uDDE8 Status", "`${member.onlineStatus}`", true)
            .addField("\uD83D\uDC64 User ID", "`${member.id}`", true)
            .addField("\uD83D\uDE80 Account Created", "`${dtf.format(member.user.timeCreated)}`", true)
            .addField("\uD83D\uDCC8 Last server join", "`${dtf.format(member.timeJoined)}`", true)
            .addField("\uD83D\uDCDA Roles", sb.toString(), false)
            .setColor(Color.CYAN)
            .setTimestamp(Instant.now())

        val mb = MessageBuilder().setEmbeds(builder.build())
        event.reply(mb.build()).queue()
    }

    override val name: String
        get() = "profile"

    override val description: String
        get() = "Show your profile or guild user profile"

    override val type: CommandType
        get() = CommandType.INFO

    override val sigma: Boolean
        get() = false

    override fun options(): HashMap<CommandOption, Boolean> {
        val co = CommandOption(OptionType.USER, "user", "Show a guild user profile")
        val hm = HashMap<CommandOption, Boolean>()
        hm[co] = false
        return hm
    }
}