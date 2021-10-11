package mx.itesm.testbasicapi.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteC


class RespuestaVisitante : Fragment() {
    lateinit var botonResponder: Button
    lateinit var botonEnviar: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_respuesta_visitante, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //boton de regresar
        botonResponder = view.findViewById(R.id.regresarRespuestaVisitanteBTN)
        botonResponder.setOnClickListener {
            val fragmentListaReportes = ReportesVisitante()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de enviar respuesta
        botonEnviar = view.findViewById(R.id.enviarRespuesta)
        botonEnviar.setOnClickListener {

            //TODO enviar esto
/*
            val respuesta = view.findViewById<TextView>(R.id.responderReporte)

            respuesta.text

            */


            val fragmentListaReportes = ReportesVisitante()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }


}