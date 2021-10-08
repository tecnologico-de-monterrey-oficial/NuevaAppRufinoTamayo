package mx.itesm.testbasicapi.model.repository.responseinterface.ejemplo

interface ILogin : IBasicResponse {
    fun onSuccess(token: JwtToken?)
}