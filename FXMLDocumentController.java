package com.example.demo2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lbl1,lbl2;
    
    @FXML
    private Button btn1,btn2,editbtn,edittbtn,delbtn,dellbtn,addbtn,adddbtn;
    
    @FXML
    private void onEdit (ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
       
        if(event.getSource()==editbtn){
            stage = (Stage) editbtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("view-edit.fxml"));
        }
        else{
            stage = (Stage) edittbtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    protected void onDel(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if(event.getSource()==delbtn){
            stage = (Stage) delbtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("view-remove.fxml"));
        }
        else{
            stage = (Stage) dellbtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onAdd(ActionEvent event)throws Exception {
        Stage stage;
        Parent root;

        if(event.getSource()==addbtn){
            stage = (Stage) addbtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("view-add.fxml"));
        }
        else{
            stage = (Stage) adddbtn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}