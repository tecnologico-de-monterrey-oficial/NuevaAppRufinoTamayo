package mx.itesm.testbasicapi.controller

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteB
import mx.itesm.testbasicapi.controller.activities.Autenticacion

class Visitante : Fragment() {
    lateinit var botonReportarIncidente: Button
    lateinit var botonMisReportes: Button
    lateinit var botonReportesIncidentes: Button
    lateinit var botonReglamentoParque: Button
    lateinit var botonAdministracion: Button
    lateinit var botonCerrarSesion: Button

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

        botonReportarIncidente = view.findViewById(R.id.botonPantallaReportar)
        botonMisReportes = view.findViewById(R.id.botonPantallaMisReportes)
        botonReportesIncidentes = view.findViewById(R.id.botonReportesIncidentes)
        botonReglamentoParque = view.findViewById(R.id.botonPantallaReglamento)
        botonAdministracion = view.findViewById(R.id.botonAdministracion)
        botonCerrarSesion = view.findViewById(R.id.botonCerrarSesion)

        botonReportesIncidentes.setVisibility(View.GONE)
        botonAdministracion.setVisibility(View.GONE)
        botonCerrarSesion.setVisibility(View.GONE)

        //Boton de reportar incidentes
        botonReportarIncidente.setOnClickListener {
            val fragment = ReporteB()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de mis reportes
        botonMisReportes.setOnClickListener {
            val fragment = ReportesVisitante()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de reglamento
        botonReglamentoParque.setOnClickListener {
            val fragment = Reglamento()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        // Boton para Cerrar Sesion
        botonCerrarSesion.setOnClickListener{
            Utils.deleteToken(view.context)
            val intentAutenticacion = Intent(view.context, Autenticacion::class.java)
            intentAutenticacion.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentAutenticacion)
        }
    }
}