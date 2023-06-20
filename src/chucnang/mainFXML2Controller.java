package chucnang;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Character;
import javafx.collections.*;
import javafx.collections.transformation.*;

public class mainFXML2Controller extends mainFXMLController  implements Initializable {
	@FXML
    private AnchorPane ac_banhang;

    @FXML
    private AnchorPane ac_hoadon;

    @FXML
    private AnchorPane ac_kholutru;

    @FXML
    private AnchorPane ac_nhacungcap;

    @FXML
    private AnchorPane ac_nhanvien;

    @FXML
    private AnchorPane ac_tongquan;

    @FXML
    private Button banhang_btn;

    @FXML
    private GridPane banhang_gridpane;

    @FXML
    private TextField banhang_gt;

    @FXML
    private Button banhang_hdbtn;

    @FXML
    private ComboBox<?> banhang_pthuc;

    @FXML
    private ScrollPane banhang_scrolpane;

    @FXML
    private TextField banhang_sdtkh;

    @FXML
    private TableView<hoadondata> banhang_tblv;

    @FXML
    private TableColumn<hoadondata, String> banhang_tblv_gt;

    @FXML
    private TableColumn<hoadondata, String> banhang_tblv_msp;

    @FXML
    private TableColumn<hoadondata, String> banhang_tblv_sl;

    @FXML
    private TableColumn<hoadondata, String> banhang_tblv_tsp;

    @FXML
    private TextField banhang_tkh;

    @FXML
    private TextField banhang_tkt;

    @FXML
    private Label banhang_tong;

    @FXML
    private Button banhang_ttbtn;

    @FXML
    private Label banhang_ttl;

    @FXML
    private Button banhang_xbtn;

    @FXML
    private AreaChart<?, ?> bieudo;

    @FXML
    private TextField hanghoa_dv;

    @FXML
    private TextField hanghoa_gb;

    @FXML
    private ImageView hanghoa_imageview;

    @FXML
    private Button hanghoa_lm;

    @FXML
    private TextField hanghoa_msp;

    @FXML
    private TextField hanghoa_ncc;

    @FXML
    private TextField hanghoa_sl;

    @FXML
    private Button hanghoa_suabtn;

    @FXML
    private TableView<hanghoadata> hanghoa_tblv;

    @FXML
    private TableColumn<hanghoadata, String> hanghoa_tblv_dv;

    @FXML
    private TableColumn<hanghoadata, String> hanghoa_tblv_gb;

    @FXML
    private TableColumn<hanghoadata, String> hanghoa_tblv_msp;

    @FXML
    private TableColumn<hanghoadata, String> hanghoa_tblv_ncc;

    @FXML
    private TableColumn<hanghoadata, String> hanghoa_tblv_nn;

    @FXML
    private TableColumn<hanghoadata, String> hanghoa_tblv_sl;

    @FXML
    private TableColumn<hanghoadata, String> hanghoa_tblv_tsp;

    @FXML
    private Button hanghoa_thabtn;

    @FXML
    private Button hanghoa_thembtn;

    @FXML
    private TextField timkiem;

    @FXML
    private TextField hanghoa_tsp;

    @FXML
    private Button hanghoa_xoabtn;

    @FXML
    private TableView<hoadondata> hoadon;

    @FXML
    private Button hoadon_btn;

    @FXML
    private TableColumn<hoadondata, String> hoadon_gt;

    @FXML
    private TableColumn<hoadondata, String> hoadon_ktt;

    @FXML
    private TableColumn<hoadondata, String> hoadon_nv;

    @FXML
    private TableColumn<hoadondata, String> hoadon_nxhd;

    @FXML
    private TableColumn<hoadondata, String> hoadon_sl;

    @FXML
    private TableColumn<hoadondata, String> hoadon_tkh;

    @FXML
    private Label homnay;

    @FXML
    private Button kholuutru_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private TextField ncc_ma;

    @FXML
    private TextField ncc_sdt;

    @FXML
    private TextField ncc_ten;

    @FXML
    private Label nguoi;

    @FXML
    private Button nhacungcap_btn;

    @FXML
    private Button nhanvien_btn;

    @FXML
    private Label sanpham;

    @FXML
    private TableView<nhacungcapdata> tableview_ncc;

