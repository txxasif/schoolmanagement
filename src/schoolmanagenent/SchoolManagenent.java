/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.text.html.HTMLDocument;



/**
 *
 * @author Asif
 */
public class SchoolManagenent extends Application{

    
    public static void main(String[] args)  {
        launch(args);
        
  }
  
    @Override
    public void start(Stage stage) throws Exception {
        
        Scanner sc = new Scanner(AddStudent_1Controller.students);
        while(sc.hasNext()) {
        Student s = null;
        String xx = sc.nextLine();
        String[] c = xx.split("#");
        s = new Student(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8], c[9]);
        s.setMid(c[10], c[11], c[12], c[13], c[14],c[15], c[16], c[17]);
        s.setFinal(c[18], c[19], c[20], c[21], c[22], c[23], c[24], c[25]);
        AddStudent_1Controller.student.add(s);
        }
        sc.close();
        try{
         
         AnchorPane p = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene s = new Scene(p);
        stage.setScene(s);
        //stage.setFullScreen(true);
        stage.show();
        }catch(Exception e) {
            
        }
        
                
   }
    
}
