package mx.itesm.testbasicapi.model.entities.ejemplo

import com.google.gson.annotations.SerializedName

class Product(
    @SerializedName("_id") var id: String,
    var name: String,
    var price: Double,
    var photoPath: String?
) {
}