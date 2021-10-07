package mx.itesm.testbasicapi.model.entities

import com.google.gson.annotations.SerializedName

class EUsuario(
    @SerializedName("_id") var id: String,
    var correo: String,
    var contrasenia: String,
    var nombre: String,
    var apellido: String,
    var tipoUsuario: Int,
    var token: String
) {}