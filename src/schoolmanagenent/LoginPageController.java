/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.io.IOException;
import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class LoginPageController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // username.setText("techy5");
        //password.setText("121172");
    }    
   // private Stage stage;
    @FXML
    private void log(ActionEvent event) throws IOException {
        
       String u = username.getText();
       String p = password.getText();
       Student xx = search(u, p);
       if(u.equals("techy5") && p.equals("121172")) {
           NoticeBoardController.e = 1;
           
           try{
           ((Stage) (((Button)event.getSource()).getScene().getWindow())).close();
           Stage stage = new Stage();
           Parent pp = FXMLLoader.load(getClass().getResource("Homee_1.fxml"));
           Scene s = new Scene(pp);
           
          // Stage ss = new Stage();
           
           stage.setScene(s);
           
           stage.show();
           }catch(Exception e) {
               
           }
       }
       else if(xx!=null) {
           ((Stage) (((Button)event.getSource()).getScene().getWindow())).close();
           NoticeBoardController.e = 2;
           
           //Sstem.out.println(xx.getName());
           
           try{ 
               StudentPanelController.stupan = xx;
           
           Stage s = new Stage();
           Parent e = FXMLLoader.load(getClass().getResource("StudentPanel.fxml"));
           Scene ss = new Scene(e);
           //System.out.println(xx.getName());
           s.setScene(ss);
           s.show();
           }catch(Exception e) {
               
           }
           
       } else {
           TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Wrong Password!");
        tray.setMessage("Please enter correct mail and password.");
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.millis(3000));
           
       }
       
       
       
    }
    public static  Student search(String u,String p) {
        Student x = null;
        ListIterator<Student> s = AddStudent_1Controller.student.listIterator();
        while(s.hasNext()) {
            
            Student s1 = s.next();
            String u1 = s1.getEmail();
            String p1 = s1.getPassword();
             
             if(u.equals(u1) && p.equals(p1)) {
                 x = s1;
             }
            }
        return x;
        }
        //return x;
    }

