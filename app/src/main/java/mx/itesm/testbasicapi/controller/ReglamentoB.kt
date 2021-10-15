package mx.itesm.testbasicapi.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mx.itesm.testbasicapi.R

class ReglamentoB : Fragment() {
    lateinit var botonRegresar: Button
    lateinit var botonSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reglamento_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        botonRegresar = view.findViewById(R.id.botonRegresarReglamentoB)
        botonRegresar.setOnClickListener{
            val fragmento = ReglamentoA()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmento)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        botonSalir = view.findViewById(R.id.botonSalirReglamentoB)
        botonSalir.setOnClickListener{
            val fragmento = Menu()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmento)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }
}