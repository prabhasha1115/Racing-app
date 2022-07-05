
package com.mycompany.racingApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class gameGUI extends javax.swing.JFrame {

    public gameGUI() {
        initComponents();
        filldata();
    }


   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Desscending order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ascending order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filldata(){
        String inputfile = "race.txt";
        File file = new File(inputfile);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputfile));
            String[] columnNames = {"Driver Name","Location","Team Name","positions","total point"};
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setColumnIdentifiers(columnNames);
            model.setRowCount(0);
            Object[] tableLines = br.lines().toArray();
            
            for(int i=0;i<tableLines.length;i++){
                
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(" ");
                model.addRow(dataRow);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(gameGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        String fileName = "race.txt";
        int point = 0;
        String line = null;
        String[] columnNames = {"Driver Name","Location","Team Name","positions","total point"};
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setColumnIdentifiers(columnNames);
        model.setRowCount(0);
        ArrayList<Integer> positions = new ArrayList<Integer>();
        
        
//        System.out.println("Driver\tLoacation\tTeam Name\tPositions\tPoints");
//        System.out.println("-------------------------------------------------------------------");
        
        try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
               
                String[] split=line.split(" ");
                String pos = split[split.length-1];
                positions.add(Integer.parseInt(pos));
                

                }
            
            Collections.sort(positions,Collections.reverseOrder());
                       
                
            }
                
            
            catch(FileNotFoundException ex) {
                System.out.println(
                    "Unable to open file '" +fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file '"+ fileName + "'");                  
            }
        
         try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
           

            for(int i=0;i<positions.size();i++){
                
                if (line == null) { 
                //end of file reached or the variable was just set up as null
                    bufferedReader.close();
                    bufferedReader = new BufferedReader(new FileReader("race.txt"));
                }
                
                while((line = bufferedReader.readLine()) != null) {
                    
                    String[] split=line.split(" ");
                   // System.out.println(line);
                    if(positions.get(i)==Integer.parseInt(split[split.length-1])){
//                        System.out.println(split[0]+"\t"+split[1]+"\t"+split[2]+"\t\t"+split[3]+"\t"+split[split.length-1]);
                          model.addRow(split);
                            
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        String fileName = "race.txt";
        int point = 0;
        String line = null;
        String[] columnNames = {"Driver Name","Location","Team Name","positions","total point"};
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setColumnIdentifiers(columnNames);
        model.setRowCount(0);
        ArrayList<Integer> positions = new ArrayList<Integer>();
        
        
//        System.out.println("Driver\tLoacation\tTeam Name\tPositions\tPoints");
//        System.out.println("-------------------------------------------------------------------");
        
        try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
               
                String[] split=line.split(" ");
                String pos = split[split.length-1];
                positions.add(Integer.parseInt(pos));
                

                }
            
            Collections.sort(positions);
                       
                
            }
                
            
            catch(FileNotFoundException ex) {
                System.out.println(
                    "Unable to open file '" +fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println(
                    "Error reading file '"+ fileName + "'");                  
            }
        
         try {
            FileReader fileReader =  new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
           

            for(int i=0;i<positions.size();i++){
                
                if (line == null) { 
                //end of file reached or the variable was just set up as null
                    bufferedReader.close();
                    bufferedReader = new BufferedReader(new FileReader("race.txt"));
                }
                
                while((line = bufferedReader.readLine()) != null) {
                    
                    String[] split=line.split(" ");
                   // System.out.println(line);
                    if(positions.get(i)==Integer.parseInt(split[split.length-1])){
//                        System.out.println(split[0]+"\t"+split[1]+"\t"+split[2]+"\t\t"+split[3]+"\t"+split[split.length-1]);
                          model.addRow(split);
                            
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String dname = jTextField1.getText();
        String fileName = "race.txt";
        File inputFile = new File("race.txt");
        String[] columnNames = {"Driver Name","Location","Team Name","positions","total point"};
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setColumnIdentifiers(columnNames);
        model.setRowCount(0);
        
        String line = null;
    try {
        FileReader fileReader =  new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        

        while((line = bufferedReader.readLine()) != null) {
            
            String[] split=line.split(" ");
            
            
            if(split[0].equals(dname)){
                model.addRow(split);
               
            }
        }   
        bufferedReader.close();    
        
    }
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName + "'");                
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");                  
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gameGUI().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
