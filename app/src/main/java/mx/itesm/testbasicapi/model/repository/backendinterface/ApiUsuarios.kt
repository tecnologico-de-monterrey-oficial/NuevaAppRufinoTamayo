package mx.itesm.testbasicapi.model.repository.backendinterface

import mx.itesm.testbasicapi.model.entities.ECorreoContrasenia
import mx.itesm.testbasicapi.model.entities.EDatosCrearCuenta
import mx.itesm.testbasicapi.model.entities.EUsuario
import mx.itesm.testbasicapi.model.entities.JwtToken
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiUsuarios {
    @POST("api/user/login")
    fun iniciarSesion(@Body correoContrasenia: ECorreoContrasenia): Call<JwtToken>

    @POST("api/user/register")
    fun crearCuenta(@Body datosIniciarSesion: EDatosCrearCuenta): Call<Boolean>

    @GET("api/user/{user_id}")
    fun obtenerUsuario(@Path("user_id") user_id: String): Call<EUsuario>
}