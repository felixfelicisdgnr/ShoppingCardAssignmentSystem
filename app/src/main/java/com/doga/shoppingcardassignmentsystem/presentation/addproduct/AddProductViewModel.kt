package com.doga.shoppingcardassignmentsystem.presentation.addproduct

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.domain.usecase.AddProductUseCase
import com.doga.shoppingcardassignmentsystem.domain.usecase.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private val addProductUseCase: AddProductUseCase,
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {

    private val _products = MutableLiveData<List<ProductEntity>>()
    val products: MutableLiveData<List<ProductEntity>> = _products

    fun addProduct(product: ProductEntity) {
        viewModelScope.launch {
            val currentProducts = getProductUseCase()
            val newId = (currentProducts.maxOfOrNull { it.id } ?: 0) + 1
            val newProduct = product.copy(id = newId)
            addProductUseCase(newProduct)
            getProducts()
        }
    }

    fun getProducts() {
        viewModelScope.launch {
            _products.value = getProductUseCase() ?: emptyList()
        }
    }
}