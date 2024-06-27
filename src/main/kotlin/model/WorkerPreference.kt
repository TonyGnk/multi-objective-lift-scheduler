package model

import kotlinx.datetime.LocalDate

data class WorkerPreference(
    val notAvailableDates: List<Triple<LocalDate, Time, String>>,
)
