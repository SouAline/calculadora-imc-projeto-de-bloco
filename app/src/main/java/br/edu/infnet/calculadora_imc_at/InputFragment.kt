package br.edu.infnet.calculadora_imc_at

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController


class InputFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        val btCheck = view.findViewById<Button>(R.id.btCheck)

        btCheck.setOnClickListener {

            val navController = this.findNavController()


            navController.navigate(R.id.action_inputFragment_to_resultFragment3)
        }

        return view
    }



}