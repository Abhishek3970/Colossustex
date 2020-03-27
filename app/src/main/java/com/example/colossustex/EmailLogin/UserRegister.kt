package com.example.colossustex.EmailLogin

data class UserRegister(
    var id: String? = "",
    var email: String? = "",
    var name: String? = "",
    var password: String? = "",
    var phone: String? = "",
    var country: String? = "",
    var city: String? = "",
    var categary: String? = "",
    var companyName: String? = "",
    var GSTNumber: String? = "",
    var address: String? = "",
    var state: String? = "",
    var pinCode: String? = "",
    var flag: Int = 0
)