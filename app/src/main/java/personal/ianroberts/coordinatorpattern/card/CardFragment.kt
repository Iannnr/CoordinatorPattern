package personal.ianroberts.coordinatorpattern.card

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import personal.ianroberts.coordinatorpattern.R
import personal.ianroberts.coordinatorpattern.databinding.FragmentCardBinding
import personal.ianroberts.coordinatorpattern.hostedViewModel
import personal.ianroberts.coordinatorpattern.nearestHost

@AndroidEntryPoint
class CardFragment : Fragment(R.layout.fragment_card) {

    companion object {
        fun newInstance() = CardFragment()
    }

    private val vm by hostedViewModel<CardViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCardBinding.bind(view)
        binding.button1.setOnClickListener {
            nearestHost()?.coordinator?.onEvent(CardUiEvent.SayHello, CardUiEvent.SayHello)
        }

        vm.events
            .onEach {
                Log.i("Event",  "$it")
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }


}