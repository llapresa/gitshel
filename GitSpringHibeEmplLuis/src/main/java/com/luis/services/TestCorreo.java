package com.luis.services;

import java.security.NoSuchAlgorithmException;

public class TestCorreo {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// EnvioCorreo.EnviarCorreo("luis_lapresa@hotmail.com", "HOlaluis",
		// "esto es una prueba");

		System.out.println(Utils.getHash("pepe"));
	}

}
