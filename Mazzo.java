package it.corso.rubamazzetto.data;

import java.util.Map;

public class Mazzo {

		public Mazzo() { }
		
		public void creaMazzo(Map<Integer,Carta> mazzo) {
			// metodo che crea il mazzo
		    // aggiunge all'hashmap una chiave di tipo intero e un valore di tipo carta
			
			mazzo.put(1, new Carta('♥', 1)); //si usa il costruttore con 2 parametri
			mazzo.put(2, new Carta('♥', 2));
			mazzo.put(3, new Carta('♥', 3));
			mazzo.put(4, new Carta('♥', 4));
			mazzo.put(5, new Carta('♥', 5));
			mazzo.put(6, new Carta('♥', 6));
			mazzo.put(7, new Carta('♥', 7));
			mazzo.put(8, new Carta('♥', 8));
			mazzo.put(9, new Carta('♥', 9));
			mazzo.put(10, new Carta('♥', 10));
			mazzo.put(11, new Carta('♦', 1));
			mazzo.put(12, new Carta('♦', 2));
			mazzo.put(13, new Carta('♦', 3));
			mazzo.put(14, new Carta('♦', 4));
			mazzo.put(15, new Carta('♦', 5));
			mazzo.put(16, new Carta('♦', 6));
			mazzo.put(17, new Carta('♦', 7));
			mazzo.put(18, new Carta('♦', 8));
			mazzo.put(19, new Carta('♦', 9));
			mazzo.put(20, new Carta('♦', 10));
			mazzo.put(21, new Carta('♣', 1));
			mazzo.put(22, new Carta('♣', 2));
			mazzo.put(23, new Carta('♣', 3));
			mazzo.put(24, new Carta('♣', 4));
			mazzo.put(25, new Carta('♣', 5));
			mazzo.put(26, new Carta('♣', 6));
			mazzo.put(27, new Carta('♣', 7));
			mazzo.put(28, new Carta('♣', 8));
			mazzo.put(29, new Carta('♣', 9));
			mazzo.put(30, new Carta('♣', 10));
			mazzo.put(31, new Carta('♠', 1));
			mazzo.put(32, new Carta('♠', 2));
			mazzo.put(33, new Carta('♠', 3));
			mazzo.put(34, new Carta('♠', 4));
			mazzo.put(35, new Carta('♠', 5));
			mazzo.put(36, new Carta('♠', 6));
			mazzo.put(37, new Carta('♠', 7));
			mazzo.put(38, new Carta('♠', 8));
			mazzo.put(39, new Carta('♠', 9));
			mazzo.put(40, new Carta('♠', 10));
		}
}