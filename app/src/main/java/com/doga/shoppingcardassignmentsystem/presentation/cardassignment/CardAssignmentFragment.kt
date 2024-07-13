package com.doga.shoppingcardassignmentsystem.presentation.cardassignment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doga.shoppingcardassignmentsystem.R
import com.doga.shoppingcardassignmentsystem.common.viewBinding
import com.doga.shoppingcardassignmentsystem.databinding.FragmentCardAssignmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardAssignmentFragment : Fragment(R.layout.fragment_card_assignment) {

    private val binding by viewBinding(FragmentCardAssignmentBinding::bind)

    private val adapter by lazy { CardAssignmentAdapter(::onDeleteClick) }

    private val viewModel: CardAssignmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObservers()
    }

    private fun onDeleteClick(productId: Int) {
        viewModel.removeProduct(productId)
    }

    private fun initObservers() {
        binding.rvAllProducts.adapter = adapter
        viewModel.products.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllProducts()
    }
}