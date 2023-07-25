package com.timmitof.photoroulette.ui.fragments.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoListViewModel: ViewModel() {

    fun loadPhotos() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}