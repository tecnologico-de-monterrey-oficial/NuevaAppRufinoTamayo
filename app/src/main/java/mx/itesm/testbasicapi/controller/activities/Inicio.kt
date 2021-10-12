package mx.itesm.testbasicapi.controller.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View

import mx.itesm.testbasicapi.R
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.Communicator
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteA
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteB
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteC
import mx.itesm.testbasicapi.controller.FragmentsDeReportes.ReporteD

class Inicio : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val fragmentA = ReporteA()

        supportFragmentManager.beginTransaction().replace(R.id.fragContViewInicio, fragmentA)
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val reporteC = ReporteC()

        reporteC.arguments = bundle

        transaction.replace(R.id.fragContViewInicio, reporteC)
        transaction.commit()

    }

}