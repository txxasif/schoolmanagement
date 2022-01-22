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
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import static schoolmanagenent.AddResultController.add;
import static schoolmanagenent.AddResultController.olpo;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class StudentInfoController implements Initializable {
    @FXML
    private TextField clas;
    @FXML
    private BorderPane b;
    @FXML
    private TableView<Student> StudentTable;
    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> clas1;
    @FXML
    private TableColumn<Student, String> id1;
    @FXML
    private TextField id;
    @FXML
    private BorderPane b1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         StudentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // TODO
       
    }    
    public static ObservableList<Student> olpo1 = FXCollections.observableArrayList();
    @FXML
    private void go(ActionEvent event) {
        olpo1.clear();
        String check1 = clas.getText();
        String check2= id.getText();
        //add1(check1, check2);
        int ch = add1(check1,check2);
        //border2.setVisible(true);
        name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        id1.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
        clas1.setCellValueFactory(new PropertyValueFactory<Student,String>("clas"));
        StudentTable.setItems(olpo1);      
    }

    @FXML
    private void click(MouseEvent event) throws IOException {
        StudentInformation1Controller.x = StudentTable.getSelectionModel().getSelectedItem();
        if(StudentInformation1Controller.x == null) {
            TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("No data found!");
        tray.setMessage("Please Choose a data from table.");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(3000));
        } else{
        Parent p = FXMLLoader.load(getClass().getResource("StudentInformation1.fxml"));
        b1.setCenter(p);
        }
    }
     public static int add1(String clas,String id){
        int i = 0;
        ListIterator<Student> s = AddStudent_1Controller.student.listIterator();
        while(s.hasNext()) {
            Student ss = s.next();
            String clas1 = ss.getClas();
            String id1 = ss.getId();
            if(id1.equals(id) && clas1.equals(clas)) {
            olpo1.add(ss);
            i++;
            }
            else if(clas1.equals(clas) && id.equals("") ){
                olpo1.add(ss);
                i++;
            }
           
    }
        return i;


}
    
    
}
