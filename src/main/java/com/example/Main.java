package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        System.out.println("client partito");
        Socket s = new Socket("localhost", 3000);

        System.out.println("il client si è collegato \n");

        String scelta;

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
        String stringaInviata;

        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1- Trasformare stringa in maiuscolo \n");
            System.out.println("2- Trasformare stringa in minuscolo \n");
            System.out.println("3- Ribaltare i caratteri della stringa \n");
            System.out.println("4- Contare il numero di caratteri \n");
            System.out.println("0- Chiudere la connessione \n");

            scelta = scanner.nextLine();


            switch(scelta){

                case "1": 

                    System.out.println("Digita la frase: ");
                    stringaInviata = scanner.nextLine();
                    out.writeBytes("U" + "\n");
                    if(in.readLine().equals("frase?")){
                        out.writeBytes(stringaInviata + "\n");
                        String stringaRicevuta1 = in.readLine();
                        System.out.println(stringaRicevuta1 + "\n");

                    }
                
                    case "2": 

                        System.out.println("Digita la frase: ");
                        stringaInviata = scanner.nextLine();
                        out.writeBytes("L" + "\n");
                        if(in.readLine().equals("frase?")){
                            out.writeBytes(stringaInviata + "\n");
                            String stringaRicevuta1 = in.readLine();
                            System.out.println(stringaRicevuta1 + "\n");

                        }
                        break;
                    
                        case "3": 

                            System.out.println("Digita la frase: ");
                            stringaInviata = scanner.nextLine();
                            out.writeBytes("R" + "\n");
                            if(in.readLine().equals("frase?")){
                                out.writeBytes(stringaInviata + "\n");
                                String stringaRicevuta1 = in.readLine();
                                System.out.println(stringaRicevuta1 + "\n");

                            }
                            break;
                        
                        case "4":
                            System.out.println("Digita la frase: ");
                            stringaInviata = scanner.nextLine();
                            out.writeBytes("C" + "\n");
                            if(in.readLine().equals("frase?")){
                                out.writeBytes(stringaInviata + "\n");
                                String stringaRicevuta1 = in.readLine();
                                System.out.println(stringaRicevuta1 + "\n");

                            }
                        break;   
            }

        }while(!scelta.equals("0"));
        s.close();
    }
}