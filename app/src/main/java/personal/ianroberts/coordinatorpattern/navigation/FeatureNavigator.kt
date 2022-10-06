package personal.ianroberts.coordinatorpattern.navigation

interface FeatureNavigator {
    fun onEvent(event: Any)
}