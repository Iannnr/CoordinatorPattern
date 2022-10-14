package personal.ianroberts.coordinatorpattern.payment

import dagger.hilt.android.scopes.FragmentScoped
import personal.ianroberts.coordinator.Coordinator
import personal.ianroberts.coordinator.navigator.FlowNavigator
import javax.inject.Inject

@FragmentScoped
class PaymentCoordinator @Inject constructor(
    private val flowNavigator: FlowNavigator
) : Coordinator<PaymentFlowEvent> {

    override fun onStart() {
        flowNavigator.navigateTo(PaymentFlowEvent.SayHello)
    }

    override fun onEvent(event: Any, screen: Any) {}
}