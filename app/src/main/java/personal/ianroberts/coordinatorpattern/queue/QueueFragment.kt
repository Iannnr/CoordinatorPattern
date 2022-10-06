package personal.ianroberts.coordinatorpattern.queue

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import personal.ianroberts.coordinatorpattern.R
import personal.ianroberts.coordinatorpattern.hostedViewModel

@AndroidEntryPoint
class QueueFragment : Fragment(R.layout.fragment_queue) {

    companion object {
        fun newInstance() = QueueFragment()
    }

    private val vm by hostedViewModel<QueueViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}