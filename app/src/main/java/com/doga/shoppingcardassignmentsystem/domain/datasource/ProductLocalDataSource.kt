package com.doga.shoppingcardassignmentsystem.domain.datasource

import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.domain.repository.ProductRepository

interface ProductLocalDataSource {

    suspend fun addProduct(product: ProductEntity)

    suspend fun updateProduct(product: ProductEntity)

    suspend fun deleteProduct(productId: Int)

    suspend fun getProductById(productId: Int): ProductEntity?

    suspend fun searchProductsByName(productName: String): List<ProductEntity>

    suspend fun getAllProducts(): ProductEntity
}