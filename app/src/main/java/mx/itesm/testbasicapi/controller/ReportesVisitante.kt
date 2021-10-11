package mx.itesm.testbasicapi.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteC


class ReportesVisitante : Fragment() {
    lateinit var botonRegresar: Button
    lateinit var botonResponder: Button

    lateinit var respuesta: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reportes_visitante, container, false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        respuesta = view.findViewById(R.id.descripcionReporteOutputTXT)

        respuesta.text="respuesta" //TODO conexion

        //boton de responder
        botonResponder = view.findViewById(R.id.enviarRespuesta)
        botonResponder.setOnClickListener {
            //enviar esto: responderReporte.text


            //TODO enviar respuesta

            Toast.makeText(requireActivity(), "Respuesta enviada", Toast.LENGTH_LONG).show()
        }

        //boton de regresar
        botonRegresar = view.findViewById(R.id.regresarDeReportes)
        botonRegresar.setOnClickListener {
            val fragmentListaReportes = Visitante()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }


}