package com.doga.shoppingcardassignmentsystem.presentation.editproduct

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doga.shoppingcardassignmentsystem.R
import com.doga.shoppingcardassignmentsystem.common.viewBinding
import com.doga.shoppingcardassignmentsystem.databinding.FragmentEditProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditProductFragment : Fragment(R.layout.fragment_edit_product) {

    private val binding by viewBinding(FragmentEditProductBinding::bind)

    private val editProductAdapter by lazy { EditProductAdapter(::onRemoveClick) }

    private val viewModel: EditProductViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()

    }

    private fun initObservers() {
        binding.rvProducts.adapter = editProductAdapter

        viewModel.products.observe(viewLifecycleOwner) {
            editProductAdapter.submitList(it)
        }
    }

    private fun onRemoveClick(productId: Int) {
        viewModel.removeProduct(productId)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllProducts()
    }
}