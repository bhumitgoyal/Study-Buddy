package com.example.study_buddy.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class UserModel(

    val email:String? = null,
    val password:String? = null,
    val name:String? = null,
)
