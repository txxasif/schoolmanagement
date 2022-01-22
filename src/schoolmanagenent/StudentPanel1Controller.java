/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import static schoolmanagenent.StudentPanelController.stupan;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class StudentPanel1Controller implements Initializable {
    @FXML
    private Label l7;
    @FXML
    private Label l88;
    @FXML
    private Label l77;
    @FXML
    private Label l66;
    @FXML
    private Label l55;
    @FXML
    private Label l44;
    @FXML
    private Label l33;
    @FXML
    private Label l22;
    @FXML
    private Label l11;
    @FXML
    private Label l8;
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
    private Label x11;
    @FXML
    private Label x22;
    @FXML
    private Label x33;
    @FXML
    private Label x1;
    @FXML
    private Label x2;
    @FXML
    private Label x3;
    @FXML
    private Label namee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String e = namee.getText();
        namee.setText(e+" "+stupan.getName());
        l1.setText(stupan.r1);
         l2.setText(stupan.r2);
         l3.setText(stupan.r3);
         l4.setText(stupan.r4);
         l5.setText(stupan.r5);
         l6.setText(stupan.r6);
         l7.setText(stupan.r7);
         l8.setText(stupan.r8);
         l11.setText(stupan.r9);
         l22.setText(stupan.r10);
         l33.setText(stupan.r11);
         l44.setText(stupan.r12);
         l55.setText(stupan.r13);
         l66.setText(stupan.r14);
         l77.setText(stupan.r15);
         l88.setText(stupan.r16);
        if(stupan.group.equals("Science")) {
            x1.setText("PHYSICS");
            x2.setText("CHEMISTRY");
            x3.setText("BIOLOGY");
            x11.setText("PHYSICS");
            x22.setText("CHEMISTRY");
            x33.setText("BIOLOGY");
        }
        else if(stupan.group.equals("Commerce")) {
             x1.setText("MANAGMENT");
            x2.setText("ECONOMICS");
            x3.setText("FINANCE");
             x11.setText("MANAGMENT");
            x22.setText("ECONOMICS");
            x33.setText("FINANCE");
        }
        else if(stupan.group.equals("Arts")) {
            x1.setText("GEOGRAPHY AND ENVIRONMENT");
            x2.setText("CIVICS AND CITIZENSHIP");
            x3.setText("ISLAM AND MORAL EDUCATION");
            x11.setText("GEOGRAPHY AND ENVIRONMENT");
            x22.setText("CIVICS AND CITIZENSHIP");
            x33.setText("ISLAM AND MORAL EDUCATION");
        }
        else{
            x1.setText("Science");
            x2.setText("ICT");
            x3.setText("PHYSICAL EDUCATION");
            x11.setText("Science");
            x22.setText("ICT");
            x33.setText("PHYSICAL EDUCATION");
        }
        
    }    

    
}
