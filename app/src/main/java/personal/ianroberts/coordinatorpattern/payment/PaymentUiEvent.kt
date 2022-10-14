package personal.ianroberts.coordinatorpattern.payment

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class PaymentUiEvent : CoordinatorEvent {
    data class SayHello(val paymentMethod: String) : PaymentUiEvent()
}
