package com.doga.shoppingcardassignmentsystem.domain.usecase

import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.domain.repository.ProductRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class SearchProductsByNameUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(name: String): List<ProductEntity> =
        productRepository.searchProductsByName(name)
}