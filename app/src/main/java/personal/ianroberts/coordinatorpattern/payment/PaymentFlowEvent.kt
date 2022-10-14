package personal.ianroberts.coordinatorpattern.payment

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinator.CoordinatorEvent

@Parcelize
sealed class PaymentFlowEvent : CoordinatorEvent {
    object SayHello : PaymentFlowEvent()
}
