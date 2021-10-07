package mx.itesm.testbasicapi.model.repository.backendinterface

import mx.itesm.testbasicapi.model.entities.CorreoContrasenia
import mx.itesm.testbasicapi.model.entities.DatosCrearCuenta
import mx.itesm.testbasicapi.model.entities.JwtToken
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiUsuarios {
    @POST("api/user/login")
    fun iniciarSesion(@Body correoContrasenia: CorreoContrasenia): Call<JwtToken>

    @POST("api/user/register")
    fun crearCuenta(@Body datosIniciarSesion: DatosCrearCuenta): Call<Boolean>
}