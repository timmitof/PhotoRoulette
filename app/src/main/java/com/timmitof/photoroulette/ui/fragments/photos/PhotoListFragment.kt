package com.timmitof.photoroulette.ui.fragments.photos

import androidx.fragment.app.viewModels
import com.timmitof.photoroulette.databinding.FragmentPhotoListBinding
import com.timmitof.photoroulette.ui.base.BaseFragment
import com.timmitof.photoroulette.ui.fragments.photos.adapter.PhotoComparator
import com.timmitof.photoroulette.ui.fragments.photos.adapter.PhotoListAdapter

class PhotoListFragment :
    BaseFragment<FragmentPhotoListBinding>(FragmentPhotoListBinding::inflate) {

    private val viewModel: PhotoListViewModel by viewModels()
    private val pagingAdapter: PhotoListAdapter by lazy { PhotoListAdapter() }

    override fun setupViews() {
        super.setupViews()
        binding.refresh.setOnRefreshListener {
            viewModel.getPhotos()
        }
    }

    override fun bindData() {
        super.bindData()

    }
}