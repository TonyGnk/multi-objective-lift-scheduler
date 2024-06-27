package model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class Range(initialWorkers: List<Worker>) {

    private val workers = MutableStateFlow<List<Worker>>(initialWorkers)

    fun isFixed(): Boolean = workers.value.size == 1

    fun removeWorker(workerId: String) {
        workers.update {
            it.filter { worker -> worker.id != workerId }
        }
    }

    fun getFirstWorkerId(): String {
        return workers.value.first().id
    }


    fun canBeFixedWorker(id: String): Boolean {
        //val dayOfRule: Boolean = workersRemainingWorkTimes[id] > 0
        val genderRuleA: Boolean = exists(Gender.MALE)
        val genderRuleB: Boolean = exists(Gender.FEMALE)

        return genderRuleA && genderRuleB
    }

    fun setFixedWorker(fixedWorkerId: String) {
        workers.update {
            it.filter { worker -> worker.id == fixedWorkerId }
        }
        //val currentTimes: Int = workersRemainingWorkTimes[fixedWorkerId]
        //TODO workersRemainingWorkTimes[fixedWorkerId] = currentTimes - 1
    }


    fun getSeniorWorkers(): List<String> {
        return workers.value.filter { worker -> worker.type == Role.SENIOR }
            .map { worker -> worker.id }
    }

    fun <T> exists(attribute: T): Boolean {
        val workerList = workers.value
        return workerList.any { worker ->
            when (attribute) {
                is Gender -> worker.gender == attribute
                is Role -> worker.type == attribute
                is String -> worker.id == attribute
                else -> {
                    throw IllegalArgumentException("Attribute not supported")
                }
            }
        }
    }

    fun collectWorkersWithGender(gender: Gender): List<String> {
        return workers.value.filter { worker ->
            worker.gender == gender
        }.map { worker -> worker.id }
    }

//
//    fun print() {
//        println(ids)
//    }
//
//    val ids: StringBuilder
//        get() {
//            return combineIds(this)
//        }
}
