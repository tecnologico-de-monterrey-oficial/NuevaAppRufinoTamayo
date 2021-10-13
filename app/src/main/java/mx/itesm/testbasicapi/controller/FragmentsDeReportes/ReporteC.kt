package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.activities.Autenticacion
import mx.itesm.testbasicapi.controller.activities.Inicio


class ReporteC : Fragment() {

    lateinit var botonIniciarConCuentaa: Button
    lateinit var botonSeguirSinCuentaa: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_reporte_c, container, false)
        //boton ir a iniciar cuenta
        botonIniciarConCuentaa = view.findViewById(R.id.iniciarSesionDesdeReporteVisitanteBTN)
        botonIniciarConCuentaa.setOnClickListener {
            val intentAutenticacion = Intent(view.context, Autenticacion::class.java)
            intentAutenticacion.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentAutenticacion)
        }

        //boton seguir sin cuenta
        botonSeguirSinCuentaa = view.findViewById(R.id.continuarConElReporteVisitanteBTN)
        botonSeguirSinCuentaa.setOnClickListener {

            val fragment = ReporteA()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }


        return view
    }


}
