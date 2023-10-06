package com.botirov.myapplication.data.repository

import androidx.lifecycle.LiveData
import com.botirov.myapplication.data.ToDoDao
import com.botirov.myapplication.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao){

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }
}