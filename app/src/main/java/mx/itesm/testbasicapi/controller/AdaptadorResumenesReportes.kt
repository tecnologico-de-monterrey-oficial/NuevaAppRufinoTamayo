package mx.itesm.testbasicapi.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.model.repository.RemoteRepository
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerResumenesReportes

// https://guides.codepath.com/android/using-the-recyclerview
// class ProductsAdapter(private val listOfProducts: List<Product>) :
class AdaptadorResumenesReportes(
    private val products: List<OutputObtenerResumenesReportes>,
    private val clickListener: OnItemClickListener,
    private val token: String,
    private val context: Context
) :
    RecyclerView.Adapter<AdaptadorResumenesReportes.ViewHolder>() {

    // 2nd step to handle clicks
    // Define listener member variable
    interface OnItemClickListener {
        fun onItemClick(item: OutputObtenerResumenesReportes)
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    // commented line is first step, second line is for handling the clicks
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val textoAsunto: TextView = itemView.findViewById(R.id.textoResumenAsunto)
        val textoTipo: TextView = itemView.findViewById(R.id.textoResumenTipo)
        val textoEstado: TextView = itemView.findViewById(R.id.textoResumenEstado)
    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorResumenesReportes.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val productView = inflater.inflate(R.layout.resumen_reporte, parent, false)
        // Return a new holder instance
        return ViewHolder(productView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: AdaptadorResumenesReportes.ViewHolder, position: Int) {
        // https://stackoverflow.com/questions/49969278/recyclerview-item-click-listener-the-right-way
        // Get the data model based on position
        val product: OutputObtenerResumenesReportes = products[position]
        viewHolder.textoAsunto.text = product.title
        //val textForPrice = String.format("Get them for only $%.2f", product.price)
        viewHolder.textoTipo.text = product.incident_type
        viewHolder.textoEstado.text = product.status

        //if (product.photoPath != null && product.photoPath!!.isNotBlank()) {
            // val urlForImage = "${BASE_URL}products/images/${product.photoPath}"
            // Picasso.get().load(urlForImage).into(viewHolder.imgProductPhoto);
            //askForImage(product.photoPath!!, viewHolder)
        //}

        // Second step: handling the clicks
        viewHolder.itemView.setOnClickListener {
            clickListener.onItemClick(product)
        }
    }

    /*private fun askForImage(photoPath: String, viewHolder: ViewHolder) {
        val picasso = RemoteRepository.getPicassoInstance(context, token)
        val urlForImage = "${Utils.BASE_URL}products/images/$photoPath"
        picasso.load(urlForImage).into(viewHolder.imgProductPhoto);
    }*/

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return products.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        // return super.getItemViewType(position)
        return position
    }
}