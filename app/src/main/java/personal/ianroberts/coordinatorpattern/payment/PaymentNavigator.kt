package personal.ianroberts.coordinatorpattern.payment

import android.os.Parcelable
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinator.ui.NavigatorFragment
import personal.ianroberts.coordinatorpattern.R
import javax.inject.Inject

@AndroidEntryPoint
class PaymentNavigator : NavigatorFragment(R.layout.fragment_container) {

    @Inject
    override lateinit var coordinator: PaymentCoordinator

    override fun <SCREEN : Parcelable> navigateTo(screen: SCREEN) {}
}