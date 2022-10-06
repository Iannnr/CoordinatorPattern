package personal.ianroberts.coordinatorpattern.consultation

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class ConsultationFlowEvent : CoordinatorEvent {
    object SayHello : ConsultationFlowEvent()
}
