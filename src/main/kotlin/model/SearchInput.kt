package model

import kotlinx.datetime.DayOfWeek

data class SearchInput(
    val start: Moment,
    val end: Moment,
    val workers: MutableList<Worker>,
    val numberOfRangesMap: Map<Pair<DayOfWeek, Time>, Int>
)
