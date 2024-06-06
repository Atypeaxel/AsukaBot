import modules.CacheModule
import managers.ModuleManager
import modules.CommandModule
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent
import org.ini4j.Ini
import utils.ALogger
import java.io.File
import kotlin.system.exitProcess

/**
 * This is the source code of Asuka, the bot made the the private server called "the server".
 * This is also a private bot, event if the code isn't protected, please do not use without permission.
 * Maybe this code will be uploaded as a public repo one day on github ! I just need to comment it correctly.
 *
 * @author ItzPeaxel
 * Github : https://github.com/itzpeaxel
 * Twitter : https://twitter.com/ItzPeaxel
 * Discord : ItzPeaxel#1304
 */

/**
 * This is the main class of our program. This is where the main instance is stored, and can be modified.
 * It's extended to ListenerAdapter due to the ReadyEvent used for the instance initialization.
 */
class Asuka : ListenerAdapter() {
    /**
     * Quick reminder : companion objects are jvm static objects.
     */
    companion object {

        /**
         * This is a non-exhaustive list of useful program arguments used by Asuka.
         *
         * --debug            Launch the bot un debug mode (allow debug commands, enable debug console and disable non debug events)
         * --no-events        Disable events
         * --invisible        Launch the bot in invisible.
         */
        private var isDebug = false
        private var isNoEvents = false
        private var isInvisible = false

        private lateinit var token: String
        private lateinit var ownerIds: List<String>
        private lateinit var motd: String

        private val commandModule = CommandModule()

        /**
         * The main method. This is where the arguments are defined, and the bot will be loaded. Everything will load here.
         */
        @JvmStatic fun main(args: Array<String>) {
            for(arg in args){
                when(arg){
                    "--debug" -> isDebug = true
                    "--no-events" -> isNoEvents = true
                    "--invisible" -> isInvisible = true
                }
            }

            /**
             * Once our arguments are defined, the config will be loaded.
             */
            startConfiguration()

            /**
             * There is the module manager configuration.
             */
            loadModules()

            /**
             * If the configuration passed and the modules loaded, it's time to JDA to start and run the bot.
             */
            startJDA()
        }

        /**
         * The configuration method. This is where all needed variables will be loaded for the bot.
         * The configuration file is in ini type. Use Ini4j for this project.
         */
        private fun startConfiguration() {
            ALogger.system("Loading configuration file...")

            val configFile = File("config.ini")

            if(!configFile.exists()){
                configFile.createNewFile()

                val iniConfigFile = Ini(configFile)
                iniConfigFile.put("configuration", "token", "insert token here")
                iniConfigFile.put("configuration", "owner_ids", "insert owner ids separated by a single space")
                iniConfigFile.put("configuration", "motd", "write a motd to display it on activity")
                iniConfigFile.store()

                ALogger.warning("Configuration file not found. Please refer to the newly one created and restart the bot.")

                exitProcess(-1)
            }

            val iniConfigFile = Ini(configFile)
            token = iniConfigFile.get("configuration", "token")
            ownerIds = iniConfigFile.get("configuration", "owner_ids").split(" ")
            motd = iniConfigFile.get("configuration", "motd")

            ALogger.system("Configuration loaded !")
            if(isDebug) ALogger.warning("Debug mode activated. Only debug content will work. Use it at your own risk.")
        }

        private fun loadModules(){
            ALogger.system("Loading modules...")
            var moduleManager = ModuleManager()

            moduleManager.registerModule(CacheModule())
            moduleManager.registerModule(commandModule)

            moduleManager.loadModules()
        }

        private fun startJDA() {
            val botInstance = JDABuilder.createDefault(token)
                .setActivity(Activity.streaming(motd, "https://twitch.tv/itzpeaxel"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(Asuka())
                .addEventListeners(commandModule)
                .build()
        }
    }
}