package personal.ianroberts.coordinatorpattern.appointment

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class AppointmentFlowEvent : CoordinatorEvent {
    object SayHello : AppointmentFlowEvent()
}
