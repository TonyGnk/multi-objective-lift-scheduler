package examples

import com.tonyGnk.core.model.worker.Gender
import com.tonyGnk.core.model.worker.Role
import com.tonyGnk.core.model.worker.Worker

val workersPreSet: List<Worker> = listOf(
    Worker(
        id = "1",
        name = "John",
        surname = "Williams",
        gender = Gender.MALE,
        role = Role.SU
    ),
    Worker(
        id = "2",
        name = "Jane",
        surname = "Martinez",
        gender = Gender.FEMALE,
        role = Role.SENIOR
    ),
    Worker(
        id = "3",
        name = "Michael",
        surname = "Worcestershire",
        gender = Gender.MALE,
        role = Role.SENIOR
    ),
    Worker(
        id = "4",
        name = "Emily",
        surname = "Johnson",
        gender = Gender.FEMALE,
        role = Role.SENIOR
    ),
    Worker(
        id = "5",
        name = "Doe",
        surname = "Williams",
        gender = Gender.MALE,
        role = Role.STAFF
    ),
    Worker(
        id = "6",
        name = "Sophia",
        surname = "Brown",
        gender = Gender.FEMALE,
        role = Role.STAFF
    ),
    Worker(
        id = "7",
        name = "James",
        surname = "Jones",
        gender = Gender.MALE,
        role = Role.STAFF
    ),
    Worker(
        id = "8",
        name = "Olivia",
        surname = "Garcia",
        gender = Gender.FEMALE,
        role = Role.STAFF
    ),
    Worker(
        id = "9",
        name = "Ethan",
        surname = "Smith",
        gender = Gender.MALE,
        role = Role.STAFF
    ),
    Worker(
        id = "10",
        name = "Mia",
        surname = "Hernandez",
        gender = Gender.FEMALE,
        role = Role.STAFF
    ),
    Worker(
        id = "11",
        name = "Alexander",
        surname = "Lopez",
        gender = Gender.MALE,
        role = Role.STAFF
    ),
    Worker(
        id = "12",
        name = "Ava",
        surname = "Wilson",
        gender = Gender.FEMALE,
        role = Role.STAFF
    )
)
