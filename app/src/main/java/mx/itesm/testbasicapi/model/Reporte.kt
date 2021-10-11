package mx.itesm.testbasicapi.model

import mx.itesm.testbasicapi.model.entities.InputObtenerResumenesReportes
import mx.itesm.testbasicapi.model.repository.RemoteRepository
import mx.itesm.testbasicapi.model.repository.backendinterface.ApiReportes
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerResumenesReportes
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaObtenerResumenesReportes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Reporte(private val token: String) {
    fun obtenerResumenesReportes(token: String, idUsuario: String?, tipoIncidente: String?, tipoVisitante: String?, estado: String?, antiguedad: String, callback: RespuestaObtenerResumenesReportes){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputObtenerResumenesReportes = InputObtenerResumenesReportes(token, idUsuario, tipoIncidente, tipoVisitante, estado, antiguedad)

        val llamada = retrofit.create(ApiReportes::class.java).obtenerResumenesReportes(inputObtenerResumenesReportes)

        llamada.enqueue(object : Callback<List<OutputObtenerResumenesReportes>?> {
            override fun onResponse(call: Call<List<OutputObtenerResumenesReportes>?>, response: Response<List<OutputObtenerResumenesReportes>?>) {
                if (response.isSuccessful) callback.enExito(response.body())
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<List<OutputObtenerResumenesReportes>?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }
}