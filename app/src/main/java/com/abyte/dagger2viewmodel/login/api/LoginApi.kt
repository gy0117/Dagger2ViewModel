package com.abyte.dagger2viewmodel.login.api

import com.abyte.dagger2viewmodel.model.AuthorizationRequest
import com.abyte.dagger2viewmodel.model.AuthorizationResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path


interface LoginApi {

    @PUT("/authorizations/clients/${"xxx"}/{fingerPrint}")
    fun createAuthorization(@Body req: AuthorizationRequest, @Path("fingerPrint") fingerPrint: String = "")
            : Observable<AuthorizationResponse>
}