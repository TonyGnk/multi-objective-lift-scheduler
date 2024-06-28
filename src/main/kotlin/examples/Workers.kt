package examples

import model.Gender
import model.Role
import model.Worker

val workersPreSet: List<Worker> = listOf(
    Worker(id = "1", name = "Γιαννακοβίτης", gender = Gender.MALE, role = Role.SU),
    Worker(id = "2", name = "Καρυτόπουλος", gender = Gender.MALE, role = Role.SENIOR),
    Worker(id = "3", name = "Σιδηρόπουλος", gender = Gender.MALE, role = Role.SENIOR),
    Worker(id = "4", name = "Στογιάννου", gender = Gender.MALE, role = Role.SENIOR),
    Worker(id = "5", name = "Μαυροκεφαλίδου", gender = Gender.FEMALE, role = Role.STAFF),
    Worker(id = "6", name = "Γραμμένας", gender = Gender.MALE, role = Role.STAFF),
    Worker(id = "7", name = "Παπαστεγίου", gender = Gender.MALE, role = Role.STAFF),
    Worker(id = "8", name = "Συροπούλου", gender = Gender.FEMALE, role = Role.STAFF),
    Worker(id = "9", name = "Βασιλειάδη", gender = Gender.MALE, role = Role.STAFF),
    Worker(id = "10", name = "Λουκίδου", gender = Gender.FEMALE, role = Role.STAFF),
    Worker(id = "11", name = "Μαλλού", gender = Gender.FEMALE, role = Role.STAFF),
    Worker(id = "12", name = "Χατζοπούλου", gender = Gender.FEMALE, role = Role.STAFF)
)
