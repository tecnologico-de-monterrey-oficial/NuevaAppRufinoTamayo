package mx.itesm.testbasicapi.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mx.itesm.testbasicapi.R



class Reglamento : Fragment() {
    lateinit var botonRegresar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reglamento, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //boton de regresar
        botonRegresar = view.findViewById(R.id.botonRegresardeReglamento)
        botonRegresar.setOnClickListener {
            val fragmentListaReportes = Menu()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }

}