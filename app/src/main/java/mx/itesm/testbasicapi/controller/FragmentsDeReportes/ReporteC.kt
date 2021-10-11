package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationRequest
import android.os.Bundle
import android.os.Looper
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






class ReporteC : Fragment() {
    lateinit var GPSSwitch: Switch

    lateinit var tvLatitude: TextView
    lateinit var tvLongitude: TextView
    lateinit var tvAddress : TextView

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    lateinit var botonSiguiente: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reporte_c, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvLatitude = view.findViewById(R.id.tv_lat)
        tvLongitude = view.findViewById(R.id.tv_lon)
        tvAddress = view.findViewById(R.id.esUrgenteTXT)

        //switch gps
        GPSSwitch = view.findViewById(R.id.GPSSwitch)
        GPSSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireActivity())

                checkLocationPermission()
                // The toggle is enabled
            } else {
                // The toggle is disabled
            }
        })

        //boton siguiente
        botonSiguiente = view.findViewById(R.id.botonSiguiente)
        botonSiguiente.setOnClickListener {
            val fragmentListaReportes = ReporteD()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }




    }

    private fun checkLocationPermission() {
        val task = fusedLocationProviderClient.lastLocation
        if(ActivityCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
        }

        task.addOnSuccessListener {
            Toast.makeText(requireActivity(), "asdfasdf", Toast.LENGTH_SHORT).show()
            if(it != null){
                tvLatitude.setText(it.getLatitude().toString())
                tvLongitude.setText(it.getLongitude().toString())
                Toast.makeText(requireActivity(), "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
            }
        }
        return
    }
}
