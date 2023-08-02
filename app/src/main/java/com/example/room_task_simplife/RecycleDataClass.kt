package com.example.test_

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("recycle_data_class")
data class RecycleDataClass (
    var name:String,
    @PrimaryKey(autoGenerate = false)
    var phone:String)