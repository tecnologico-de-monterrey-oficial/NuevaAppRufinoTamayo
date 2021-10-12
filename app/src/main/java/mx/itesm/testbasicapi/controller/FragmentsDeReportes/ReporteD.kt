package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.*
import mx.itesm.testbasicapi.R
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*
import android.widget.Toast
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.fragment_reporte_b.view.*
import kotlinx.android.synthetic.main.fragment_reporte_c.view.*
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.controller.Menu
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaCrearCuenta


class ReporteD : Fragment() {
    lateinit var botonFinalizar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_reporte_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //boton finalizar
        botonFinalizar = view.findViewById(R.id.botonFinalizar)
        botonFinalizar.setOnClickListener {

            val fragment = Menu()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }
}