    @FXML
    private TableColumn<nhacungcapdata,String> tableview_ncc_mncc;

    @FXML
    private TableColumn<nhacungcapdata,String> tableview_ncc_sdt;

    @FXML
    private TableColumn<nhacungcapdata,String> tableview_ncc_tncc;

    @FXML
    private Label thunhap;

    @FXML
    private Button tongquan_btn;

    @FXML
    private TextField txttim;
    

    @FXML
    private TableView<nhanviendata> tableview_nv;

    @FXML
    private TableColumn<nhanviendata, String> tableview_nv_dc;

    @FXML
    private TableColumn<nhanviendata, String> tableview_nv_gt;

    @FXML
    private TableColumn<nhanviendata, String> tableview_nv_hvt;
    
    @FXML
    private TableColumn<nhanviendata, String> tableview_nv_pass;

    @FXML
    private TableColumn<nhanviendata, String> tableview_nv_sdt;
    
    @FXML
    private TableColumn<nhanviendata, String> tableview_nv_mnv;
    

    @FXML
    private TextField timkiem_nv;
    
    @FXML
    private TextField nhanvien_dc;

    @FXML
    private TextField nhanvien_gt;

    @FXML
    private TextField nhanvien_hvt;

    @FXML
    private TextField nhanvien_mnv;

    @FXML
    private TextField nhanvien_pass;

    @FXML
    private TextField nhanvien_sdt;
    @FXML
    private AnchorPane main_from;

    @FXML
    private TextField timkiemhd;
    
    private Connection connect;
	private PreparedStatement prepare;
	private Statement statement;
	private ResultSet result;

	private Alert alert;
	
