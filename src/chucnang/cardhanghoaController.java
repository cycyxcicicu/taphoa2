package chucnang;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class cardhanghoaController implements Initializable{

	@FXML
    private AnchorPane card_from;

    @FXML
    private Button hanghoa_add;

    @FXML
    private ImageView hanghoa_anh;

    @FXML
    private Label hanghoa_name;

    @FXML
    private Label hanghoa_tien;

    @FXML
    private Spinner<Integer> hanghoa_spinner;
    
    private hanghoadata hhdata;
    private Image image;
    
    private String masanpham1;
    private String donvi1 ;
    private String ngaynhap1;
    private String hh_image;
    private String tensanpham1;
   
    
    private SpinnerValueFactory<Integer> spin;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private Alert alert;
    
    
    
    private double totalP;
    private BigDecimal pr;
    
    private int qty;
    public void setQuantity() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        hanghoa_spinner.setValueFactory(spin);
    }

    public void setData(hanghoadata hhdata) {
    	
    	this.hhdata=hhdata;
    	tensanpham1=hhdata.getTenhanghoa();
    	hh_image= hhdata.getImage();
        ngaynhap1 = String.valueOf(hhdata.getNgaynhap());
        donvi1 = hhdata.getDonvi();
        masanpham1 = hhdata.getMahanghoa();
        hanghoa_name.setText(hhdata.getTenhanghoa());
        hanghoa_tien.setText( String.valueOf(hhdata.getGiaban())+ "đ");
        String path = "File:" + hhdata.getImage();
        image = new Image(path, 165, 100, false, true);
        hanghoa_anh.setImage(image);
        pr = hhdata.getGiaban();
    	
    	
    }
   
    
    public void addBtn() {

    	mainFXMLController mForm = new mainFXMLController();
        mForm.customerID();

        qty = hanghoa_spinner.getValue();
        
      //  String checkAvailable = "SELECT status FROM product WHERE prod_id = '"
       //         + prodID + "'";

        connect = database.connectdb();

        try {
            int checkStck = 0;
            String checkStock = "SELECT so_luong_trong_kho FROM tbl_hang_hoa WHERE ma_hang_hoa = '"
                    + masanpham1 + "'";

            prepare = connect.prepareStatement(checkStock);
            result = prepare.executeQuery();

            if (result.next()) {
                checkStck = result.getInt("so_luong_trong_kho");
            }
            
            if(checkStck == 0){
                
                String updateStock = "UPDATE tbl_hang_hoa SET ten_hang_hoa = N'"
                            + hanghoa_name.getText() + "', so_luong_trong_kho = 0 , gia_ban = " + pr
                            + ", image = '"
                            + hh_image + "', ngay_nhap = '"
                            + ngaynhap1 + "' WHERE ma_hang_hoa = '"
                            + masanpham1 + "'";
                prepare = connect.prepareStatement(updateStock);
                prepare.executeUpdate();
                
            }

            

            if ( qty == 0) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("nhập số lượng sản phẩm :3");
                alert.showAndWait();
            } else {

                if (checkStck < qty) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("số lượng mua nhiều hơn số lượng trong kho ");
                    alert.showAndWait();
                } else {
                	
                	 
                	
                    String insertData = "INSERT INTO tbl_hoa_don "
                            + "(ma_hoa_don,ma_khach_hang, gia_tien, so_luong_ban, ngay_xuat_hoa_don, ma_nhan_vien,ma_hang_hoa,phuong_thuc) "
                            + "VALUES(?,?,?,?,?,?,?,?)";
                    
                    prepare = connect.prepareStatement(insertData);
                    prepare.setInt(1, getData.mahoadon);
                    prepare.setInt(2, getData.cID);
                    totalP = pr.multiply(BigDecimal.valueOf(qty)).doubleValue();//nhân thành tiền
                    prepare.setString(3,String.valueOf(totalP) );
                    prepare.setString(4, String.valueOf(qty));
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));
                    prepare.setString(6,getData.ma );
                    prepare.setString(7,masanpham1);
                    
                    prepare.setString(8,getData.phuongthuc);
                    System.out.println(getData.phuongthuc);
                    prepare.executeUpdate();
                    
                    int upStock = checkStck - qty;

                    

                    

                    String updateStock = "UPDATE tbl_hang_hoa SET ten_hang_hoa = N'"
                            + hanghoa_name.getText() + "', so_luong_trong_kho =  "+upStock+", gia_ban = " + pr
                            + ", image = '"
                            + hh_image + "', ngay_nhap = '"
                            + ngaynhap1 + "' WHERE ma_hang_hoa = '"
                            + masanpham1 + "'";

                    prepare = connect.prepareStatement(updateStock);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    
                   mForm.menuGetTotal();
                  


                  
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setQuantity(); 
	}

}
