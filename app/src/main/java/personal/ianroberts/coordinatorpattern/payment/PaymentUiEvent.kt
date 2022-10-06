package personal.ianroberts.coordinatorpattern.payment

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class PaymentUiEvent : CoordinatorEvent {
    object SayHello : PaymentUiEvent()
}
