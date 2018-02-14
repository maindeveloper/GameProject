/**
 Esame sulla programmazione agli oggetti.
 Ultima modifica: 6 gennaio 2018.
 Programma che simula il famoso gioco di carte Rubamazzetto

 Autori:
 Nicola T. Aspirante programmatore
 Samuele P. Aspirante programmatore
 Margherita M. Aspirante programmatore
 Bruno B. Aspirante programmatore
 */


package it.corso.rubamazzetto;

import it.corso.rubamazzetto.configurazione.util.LeggiEStampa;
import it.corso.rubamazzetto.data.Carta;
import it.corso.rubamazzetto.data.FasiGioco;
import it.corso.rubamazzetto.data.Mazzo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Map<Integer,Carta> mazzo= new HashMap<>();// creo il contenitore del mazzo, quindi delle 40 carte
		Mazzo oggettoMazzo=new Mazzo(); // creiamo un oggetto della classe Mazzo
		oggettoMazzo.creaMazzo(mazzo);// inserisce l'oggettomazzo dentro al mazzo
		// array vuoti
		ArrayList<Carta> manoUtente = new ArrayList<>(); // carte dell'utente
		ArrayList<Carta> manoPC = new ArrayList<>();	// carte del pc
		ArrayList<Carta> tavolo = new ArrayList<>();	// carte in tavolo
		ArrayList<Carta> mazzettoUtente= new ArrayList<>();
		ArrayList<Carta> mazzettoPC = new ArrayList<>();
		int numTurno; // contatore turni
		boolean start; // decide chi comincia a giocare casualmente

//----------------------
        //Stampa le regole del gioco
        LeggiEStampa regole = new LeggiEStampa();
        regole.leggiFile();
        System.out.println();
        for(int i=0; i<200; i++) {
            System.out.print("*");
        }
        System.out.println();
//----------------------

		FasiGioco partita=new FasiGioco(); // partita serve per le varie azioni svolte in un turno
        System.out.println();
        partita.inserisciNome();
		start=partita.lancioMoneta(); // partita comincia con il lancio della moneta

//-----------------------

		// arraylist con valori casuali, ArrayList che simula il mazzo mescolato
		ArrayList<Integer> listaChiaviRandom = new ArrayList<>();
		Random random= new Random();
		for(int i=0; i<40;i++) {
			Integer casuale= 1+random.nextInt(40);
			if(listaChiaviRandom.contains(casuale)==false) { // controlla se contiene gi� quel valore
				listaChiaviRandom.add(casuale);	
			}
			else i--; // per non incrementare nel caso lo contenesse gi�
		}

//---------------------------------

		// primo turno: vengono servite 10 carte
		if(start==false) { // inizia il PC
			System.out.println("-------  INIZIO 1 MANCHE  -------\n");
			System.out.println("Vengono servite le carte..\n");
			partita.dareCarte1Turno(mazzo, listaChiaviRandom, manoUtente, manoPC, tavolo);
			for(int k=0; k<3; k++) { // 3 azioni ciascuno
				partita.azionePC(manoPC, tavolo, mazzettoUtente, mazzettoPC);
				partita.azioneUtente(manoUtente, tavolo, mazzettoUtente, mazzettoPC);
			}
		}
		if(start==true){ // inizia l'utente
			System.out.println("-------  INIZIO 1 MANCHE  -------\n");
			System.out.println("Vengono servite le carte..\n");
			partita.dareCarte1Turno(mazzo, listaChiaviRandom, manoUtente, manoPC, tavolo);
			for(int k=0; k<3; k++) { // 3 azioni ciascuno
				partita.azioneUtente(manoUtente, tavolo, mazzettoUtente, mazzettoPC);
				partita.azionePC(manoPC, tavolo, mazzettoUtente, mazzettoPC);
			}
		}

    	// 5 TURNI successivi
		numTurno=2;
		if(start==false) { // riparte il PC
			for(int j=0; j<5; j++) { // 5 turni
				System.out.println("\n-------  INIZIO "+(numTurno)+" MANCHE  -------\n");
				System.out.println("Vengono servite le carte..\n");
				partita.dareCarte(mazzo, listaChiaviRandom, manoUtente, manoPC, tavolo,mazzettoUtente, mazzettoPC, numTurno);
				for (int i=0; i<3; i++) {
					partita.azionePC(manoPC, tavolo, mazzettoUtente, mazzettoPC);
					partita.azioneUtente(manoUtente, tavolo, mazzettoUtente, mazzettoPC);
				}
				numTurno++;
			}
		}
		else { // riparte l'utente
			for(int j=0; j<5; j++) { 
				System.out.println("\n-------  INIZIO "+(numTurno)+" MANCHE  -------\n");
				System.out.println("Vengono servite le carte..\n");
				partita.dareCarte(mazzo, listaChiaviRandom, manoUtente, manoPC, tavolo,mazzettoUtente, mazzettoPC, numTurno);
				for (int i=0; i<3; i++) {
					partita.azioneUtente(manoUtente, tavolo, mazzettoUtente, mazzettoPC);
					partita.azionePC(manoPC, tavolo, mazzettoUtente, mazzettoPC);
				}
				numTurno++;
			}
		}

		System.out.println("\n FINE PARTITA\n");
		partita.contaPunti(mazzettoPC,mazzettoUtente,tavolo); // conta punti e incorona il vincitore
	}

}
