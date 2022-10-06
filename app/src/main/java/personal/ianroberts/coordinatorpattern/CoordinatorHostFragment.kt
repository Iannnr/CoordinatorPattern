package personal.ianroberts.coordinatorpattern

import personal.ianroberts.coordinatorpattern.navigation.Coordinator

interface CoordinatorHost {
    val coordinator: Coordinator<*>
}