package mx.itesm.testbasicapi.model.repository.backendinterface

import mx.itesm.testbasicapi.model.entities.*
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputIniciarSesion
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerReporte
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerRespuestasReporte
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerResumenesReportes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiReportes {
    @POST("api/report/register_report")
    fun crearReporte(@Body inputCrearReporte: InputCrearReporte): Call<Void>

    @GET("api/report/get_report")
    fun obtenerReporte(inputObtenerReporte: InputObtenerReporte): Call<OutputObtenerReporte>

    @PUT("api/report/get_summaries")
    fun obtenerResumenesReportes(@Body inputObtenerResumenesReportes: InputObtenerResumenesReportes): Call<List<OutputObtenerResumenesReportes>>

    @POST("api/report/reply")
    fun responderReporte(inputResponderReporte: InputResponderReporte): Call<Void>

    @GET("api/report/get_replies")
    fun obtenerRespuestasReporte(inputObtenerRespuestasReporte: InputObtenerRespuestasReporte): Call<List<OutputObtenerRespuestasReporte>>
}