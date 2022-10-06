package personal.ianroberts.coordinatorpattern.consultation

import dagger.hilt.android.scopes.FragmentScoped
import personal.ianroberts.coordinatorpattern.BaseViewModel
import personal.ianroberts.coordinatorpattern.card.CardUiEvent
import personal.ianroberts.coordinatorpattern.navigation.Coordinator
import personal.ianroberts.coordinatorpattern.navigation.FlowNavigator
import java.lang.Exception
import javax.inject.Inject

@FragmentScoped
class ConsultationCoordinator @Inject constructor(
    private val flowNavigator: FlowNavigator
) : Coordinator<ConsultationFlowEvent> {

    init {
        onStart()
    }

    override fun onStart() {
        flowNavigator.navigateTo(ConsultationFlowEvent.SayHello)
    }

    override fun onEvent(event: Any, screen: Any) {
        when (event) {
            CardUiEvent.SayHello -> flowNavigator.navigateTo(ConsultationFlowEvent.SayHello)
        }
    }
}