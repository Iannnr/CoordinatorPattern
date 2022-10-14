package personal.ianroberts.coordinatorpattern.screens.address

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinatorpattern.navigation.CoordinatorEvent

@Parcelize
sealed class AddressUiEvent : CoordinatorEvent {
    data class SelectAddress(val address: String) : AddressUiEvent()
    object CreateAddress: AddressUiEvent()
}
