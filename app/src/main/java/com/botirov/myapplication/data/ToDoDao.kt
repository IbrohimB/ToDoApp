package com.botirov.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ToDoDao {

    @Query("SELECT*FROM todo_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<ToDoData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE) //If faces same item, it will ignore
    suspend fun insertData(toDoData: ToDoData)

}