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
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.model.Reporte
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerReporte
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaObtenerReporte


class LecturaReporte : Fragment() {
    lateinit var textoAsunto: TextView
    lateinit var textoTipo: TextView
    lateinit var textoDescripcion: TextView
    lateinit var botonResponder: Button
    lateinit var botonRegresar: Button

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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textoAsunto = view.findViewById(R.id.textoAsuntoReporte)
        textoTipo = view.findViewById(R.id.textoTipoReporte)
        textoDescripcion = view.findViewById(R.id.textoDescripcionReporte)

        //boton de responder
        botonResponder = view.findViewById(R.id.botonResponder)
        botonResponder.setOnClickListener {
            val fragmentListaReportes = Respuesta()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de regresar
        botonRegresar = view.findViewById(R.id.botonRegresarLecturaReporte)
        botonRegresar.setOnClickListener {
            val fragmentListaReportes = Reportes()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        Reporte(Utils.getToken(view.context)).obtenerReporte(Utils.getToken(view.context), Utils.obtenerIdReporte(view.context), object: RespuestaObtenerReporte {
            override fun enExito(outputObtenerReporte: OutputObtenerReporte?) {
                if(outputObtenerReporte != null) {
                    textoAsunto.text = outputObtenerReporte.title
                    textoTipo.text = outputObtenerReporte.incident_type
                    textoDescripcion.text = outputObtenerReporte.description
                }
            }

            override fun enErrorServidor(codigo: Int, mensaje: String) {
                Log.d("ErrorServidor", mensaje)
            }

            override fun enOtroError(t: Throwable) {
                Log.d("OtroError", t.message.toString())
            }
        })
    }

}