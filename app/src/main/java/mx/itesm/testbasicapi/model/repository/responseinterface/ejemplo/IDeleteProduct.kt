package mx.itesm.testbasicapi.model.repository.responseinterface.ejemplo

import mx.itesm.testbasicapi.model.entities.ejemplo.Product

interface IDeleteProduct: IBasicResponse {
    fun onSuccess(product: Product?)
}