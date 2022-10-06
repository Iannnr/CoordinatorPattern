package personal.ianroberts.coordinatorpattern.appointment

import dagger.hilt.android.scopes.FragmentScoped
import personal.ianroberts.coordinatorpattern.BaseViewModel
import personal.ianroberts.coordinatorpattern.navigation.Coordinator
import personal.ianroberts.coordinatorpattern.navigation.FlowNavigator
import javax.inject.Inject

@FragmentScoped
class AppointmentCoordinator @Inject constructor(
    private val flowNavigator: FlowNavigator
) : Coordinator<AppointmentFlowEvent> {

    override fun onStart() {
        flowNavigator.navigateTo(AppointmentFlowEvent.SayHello)
    }

    override fun onEvent(event: Any, screen: Any) {
        TODO("Not yet implemented")
    }

}