/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class StudentInformation1Controller implements Initializable {
   
    /**
     * Initializes the controller class.
     */
   
    @FXML
    private Label text;
    @FXML
    private Label text1;
    @FXML
    private Label text2;
    @FXML
    private Label text3;
    @FXML
    private Label text4;
    @FXML
    private Label text5;
    @FXML
    private Label text6;
    @FXML
    private Label text7;
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
    private Label l9;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         l1.setText(x.name);
         l2.setText(x.clas);
         l3.setText(x.id);
         l4.setText(x.gender);
         l5.setText(x.Date);
         l6.setText(x.group);
         l9.setText(x.email);
         l7.setText(x.number);
         l8.setText(x.pumber);
    }    
    public static Student x = null;
    @FXML
    private void result(ActionEvent event) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("StudentInfrormation2.fxml"));
        Scene s = new Scene(p);
        Stage s1 = new Stage();
        s1.setScene(s);
        s1.show();
        
    }
    
}
