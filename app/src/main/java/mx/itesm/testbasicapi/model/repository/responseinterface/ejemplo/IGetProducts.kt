package mx.itesm.testbasicapi.model.repository.responseinterface.ejemplo

import mx.itesm.testbasicapi.model.entities.ejemplo.Product

interface IGetProducts : IBasicResponse {
    fun onSuccess(products: List<Product>?)
}