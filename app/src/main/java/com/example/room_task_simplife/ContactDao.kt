package com.example.test_

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select

@Dao
interface ContactDao {
    @Insert()
    fun insertContact(recycleDataClass: RecycleDataClass)
    @Query("select * from recycle_data_class")
    fun getContacts():List<RecycleDataClass>
}