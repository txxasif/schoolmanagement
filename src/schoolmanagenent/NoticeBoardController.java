/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * 
 */
package schoolmanagenent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asif
 */
public class NoticeBoardController implements Initializable {
    @FXML
    private AnchorPane anchor;
    @FXML
    private Label notice;
    @FXML
    private Label midnotice;
    @FXML
    private Label finalnotice;
    public static int e = 0;
    @FXML
    private Button editt;
    public File noticefile;
    @FXML
    private TextField field1;
    /**
     * Initializes the controller class.
     */
    String tex;
    @FXML
    private Button savee;
    @FXML
    private Label welcome;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            noticefile = new File("notice.txt");
            if(!noticefile.exists()) {
                noticefile.createNewFile();
            }
            Scanner s = new Scanner(noticefile);
            
            while(s.hasNext()) {
                tex = s.nextLine();
                
            }
            s.close();
            notice.setText(tex);
        }catch(Exception e) {
            
        }
        
        if(e==1) {
            field1.setVisible(false);
            midnotice.setVisible(false);
            finalnotice.setVisible(false);
            savee.setVisible(false);
        }
        else if(e==2) {
            String name = StudentPanelController.stupan.getName();
            String n = welcome.getText();
            welcome.setText(n+" "+name);
            field1.setVisible(false);
            editt.setVisible(false);
            savee.setVisible(false);
            
            int i = check();
            if(i == 1) {
                midnotice.setText("The result of Mid-Term hasn't been released yet.");
            }
            int i1 = check2();
            if(i1 == 2) {
                finalnotice.setText("The result of Final hasn't been released yet.");
                
            }
        }
        
    }
    public int check() {
        int i = 0;
        Student x = StudentPanelController.stupan;
        if(x.r1.equals("0.0") || x.r2.equals("0.0") || x.r3.equals("0.0") || x.r4.equals("0.0") || x.r5.equals("0.0") || x.r6.equals("0.0") || x.r7.equals("0.0") || x.r8.equals("0.0")) {
            i = 1;
        }
        return i;
        
    }
    public int check2() {
        int i = 0;
        Student x = StudentPanelController.stupan;
        
         if(x.r9.equals("0.0") || x.r10.equals("0.0") || x.r11.equals("0.0") || x.r12.equals("0.0") || x.r13.equals("0.0") || x.r14.equals("0.0") || x.r15.equals("0.0") || x.r16.equals("0.0")) {
            i = 2;
        }
         return i;
    }

    @FXML
    private void edit(ActionEvent event) throws IOException {
        savee.setVisible(true);
        field1.setVisible(true);
        field1.setText(tex);
        
    }

    @FXML
    private void save(ActionEvent event) throws IOException {
        tex = field1.getText();
        FileWriter fw = new FileWriter(noticefile);
        fw.write(tex);
        fw.close();
        try{
            notice.setText(tex);
            field1.setVisible(false);
            savee.setVisible(false);
        }catch(Exception e) {
            
        }
        
        //savee.setVisible(false);
    }
    
}
