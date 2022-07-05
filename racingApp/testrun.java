
package com.mycompany.racingApp;

import java.util.Scanner;


public class testrun{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Formula1ChampionshipManager fcm = new Formula1ChampionshipManager();
        int i =0;
        while(i!=-99){
        System.out.println("Enter your option");
        System.out.println("1.Create New Driver");
        System.out.println("2.Delete Driver and the team");
        System.out.println("3.Change the Driver of the team");
        System.out.println("4.Display statistics of Driver");
        System.out.println("5.Display All Drivers");
        System.out.println("6.Go to GUI");
        i = sc.nextInt();
        
        if(i==1){
            fcm.CreateNewDriver();
        }
        else if(i==2){
            fcm.deleteDriver();
        }
        else if(i==3){
            fcm.ChangeDriver();
        }
        else if(i==4){
            fcm.displayStatistics();
        }
        else if(i==5){
            fcm.calculatePoints();
            fcm.displayAll();
        }
        else if(i==6){
            gameGUI gui = new gameGUI();
            gui.setVisible(true);
        }else{
            System.out.println("Invalid option");
        }
        
        }
    }
}
