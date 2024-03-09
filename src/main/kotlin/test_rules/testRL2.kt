package test_rules

import getWorkers

fun test2PreventTheSameWorkerInTwoShifts() {
    val workers = getWorkers()
    for (worker in workers) {
        worker.print()
    }
    
}