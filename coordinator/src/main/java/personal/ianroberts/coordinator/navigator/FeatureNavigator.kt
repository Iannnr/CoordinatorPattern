package personal.ianroberts.coordinator.navigator

/**
 * Used to glue together multiple Flow navigators based on events or finish lambdas being emitted
 */
interface FeatureNavigator {
    fun onEvent(event: Any)
}