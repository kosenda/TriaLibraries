package ksnd.trialibraries.libraries.konfetti

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import nl.dionsegijn.konfetti.core.Party
import javax.inject.Inject

@HiltViewModel
class KonfettiViewModel @Inject constructor() : ViewModel() {
    private val _parties = MutableStateFlow<List<Party>>(emptyList())
    val parties: StateFlow<List<Party>> = _parties.asStateFlow()

    fun updateParties(parties: List<Party>) {
        _parties.value = parties
    }
}
