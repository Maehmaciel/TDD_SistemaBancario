package com.sistemabancario.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

	@Test
	public void testSetNumeroValido() {
		final Conta instance = new Conta();
		final String esperado = "12345-6";
		instance.setNumero(esperado);
		final String obtido = instance.getNumero();
		assertEquals(esperado, obtido);
	}

	@Test
	public void testSetNumeroInvalidoNaoArmazena() {
		final Conta instance = new Conta();
		final String esperado = "123";
		assertThrows(IllegalArgumentException.class,()->instance.setNumero(esperado));
		final String obtido = instance.getNumero();
		assertNotEquals(esperado, obtido);
	}

	//TODO : NULL
	@Test
	public void testSetNumeroNull() {
		final Conta instance = new Conta();
		assertThrows(NullPointerException.class,()->instance.setNumero(null));
	}

	@Test
	public void testInstanciaPadraoPolpanca() {
		final Conta instance = new Conta();
		assertFalse(instance.isPoupanca());
	}

	@Test
	public void testSetLimiteContaEspecial() {
		final Conta instance = new Conta();
		instance.setEspecial(true);
		final double esperado = 300; 
		instance.setLimite(esperado);
		final double obtido = instance.getLimite();
		assertEquals(esperado, obtido);

	}

	@Test
	public void testSetLimiteContaNaoEspecial() {
		final Conta instance = new Conta();
		final double limite = 1000; 
		assertThrows(IllegalStateException.class, ()->instance.setLimite(limite));

	}

	@Test
	public void testSetLimiteContaNaoEspecialNaoArmazena() {
		final Conta instance = new Conta();
		final double limite = 1000; 
		assertThrows(IllegalStateException.class, ()->instance.setLimite(limite));
		final String obtido = instance.getNumero();
		assertNotEquals(limite, obtido);

	}


	@Test
	public void testHistoricoNotNull() {
		final Conta instance = new Conta();
		assertNotNull(instance.getMovimentacoes());

	}

}
