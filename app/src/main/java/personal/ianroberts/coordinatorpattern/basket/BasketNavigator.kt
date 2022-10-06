package personal.ianroberts.coordinatorpattern.basket

import android.os.Parcelable
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinatorpattern.CoordinatorHost
import personal.ianroberts.coordinatorpattern.navigation.FlowNavigator
import javax.inject.Inject

@AndroidEntryPoint
class BasketNavigator : Fragment(), CoordinatorHost, FlowNavigator {

    @Inject
    override lateinit var coordinator: BasketCoordinator

    override fun <SCREEN : Parcelable> navigateTo(screen: SCREEN) {
        when (screen) {
            BasketFlowEvent.SayHello -> {}
        }
    }
}