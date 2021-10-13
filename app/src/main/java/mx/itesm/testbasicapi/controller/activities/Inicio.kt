package mx.itesm.testbasicapi.controller.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.Communicator2
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.Communicator
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteB
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteC
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteD
import mx.itesm.testbasicapi.controller.LecturaReporte

class Inicio : AppCompatActivity(), Communicator, Communicator2 {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val fragmentA = ReporteC()

        supportFragmentManager.beginTransaction().replace(R.id.fragContViewInicio, fragmentA)
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val reporteC = ReporteB()

        reporteC.arguments = bundle

        transaction.replace(R.id.fragContViewInicio, reporteC)
        transaction.commit()

    }
    override fun passDataCom2(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("id", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val reporte = LecturaReporte()

        reporte.arguments = bundle

        transaction.replace(R.id.fragContViewInicio, reporte)
        transaction.commit()

    }

}