package abika.sinau.myfirstdaggerhilt

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 5/26/2022
 */

// TODO: Add this annotation if we want tell the hilt, if this class is viewModel
@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepositoryImpl
) : ViewModel() {
    fun doCall() {
        repository.doNetworkCall()
    }
}