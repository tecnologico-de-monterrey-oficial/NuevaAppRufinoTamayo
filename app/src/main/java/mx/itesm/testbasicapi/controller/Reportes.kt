package mx.itesm.testbasicapi.controller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.Utils
import mx.itesm.testbasicapi.model.Reporte
import mx.itesm.testbasicapi.model.Usuario
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerResumenesReportes
import mx.itesm.testbasicapi.model.repository.responseinterface.OutputObtenerUsuario
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaObtenerResumenesReportes
import mx.itesm.testbasicapi.model.repository.responseinterface.RespuestaObtenerUsuario

class Reportes : Fragment() {
    lateinit var textoReportes: TextView
    lateinit var textoPruebasReportes: TextView
    lateinit var botonSalirReportes: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reportes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Texto para mostrar el titulo de la pantalla de reportes
        textoReportes = view.findViewById(R.id.textoReportes)

        // Texto para hacer pruebas con reportes
        textoPruebasReportes = view.findViewById(R.id.textoPruebasReportes)

        // Boton para salir de la pantalla de reportes
        botonSalirReportes = view.findViewById(R.id.botonSalirReportes)
        botonSalirReportes.setOnClickListener {
            val fragment = Menu()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        // Revisar si mostrar interfaz de visitante o administrador
        if(Utils.isUserLoggedIn(view.context)) {
            Usuario(Utils.getToken(view.context)).obtenerUsuario(Utils.getToken(view.context), object: RespuestaObtenerUsuario {
                override fun enExito(outputObtenerUsuario: OutputObtenerUsuario?) {
                    if(outputObtenerUsuario != null) {
                        if(outputObtenerUsuario.is_admin) {
                            Reporte(Utils.getToken(view.context)).obtenerResumenesReportes(Utils.getToken(view.context), null, null, null, null, null, object: RespuestaObtenerResumenesReportes {
                                override fun enExito(outputObtenerResumenesReportes: List<OutputObtenerResumenesReportes>?) {
                                    //
                                }

                                override fun enErrorServidor(codigo: Int, mensaje: String) {
                                    //
                                }

                                override fun enOtroError(t: Throwable) {
                                    //
                                }
                            })
                        } else {
                            Reporte(Utils.getToken(view.context)).obtenerResumenesReportes(Utils.getToken(view.context), "123", null, null, null, null, object: RespuestaObtenerResumenesReportes {
                                override fun enExito(outputObtenerResumenesReportes: List<OutputObtenerResumenesReportes>?) {
                                    //
                                }

                                override fun enErrorServidor(codigo: Int, mensaje: String) {
                                    //
                                }

                                override fun enOtroError(t: Throwable) {
                                    //
                                }
                            })
                        }
                    }
                }

                override fun enErrorServidor(codigo: Int, mensaje: String) {
                    //
                }

                override fun enOtroError(t: Throwable) {
                    //
                }
            })
        }
    }
}