package DIEGO.diegoprueba

import DIEGO.diegoprueba.Calculadora.CalculatorActivity
import DIEGO.diegoprueba.IMC.IMCcalculatorActivity
import DIEGO.diegoprueba.Nombre.PrimeraAppActivity
import DIEGO.diegoprueba.TODO.TodoActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.diegoinicial.diegoprueba.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnNombreApp = findViewById<Button>(R.id.btnNombreApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnNombreApp.setOnClickListener { navigateToNombreApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        btnTODO.setOnClickListener { navigateToTodoApp() }
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        btnCalc.setOnClickListener { navigateToCalculatorActivity() }

    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, IMCcalculatorActivity::class.java)
        startActivity(intent)


    }

    private fun navigateToNombreApp() {
        val intent = Intent(this, PrimeraAppActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToCalculatorActivity() {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
}

