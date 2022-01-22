/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class AllTeacherController implements Initializable {
    @FXML
    private TableView<Teacher> teachertable;
    @FXML
    private TableColumn<Teacher, String> name;
    @FXML
    private TableColumn<Teacher, String> group;
    @FXML
    private TableColumn<Teacher, String> phone;
    @FXML
    private BorderPane bpane;
    

    /**
     * Initializes the controller class.
     */
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        AddTeacherController.teacher.clear();
        try {
            Scanner scanner = new Scanner(AddTeacherController.teach);
            while(scanner.hasNext()) {
                String s = scanner.nextLine();
                String[] x = s.split("#");
                
                Teacher t = new Teacher(x[0],x[1], x[2], x[3], x[4], x[5]);
                AddTeacherController.teacher.add(t);
            }
            scanner.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AllTeacherController.class.getName()).log(Level.SEVERE, null, ex);
        }
        teachertable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        name.setCellValueFactory(new PropertyValueFactory<Teacher,String>("name"));
        group.setCellValueFactory(new PropertyValueFactory<Teacher,String>("group"));
        phone.setCellValueFactory(new PropertyValueFactory<Teacher,String>("number"));
        teachertable.setItems(AddTeacherController.teacher);
    }    
    public static Teacher s1;
    @FXML
    private void mouseC(MouseEvent event) throws IOException {
        
        
        s1 = teachertable.getSelectionModel().getSelectedItem();
        //System.out.println(s.getName());
        Parent p = FXMLLoader.load(getClass().getResource("TeacherDetails.fxml"));
        bpane.setCenter(p);
        
    }
    
}
