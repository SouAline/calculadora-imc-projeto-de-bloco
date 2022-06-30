package br.edu.infnet.calculadora_imc_at

import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

class InputFragmentTest {

    @Test
    fun calcularIMCDeveRetornarValorCerto() {
        // Arrange
        var pesoConvertido = 90.0
        var alturaConvertida = 180.0

        //Act
        var actualIMC = InputFragment().calcularIMC(pesoConvertido, alturaConvertida)
        var expetedIMC = 27.78
        //Assert
        assertTrue(actualIMC == expetedIMC)
    }

    @Test
    fun validarGrauDeveRetornarTextoMagrezagrave() {
        //Arrange
        var imc = 15.78

        //Act
        var actualText = InputFragment().validarGrau(imc)
        var expectedText = "Magreza grave"

        //Assert
        assertEquals(actualText, expectedText)
    }

    @Test
    fun obterPesoIdealDeveRetornarTextoMagrezagrave() {
        // Arrange
        var peso = 90.0
        var altura = 180.0

        //Act
        var actualPeso = InputFragment().obterPesoIdeal(peso, altura)
        var expectedPeso = 81.0

        //Assert
        assertTrue(actualPeso == expectedPeso)
    }

}