	private Image image;
	
public void inventoryAddBtn1() {
	
        
        if (ncc_ma.getText().isEmpty()
                || ncc_ten.getText().isEmpty()
                || ncc_sdt.getText().isEmpty()) {
            
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Hãy điền đầy đủ thông tin");
            alert.showAndWait();
            
        } else {

            // CHECK PRODUCT ID
            String checkProdID = "SELECT ma_nha_cung_cap FROM tbl_nha_cung_cap WHERE ma_nha_cung_cap = '"
                    + ncc_ma.getText() + "'";
            
            connect = database.connectdb();
            
            try {
                
                statement = connect.createStatement();
                result = statement.executeQuery(checkProdID);
                
                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(ncc_ma.getText() + " hãy nhập mã nhà cung cấp khác ");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO tbl_nha_cung_cap "
                            + "(ma_nha_cung_cap, ten_nha_cung_cap, so_dien_thoai_ncc) "
                            + "VALUES(?,?,?)";
                    
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, ncc_ma.getText());
                    prepare.setString(2, ncc_ten.getText());
                    
                    prepare.setString(3, ncc_sdt.getText());
                    
                    
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    
                    inventoryShowData1();
                    inventoryClearBtn1();
                    timkiemncc();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
public void inventoryUpdateBtn1() {
        
        if (ncc_ma.getText().isEmpty()
                || ncc_ten.getText().isEmpty()
                || ncc_sdt.getText().isEmpty()) {
            
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Hãy điền đầy đủ thông tin");
            alert.showAndWait();
            
        } else {
            
            
            
            String updateData = "UPDATE tbl_nha_cung_cap SET "
                    + "ma_nha_cung_cap = '" + ncc_ma.getText() 
                    + "', ten_nha_cung_cap = N'"
                    + ncc_ten.getText() 
                    + "', so_dien_thoai_ncc = "
                    + ncc_sdt.getText()
                    
                    + " WHERE ma_nha_cung_cap = '" + getData.mancc+"'";
            connect = database.connectdb();
            
            try {
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("BẠn muốn sửa thông tin nhà cung cấp có mã : " + ncc_ma.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE YOUR TABLE VIEW
                    inventoryShowData1();
                    // TO CLEAR YOUR FIELDS
                    inventoryClearBtn1();
                    timkiemncc();
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
	public void inventoryDeleteBtn1() {
        if (getData.mancc == "") {
            
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Điền thông tin muoond xóa");
            alert.showAndWait();
            
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Bạn muốn xóa nhà cung cấp có mã: " + ncc_ma.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get().equals(ButtonType.OK)) {
                String deleteData = "DELETE FROM tbl_nha_cung_cap WHERE ma_nha_cung_cap = '" + getData.mancc+"'";
                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("successfully Deleted!");
                    alert.showAndWait();

                    // TO UPDATE YOUR TABLE VIEW
                    inventoryShowData1();
                    // TO CLEAR YOUR FIELDS
                    inventoryClearBtn1();
                    timkiemncc();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();
            }
        }
    }
public void inventoryClearBtn1() {
        
	ncc_ma.setText("");
	ncc_ten.setText("");
	ncc_sdt.setText("");
	getData.mancc="";
        
    }
public void inventorySelectData1() {
        
	nhacungcapdata prodData = tableview_ncc.getSelectionModel().getSelectedItem();
        int num = tableview_ncc.getSelectionModel().getSelectedIndex();
        
        if ((num - 1) < -1) {
            return;
        }
        
        ncc_ma.setText(prodData.getManhacungcap());
        ncc_ten.setText(prodData.getTennhacungcap());
        ncc_sdt.setText(String.valueOf(prodData.getSodienthoainhacungcap()));
        
        getData.mancc=prodData.getManhacungcap();
        
    }
public ObservableList<nhacungcapdata> inventoryDataList() {
        
        ObservableList<nhacungcapdata> listData = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM tbl_nha_cung_cap";
        
        connect = database.connectdb();
        
        try {
        	
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            nhacungcapdata prodData;
            
            while (result.next()) {
            	prodData = new nhacungcapdata(
            			result.getString("ma_nha_cung_cap"),
                        result.getString("ten_nha_cung_cap"),
                        result.getInt("so_dien_thoai_ncc"));
                
                listData.add(prodData);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
private ObservableList<nhacungcapdata> inventoryListData;

public void inventoryShowData1() {
    inventoryListData = inventoryDataList();
    
    tableview_ncc_mncc.setCellValueFactory(new PropertyValueFactory<>("manhacungcap"));
    tableview_ncc_tncc.setCellValueFactory(new PropertyValueFactory<>("tennhacungcap"));
    tableview_ncc_sdt.setCellValueFactory(new PropertyValueFactory<>("sodienthoainhacungcap"));
    
    
    tableview_ncc.setItems(inventoryListData);
    
}

public ObservableList<nhanviendata> inventoryDataList1() {
    
    ObservableList<nhanviendata> listData = FXCollections.observableArrayList();
    
    String sql = "SELECT * FROM tbl_nhan_vien";
    
    connect = database.connectdb();
    
    try {
    	
        
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
        
        nhanviendata prodData;
        
        while (result.next()) {
        	prodData = new nhanviendata(
        			result.getString("ma_nhan_vien"),
        			result.getString("ten_nhan_vien"),
        			result.getString("so_dien_thoai_nv"),
        			result.getString("gioi_tinh_nv"),
        			result.getString("dia_chi"),
        			result.getString("password")
        			);
            
            listData.add(prodData);
            
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listData;
}
private ObservableList<nhanviendata> inventoryListData1;

public void inventoryShowData2() {
    inventoryListData1 = inventoryDataList1();
    
    tableview_nv_mnv.setCellValueFactory(new PropertyValueFactory<>("manhanvien"));
    tableview_nv_hvt.setCellValueFactory(new PropertyValueFactory<>("hovaten"));
    tableview_nv_sdt.setCellValueFactory(new PropertyValueFactory<>("sodienthoai"));
    tableview_nv_gt.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));
    tableview_nv_dc.setCellValueFactory(new PropertyValueFactory<>("diachi"));
    tableview_nv_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
    
    
    tableview_nv.setItems(inventoryListData1);
    
}
public void inventoryClearBtn2() {

	nhanvien_mnv.setText("");
	nhanvien_gt.setText("");
	nhanvien_pass.setText("");
	nhanvien_dc.setText("");
	
	nhanvien_hvt.setText("");
	
	nhanvien_sdt.setText("");

}
public void hanghoaSelectData2() {

	nhanviendata prodData = tableview_nv.getSelectionModel().getSelectedItem();
	int num = tableview_nv.getSelectionModel().getSelectedIndex();

	if ((num - 1) < -1) {
		return;
	}

	nhanvien_mnv.setText(prodData.getManhanvien());
	nhanvien_gt.setText(prodData.getGioitinh());
	nhanvien_pass.setText(prodData.getPassword());
	
	nhanvien_dc.setText(prodData.getDiachi());
	nhanvien_hvt.setText(prodData.getHovaten());
	
	nhanvien_sdt.setText(prodData.getSodienthoai());

	
}
public void nhanvienthemBtn() {
	// kiểm tra xem các ô đã ghi hết chưa
	if (nhanvien_mnv.getText().isEmpty() || nhanvien_sdt.getText().isEmpty()
	
			|| nhanvien_pass.getText().isEmpty() || nhanvien_dc.getText().isEmpty()
			
			|| nhanvien_hvt.getText().isEmpty()
			
			|| nhanvien_gt.getText().isEmpty()) {

		alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Message");
		alert.setHeaderText(null);
		alert.setContentText("Please fill all blank fields");
		alert.showAndWait();

	} else {

		// CHECK mã hàng hóa
		String checknhanvien = "SELECT ma_nhan_vien FROM tbl_nhan_vien WHERE ma_nhan_vien = '" + nhanvien_mnv.getText()
				+ "'";

		connect = database.connectdb();

		try {

			statement = connect.createStatement();
			result = statement.executeQuery(checknhanvien);

			if (result.next()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);

				alert.setContentText(nhanvien_mnv.getText() + " Đã có ");
				alert.showAndWait();
			} else {
				String insertData = "INSERT INTO tbl_nhan_vien "
						+ "(ma_nhan_vien ,ten_nhan_vien,so_dien_thoai_nv,gioi_tinh_nv,dia_chi ,password) "
						+ "VALUES(?,?,?,?,?,?)";

				prepare = connect.prepareStatement(insertData);
				prepare.setString(1, nhanvien_mnv.getText());
				prepare.setString(2, nhanvien_hvt.getText());
				prepare.setString(3, nhanvien_sdt.getText());
				prepare.setString(4, nhanvien_gt.getText());
				
				prepare.setString(5, nhanvien_dc.getText());
				prepare.setString(6, nhanvien_pass.getText());

				

				prepare.executeUpdate();

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Successfully Added!");
				alert.showAndWait();

				inventoryShowData2();
				inventoryClearBtn2();
				timkiemnv();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public void membersDelete2() {
	String sql = "DELETE FROM tbl_nhan_vien WHERE ma_nhan_vien = ?";

	connect = database.connectdb();

	try {
		if (nhanvien_mnv.getText().isEmpty()) {
			inventoryClearBtn2();
		} else {
			alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Message");
			alert.setHeaderText(null);
			alert.setContentText("Bạn có muốn XÓA ?");
			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, nhanvien_mnv.getText());
				prepare.executeUpdate();

				alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Xóa thành công!");
				alert.showAndWait();

				inventoryShowData2();
				inventoryClearBtn2();
				timkiemnv();
			} else {
				alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Hủy xóa!!");
				alert.showAndWait();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void membersUpdate2() {
	String sql = "UPDATE tbl_nhan_vien SET ma_nhan_vien = ?,ten_nhan_vien=?,so_dien_thoai_nv =?,gioi_tinh_nv=?,dia_chi =?,password=? WHERE ma_nhan_vien=?";

	connect = database.connectdb();

	try {
		Alert alert;

		if (nhanvien_mnv.getText().isEmpty()) {
			inventoryClearBtn2();
		} else {
			alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Message");
			alert.setHeaderText(null);
			alert.setContentText("Bạn có muốn CẬP NHẬT ?");
			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				prepare = connect.prepareStatement(sql);
				

				prepare.setString(1, nhanvien_mnv.getText());

				prepare.setString(2, nhanvien_hvt.getText());
				prepare.setString(3, nhanvien_sdt.getText());

				prepare.setString(4, nhanvien_gt.getText());
				
				prepare.setString(5, nhanvien_dc.getText());
				prepare.setString(6, nhanvien_pass.getText());
				prepare.setString(7, nhanvien_mnv.getText());

				prepare.executeUpdate();

				alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Cập nhật thành công!");
				alert.showAndWait();

				inventoryShowData2();

				inventoryClearBtn2();
				timkiemnv();

			} else {
				alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Hủy Cập Nhật!!");
				alert.showAndWait();
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void timkiemnv() {
	try {
		inventoryListData1 = inventoryDataList1();
	    
	    tableview_nv_mnv.setCellValueFactory(new PropertyValueFactory<>("manhanvien"));
	    tableview_nv_hvt.setCellValueFactory(new PropertyValueFactory<>("hovaten"));
	    tableview_nv_sdt.setCellValueFactory(new PropertyValueFactory<>("sodienthoai"));
	    tableview_nv_gt.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));
	    tableview_nv_dc.setCellValueFactory(new PropertyValueFactory<>("diachi"));
	    tableview_nv_pass.setCellValueFactory(new PropertyValueFactory<>("password"));
	    
	    
	    tableview_nv.setItems(inventoryListData1);
	    
	    FilteredList<nhanviendata> filteredData =new FilteredList<>(inventoryListData1,b->true);
	    timkiem_nv.textProperty().addListener((observable,oldValue,newValue) ->{
	    	filteredData.setPredicate(nhanviendata->{
	    	if(newValue.isEmpty()||newValue.trim().isEmpty()||newValue==null)
	    	{
	    		return true;
	    	}
	    	String seachKeyword =newValue.toLowerCase();
	    	if(nhanviendata.getManhanvien().toLowerCase().indexOf(seachKeyword)>-1)
	    	{
	    		return true;
	    	}
	    	else if(nhanviendata.getHovaten().toLowerCase().indexOf(seachKeyword)>-1) {
	    		return true;
	    	}
	    	else if (nhanviendata.getSodienthoai().toLowerCase().indexOf(seachKeyword)>-1)
	    	{
	    		return true;
	    	}else
	    		return false;
	    	});
	    });
	    SortedList<nhanviendata> sorteddata= new SortedList<>(filteredData);
	    sorteddata.comparatorProperty().bind(tableview_nv.comparatorProperty());
	    tableview_nv.setItems(sorteddata);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
public void timkiemncc() {
	try {
		inventoryListData = inventoryDataList();
	    
	    tableview_ncc_mncc.setCellValueFactory(new PropertyValueFactory<>("manhacungcap"));
	    tableview_ncc_tncc.setCellValueFactory(new PropertyValueFactory<>("tennhacungcap"));
	    tableview_ncc_sdt.setCellValueFactory(new PropertyValueFactory<>("sodienthoainhacungcap"));
	    
	    
	    tableview_ncc.setItems(inventoryListData);
	    
	    FilteredList<nhacungcapdata> filteredData =new FilteredList<>(inventoryListData,b->true);
	    txttim.textProperty().addListener((observable,oldValue,newValue) ->{
	    	filteredData.setPredicate(nhacungcapdata->{
	    	if(newValue.isEmpty()||newValue.trim().isEmpty()||newValue==null)
	    	{
	    		return true;
	    	}
	    	String seachKeyword =newValue.toLowerCase();
	    	if(nhacungcapdata.getManhacungcap().toLowerCase().indexOf(seachKeyword)>-1)
	    	{
	    		return true;
	    	}
	    	else if(String.valueOf(nhacungcapdata.getSodienthoainhacungcap()).indexOf(seachKeyword)>-1) {
	    		return true;
	    	}
	    	else if (nhacungcapdata.getTennhacungcap().toLowerCase().indexOf(seachKeyword)>-1)
	    	{
	    		return true;
	    	}else
	    		return false;
	    	});
	    });
	    SortedList<nhacungcapdata> sorteddata= new SortedList<>(filteredData);
	    sorteddata.comparatorProperty().bind(tableview_ncc.comparatorProperty());
	    tableview_ncc.setItems(sorteddata);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

    public void logout() {
    	
		try {
//			alert = new Alert(AlertType.CONFIRMATION);
//			alert.setTitle("Error Message");
//			alert.setHeaderText(null);
//			alert.setContentText("Bạn có chắc chắn bạn muốn thoát?");
//			Optional<ButtonType> option = alert.showAndWait();
//			if (option.get().equals(ButtonType.OK)) {
//
//				// ĐỂ ẨN MẪU CHÍNH
//				logout_btn.getScene().getWindow().hide();
//
//				// LIÊN KẾT MẪU ĐĂNG NHẬP VÀ HIỂN THỊ
//				Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
//
//				Stage stage = new Stage();
//				Scene scene = new Scene(root);
//
//				stage.setScene(scene);
//				stage.show();}
			super.logout();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    @FXML
    void btnclose(ActionEvent event) {
    	System.exit(0);
    }
    
public void switchForm(ActionEvent event) {
        
        
        
        if (event.getSource() ==tongquan_btn) {
            
           
            	ac_tongquan.setVisible(true);
                ac_kholutru.setVisible(false);
                ac_nhanvien.setVisible(false);
                ac_hoadon.setVisible(false);
                ac_nhacungcap.setVisible(false);
                ac_banhang.setVisible(false);
                
                super.daban();
        		super.tongthunhap();
        		super.displaynguoi(); 
        		super.displaythunhaphomnay() ;
        		super.dashboardIncomeChart();
            
        } else if (event.getSource() == kholuutru_btn) {
            
        	ac_tongquan.setVisible(false);
            ac_kholutru.setVisible(true);
            ac_nhanvien.setVisible(false);
            ac_hoadon.setVisible(false);
            ac_nhacungcap.setVisible(false);
            ac_banhang.setVisible(false);
            super.hienthidatahanghoa();
            super.timkiemhh();
                
           
        }else if (event.getSource() == hoadon_btn) {
            
        	ac_tongquan.setVisible(false);
            ac_kholutru.setVisible(false);
            ac_nhanvien.setVisible(false);
            ac_hoadon.setVisible(true);
            ac_nhacungcap.setVisible(false);
            ac_banhang.setVisible(false);
            super.timkiemhd();
            super.hoadonData();
        }else if (event.getSource() == nhanvien_btn) {
            
        	ac_tongquan.setVisible(false);
            ac_kholutru.setVisible(false);
            ac_nhanvien.setVisible(true);
            ac_hoadon.setVisible(false);
            ac_nhacungcap.setVisible(false);
            ac_banhang.setVisible(false);
            timkiemnv();
            inventoryShowData2();
            }
        else if (event.getSource() == nhacungcap_btn) {
            
        	ac_tongquan.setVisible(false);
            ac_kholutru.setVisible(false);
            ac_nhanvien.setVisible(false);
            ac_hoadon.setVisible(false);
            ac_nhacungcap.setVisible(true);
            ac_banhang.setVisible(false);
            
            timkiemncc();
            inventoryShowData1();
            }else if (event.getSource() == banhang_btn) {
                
            	ac_tongquan.setVisible(false);
                ac_kholutru.setVisible(false);
                ac_nhanvien.setVisible(false);
                ac_hoadon.setVisible(false);
                ac_nhacungcap.setVisible(false);
                ac_banhang.setVisible(true);
                
                super.menuDisplayCard();
                super.menuGetOrder();
                super.menuDisplayTotal();
                super.menuShowOrderData();
                }
        
    }
public void membersDelete() {
	super.membersDelete();
}
public void membersUpdate() {
	super.membersUpdate();
}
public void hanghoaSelectData() {
	super.hanghoaSelectData();
}
public void hanghoathemBtn() {
	super.hanghoathemBtn();
}
public void inventoryClearBtn() {
	super.inventoryClearBtn();
}
public void inventoryImportBtn() {
	super.inventoryImportBtn();
}
public void menuRemoveBtn() {
	super.menuRemoveBtn();
}
public void menuPayBtn() {
	super.menuPayBtn();
}
public void menuReceiptBtn() {
	super.menuReceiptBtn();
}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		inventoryShowData2();
		inventoryShowData1();
		timkiemnv();
		timkiemncc();
		super.timkiemhh();
		super.inventoryTypeList();
		super.timkiemhd();
		super.hienthidatahanghoa();

		super.menuDisplayCard();
		super.menuGetOrder();
		super.menuShowOrderData();
		super.menuDisplayTotal();
        
		super.hoadonData();
        
		super.daban();
		super.tongthunhap();
		super.displaynguoi(); 
		super.displaythunhaphomnay() ;
        
		super.dashboardIncomeChart();
		
		
		
	}

}
