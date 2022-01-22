package schoolmanagenent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asif
 */

public class AddStudent_1Controller implements Initializable {
 public static File students = new File("Student.txt");    
//static Readable students;
    @FXML
    private TextField n;
    @FXML
    private TextField n4;
    @FXML
    private TextField n5;
    @FXML
    private TextField n6;
    @FXML
    private TextField n7;
    @FXML
    private TextField n2;

    /**
     * Initializes the controller class.
     */
    
    public static ObservableList<Student> student = FXCollections.observableArrayList();
    public ObservableList<String> box = FXCollections.observableArrayList("Male","Female");
    public ObservableList<String> box2 = FXCollections.observableArrayList("Science","Commerce","Arts","None");
    @FXML
    private ChoiceBox<String> choicebox;
    @FXML
    private ChoiceBox<String> choicebox1;
    //public static File studentFile = new File("Student.txt");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choicebox.setItems(box);
        choicebox1.setItems(box2);
        
        choicebox1.setValue("None");
        choicebox.setValue("Male");
        if(!students.exists()) {
            try {
                students.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(AddStudent_1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    @FXML
    private void save(ActionEvent event) throws IOException {
        String name = n.getText();
        String gender = choicebox.getValue();
        System.out.println(gender);
        String date = n2.getText();
        String group = choicebox1.getValue();
        String clas = n4.getText();
        String id = n5.getText();
        String phone = n6.getText();
        String pphone = n7.getText();
        String[] firstname = name.split(" ");
        String email = firstname[0]+id+"-"+clas+"@diu.edu.bd";
        String password = firstname[0]+id+"-"+clas;
        int classidcheck = 0;
        try{
            int e = Integer.parseInt(id);
            int e1 = Integer.parseInt(clas);
            if(e1>5 && e1<9) {
               
                if(group.equals("None")) {
                    classidcheck = 1;
                }
                else {
                    classidcheck = 2;
                }
            }
            else if(e1>8 && e1<11){
                if(group.equals("None")) {
                   classidcheck = 2; 
                } else {
                    classidcheck = 1;
                }
                
            }
            else if(e1>=6 && e1<=10){
                classidcheck = 1;
                
            }
            else {
                classidcheck = 2;
            }
        }catch(Exception e) {
            classidcheck = 2;
        }
        
        boolean check = search(clas, id);
        String[] datecheck = date.split("-");
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
            System.out.println("Err!");
        }
        System.out.println(i);
        if(check == true) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Error!");
        tray.setMessage("This ID is already taken.");
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.millis(3000));
        }
        else if(name.equals("") || gender.equals("") || clas.equals("") || id.equals("") || phone.equals("") ||pphone.equals("")) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Error!");
        tray.setMessage("Please fill all the box.");
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
        else if(classidcheck == 2) {
            TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Error!");
        tray.setMessage("Please enter valid Class,ID or Group.");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(3000));
            
        }
        else {
        Student s = new Student(name, gender, date, group, clas, id,phone, pphone,email,password);
        FileWriter fw = new FileWriter(students,true);
        fw.write(name+"#"+gender+"#"+date+"#"+group+"#"+clas+"#"+id+"#"+phone+"#"+pphone+"#"+email+"#"+password
                +"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"
                +"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"#"+"0.0"+"\n"
        );
        fw.close();
         TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Success!");
        tray.setMessage("Saved.");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
        student.add(s);
        
        
        }
    }
    public static boolean search(String clas,String id) {
        boolean check = false;
        ListIterator<Student> list = student.listIterator();
        while(list.hasNext()) {
            Student ss = list.next();
            String  cl = ss.getClas();
            String i = ss.getId();
            if(cl.equals(clas) && i.equals(id)) {
                check = true;
            }
        }
        
        return check;
        
    }
}
    