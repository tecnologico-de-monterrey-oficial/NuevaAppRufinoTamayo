package mx.itesm.testbasicapi.model.entities

import com.google.gson.annotations.SerializedName

// Usuarios

class InputCrearCuenta(
    var name: String,
    var last_name: String,
    var email: String,
    var password: String,
    var repeated_password: String
) {}

class InputIniciarSesion(
    var email: String,
    var password: String
) {}

class InputCambiarContrasenia(
    var password: String,
    var new_password: String,
    var repeated_new_password: String
) {}

class InputNombrarAdministrador(
    var token: String,
    var email: String,
    var add_or_delete: Boolean
) {}

class InputNuevoAdministradorPrincipal(
    var token: String,
    var email: String
) {}

class InputBloquearVisitante(
    var token: String,
    var user_id: String
) {}

class InputBloquearReportesAnonimos(
    var token: String,
    var block: Boolean
) {}

// Reportes

class InputCrearReporte(
    var title: String,
    var incident_type: String,
    var description: String,
    var urgency_level: Boolean,
    var photo: String?,
    var location: String?
) {}

class InputObtenerReporte(
    var report_id: String
) {}

class InputObtenerResumenesReportes(
    var user_id: String?,
    var incident_type: String?,
    var visitor_type: String?,
    var status: String?,
    var antiquity: String?
) {}

class InputResponderReporte(
    var token: String,
    var report_id: String,
    var message: String,
    var new_status: String?
) {}

class InputObtenerRespuestasReporte(
    var token: String,
    var report_id: String
) {}

// Otras Cosas

class EUsuario(
    @SerializedName("_id") var id: String,
    var email: String,
    var password: String,
    var name: String,
    var last_name: String,
    var type: Int
) {}

class JwtToken(
    var token: String
) {}