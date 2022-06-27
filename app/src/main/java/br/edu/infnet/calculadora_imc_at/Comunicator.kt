package br.edu.infnet.calculadora_imc_at

interface Comunicator {
    fun passDataCom(imc: String, text: String)
}