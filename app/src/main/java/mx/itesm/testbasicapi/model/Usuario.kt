package mx.itesm.testbasicapi.model

import mx.itesm.testbasicapi.model.entities.*
import mx.itesm.testbasicapi.model.repository.RemoteRepository
import mx.itesm.testbasicapi.model.repository.backendinterface.ApiUsuarios
import mx.itesm.testbasicapi.model.repository.responseinterface.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Usuario(private val token: String) {
    fun crearCuenta(nombre: String, apellido: String, correo: String, contrasenia: String, repetirContrasenia: String, callback: RespuestaCrearCuenta) {
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputCrearCuenta = InputCrearCuenta(nombre, apellido, correo, contrasenia, repetirContrasenia)

        val llamada = retrofit.create(ApiUsuarios::class.java).crearCuenta(inputCrearCuenta)

        llamada.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.isSuccessful) callback.enExito()
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun iniciarSesion(correo: String, contrasenia: String, callback: RespuestaIniciarSesion){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputIniciarSesion = InputIniciarSesion(correo, contrasenia)

        val llamada = retrofit.create(ApiUsuarios::class.java).iniciarSesion(inputIniciarSesion)

        llamada.enqueue(object : Callback<OutputIniciarSesion?> {
            override fun onResponse(call: Call<OutputIniciarSesion?>, response: Response<OutputIniciarSesion?>) {
                if (response.isSuccessful) callback.enExito(response.body())
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<OutputIniciarSesion?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun obtenerUsuario(token: String, callback: RespuestaObtenerUsuario) {
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputObtenerUsuario = InputObtenerUsuario(token)

        val llamada = retrofit.create(ApiUsuarios::class.java).obtenerUsuario(inputObtenerUsuario)

        llamada.enqueue(object : Callback<OutputObtenerUsuario?> {
            override fun onResponse(call: Call<OutputObtenerUsuario?>, response: Response<OutputObtenerUsuario?>) {
                if (response.isSuccessful) callback.enExito(response.body())
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<OutputObtenerUsuario?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun cambiarContrasenia(token: String, contrasenia: String, nuevaContrasenia: String, repetirNuevaContrasenia: String, callback: RespuestaCambiarContrasenia){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputCambiarContrasenia = InputCambiarContrasenia(token, contrasenia, nuevaContrasenia, repetirNuevaContrasenia)

        val llamada = retrofit.create(ApiUsuarios::class.java).cambiarContrasenia(inputCambiarContrasenia)

        llamada.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.isSuccessful) callback.enExito()
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun nombrarAdministrador(token: String, correo: String, agregarEliminar: Boolean, callback: RespuestaNombrarAdministrador){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputNombrarAdministrador = InputNombrarAdministrador(token, correo, agregarEliminar)

        val llamada = retrofit.create(ApiUsuarios::class.java).nombrarAdministrador(inputNombrarAdministrador)

        llamada.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.isSuccessful) callback.enExito()
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun nuevoAdministradorPrincipal(token: String, correo: String, callback: RespuestaNuevoAdministradorPrincipal){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputNuevoAdministradorPrincipal = InputNuevoAdministradorPrincipal(token, correo)

        val llamada = retrofit.create(ApiUsuarios::class.java).nuevoAdministradorPrincipal(inputNuevoAdministradorPrincipal)

        llamada.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.isSuccessful) callback.enExito()
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun bloquearVisitante(token: String, idUsuario: String, callback: RespuestaBloquearVisitante){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputBloquearVisitante = InputBloquearVisitante(token, idUsuario)

        val llamada = retrofit.create(ApiUsuarios::class.java).bloquearVisitante(inputBloquearVisitante)

        llamada.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.isSuccessful) callback.enExito()
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun bloquarReportesAnonimos(token: String, bloquearDesbloquear: Boolean, callback: RespuestaBloquearReportesAnonimos){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputBloquearReporte = InputBloquearReportesAnonimos(token, bloquearDesbloquear)

        val llamada = retrofit.create(ApiUsuarios::class.java).bloquearReportesAnonimos(inputBloquearReporte)

        llamada.enqueue(object : Callback<Void?> {
            override fun onResponse(call: Call<Void?>, response: Response<Void?>) {
                if (response.isSuccessful) callback.enExito()
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<Void?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }
}