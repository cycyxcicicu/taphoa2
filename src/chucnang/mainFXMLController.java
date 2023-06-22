package chucnang;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import javafx.collections.*;
import javafx.collections.transformation.*;
public class mainFXMLController implements Initializable {

	@FXML
	private Button banhang_btn;

	@FXML
	private ComboBox<?> banhang_pthuc;

	@FXML
	private ImageView hanghoa_imageview;

	@FXML
	private Button hanghoa_suabtn;

	@FXML
	private TableView<hanghoadata> hanghoa_tblv;

//    @FXML
//    private TableView<hanghoadata> hanghoa_tblv1;

	@FXML
	private TableColumn<hanghoadata, String> hanghoa_tblv_dv;

	@FXML
	private TableColumn<hanghoadata, String> hanghoa_tblv_gb;

//	@FXML
//	private TableColumn<hanghoadata, String> hanghoa_tblv_gn;

	@FXML
	private TableColumn<hanghoadata, String> hanghoa_tblv_msp;

//	@FXML
//	private TableColumn<hanghoadata, String> hanghoa_tblv_nhh;

	@FXML
	private TableColumn<hanghoadata, String> hanghoa_tblv_nn;

//	@FXML
//	private TableColumn<hanghoadata, String> hanghoa_tblv_nsx;

	@FXML
	private TableColumn<hanghoadata, String> hanghoa_tblv_sl;

//	@FXML
//	private TableColumn<hanghoadata, String> hanghoa_tblv_sln;

	@FXML
	private TableColumn<hanghoadata, String> hanghoa_tblv_tsp;

	@FXML
	private TableColumn<hanghoadata, String> hanghoa_tblv_ncc;

	@FXML
	private GridPane banhang_gridpane;

	@FXML
	private Button banhang_hdbtn;

	@FXML
	private ScrollPane banhang_scrolpane;

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
	private TextField hanghoa_sl;

//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_dv1;
//    
//
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_gb1;
//    
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_gn1;
//    
//
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_msp1;
//    
//
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_nhh1;
//    
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_nn1;
//    
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_nsx1;
//    
//
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_sl1;
//    
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_sln1;
//    
//
//    @FXML
//    private TableColumn<?, ?> hanghoa_tblv_tsp1;

	@FXML
	private Button hanghoa_thabtn;

	@FXML
	private Button hanghoa_thembtn;

	@FXML
    private TextField timkiem;

	@FXML
	private Button hanghoa_xoabtn;

	@FXML
	private Button hoadon_btn;

	@FXML
	private Button kholuutru_btn;

	@FXML
	private Button logout_btn;

	@FXML
	private AnchorPane main_from;

	@FXML
	private TextField hanghoa_msp;

//	@FXML
//	private DatePicker hanghoa_nhh;
//
//	@FXML
//	private DatePicker hanghoa_nsx;
//
//	@FXML
//	private TextField hanghoa_sln;

	@FXML
	private Button hanghoa_lm;

	@FXML
	private TextField hanghoa_dv;

	@FXML
	private TextField hanghoa_ncc;

	@FXML
	private TextField hanghoa_gb;

//	@FXML
//	private TextField hanghoa_gn;

	@FXML
	private TextField hanghoa_tsp;

	@FXML
	private Button tongquan_btn;

	@FXML
	private AnchorPane ac_banhang;

	@FXML
	private AnchorPane ac_hanghoa;

	@FXML
	private AnchorPane ac_hoadon;

	@FXML
	private AnchorPane ac_tongquan;

	@FXML
	private Label ten_labl;

    @FXML
    private TextField banhang_tkh;
    
    @FXML
    private TextField banhang_sdtkh;
    
    
    

    @FXML
    private TableView<hoadondata> hoadon;

    

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
    private Label nguoi;
    
    @FXML
    private Label sanpham;
    
    @FXML
    private Label thunhap;
    
    @FXML
    private ComboBox<?> banhang_gt1;

    @FXML
    private AreaChart<?, ?> bieudo;
    

    @FXML
    private TextField timkiemhd;

	private Connection connect;
	private PreparedStatement prepare;
	private Statement statement;
	private ResultSet result;

	private Alert alert;

	private Image image;
	
