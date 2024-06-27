import kotlinx.datetime.toLocalDate
import model.Gender
import model.Role
import model.Time
import model.Worker
import model.WorkerPreference

fun main() {

    val notAvailableDatesOfWorkers = WorkerPreference(
        listOf(
            Triple("2024-07-2".toLocalDate(), Time.MORNING, "worker1"),
            Triple("2024-06-3".toLocalDate(), Time.AFTERNOON, "worker2"),
            Triple("2024-06-4".toLocalDate(), Time.NIGHT, "worker3"),
        )
    )

    val startDate = "2024-06-1".toLocalDate()
    val endDate = "2024-06-7".toLocalDate()

    val availableWorkers: List<Worker> = listOf(
        Worker(
            id = "worker1",
            name = "John",
            surname = "Doe",
            gender = Gender.MALE,
            type = Role.SENIOR
        ),
        Worker(
            id = "worker2",
            name = "Jane",
            surname = "Doe",
            gender = Gender.FEMALE,
            type = Role.SENIOR
        )
    )

    val solvedWeek = solveWeek(Week(), true)
}
