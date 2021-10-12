package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationRequest
import android.os.Bundle
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
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
import android.widget.Toast
import androidx.core.location.LocationManagerCompat.getCurrentLocation
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.fragment_reporte_c.view.*
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.controller.FragmentsDeAdmin.ReporteIndividualAdministrador
import mx.itesm.testbasicapi.model.Reporte
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaCrearCuenta
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaCrearReporte


class ReporteC : Fragment() {
    lateinit var GPSSwitch: Switch

    lateinit var tvLatitude: TextView
    lateinit var tvLongitude: TextView
    lateinit var descripcionReporte : TextView

    private val lista = ArrayList<String>(7)

    var auxiliar = ""
    var displayMessage: String? = ""

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    lateinit var botonSiguiente: Button

    var asunto =""
    var tipo =""
    var urgente =""
    var descripcion =""




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reporte_c, container, false)
        // Inflate the layout for this fragment
        displayMessage = arguments?.getString("message")
        val aux = displayMessage.toString()
        val list= listOf(*aux.split(",").toTypedArray())
        asunto=list.elementAt(0)
        urgente = list.elementAt(1)
        descripcion = list.elementAt(2)
        tipo = list.elementAt(3)

        view.tv_lat.text = auxiliar

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvLatitude = view.findViewById(R.id.tv_lat)
        tvLongitude = view.findViewById(R.id.tv_lon)
        descripcionReporte = view.findViewById(R.id.descripcionReporteInputTXT)



        //switch gps
        GPSSwitch = view.findViewById(R.id.GPSSwitch)
        GPSSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

                checkLocationPermission()
            } else {
                sinGps()
            }


        })

        //boton siguiente
        botonSiguiente = view.findViewById(R.id.botonSiguiente)
        botonSiguiente.setOnClickListener {

            var urgenteBool = false
            var foto = "foto prueba"
            var coords = tvLatitude.text.toString().plus(" ").plus(tvLongitude.text.toString())

            if(urgente == "1"){
                urgenteBool = true
            }
            }
            /*
            asunto
            urgenteBool
            descripcion
            tipo
            foto
            coords
            */

            Toast.makeText(requireActivity(), asunto, Toast.LENGTH_SHORT).show()
            //Log.d("token", Utils.getToken(view.context))

            val fragmentListaReportes = ReporteIndividualAdministrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
/*
            Reporte(Utils.getToken(view.context)).crearReporte(Utils.getToken(view.context), asunto, tipo, descripcion, urgente,foto, coords,  object:
                RespuestaCrearReporte {

                override fun enExito() {/*
                    Toast.makeText(requireActivity(), "Se envio correctamente", Toast.LENGTH_SHORT).show()
                    val fragmentListaReportes = ReporteD()
                    val transaccionFragmento = parentFragmentManager.beginTransaction()
                    transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
                    transaccionFragmento.addToBackStack(null)
                    transaccionFragmento.commit()*/
                    //https://experiencia21.tec.mx/courses/182802/pages/mis-clases
                }

                override fun enErrorServidor(codigo: Int, mensaje: String) {/*
                    Toast.makeText(requireActivity(), mensaje, Toast.LENGTH_SHORT).show()*/

                }

                override fun enOtroError(t: Throwable) {/*
                    Toast.makeText(requireActivity(), "Algo salio mal, vuelte a intentarlo mas tarde", Toast.LENGTH_SHORT).show()*/

                }
            })*/







            //Toast.makeText(requireActivity(), auxiliar, Toast.LENGTH_SHORT).show()


/*
            val fragmentListaReportes = ReporteD()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()*/
        }




    }

    private fun sinGps() {
        tvLatitude.setText("0")
        tvLongitude.setText("0")
        Toast.makeText(requireActivity(), "Si es necesario especifica la ubicacion en la descripcion", Toast.LENGTH_SHORT).show()
        return
    }

    private fun checkLocationPermission() {
        val task = fusedLocationProviderClient.lastLocation
        if(ActivityCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
        }

        task.addOnSuccessListener {
            //Toast.makeText(requireActivity(), "prueba", Toast.LENGTH_SHORT).show()
            if(it != null){
                tvLatitude.setText(it.getLatitude().toString())
                tvLongitude.setText(it.getLongitude().toString())
                Toast.makeText(requireActivity(), "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
            }
        }
        return
    }


}
