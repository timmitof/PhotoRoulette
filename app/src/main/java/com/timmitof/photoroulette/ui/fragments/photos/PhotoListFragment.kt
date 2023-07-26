package com.timmitof.photoroulette.ui.fragments.photos

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.timmitof.photoroulette.data.models.Src
import com.timmitof.photoroulette.databinding.FragmentPhotoListBinding
import com.timmitof.photoroulette.ui.base.BaseFragment
import com.timmitof.photoroulette.ui.fragments.photos.adapter.PhotoComparator
import com.timmitof.photoroulette.ui.fragments.photos.adapter.PhotoListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoListFragment : BaseFragment<FragmentPhotoListBinding>(FragmentPhotoListBinding::inflate) {

    private val viewModel: PhotoListViewModel by viewModels()
    private val pagingAdapter: PhotoListAdapter by lazy { PhotoListAdapter(onClickDetails) }
    private lateinit var onClickDetails: (Src) -> Unit

    override fun setupViews() {
        super.setupViews()
        onClickDetails = { findNavController().navigate(PhotoListFragmentDirections.actionPhotoListFragmentToImageFullScreenFragment(it)) }

        pagingAdapter.addLoadStateListener { loadState ->
            when {
                loadState.append is LoadState.NotLoading -> { binding.refresh.isRefreshing = false }
                loadState.append is LoadState.Loading -> { binding.refresh.isRefreshing = true }
                loadState.append is LoadState.Error -> {
                    binding.refresh.isRefreshing = false
                    val errorState = loadState.append as LoadState.Error
                    Toast.makeText(requireContext(), errorState.error.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.recyclerView.adapter = pagingAdapter

        binding.refresh.setOnRefreshListener {
            viewModel.getPhotos()
        }
    }

    override fun bindData() {
        super.bindData()
        viewModel.photosList.observe(viewLifecycleOwner) { pagingData ->
            pagingAdapter.submitData(viewLifecycleOwner.lifecycle, pagingData)
        }
    }
}