package personal.ianroberts.coordinatorpattern.card

import dagger.hilt.android.lifecycle.HiltViewModel
import personal.ianroberts.coordinatorpattern.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
) : BaseViewModel() {

    fun sayHello() = sendCoordinatorEvent(CardUiEvent.SayHello)
}