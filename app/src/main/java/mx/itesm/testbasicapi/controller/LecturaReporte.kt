package mx.itesm.testbasicapi.controller

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.FragmentsDeAdmin.RespuestaAdministrador


class LecturaReporte : Fragment() {
    lateinit var textoAsunto: TextView
    lateinit var textoTipo: TextView
    lateinit var textoDescripcion: TextView
    lateinit var botonResponder: Button
    lateinit var botonRegresar: Button
    var displayMessage: String? = ""
    var idReporte = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =inflater.inflate(
            R.layout.fragment_lectura_reporte,
            container,
            false
        )

        displayMessage = arguments?.getString("id")
        val aux = displayMessage.toString()
        Log.d("Este es el aux -> ", aux)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayMessage = arguments?.getString("id")
        val aux = displayMessage.toString()



        //boton de responder
        botonResponder = view.findViewById(R.id.botonResponder)
        botonResponder.setOnClickListener {
            val fragmentListaReportes = RespuestaAdministrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        botonResponder.text = aux

        //boton de regresar
        botonRegresar = view.findViewById(R.id.botonRegresarLecturaReporte)
        botonRegresar.setOnClickListener {
            val fragmentListaReportes = Reportes()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de mapa
        /*botonMapa = view.findViewById(R.id.buttonMapa)
        botonMapa.setOnClickListener {
            val fragmentListaReportes = MapsFragment()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }*/
    }

}