/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class TeacherDetailsController implements Initializable {
    @FXML
    private Label l;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            Teacher x = AllTeacherController.s1;
        l.setText(x.getName());
        l1.setText(x.getAge());
        l2.setText(x.getDate());
        l3.setText(x.getGroup());
        l4.setText(x.getNumber());
        l5.setText(x.getReligion());
        } catch(Exception e) {
           
        }
        
    }    
    
}
