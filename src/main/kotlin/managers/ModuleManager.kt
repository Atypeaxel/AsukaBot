package managers

import utils.ALogger

class ModuleManager {

    private val modules = HashMap<String, IModule>()

    fun registerModule(module: IModule){
        if(modules.containsKey(module.name)) return
        modules[module.name] = module
    }

    fun loadModules(){
        for(module in modules){
            module.value.execution()
        }
        ALogger.system("Modules loaded : ${modules.size}")
    }
}

interface IModule{
    var name: String
    fun execution()
}