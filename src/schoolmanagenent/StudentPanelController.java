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
import schoolmanagenent.Student;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class StudentPanelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public static Student stupan;
    @FXML
    private BorderPane border1;
    @FXML
    private AnchorPane anchorr;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Parent p = FXMLLoader.load(getClass().getResource("NoticeBoard.fxml"));
            border1.setCenter(p);
        } catch (IOException ex) {
            Logger.getLogger(StudentPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void result1(ActionEvent event) throws IOException {
        try{ 
        Parent p = FXMLLoader.load(getClass().getResource("StudentPanel1.fxml"));
        border1.setCenter(p);
        }catch(Exception e) {
            
            
        }
    }

    @FXML
    private void allteacher(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("AllTeacherr.fxml"));
        border1.setCenter(p);
        
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("StudentPanel2.fxml"));
        border1.setCenter(p);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        ((Stage) (((Button)event.getSource()).getScene().getWindow())).close();
        AnchorPane p = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Stage s = new Stage();
        Scene s1 = new Scene(p);
        s.setScene(s1);
        s.show();
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
         Parent p = FXMLLoader.load(getClass().getResource("NoticeBoard.fxml"));
         border1.setCenter(p);
    }

    
}
