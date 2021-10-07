package mx.itesm.testbasicapi.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.ejemplo.AddProductFragment

class Visitante : Fragment() {
    lateinit var botonReportarIncidente: Button
    lateinit var botonMisReportes: Button
    lateinit var botonReglamento: Button
    lateinit var botonTemporal: Button
    lateinit var botonTemporal2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_visitante, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Boton de reportar incidentes
        botonReportarIncidente = view.findViewById(R.id.botonPantallaReportar)
        botonReportarIncidente.setOnClickListener {
            val fragment = ReporteA()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de mis reportes
        botonMisReportes = view.findViewById(R.id.botonPantallaMisReportes)
        botonMisReportes.setOnClickListener {
            val fragment = ReportesVisitante()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de reglamento
        botonReglamento = view.findViewById(R.id.botonPantallaReglamento)
        botonReglamento.setOnClickListener {
            val fragment = Reglamento()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton temporal de inicio de sesion
        botonTemporal = view.findViewById(R.id.goToSesion)
        botonTemporal.setOnClickListener {
            val fragment = conCuenta()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton temporal de inicio de sesion para admin
        botonTemporal2 = view.findViewById(R.id.goToAdmin)
        botonTemporal2.setOnClickListener {
            val fragment = Administrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.actividadInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }



    }


}