package mx.itesm.testbasicapi.model.repository.backendinterface

import mx.itesm.testbasicapi.model.entities.InputIniciarSesion
import mx.itesm.testbasicapi.model.entities.InputObtenerResumenesReportes
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputIniciarSesion
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerResumenesReportes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiReportes {
    @GET("api/report/get_summaries")
    fun obtenerResumenesReportes(inputObtenerResumenesReportes: InputObtenerResumenesReportes): Call<List<OutputObtenerResumenesReportes>>
}