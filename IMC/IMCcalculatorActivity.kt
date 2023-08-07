package DIEGO.diegoprueba.IMC

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.diegoinicial.diegoprueba.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCcalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean=true
    private var isFemaleSelected:Boolean=false
    private var currentWeight:Int = 50
    private var currentHeight:Int = 130
    private var currentAge:Int = 27

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imccalculator)
        initComponents()
        initListeners()
        initUI()

    }

    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }
    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -=1
            setWeight()
        }
        btnPlusWeight.setOnClickListener {
            currentWeight +=1
            setWeight()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -=1
            setAge()
        }
        btnPlusAge.setOnClickListener {
            currentAge +=1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }


    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, IMCResultActivity::class.java)
        intent.putExtra("IMC_Result", result)
        startActivity(intent)

    }

    private fun calculateIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble() /100* currentHeight.toDouble()/100)
        return df.format(imc).toDouble()

    }

    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }
    private fun setAge(){
        tvAge.text = currentAge.toString()
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor(){

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))

    }
    private fun getBackgroundColor(isSelectedComponent:Boolean) :Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else{R.color.background_component}

        return ContextCompat.getColor(this,colorReference)

    }

    private fun initUI(){
        setGenderColor()
        setWeight()
        setAge()

    }

}