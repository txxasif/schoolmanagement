/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
public class AddMidFinalResultController implements Initializable {
    @FXML
    private Label title;

    /**
     * Initializes the controller class.
     */
    public static int  x;
    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextField t5;
    @FXML
    private TextField t6;
    @FXML
    private TextField t7;
    @FXML
    private TextField t8;
    public static Student z = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //System.out.println("MIISI");
        if(z!=null) {
            try {
        if(z.getGroup().equals("Science")) {
            l5.setText("PHYSICS");
            l6.setText("CHEMISTRY");
            l7.setText("BIOLOGY");
        }
        else if(z.getGroup().equals("Commerce")) {
            l5.setText("MANAGMENT");
            l6.setText("ECONOMICS");
            l7.setText("FINANCE");
        }
       else if(z.getGroup().equals("Arts")) {
            l5.setText("GEOGRAPHY AND ENVIRONMENT");
            l6.setText("CIVICS AND CITIZENSHIP");
            l7.setText("ISLAM AND MORAL EDUCATION");
        }
       else {
           l5.setText("Science");
           l6.setText("ICT");
           l7.setText("PHYSICAL EDUCATION");
       }
       
        
       
        } catch(Exception e) {
           
        }
           
          if(x==1) {
              t1.setText(z.r1);
              t2.setText(z.r2);
              t3.setText(z.r3);
              t4.setText(z.r4);
              t5.setText(z.r5);
              t6.setText(z.r6);
              t7.setText(z.r7);
              t8.setText(z.r8);
              
          }
          else if(x==2){
              t1.setText(z.r9);
              t2.setText(z.r10);
              t3.setText(z.r11);
              t4.setText(z.r12);
              t5.setText(z.r13);
              t6.setText(z.r14);
              t7.setText(z.r15);
              t8.setText(z.r16);
          }
       
        }
        else {
           
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("NULL!");
        tray.setMessage("");
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.millis(3000));
        
        }
        
    }    

    @FXML
    private void save(ActionEvent event) {
        int i = 0;
        String r1 = t1.getText();
        String r2 = t2.getText();
        String r3 = t3.getText();
        String r4 = t4.getText();
        String r5 = t5.getText();
        String r6 = t6.getText();
        String r7 = t7.getText();
        String r8 = t8.getText();
        try{
        double x1 = Double.parseDouble(r1);
        double x2 = Double.parseDouble(r2);
        double x3 = Double.parseDouble(r3);
        double x4 = Double.parseDouble(r4);
        double x5 = Double.parseDouble(r5);
        double x6 = Double.parseDouble(r6);
        double x7 = Double.parseDouble(r7);
        double x8 = Double.parseDouble(r8);
        if((x1>=0 && x1<=100) && (x2>=0 && x2<=100) && (x3>=0 && x3<=100) && (x4>=0 && x4<=100) && (x5>=0 && x5<=100) && (x6>=0 && x6<=100) && (x7>=0 && x7<=100) && (x8>=0 && x8<=100)) {
            i = 1;
        }
        
                } catch(Exception e) {
                    i = 2;
                }
        if(x==1 && i==1) {
           
            
            z.setMid(r1, r2, r3, r4, r5, r6, r7, r8);
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Done!");
        tray.setMessage("");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
        }
        else if(x==2&& i==1) {
            
           
        z.setFinal(r1, r2, r3, r4, r5, r6, r7, r8);
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.FADE;
        tray.setAnimationType(type);
        tray.setTitle("Done!");
        tray.setMessage("");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(3000));
        
        }
        else {
           TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("Invalid Number");
        tray.setMessage("Please enter valid number.");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(3000));
        }
        ListIterator<Student> cc = AddStudent_1Controller.student.listIterator();
        try{
            String clas12 = z.getClas();
            String id12  = z.getId();
        while(cc.hasNext()) {
            System.out.println("l3--");
        
            Student xx = cc.next();
            String id = xx.getId();
            String clas = xx.getClas();
           
            if(clas.equals(clas12) && id.equals(id12)){
                
                AddStudent_1Controller.student.remove(xx);
                
                break;
                
            }
        }
            
            AddStudent_1Controller.student.add(z);
           
           
         
                      
        
        } catch(Exception e) {
            System.out.println("Erroos");
        }
        
        
        try{
           
            addd();
        }catch(Exception e) {
           
        }
        
    }
    public static void addd() throws IOException {
    ListIterator<Student>  xn = AddStudent_1Controller.student.listIterator();
    FileWriter ff = new FileWriter(AddStudent_1Controller.students);
    while(xn.hasNext()) {
              System.out.println("Enee");
              Student o = xn.next();
              String a0 = o.name,a1 = o.gender,a2 = o.Date,a3 = o.group,a4 = o.clas,a5 = o.id,a6 = o.number,a7 = o.pumber,a8 = o.email,
              a9 = o.password,a10 = o.r1,a11 = o.r2,a12 = o.r3,a13 = o.r4,a14 = o.r5,a15 = o.r6,a16 = o.r7,a17 = o.r8,
              a18 = o.r9,a19 = o.r10,a20 = o.r11,a21 = o.r12,a22 = o.r13,a23 = o.r14,a24 = o.r15,a25 = o.r16;
              ff.write(a0+"#"+a1+"#"+a2+"#"+a3+"#"+a4+"#"+a5+"#"+a6+"#"+a7+"#"+a8
              +"#"+a9+"#"+a10+"#"+a11+"#"+a12+"#"+a13+"#"+a14+"#"+a15+"#"+a16
              +"#"+a17+"#"+a18+"#"+a19+"#"+a20+"#"+a21+"#"+a22+"#"+a23+"#"+a24+"#"+a25+"\n");
          }
         ff.close();
        
    }
    
}
 