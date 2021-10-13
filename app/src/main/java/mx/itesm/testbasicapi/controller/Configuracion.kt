package mx.itesm.testbasicapi.controller

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaCambiarContrasenia

class Configuracion : Fragment() {
    lateinit var escribirNombre: EditText
    lateinit var escribirApellido: EditText
    lateinit var escribirCorreo: EditText
    lateinit var botonActualizarDatos: Button
    lateinit var escribirContraseniaActual: EditText
    lateinit var escribirNuevaContrasenia: EditText
    lateinit var escribirRepetirNuevaContrasenia: EditText
    lateinit var botonCambiarContrasenia: Button
    lateinit var botonRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuracion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        escribirNombre = view.findViewById(R.id.escribirNuevoNombreConfig)
        escribirApellido = view.findViewById(R.id.escribirNuevoApellidoConfig)
        escribirCorreo = view.findViewById(R.id.escribirNuevoCorreoConfig)
        escribirContraseniaActual = view.findViewById(R.id.escribirContraseniaActual)
        escribirNuevaContrasenia = view.findViewById(R.id.escribirNuevaContraseniaConfig)
        escribirRepetirNuevaContrasenia = view.findViewById(R.id.escribirNuevoRepetirContraseniaConfig)
        escribirNombre = view.findViewById(R.id.escribirNuevoNombreConfig)
        botonActualizarDatos = view.findViewById(R.id.botonActualizarDatos)
        botonCambiarContrasenia = view.findViewById(R.id.botonCambiarContrasenia)
        botonRegresar = view.findViewById(R.id.botonSalirConfiguracion)

        botonCambiarContrasenia.setOnClickListener(cambiarContrasenia(view))

        // Boton para regresar al menu principal
        botonRegresar.setOnClickListener{
            val fragment = Menu()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }
    }

    fun cambiarContrasenia(view: View): View.OnClickListener {
        return View.OnClickListener {
            val contraseniaActual = escribirContraseniaActual.text.toString()
            val nuevaContrasenia = escribirNuevaContrasenia.text.toString()
            val repetirNuevaContrasenia = escribirRepetirNuevaContrasenia.text.toString()
            Usuario(Utils.getToken(view.context)).cambiarContrasenia(Utils.getToken(view.context), contraseniaActual, nuevaContrasenia, repetirNuevaContrasenia, object: RespuestaCambiarContrasenia {
                override fun enExito() {
                    Log.d("ContraseniaCambiada", "Exito")
                }

                override fun enErrorServidor(codigo: Int, mensaje: String) {
                    Log.d("ContraseniaCambiada", mensaje)
                }

                override fun enOtroError(t: Throwable) {
                    Log.d("ContraseniaCambiada", t.message.toString())
                }
            })
        }
    }
}