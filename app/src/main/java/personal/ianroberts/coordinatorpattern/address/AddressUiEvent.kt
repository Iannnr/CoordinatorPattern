package personal.ianroberts.coordinatorpattern.address

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class AddressUiEvent : CoordinatorEvent {
    object SayHello : AddressUiEvent()
}
