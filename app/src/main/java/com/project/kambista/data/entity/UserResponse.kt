package com.project.kambista.data.entity

import java.io.Serializable

data class UserResponse(
    val success: Boolean,
    var message: String
): Serializable