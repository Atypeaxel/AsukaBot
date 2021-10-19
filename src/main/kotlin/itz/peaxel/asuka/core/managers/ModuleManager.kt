package itz.peaxel.asuka.core.managers

import itz.peaxel.asuka.Asuka
import itz.peaxel.asuka.modules.TerminalModule
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.dv8tion.jda.api.JDA

/**
 * As it named, this is the module manager object class
 */
object ModuleManager {

    /**
     * This is the module map, where every modules is stored after being registered.
     */
    val modulesMap = HashMap<String, IModule>()

    /**
     * In order to not block on the code at each modules startup, a Coroutine is created to create multiple threads and use modules asynchronously.
     */
    fun startModules(){
        loadModules()
        for(module in modulesMap){
            GlobalScope.launch {
                if(!module.value.sigma && Asuka.isSigma) return@launch

                module.value.execution(JDAManager.instance)
            }
        }
    }

    /**
     * Just a simple method where every registered modules is declared
     */
    private fun loadModules(){
        registerModule(TerminalModule())
    }

    /**
     * The map's registration method.
     */
    private fun registerModule(module: IModule){
        if(modulesMap.containsKey(module.name)) return
        modulesMap[module.name] = module
    }
}

/**
 * This is the module Interface. Every created modules implemented of this interface will use theses variables and method.
 */
interface IModule{
    fun execution(jda: JDA)
    val name: String
    val sigma: Boolean
}