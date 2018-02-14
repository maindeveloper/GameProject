package it.corso.rubamazzetto.data;

public class Carta {
		
		private int valore;
		private char seme;
//------------------------------------------------------
		
		public Carta() { } // costruttore vuoto
		
		public Carta(char seme, int valore) { // per costruire una carta
		this.seme=seme;
		this.valore=valore;
		}

//--------------------------------------------

		@Override
		public String toString() { // per stampare le carte
			return valore +" "+ seme;
		}

//----------------------------------------------

		public int getValore() {
			return valore;
		}

		public void setValore(int valore) {
			this.valore = valore;
		}

		public char getSeme() {
			return seme;
		}

		public void setSeme(char seme) {
			this.seme = seme;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
