package com.doga.shoppingcardassignmentsystem.domain.repository

import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity

interface ProductRepository {

    suspend fun addProduct(product: ProductEntity)

    suspend fun updateProduct(product: ProductEntity)

    suspend fun deleteProduct(productId: Int)

    suspend fun getProductById(productId: Int): ProductEntity?

    suspend fun searchProductsByName(productName: String): List<ProductEntity>

    suspend fun getAllProducts(): List<ProductEntity>
}