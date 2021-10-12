package mx.itesm.testbasicapi.controller.FragmentsDeAdmin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import mx.itesm.testbasicapi.R

class RespuestaAdministrador : Fragment() {
    lateinit var botonResponder: Button
    lateinit var botonRegresar: Button
    lateinit var estado: Switch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_respuesta_administrador, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var estadoDelSwitch = 0

        estado = view.findViewById(R.id.switch1)
        estado.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                estadoDelSwitch = 1
            } else {
                estadoDelSwitch = 0
            }


        })



        //boton de responder
        botonResponder = view.findViewById(R.id.EnviarRespuestaAdministrador)
        botonResponder.setOnClickListener {

            //RespuestaDeAdministrador.text TODO aqui mandar a la DB
            //estadoDelSwitch



            val fragmentListaReportes = ReporteIndividualAdministrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        //boton de regresar
        botonRegresar = view.findViewById(R.id.regresarBTN)
        botonRegresar.setOnClickListener {
            val fragmentListaReportes = ReporteIndividualAdministrador()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }


}