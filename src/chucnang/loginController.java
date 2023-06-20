package chucnang;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;
import javafx.animation.TranslateTransition;

public class loginController implements Initializable  {

    @FXML
    private AnchorPane ac_anh;
    
    @FXML
    private AnchorPane ac_chutiem;

    @FXML
    private AnchorPane ac_nhanvien;

    @FXML
    private Button btn_chutiem;
    
    @FXML
    private Button btn_nhanvien;
    
    @FXML
    private Button btnclose;

    @FXML
    private Button loginBtn;

    @FXML
    private Button loginBtn1;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password1;

    @FXML
    private TextField username;

    @FXML
    private TextField username1;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private double x = 0;
    private double y = 0;
   
    @FXML
    void btnclose(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void btnlogin() {
    	String sql = "SELECT so_dien_thoai_nv,password,ten_nhan_vien,ma_nhan_vien FROM tbl_nhan_vien WHERE so_dien_thoai_nv = ? and password = ?";
        
        connect = database.connectdb();
        try {
        	prepare =connect.prepareStatement(sql);
        	prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            
            result = prepare.executeQuery();
            Alert alert;
            
            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(result.next()){
                    
                    getData.username=result.getString("ten_nhan_vien");
                    getData.ma=result.getString("ma_nhan_vien");
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();
                    
                    loginBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("mainFXML.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    root.setOnMousePressed((MouseEvent event) ->{
        	            x = event.getSceneX();
        	            y = event.getSceneY();
        	        });
        	        root.setOnMouseDragged((MouseEvent event) ->{
        	            stage.setX(event.getScreenX() - x);
        	            stage.setY(event.getScreenY() - y);
        	            
        	            stage.setOpacity(.8);
        	        });
        	        
        	        root.setOnMouseReleased((MouseEvent event) ->{
        	            stage.setOpacity(1);
        	        });
        	        
        	        
                    stage.setScene(scene);
                    stage.show();
                    
                }else{
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
    @FXML
    void btnlogin1() {
    	String sql = "SELECT * FROM user_chutiem WHERE username = ? and password = ?";
        
        connect = database.connectdb();
        try {
        	prepare =connect.prepareStatement(sql);
        	prepare.setString(1, username1.getText());
            prepare.setString(2, password1.getText());
            
            result = prepare.executeQuery();
            Alert alert;
            
            if(username1.getText().isEmpty() || password1.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(result.next()){
                    getData.username = username.getText();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();
                    
                    loginBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("mainFXML2.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    
                    root.setOnMousePressed((MouseEvent event) ->{
        	            x = event.getSceneX();
        	            y = event.getSceneY();
        	        });
        	        root.setOnMouseDragged((MouseEvent event) ->{
        	            stage.setX(event.getScreenX() - x);
        	            stage.setY(event.getScreenY() - y);
        	            
        	            stage.setOpacity(.8);
        	        });
        	        
        	        root.setOnMouseReleased((MouseEvent event) ->{
        	            stage.setOpacity(1);
        	        });
        	        
        	        
                    stage.setScene(scene);
                    stage.show();
                    
                }else{
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
 public void switchForm(ActionEvent event) {
        
        TranslateTransition slider = new TranslateTransition();
        
        if (event.getSource() == btn_chutiem) {
            slider.setNode(ac_anh);
            slider.setToX(300);
            slider.setDuration(Duration.seconds(.5));
            
            slider.setOnFinished((ActionEvent e) -> {
                btn_nhanvien.setVisible(true);
                btn_chutiem.setVisible(false);
                btnclose.setVisible(true);
                
            });
            
            slider.play();
        } else if (event.getSource() == btn_nhanvien) {
            slider.setNode(ac_anh);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));
            
            slider.setOnFinished((ActionEvent e) -> {
            	btn_nhanvien.setVisible(false);
                btn_chutiem.setVisible(true);
                btnclose.setVisible(false);
            });
            
            slider.play();
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	
    }

}
