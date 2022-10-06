package personal.ianroberts.coordinatorpattern.ui.main

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinatorpattern.CoordinatorHost
import personal.ianroberts.coordinatorpattern.R
import personal.ianroberts.coordinatorpattern.appointment.AppointmentCoordinator
import personal.ianroberts.coordinatorpattern.appointment.AppointmentFlowEvent
import personal.ianroberts.coordinatorpattern.appointment.AppointmentNavigator
import personal.ianroberts.coordinatorpattern.basket.BasketCoordinator
import personal.ianroberts.coordinatorpattern.basket.BasketFlowEvent
import personal.ianroberts.coordinatorpattern.basket.BasketNavigator
import personal.ianroberts.coordinatorpattern.consultation.ConsultationCoordinator
import personal.ianroberts.coordinatorpattern.consultation.ConsultationFlowEvent
import personal.ianroberts.coordinatorpattern.consultation.ConsultationNavigator
import personal.ianroberts.coordinatorpattern.databinding.FragmentMainBinding
import personal.ianroberts.coordinatorpattern.navigation.FlowNavigator
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main), FlowNavigator {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var appointment: AppointmentCoordinator

    @Inject
    lateinit var basket: BasketCoordinator

    @Inject
    lateinit var consultation: ConsultationCoordinator

    private val vm by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)

        binding.button1.setOnClickListener {
            startFlow(AppointmentNavigator())
        }
        binding.button2.setOnClickListener {
            startFlow(BasketNavigator())
        }
        binding.button3.setOnClickListener {
            startFlow(ConsultationNavigator())
        }
    }

    private fun startFlow(host: Fragment) {
        parentFragmentManager.commit(true) {
            replace(R.id.container, host)
        }
    }

    override fun <SCREEN : Parcelable> navigateTo(screen: SCREEN) {
        val fragment = when(screen) {
            AppointmentFlowEvent.SayHello -> AppointmentNavigator()
            BasketFlowEvent.SayHello -> BasketNavigator()
            ConsultationFlowEvent.SayHello -> ConsultationNavigator()
            else -> return
        }


    }
}