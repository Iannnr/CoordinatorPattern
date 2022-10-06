package personal.ianroberts.coordinatorpattern.basket

import dagger.hilt.android.scopes.FragmentScoped
import personal.ianroberts.coordinatorpattern.BaseViewModel
import personal.ianroberts.coordinatorpattern.address.AddressUiEvent
import personal.ianroberts.coordinatorpattern.navigation.Coordinator
import personal.ianroberts.coordinatorpattern.navigation.FlowNavigator
import javax.inject.Inject

@FragmentScoped
class BasketCoordinator @Inject constructor(
    private val flowNavigator: FlowNavigator
) : Coordinator<BasketFlowEvent> {

    override fun onStart() {
        flowNavigator.navigateTo(BasketFlowEvent.SayHello)
    }

    override fun onEvent(event: Any, screen: Any) {
        when (event) {
            AddressUiEvent.SayHello -> flowNavigator.navigateTo(BasketFlowEvent.SayHello)
        }
    }
}