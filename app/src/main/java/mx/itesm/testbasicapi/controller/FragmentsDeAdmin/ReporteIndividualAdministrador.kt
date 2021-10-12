package mx.itesm.testbasicapi.controller.FragmentsDeAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_reporte_individual_administrador.view.*
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.FragmentsDeAdmin.ReportesAdministrador
import mx.itesm.testbasicapi.controller.FragmentsDeAdmin.RespuestaAdministrador


class ReporteIndividualAdministrador : Fragment() {
    lateinit var botonResponder: Button
    lateinit var botonRegresar: Button
    lateinit var botonMapa: Button




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view =inflater.inflate(
            R.layout.fragment_reporte_individual_administrador,
            container,
            false
        )

        view.tituloReporte.text = "el text" // aqui
        view.descripcionReporte.text = "el otro text" //el otro

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        //boton de responder
        botonResponder = view.findViewById(R.id.enviarRespuestaBTN)
        botonResponder.setOnClickListener {
            val fragmentListaReportes = RespuestaAdministrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de regresar
        botonRegresar = view.findViewById(R.id.regresarDeRespuesta)
        botonRegresar.setOnClickListener {
            val fragmentListaReportes = ReportesAdministrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de mapa
        botonMapa = view.findViewById(R.id.buttonMapa)
        botonMapa.setOnClickListener {
            val fragmentListaReportes = MapsFragment()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }

}