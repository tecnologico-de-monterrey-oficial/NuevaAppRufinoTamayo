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

class InputObtenerUsuario(
    var token: String,
    var email: String
) {}

class InputCambiarContrasenia(
    var token: String,
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

class InputObtenerResumenesReportes(
    var token: String,
    var user_id: String?,
    var type_of_incident: String?,
    var type_of_visitor: String?,
    var status: String?,
    var antiquity: String?
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