package mx.itesm.testbasicapi.controller.FragmentsDeReportes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_reporte_b.*
import mx.itesm.testbasicapi.R


class ReporteA : Fragment() {
    lateinit var botonSeguirSinCuentaa: Button
    lateinit var botonSeguirConCuenta: Button
    lateinit var botonSiguiente: Button

    private lateinit var communicator: Communicator
    private val list = ArrayList<String>(7)

    var spinnerVar ="No Selecciono"
    var dato2 = false


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
        val switch = view.findViewById<Switch>(R.id.esUrgenteInputSWITCH)

        val lista = resources.getStringArray(R.array.Problematicas)



        val adaptador = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, lista.toList())

        spinner.adapter = adaptador



        //boton de siguiente
        botonSiguiente = view.findViewById(R.id.botonEnviarReporte)
        botonSiguiente.setOnClickListener {
            communicator = activity as Communicator



            val asuntolist = asunto.text.toString()
            val descripcionlist = descripcion.text.toString()
            val spinnerlist = spinnerVar

            list.add(asuntolist)

            if(dato2){
                list.add("1")
            }else{
                list.add("0")
            }

            list.add(descripcionlist)
            list.add(spinnerlist)

            val lista  = list.joinToString(separator = ",")
/*
            val bundle = Bundle()
            bundle.putString("message", lista)

            val transaction = this.parentFragmentManager.beginTransaction()
            val reporteC = ReporteC()

            reporteC.arguments = bundle

            transaction.replace(R.id.fragContViewInicio, reporteC)
            transaction.addToBackStack(null)
            transaction.commit()*/

            communicator.passDataCom(lista)

            //Toast.makeText(requireActivity(), lista, Toast.LENGTH_LONG).show()

/*
            val fragmentListaReportes = ReporteC()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //boton de seguir sin cuenta
        botonSeguirSinCuentaa = view.findViewById(R.id.continuarConElReporteVisitanteBTN)
        botonSeguirSinCuentaa.setOnClickListener {
            val fragmentListaReportes = ReporteB()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragmentListaReportes)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()*/
        }

        //switch urgente
        switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                dato2 = true
            } else {
                dato2 = false
            }


        })



        spinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerVar = lista[p2]
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
}

