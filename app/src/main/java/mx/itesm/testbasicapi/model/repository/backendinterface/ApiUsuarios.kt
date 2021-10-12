package mx.itesm.testbasicapi.model.repository.backendinterface

import android.icu.util.Output
import mx.itesm.testbasicapi.model.entities.*
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputIniciarSesion
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerUsuario
import retrofit2.Call
import retrofit2.http.*

interface ApiUsuarios {
    @POST("api/user/register")
    fun crearCuenta(@Body inputCrearCuenta: InputCrearCuenta): Call<Void>

    @POST("api/user/login")
    fun iniciarSesion(@Body inputIniciarSesion: InputIniciarSesion): Call<OutputIniciarSesion>

    @GET("api/user/get_user")
    fun obtenerUsuario(): Call<OutputObtenerUsuario>

    @PATCH("api/user/reset_password")
    fun cambiarContrasenia(@Body inputCambiarContrasenia: InputCambiarContrasenia): Call<Void>

    @PATCH("api/user/change_to_admin")
    fun nombrarAdministrador(@Body inputNombrarAdministrador: InputNombrarAdministrador): Call<Void>

    @PATCH("api/user/new_main_admin")
    fun nuevoAdministradorPrincipal(@Body inputNuevoAdministradorPrincipal: InputNuevoAdministradorPrincipal): Call<Void>

    @PUT("api/user/block_anony_reports")
    fun bloquearReportesAnonimos(@Body inputBloquearReportesAnonimos: InputBloquearReportesAnonimos): Call<Void>

    @PATCH("api/user/block_user")
    fun bloquearVisitante(@Body inputBloquearVisitante: InputBloquearVisitante): Call<Void>
}