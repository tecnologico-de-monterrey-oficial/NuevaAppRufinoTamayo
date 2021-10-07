package mx.itesm.testbasicapi.model.repository.responseinterface.ejemplo

import mx.itesm.testbasicapi.model.entities.ejemplo.Product

interface IUpdateProduct: IBasicResponse {
    fun onSuccess(product: Product?)
}