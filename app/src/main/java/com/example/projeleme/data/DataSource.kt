package com.example.projeleme.data

import android.content.Context
import com.example.projeleme.R
import com.example.projeleme.model.User

class DataSource(val context: Context) {
    fun getUserNamesList(): Array<String>{
        return context.resources.getStringArray(R.array.name_array)
    }
    fun getUserDescList(): Array<String>{
        return context.resources.getStringArray(R.array.desc_array)
    }
    fun getUserGenderList(): Array<String>{
        return context.resources.getStringArray(R.array.gender_array)
    }
    fun getUserAgeList(): Array<String>{
        return context.resources.getStringArray(R.array.age_array)
    }
    fun getUserPreferenceList(): Array<String>{
        return context.resources.getStringArray(R.array.preference_array)
    }
    fun getUserNumberList(): Array<String>{
        return context.resources.getStringArray(R.array.phone_number_array)
    }

    fun loadUsers(): List<User>{
        val namesList = getUserNamesList()
        val descList = getUserDescList()
        val genderList  = getUserGenderList()
        val ageList = getUserAgeList()
        val preferenceList = getUserPreferenceList()
        val numberList = getUserNumberList()

        val users = mutableListOf<User>()
        for (i in namesList.indices){
            users.add(User(namesList[i], descList[i],genderList[i],ageList[i], preferenceList[i],numberList[i]))
        }
        return users
    }
}