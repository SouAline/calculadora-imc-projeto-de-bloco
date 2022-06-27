package br.edu.infnet.calculadora_imc_at

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(), Comunicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val inputFragment = InputFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView5, inputFragment).commit()

    }


    override fun passDataCom(imc: String, text: String) {
        val bundle = Bundle()
        bundle.putString("imc", imc)
        bundle.putString("text",text)

        val transaction = this.supportFragmentManager.beginTransaction()
        val resultFragment = ResultFragment()
        resultFragment.arguments = bundle

        transaction.replace(R.id.fragmentContainerView5,resultFragment)
        transaction.commit()
    }
}