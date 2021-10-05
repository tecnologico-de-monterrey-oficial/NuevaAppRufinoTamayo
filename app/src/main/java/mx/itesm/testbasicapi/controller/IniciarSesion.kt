package mx.itesm.testbasicapi.controller

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.ejemplo.LoginActivity
import mx.itesm.testbasicapi.controller.ejemplo.MainActivity


class IniciarSesion : Fragment() {
    lateinit var botonContinuarSinIniciarSesion: Button
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
        botonContinuarSinIniciarSesion = view.findViewById(R.id.botonContinuarSinIniciarSesion)
        botonContinuarSinIniciarSesion.setOnClickListener {
            val intentInicio = Intent(view.context, Inicio::class.java)
            intentInicio.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentInicio)
        }
    }
}