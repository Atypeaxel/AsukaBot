package itz.peaxel.asuka.utils

import itz.peaxel.asuka.Asuka

class ALogger(cn: String){

        private var className = cn

        // Reset
        private val RESET = "\u001b[0m" // Text Reset

        // Regular Colors
        private val BLACK = "\u001b[0;30m" // BLACK
        private val RED = "\u001b[0;31m" // RED

        private val GREEN = "\u001b[0;32m" // GREEN
        private val YELLOW = "\u001b[0;33m" // YELLOW
        private val BLUE = "\u001b[0;34m" // BLUE
        private val PURPLE = "\u001b[0;35m" // PURPLE
        private val CYAN = "\u001b[0;36m" // CYAN
        private val WHITE = "\u001b[0;37m" // WHITE

        // Bold
        private val BLACK_BOLD = "\u001b[1;30m" // BLACK
        private val RED_BOLD = "\u001b[1;31m" // RED
        private val GREEN_BOLD = "\u001b[1;32m" // GREEN
        private val YELLOW_BOLD = "\u001b[1;33m" // YELLOW
        private val BLUE_BOLD = "\u001b[1;34m" // BLUE
        private val PURPLE_BOLD = "\u001b[1;35m" // PURPLE
        private val CYAN_BOLD = "\u001b[1;36m" // CYAN
        private val WHITE_BOLD = "\u001b[1;37m" // WHITE

        // Underline
        private val BLACK_UNDERLINED = "\u001b[4;30m" // BLACK
        private val RED_UNDERLINED = "\u001b[4;31m" // RED
        private val GREEN_UNDERLINED = "\u001b[4;32m" // GREEN
        private val YELLOW_UNDERLINED = "\u001b[4;33m" // YELLOW
        private val BLUE_UNDERLINED = "\u001b[4;34m" // BLUE
        private val PURPLE_UNDERLINED = "\u001b[4;35m" // PURPLE
        private val CYAN_UNDERLINED = "\u001b[4;36m" // CYAN
        private val WHITE_UNDERLINED = "\u001b[4;37m" // WHITE

        // Background
        private val BLACK_BACKGROUND = "\u001b[40m" // BLACK
        private val RED_BACKGROUND = "\u001b[41m" // RED
        private val GREEN_BACKGROUND = "\u001b[42m" // GREEN
        private val YELLOW_BACKGROUND = "\u001b[43m" // YELLOW
        private val BLUE_BACKGROUND = "\u001b[44m" // BLUE
        private val PURPLE_BACKGROUND = "\u001b[45m" // PURPLE
        private val CYAN_BACKGROUND = "\u001b[46m" // CYAN
        private val WHITE_BACKGROUND = "\u001b[47m" // WHITE

        // High Intensity
        private val BLACK_BRIGHT = "\u001b[0;90m" // BLACK
        private val RED_BRIGHT = "\u001b[0;91m" // RED
        private val GREEN_BRIGHT = "\u001b[0;92m" // GREEN
        private val YELLOW_BRIGHT = "\u001b[0;93m" // YELLOW
        private val BLUE_BRIGHT = "\u001b[0;94m" // BLUE
        private val PURPLE_BRIGHT = "\u001b[0;95m" // PURPLE
        private val CYAN_BRIGHT = "\u001b[0;96m" // CYAN
        private val WHITE_BRIGHT = "\u001b[0;97m" // WHITE

        // Bold High Intensity
        private val BLACK_BOLD_BRIGHT = "\u001b[1;90m" // BLACK
        private val RED_BOLD_BRIGHT = "\u001b[1;91m" // RED
        private val GREEN_BOLD_BRIGHT = "\u001b[1;92m" // GREEN
        private val YELLOW_BOLD_BRIGHT = "\u001b[1;93m" // YELLOW
        private val BLUE_BOLD_BRIGHT = "\u001b[1;94m" // BLUE
        private val PURPLE_BOLD_BRIGHT = "\u001b[1;95m" // PURPLE
        private val CYAN_BOLD_BRIGHT = "\u001b[1;96m" // CYAN
        private val WHITE_BOLD_BRIGHT = "\u001b[1;97m" // WHITE

        // High Intensity backgrounds
        private val BLACK_BACKGROUND_BRIGHT = "\u001b[0;100m" // BLACK
        private val RED_BACKGROUND_BRIGHT = "\u001b[0;101m" // RED
        private val GREEN_BACKGROUND_BRIGHT = "\u001b[0;102m" // GREEN
        private val YELLOW_BACKGROUND_BRIGHT = "\u001b[0;103m" // YELLOW
        private val BLUE_BACKGROUND_BRIGHT = "\u001b[0;104m" // BLUE
        private val PURPLE_BACKGROUND_BRIGHT = "\u001b[0;105m" // PURPLE
        private val CYAN_BACKGROUND_BRIGHT = "\u001b[0;106m" // CYAN
        private val WHITE_BACKGROUND_BRIGHT = "\u001b[0;107m" // WHITE

        fun system(msg: String) {
                println("$BLUE_BOLD[SYSTEM] [$className]$RESET $msg")
        }

        fun log(msg: String) {
                println("$GREEN_BOLD[LOG] [$className]$RESET $msg")
        }

        fun error(msg: String) {
                println("$RED_BOLD_BRIGHT[ERROR] [$className]$RED $msg")
        }

        fun debug(msg: String) {
                if(!Asuka.getSigma) return
                println("$PURPLE_BOLD_BRIGHT[DEBUG] [$className]$PURPLE $msg")
        }

        fun warning(msg: String) {
                println("$YELLOW_BOLD[WARNING] [$className]$RESET $msg")
        }

        fun terminal(msg: String) {
                println("$CYAN_BOLD[TERMINAL] [$className]$RESET $msg")
        }
}