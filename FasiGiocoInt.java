package it.corso.rubamazzetto.configurazione.util;

import it.corso.rubamazzetto.data.Carta;

import java.util.ArrayList;
import java.util.Map;

public interface FasiGiocoInt {
	
	void inserisciNome();
	boolean lancioMoneta(); 
	
	void dareCarte1Turno(Map<Integer,Carta> mazzo, ArrayList<Integer> listaChiaviRandom, ArrayList<Carta> manoUtente,ArrayList<Carta> manoPC, ArrayList<Carta> tavolo);
	void dareCarte(Map<Integer,Carta> mazzo, ArrayList<Integer> listaChiaviRandom, ArrayList<Carta> manoUtente,ArrayList<Carta> manoPC, ArrayList<Carta> tavolo,ArrayList<Carta> mazzettoUtente, ArrayList<Carta> mazzettoPC, int numTurno);
	
	void stampaArrayList(ArrayList<Carta> arrayListGenerale);
	void stampaMazzetto(Carta mazzettoGenerale);
		
	void azioneUtente(ArrayList<Carta> manoUtente, ArrayList<Carta> tavolo,ArrayList<Carta> mazzettoUtente, ArrayList<Carta> mazzettoPC);
	void azionePC(ArrayList<Carta> manoPC, ArrayList<Carta> tavolo,ArrayList<Carta> mazzettoUtente,ArrayList<Carta> mazzettoPC); 
			
	int splitCarta(Carta cartaDaSplittare);
	void estraiValore (ArrayList<Carta> arrayDaConvertire, ArrayList<Integer> arrayConvertito);
	void pigliaTutto (ArrayList<Carta> manoUtente,Carta cartaAsso, ArrayList<Carta> tavolo,ArrayList<Carta> mazzettoAvversario,ArrayList<Carta> mazzettoDaAmpliare );
	void diminuisciTavolo(Carta cartaDaRimuovere, ArrayList<Carta> tavolo);
	void diminuisciMano(Carta cartaDaRimuovere, ArrayList<Carta> manoGenerica); 
	void aumentaMazzetto(Carta cartaMano, Carta cartaTavolo, ArrayList<Carta> mazzettoGenerale);
	void rubaMazzetto(Carta cartaPerRubare,ArrayList<Carta> mazzettoAvversario,ArrayList<Carta> mazzettoDaAmpliare);
	void aumentaTavolo(Carta cartaMano, ArrayList<Carta> tavolo); 
	
	void contaPunti(ArrayList<Carta> mazzettoPC, ArrayList<Carta> mazzettoUtente,ArrayList<Carta> tavolo);
		
			
			
			
			
			
}
