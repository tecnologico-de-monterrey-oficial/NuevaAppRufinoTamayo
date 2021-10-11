package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_inicio.*
import mx.itesm.testbasicapi.R


class ReporteA : Fragment() {
    lateinit var botonSiguiente: Button



    private lateinit var communicator: Communicator
    private val list = ArrayList<String>(7)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment 4a0as

        val view = inflater.inflate(R.layout.fragment_reporte_a, container, false)

        val asunto = view.findViewById<TextView>(R.id.asuntoInputTXT)
        val urgente = view.findViewById<Switch>(R.id.esUrgenteInputSWITCH)
        val descripcion = view.findViewById<EditText>(R.id.descripcionReporteInputTXT)

        val spinner = view.findViewById<Spinner>(R.id.spinnerIncidentes)

        val lista = resources.getStringArray(R.array.Problematicas)



        val adaptador = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, lista.toList())

        spinner.adapter = adaptador



        //boton de siguiente
        botonSiguiente = view.findViewById(R.id.botonEnviarReporte)
        botonSiguiente.setOnClickListener {
            communicator = activity as Communicator



            val dato1 = asunto.text.toString()
            val dato2 = urgente.text.toString()
            val dato3 = descripcion.text.toString()

            list.add(dato1)
            list.add(dato2)
            list.add(dato3)

            val lista  = list.joinToString(separator = ",")

            communicator.passDataCom("lista")

            //Toast.makeText(requireActivity(), lista, Toast.LENGTH_LONG).show()

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
                Toast.makeText(requireActivity(), "Especificalo en el recuadro de la descripcion", Toast.LENGTH_LONG).show()

            }


        }

        return view

    }

    // 81 89 88 2000
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }*/
}