package personal.ianroberts.coordinatorpattern.queue

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class QueueUiEvent : CoordinatorEvent {
    object SayHello : QueueUiEvent()
}
