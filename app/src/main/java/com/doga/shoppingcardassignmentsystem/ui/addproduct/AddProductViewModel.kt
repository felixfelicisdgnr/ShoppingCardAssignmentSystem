package com.doga.shoppingcardassignmentsystem.ui.addproduct

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
) : ViewModel(){

    private val _product = MutableLiveData<ProductEntity?>()
    val product: MutableLiveData<ProductEntity?> = _product

    fun addProduct(product: ProductEntity){
        viewModelScope.launch {
            addProductUseCase(product)
            getProduct()
        }
    }

    fun getProduct(){
        viewModelScope.launch {
            _product.value = getProductUseCase()
        }
    }
}