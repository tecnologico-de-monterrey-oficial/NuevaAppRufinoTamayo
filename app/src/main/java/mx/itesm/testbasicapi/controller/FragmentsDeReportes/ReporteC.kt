package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import mx.itesm.testbasicapi.R


class ReporteC : Fragment() {

    lateinit var botonIniciarConCuentaa: Button
    lateinit var botonSeguirSinCuentaa: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_reporte_c, container, false)
    }

        val view = inflater.inflate(R.layout.fragment_reporte_a, container, false)


        //boton ir a iniciar cuenta
        botonIniciarConCuentaa = view.findViewById(R.id.iniciarSesionDesdeReporteVisitanteBTN)
        botonIniciarConCuentaa.setOnClickListener {

            val fragment = ReporteD()  //TODO AQUI VA AL FRAGMENT PARA QUE INICIE SESION
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton seguir sin cuenta
        botonSeguirSinCuentaa = view.findViewById(R.id.continuarConElReporteVisitanteBTN)
        botonSeguirSinCuentaa.setOnClickListener {

            val fragment = ReporteD()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

    }


}
