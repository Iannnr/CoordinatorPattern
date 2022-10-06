package personal.ianroberts.coordinatorpattern.basket

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class BasketFlowEvent : CoordinatorEvent {
    object SayHello : BasketFlowEvent()
}
