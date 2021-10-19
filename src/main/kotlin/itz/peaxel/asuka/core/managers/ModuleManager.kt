package itz.peaxel.asuka.core.managers

import itz.peaxel.asuka.modules.TerminalModule
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.dv8tion.jda.api.JDA

object ModuleManager {

    val modulesMap = HashMap<String, IModule>()

    fun startModules(){
        loadModules()
        for(module in modulesMap){
            GlobalScope.launch {
                module.value.execution(JDAManager.instance)
            }
        }
    }

    private fun loadModules(){
        registerModule(TerminalModule())
    }

    private fun registerModule(module: IModule){
        if(modulesMap.containsKey(module.name)) return
        modulesMap[module.name] = module
    }
}

interface IModule{
    fun execution(jda: JDA)
    val name: String
    val sigma: Boolean
}