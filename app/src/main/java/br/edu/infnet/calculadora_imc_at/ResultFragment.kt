package br.edu.infnet.calculadora_imc_at

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ResultFragment : Fragment() {

    private lateinit var imcResult: TextView
    private lateinit var textResult: TextView
    private lateinit var idealResult: TextView
    var displayMessageImc: String? = ""
    var displayMessage: String? = ""
    var displayPesoIdeal: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        displayMessageImc = arguments?.getString("imc")
        displayMessage = arguments?.getString("text")
        displayPesoIdeal = arguments?.getString("pesoIdeal")

        imcResult = view.findViewById<TextView>(R.id.tvResultImc)
        textResult = view.findViewById<TextView>(R.id.tvResultAlert)
        idealResult = view.findViewById<TextView>(R.id.tvIdealWeight)


        imcResult.setText(displayMessageImc)
        textResult.setText(displayMessage)
        idealResult.setText(displayPesoIdeal)

        return view
    }

}