package mx.itesm.testbasicapi.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mx.itesm.testbasicapi.R




class Administrador : Fragment() {

    lateinit var verReportesAdministradorBTN: Button
    lateinit var administracionBTN: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_administrador, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //boton avanzar a reportes
        verReportesAdministradorBTN = view.findViewById(R.id.reportesAdminBTN)
        verReportesAdministradorBTN.setOnClickListener {
            val fragment = ReportesAdministrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.actividadInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton avanzar a Administracion
        administracionBTN = view.findViewById(R.id.administracionAdminBTN)
        administracionBTN.setOnClickListener {
            val fragment = ReportesAdministrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.actividadInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }


}