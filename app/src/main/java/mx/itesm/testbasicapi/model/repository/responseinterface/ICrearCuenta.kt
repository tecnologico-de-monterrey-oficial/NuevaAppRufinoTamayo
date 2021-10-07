package mx.itesm.testbasicapi.model.repository.responseinterface

interface ICrearCuenta: IRespuestaBasica {
    fun enExito(cuentaCreada: Boolean?)
}