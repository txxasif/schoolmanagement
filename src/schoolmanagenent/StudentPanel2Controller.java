/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import static schoolmanagenent.StudentPanelController.stupan;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class StudentPanel2Controller implements Initializable {
    @FXML
    private Label l9;
    @FXML
    private Label l8;
    @FXML
    private Label l7;
    @FXML
    private Label l6;
    @FXML
    private Label l5;
    @FXML
    private Label l4;
    @FXML
    private Label l3;
    @FXML
    private Label l2;
    @FXML
    private Label l1;
    @FXML
    private Label text7;
    @FXML
    private Label text6;
    @FXML
    private Label text5;
    @FXML
    private Label text4;
    @FXML
    private Label text3;
    @FXML
    private Label text2;
    @FXML
    private Label text1;
    @FXML
    private Label text;
    @FXML
    private TextField old;
    @FXML
    private TextField neww;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        l1.setText(stupan.getName());
        l2.setText(stupan.clas);
        l3.setText(stupan.id);
        l4.setText(stupan.gender);
        l5.setText(stupan.Date);
        l6.setText(stupan.group);
        l7.setText(stupan.number);
        l8.setText(stupan.pumber);
        l9.setText(stupan.email);
    }    

    @FXML
    private void save(ActionEvent event) {
        String pass = old.getText();
        if(stupan.password.equals(pass)) {
            ListIterator<Student> cc = AddStudent_1Controller.student.listIterator();
            String newpas = neww.getText();
            stupan.setPassword(newpas);
        try{
            String clas12 = stupan.getClas();
            String id12  = stupan.getId();
        while(cc.hasNext()) {
           
        
            Student xx = cc.next();
            String id = xx.getId();
            String clas = xx.getClas();
            
            if(clas.equals(clas12) && id.equals(id12)){
                
                AddStudent_1Controller.student.remove(xx);
               
                break;
                
            }
        }
            
            AddStudent_1Controller.student.add(stupan);
           
            AddMidFinalResultController.addd();
            TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Done!");
        tray.setMessage("Your password successfully changed.");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
           
         
                      
        
        } catch(Exception e) {
            System.out.println("Erroos");
        }
        }
        else {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Wrong old password!");
        tray.setMessage("Please enter correct password.");
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.millis(3000));
        }
            
    }
    
}
