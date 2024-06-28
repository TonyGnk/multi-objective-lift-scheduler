package model

enum class Time(val next: String) {
    NIGHT("MORNING"),
    MORNING("AFTERNOON"),
    AFTERNOON("NIGHT")
}
