package personal.ianroberts.coordinator

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import personal.ianroberts.coordinator.ui.BaseViewModel

/**
 * Goes up the backstack tree to try and find the nearest Coordinator host to send UI events to
 */
tailrec fun Fragment.nearestHost(): CoordinatorHost? {
    val fragment = this.parentFragment
    val activity = this.activity
    return when {
        fragment is CoordinatorHost -> fragment
        activity is CoordinatorHost -> activity
        else -> fragment?.nearestHost()
    }
}

/**
 * Middleware interceptor to get the Coordinator host's coordinator to provide the fields/VM for view model creation
 * -- Currently just calls out the Fragment's default view model provider (as provided by Hilt)
 */
@MainThread
inline fun <reified VM : BaseViewModel> Fragment.hostedViewModel(
): Lazy<VM> {
    // Decision needed if the Coordinator can be used to create the ViewModel/Factory
    val nearestHost by lazy { nearestHost() ?: throw IllegalArgumentException("Fragment not attached to a Coordinator Host") }
    return viewModels()
}