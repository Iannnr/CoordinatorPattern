package personal.ianroberts.coordinatorpattern.payment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinatorpattern.R
import personal.ianroberts.coordinatorpattern.hostedViewModel

@AndroidEntryPoint
class PaymentFragment : Fragment(R.layout.fragment_payment) {

    companion object {
        fun newInstance() = PaymentFragment()
    }

    private val vm by hostedViewModel<PaymentViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}