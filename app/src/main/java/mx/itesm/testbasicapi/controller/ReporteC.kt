package mx.itesm.testbasicapi.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mx.itesm.testbasicapi.R


class ReporteC : Fragment() {
    lateinit var botonSeguirSinCuentaa: Button
    lateinit var botonSeguirConCuenta: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reporte_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //boton de seguir sin cuenta
        botonSeguirSinCuentaa = view.findViewById(R.id.continuarConElReporteVisitanteBTN)
        botonSeguirSinCuentaa.setOnClickListener {
            val fragmentListaReportes = ReporteD()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.actividadInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de seguir con cuenta
        botonSeguirConCuenta = view.findViewById(R.id.iniciarSesionDesdeReporteVisitanteBTN)
        botonSeguirConCuenta.setOnClickListener {
            val fragmentListaReportes = ReporteD()  //TODO AQUI HAY QUE CHECAR LO DE LOGIN DESDE EL REPORTE
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.actividadInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }


}