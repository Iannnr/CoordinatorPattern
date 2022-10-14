package personal.ianroberts.feature

import dagger.hilt.android.lifecycle.HiltViewModel
import personal.ianroberts.coordinator.ui.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureViewModel @Inject constructor(
) : BaseViewModel() {

    fun sayHello() = sendCoordinatorEvent(FeatureUiEvent.SayHello)
}