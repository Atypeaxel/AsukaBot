package utils

class ALogger {
    companion object{
        // Reset
        private const val RESET = "\u001b[0m" // Text Reset

        // Regular Colors
        private const val BLACK = "\u001b[0;30m" // BLACK
        private const val RED = "\u001b[0;31m" // RED

        private const val GREEN = "\u001b[0;32m" // GREEN
        private const val YELLOW = "\u001b[0;33m" // YELLOW
        private const val BLUE = "\u001b[0;34m" // BLUE
        private const val PURPLE = "\u001b[0;35m" // PURPLE
        private const val CYAN = "\u001b[0;36m" // CYAN
        private const val WHITE = "\u001b[0;37m" // WHITE

        // Bold
        private const val BLACK_BOLD = "\u001b[1;30m" // BLACK
        private const val RED_BOLD = "\u001b[1;31m" // RED
        private const val GREEN_BOLD = "\u001b[1;32m" // GREEN
        private const val YELLOW_BOLD = "\u001b[1;33m" // YELLOW
        private const val BLUE_BOLD = "\u001b[1;34m" // BLUE
        private const val PURPLE_BOLD = "\u001b[1;35m" // PURPLE
        private const val CYAN_BOLD = "\u001b[1;36m" // CYAN
        private const val WHITE_BOLD = "\u001b[1;37m" // WHITE

        // Underline
        private const val BLACK_UNDERLINED = "\u001b[4;30m" // BLACK
        private const val RED_UNDERLINED = "\u001b[4;31m" // RED
        private const val GREEN_UNDERLINED = "\u001b[4;32m" // GREEN
        private const val YELLOW_UNDERLINED = "\u001b[4;33m" // YELLOW
        private const val BLUE_UNDERLINED = "\u001b[4;34m" // BLUE
        private const val PURPLE_UNDERLINED = "\u001b[4;35m" // PURPLE
        private const val CYAN_UNDERLINED = "\u001b[4;36m" // CYAN
        private const val WHITE_UNDERLINED = "\u001b[4;37m" // WHITE

        // Background
        private const val BLACK_BACKGROUND = "\u001b[40m" // BLACK
        private const val RED_BACKGROUND = "\u001b[41m" // RED
        private const val GREEN_BACKGROUND = "\u001b[42m" // GREEN
        private const val YELLOW_BACKGROUND = "\u001b[43m" // YELLOW
        private const val BLUE_BACKGROUND = "\u001b[44m" // BLUE
        private const val PURPLE_BACKGROUND = "\u001b[45m" // PURPLE
        private const val CYAN_BACKGROUND = "\u001b[46m" // CYAN
        private const val WHITE_BACKGROUND = "\u001b[47m" // WHITE

        // High Intensity
        private const val BLACK_BRIGHT = "\u001b[0;90m" // BLACK
        private const val RED_BRIGHT = "\u001b[0;91m" // RED
        private const val GREEN_BRIGHT = "\u001b[0;92m" // GREEN
        private const val YELLOW_BRIGHT = "\u001b[0;93m" // YELLOW
        private const val BLUE_BRIGHT = "\u001b[0;94m" // BLUE
        private const val PURPLE_BRIGHT = "\u001b[0;95m" // PURPLE
        private const val CYAN_BRIGHT = "\u001b[0;96m" // CYAN
        private const val WHITE_BRIGHT = "\u001b[0;97m" // WHITE

        // Bold High Intensity
        private const val BLACK_BOLD_BRIGHT = "\u001b[1;90m" // BLACK
        private const val RED_BOLD_BRIGHT = "\u001b[1;91m" // RED
        private const val GREEN_BOLD_BRIGHT = "\u001b[1;92m" // GREEN
        private const val YELLOW_BOLD_BRIGHT = "\u001b[1;93m" // YELLOW
        private const val BLUE_BOLD_BRIGHT = "\u001b[1;94m" // BLUE
        private const val PURPLE_BOLD_BRIGHT = "\u001b[1;95m" // PURPLE
        private const val CYAN_BOLD_BRIGHT = "\u001b[1;96m" // CYAN
        private const val WHITE_BOLD_BRIGHT = "\u001b[1;97m" // WHITE

        // High Intensity backgrounds
        private const val BLACK_BACKGROUND_BRIGHT = "\u001b[0;100m" // BLACK
        private const val RED_BACKGROUND_BRIGHT = "\u001b[0;101m" // RED
        private const val GREEN_BACKGROUND_BRIGHT = "\u001b[0;102m" // GREEN
        private const val YELLOW_BACKGROUND_BRIGHT = "\u001b[0;103m" // YELLOW
        private const val BLUE_BACKGROUND_BRIGHT = "\u001b[0;104m" // BLUE
        private const val PURPLE_BACKGROUND_BRIGHT = "\u001b[0;105m" // PURPLE
        private const val CYAN_BACKGROUND_BRIGHT = "\u001b[0;106m" // CYAN
        private const val WHITE_BACKGROUND_BRIGHT = "\u001b[0;107m" // WHITE

        fun system(msg: String){
            println("$BLUE_BOLD[SYSTEM]$RESET $msg")
        }

        fun log(msg: String){
            println("$GREEN_BOLD[LOG]$RESET $msg")
        }

        fun error(msg: String){
            println("$RED_BOLD_BRIGHT[ERROR]$RED $msg")
        }

        fun debug(msg: String){
            println("$PURPLE_BOLD_BRIGHT[DEBUG]$PURPLE $msg")
        }

        fun warning(msg: String){
            println("$YELLOW_BOLD[WARNING]$RESET $msg")
        }
    }
}