package mx.itesm.testbasicapi.model.entities

import com.google.gson.annotations.SerializedName

class ECorreoContrasenia(
    var email: String,
    var password: String
) {}

class EDatosCrearCuenta(
    var name: String,
    var last_name: String,
    var email: String,
    var password: String,
    var repeated_password: String
) {}

class EUsuario(
    @SerializedName("_id") var id: String,
    var email: String,
    var password: String,
    var name: String,
    var last_name: String,
    var type: Int
) {}

class JwtToken(
    var token:String
) {}