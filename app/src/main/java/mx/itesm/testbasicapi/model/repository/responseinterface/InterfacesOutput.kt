package mx.itesm.testbasicapi.model.repository.responseinterface

import com.google.gson.annotations.SerializedName
import mx.itesm.testbasicapi.model.entities.EUsuario
import mx.itesm.testbasicapi.model.entities.JwtToken

interface IRespuestaBasica {
    fun enErrorServidor(codigo: Int, mensaje: String)
    fun enOtroError(t: Throwable)
}

// Usuarios

interface RespuestaCrearCuenta: IRespuestaBasica {
    fun enExito()
}

class OutputIniciarSesion(
    var token: String,
    var user_id: String
) {}

interface RespuestaIniciarSesion: IRespuestaBasica {
    fun enExito(outputIniciarSesion: OutputIniciarSesion?)
}

class OutputObtenerUsuario(
    var user_id: String,
    var name: String,
    var last_name: String,
    var type: String
) {}

interface RespuestaObtenerUsuario: IRespuestaBasica {
    fun enExito(outputObtenerUsuario: OutputObtenerUsuario?)
}

interface RespuestaCambiarContrasenia: IRespuestaBasica {
    fun enExito()
}

interface RespuestaNombrarAdministrador: IRespuestaBasica {
    fun enExito()
}

interface RespuestaNuevoAdministradorPrincipal: IRespuestaBasica {
    fun enExito()
}

interface RespuestaBloquearReportesAnonimos: IRespuestaBasica {
    fun enExito()
}

interface RespuestaBloquearVisitante: IRespuestaBasica {
    fun enExito()
}

// Reportes

interface RespuestaCrearReporte: IRespuestaBasica {
    fun enExito()
}

class OutputObtenerReporte(
    var report_id: String,
    var user_id: String,
    var title: String,
    var incident_type: String,
    var description: String,
    var urgency_level: Boolean,
    var status: String,
    var date: String,
    var name: String,
    var last_name: String
) {}

interface RespuestaObtenerReporte: IRespuestaBasica {
    fun enExito(outputObtenerReporte: OutputObtenerReporte?)
}

class OutputObtenerResumenesReportes(
    var report_id: String,
    var title: String,
    var incident_type: String,
    var urgency_level: Boolean,
    var status: String
) {}

interface RespuestaObtenerResumenesReportes: IRespuestaBasica {
    fun enExito(outputObtenerResumenesReportes: List<OutputObtenerResumenesReportes>?)
}

interface RespuestaResponderReporte: IRespuestaBasica {
    fun enExito()
}

class OutputObtenerRespuestasReporte(
    var name: String,
    var last_name: String,
    var is_admin: String,
    var message: String,
    date: String,
    hour: String
) {}

interface RespuestaObtenerRespuestasReporte: IRespuestaBasica {
    fun enExito(outputObtenerRespuestasReporte: List<OutputObtenerRespuestasReporte>?)
}