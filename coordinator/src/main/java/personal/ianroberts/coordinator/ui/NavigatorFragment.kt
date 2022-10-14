package personal.ianroberts.coordinator.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import personal.ianroberts.coordinator.CoordinatorHost
import personal.ianroberts.coordinator.navigator.FlowNavigator

abstract class NavigatorFragment : Fragment, CoordinatorHost, FlowNavigator {

    constructor() : super()
    constructor(@LayoutRes resId: Int) : super(resId)
}