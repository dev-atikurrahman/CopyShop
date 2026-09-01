package com.atik.coffeeshop.features.auth.data.models

// registration এর সময় শুধু name, email, password দিয়ে হবে, বাকি গুলো user পরে profile থেকে update করে নিতে পারবে।
data class Users(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val repeatedPassword: String = "",
    val profileImgUrl: String = "",
    val gender: String = "",
    val address: String = ""
)