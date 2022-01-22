package schoolmanagenent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import jdk.jfr.events.FileWriteEvent;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asif
 */

public class AddTeacherController implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private TextField phone;
    @FXML
    private TextField age;
    @FXML
    private TextField date;
    @FXML
    private TextField religion;
    
    public ObservableList<String> box2 = FXCollections.observableArrayList("Science","Commerce","Arts","None");
    /**
     * Initializes the controller class.
     */
    public static File teach = new File("teacher.txt");
    @FXML
    private ChoiceBox<String> choice;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       choice.setItems(box2);
       choice.setValue("None");
        if(!teach.exists()) {
            try {
                teach.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(AddTeacherController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    public static ObservableList<Teacher> teacher = FXCollections.observableArrayList();
    @FXML
    private void save(ActionEvent event) throws InterruptedException {
        String n = name.getText();
        String n1 = age.getText();
        String n2 = date.getText();
        String n3 = choice.getValue();
        String n4 = phone.getText();
        String n5 = religion.getText();
        String[] datecheck = n2.split("-");
        int i = 0;
        for(String xx: datecheck) {
            i++;
        }
           
        try {
        int date1 = Integer.parseInt(datecheck[0]);
        int date2 = Integer.parseInt(datecheck[1]);
        int date3 = Integer.parseInt(datecheck[2]);
        if((date1<32 && date1>1) && (date2>0 && date2<13) && date3>1900) {
            i=3;
        }
        else {
            i = 0;
        }
        } catch(Exception e){
            
        }
        
       if(n.equals("") || n1.equals("") || n2.equals("") || n3.equals("") || n4.equals("") || n5.equals("")) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Not Saved!");
        tray.setMessage("Please fill all the blanks!");
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.millis(3000));
       } 
       else if(i<3) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Error!");
        tray.setMessage("Please Enter a valid Date of Birth.");
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.millis(3000));
        }
       else {
         
            
            try {
                FileWriter fw = new FileWriter(teach,true);
                fw.write(n+"#"+n1+"#"+n2+"#"+n3+"#"+n4+"#"+n5+"\n");
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(AddTeacherController.class.getName()).log(Level.SEVERE, null, ex);
            }
           Teacher t = new Teacher(n, n1, n2, n3, n4, n5);
           teacher.add(t);
           TrayNotification tray = new TrayNotification();
           AnimationType type = AnimationType.POPUP;
           tray.setAnimationType(type);
           tray.setTitle("Save!");
           tray.setMessage("Done!");
           tray.setNotificationType(NotificationType.SUCCESS);
           tray.showAndDismiss(Duration.millis(3000));
       }
        
    }
    
}
