package personal.ianroberts.coordinator

import android.os.Parcelable

interface Coordinator<SCREEN : Parcelable> {

    fun onStart()

    fun onEvent(event: Any, screen: Any)
}