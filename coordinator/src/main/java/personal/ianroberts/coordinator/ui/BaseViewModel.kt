package personal.ianroberts.coordinator.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    /**
     * Using a Channel to control navigation via a Send & Receive channel
     * [BUFFERED] capacity meaning that it will suspend any pending events until consumed so we can sure that can send up to 64 events in safe manner
     */
    private val _events = Channel<Any>(BUFFERED)
    val events = _events.receiveAsFlow()

    /**
     * restrict visibility so that only ViewModels implementation this can send a [personal.ianroberts.coordinator.CoordinatorEvent]
     * to follow the Unidirectional Data Flow of this pattern.
     * Suggestion is for implementing classes to provide an idiomatic interface over just calling [sendCoordinatorEvent]
     * ```
     * class BaseViewModelImpl(): BaseViewModel {
     *   fun sayHello() = sendCoordinatorEvent(UiEvent.SayHello)
     *   fun sayGoodbye() = sendCoordinatorEvent(UiEvent.SayGoodbye)
     * }
     * ```
     * instead of doing
     * ```
     * class BaseViewModelImpl(): BaseViewModel {
     *   fun sendCoordinatorEvent(event: UiEvent.SayHello) = sendCoordinatorEvent(event)
     * }
     * ```
     */
    fun sendCoordinatorEvent(event: Any) = viewModelScope.launch {
        _events.send(event)
    }
}