package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import mx.itesm.testbasicapi.R


class ReporteA : Fragment() {
    lateinit var botonSiguiente: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reporte_a, container, false)
    }

    // 81 89 88 2000

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner = view.findViewById<Spinner>(R.id.spinnerIncidentes)

        val lista = resources.getStringArray(R.array.Problematicas)



        val adaptador = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, lista.toList())

        spinner.adapter = adaptador



        //boton de regresar
        botonSiguiente = view.findViewById(R.id.botonEnviarReporte)
        botonSiguiente.setOnClickListener {
            val fragmentListaReportes = ReporteB()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(lista[p2] == "Otro"){
                    Toast.makeText(requireActivity(), "Especificalo en el recuadro de la descripcion", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(requireActivity(), lista[p2], Toast.LENGTH_LONG).show()
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {


            }
        }
    }
}