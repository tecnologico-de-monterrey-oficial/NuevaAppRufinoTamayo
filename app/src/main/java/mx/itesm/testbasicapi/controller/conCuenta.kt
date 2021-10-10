package mx.itesm.testbasicapi.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteB


class conCuenta : Fragment() {
    lateinit var reportarIncidente: Button
    lateinit var misReportes: Button
    lateinit var Reglamento: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_con_cuenta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //boton reportar incidente
        reportarIncidente = view.findViewById(R.id.reportarIncidenteConCuentaBTN)
        reportarIncidente.setOnClickListener {
            val fragment = ReporteB()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton mis reportes
        misReportes = view.findViewById(R.id.misReportesConCuentaBTN)
        misReportes.setOnClickListener {
            val fragment = ReportesVisitante()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton reglamento
        Reglamento = view.findViewById(R.id.reglamentoConCuentaBTN)
        Reglamento.setOnClickListener {
            val fragment = Reglamento()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

    }




}