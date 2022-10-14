package personal.ianroberts.coordinator.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import personal.ianroberts.coordinator.Coordinator
import personal.ianroberts.coordinator.CoordinatorEvent
import personal.ianroberts.coordinator.CoordinatorHost
import personal.ianroberts.coordinator.nearestHost

/**
 * Responsible for orchestrating the event flow from the [CoordinatorEvent] to send to the [Coordinator]
 * which is associated with the implementation of this base fragment via the [coordinator] override
 */
abstract class BaseFragment : Fragment {

    constructor() : super()
    constructor(@LayoutRes resId: Int) : super(resId)

    abstract val vm: BaseViewModel
    abstract val coordinator: Coordinator<*>

    /**
     * This should not be accessed before [onAttach] as both [getParentFragment] and [getActivity] will always return null
     * So will be guarded by the [IllegalArgumentException] thrown in [onAttach]
     */
    protected val coordinatorHost: CoordinatorHost
        get() = nearestHost()!!

    /**
     * Fail fast to ensure that any of these fragments are attached to a host that can provide a [Coordinator] via the [CoordinatorHost]
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (nearestHost() == null) throw IllegalArgumentException()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Orchestrates the flow of events from the UI/ViewModel to notify this coordinator
         */
        vm.events
            .onEach { event -> coordinator.onEvent(event, event) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }
}