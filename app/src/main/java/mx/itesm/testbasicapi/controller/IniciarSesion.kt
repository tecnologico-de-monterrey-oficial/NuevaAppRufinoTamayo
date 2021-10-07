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
import mx.itesm.testbasicapi.controller.activities.Autenticacion
import mx.itesm.testbasicapi.controller.activities.Inicio
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.entities.EUsuario
import mx.itesm.testbasicapi.model.entities.JwtToken
import mx.itesm.testbasicapi.model.repository.RemoteRepository
import mx.itesm.testbasicapi.model.repository.responseinterface.IIniciarSesion


class IniciarSesion : Fragment() {
    lateinit var escribirCorreo: EditText
    lateinit var escribirContrasenia: EditText
    lateinit var textoOlvideContrasenia: TextView
    lateinit var textoCrearCuenta: TextView
    lateinit var textoMensajeError: TextView
    lateinit var botonContinuarSinIniciarSesion: Button
    lateinit var botonIniciarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Asignaciones de referencias
        escribirCorreo = view.findViewById(R.id.escribirCorreo)
        escribirContrasenia = view.findViewById(R.id.escribirContrasenia)
        textoOlvideContrasenia = view.findViewById(R.id.textoOlvideContrasenia)
        textoCrearCuenta = view.findViewById(R.id.textoNoTienesCuenta)
        textoMensajeError = view.findViewById(R.id.textoError)
        botonContinuarSinIniciarSesion = view.findViewById(R.id.botonContinuarSinIniciarSesion)
        botonIniciarSesion = view.findViewById(R.id.botonIniciarSesion)

        // Asignaciones de Click Listeners
        botonContinuarSinIniciarSesion.setOnClickListener(irAlInicio(view))
        botonIniciarSesion.setOnClickListener(iniciarSesion(view))
    }

    private fun iniciarSesion(view: View): View.OnClickListener? {
        return View.OnClickListener {
            val correo = escribirCorreo.text.toString()
            val contrasenia = escribirContrasenia.text.toString()
            if(correo != "" && contrasenia != "") {
                Usuario(Utils.getToken(view.context)).iniciarSesion(correo, contrasenia, object: IIniciarSesion {
                    override fun enExito(token: JwtToken?) {
                        if(token != null) {
                            textoMensajeError.text = token.token

                            Utils.saveToken(token, view.context)
                            RemoteRepository.updateRemoteReferences(token.token, view.context);
                            val intentInicio = Intent(view.context, Inicio::class.java)
                            intentInicio.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intentInicio)
                        } else {
                            textoMensajeError.text = "Algo salió mal"
                        }
                    }

                    override fun enErrorServidor(codigo: Int, mensaje: String) {
                        textoMensajeError.text = mensaje
                    }

                    override fun enOtroError(t: Throwable) {
                        textoMensajeError.text = "Algo salió mal"
                        Log.e("API", t.message, t)
                    }
                })
                textoMensajeError.text = ""
            } else {
                textoMensajeError.text = "ERROR: No se introdujo el correo o la contraseña"
            }
        }
    }

    private fun irAlInicio(view: View): View.OnClickListener {
        return View.OnClickListener {
            val intentInicio = Intent(view.context, Inicio::class.java)
            intentInicio.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentInicio)
        }
    }
}