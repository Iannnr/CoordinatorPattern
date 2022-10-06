package personal.ianroberts.coordinatorpattern.address

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinatorpattern.R
import personal.ianroberts.coordinatorpattern.hostedViewModel

@AndroidEntryPoint
class AddressFragment : Fragment(R.layout.fragment_address) {

    companion object {
        fun newInstance() = AddressFragment()
    }

    private val vm by hostedViewModel<AddressViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}