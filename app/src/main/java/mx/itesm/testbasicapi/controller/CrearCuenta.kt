package mx.itesm.testbasicapi.controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.controller.activities.Inicio
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.entities.JwtToken
import mx.itesm.testbasicapi.model.repository.RemoteRepository
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputIniciarSesion
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaCrearCuenta
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaIniciarSesion

class CrearCuenta : Fragment() {
    lateinit var escribirNombre: EditText
    lateinit var escribirApellido: EditText
    lateinit var escribirCorreo: EditText
    lateinit var escribirContrasenia: EditText
    lateinit var escribirRepetirContrasenia: EditText
    lateinit var textoMensajeError: TextView
    lateinit var botonCrearCuenta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crear_cuenta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener las referencias
        escribirNombre = view.findViewById(R.id.escribirNuevoNombre)
        escribirApellido = view.findViewById(R.id.escribirNuevoApellido)
        escribirCorreo = view.findViewById(R.id.escribirNuevoCorreo)
        escribirContrasenia = view.findViewById(R.id.escribirNuevaContrasenia)
        escribirRepetirContrasenia = view.findViewById(R.id.escribirNuevoRepetirContrasenia)
        textoMensajeError = view.findViewById(R.id.textoNuevoError)
        botonCrearCuenta = view.findViewById(R.id.botonNuevoCrearCuenta)

        textoMensajeError.setVisibility(View.GONE)

        // Asignar los métodos a las referencias
        botonCrearCuenta.setOnClickListener(crearCuenta(view))
    }

    private fun crearCuenta(view: View): View.OnClickListener {
        return View.OnClickListener {
            // Obtener los valores de los campos
            var nombre = escribirNombre.text.toString()
            var apellido = escribirApellido.text.toString()
            var correo = escribirCorreo.text.toString()
            var contrasenia = escribirContrasenia.text.toString()
            var repetirContrasenia = escribirRepetirContrasenia.text.toString()
            var pudoCrearCuenta: Boolean = false

            // Validar los campos
            if(
                nombre != "" && apellido != "" && correo != "" && contrasenia != "" && repetirContrasenia != "" && // Que ninguno esté vacío
                contrasenia == repetirContrasenia // Que los valores de los campos de contraseña y el de repetir contraseña coincidan
            ) {
                // Intentar crear la cuenta
                Usuario(Utils.getToken(view.context)).crearCuenta(nombre, apellido, correo, contrasenia, repetirContrasenia, object:
                    RespuestaCrearCuenta {
                    override fun enExito() {
                        Log.d("CrearCuenta", "Exito")
                        //pudoCrearCuenta = true

                        // Si pudo crear la cuenta, intenta inciar sesion
                        Log.d("IniciarSesion", "Afuera")
                        Usuario(Utils.getToken(view.context)).iniciarSesion(correo, contrasenia, object: RespuestaIniciarSesion {
                            override fun enExito(outputIniciarSesion: OutputIniciarSesion?) {
                                Log.d("IniciarSesion", "EnExito")
                                if(outputIniciarSesion != null) {
                                    Log.d("IniciarSesion", "Token")
                                    textoMensajeError.setVisibility(View.VISIBLE)
                                    textoMensajeError.text = outputIniciarSesion.token

                                    Utils.saveToken(JwtToken(outputIniciarSesion.token), view.context)
                                    RemoteRepository.updateRemoteReferences(outputIniciarSesion.token, view.context);

                                    // Ir a la actividad de Inicio
                                    val intentInicio = Intent(view.context, Inicio::class.java)
                                    intentInicio.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    startActivity(intentInicio)
                                } else {
                                    Log.d("IniciarSesion", "Mal")
                                    textoMensajeError.setVisibility(View.VISIBLE)
                                    textoMensajeError.text = "Algo salió mal"
                                }
                            }

                            override fun enErrorServidor(codigo: Int, mensaje: String) {
                                textoMensajeError.setVisibility(View.VISIBLE)
                                textoMensajeError.text = mensaje
                            }

                            override fun enOtroError(t: Throwable) {
                                textoMensajeError.setVisibility(View.VISIBLE)
                                textoMensajeError.text = "Algo salió mal"
                                Log.e("API", t.message, t)
                            }
                        })
                        textoMensajeError.text = ""
                    }

                    override fun enErrorServidor(codigo: Int, mensaje: String) {
                        Log.d("CrearCuenta", "ErrorServidor")
                        textoMensajeError.setVisibility(View.VISIBLE)
                        textoMensajeError.text = mensaje
                    }

                    override fun enOtroError(t: Throwable) {
                        Log.d("CrearCuenta", "OtroError")
                        textoMensajeError.setVisibility(View.VISIBLE)
                        textoMensajeError.text = "Algo salió mal"
                        Log.e("API", t.message, t)
                    }
                })
            } else {
                textoMensajeError.setVisibility(View.VISIBLE)
                textoMensajeError.text = "Alguno de los campos están vacíos o las contraseñas no coninciden"
            }
        }
    }
}