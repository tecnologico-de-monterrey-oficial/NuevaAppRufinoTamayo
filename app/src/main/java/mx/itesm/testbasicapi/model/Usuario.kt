package mx.itesm.testbasicapi.model

import mx.itesm.testbasicapi.model.entities.CorreoContrasenia
import mx.itesm.testbasicapi.model.entities.JwtToken
import mx.itesm.testbasicapi.model.entities.User
import mx.itesm.testbasicapi.model.repository.RemoteRepository
import mx.itesm.testbasicapi.model.repository.backendinterface.ApiUsuarios
import mx.itesm.testbasicapi.model.repository.backendinterface.UsersApi
import mx.itesm.testbasicapi.model.repository.responseinterface.IIniciarSesion
import mx.itesm.testbasicapi.model.repository.responseinterface.ILogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Usuario(private val token: String) {
    fun iniciarSesion(correo: String, contrasenia: String, callback: IIniciarSesion){ //
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val correoContrasenia = CorreoContrasenia(correo, contrasenia)

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
}