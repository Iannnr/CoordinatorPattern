package personal.ianroberts.coordinatorpattern.navigation

import android.os.Parcelable

interface FlowNavigator {
    fun <SCREEN: Parcelable> navigateTo(screen: SCREEN)
}