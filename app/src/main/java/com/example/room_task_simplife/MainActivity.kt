package com.example.room_task_simplife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.room_task_simplife.databinding.ActivityMainBinding
import com.example.test_.ContactAdapter
import com.example.test_.ContactDatabase
import com.example.test_.RecycleDataClass

class MainActivity : AppCompatActivity(), ContactAdapter.OnClick {
    lateinit var binding: ActivityMainBinding
    lateinit var db:ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db= ContactDatabase.getInstance(this)
        var contactList:List<RecycleDataClass> =arrayListOf(RecycleDataClass("ahmed","01027453029"),RecycleDataClass("ahmed","01027453029"),RecycleDataClass("ahmed","01027453029"),RecycleDataClass("ahmed","01027453029"))
        binding.recycleviewRoomTest.adapter=ContactAdapter(contactList,this)
       binding.showButton.setOnClickListener {
           contactList=db.contactDao.getContacts()
           binding.recycleviewRoomTest.adapter=ContactAdapter(contactList,this)
       }
       binding.saveButton.setOnClickListener {
       var name= binding.nameEditTextText.text.toString()
       var phone=binding.phoneEditText.text.toString()
           db.contactDao.insertContact(RecycleDataClass(name,phone))
       }

    }

    override fun viewClick() {

    }
}