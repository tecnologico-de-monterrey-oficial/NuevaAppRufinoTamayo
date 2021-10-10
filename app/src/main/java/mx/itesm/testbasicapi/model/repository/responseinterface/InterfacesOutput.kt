package mx.itesm.testbasicapi.model.repository.responseinterface

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
    var last_name: String
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

class OutputObtenerReporte(
    var user_id: String,
    var name: String,
    var last_name: String,
    var subject: String,
    var type_of_incident: String,
    var description: String,
    var is_urgent: String,
    var status: String,
    var photo: String?,
    var location: String?
) {}

interface RespuestaObtenerReporte: IRespuestaBasica {
    fun enExito(outputObtenerReporte: OutputObtenerReporte?)
}

class OutputObtenerResumenesReportes(
    var subject: String,
    var type_of_incident: String,
    var status: String,
    var is_urgent: String
) {}

interface RespuestaObtenerResumenesReportes: IRespuestaBasica {
    fun enExito(outputObtenerResumenesReportes: List<OutputObtenerResumenesReportes>?)
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