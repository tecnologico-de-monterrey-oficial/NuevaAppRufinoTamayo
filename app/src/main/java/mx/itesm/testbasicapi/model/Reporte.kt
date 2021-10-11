package mx.itesm.testbasicapi.model

import mx.itesm.testbasicapi.model.entities.*
import mx.itesm.testbasicapi.model.repository.RemoteRepository
import mx.itesm.testbasicapi.model.repository.backendinterface.ApiReportes
import mx.itesm.testbasicapi.model.repository.responseinterface.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Reporte(private val token: String) {
    fun crearReporte(token: String, asunto: String, tipoIncidente: String, descripcion: String, esUrgente: Boolean, foto: String?, ubicacion: String?, callback: RespuestaCrearReporte){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputCrearReporte = InputCrearReporte(token, asunto, tipoIncidente, descripcion, esUrgente, foto, ubicacion)

        val llamada = retrofit.create(ApiReportes::class.java).crearReporte(inputCrearReporte)

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

    fun obtenerReporte(token: String, idReporte: String, callback: RespuestaObtenerReporte){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputObtenerReporte = InputObtenerReporte(token, idReporte)

        val llamada = retrofit.create(ApiReportes::class.java).obtenerReporte(inputObtenerReporte)

        llamada.enqueue(object : Callback<OutputObtenerReporte?> {
            override fun onResponse(call: Call<OutputObtenerReporte?>, response: Response<OutputObtenerReporte?>) {
                if (response.isSuccessful) callback.enExito(response.body())
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<OutputObtenerReporte?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }

    fun obtenerResumenesReportes(token: String, idUsuario: String?, tipoIncidente: String?, tipoVisitante: String?, estado: String?, antiguedad: String?, callback: RespuestaObtenerResumenesReportes){
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

    fun responderReporte(token: String, idReporte: String, mensaje: String, nuevoEstado: String?, callback: RespuestaResponderReporte){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputResponderReporte = InputResponderReporte(token, idReporte, mensaje, nuevoEstado)

        val llamada = retrofit.create(ApiReportes::class.java).responderReporte(inputResponderReporte)

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

    fun obtenerRespuestasReporte(token: String, idReporte: String, callback: RespuestaObtenerRespuestasReporte){
        val retrofit = RemoteRepository.getRetrofitInstance(token)
        val inputObtenerRespuestasReporte = InputObtenerRespuestasReporte(token, idReporte)

        val llamada = retrofit.create(ApiReportes::class.java).obtenerRespuestasReporte(inputObtenerRespuestasReporte)

        llamada.enqueue(object : Callback<List<OutputObtenerRespuestasReporte>?> {
            override fun onResponse(call: Call<List<OutputObtenerRespuestasReporte>?>, response: Response<List<OutputObtenerRespuestasReporte>?>) {
                if (response.isSuccessful) callback.enExito(response.body())
                else {
                    val message: String = if (response.errorBody() != null)
                        response.errorBody()!!.string()
                    else
                        response.message()
                    callback.enErrorServidor(response.code(), message)
                }
            }

            override fun onFailure(call: Call<List<OutputObtenerRespuestasReporte>?>, t: Throwable) {
                callback.enOtroError(t)
            }
        })
    }
}