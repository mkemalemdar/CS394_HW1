package com.example.projeleme

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.projeleme.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {
    companion object{
        const val USER_NAME = "user_name"
        const val USER_DESC = "user_desc"
        const val USER_GENDER = "user_gender"
        const val USER_AGE = "user_age"
        const val USER_PREFERENCE= "user_preference"
        const val USER_NUMBER = "user_number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_user_detail)
        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        val userName = intent.getStringExtra(USER_NAME)
        val userDesc = intent.getStringExtra(USER_DESC)
        val userGender = intent.getStringExtra(USER_GENDER)
        val userAge = intent.getStringExtra(USER_AGE)
        val userPreference = intent.getStringExtra(USER_PREFERENCE)
        val userNumber = intent.getStringExtra(USER_NUMBER)

        binding.nameView.text = userName
        binding.descView.text = userDesc
        binding.genderView.text = userGender
        binding.ageView.text = userAge
        binding.preferenceView.text = userPreference
        binding.numberView.text = userNumber

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}