package com.botirov.myapplication.fragments

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import com.botirov.myapplication.data.models.Priority

class SharedViewModel(application: Application): AndroidViewModel(application) {
     fun verifyDataFromUser(title:String, description:String):Boolean{ // this is to check if empty, before passing to the user
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)){
            false
        } else !(title.isEmpty() || description.isEmpty())

    }

     fun parsePiority(priority: String): Priority {
        return when(priority){
            "High Priority" -> {
                Priority.HIGH}
            "Medium Priority" -> {
                Priority.MEDIUM}
            "Low Priority" -> {
                Priority.LOW}
            else -> Priority.LOW

        }
    }
}