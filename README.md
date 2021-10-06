# AsukaBot - A simple Kotlin Discord Bot

The Discord bot of the serber, a private Discord server. Asuka is a Discord But running on the JDA API but made in kotlin. Asuka support ini configuration file, local modules and slash commands.

### Configuration
___
As you see, Asuka use a INI configuration file with the api Init4j, and you configuration file should be like this :
```ini
[configuration]
token = Insert your token here
owner_ids = Owner ids are here separated by a simple space (like this " ")
motd = A useless status for the bot
```
If you don't know how to read the code, just launch it with gradle (type `./gradlew run` in terminal) and the config file shloud be created on the first boot.

Also, there is some arguments used by Asuka to run with different configurations :

Arguments | Definition
--- | ---
--sigma | Launch the bot in sigma mode (aka debug mode). This mode disable non debug events, such as modules and some commands. Also activate debug console and authorize use of debug commands.
--no-events | Disable all non system events, such as almost all ListenerAdapter() events.
--invisible | Launch the bot in invisible mode. Can be used with `--sigma` for incognito debugging. 

### The Module Manager
___
The module manager is a simple module class with a module handler and interface. the module manager can manage simple module class at bot startup, for cache, logging, commands, or anything else. To create a command, you need to implement your newly created class to `IModule` and import all needed methods and variables. Once your module created, you just simply need to initialize it on the main class on `Asuka.kt` in the `loadModules()` 

A correct module with no extra functions should look like this : 

```kotlin
package modules

import managers.IModule

class TestModule : IModule {
    
    override var name: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun execution() {
        TODO("Not yet implemented")
    }
}
```

Member | Description
--- | ---
name | The name of the module, initialized in the `get()` assignation
execution | The method used as main module method. You are free to create more method in order to evolve your module.

### The Command Module
___
The command module is the main command class handler and interface. It also support the use for slash commands, but only for one guild (You can change this guild ID, just by replacing the hardcoded one in the `modules.CommandModule.tk` class).

In order to make a command, just like Modules, you have to create a class implemented by the `ICommand` interface.

A correct command class should look like this : 

```kotlin
package commands

import modules.CommandOption
import modules.CommandType
import modules.ICommand
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent

class TestCmd : ICommand {
    override var name: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var description: String
        get() = TODO("Not yet implemented")
        set(value) {}

    override var type: CommandType
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun execution(event: SlashCommandEvent) {
        TODO("Not yet implemented")
    }

    override fun options(): HashMap<CommandOption, Boolean> {
        TODO("Not yet implemented")
    }
}
```
Let me explain you what you have to do if you are lost : 

Member | Definition 
--- | ---
name | As you see, it's the name of the command. write it without upper case, because it's case sensitive.
description | The description of the command, who will be displayed on discord when you type the command.
type | The type of the command. The type will be one of the `CommandType` types.
execution | There is where your command code will be. There is a event variable containing the SlashCommand event. You are free to create and use other methods or variables in order to evolve your command.
options | The option method is kinda special. You have to return a `HashMap` with a `CommandOption` in key and a `Boolean` in `value`. The `CommandOption` is the class created to handle Slash commands options. You have to create a new variable of its type, and initialize the `type` (with `OptionType` enum), the `name` and the `desctiption`. Once you do that, you have to put your `CommandOption` in the returned `Hashmap`. The `Boolean` value is the `setRequired` method needed by JDA. set `true` if the option is required.

### Installation 
___
Everything is in the gradle configuration files. All you need to do is know how to use gradle ! 

### Contribution
___
If you want to contribute to the project, you can give it a star or discuss on it with suggestions, or reports ! 

Thank you all ! <3 