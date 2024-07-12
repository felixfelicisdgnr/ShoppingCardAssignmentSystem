package com.doga.shoppingcardassignmentsystem.data.source


import androidx.room.Database
import androidx.room.RoomDatabase
import com.doga.shoppingcardassignmentsystem.data.model.entity.CardEntity
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.data.source.dao.CardDao
import com.doga.shoppingcardassignmentsystem.data.source.dao.ProductDao

@Database(
    entities = [ProductEntity::class,
        CardEntity::class],
    version = 1,exportSchema = false
)

abstract class RoomDatabaseService : RoomDatabase() {
    abstract fun getProductDao(): ProductDao
    abstract fun getCardDao(): CardDao
}