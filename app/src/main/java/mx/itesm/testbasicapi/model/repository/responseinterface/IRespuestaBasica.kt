package mx.itesm.testbasicapi.model.repository.responseinterface

interface IRespuestaBasica {
    // Error en el servidor
    fun enErrorServidor(codigo: Int, mensaje: String)

    // CualquierOtroError
    fun enOtroError(t: Throwable)
}