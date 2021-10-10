package mx.itesm.testbasicapi.model.repository.responseinterface

import mx.itesm.testbasicapi.model.entities.EUsuario
import mx.itesm.testbasicapi.model.entities.JwtToken

interface IRespuestaBasica {
    fun enErrorServidor(codigo: Int, mensaje: String)
    fun enOtroError(t: Throwable)
}

interface ICrearCuenta: IRespuestaBasica {
    fun enExito(cuentaCreada: Boolean?)
}

interface IIniciarSesion: IRespuestaBasica {
    fun enExito(token: JwtToken?)
}

interface IObtenerUsuario: IRespuestaBasica {
    fun enExito(usuario: EUsuario?)
}