package personal.ianroberts.coordinatorpattern.consultation

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinatorpattern.CoordinatorHost
import personal.ianroberts.coordinatorpattern.R
import personal.ianroberts.coordinatorpattern.card.CardFragment
import personal.ianroberts.coordinatorpattern.databinding.FragmentHeadlessBinding
import personal.ianroberts.coordinatorpattern.navigation.FlowNavigator
import javax.inject.Inject

@AndroidEntryPoint
class ConsultationNavigator : Fragment(R.layout.fragment_headless), CoordinatorHost, FlowNavigator {

    @Inject
    override lateinit var coordinator: ConsultationCoordinator

    private var _binding: FragmentHeadlessBinding? = null
    private val binding get() = _binding!!

    override fun <SCREEN : Parcelable> navigateTo(screen: SCREEN) {
        when (screen) {
            ConsultationFlowEvent.SayHello -> childFragmentManager.commit {
                setTransition(TRANSIT_FRAGMENT_OPEN)
                replace(R.id.root, CardFragment.newInstance(), "$screen")
            }
        }
    }
}