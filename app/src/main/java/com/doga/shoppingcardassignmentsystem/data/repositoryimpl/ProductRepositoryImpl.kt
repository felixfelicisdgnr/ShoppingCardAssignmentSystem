package com.doga.shoppingcardassignmentsystem.data.repositoryimpl

import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.domain.datasource.ProductLocalDataSource
import com.doga.shoppingcardassignmentsystem.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productLocalDataSource: ProductLocalDataSource
) : ProductRepository {
    override suspend fun addProduct(product: ProductEntity) =
        productLocalDataSource.addProduct(product)

    override suspend fun updateProduct(product: ProductEntity) =
        productLocalDataSource.updateProduct(product)

    override suspend fun deleteProduct(productId: Int) =
        productLocalDataSource.deleteProduct(productId)

    override suspend fun getProductById(productId: Int): ProductEntity? =
        productLocalDataSource.getProductById(productId)

    override suspend fun searchProductsByName(productName: String): List<ProductEntity> =
        productLocalDataSource.searchProductsByName(productName)

    override suspend fun getAllProducts(): List<ProductEntity> =
        productLocalDataSource.getAllProducts()
}