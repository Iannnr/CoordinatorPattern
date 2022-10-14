package personal.ianroberts.coordinatorpattern.card

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import personal.ianroberts.coordinatorpattern.BaseFragment
import personal.ianroberts.coordinatorpattern.databinding.FragmentCardBinding
import personal.ianroberts.coordinatorpattern.hostedViewModel
import personal.ianroberts.coordinatorpattern.navigation.Coordinator
import personal.ianroberts.coordinatorpattern.nearestHost

@AndroidEntryPoint
class CardFragment : BaseFragment() {

    companion object {
        fun newInstance() = CardFragment()
    }

    override val vm by hostedViewModel<CardViewModel>()
    override val coordinator: Coordinator<*> by lazy { nearestHost()!!.coordinator }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCardBinding.bind(view)
        binding.button1.setOnClickListener {
            vm.sayHello()
        }
    }
}

/** gradle module structure
 * app (coordinator & navigator implementation)
 * -- feature (fragment, vm, repo, screen ui event) - reusable fragments, no context of what flow it's in
 * --- navigation (interfaces for coordinator, navigator etc, base fragment & VM)
 */