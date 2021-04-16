package com.project.kambista.data.raw

import java.io.Serializable

data class UserRaw(
    var user: String,
    var password: String
): Serializable