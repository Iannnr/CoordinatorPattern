package personal.ianroberts.coordinatorpattern

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

tailrec fun Fragment.nearestHost(): CoordinatorHost? {
    val fragment = this.parentFragment
    val activity = this.activity
    return when {
        fragment is CoordinatorHost -> fragment
        activity is CoordinatorHost -> activity
        else -> fragment?.nearestHost()
    }
}

abstract class BaseViewModel : ViewModel() {

    private val _events = Channel<Any>(BUFFERED)
    val events = _events.receiveAsFlow()

    protected fun sendCoordinatorEvent(event: Any) = viewModelScope.launch {
        _events.send(event)
    }
}

@MainThread
inline fun <reified VM : BaseViewModel> Fragment.hostedViewModel(
): Lazy<VM> {
    val nearestHost by lazy { nearestHost() ?: throw IllegalArgumentException("Fragment not attached to a Coordinator Host") }
    return lazy(LazyThreadSafetyMode.NONE) {
        viewModels<VM>().value
    }

}

