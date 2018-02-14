package it.corso.rubamazzetto.data;

import it.corso.rubamazzetto.configurazione.util.FasiGiocoInt;

import java.util.*;


public class FasiGioco implements FasiGiocoInt {

		private String nome;
		int mangiate=0; 
/* valore che si incrementa ogni volta che qualcuno mangia. Quel valore viene di volta in volta 
associato al giocatore che mangia. A fine partita, chi avr� mangiato per ultimo(valore mangiate pi� alto)
prender� le eventuali carte rimaste sul tavolo */
		int mangiatePC=0; 
		int mangiateUtente=0;
//------------------------------------------------------------------------
	@Override
	public void inserisciNome(){
		Scanner nomeTastiera= new Scanner(System.in);
		System.out.println("Inserire nome giocatore:");
		nome=nomeTastiera.nextLine();
		
	}
//------------------------------------------------------
	@Override
	// Ritorna TRUE se viene 0....ritorna FALSE se viene 1
	public boolean lancioMoneta() {
		Random random=new Random();
		int lancio;

		System.out.print("Scelta turno: ");
		lancio=random.nextInt(2); //genera numeri casuali tra 0 e 1
		if(lancio==0) {
			System.out.println("E' il tuo turno "+nome+"!\n");
			return true;
		}
		else {
			System.out.println("E' il turno del computer!\n");
			return false;
		}
	}
//------------------------------------------------------
	@Override
	// Estrae dall'hashmap le carte da servire.Gli indici sono i valori casuali dell'arraylist creato nel main
	public void dareCarte1Turno(Map<Integer,Carta> mazzo, 
								ArrayList<Integer> listaChiaviRandom, 
								ArrayList<Carta> manoUtente,
								ArrayList<Carta> manoPC, 
								ArrayList<Carta> tavolo) {
		int valore;
		int contatore=0;
		
		for(int i=0; i<10; i++) { // vengono servite 10 carte
			contatore++;
			valore=listaChiaviRandom.get(i); // assume i primi 10 valori casuali dell'arrayList
			Carta carta= mazzo.get(valore); // prende 10 carte dall'hashmap mazzo aventi come indice i primi 10 valori casuali
			if(contatore<=3) { // le prime 3 carte vanno all'utente e sotto vengono stampate
				manoUtente.add((Carta) carta);
			}
			else if(contatore>3 && contatore<=6) { // le 3 successive vanno al pc ma non vengono stampate
				manoPC.add((Carta) carta);
			}
			else  tavolo.add((Carta) carta); // le ultime 4 vanno sul tavolo
		}
		System.out.println("Carte "+nome+":");
		System.out.println(manoUtente);
		System.out.println("\nCarte in tavola:");
		stampaArrayList(tavolo);
	}
//------------------------------------------------------
	@Override
	public void dareCarte(Map<Integer,Carta> mazzo, 
						 ArrayList<Integer> listaChiaviRandom, 
						 ArrayList<Carta> manoUtente,
						 ArrayList<Carta> manoPC, 
						 ArrayList<Carta> tavolo,
						 ArrayList<Carta> mazzettoUtente,
						 ArrayList<Carta> mazzettoPC,
						 int numTurno) {
		int valore;
		int contatore=0;

		if(numTurno==2) {
			for (int i = 10; i <16; i++) { // serve dalla 11esima in pos 10 alla 16esima in pos 15
				contatore++;
				valore = listaChiaviRandom.get(i); // usa gli elementi dell'arraylist di valori casuali
				Carta carta = mazzo.get(valore); 
				if (contatore <= 3) { // le prime 3 vanno all'utente e sotto vengono stampate
					manoUtente.add((Carta) carta);
				} else if (contatore > 3 && contatore <= 6) { // le 3 successive vanno al pc ma non vengono stampate
					manoPC.add((Carta) carta);
				}
			}
			System.out.println("Carte " + nome + ":");
			System.out.println(manoUtente);
			if(mazzettoUtente.size()==0) { // se il mazzetto � vuoto..
				System.out.println("Mazzetto "+ nome + ": vuoto");
			}	
			else { // se non � vuoto...
					System.out.print("Mazzetto " + nome + ":");
					stampaMazzetto(mazzettoUtente.get(mazzettoUtente.size()-1)); // stampa la carta con posizione
														//uguale alla grandezza dell'arraylist -1 per non uscire dall'arraylist
			}
			System.out.println("\nCarte in tavola:");
			stampaArrayList(tavolo);
			if(mazzettoPC.size()==0) { // se � vuoto..
				System.out.println("Mazzetto PC: vuoto");
			}
			else {
				System.out.print("Mazzetto PC:");
				stampaMazzetto(mazzettoPC.get(mazzettoPC.size()-1));
			}
			
		}
		if(numTurno==3) {
			for (int i = 16; i < 22; i++) { 
				contatore++;
				valore = listaChiaviRandom.get(i); // usa gli elementi dell'arraylist del main
				Carta carta = mazzo.get(valore);
				if (contatore <= 3) { // le prime 3 vanno all'utente e sotto vengono stampate
					manoUtente.add((Carta) carta);
				} else if (contatore > 3 && contatore <= 6) { // le 3 successive vanno al pc ma non vengono stampate
					manoPC.add((Carta) carta);
				}
			}
			System.out.println("Carte " + nome + ":");
			System.out.println(manoUtente);
			if(mazzettoUtente.size()==0) {
				System.out.println("Mazzetto "+ nome + ": vuoto");
			}	
			else {
					System.out.print("Mazzetto " + nome + ":");
					stampaMazzetto(mazzettoUtente.get(mazzettoUtente.size()-1));
			}
			System.out.println("\nCarte in tavola:");
			stampaArrayList(tavolo);
			if(mazzettoPC.size()==0) {
				System.out.println("Mazzetto PC: vuoto");
			}
			else {
				System.out.print("Mazzetto PC:");
				stampaMazzetto(mazzettoPC.get(mazzettoPC.size()-1));
			}
		}
		if(numTurno==4) {
			for (int i = 22; i < 28; i++) { 
				contatore++;
				valore = listaChiaviRandom.get(i); // usa gli elementi dell'arraylist del main
				Carta carta = mazzo.get(valore);
				if (contatore <= 3) { // le prime 3 vanno all'utente e sotto vengono stampate
					manoUtente.add((Carta) carta);
				} else if (contatore > 3 && contatore <= 6) { // le 3 successive vanno al pc ma non vengono stampate
					manoPC.add((Carta) carta);
				}
			}
			System.out.println("Carte " + nome + ":");
			System.out.println(manoUtente);
			if(mazzettoUtente.size()==0) {
				System.out.println("Mazzetto "+ nome + ": vuoto");
			}	
			else {
					System.out.print("Mazzetto " + nome + ":");
					stampaMazzetto(mazzettoUtente.get(mazzettoUtente.size()-1));
			}
			System.out.println("\nCarte in tavola:");
			stampaArrayList(tavolo);
			if(mazzettoPC.size()==0) {
				System.out.println("Mazzetto PC: vuoto");
			}
			else {
				System.out.print("Mazzetto PC:");
				stampaMazzetto(mazzettoPC.get(mazzettoPC.size()-1));
			}
		}
		if(numTurno==5) {
			for (int i = 28; i < 34; i++) { 
				contatore++;
				valore = listaChiaviRandom.get(i); // usa gli elementi dell'arraylist del main
				Carta carta = mazzo.get(valore);
				if (contatore <= 3) { // le prime 3 vanno all'utente e sotto vengono stampate
					manoUtente.add((Carta) carta);
				} else if (contatore > 3 && contatore <= 6) { // le 3 successive vanno al pc ma non vengono stampate
					manoPC.add((Carta) carta);
				}
			}
			System.out.println("Carte " + nome + ":");
			System.out.println(manoUtente);
			if(mazzettoUtente.size()==0) {
				System.out.println("Mazzetto "+ nome + ": vuoto");
			}	
			else {
					System.out.print("Mazzetto " + nome + ":");
					stampaMazzetto(mazzettoUtente.get(mazzettoUtente.size()-1));
			}
			System.out.println("\nCarte in tavola:");
			stampaArrayList(tavolo);
			if(mazzettoPC.size()==0) {
				System.out.println("Mazzetto PC: vuoto");
			}
			else {
				System.out.print("Mazzetto PC:");
				stampaMazzetto(mazzettoPC.get(mazzettoPC.size()-1));
			}
		}
		if(numTurno==6) {
			for (int i = 34; i < 40; i++) { 
				contatore++;
				valore = listaChiaviRandom.get(i); // usa gli elementi dell'arraylist del main
				Carta carta = mazzo.get(valore);
				if (contatore <= 3) { // le prime 3 vanno all'utente e sotto vengono stampate
					manoUtente.add((Carta) carta);
				} else if (contatore > 3 && contatore <= 6) { // le 3 successive vanno al pc ma non vengono stampate
					manoPC.add((Carta) carta);
				}
			}
			System.out.println("Carte " + nome + ":");
			System.out.println(manoUtente);
			if(mazzettoUtente.size()==0) {
				System.out.println("Mazzetto "+ nome + ": vuoto");
			}	
			else {
					System.out.print("Mazzetto " + nome + ":");
					stampaMazzetto(mazzettoUtente.get(mazzettoUtente.size()-1));
			}
			System.out.println("\nCarte in tavola:");
			stampaArrayList(tavolo);
			if(mazzettoPC.size()==0) {
				System.out.println("Mazzetto PC: vuoto");
			}
			else {
				System.out.print("Mazzetto PC:");
				stampaMazzetto(mazzettoPC.get(mazzettoPC.size()-1));
			}
		}

	}
//-------------------------------------------------------
	@Override
	public void stampaArrayList(ArrayList<Carta> arrayListGenerale) {
		// Stampa un ArrayList generale
		for(int i=0; i<arrayListGenerale.size(); i++) {
			System.out.println(arrayListGenerale.get(i));
		}
	}
//------------------------------------------------------
	@Override
	public void stampaMazzetto(Carta mazzettoGenerale){
		// Stampa l'ultima carta di un mazzetto 
		System.out.println(mazzettoGenerale + "\n");
	}
//------------------------------------------------------	
	@Override
	public void azioneUtente(ArrayList<Carta> manoUtente, 
					ArrayList<Carta> tavolo,
					ArrayList<Carta> mazzettoUtente, 
					ArrayList<Carta> mazzettoPC) {
		boolean trovato = false;
		Carta cartaSelezionata = new Carta();

		ArrayList<Integer> tavoloConvertito = new ArrayList<>(); // arraylist che conterr� solo i valori delle carte
		estraiValore(tavolo, tavoloConvertito); // tavoloConvertito ora contiene solo il valore senza il seme
		ArrayList<Integer> manoUtenteConvertito = new ArrayList<>();
		estraiValore(manoUtente, manoUtenteConvertito); // manoUtente ora contiene solo il valore senza il seme

		System.out.print("\nInserisci il valore della carta da selezionare: ");
		Scanner input = new Scanner(System.in);
		Integer valoreInserito = input.nextInt(); // si inserisce il valore della carta che si vuole usare
		//controlla se il valore inserito corrisponde a una carta della mano utente
		while (!manoUtenteConvertito.contains(valoreInserito)) { // ritorna true o false
			System.out.print("Valore non presente, inserire di nuovo: ");
			valoreInserito = input.nextInt();
		}
		// associa il valore inserito alla carta corrispondente 
		for (int i = 0; i < manoUtenteConvertito.size(); i++) {
			if (manoUtenteConvertito.get(i) == valoreInserito) {
				cartaSelezionata = manoUtente.get(i);//� la carta selezionata corrispondente al valore inserito
				break;
			}
		}
		// variante assopigliatutto
		if (valoreInserito == 1) { // se � un asso
			System.out.print("\n" + nome + " ");
			pigliaTutto(manoUtente, cartaSelezionata, tavolo, mazzettoPC, mazzettoUtente);// prende o le carte in tavola o il mazzetto PC
			System.out.println("Carte " + nome);
			System.out.println(manoUtente);
			System.out.print("Mazzetto " + nome + ":");
			stampaMazzetto(cartaSelezionata);
			trovato = true; // termina il turno dell'utente
		}

		if (trovato == false) { // se non � un asso...
			// controlla se la nostra carta � uguale a una sul tavolo
			for (int j = 0; j < tavolo.size(); j++) {
				if (tavoloConvertito.get(j) == valoreInserito) {
					trovato = true;
					// Specifica con quale carta della mano prende quella in tavola
					System.out.println("\nMossa " + nome + ": " + cartaSelezionata + " --> " + tavolo.get(j));
					// stampa il mazzetto incrementato grazie alla mossa effettuata
					aumentaMazzetto(cartaSelezionata, tavolo.get(j), mazzettoUtente);
					diminuisciMano(cartaSelezionata, manoUtente);
					diminuisciTavolo(tavolo.get(j), tavolo);

					mangiate++;
					mangiateUtente = mangiate;

					// Stampa tavolo e mano utente aggiornati dopo la mossa
					System.out.println("Carte " + nome);
					System.out.println(manoUtente);
					System.out.print("Mazzetto " + nome + ":");
					stampaMazzetto(cartaSelezionata);
					System.out.println("\nCarte in tavola:");
					stampaArrayList(tavolo);
					//se ne trova la carta sul tavolo esegue il codice e poi esce dal ciclo
					break;
				}
			}
		}
		// Controlla se la carta � uguale al mazzetto avversario
		if (trovato == false) {
			try {
				for (int i = 0; i < manoUtente.size(); i++) {
					if (mazzettoPC.size() > 0 && valoreInserito == (splitCarta(mazzettoPC.get(mazzettoPC.size() - 1)))) {
						trovato = true;
						System.out.println("RUBAMAZZETTO!! La carta selezionata per rubare il mazzo � " + cartaSelezionata);
						rubaMazzetto(cartaSelezionata, mazzettoPC, mazzettoUtente);
						System.out.println("Mazzetto PC  | vuoto |");
						diminuisciMano(cartaSelezionata, manoUtente);
						// Stampa tavolo e mano utente aggiornati dopo la mossa
						System.out.println("\nCarte " + nome + ":");
						System.out.println(manoUtente);
						System.out.print("Mazzetto " + nome + ":");
						stampaMazzetto(cartaSelezionata);
						System.out.println("\nCarte in tavola:");
						stampaArrayList(tavolo);
					}
				}
			} catch (IndexOutOfBoundsException e) {
			}
		}
		// ultima azione possibile: tira la carta in tavola
		if (trovato == false) {
			System.out.print("\nMossa " + nome + " ---> ");
			aumentaTavolo(cartaSelezionata, tavolo);
			diminuisciMano(cartaSelezionata, manoUtente);
			// Stampa tavolo aggiornato dopo la mossa
			System.out.println("\nCarte " + nome + ":");
			System.out.println(manoUtente);
			System.out.println("\nCarte in tavola:");
			stampaArrayList(tavolo);
		}
	}

	
//------------------------------------------------------	
	@Override
	public void azionePC(ArrayList<Carta> manoPC, 
								ArrayList<Carta> tavolo, 
								ArrayList<Carta> mazzettoUtente, 
								ArrayList<Carta> mazzettoPC) {
		boolean trovato=false;
		ArrayList<Integer> tavoloConvertito = new ArrayList<>(); // arraylist che conterr� solo i valori delle carte
		estraiValore(tavolo, tavoloConvertito); // tavoloConvertito ora contiene solo il valore
		ArrayList<Integer> manoPCConvertito= new ArrayList<>();
		estraiValore(manoPC, manoPCConvertito);
		
	// variante assopigliatutto
		for(int i=0; i<manoPC.size();i++) {
			if(manoPCConvertito.get(i) == 1) { // controlla se manoPC contiene un asso
				System.out.print("\nPC ");
				pigliaTutto(manoPC,manoPC.get(i),tavolo,mazzettoUtente,mazzettoPC); // prende o le carte in tavola o il mazzetto utente
				System.out.print("Mazzetto PC:");
				stampaMazzetto(mazzettoPC.get(mazzettoPC.size()-1)); // stampa l'ultima carta 
				trovato=true; // termina il turno del PC 
			}
		}
		if(trovato==false){ // se non ha terminato il turno, controlla se una carta del pc � uguale a una sul tavolo 
			for(int i=0; i<manoPC.size();i++) {
				for(int j=0; j<tavolo.size();j++) {
					// se il valore della carta splittata del pc � contenuto nell'array formato dai valori in tavola
					if(tavoloConvertito.get(j)==(splitCarta(manoPC.get(i)))) {
						trovato=true;
						System.out.println("\nMossa PC: "+ manoPC.get(i) + " --> "+ tavolo.get(j));
						System.out.print("Mazzetto PC:");
						stampaMazzetto(manoPC.get(i)); //stampa mazzettoPC
						aumentaMazzetto(manoPC.get(i),tavolo.get(j),mazzettoPC); // riempie il mazzetto con la carte in tavola e quella del PC
						diminuisciMano(manoPC.get(i),manoPC); // leva la carta alla manoPC
						diminuisciTavolo(tavolo.get(j),tavolo); //leva la carta dal tavolo
						
						mangiate++; //conta il numero di mangiate effettuate
						mangiatePC=mangiate; 
						
						// Stampa tavolo aggiornato dopo la mossa
						System.out.println("Carte in tavola:");
						stampaArrayList(tavolo);
						break; //esce dal ciclo secondario
					}
				}
				if(trovato==true) break; // esce dal ciclo principale
			}
		}
		if(trovato==false) {
			try {
				for(int i=0; i<manoPC.size();i++) {
					if(mazzettoUtente.size()>0 && manoPCConvertito.get(i)==(splitCarta(mazzettoUtente.get(mazzettoUtente.size()-1)))){ // controlla se il valore di una carta del pc � = al valore dell'ultima carta
						trovato=true;												// del mazzetto dell'utente
						System.out.println("RUBAMAZZETTO!! La carta selezionata per rubare il mazzo e'" + manoPC.get(i));
						rubaMazzetto(manoPC.get(i),mazzettoUtente, mazzettoPC);
						System.out.println("Mazzetto " + nome +" | vuoto |");
						System.out.print("Mazzetto PC: ");
						stampaMazzetto(manoPC.get(i));
						diminuisciMano(manoPC.get(i),manoPC);
						// Stampa tavolo aggiornato dopo la mossa
						System.out.println("\nCarte in tavola:");
						stampaArrayList(tavolo);
					}
				}
			}catch(IndexOutOfBoundsException e) {}
		}
		if(trovato==false) {
			System.out.print("\nMossa PC --> ");
			aumentaTavolo(manoPC.get(0),tavolo);
			diminuisciMano(manoPC.get(0),manoPC);
			// Stampa tavolo aggiornato dopo la mossa
			System.out.println("\nCarte in tavola:");
			stampaArrayList(tavolo);
			trovato=true;
		}
	}
// -------------------------------------------------------
	@Override
	public int splitCarta(Carta cartaDaSplittare) {//restituisce solo il valore di una carta
		int valoreCarta = cartaDaSplittare.getValore();
		return valoreCarta;
	}
//----------------------------------------------------------	
	@Override
	public void estraiValore (ArrayList<Carta> arrayDaConvertire, ArrayList<Integer> arrayConvertito) {
	// converte un arraylist di carte in un arraylist di soli valori
		for(int i=0; i<arrayDaConvertire.size(); i++) {
		Carta soloValore= arrayDaConvertire.get(i); // carta ancora da splittare
		arrayConvertito.add(splitCarta(soloValore)); // aggiunge il valore all'arraylist
	}
}
//--------------------------------------------------------
	@Override
	public void pigliaTutto (ArrayList<Carta> manoGenerica,Carta cartaAsso, ArrayList<Carta> tavolo,ArrayList<Carta> mazzettoAvversario,ArrayList<Carta> mazzettoDaAmpliare ) {
		// valuta se ci sono pi� carte in tavola o nel mazzetto avversario
		if(tavolo.size() >= mazzettoAvversario.size()) {
			mazzettoDaAmpliare.addAll(tavolo);
			mazzettoDaAmpliare.add(cartaAsso);
			tavolo.clear();
			diminuisciMano(cartaAsso,manoGenerica);
			System.out.println("ASSO PIGLIA TUTTO!! Ha rubato il tavolo");
			System.out.println("\nTavolo vuoto\n");
		}
		else {
			rubaMazzetto(cartaAsso,mazzettoAvversario,mazzettoDaAmpliare);
			diminuisciMano(cartaAsso,manoGenerica);
			System.out.println("ASSO PIGLIA TUTTO!! Ha rubato il mazzetto");
			System.out.println("\nCarte in tavola:");
			stampaArrayList(tavolo);
		}
	}
//--------------------------------------------------------
	@Override
	public void diminuisciTavolo(Carta cartaDaRimuovere, ArrayList<Carta> tavolo) {
		tavolo.remove(cartaDaRimuovere);
	}
//--------------------------------------------------------
	@Override
	public void diminuisciMano(Carta cartaDaRimuovere, ArrayList<Carta> manoGenerica) {
		manoGenerica.remove(cartaDaRimuovere);

	}
//--------------------------------------------------------
	@Override
	public void rubaMazzetto(Carta cartaPerRubare,ArrayList<Carta> mazzettoAvversario,ArrayList<Carta> mazzettoDaAmpliare ) { // aggiunge il mazzetto rubato all'altro
		mazzettoDaAmpliare.addAll(mazzettoAvversario);
		mazzettoDaAmpliare.add(cartaPerRubare);
		mazzettoAvversario.clear();
		// mazzetto ampliato di chi ha rubato
	}
//--------------------------------------------------------	
	@Override
	public void aumentaMazzetto(Carta cartaMano, Carta cartaTavolo, ArrayList<Carta> mazzettoGenerale) {
		mazzettoGenerale.add(cartaTavolo);
		mazzettoGenerale.add(cartaMano);
	}
//--------------------------------------------------------
	@Override
	public void aumentaTavolo(Carta cartaMano, ArrayList<Carta> tavolo) {
		tavolo.add(cartaMano);
		System.out.println(cartaMano);
	}
//--------------------------------------------------------
	@Override
	public void contaPunti(ArrayList<Carta> mazzettoPC, 
						   ArrayList<Carta> mazzettoUtente,
						   ArrayList<Carta> tavolo) {
		int puntiUtente=0;
		int puntiPC=0;
		
		if(mangiatePC>mangiateUtente) { //se ha mangiato per ultimo il PC
			puntiPC=mazzettoPC.size()+tavolo.size();
			if(tavolo.size()>0) {System.out.println("Il PC prende il resto del tavolo.");}
			System.out.println("Punti PC: "+puntiPC);
	
			puntiUtente=mazzettoUtente.size();
			System.out.println("Punti "+nome+": "+puntiUtente);
		}
		else { // se ha mangiato per ultimo l'utente
			puntiPC=mazzettoPC.size();
			if(tavolo.size()>0) {System.out.println(nome + " prende il resto del tavolo.");}
			System.out.println("Punti PC: "+puntiPC);
		
			puntiUtente=mazzettoUtente.size()+tavolo.size();
			System.out.println("Punti "+nome+": "+puntiUtente);
		}
		
		if(puntiPC>puntiUtente){
			System.out.println("HA VINTO PC");
		}
		else if(puntiPC<puntiUtente){
			System.out.println("HA VINTO "+nome);
		}
		else System.out.println("PAREGGIO");
	}



}
