package mx.itesm.testbasicapi.model.repository.backendinterface.ejemplo

import mx.itesm.testbasicapi.model.entities.JwtToken
import mx.itesm.testbasicapi.model.entities.ejemplo.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UsersApi {
    @POST("users/login")
    fun login(@Body user: User): Call<JwtToken>
}