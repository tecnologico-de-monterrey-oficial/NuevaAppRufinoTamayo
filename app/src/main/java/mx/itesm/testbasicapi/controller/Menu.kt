package mx.itesm.testbasicapi.controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.controller.FragmentsDeAdmin.Administracion
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteC
import mx.itesm.testbasicapi.controller.activities.Autenticacion
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerUsuario
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaObtenerUsuario

class Menu : Fragment() {
    lateinit var textoBienvenida: TextView
    lateinit var botonIniciarSesion: Button
    lateinit var botonReportarIncidente: Button
    lateinit var botonMisReportes: Button
    lateinit var botonReportesIncidentes: Button
    lateinit var botonReglamentoParque: Button
    lateinit var botonAdministracion: Button
    lateinit var botonConfiguracion: Button
    lateinit var botonCerrarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textoBienvenida = view.findViewById(R.id.textoBienvenida)
        botonIniciarSesion = view.findViewById(R.id.botonIniciarSesionMenu)
        botonReportarIncidente = view.findViewById(R.id.botonPantallaReportar)
        botonMisReportes = view.findViewById(R.id.botonPantallaMisReportes)
        botonReportesIncidentes = view.findViewById(R.id.botonReportesIncidentes)
        botonReglamentoParque = view.findViewById(R.id.botonPantallaReglamento)
        botonAdministracion = view.findViewById(R.id.botonAdministracion)
        botonConfiguracion = view.findViewById(R.id.botonConfiguracion)
        botonCerrarSesion = view.findViewById(R.id.botonCerrarSesion)

        botonReportesIncidentes.setVisibility(View.GONE)
        botonAdministracion.setVisibility(View.GONE)
        botonCerrarSesion.setVisibility(View.GONE)

        Log.d("ObtenerUsuario", "0")
        if(Utils.isUserLoggedIn(view.context)) {
            Log.d("ObtenerUsuario", "1")
            botonIniciarSesion.setVisibility(View.GONE)
            botonCerrarSesion.setVisibility(View.VISIBLE)
            Usuario(Utils.getToken(view.context)).obtenerUsuario(Utils.getToken(view.context), object: RespuestaObtenerUsuario {
                override fun enExito(outputObtenerUsuario: OutputObtenerUsuario?) {
                    Log.d("ObtenerUsuario", "2")
                    if(outputObtenerUsuario != null) {
                        Log.d("ObtenerUsuario", "3")
                        textoBienvenida.text = "Bienvenido " + outputObtenerUsuario.name + " " + outputObtenerUsuario.last_name + "!"

                        if(outputObtenerUsuario.type == "Administrador") {
                            Log.d("ObtenerUsuario", "4")
                            botonReportarIncidente.setVisibility(View.GONE)
                            botonMisReportes.setVisibility(View.GONE)
                            botonReportesIncidentes.setVisibility(View.VISIBLE)
                            botonReglamentoParque.setVisibility(View.GONE)
                            botonAdministracion.setVisibility(View.VISIBLE)
                        }
                    }
                }

                override fun enErrorServidor(codigo: Int, mensaje: String) {
                    Toast.makeText(view.context, "No se pudo obtener tu usuario", Toast.LENGTH_LONG)
                    Log.d("ObtenerUsuario", "No se pudo obtener tu usuario")
                }

                override fun enOtroError(t: Throwable) {
                    Toast.makeText(view.context, "Algo sali?? mal, vuelte a intentarlo mas tarde", Toast.LENGTH_LONG)
                    Log.d("ObtenerUsuario", "Algo sali?? mal, vuelte a intentarlo mas tarde")
                }
            })
        }

        // Boton para Iniciar Sesion
        botonIniciarSesion.setOnClickListener{
            val intentAutenticacion = Intent(view.context, Autenticacion::class.java)
            intentAutenticacion.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentAutenticacion)
        }

        // Boton para Reportar Incidentes
        botonReportarIncidente.setOnClickListener {
            val fragment = ReporteC()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        // Boton para ver Mis Reportes
        botonMisReportes.setOnClickListener {
            val fragment = Reportes()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        // Boton para ver los Reportes de Incidentes
        botonReportesIncidentes.setOnClickListener {
            val fragment = Reportes()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        // Boton para ver el Reglamento
        botonReglamentoParque.setOnClickListener {
            val fragment = ReglamentoA()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        // Bot??n para ir a la secci??n de Administraci??n
        botonAdministracion.setOnClickListener {
            val fragment = Administracion()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        // Bot??n para ir a la secci??n de Configuraci??n
        botonConfiguracion.setOnClickListener {
            val fragment = Configuracion()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        // Boton para Cerrar Sesion
        botonCerrarSesion.setOnClickListener{
            Utils.deleteToken(view.context)
            val intentAutenticacion = Intent(view.context, Autenticacion::class.java)
            intentAutenticacion.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentAutenticacion)
        }
    }
}