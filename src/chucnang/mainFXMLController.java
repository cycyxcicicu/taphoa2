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
import java.util.UUID;

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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.converter.IntegerStringConverter;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.StringConverter;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn.CellEditEvent;
public class mainFXMLController implements Initializable, MainFXMLListener {

	@FXML
	private Button banhang_btn;

	@FXML
	private ComboBox<?> banhang_pthuc;

	@FXML
	private Button closebtn;

	@FXML
	private ImageView hanghoa_imageview;

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
	private TableColumn<hanghoadata, String> hanghoa_tblv_nn;

	@FXML
	private TableColumn<hanghoadata, String> hanghoa_tblv_sl;

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
	private TableColumn<hoadondata, Integer> banhang_tblv_sl;

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
	private Button hanghoa_lm;

	@FXML
	private TextField hanghoa_dv;

	@FXML
	private TextField hanghoa_gb;

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
	private ComboBox<String> hanghoa_ncc;

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

			FilteredList<hoadondata> filteredData = new FilteredList<>(hoadonListData, b -> true);
			timkiemhd.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredData.setPredicate(hoadondata -> {
					if (newValue.isEmpty() || newValue.trim().isEmpty() || newValue == null) {
						return true;
					}
					String seachKeyword = newValue.toLowerCase();
					if (String.valueOf(hoadondata.getNgayxuathoadon()).indexOf(seachKeyword) > -1) {
						return true;
					} else
						return false;
				});
			});
			SortedList<hoadondata> sorteddata = new SortedList<>(filteredData);
			sorteddata.comparatorProperty().bind(hoadon.comparatorProperty());
			hoadon.setItems(sorteddata);
		} catch (Exception e) {
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

			FilteredList<hanghoadata> filteredData = new FilteredList<>(data_hanghoa, b -> true);
			timkiem.textProperty().addListener((observable, oldValue, newValue) -> {
				filteredData.setPredicate(hanghoadata -> {
					if (newValue.isEmpty() || newValue.trim().isEmpty() || newValue == null) {
						return true;
					}
					String seachKeyword = newValue.toLowerCase();
					if (hanghoadata.getMahanghoa().toLowerCase().indexOf(seachKeyword) > -1) {
						return true;
					} else if (String.valueOf(hanghoadata.getGiaban()).indexOf(seachKeyword) > -1) {
						return true;
					} else if (String.valueOf(hanghoadata.getNgaynhap()).indexOf(seachKeyword) > -1) {
						return true;
					} else if (hanghoadata.getTenhanghoa().toLowerCase().indexOf(seachKeyword) > -1) {
						return true;
					} else
						return false;
				});
			});
			SortedList<hanghoadata> sorteddata = new SortedList<>(filteredData);
			sorteddata.comparatorProperty().bind(hanghoa_tblv.comparatorProperty());
			hanghoa_tblv.setItems(sorteddata);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void membersDelete() {
		String sql = "DELETE FROM tbl_hang_hoa WHERE ma_hang_hoa = ?";

		connect = database.connectdb();

		try {

			alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Message");
			alert.setHeaderText(null);
			alert.setContentText("Bạn có muốn XÓA ?");
			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, mahanghoa);
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void membersUpdate() {

		if (hanghoa_tsp.getText().isEmpty() || hanghoa_sl.getText().isEmpty()
				|| hanghoa_ncc.getSelectionModel().getSelectedItem() == null || hanghoa_gb.getText().isEmpty()
				|| hanghoa_dv.getText().isEmpty() || getData.path == null) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Nhập đầy đủ thông tin ");
			alert.showAndWait();
		} else {
			try { 
				giaban = new BigDecimal(hanghoa_gb.getText());
				soluong = new Integer(hanghoa_sl.getText());
				String numberString = String.valueOf(soluong);
				boolean isValid = numberString.matches("\\d+");
				if (giaban.compareTo(BigDecimal.ZERO) < 0) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Giá bán không thể âm ");
					alert.showAndWait();
				} else if (!isValid) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("số lượng không thể âm ");
					alert.showAndWait();
				} else {

					try {

						alert = new Alert(Alert.AlertType.CONFIRMATION);
						alert.setTitle("Confirmation Message");
						alert.setHeaderText(null);
						alert.setContentText("Bạn có muốn CẬP NHẬT ?");
						Optional<ButtonType> option = alert.showAndWait();

						if (option.get().equals(ButtonType.OK)) {

							String sql = "UPDATE tbl_hang_hoa SET ma_hang_hoa = ?,ten_hang_hoa=?,so_luong_trong_kho =?,gia_ban=?,ma_nha_cung_cap =?,don_vi=?,image=? WHERE ma_hang_hoa=?";

							connect = database.connectdb();

							prepare = connect.prepareStatement(sql);
							String path = getData.path;
							path = path.replace("\\", "\\\\");

							prepare.setString(1, mahanghoa);

							prepare.setString(2, hanghoa_tsp.getText());
							prepare.setString(3, hanghoa_sl.getText());

							prepare.setString(4, hanghoa_gb.getText());

							prepare.setString(5, hanghoa_ncc.getSelectionModel().getSelectedItem());
							prepare.setString(6, hanghoa_dv.getText());
							prepare.setString(7, path);
							prepare.setString(8, mahanghoa);

							prepare.executeUpdate();

							alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setTitle("Information Message");
							alert.setHeaderText(null);
							alert.setContentText("Cập nhật thành công!");
							alert.showAndWait();

							timkiemhh();
							hienthidatahanghoa();
							inventoryClearBtn();
						} else {
							alert = new Alert(Alert.AlertType.ERROR);
							alert.setTitle("Information Message");
							alert.setHeaderText(null);
							alert.setContentText("Hủy Cập Nhật!!");
							alert.showAndWait();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (NumberFormatException e) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("vui lòng nhập lại");
				alert.showAndWait();
			}
		}
	}

	private String mahanghoa;
	private BigDecimal giaban;
	private int soluong;

	public void hanghoaSelectData() {

		hanghoadata prodData = hanghoa_tblv.getSelectionModel().getSelectedItem();
		int num = hanghoa_tblv.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1) {
			return;
		}

		mahanghoa = prodData.getMahanghoa();
		hanghoa_tsp.setText(prodData.getTenhanghoa());
		hanghoa_ncc.setValue(prodData.getManhacungcap());
		hanghoa_sl.setText(String.valueOf(prodData.getSoluongtrongkho()));
		hanghoa_gb.setText(String.valueOf(prodData.getGiaban()));
		hanghoa_dv.setText(prodData.getDonvi());
		getData.path = prodData.getImage();
		String path = "File:" + prodData.getImage();
		image = new Image(path, 137, 144, false, true);
		hanghoa_imageview.setImage(image);
	}

	public void hanghoathemBtn() {
		// kiểm tra xem các ô đã ghi hết chưa

		if (hanghoa_tsp.getText().isEmpty() || hanghoa_sl.getText().isEmpty()
				|| hanghoa_ncc.getSelectionModel().getSelectedItem() == null || hanghoa_gb.getText().isEmpty()
				|| hanghoa_dv.getText().isEmpty() || getData.path == null) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Nhập đầy đủ thông tin ");
			alert.showAndWait();
		} else {
			try {
				giaban = new BigDecimal(hanghoa_gb.getText());
				soluong = new Integer(hanghoa_sl.getText());
				String numberString = String.valueOf(soluong);
				boolean isValid = numberString.matches("\\d+");
				if (giaban.compareTo(BigDecimal.ZERO) < 0) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Giá bán không thể âm ");
					alert.showAndWait();
				} else if (!isValid) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("số lượng không thể âm ");
					alert.showAndWait();
				} else {

					// CHECK mã hàng hóa
					String checkmahanghoa = "SELECT ma_hang_hoa FROM tbl_hang_hoa WHERE ma_hang_hoa = '" + mahanghoa
							+ "'";

					connect = database.connectdb();

					try {

						statement = connect.createStatement();
						result = statement.executeQuery(checkmahanghoa);

						if (result.next()) {
							alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error Message");
							alert.setHeaderText(null);

							alert.setContentText(mahanghoa + " is already taken");
							alert.showAndWait();
						} else {
							String insertData = "INSERT INTO tbl_hang_hoa "
									+ "(ma_hang_hoa, ten_hang_hoa ,so_luong_trong_kho,ma_nha_cung_cap,gia_ban,don_vi,image,ngay_nhap) "
									+ "VALUES(?,?,?,?,?,?,?,?)";

							prepare = connect.prepareStatement(insertData);
							prepare.setString(1, generateID1());
							prepare.setString(2, hanghoa_tsp.getText());
							prepare.setString(3, hanghoa_sl.getText());
							prepare.setString(4, (String) hanghoa_ncc.getSelectionModel().getSelectedItem());
							prepare.setString(5, hanghoa_gb.getText());
							prepare.setString(6, hanghoa_dv.getText());
							String path = getData.path;
							path = path.replace("\\", "\\\\");
							prepare.setString(7, path);
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
			} catch (NumberFormatException e) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("vui lòng nhập lại");
				alert.showAndWait();
			}
		}
	}

	private static final int ID_LENGTH = 5;
