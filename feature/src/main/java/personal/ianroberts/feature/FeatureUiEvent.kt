package personal.ianroberts.feature

import kotlinx.parcelize.Parcelize
import personal.ianroberts.coordinator.CoordinatorEvent

@Parcelize
sealed class FeatureUiEvent : CoordinatorEvent {
    object SayHello : FeatureUiEvent()
}
