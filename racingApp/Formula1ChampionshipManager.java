package com.mycompany.racingApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
class Formula1ChampionshipManager implements ChamoionshipManager,Serializable{
    
    @Override
    public void setNoOfDrivers(){
        
    }
    
    public void CreateNewDriver(){
        
        Formula1Driver fd = new Formula1Driver();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter drivers name:");
        String name = sc.nextLine();
        fd.setName(name);
        
        System.out.println("Enter drivers Loavation:");
        String location = sc.nextLine();
        fd.setLocation(location);
        
        System.out.println("Enter drivers Team Name:");
        String Tname = sc.nextLine();
        fd.setTeam(Tname); 
        
        System.out.println("Enter drivers current positions(please enter positions followed by coma):");
        String pos = sc.nextLine();
        
        
        try (FileWriter fstream = new FileWriter("race.txt",true);
             BufferedWriter info = new BufferedWriter(fstream)) {
            info.write(name+" "+location+" "+Tname+" "+pos+",");
                info.newLine();
                System.out.println("Driver succesfully added\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void deleteDriver(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter driver Name:");
        String driverName = sc.nextLine();
        String fileName = "race.txt";
        File inputFile = new File("race.txt");
        File tempFile = new File("race2.txt");
        String line = null;
    try {
        FileReader fileReader =  new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        

        while((line = bufferedReader.readLine()) != null) {
            
            String[] split=line.split(" ");
            
            
            if(!split[0].equals(driverName)){
                try (FileWriter fstream = new FileWriter("race2.txt",true);
                    BufferedWriter info = new BufferedWriter(fstream)) {
                   info.write(line);
                info.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }   
        bufferedReader.close();    
        tempFile.renameTo(inputFile);
    }
    catch(FileNotFoundException ex) {
        System.out.println("Unable to open file '" + fileName + "'");                
    }
    catch(IOException ex) {
        System.out.println("Error reading file '" + fileName + "'");                  
    }   

        
    }
    
    public void ChangeDriver(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter team Name to change driver:");
        String teamName = sc.nextLine();
        System.out.println("Enter new driver name:");
        String fDriver = sc.nextLine();
        String fileName = "race.txt";
        File inputFile = new File("race.txt");
        File tempFile = new File("race2.txt");
        String line = null;
        try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while((line = bufferedReader.readLine()) != null) {

                String[] split=line.split(" ");


                if(split[2].equals(teamName)){

                    try (FileWriter fstream = new FileWriter("race2.txt",true);
                    BufferedWriter info = new BufferedWriter(fstream)) {
                   info.write(fDriver+" "+split[1]+" "+split[2]+" "+split[3]);
                    info.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else{

                    try (FileWriter fstream = new FileWriter("race2.txt",true);
                 BufferedWriter info = new BufferedWriter(fstream)) {
                info.write(line);
                    info.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }   
            bufferedReader.close();    
            tempFile.renameTo(inputFile);
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"+ fileName + "'");                  
        }     
    }
    
    public void displayStatistics(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter driver name:");
        String dName = sc.nextLine();
        String fileName = "race.txt";
        int point = 0;
        String line = null;
        try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while((line = bufferedReader.readLine()) != null) {
               
                String[] split=line.split(" ");
                
                

                if(split[0].equals(dName)){
                    
                    String[] pos = split[3].split(",");
                    System.out.println(dName+"'s current positions are "+split[3]);
                    int[] positions= new int[10];
                    for(int i=0;i<pos.length;i++){
                        
                        positions[i] =Integer.parseInt(pos[i]);
                        switch(positions[i]){
                            case 1:
                                point+=25;
                            case 2:
                                point+=18;
                            case 3:
                                point+=15;
                            case 4:
                                point+=12;
                            case 5:
                                point+=10;
                            case 6:
                                point+=8;
                            case 7:
                                point+=6;
                            case 8:
                                point+=4;
                            case 9:
                                point+=2;
                            case 10:
                                point+=1;
                            default:
                                point+=0;
                        }
                    }
                   System.out.println(dName+"'s current point = "+point);
                    

                }
                
            }   
            bufferedReader.close();    
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ fileName + "'");                  
        } 
    }
    
    public void displayAll(){
        
        String fileName = "race.txt";
        int point = 0;
        String line = null;
        ArrayList<Integer> positions = new ArrayList<Integer>();
        
        
        System.out.println("Driver\tLoacation\tTeam Name\tPositions\tPoints");
        System.out.println("-------------------------------------------------------------------");
        
        try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
               
                String[] split=line.split(" ");
                String pos = split[split.length-1];
                positions.add(Integer.parseInt(pos));
                

                }
            
            Collections.sort(positions,Collections.reverseOrder());
               //reverse the sort array to get desending order
            }

            catch(FileNotFoundException ex) {
                System.out.println("Unable to open file '" +fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println("Error reading file '"+ fileName + "'");                  
            }
        
         try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
           

            for(int i=0;i<positions.size();i++){
                //point bufferreader to begining of the file if it reachs end of the file
                if (line == null) { 
                
                    bufferedReader.close();
                    bufferedReader = new BufferedReader(new FileReader("race.txt"));
                }
                
                while((line = bufferedReader.readLine()) != null) {
                    
                    String[] split=line.split(" ");
                   
                    if(positions.get(i)==Integer.parseInt(split[split.length-1])){
                        System.out.println(split[0]+"\t"+split[1]+"\t\t"+split[2]+"\t\t"+split[3]+"\t"+split[split.length-1]);
                    }
                    

                }
                
            }
                
                
        }
                
            
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"+ fileName + "'");                  
        }
 }
    
public void calculatePoints(){
    
    String fileName = "race.txt";
        
        String line = null;
        File inputFile = new File("race.txt");
        File tempFile = new File("race2.txt");
        try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);


            while((line = bufferedReader.readLine()) != null) {
               
                    String[] split=line.split(" ");
                    int point = 0;
                    String[] pos = split[3].split(",");
                    
                    int[] positions= new int[10];

                    for(int i=0;i<pos.length;i++){
                        
                        positions[i] =Integer.parseInt(pos[i]);
                        switch(positions[i]){
                            case 1:
                                point=point+25;break;
                            case 2:
                                point=point+18;break;
                            case 3:
                                point=point+15;break;
                            case 4:
                                point=point+12;break;
                            case 5:
                                point=point+10;break;
                            case 6:
                                point=point+8;break;
                            case 7:
                                point=point+6;break;
                            case 8:
                                point=point+4;break;
                            case 9:
                                point=point+2;break;
                            case 10:
                                point=point+1;break;
                            default:
                                point=point+0;break;
                        }
                    }
                 
                    
                    try (FileWriter fstream = new FileWriter("race2.txt",true);
                        BufferedWriter info = new BufferedWriter(fstream)) {
                        info.write(line+" "+point);
                        info.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                
            }   
            bufferedReader.close();   
            tempFile.renameTo(inputFile);
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ fileName + "'");                  
        }
    
}    
    
    
    
}

