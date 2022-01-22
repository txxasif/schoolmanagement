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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static schoolmanagenent.StudentInformation1Controller.x;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class StudentInfrormation2Controller implements Initializable {
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
    private Label l8;
    @FXML
    private Label l11;
    @FXML
    private Label l22;
    @FXML
    private Label l33;
    @FXML
    private Label l44;
    @FXML
    private Label l55;
    @FXML
    private Label l66;
    @FXML
    private Label l77;
    @FXML
    private Label l88;
    @FXML
    private Label l7;
    @FXML
    private Label x3;
    @FXML
    private Label x2;
    @FXML
    private Label x1;
    @FXML
    private Label x33;
    @FXML
    private Label x22;
    @FXML
    private Label x11;
    @FXML
    private Label bo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String e = bo.getText();
        String e1 = x.getName();
        bo.setText(e+" "+e1);
         l1.setText(x.r1);
         l2.setText(x.r2);
         l3.setText(x.r3);
         l4.setText(x.r4);
         l5.setText(x.r5);
         l6.setText(x.r6);
         l7.setText(x.r7);
         l8.setText(x.r8);
         l11.setText(x.r9);
         l22.setText(x.r10);
         l33.setText(x.r11);
         l44.setText(x.r12);
         l55.setText(x.r13);
         l66.setText(x.r14);
         l77.setText(x.r15);
         l88.setText(x.r16);
        if(x.group.equals("Science")) {
            x1.setText("PHYSICS");
            x2.setText("CHEMISTRY");
            x3.setText("BIOLOGY");
            x11.setText("PHYSICS");
            x22.setText("CHEMISTRY");
            x33.setText("BIOLOGY");
        }
        else if(x.group.equals("Commerce")) {
             x1.setText("MANAGMENT");
            x2.setText("ECONOMICS");
            x3.setText("FINANCE");
             x11.setText("MANAGMENT");
            x22.setText("ECONOMICS");
            x33.setText("FINANCE");
        }
        else if(x.group.equals("Arts")) {
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

    @FXML
    private void save(ActionEvent event) {
        ((Stage) (((Button)event.getSource()).getScene().getWindow())).close();
    }
    
}
