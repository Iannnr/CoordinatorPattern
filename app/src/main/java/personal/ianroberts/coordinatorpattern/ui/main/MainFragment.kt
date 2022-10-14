package personal.ianroberts.coordinatorpattern.ui.main

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinator.navigator.FlowNavigator
import personal.ianroberts.coordinatorpattern.R
import personal.ianroberts.coordinatorpattern.databinding.FragmentMainBinding
import personal.ianroberts.coordinatorpattern.payment.PaymentNavigator

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main), FlowNavigator {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val vm by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)

        binding.button2.setOnClickListener {
            startFlow(PaymentNavigator())
        }
    }

    private fun startFlow(host: Fragment) {
        parentFragmentManager.commit(true) {
            replace(R.id.container, host)
        }
    }

    override fun <SCREEN : Parcelable> navigateTo(screen: SCREEN) {}
}