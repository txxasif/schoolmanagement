/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class HomeeController implements Initializable {
    @FXML
    private BorderPane border;
    @FXML
    private Button allTeacher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       try{
           load();
       }catch(Exception e) {
           
       }
    }    

    @FXML
    private void addT(ActionEvent event) throws IOException {
        try{
            Parent p = FXMLLoader.load(getClass().getResource("AddTeacher.fxml"));
        border.setCenter(p);
        }catch(Exception e) {
            
        }
    }

    @FXML
    private void viewT(ActionEvent event) throws IOException {
         try{
             Parent p = FXMLLoader.load(getClass().getResource("AllTeacherr.fxml"));
         
        border.setCenter(p);
         }catch(Exception e) {
             
         }
    }

    @FXML
    private void addStu(ActionEvent event) throws IOException {
         try{ 
             Parent p = FXMLLoader.load(getClass().getResource("AddStudent_1.fxml"));
         
        border.setCenter(p);
         }catch(Exception e) {
             
         }
    }

    @FXML
    private void addResult(ActionEvent event) throws IOException {
        try {
            Parent p = FXMLLoader.load(getClass().getResource("AddResult.fxml"));
        
        border.setCenter(p);
        }catch(Exception e) {
            
        }
       
    }

    @FXML
    private void studentinfo(ActionEvent event) throws IOException {
       try{
           Parent p = FXMLLoader.load(getClass().getResource("StudentInfo.fxml"));
       
        border.setCenter(p);
       }catch(Exception e) {
           
       }
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        try{
            ((Stage) (((Button)event.getSource()).getScene().getWindow())).close();
        
        AnchorPane p = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Stage s = new Stage();
        Scene s1 = new Scene(p);
        s.setScene(s1);
        s.show();
        }catch(Exception e) {
            
        }
        
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
         try {
             Parent p = FXMLLoader.load(getClass().getResource("NoticeBoard.fxml"));
         
            border.setCenter(p);
         }catch(Exception e) {
             
         }
         
    }
    public void load() {
         try {
            // TODO
            Parent p = FXMLLoader.load(getClass().getResource("NoticeBoard.fxml"));
            border.setCenter(p);
        } catch (IOException ex) {
            Logger.getLogger(HomeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    
}
