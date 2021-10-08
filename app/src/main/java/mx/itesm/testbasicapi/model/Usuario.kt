package mx.itesm.testbasicapi.model

import mx.itesm.testbasicapi.model.entities.ECorreoContrasenia
import mx.itesm.testbasicapi.model.entities.EDatosCrearCuenta
import mx.itesm.testbasicapi.model.entities.EUsuario
import mx.itesm.testbasicapi.model.entities.JwtToken
import mx.itesm.testbasicapi.model.repository.RemoteRepository
import mx.itesm.testbasicapi.model.repository.backendinterface.ApiUsuarios
import mx.itesm.testbasicapi.model.repository.responseinterface.ICrearCuenta
import mx.itesm.testbasicapi.model.repository.responseinterface.IIniciarSesion
import mx.itesm.testbasicapi.model.repository.responseinterface.IObtenerUsuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Usuario(private val token: String) {
    fun iniciarSesion(correo: String, contrasenia: String, callback: IIniciarSesion){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val correoContrasenia = ECorreoContrasenia(correo, contrasenia)

        val llamada = retrofit.create(ApiUsuarios::class.java).iniciarSesion(correoContrasenia)

        llamada.enqueue(object : Callback<JwtToken?> {
            override fun onResponse(call: Call<JwtToken?>, response: Response<JwtToken?>) {
                if (response.isSuccessful) callback.enExito(response.body())
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<JwtToken?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun crearCuenta(nombre: String, apellido: String, correo: String, contrasenia: String, repetirContrasenia: String, callback: ICrearCuenta) {
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val datosCrearCuenta = EDatosCrearCuenta(nombre, apellido, correo, contrasenia, repetirContrasenia)

        val llamada = retrofit.create(ApiUsuarios::class.java).crearCuenta(datosCrearCuenta)

        llamada.enqueue(object : Callback<Boolean?> {
            override fun onResponse(call: Call<Boolean?>, response: Response<Boolean?>) {
                if (response.isSuccessful) callback.enExito(response.body())
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun obtenerUsuario(callback: IObtenerUsuario) {
        val retrofit = RemoteRepository.getRetrofitInstance(token)

        val llamada = retrofit.create(ApiUsuarios::class.java).obtenerUsuario("615c8333eb6e09bc8994be20")

        llamada.enqueue(object : Callback<EUsuario?> {
            override fun onResponse(call: Call<EUsuario?>, response: Response<EUsuario?>) {
                if (response.isSuccessful) callback.enExito(response.body())
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<EUsuario?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }
}