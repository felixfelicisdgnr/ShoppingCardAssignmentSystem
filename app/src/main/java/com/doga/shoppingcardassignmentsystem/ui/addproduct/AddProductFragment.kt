package com.doga.shoppingcardassignmentsystem.ui.addproduct

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doga.shoppingcardassignmentsystem.R
import com.doga.shoppingcardassignmentsystem.common.viewBinding
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.databinding.FragmentAddProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddProductFragment : Fragment(R.layout.fragment_add_product) {

    private val binding by viewBinding(FragmentAddProductBinding::bind)

    private val submitProductAdapter by lazy { SubmitProductAdapter() }

    private val viewModel: AddProductViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initObservers()
        setUpOnClickListeners()
        viewModel.getProduct()

    }

    private fun initObservers() {
        binding.rvSubmitProducts.adapter = submitProductAdapter
        viewModel.product.observe(viewLifecycleOwner) {
            val list = it?.let { listOf(it) } ?: emptyList()
            submitProductAdapter.submitList(list)
        }
    }

    private fun setUpOnClickListeners() {
        binding.btnSubmitProduct.setOnClickListener {
            submitProduct()
        }
    }

    private fun submitProduct() {

        val productName = binding.etProductName.text.toString()
        val productPrice = binding.etProductPrice.text.toString()


        if (productName.isEmpty()) {
            Toast.makeText(requireContext(), "Please, enter a product name", Toast.LENGTH_SHORT)
                .show()
            return
        }

        if (productPrice.isEmpty()) {
            Toast.makeText(requireContext(), "Please, enter a product price", Toast.LENGTH_SHORT)
                .show()
            return
        }

        if (productPrice < 0.01.toString() || productPrice > 99.99.toString()) {
            Toast.makeText(
                requireContext(),
                "Please, price must be between 0.01 and 99.99",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val product = ProductEntity(1, productName, productPrice.toDouble())

        viewModel.addProduct(product)
    }
}