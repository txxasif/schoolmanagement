package schoolmanagenent;

import java.io.IOException;
import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class AddResultController implements Initializable {
    @FXML
    private BorderPane pane;
    @FXML
    private BorderPane border2;
   @FXML
    private TableView<Student> StudentTable;
    @FXML
    private TableColumn<Student,String> name;
    @FXML
    private TableColumn<Student, String> id;
    @FXML
    private TableColumn<Student,String > clas;
    @FXML
    private TextField eclas;
    @FXML
    private TextField eid;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        border2.setVisible(false);
         StudentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
         AddMidFinalResultController.z = StudentTable.getSelectionModel().getSelectedItem();
        
    }    
    public static ObservableList<Student> olpo = FXCollections.observableArrayList();
    @FXML
    private void go(ActionEvent event) throws IOException {
        olpo.clear();
        AddMidFinalResultController.z = null;
        String check1 = eclas.getText();
        String check2= eid.getText();
        int ch = add(check1,check2);
        if(ch==0) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("No Student Found.");
        tray.setMessage("Please enter valid Class and ID.");
        tray.setNotificationType(NotificationType.NOTICE);
        tray.showAndDismiss(Duration.millis(3000));
        } else{
        border2.setVisible(true);
        name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
        clas.setCellValueFactory(new PropertyValueFactory<Student,String>("clas"));
        StudentTable.setItems(olpo); 
        }
    }

    @FXML
    private void mid(ActionEvent event) throws IOException {
        if(AddMidFinalResultController.z == null) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("No data found");
        tray.setMessage("Please selecr data from table");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(3000));
        } else {
        AddMidFinalResultController.x = 1;
        Parent p = FXMLLoader.load(getClass().getResource("AddMidFinalResult.fxml"));
        border2.setCenter(p);
        }
    }

    @FXML
    private void finall(ActionEvent event) throws IOException {
         if(AddMidFinalResultController.z == null) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("No data found");
        tray.setMessage("Please selecr data from table");
        tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(3000));
        } else {  
        AddMidFinalResultController.x = 2;   
        Parent p = FXMLLoader.load(getClass().getResource("AddMidFinalResult.fxml"));
        border2.setCenter(p);
         }
    }

   

    @FXML
    private void clicked(MouseEvent event) {
        AddMidFinalResultController.z = StudentTable.getSelectionModel().getSelectedItem();
    }
    public static int add(String clas,String id){
        int i = 0;
        ListIterator<Student> s = AddStudent_1Controller.student.listIterator();
        while(s.hasNext()) {
            Student ss = s.next();
            String clas1 = ss.getClas();
            String id1 = ss.getId();
            if(id1.equals(id) && clas1.equals(clas)) {
            olpo.add(ss);
            i++;
            }
            else if(clas1.equals(clas) && id.equals("") ){
                olpo.add(ss);
                i++;
            }
           
    }
        return i;


}
    
}
