package com.doga.shoppingcardassignmentsystem.data.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity

@Dao
interface ProductDao {
    @Insert
    suspend fun addProduct(product: ProductEntity)

    @Query("UPDATE products SET name = :name, price = :price WHERE id = :id")
    suspend fun updateProduct(id: Int, name: String, price: Double)

    @Query("DELETE FROM products WHERE id = :productId")
    suspend fun deleteProduct(productId: Int)

    @Query("SELECT * FROM products WHERE id = :productId")
    suspend fun getProductById(productId: Int): ProductEntity?

    @Query("SELECT * FROM products WHERE name LIKE '%' || :productName || '%'")
    suspend fun searchProductsByName(productName: String): List<ProductEntity>

    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<ProductEntity>

}