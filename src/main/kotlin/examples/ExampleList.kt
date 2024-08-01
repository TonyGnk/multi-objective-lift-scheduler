package examples

import com.tonyGnk.core.model.scheduler.SearchInput
import com.tonyGnk.core.model.scheduler.numberOfRangesMapPreset
import com.tonyGnk.core.model.time.Moment
import com.tonyGnk.core.model.time.Time
import com.tonyGnk.core.model.worker.workersPreSet
import kotlinx.datetime.toLocalDate

val exampleOneDay = SearchInput(
    start = Moment("2024-07-01".toLocalDate(), Time.NIGHT),
    end = Moment("2024-07-01".toLocalDate(), Time.AFTERNOON),
    workers = workersPreSet.toMutableList(),
    numberOfRangesMap = numberOfRangesMapPreset
)

val exampleTwoDays = SearchInput(
    start = Moment("2024-07-02".toLocalDate(), Time.NIGHT),
    end = Moment("2024-07-03".toLocalDate(), Time.AFTERNOON),
    workers = workersPreSet.toMutableList(),
    numberOfRangesMap = numberOfRangesMapPreset
)
