package com.timmitof.photoroulette.ui.fragments.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.timmitof.photoroulette.data.models.Photo
import com.timmitof.photoroulette.domain.repositories.PhotoRepository
import com.timmitof.photoroulette.domain.repositories.PhotoRepositoryImpl
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    private val photoRepository: PhotoRepositoryImpl
) : ViewModel() {

    private val _photosList = MutableLiveData<PagingData<Photo>>()
    val photosList: LiveData<PagingData<Photo>>
        get() = _photosList

    init {
        getPhotos()
    }

    fun getPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = photoRepository.getPagedPhotos().cachedIn(viewModelScope)
            result.collectLatest {
                _photosList.postValue(it)
            }
        }
    }

}