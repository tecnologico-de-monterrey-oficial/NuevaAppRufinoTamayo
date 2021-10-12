package mx.itesm.testbasicapi.controller.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.Utils

class Autenticacion : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        if (Utils.isUserLoggedIn(this)) avanzarALaActividadDeInicio()
    }

    fun avanzarALaActividadDeInicio() {
        val intentInicio = Intent(applicationContext, Inicio::class.java)
        intentInicio.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intentInicio)
    }


}