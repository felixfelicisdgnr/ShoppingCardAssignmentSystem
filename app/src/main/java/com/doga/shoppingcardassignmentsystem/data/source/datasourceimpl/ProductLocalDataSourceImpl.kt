package com.doga.shoppingcardassignmentsystem.data.source.datasourceimpl

import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.data.source.dao.ProductDao
import com.doga.shoppingcardassignmentsystem.domain.datasource.ProductLocalDataSource
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ProductLocalDataSourceImpl @Inject constructor(
    private val productDao: ProductDao,
    private val ioDispatcher: CoroutineContext
) : ProductLocalDataSource {
    override suspend fun insertProduct(product: ProductEntity) = withContext(ioDispatcher) {
        productDao.insertProduct(product)
    }

    override suspend fun updateProduct(product: ProductEntity) = withContext(ioDispatcher) {
        productDao.updateProduct(product)
    }

    override suspend fun deleteProduct(productId: Int) = withContext(ioDispatcher) {
        productDao.deleteProduct(productId)
    }

    override suspend fun getProductById(productId: Int): ProductEntity? = withContext(ioDispatcher) {
        productDao.getProductById(productId)
    }
    override suspend fun searchProductsByName(productName: String): List<ProductEntity> = withContext(ioDispatcher) {
        productDao.searchProductsByName(productName)
    }

    override suspend fun getAllProducts(): List<ProductEntity> = withContext(ioDispatcher) {
        productDao.getAllProducts()
    }
}