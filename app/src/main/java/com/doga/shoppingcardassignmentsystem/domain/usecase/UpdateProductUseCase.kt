package com.doga.shoppingcardassignmentsystem.domain.usecase

import com.doga.shoppingcardassignmentsystem.domain.repository.ProductRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class UpdateProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(id: Int, name: String, price: Double) =
        productRepository.updateProduct(id, name, price)
}