//sinh mã tự động
	public String generateID1() {
		UUID uuid = UUID.randomUUID();
		long hash = uuid.getLeastSignificantBits();
		hash = hash != Long.MIN_VALUE ? Math.abs(hash) : 0;
		String id = Long.toString(hash, 36);
		return id.substring(0, Math.min(id.length(), ID_LENGTH)).toUpperCase();
	}

//xóa dữ liệu đang hiện trên các ô
	public void inventoryClearBtn() {
		mahanghoa = "";
		hanghoa_tsp.setText("");
		hanghoa_ncc.getSelectionModel().clearSelection();
		hanghoa_sl.setText("");
		hanghoa_gb.setText("");
		hanghoa_dv.setText("");
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
						result.getDate("ngay_nhap"),

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

		hanghoa_tblv_nn.setCellValueFactory(new PropertyValueFactory<>("ngaynhap"));

		hanghoa_tblv_ncc.setCellValueFactory(new PropertyValueFactory<>("manhacungcap"));
		hanghoa_tblv_dv.setCellValueFactory(new PropertyValueFactory<>("donvi"));

		hanghoa_tblv.setItems(data_hanghoa);

	}

	public ObservableList<hanghoadata> hanghoaGetData() {

		String sql = "SELECT * FROM tbl_hang_hoa";

		ObservableList<hanghoadata> listData = FXCollections.observableArrayList();
		connect = database.connectdb();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			hanghoadata prod;

			while (result.next()) {
				prod = new hanghoadata(result.getString("ma_hang_hoa"), result.getString("ten_hang_hoa"),
						result.getInt("so_luong_trong_kho"), result.getBigDecimal("gia_ban"),
						result.getString("don_vi"), result.getString("image"), result.getDate("ngay_nhap"));

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

		String sql = "SELECT tbl_hang_hoa.ma_hang_hoa,tbl_hang_hoa.ten_hang_hoa,tbl_hoa_don.gia_tien,tbl_hoa_don.so_luong_ban,tbl_hoa_don.ma_hoa_don,tbl_hoa_don.ma_khach_hang,tbl_hoa_don.ngay_xuat_hoa_don,tbl_hoa_don.phuong_thuc,tbl_hoa_don.ma_nhan_vien from tbl_hang_hoa ,tbl_hoa_don where  tbl_hang_hoa.ma_hang_hoa=tbl_hoa_don.ma_hang_hoa and ma_khach_hang = "
				+ cID;
		System.out.println(sql);
		connect = database.connectdb();

		try {

			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			hoadondata prod;

			while (result.next()) {
				prod = new hoadondata(result.getInt("ma_hoa_don"), result.getBigDecimal("gia_tien"),
						result.getInt("so_luong_ban"), result.getDate("ngay_xuat_hoa_don"),
						result.getString("ma_khach_hang"), result.getString("ma_nhan_vien"),
						result.getString("phuong_thuc"), result.getString("ma_hang_hoa"),
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

	// hiển thị hàng hóa mua
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
	private BigDecimal gia2;
	private BigDecimal gia3;
	Integer soluong1;

	public void initialize1() {

		banhang_tblv_sl.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
		    @Override
		    public String toString(Integer object) {
		        return object.toString();
		    }

		    @Override
		    public Integer fromString(String string) {
		        try {
		            return Integer.parseInt(string);
		        } catch (NumberFormatException e) {
		            return null;
		        }
		    }
		}));
		
		banhang_tblv_sl.setOnEditCommit(event -> {
			hoadondata selectedData = event.getRowValue();
			
			if(event.getNewValue()==null) {
				selectedData.setSoluongban(event.getOldValue());
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("vui lòng nhập lại");
				alert.showAndWait();
				menuShowOrderData();
			}
			else {
				soluong1 =  new Integer(event.getNewValue().intValue());
				
				if ( soluong1 != null && soluong1 > 0) {
					selectedData.setSoluongban(soluong1); // Ghi lại số lượng mới
					gia3 = gia(selectedData.getMahoadon());
					BigDecimal bigDecimalValue = new BigDecimal(soluong1);

					gia2 = bigDecimalValue.multiply(gia3);
					updateQuantityInDatabase(selectedData.getMahoadon(), soluong1, gia2);
					menuGetOrder();
					menuDisplayTotal();
					menuShowOrderData();
				} else {

					selectedData.setSoluongban(event.getOldValue());

					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("số lượng phải lơn hơn 0");
					alert.showAndWait();
					menuShowOrderData();
				}
			}
			

			

		});
		}

	private BigDecimal gia1;
	private BigDecimal gia(int mahoadon)
	{ 
		String sql = "SELECT tbl_hang_hoa.gia_ban from tbl_hang_hoa,tbl_hoa_don where tbl_hang_hoa.ma_hang_hoa=tbl_hoa_don.ma_hang_hoa and tbl_hoa_don.ma_hoa_don="+mahoadon;
		connect = database.connectdb();
		try {
		prepare = connect.prepareStatement(sql);
		result = prepare.executeQuery();

		if (result.next()) {
			gia1 = result.getBigDecimal("gia_ban");
			
		}
		
		 } catch (Exception e) {
				e.printStackTrace();
		    }
		return gia1;
	}
	private void updateQuantityInDatabase(int maHoaDon, int newQuantity,BigDecimal gia1) {
	    // Thực hiện câu truy vấn SQL để cập nhật số lượng trong cơ sở dữ liệu
	    String sql = "UPDATE tbl_hoa_don SET so_luong_ban = ?,gia_tien=? WHERE ma_hoa_don = ?";
	    connect = database.connectdb();
	    try {
	    	
	        PreparedStatement statement = connect.prepareStatement(sql);
	        statement.setInt(1, newQuantity);
	        statement.setBigDecimal(2,gia1);
	        statement.setInt(3, maHoaDon);
	        statement.executeUpdate();
	    } catch (Exception e) {
			e.printStackTrace();
	    }
	}

	private BigDecimal totalP;

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
	private int soluongban;
	private String ma;

	public void menuSelectOrder() {
		hoadondata prod = banhang_tblv.getSelectionModel().getSelectedItem();
		int num = banhang_tblv.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1) {
			return;
		}
		// trả về ma hóa đơn
		getid = prod.getMahoadon();
		soluongban = prod.getSoluongban();
		ma = prod.getMahanghoa();
	}

	String sdt;
	int so;
	public void menuPayBtn() {
		
		if (totalP == null || totalP.compareTo(BigDecimal.ZERO) == 0) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Khách chưa mua hàng (!'!) ");
			alert.showAndWait();
		} else if (banhang_pthuc.getSelectionModel().getSelectedItem() == null) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("chọn phương thức thanh toán !");
			alert.showAndWait();

		} else if (banhang_tkt.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setContentText("Chưa Nhập tiền khách trả");
			alert.showAndWait();
		} else {
			getData.phuongthuc = (String) banhang_pthuc.getSelectionModel().getSelectedItem();
			
			menuGetTotal();

			String insertPay = "INSERT INTO tbl_khach_hang (ma_khach_hang, so_dien_thoai_kh, ten_khach_hang, gioi_tinh_kh,tong) "
					+ "VALUES(?,?,?,?,?)";

			connect = database.connectdb();

			try {

				if (amount.compareTo(BigDecimal.ZERO) == 0) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Messaged");
					alert.setHeaderText(null);
					alert.setContentText("nhập tiền khách trả:3");
					alert.showAndWait();
				} else if (!banhang_sdtkh.getText().isEmpty()) {
					sdt = banhang_sdtkh.getText();
					boolean isValid = sdt.matches("\\d{10}");
					if (!isValid) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Messaged");
						alert.setHeaderText(null);
						alert.setContentText("nhập lại sdt");
						alert.showAndWait();
					}

					else {

						alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirmation Message");
						alert.setHeaderText(null);
						alert.setContentText("bạn chắc chắn chứ ?");
						Optional<ButtonType> option = alert.showAndWait();

						if (option.get().equals(ButtonType.OK)) {
							customerID();
							menuGetTotal();
							so=cID;
							prepare = connect.prepareStatement(insertPay);

							prepare.setString(1, String.valueOf(cID));
							prepare.setString(2, banhang_sdtkh.getText());

							prepare.setString(3, banhang_tkh.getText());
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
				}
				else {

					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Message");
					alert.setHeaderText(null);
					alert.setContentText("bạn chắc chắn chứ ?");
					Optional<ButtonType> option = alert.showAndWait();

					if (option.get().equals(ButtonType.OK)) {
						customerID();
						menuGetTotal();
						so=cID;
						prepare = connect.prepareStatement(insertPay);

						prepare.setString(1, String.valueOf(cID));
						prepare.setString(2, banhang_sdtkh.getText());

						prepare.setString(3, banhang_tkh.getText());
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

		if (totalP == null || totalP.compareTo(BigDecimal.ZERO) == 0) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setContentText("chưa mua hàng ");
			alert.showAndWait();
		} else if (banhang_tkt.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setContentText("Chưa Nhập tiền khách trả");
			alert.showAndWait();
		} else {

			HashMap map = new HashMap();
			map.put("getmakhachhang", (cID - 1));

			try {

				JasperDesign jDesign = JRXmlLoader
						.load("C:\\Users\\ADMIN\\eclipse-workspace\\taphoa\\src\\chucnang\\hoadon.jrxml");
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

		if (totalP == null || totalP.compareTo(BigDecimal.ZERO) == 0) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Khách chưa mưa hàng");
			alert.showAndWait();
		} else if (getid == 0) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("chọn món đồ muốn xóa");
			alert.showAndWait();

		} else {
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

				int checkStck = 0;
				String checkStock = "SELECT so_luong_trong_kho FROM tbl_hang_hoa WHERE ma_hang_hoa = '" + ma + "'";

				prepare = connect.prepareStatement(checkStock);
				result = prepare.executeQuery();

				if (result.next()) {
					checkStck = result.getInt("so_luong_trong_kho");
				}

				String update = "UPDATE tbl_hang_hoa SET  so_luong_trong_kho= ? where ma_hang_hoa=?";
				prepare = connect.prepareStatement(update);

				int tong = checkStck + soluongban;

				prepare.setInt(1, tong);

				prepare.setString(2, ma);

				prepare.executeUpdate();

				menuDisplayTotal();

				menuShowOrderData();
				if (!banhang_tkt.getText().isEmpty()) {
					amount = new BigDecimal(banhang_tkt.getText());

					if (totalP == null) {
						menuRestart();
					} else {
						change = amount.subtract(totalP);
						banhang_ttl.setText(change + "đ");
					}
				}
				if (totalP == null) {
					menuRestart();
				}

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

	private BigDecimal amount = new BigDecimal(0);
	private BigDecimal change = new BigDecimal(0);

	// tính tiền trả lại
	public void menuAmount() {
		menuGetTotal();
		if (totalP == null || totalP.compareTo(BigDecimal.ZERO) == 0) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Khách chưa mua hàng :3");
			alert.showAndWait();
		} else if (banhang_tkt.getText().isEmpty()) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setContentText("Chưa Nhập tiền khách trả");
			alert.showAndWait();
		} else {
			try {

				amount = new BigDecimal(banhang_tkt.getText());

				if (amount.compareTo(totalP) < 0) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Khách Trả Thiếu");
					alert.showAndWait();
				} else {
					change = amount.subtract(totalP);
					banhang_ttl.setText(change + "đ");
				}
			} catch (NumberFormatException e) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("vui lòng nhập lại");
				alert.showAndWait();
			}
		}
	}

	// hiển thị tổng tiền
	public void menuDisplayTotal() {
		try {
			menuGetTotal();
			if (totalP == null) {
				banhang_tong.setText("0.0đ");
			} else
				banhang_tong.setText(totalP + "đ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ObservableList<hanghoadata> cardListData = FXCollections.observableArrayList();

	@Override
	public void performMainFunction() {
		menuDisplayCard();
		menuGetOrder();
		menuDisplayTotal();
		menuShowOrderData();
	}

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
				cardC.setMainFXMLListener(this);
				cardC.setData(cardListData.get(q));

				if (column == 5) {
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
	private int mhd = 0;

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

			} else if (cID == checkID) {
				cID += 1;

			} else if (cID < checkID) {
				cID = checkID + 1;
			}
			String sql1 = "SELECT MAX(ma_hoa_don)as max_ma_khach_hang FROM tbl_hoa_don";
			prepare = connect.prepareStatement(sql1);
			result = prepare.executeQuery();
			if (result.next()) {
				mhd = result.getInt("max_ma_khach_hang");
			}
			getData.mahoadon = mhd + 1;

			if (mhd == 0) {
				mhd += 1;
			}
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
			displaythunhaphomnay();
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
		String sql = "select count(tbl_hoa_don.ma_khach_hang) as ma from tbl_hoa_don,tbl_khach_hang Where tbl_khach_hang.ma_khach_hang=tbl_hoa_don.ma_khach_hang and DAY(tbl_hoa_don.ngay_xuat_hoa_don)="
				+ calendar.get(java.util.Calendar.DAY_OF_MONTH);
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
		int month = calendar.get(java.util.Calendar.MONTH) + 1;
		String sql = "SELECT sum(gia_tien) as ma FROM tbl_hoa_don where DAY(ngay_xuat_hoa_don)= " + dayOfMonth
				+ " and MONTH(ngay_xuat_hoa_don)=" + month;
		connect = database.connectdb();

		try {
			System.out.print(sql);
			BigDecimal ti = new BigDecimal("0");
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			if (result.next()) {
				ti = result.getBigDecimal("ma");
			}
			if (ti == null)
				ti = new BigDecimal("0");
			homnay.setText(ti + "đ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void tongthunhap() {
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		java.util.Calendar calendar = java.util.Calendar.getInstance();

		int month = calendar.get(java.util.Calendar.MONTH) + 1;

		String sql = "SELECT sum(tong) as tong FROM tbl_khach_hang where tong in(SELECT DISTINCT tong  FROM tbl_khach_hang  INNER JOIN tbl_hoa_don ON tbl_khach_hang.ma_khach_hang=tbl_hoa_don.ma_khach_hang and MONTH(ngay_xuat_hoa_don)="
				+ month + ")";

		connect = database.connectdb();

		try {
			BigDecimal ti = new BigDecimal("0");
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			if (result.next()) {
				ti = result.getBigDecimal("tong");
			}
			thunhap.setText(ti + "đ");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void daban() {
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		int dayOfMonth = calendar.get(java.util.Calendar.DAY_OF_MONTH);

		String sql = "SELECT sum(so_luong_ban) as so FROM tbl_hoa_don where day(ngay_xuat_hoa_don)=" + dayOfMonth;

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

	public void inventoryTypeList2() {
		ObservableList<String> options = FXCollections.observableArrayList();
		String sql = " select ma_nha_cung_cap from tbl_nha_cung_cap  ";
		connect = database.connectdb();
		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			while (result.next()) {
				String name = result.getString("ma_nha_cung_cap");
				options.add(name);
			}

			hanghoa_ncc.setItems(options);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initialize1();
		displayUsername();
		timkiemhh();
		inventoryTypeList();
		timkiemhd();
		hienthidatahanghoa();
		inventoryTypeList1();
		inventoryTypeList2();
		menuDisplayCard();
		menuGetOrder();
		menuShowOrderData();
		menuDisplayTotal();

		hoadonData();

		daban();
		tongthunhap();
		displaynguoi();
		displaythunhaphomnay();

		dashboardIncomeChart();

	}

}
