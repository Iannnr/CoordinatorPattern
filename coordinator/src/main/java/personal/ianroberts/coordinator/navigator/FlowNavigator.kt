package personal.ianroberts.coordinator.navigator

import android.os.Parcelable

/**
 * Used to convert [personal.ianroberts.coordinator.CoordinatorEvent] into Fragments
 * And starting them in this lifecycle owner's fragment manager
 */
interface FlowNavigator {
    fun <SCREEN: Parcelable> navigateTo(screen: SCREEN)
}