fun toHours(seconds: Int): Int {
    return seconds / 3600
}

fun toMinutes(seconds: Int): Int {
    return seconds / 60
}

fun minutesToText(seconds: Int): String {
    var minutes = toMinutes(seconds)
    return when (minutes) {
        1, 21, 31, 41, 51 -> "$minutes минуту назад"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 ->"$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursToText(seconds: Int): String {
    var hours = toHours(seconds)
    return when (hours) {
        1, 21 -> "$hours час назад"
        2, 3, 4, 22 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "$USER_1 \nбыл(а) только что"
        in 61..3600 -> "$USER_2 \nбыл(а) " + minutesToText(seconds)
        in 3601..86400 -> "$USER_3 \nбыл(а) в сети " + hoursToText(seconds)
        in 86401..172800 -> "$USER_4 \nбыла(а) сегодня"
        in 172801..259200 -> "$USER_5 \nбыл(а) вчера"
        else -> "$USER_6 \nбыл(а) давно"
    }
}

const val USER_1 = "Вася"
const val USER_2 = "Женя"
const val USER_3 = "Олег"
const val USER_4 = "Аркадий"
const val USER_5 = "Алиса"
const val USER_6 = "DeanWinchester"

fun main() {
    print(agoToText(333))
}