	public void timkiemhd() {
		try {
			hoadonListData = hoadonGetOrder();

			hoadon_tkh.setCellValueFactory(new PropertyValueFactory<>("sodienthoai"));
			hoadon_sl.setCellValueFactory(new PropertyValueFactory<>("soluongban"));
			hoadon_gt.setCellValueFactory(new PropertyValueFactory<>("giatien"));
			hoadon_nxhd.setCellValueFactory(new PropertyValueFactory<>("ngayxuathoadon"));
			hoadon_ktt.setCellValueFactory(new PropertyValueFactory<>("phuongthuc"));
			hoadon_nv.setCellValueFactory(new PropertyValueFactory<>("manhanvien"));
			
			hoadon.setItems(hoadonListData);
		    
		    FilteredList<hoadondata> filteredData =new FilteredList<>(hoadonListData,b->true);
		    timkiemhd.textProperty().addListener((observable,oldValue,newValue) ->{
		    	filteredData.setPredicate(hoadondata->{
		    	if(newValue.isEmpty()||newValue.trim().isEmpty()||newValue==null)
		    	{
		    		return true;
		    	}
		    	String seachKeyword =newValue.toLowerCase();
		    	if( hoadondata.getSodienthoai().toLowerCase().indexOf(seachKeyword)>-1)
		    	{
		    		return true;
		    	}
		    	else
		    		return false;
		    	});
		    });
		    SortedList<hoadondata> sorteddata= new SortedList<>(filteredData);
		    sorteddata.comparatorProperty().bind(hoadon.comparatorProperty());
		    hoadon.setItems(sorteddata);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void timkiemhh() {
		try {
			data_hanghoa = datahanghoa();
			hanghoa_tblv_msp.setCellValueFactory(new PropertyValueFactory<>("mahanghoa"));
			hanghoa_tblv_tsp.setCellValueFactory(new PropertyValueFactory<>("tenhanghoa"));
			hanghoa_tblv_sl.setCellValueFactory(new PropertyValueFactory<>("soluongtrongkho"));
			hanghoa_tblv_gb.setCellValueFactory(new PropertyValueFactory<>("giaban"));
			
			hanghoa_tblv_nn.setCellValueFactory(new PropertyValueFactory<>("ngaynhap"));
			
			hanghoa_tblv_ncc.setCellValueFactory(new PropertyValueFactory<>("manhacungcap"));
			hanghoa_tblv_dv.setCellValueFactory(new PropertyValueFactory<>("donvi"));

			hanghoa_tblv.setItems(data_hanghoa);
		    
		    FilteredList<hanghoadata> filteredData =new FilteredList<>(data_hanghoa,b->true);
		    timkiem.textProperty().addListener((observable,oldValue,newValue) ->{
		    	filteredData.setPredicate(hanghoadata->{
		    	if(newValue.isEmpty()||newValue.trim().isEmpty()||newValue==null)
		    	{
		    		return true;
		    	}
		    	String seachKeyword =newValue.toLowerCase();
		    	if( hanghoadata.getMahanghoa().toLowerCase().indexOf(seachKeyword)>-1)
		    	{
		    		return true;
		    	}
		    	else if(String.valueOf(hanghoadata.getGiaban()).indexOf(seachKeyword)>-1) {
		    		return true;
		    	}
		    	else if(String.valueOf(hanghoadata.getNgaynhap()).indexOf(seachKeyword)>-1) {
		    		return true;
		    	}
		    	else if (hanghoadata.getTenhanghoa().toLowerCase().indexOf(seachKeyword)>-1)
		    	{
		    		return true;
		    	}else
		    		return false;
		    	});
		    });
		    SortedList<hanghoadata> sorteddata= new SortedList<>(filteredData);
		    sorteddata.comparatorProperty().bind(hanghoa_tblv.comparatorProperty());
		    hanghoa_tblv.setItems(sorteddata);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void membersDelete() {
		String sql = "DELETE FROM tbl_hang_hoa WHERE ma_hang_hoa = ?";

		connect = database.connectdb();

		try {
			if (hanghoa_msp.getText().isEmpty()) {
				inventoryClearBtn();
			} else {
				alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Bạn có muốn XÓA ?");
				Optional<ButtonType> option = alert.showAndWait();

				if (option.get().equals(ButtonType.OK)) {
					prepare = connect.prepareStatement(sql);
					prepare.setString(1, hanghoa_msp.getText());
					prepare.executeUpdate();

					alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Xóa thành công!");
					alert.showAndWait();

					hienthidatahanghoa();
					inventoryClearBtn();
					timkiemhh();
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

	public void membersUpdate() {
		String sql = "UPDATE tbl_hang_hoa SET ma_hang_hoa = ?,ten_hang_hoa=?,so_luong_trong_kho =?,gia_ban=?,ma_nha_cung_cap =?,don_vi=?,image=? WHERE ma_hang_hoa=?";

		connect = database.connectdb();

		try {
			Alert alert;

			if (hanghoa_msp.getText().isEmpty()) {
				inventoryClearBtn();
			} else {
				alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Bạn có muốn CẬP NHẬT ?");
				Optional<ButtonType> option = alert.showAndWait();

				if (option.get().equals(ButtonType.OK)) {
					prepare = connect.prepareStatement(sql);
					String path = getData.path;
					path = path.replace("\\", "\\\\");

					prepare.setString(1, hanghoa_msp.getText());

					prepare.setString(2, hanghoa_tsp.getText());
					prepare.setString(3, hanghoa_sl.getText());

					prepare.setString(4, hanghoa_gb.getText());
					// prepare.setString(4,
					// java.sql.Date.valueOf(hanghoa_nhh.getValue()).toString());
					// prepare.setInt(5, Integer.parseInt(hanghoa_sln.getText()));
					// prepare.setString(6,hanghoa_gn.getText());
					// prepare.setString(7,
					// java.sql.Date.valueOf(hanghoa_nsx.getValue()).toString());
					prepare.setString(5, hanghoa_ncc.getText());
					prepare.setString(6, hanghoa_dv.getText());
					prepare.setString(7, path);
					prepare.setString(8, hanghoa_msp.getText());

					prepare.executeUpdate();

					alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Cập nhật thành công!");
					alert.showAndWait();

					hienthidatahanghoa();
					timkiemhh();
					inventoryClearBtn();

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

	public void hanghoaSelectData() {

		hanghoadata prodData = hanghoa_tblv.getSelectionModel().getSelectedItem();
		int num = hanghoa_tblv.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1) {
			return;
		}

		hanghoa_msp.setText(prodData.getMahanghoa());
		hanghoa_tsp.setText(prodData.getTenhanghoa());
		hanghoa_ncc.setText(prodData.getManhacungcap());
		// hanghoa_sln.setText(String.valueOf(prodData.getSoluongnhap()));
		hanghoa_sl.setText(String.valueOf(prodData.getSoluongtrongkho()));
		hanghoa_gb.setText(String.valueOf(prodData.getGiaban()));
		// hanghoa_gn.setText(String.valueOf(prodData.getGianhap()));
		// hanghoa_nsx.setValue(prodData.getNgaysanxuat().toLocalDate());
		// hanghoa_nhh.setValue(prodData.getNgaysanxuat().toLocalDate());
		hanghoa_dv.setText(prodData.getDonvi());

		getData.path = prodData.getImage();

		String path = "File:" + prodData.getImage();
//	        data.date = String.valueOf(prodData.getDate());
//	        data.id = prodData.getId();

		image = new Image(path, 137, 144, false, true);
		hanghoa_imageview.setImage(image);
	}

	public void hanghoathemBtn() {
		// kiểm tra xem các ô đã ghi hết chưa
		if (hanghoa_msp.getText().isEmpty() || hanghoa_tsp.getText().isEmpty()
		// || hanghoa_nsx.getValue() ==null
				|| hanghoa_sl.getText().isEmpty() || hanghoa_ncc.getText().isEmpty()
				// || hanghoa_sln.getText().isEmpty()
				// || hanghoa_nhh.getValue()== null
				|| hanghoa_gb.getText().isEmpty()
				// ||hanghoa_gn.getText().isEmpty()
				|| hanghoa_dv.getText().isEmpty()

				|| getData.path == null) {

			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please fill all blank fields");
			alert.showAndWait();

		} else {

			// CHECK mã hàng hóa
			String checkmahanghoa = "SELECT ma_hang_hoa FROM tbl_hang_hoa WHERE ma_hang_hoa = '" + hanghoa_msp.getText()
					+ "'";

			connect = database.connectdb();

			try {

				statement = connect.createStatement();
				result = statement.executeQuery(checkmahanghoa);

				if (result.next()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);

					alert.setContentText(hanghoa_msp.getText() + " is already taken");
					alert.showAndWait();
				} else {
					String insertData = "INSERT INTO tbl_hang_hoa "
							+ "(ma_hang_hoa, ten_hang_hoa ,so_luong_trong_kho,ma_nha_cung_cap,gia_ban,don_vi,image,ngay_nhap) "
							+ "VALUES(?,?,?,?,?,?,?,?)";

					prepare = connect.prepareStatement(insertData);
					prepare.setString(1, hanghoa_msp.getText());
					prepare.setString(2, hanghoa_tsp.getText());
					prepare.setString(3, hanghoa_sl.getText());
					prepare.setString(4, hanghoa_ncc.getText());
					// prepare.setString(4, hanghoa_sln.getText());
					// prepare.setString(5, hanghoa_gn.getText());
					// prepare.setString(6, (String) hanghoa_nsx.getValue().toString());
					// prepare.setString(7, (String) hanghoa_nhh.getValue().toString());
					prepare.setString(5, hanghoa_gb.getText());
					prepare.setString(6, hanghoa_dv.getText());

					String path = getData.path;
					path = path.replace("\\", "\\\\");

					prepare.setString(7, path);

					// ĐỂ NHẬN NGÀY HIỆN TẠI
					Date date = new Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());

					prepare.setString(8, String.valueOf(sqlDate));

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();
					
					timkiemhh();
					hienthidatahanghoa();
					inventoryClearBtn();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//xóa dữ liệu đang hiện trên các ô
	public void inventoryClearBtn() {

		hanghoa_msp.setText("");
		hanghoa_tsp.setText("");
		hanghoa_ncc.setText("");
		hanghoa_sl.setText("");
		// hanghoa_sln.setText("");
		hanghoa_gb.setText("");
		// hanghoa_gn.setText("");
		hanghoa_dv.setText("");

		// hanghoa_nsx.setValue(null);
		// hanghoa_nhh.setValue(null);

		getData.path = "";

		hanghoa_imageview.setImage(null);

	}

//tải ảnh lên
	public void inventoryImportBtn() {

		FileChooser openFile = new FileChooser();
		
		openFile.getExtensionFilters().add(new ExtensionFilter("Open Image File", "*png", "*jpg"));

		File file = openFile.showOpenDialog(main_from.getScene().getWindow());

		if (file != null) {

			getData.path = file.getAbsolutePath();
			image = new Image(file.toURI().toString(), 137, 144, false, true);

			hanghoa_imageview.setImage(image);
		}
	}

	// HỢP NHẤT TẤT CẢ DỮ LIỆU
	public ObservableList<hanghoadata> datahanghoa() {

		ObservableList<hanghoadata> listData = FXCollections.observableArrayList();

		String sql = "SELECT * FROM tbl_hang_hoa";

		connect = database.connectdb();

		try {

			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			hanghoadata hhdata;

			while (result.next()) {

				hhdata = new hanghoadata(result.getString("ma_hang_hoa"), result.getString("ten_hang_hoa"),
						result.getInt("so_luong_trong_kho"), result.getBigDecimal("gia_ban"),
						// result.getDate("ngay_het_han"),
						result.getDate("ngay_nhap"),
//        		result.getInt("so_luong_nhap"),
//        		result.getBigDecimal("gia_nhap"),
//        		result.getDate("ngay_san_xuat"),
						result.getString("ma_nha_cung_cap"), result.getString("don_vi"), result.getString("image"));
				listData.add(hhdata);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listData;
	}

	// HIỂN THỊ DỮ LIỆU TRÊN BẢNG
	private ObservableList<hanghoadata> data_hanghoa;

	public void hienthidatahanghoa() {
		data_hanghoa = datahanghoa();

		hanghoa_tblv_msp.setCellValueFactory(new PropertyValueFactory<>("mahanghoa"));
		hanghoa_tblv_tsp.setCellValueFactory(new PropertyValueFactory<>("tenhanghoa"));
		hanghoa_tblv_sl.setCellValueFactory(new PropertyValueFactory<>("soluongtrongkho"));
		hanghoa_tblv_gb.setCellValueFactory(new PropertyValueFactory<>("giaban"));
		// hanghoa_tblv_nsx.setCellValueFactory(new
		// PropertyValueFactory<>("ngaysanxuat"));
		// hanghoa_tblv_nhh.setCellValueFactory(new
		// PropertyValueFactory<>("ngayhethan"));
		hanghoa_tblv_nn.setCellValueFactory(new PropertyValueFactory<>("ngaynhap"));
		// hanghoa_tblv_gn.setCellValueFactory(new PropertyValueFactory<>("gianhap"));
		// hanghoa_tblv_sln.setCellValueFactory(new
		// PropertyValueFactory<>("soluongnhap"));
		hanghoa_tblv_ncc.setCellValueFactory(new PropertyValueFactory<>("manhacungcap"));
		hanghoa_tblv_dv.setCellValueFactory(new PropertyValueFactory<>("donvi"));

		hanghoa_tblv.setItems(data_hanghoa);

	}

//    public void hienthidatahanghoa1() {
//    	data_hanghoa = datahanghoa();
//        
//    	hanghoa_tblv_msp1.setCellValueFactory(new PropertyValueFactory<>("mahanghoa"));
//    	hanghoa_tblv_tsp1.setCellValueFactory(new PropertyValueFactory<>("tenhanghoa"));
//    	hanghoa_tblv_sl1.setCellValueFactory(new PropertyValueFactory<>("soluongtrongkho"));
//    	hanghoa_tblv_gb1.setCellValueFactory(new PropertyValueFactory<>("giaban"));
//    	hanghoa_tblv_nsx1.setCellValueFactory(new PropertyValueFactory<>("ngaysanxuat"));
//    	hanghoa_tblv_nhh1.setCellValueFactory(new PropertyValueFactory<>("ngayhethan"));
//    	hanghoa_tblv_nn1.setCellValueFactory(new PropertyValueFactory<>("ngaynhap"));
//    	hanghoa_tblv_gn1.setCellValueFactory(new PropertyValueFactory<>("gianhap"));
//    	hanghoa_tblv_sln1.setCellValueFactory(new PropertyValueFactory<>("soluongnhap"));
//    	
//    	hanghoa_tblv_dv1.setCellValueFactory(new PropertyValueFactory<>("donvi"));
//        
//    	
//    	
//    	hanghoa_tblv1.setItems(data_hanghoa);
//        
//    }

	//
	public ObservableList<hanghoadata> hanghoaGetData() {

		String sql = "SELECT * FROM tbl_hang_hoa";

		ObservableList<hanghoadata> listData = FXCollections.observableArrayList();
		connect = database.connectdb();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			hanghoadata prod;

			while (result.next()) {
				prod = new hanghoadata(result.getString("ma_hang_hoa"), 
						result.getString("ten_hang_hoa"),
						result.getInt("so_luong_trong_kho"), 
						result.getBigDecimal("gia_ban"),
						result.getString("don_vi"), 
						result.getString("image"),
						result.getDate("ngay_nhap"));

				listData.add(prod);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listData;
	}

	public ObservableList<hoadondata> menuGetOrder() {
		   customerID();
		ObservableList<hoadondata> listData = FXCollections.observableArrayList();

		String sql = "SELECT tbl_hang_hoa.ma_hang_hoa,tbl_hang_hoa.ten_hang_hoa,tbl_hoa_don.gia_tien,tbl_hoa_don.so_luong_ban,tbl_hoa_don.ma_hoa_don,tbl_hoa_don.ma_khach_hang,tbl_hoa_don.ngay_xuat_hoa_don,tbl_hoa_don.phuong_thuc,tbl_hoa_don.ma_nhan_vien from tbl_hang_hoa ,tbl_hoa_don where  tbl_hang_hoa.ma_hang_hoa=tbl_hoa_don.ma_hang_hoa and ma_khach_hang = "+cID;
		System.out.println(sql);
		connect = database.connectdb();

		try {

			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			hoadondata prod;

			while (result.next()) {
				prod = new hoadondata(
						result.getInt("ma_hoa_don"),
						result.getBigDecimal("gia_tien"),
						result.getInt("so_luong_ban"),
						result.getDate("ngay_xuat_hoa_don"),
						result.getString("ma_khach_hang"),
						result.getString("ma_nhan_vien"),
						result.getString("phuong_thuc"), 
						result.getString("ma_hang_hoa"),
						result.getString("ten_hang_hoa"));
				
				listData.add(prod);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listData;
	}
	public ObservableList<hoadondata> hoadonGetOrder() {
		   customerID();
		ObservableList<hoadondata> listData = FXCollections.observableArrayList();

		String sql = "select tbl_nhan_vien.ten_nhan_vien,tbl_hoa_don.so_luong_ban,tbl_hoa_don.ngay_xuat_hoa_don,tbl_hoa_don.gia_tien,tbl_hoa_don.phuong_thuc,tbl_khach_hang.ten_khach_hang from tbl_hoa_don,tbl_khach_hang,tbl_nhan_vien where tbl_nhan_vien.ma_nhan_vien=tbl_hoa_don.ma_nhan_vien and tbl_khach_hang.ma_khach_hang=tbl_hoa_don.ma_khach_hang";
		
		connect = database.connectdb();

		try {

			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			hoadondata prod;

			while (result.next()) {
				prod = new hoadondata(
						
						result.getBigDecimal("gia_tien"),
						result.getInt("so_luong_ban"),
						result.getDate("ngay_xuat_hoa_don"),
						
						
						result.getString("ten_khach_hang"),
						result.getString("ten_nhan_vien"),
						result.getString("phuong_thuc"));
				
				listData.add(prod);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listData;
	}
	private ObservableList<hoadondata> hoadonListData;
	//hiển thị hàng hóa mua
		public void hoadonData() {
			hoadonListData = hoadonGetOrder();

			hoadon_tkh.setCellValueFactory(new PropertyValueFactory<>("sodienthoai"));
			hoadon_sl.setCellValueFactory(new PropertyValueFactory<>("soluongban"));
			hoadon_gt.setCellValueFactory(new PropertyValueFactory<>("giatien"));
			hoadon_nxhd.setCellValueFactory(new PropertyValueFactory<>("ngayxuathoadon"));
			hoadon_ktt.setCellValueFactory(new PropertyValueFactory<>("phuongthuc"));
			hoadon_nv.setCellValueFactory(new PropertyValueFactory<>("manhanvien"));
			
			hoadon.setItems(hoadonListData);
		}
	private ObservableList<hoadondata> menuOrderListData;
//hiển thị hàng hóa mua
	public void menuShowOrderData() {
		menuOrderListData = menuGetOrder();

		banhang_tblv_msp.setCellValueFactory(new PropertyValueFactory<>("mahanghoa"));
		banhang_tblv_tsp.setCellValueFactory(new PropertyValueFactory<>("tenhanghoa"));
		banhang_tblv_sl.setCellValueFactory(new PropertyValueFactory<>("soluongban"));
		banhang_tblv_gt.setCellValueFactory(new PropertyValueFactory<>("giatien"));
		
		banhang_tblv.setItems(menuOrderListData);
	}

	private BigDecimal totalP = new BigDecimal(0);
//tính tổng tiền mua
	public void menuGetTotal() {
		   customerID();
		String total = "SELECT SUM(gia_tien) as giatien FROM tbl_hoa_don WHERE ma_khach_hang = " + cID;

		connect = database.connectdb();
		 
		try {

			prepare = connect.prepareStatement(total);
			result = prepare.executeQuery();

			if (result.next()) {
				totalP = result.getBigDecimal("giatien");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	 private int getid;
	public void menuSelectOrder() {
        hoadondata prod = banhang_tblv.getSelectionModel().getSelectedItem();
        int num = banhang_tblv.getSelectionModel().getSelectedIndex();
        
        if ((num - 1) < -1) {
            return;
        }
        // trả về ma hóa đơn 
        getid = prod.getMahoadon();
        
    }
	
public void menuPayBtn() {
        
        if (totalP == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Khách chưa mua hàng (!'!) ");
            alert.showAndWait();
        } else if(banhang_pthuc.getSelectionModel().getSelectedItem() == null){
        	alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("chọn phương thức thanh toán !");
            alert.showAndWait();
        	
        }
        	else {
        		getData.phuongthuc=(String) banhang_pthuc.getSelectionModel().getSelectedItem();
        		 System.out.println(getData.phuongthuc);
            menuGetTotal();
            
            String insertPay = "INSERT INTO tbl_khach_hang (ma_khach_hang, so_dien_thoai_kh, ten_khach_hang, gioi_tinh_kh,tong) "
                    + "VALUES(?,?,?,?,?)";
            
            connect = database.connectdb();
            
            try {
                
                if (amount.compareTo(BigDecimal.ZERO) == 0) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Messaged");
                    alert.setHeaderText(null);
                    alert.setContentText("tiền khách trả:3");
                    alert.showAndWait();
                } else {
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("bạn chắc chắn chứ ?");
                    Optional<ButtonType> option = alert.showAndWait();
                    
                    if (option.get().equals(ButtonType.OK)) {
                        customerID();
                        menuGetTotal();
                        
                        prepare = connect.prepareStatement(insertPay);
                        
                        prepare.setString(1, String.valueOf(cID));
                        prepare.setString(2,banhang_sdtkh.getText() );
                        
                        
                        
                        prepare.setString(3,banhang_tkh.getText() );
                        prepare.setString(4, (String) banhang_gt1.getSelectionModel().getSelectedItem());
                        prepare.setBigDecimal(5, totalP);
                        
                        
                        prepare.executeUpdate();
                        
                        
                        
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Infomation Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successful.");
                        alert.showAndWait();
                        
                        menuShowOrderData();
                        
                    } else {
                        alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Infomation Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Cancelled.");
                        alert.showAndWait();
                    }
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
public void menuReceiptBtn() {
    
    if (totalP == null ) {
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setContentText("chưa mua hàng");
        alert.showAndWait();
    } 
    else if(banhang_tkt.getText().isEmpty())
    {
    	alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setContentText("Chưa Nhập tiền khách trả");
        alert.showAndWait();
    }
    else {
    	
        HashMap map = new HashMap();
        map.put("getmakhachhang", (cID - 1));
        
        try {
            
            JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\ADMIN\\eclipse-workspace\\taphoa\\src\\chucnang\\hoadon.jrxml");
            JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);
            
            JasperViewer.viewReport(jPrint, false);
            
            menuRestart();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
    
}
public void dashboardIncomeChart() {
	bieudo.getData().clear();
    
    String sql = "select tbl_hoa_don.ngay_xuat_hoa_don,sum(tbl_khach_hang.tong) from tbl_hoa_don, tbl_khach_hang where tbl_hoa_don.ma_khach_hang=tbl_khach_hang.ma_khach_hang group by tbl_hoa_don.ngay_xuat_hoa_don ";
    connect = database.connectdb();
    XYChart.Series chart = new XYChart.Series();
    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
        
        while (result.next()) {
            chart.getData().add(new XYChart.Data<>(result.getString(1), result.getFloat(2)));
        }
        
        bieudo.getData().add(chart);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void menuRemoveBtn() {
    
    if (getid == 0) {
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("chọn món đồ muốn xóa");
        alert.showAndWait();
    }else if (totalP==null)
    {
    	alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Khách chưa mưa hàng");
        alert.showAndWait();
    	
    }
    else {
        String deleteData = "DELETE FROM tbl_hoa_don WHERE ma_hoa_don = " + getid;
        connect = database.connectdb();
        try {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("bạn chắc chắn muốn xóa chứ ?");
            Optional<ButtonType> option = alert.showAndWait();
            
            if (option.get().equals(ButtonType.OK)) {
                prepare = connect.prepareStatement(deleteData);
                prepare.executeUpdate();
            }
            
            menuShowOrderData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
public void menuRestart() {
    totalP = new BigDecimal(0);
    change = new BigDecimal(0);
    amount = new BigDecimal(0);
    banhang_pthuc.getSelectionModel().clearSelection();
    banhang_tong.setText("0.0đ");
    banhang_tkt.setText("");
    banhang_ttl.setText("0.0đ");
    banhang_tkh.setText("");
    banhang_sdtkh.setText("");
    banhang_gt1.getSelectionModel().clearSelection();
}
    
	 private BigDecimal amount= new BigDecimal(0);
	 private BigDecimal change= new BigDecimal(0);
	

	 
	 //tính tiền trả lại
	public void menuAmount() {
        menuGetTotal();
        if (banhang_tkt.getText().isEmpty() ) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Nhập tiền khách trả :3");
            alert.showAndWait();
        } else if(totalP == null) {
        	alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Khách chưa mua hàng :3");
            alert.showAndWait();
        }
        else {
        	try {
        	
            amount = new BigDecimal(banhang_tkt.getText());
            
            if (amount.compareTo(totalP)<0) {
            	alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Khách Trả Thiếu");
                alert.showAndWait();
            }
            else {
                change = amount.subtract(totalP);
                banhang_ttl.setText( change+"đ");
            }
        	}
        	catch (NumberFormatException e)
        	{
        		alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("vui lòng nhập lại");
                alert.showAndWait();
        	}
        }
    }
	//hiển thị tổng tiền
	public void menuDisplayTotal() {
		menuGetTotal();
		if(totalP == null) {
			banhang_tong.setText("0.0đ");
		}else
		banhang_tong.setText(totalP+"đ");
	}

	private ObservableList<hanghoadata> cardListData = FXCollections.observableArrayList();

	public void menuDisplayCard() {

		cardListData.clear();
		cardListData.addAll(hanghoaGetData());

		int row = 0;
		int column = 0;

		banhang_gridpane.getChildren().clear();
		banhang_gridpane.getRowConstraints().clear();
		banhang_gridpane.getColumnConstraints().clear();

		for (int q = 0; q < cardListData.size(); q++) {

			try {
				FXMLLoader load = new FXMLLoader();
				load.setLocation(getClass().getResource("cardhanghoa.fxml"));
				AnchorPane pane = load.load();
				cardhanghoaController cardC = load.getController();
				cardC.setData(cardListData.get(q));

				if (column == 3) {
					column = 0;
					row += 1;
				}

				banhang_gridpane.add(pane, column++, row);

				GridPane.setMargin(pane, new Insets(10));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private int cID;
	private int mhd=0;
//	String hd = "hh";
//	String mhd = "";
//	
//	public String mahd(int n) {
//		return hd + n;
//
//	}

	public void customerID() {

		String sql = "SELECT MAX(ma_khach_hang) as max_ma_khach_hang FROM tbl_hoa_don";
		connect = database.connectdb();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			if (result.next()) {
				cID = result.getInt("max_ma_khach_hang");
			}
			String checkCID = "SELECT MAX(ma_khach_hang)as max_ma_khach_hang FROM tbl_khach_hang ";
			
            prepare = connect.prepareStatement(checkCID);
            result = prepare.executeQuery();
            int checkID = 0;
            if (result.next()) {
                checkID = result.getInt("max_ma_khach_hang");
            }
            
			if (cID == 0) {
				cID += 1;
				//mhd = mahd(cID);

			} else if(cID == checkID) {
				cID += 1;
				//mhd = mahd(cID);
			}
			else if(cID<checkID)
			{
				cID=checkID+1;
			}
			String sql1 = "SELECT MAX(ma_hoa_don)as max_ma_khach_hang FROM tbl_hoa_don";
			prepare = connect.prepareStatement(sql1);
			result = prepare.executeQuery();
			if (result.next()) {
				mhd = result.getInt("max_ma_khach_hang");
			}
			getData.mahoadon=mhd+1;
			//getData.mahoadon = mhd;
			if (mhd == 0) {
				mhd += 1;}
			getData.cID = cID;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		try {
			alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Bạn có chắc chắn bạn muốn thoát?");
			Optional<ButtonType> option = alert.showAndWait();
			if (option.get().equals(ButtonType.OK)) {

				// ĐỂ ẨN MẪU CHÍNH
				logout_btn.getScene().getWindow().hide();

				// LIÊN KẾT MẪU ĐĂNG NHẬP VÀ HIỂN THỊ
				Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));

				Stage stage = new Stage();
				Scene scene = new Scene(root);

				stage.setScene(scene);
				stage.show();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnclose(ActionEvent event) {
		System.exit(0);
	}

	public void displayUsername() {

		String user = getData.username;
		user = user.substring(0, 1).toUpperCase() + user.substring(1);

		ten_labl.setText(user);

	}

	public void switchForm(ActionEvent event) {

		if (event.getSource() == tongquan_btn) {

			ac_tongquan.setVisible(true);
			ac_hanghoa.setVisible(false);
			ac_banhang.setVisible(false);
			ac_hoadon.setVisible(false);
			
			daban();
	        tongthunhap();
	        displaynguoi(); 
	        displaythunhaphomnay() ;
	        dashboardIncomeChart();

		} else if (event.getSource() == kholuutru_btn) {

			ac_tongquan.setVisible(false);
			ac_hanghoa.setVisible(true);
			ac_banhang.setVisible(false);
			ac_hoadon.setVisible(false);
			hienthidatahanghoa();
			timkiemhh();

		} else if (event.getSource() == banhang_btn) {

			ac_tongquan.setVisible(false);
			ac_hanghoa.setVisible(false);
			ac_banhang.setVisible(true);
			ac_hoadon.setVisible(false);
			menuDisplayCard();
			menuGetOrder();
	        menuDisplayTotal();
	        menuShowOrderData();
			
		} else if (event.getSource() == hoadon_btn) {

			ac_tongquan.setVisible(false);
			ac_hanghoa.setVisible(false);
			ac_banhang.setVisible(false);
			ac_hoadon.setVisible(true);
			timkiemhd();
			hoadonData();
		}

	}
public void displaynguoi() {
	Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    calendar.get(java.util.Calendar.DAY_OF_MONTH);
        String sql = "select count(tbl_hoa_don.ma_khach_hang) as ma from tbl_hoa_don,tbl_khach_hang Where tbl_khach_hang.ma_khach_hang=tbl_hoa_don.ma_khach_hang and DAY(tbl_hoa_don.ngay_xuat_hoa_don)=" +calendar.get(java.util.Calendar.DAY_OF_MONTH);
        connect = database.connectdb();
        
        try {
            int nc = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if (result.next()) {
                nc = result.getInt("ma");
            }
            nguoi.setText(String.valueOf(nc));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
public void displaythunhaphomnay() {
	Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    int dayOfMonth = calendar.get(java.util.Calendar.DAY_OF_MONTH);
    int month = calendar.get(java.util.Calendar.MONTH)+1;
    String sql = "SELECT sum(gia_tien) as ma FROM tbl_hoa_don where DAY(ngay_xuat_hoa_don)= "+ dayOfMonth + " and MONTH(ngay_xuat_hoa_don)=" +month;
    connect = database.connectdb();
    
    try {
    	System.out.print(sql);
    	BigDecimal ti = new BigDecimal("0");
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
        
        if (result.next()) {
        	ti = result.getBigDecimal("ma");
        }
        if(ti==null)
        	ti=new BigDecimal("0");
        homnay.setText(ti+"đ");
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}

public void tongthunhap() {
	Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    
    int month = calendar.get(java.util.Calendar.MONTH)+1;
   
    String sql = "SELECT sum(tong) as tong FROM tbl_khach_hang where tong in(SELECT DISTINCT tong  FROM tbl_khach_hang  INNER JOIN tbl_hoa_don ON tbl_khach_hang.ma_khach_hang=tbl_hoa_don.ma_khach_hang and MONTH(ngay_xuat_hoa_don)="+month+")";
    
    connect = database.connectdb();
    
    try {
    	BigDecimal ti = new BigDecimal("0");
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
        
        if (result.next()) {
        	ti = result.getBigDecimal("tong");
        }
        thunhap.setText(ti+"đ");
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
public void daban() {
	Date date = new Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    int dayOfMonth = calendar.get(java.util.Calendar.DAY_OF_MONTH);
   
    
    String sql = "SELECT sum(so_luong_ban) as so FROM tbl_hoa_don where day(ngay_xuat_hoa_don)="+dayOfMonth;
    
    connect = database.connectdb();
    
    try {
        int q = 0;
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
        
        if (result.next()) {
            q = result.getInt("so");
        }
        sanpham.setText(String.valueOf(q));
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}

	private String[] typeList = { "tiền mặt", "chuyển khoản" };
	private String[] typeList1 = { "Nam", "Nữ" };
	
	public void inventoryTypeList() {

		List<String> typeL = new ArrayList<>();

		for (String data : typeList) {
			typeL.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(typeL);

		banhang_pthuc.setItems(listData);
	}
	public void inventoryTypeList1() {

		List<String> typeL = new ArrayList<>();

		for (String data : typeList1) {
			typeL.add(data);
		}

		ObservableList listData = FXCollections.observableArrayList(typeL);

		banhang_gt1.setItems(listData);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		displayUsername();
		timkiemhh();
		inventoryTypeList();
		timkiemhd();
		hienthidatahanghoa();
		inventoryTypeList1();
		menuDisplayCard();
		menuGetOrder();
		menuShowOrderData();
        menuDisplayTotal();
        
        hoadonData();
        
        daban();
        tongthunhap();
        displaynguoi(); 
        displaythunhaphomnay() ;
        
        dashboardIncomeChart();

	}

}
