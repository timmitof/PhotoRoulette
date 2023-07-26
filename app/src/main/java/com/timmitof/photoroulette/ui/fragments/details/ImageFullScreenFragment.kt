package com.timmitof.photoroulette.ui.fragments.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.timmitof.photoroulette.databinding.FragmentImageFullScreenBinding
import com.timmitof.photoroulette.ui.base.BaseFragment

class ImageFullScreenFragment : BaseFragment<FragmentImageFullScreenBinding>(FragmentImageFullScreenBinding::inflate) {

    private val args: ImageFullScreenFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(args.src.portrait).into(binding.imageView)
        binding.backBtn.setOnClickListener { findNavController().popBackStack() }
    }
}