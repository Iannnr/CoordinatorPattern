package personal.ianroberts.feature

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinator.Coordinator
import personal.ianroberts.coordinator.hostedViewModel
import personal.ianroberts.coordinator.ui.BaseFragment
import personal.ianroberts.feature.databinding.FragmentFeatureBinding

@AndroidEntryPoint
class FeatureFragment : BaseFragment(R.layout.fragment_feature) {

    companion object {
        fun newInstance() = FeatureFragment()
    }

    override val vm by hostedViewModel<FeatureViewModel>()
    override val coordinator: Coordinator<*> by lazy(coordinatorHost::coordinator)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentFeatureBinding.bind(view)
        binding.button1.setOnClickListener {
            vm.sayHello()
        }
    }
}

/** gradle module structure
 * app (coordinator & navigator implementation)
 * -- feature (fragment, vm, repo, screen ui event) - reusable fragments, no context of what flow it's in
 * --- navigation (interfaces for coordinator, navigator etc, base fragment & VM)
 */