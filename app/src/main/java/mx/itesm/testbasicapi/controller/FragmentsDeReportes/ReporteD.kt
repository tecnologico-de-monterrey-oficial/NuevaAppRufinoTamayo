package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaCrearCuenta


class ReporteD : Fragment() {
    lateinit var GPSSwitch: Switch

    lateinit var tvLatitude: TextView
    lateinit var tvLongitude: TextView
    lateinit var descripcionReporte : TextView

    var auxiliar = ""

    var displayMessage: String? = ""

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    lateinit var botonSiguiente: Button





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reporte_b, container, false)
        // Inflate the layout for this fragment
        displayMessage = arguments?.getString("message")
        val aux = displayMessage.toString()
        val list: List<String> = listOf(*aux.split(",").toTypedArray())
        auxiliar= displayMessage.toString()
        //Toast.makeText(requireActivity(), displayMessage.toString(), Toast.LENGTH_SHORT).show()

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

            var asunto = "asunto prueba"
            var tipo = "tipo prueba"
            var urgente = true
            var descripcion = "descripcion prueba"
            var coords = "-0, 0"
            var foto = "foto prueba"

            var nombre = "asdf"
            var apellido = "asdf"
            var correo = "asdf"
            var contrasenia = "asdf"
            var repetirContrasenia = "asdf"
            var pudoCrearCuenta: Boolean = false

            Log.d("token", Utils.getToken(view.context))

            Usuario(Utils.getToken(view.context)).crearCuenta(nombre, apellido, correo, contrasenia, repetirContrasenia, object:
                RespuestaCrearCuenta {

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
            })







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
