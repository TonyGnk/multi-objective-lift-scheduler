package test_rules

import Worker

fun test2PreventTheSameWorkerInTwoShifts() {
    val workers = Worker.ListOfWorkers
    for (worker in workers) {
        worker.print()
    }


}