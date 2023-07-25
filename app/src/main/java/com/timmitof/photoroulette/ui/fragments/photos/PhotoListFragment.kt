package com.timmitof.photoroulette.ui.fragments.photos

import androidx.fragment.app.viewModels
import com.timmitof.photoroulette.databinding.FragmentPhotoListBinding
import com.timmitof.photoroulette.ui.base.BaseFragment

class PhotoListFragment :
    BaseFragment<FragmentPhotoListBinding>(FragmentPhotoListBinding::inflate) {

    private val viewModel: PhotoListViewModel by viewModels()

    override fun setupViews() {
        super.setupViews()

    }

    override fun bindData() {
        super.bindData()

    }
}