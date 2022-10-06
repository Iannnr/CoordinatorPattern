package personal.ianroberts.coordinatorpattern.appointment

import android.os.Parcelable
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinatorpattern.CoordinatorHost
import personal.ianroberts.coordinatorpattern.navigation.FlowNavigator
import javax.inject.Inject

@AndroidEntryPoint
class AppointmentNavigator : Fragment(), CoordinatorHost, FlowNavigator {

    @Inject
    override lateinit var coordinator: AppointmentCoordinator

    override fun <SCREEN : Parcelable> navigateTo(screen: SCREEN) {
        TODO("Not yet implemented")
    }
}