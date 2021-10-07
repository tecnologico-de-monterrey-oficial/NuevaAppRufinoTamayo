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
        botonReportarIncidente.setOnClickListener {
            val fragmentoReporteA = ReporteA()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentoReporteA)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }
}