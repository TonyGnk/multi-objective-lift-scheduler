package model


data class Worker(
    val id: String,
    val name: String,
    val surname: String,
    val gender: Gender,
    val type: Role,
)
