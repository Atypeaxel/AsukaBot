package itz.peaxel.asuka.core

import itz.peaxel.asuka.Asuka
import itz.peaxel.asuka.core.managers.CommandManager
import itz.peaxel.asuka.core.managers.JDAManager
import itz.peaxel.asuka.core.managers.ModuleManager
import itz.peaxel.asuka.utils.ALogger
import org.ini4j.Ini
import java.io.File

/**
 * This is our configuration class. This class is not an object because it needs to be declared as a new object.
 */
class AConfiguration {

    private val logger = ALogger(this::class.java.simpleName)

    /**
     * This is our important variables. Without them, the bot will not or badly work.
     * There is our token, the bot secret credential, an motd for the status and an owner id list
     */
    private lateinit var token: String
    lateinit var motd: String
    lateinit var ownerIds: List<String>

    /**
     * This variable define the version of the program and the bot.
     */
    val version: String
        get() = "0.2.0 BETA-1"

    /**
     * This init method is used to create and retrieve file configurations in order to not hardcode sensible content in the program.
     */
    fun init(){

        /**
         * Our config file is initialized with the File() object.
         * For handling, the Ini() objet is declared in order to easily manage file information
         */
        val configFile = File("config.ini")

        if(!configFile.exists()){
            logger.error("Config file not found ! Creating file...\n-----> Please configure the newly created one.")
            val ini = Ini(configFile)
            ini.put("configuration", "token", "insert token here")
            ini.put("configuration", "owner_ids", "insert owner ids separated by a space here")
            ini.put("configuration", "motd", "insert an motd here")
            ini.store()
            Asuka.stop()
        }

        logger.system("Loading needed variables...")
        val ini = Ini(configFile)

        token = ini.get("configuration", "token")
        ownerIds = ini.get("configuration", "owner_ids").split(" ")
        motd = ini.get("configuration", "motd")
    }

    /**
     * This method is called after the init method only if it passed.
     * This is where JDA, modules and commands will be loaded in order to setup the bot online.
     */
    fun load(){

        logger.system("Loading JDA...")
        JDAManager.startJda(token, motd)
        logger.system("Loading CommandManager...")
        CommandManager.loadCommands()
        logger.system("Loading ModuleManager...")
        ModuleManager.startModules()
    }

    /**
     * This method is created in order to store information at the end oh the program.
     * This one will be used later.
     */
    fun save(){
        logger.system("Saving configuration...")
        val configFile = File("config.ini")
    }
}