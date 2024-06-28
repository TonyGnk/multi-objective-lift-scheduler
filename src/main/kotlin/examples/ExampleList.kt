package examples

import kotlinx.datetime.toLocalDate
import model.Moment
import model.SearchInput
import model.Time

val exampleOneDay = SearchInput(
    start = Moment("2024-07-01".toLocalDate(), Time.NIGHT),
    end = Moment("2024-07-01".toLocalDate(), Time.AFTERNOON),
    workers = workersPreSet.toMutableList(),
    numberOfRangesMap = numberOfRangesMap
)

val exampleTwoDays = SearchInput(
    start = Moment("2024-07-02".toLocalDate(), Time.NIGHT),
    end = Moment("2024-07-03".toLocalDate(), Time.AFTERNOON),
    workers = workersPreSet.toMutableList(),
    numberOfRangesMap = numberOfRangesMap
)
