package com.abyte.dagger2viewmodel.model

import com.abyte.dagger2viewmodel.core.anno.PoKo


@PoKo
data class AuthorizationRequest(
    var scopes: List<String>? = null,
    var note: String = "",
    var note_url: String = "",
    var client_secret: String = ""
)


@PoKo
data class AuthorizationResponse(
    var id: Int,
    var url: String,
    var app: App,
    var token: String,
    var hashed_token: String,
    var token_last_eight: String,
    var note: String,
    var note_url: String,
    var created_at: String,
    var updated_at: String,
    var scopes: List<String>
)


@PoKo
data class App(var name: String, var url: String, var client_id: String)