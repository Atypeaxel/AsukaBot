package itz.peaxel.asuka

import itz.peaxel.asuka.core.AConfiguration
import itz.peaxel.asuka.utils.ALogger
import kotlin.system.exitProcess

/**
 * This this our main class.
 * This class is declared as an object to use every functions and variable everywhere as static objects.
 *
 * @author ItzPeaxel
 */
object Asuka {

    /**
     * We need to create a new instance of the configuration to avoid static and objects incomprehension
     */
    val config = AConfiguration()

    /**
     * This is the logger utility. It need to be initialized at every classes or objects for a better console naming.
     */
    private val logger = ALogger(this::class.java.simpleName)

    /**
     * Theses variable is a program startup argument.
     *  A when condition was declared in the start method to implement more settings in the future.
     */
    var isSigma = false

    /**
     * This is our entry method used in the main method at the end of this file. This is where program argument are declared and the bot will be fully operational.
     * @see AConfiguration for more information.
     */
    private fun start(args: Array<String>) {

        for (arg in args) {
            when (arg) {
                "-sigma" -> {
                    isSigma = true
                    logger.warning("Sigma is enabled ! Asuka will not work as usual, and bugs may appear.")
                    logger.debug("All sigma functionalities are unlocked. Continue at your own risk.")
                }
            }
        }

        logger.system("Starting config initialization...")
        config.init()

        logger.system("Starting config loading...")
        config.load()
        println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")
        logger.system("Asuka v.${config.version} is ready to use ! type 'help' for fore infos !")
        println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-")
    }

    /**
     * This is the stop method. Use this method from anywhere to shutdown the program.
     */
    fun stop() {
        logger.warning("Asuka's running process shutting down. Saving...")
        config.save()
        exitProcess(0)
    }

    /**
     * This is our main method. The JVM will start the program here.
     */
    @JvmStatic
    fun main(args: Array<String>) {
        start(args)
    }
}