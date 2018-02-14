package it.corso.rubamazzetto.configurazione.util;

import java.io.*;

public class LeggiEStampa
    {

       public void leggiFile(){
            try{
                // Seleziona ed apre il file
                FileInputStream fstream = new FileInputStream("gioco.txt");
                // Accede all'oggetto DataInputStream ed al BufferedReader
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                //Legge il file riga per riga
                while ((strLine = br.readLine()) != null)   {
                    // Stampa il contenuto a video.
                    System.out.println (strLine);
                }
                //Chiude InputStream
                in.close();
            }catch (Exception e){  //Verifica se ci sono eccezioni.
                System.err.println("Error: " + e.getMessage());
                for(int i=0; i<50; i++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }










