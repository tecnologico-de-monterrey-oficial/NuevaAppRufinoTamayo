package mx.itesm.testbasicapi.model.repository.responseinterface

import mx.itesm.testbasicapi.model.entities.EUsuario
import mx.itesm.testbasicapi.model.entities.JwtToken

interface IIniciarSesion: IRespuestaBasica {
    fun enExito(token: JwtToken?)
}