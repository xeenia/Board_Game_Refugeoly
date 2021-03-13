package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveGame {
  
    File f3 = new File("Saves.txt");
    
    public void SaveMe(ArrayList<Refugee> refugee,ReceiverEntity mafia,GiverEntity NGO_Bank) throws FileNotFoundException, IOException{


        int size = refugee.size(); 



        System.out.println();
        String st;
         BufferedReader br = new BufferedReader(new FileReader(f3)); 
         String noum;
         int flag=0;
         while((noum=br.readLine())!=null){
             
            if(noum.contains("_SAVE")){
                flag++;
            }
         }
         BufferedWriter writer = new BufferedWriter(new FileWriter(f3, true));
         writer.append((flag+1)+"_SAVE\n");
         for(int i=0 ; i<size ; i++){
            
            writer.append(refugee.get(i).name + " " + refugee.get(i).money + " " + refugee.get(i).sq + " ");
            if(refugee.get(i).alive==true){
                writer.append("alive");
            }
            else
                writer.append("dead");
            writer.append("\n");
         }
         writer.append("Mafia " + mafia.money + "$\n");
         writer.append("NGO " + NGO_Bank.money + "$\n");
         
         writer.append("\n");
         int aa,ee;
         for(int i=0 ; i<size ; i++){
             if(refugee.get(i).alive==true){
                 aa=1;
             }
             else
                 aa=0;
             
             if(refugee.get(i).extra_life==true)
                 ee=1;
             else
                 ee=0;
            writer.append("<" + refugee.get(i).name + "," + refugee.get(i).money + ","+refugee.get(i).exp+"," + refugee.get(i).sq + "," + mafia.money + "," + NGO_Bank.money + "," + aa + "," + ee + "," + refugee.get(i).turn_time + "," + refugee.get(i).roll + ">");
            writer.append("\n");
         }
         writer.append("end"+(flag+1)+"\n");
         writer.close();   
    }
}