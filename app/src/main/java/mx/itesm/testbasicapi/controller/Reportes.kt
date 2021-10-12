package mx.itesm.testbasicapi.controller

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        //textoPruebasReportes = view.findViewById(R.id.textoPruebasReportes)

        // Boton para salir de la pantalla de reportes
        botonSalirReportes = view.findViewById(R.id.botonSalirReportes)
        botonSalirReportes.setOnClickListener {
            val fragment = Menu()
            val transaccionFragmento = parentFragmentManager.beginTransaction()
            transaccionFragmento.replace(R.id.fragContViewInicio, fragment)
            transaccionFragmento.addToBackStack(null)
            transaccionFragmento.commit()
        }

        Log.d("HOLAAA", "ANTES TOKEN")

        // Revisar si mostrar interfaz de visitante o administrador
        if(Utils.isUserLoggedIn(view.context)) {
            Log.d("HOLAAA", "DESPUES TOKEN")
            Usuario(Utils.getToken(view.context)).obtenerUsuario(Utils.getToken(view.context), object: RespuestaObtenerUsuario {
                override fun enExito(outputObtenerUsuario: OutputObtenerUsuario?) {
                    Log.d("HOLAAA", "DESPUES TOKEN 2")
                    if(outputObtenerUsuario != null) {
                        Log.d("HOLAAA", "DESPUES TOKEN 3")
                        if(outputObtenerUsuario.type == "Administrador") {
                            Log.d("HOLAAA", "DESPUES TOKEN 4")
                            Reporte(Utils.getToken(view.context)).obtenerResumenesReportes(Utils.getToken(view.context), null, null, null, null, null, object: RespuestaObtenerResumenesReportes {
                                override fun enExito(outputObtenerResumenesReportes: List<OutputObtenerResumenesReportes>?) {
                                    textoReportes.text = outputObtenerResumenesReportes.toString()
                                    Log.d("TraerReportes", "exito admin")
                                }

                                override fun enErrorServidor(codigo: Int, mensaje: String) {
                                    Log.d("TraerReportes", "servidor admin")
                                }

                                override fun enOtroError(t: Throwable) {
                                    Log.d("TraerReportes", "otro admin")
                                }
                            })
                        } else {
                            Log.d("HOLAAA", "DESPUES TOKEN 4 ELSE")
                            Reporte(Utils.getToken(view.context)).obtenerResumenesReportes(Utils.getToken(view.context), null, null, null, null, null, object: RespuestaObtenerResumenesReportes {
                                override fun enExito(outputObtenerResumenesReportes: List<OutputObtenerResumenesReportes>?) {
                                    Log.d("TraerReportes", "exito")
                                    if(outputObtenerResumenesReportes != null) {
                                        val recyclerViewResumenesReportes = view.findViewById<RecyclerView>(R.id.recyclerViewResumenes)
                                        val adaptador = AdaptadorResumenesReportes(outputObtenerResumenesReportes, object: AdaptadorResumenesReportes.OnItemClickListener {
                                            override fun onItemClick(item: OutputObtenerResumenesReportes) {
                                                val fragmentoLecturaReporte = LecturaReporte()
                                                val bundle = Bundle()
                                                bundle.putString("idReporte", "123")
                                                fragmentoLecturaReporte.arguments = bundle

                                                val fragmentTransaction = parentFragmentManager.beginTransaction()
                                                fragmentTransaction.replace(
                                                    R.id.fragContViewInicio,
                                                    fragmentoLecturaReporte
                                                )
                                                fragmentTransaction.addToBackStack(null)
                                                fragmentTransaction.commit()
                                            }
                                        }, Utils.getToken(view.context), view.context)
                                        recyclerViewResumenesReportes.adapter = adaptador
                                        recyclerViewResumenesReportes.layoutManager = LinearLayoutManager(view.context)
                                    }
                                }

                                override fun enErrorServidor(codigo: Int, mensaje: String) {
                                    Log.d("TraerReportes", "servidor")
                                    textoPruebasReportes.text = mensaje
                                }

                                override fun enOtroError(t: Throwable) {
                                    Log.d("TraerReportes", "otro")
                                }
                            })
                        }
                    }
                }

                override fun enErrorServidor(codigo: Int, mensaje: String) {
                    Log.d("ERRORZAZO", mensaje)
                }

                override fun enOtroError(t: Throwable) {
                    Log.d("ERRORZAZO", "???")
                }
            })
        }
    }
}