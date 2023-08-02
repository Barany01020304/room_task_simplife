package com.example.test_

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RecycleDataClass::class], version = 1, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {

    abstract val contactDao:ContactDao
    companion object {
        private lateinit var instance: ContactDatabase
        fun getInstance(context: Context):ContactDatabase {
            synchronized(ContactDatabase::class.java) {
                if (!::instance.isInitialized) {
                    instance =
                        Room.databaseBuilder(context, ContactDatabase::class.java, "contact_db")
                            .fallbackToDestructiveMigrationOnDowngrade()
                            .fallbackToDestructiveMigration().allowMainThreadQueries()
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance
        }
    }

}