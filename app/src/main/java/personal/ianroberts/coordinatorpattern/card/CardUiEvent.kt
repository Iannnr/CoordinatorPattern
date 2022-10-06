package personal.ianroberts.coordinatorpattern.card

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class CardUiEvent : CoordinatorEvent {
    object SayHello : CardUiEvent()
}
