package DIEGO.diegoprueba.IMC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.diegoinicial.diegoprueba.R

class IMCResultActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcresult)
        val result: Double = intent.extras?.getDouble("IMC_Result") ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners(){
        btnRecalculate.setOnClickListener{ onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.49 -> {
                tvResult.text = getString(R.string.tittle_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }
            in 18.5..24.99 -> {
                tvResult.text = getString(R.string.tittle_peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvDescription.text = getString(R.string.description_peso_normal)
            }
            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.tittle_sobre_peso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.sobrepeso))
                tvDescription.text = getString(R.string.description_sobre_peso)
            }
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.tittle_obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesidad)
            }
            else -> {
                tvDescription.text = getString(R.string.error)
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
            }


        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvImc)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

}