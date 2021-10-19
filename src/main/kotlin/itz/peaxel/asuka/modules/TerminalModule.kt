package itz.peaxel.asuka.modules

import itz.peaxel.asuka.Asuka
import itz.peaxel.asuka.core.managers.IModule
import itz.peaxel.asuka.utils.ALogger
import net.dv8tion.jda.api.JDA

class TerminalModule: IModule {

    private val logger = ALogger(this::class.java.simpleName)

    override fun execution(jda: JDA) {

        while(true){
            val input = readLine()

            when(input.toString().lowercase()){
                "help" -> {
                    logger.terminal("Asuka v${Asuka.config.version} made by ItzPeaxel !")
                    logger.terminal("All available CLI commands: help, stop, version")
                }

                "stop" -> {
                    logger.terminal("Shutting down !")
                    Asuka.stop()
                }

                "version" -> {
                    logger.terminal("Asuka is running on version ${Asuka.config.version} !")
                    logger.terminal("Sigma status (beta with limited features) is ${Asuka.isSigma}")
                    logger.debug("Sigma test. If this text is visible, everything is working fine.")
                }
            }
        }
    }

    override val name: String
        get() = "Terminal"
    override val sigma: Boolean
        get() = true
}