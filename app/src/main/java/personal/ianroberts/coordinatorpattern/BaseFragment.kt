package personal.ianroberts.coordinatorpattern

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import personal.ianroberts.coordinatorpattern.navigation.Coordinator

abstract class BaseFragment : Fragment() {

    abstract val vm: BaseViewModel
    abstract val coordinator: Coordinator<*>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (nearestHost() == null) throw IllegalArgumentException()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.events
            .onEach {
                coordinator.onEvent(it, it)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }
}