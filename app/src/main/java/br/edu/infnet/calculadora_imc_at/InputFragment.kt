package br.edu.infnet.calculadora_imc_at

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

import kotlin.math.roundToInt


class InputFragment : Fragment() {
    private lateinit var comunicator: Comunicator

    private lateinit var peso: EditText
    private lateinit var altura: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        comunicator = activity as Comunicator

        altura = view.findViewById(R.id.etHeight)
        peso = view.findViewById(R.id.etWeight)

        val btCheck = view.findViewById<Button>(R.id.btCheck)

        btCheck.setOnClickListener {
            var pesoConvertido = peso.text.toString().toDouble()
            var alturaConvertida = altura.text.toString().toDouble()

            var imc = calcularIMC(pesoConvertido, alturaConvertida)
            var text = validarGrau(imc)
            var pesoIdeal = obterPesoIdeal(pesoConvertido, alturaConvertida)

            comunicator.passDataCom(imc.toString(),text, pesoIdeal.toString())
        }
        return view

    }

    fun calcularIMC(pesoConvertido: Double, alturaConvertida:Double): Double{
        var alturaMetros = alturaConvertida/100.0

        var imcSemArredondar =  (pesoConvertido/(alturaMetros * alturaMetros))
        val imc = (imcSemArredondar * 100).roundToInt().toDouble() / 100

       return imc

    }

    fun validarGrau(imc: Double) : String{
        var text = ""

        if(imc in 0.0 .. 16.0){
            text = "Magreza grave"
        }else if(imc in 16.1 .. 16.9){
            text = "Magreza moderada"
        } else if(imc in 17.0 .. 18.5){
            text = "Magreza leve"
        }else if(imc in 18.6 .. 25.0){
            text = "Saudável"
        } else if(imc in 25.1 .. 30.0){
            text = "Sobrepeso"
        } else if(imc in 30.1 .. 35.0){
            text = "Obesidade Grau I"
        } else if(imc in 35.1 .. 40.0){
            text = "Obesidade Grau II - Severo"
        } else if(imc > 40.0){
            text = "Obesidade Grau III - Mórbida"
        }else{
            text = "Tente novamente"
        }
        return text
    }

    fun obterPesoIdeal(peso: Double, altura:Double):Double{
        var resultado: Double

        if ((calcularIMC(peso, altura) > 25.00) || (calcularIMC(peso, altura) < 18.6)){
            var calculo = (25 * Math.pow(altura, 2.0))/ Math.pow(10.0, 4.0)
            resultado = calculo}
        else{
            resultado = peso
        }
        return "%.0f".format(resultado).toDouble()
    }


}