package com.doga.shoppingcardassignmentsystem.presentation.editproduct

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.domain.usecase.GetProductsUseCase
import com.doga.shoppingcardassignmentsystem.domain.usecase.RemoveProductUseCase
import com.doga.shoppingcardassignmentsystem.domain.usecase.SearchProductsByNameUseCase
import com.doga.shoppingcardassignmentsystem.domain.usecase.UpdateProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val removeProductUseCase: RemoveProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val searchProductsByNameUseCase: SearchProductsByNameUseCase
) : ViewModel() {

    private val _products = MutableLiveData<List<ProductEntity>>()
    val products: MutableLiveData<List<ProductEntity>> = _products

    fun searchProductsByName(name: String) {
        viewModelScope.launch {
            _products.value = searchProductsByNameUseCase(name) ?: emptyList()
        }
    }

    fun getAllProducts() {
        viewModelScope.launch {
            _products.value = getProductsUseCase() ?: emptyList()
        }
    }

    fun removeProduct(productId: Int) {
        viewModelScope.launch {
            removeProductUseCase(productId)
            getAllProducts()
        }
    }

    fun updateProduct(id: Int, name: String, price: Double) {
        viewModelScope.launch {
            updateProductUseCase(id, name, price)
            getAllProducts()
        }
    }
}