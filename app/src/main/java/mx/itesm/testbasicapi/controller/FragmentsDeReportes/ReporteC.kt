package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.*
import mx.itesm.testbasicapi.R
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import java.util.*
import androidx.core.location.LocationManagerCompat.getCurrentLocation
import kotlinx.android.synthetic.main.fragment_reporte_c.view.*
import kotlinx.android.synthetic.main.fragment_reporte_d.*
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.controller.FragmentsDeAdmin.ReporteIndividualAdministrador
import mx.itesm.testbasicapi.model.Reporte
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaCrearCuenta
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaCrearReporte


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //boton ir a iniciar cuenta
        botonIniciarConCuentaa = view.findViewById(R.id.iniciarSesionDesdeReporteVisitanteBTN)
        botonIniciarConCuentaa.setOnClickListener {

            val fragment = ReporteD()  //TODO AQUI VA AL FRAGMENT PARA QUE INICIE SESION
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
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
