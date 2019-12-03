package controller.administrator;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.IOHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

//입사자 조회 및 관리
public class BoarderManageTabController implements Initializable 
{

	@FXML
    private Button allocate_button;

    @FXML
    private Button check_button;

    @FXML
    private TableView<?> check_placementHistory_tableview;

    @FXML
    private Button delete_button;

    @FXML
    private TextField delete_id_textfield;

    @FXML
    private TextField delete_semester_textfield;

    @FXML
    private TextField delete_roomNumber_textfield;

    @FXML
    private TextField delete_dormName_textfield;

    @FXML
    private Button insert_button;

    @FXML
    private TextField insert_id_textfield;

    @FXML
    private TextField insert_roomNumber_textfield;

    @FXML
    private TextField insert_semester_textfield;

    @FXML
    private TextField insert_seat_textfield;

    @FXML
    private TextField insert_mealType_textfield;

    @FXML
    private TextField insert_dormName_textfield;

    @FXML
    private DatePicker insert_exitDate_datepicker;

    @FXML
    private CheckBox insert_snore_checkbox;

    
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		System.out.println("입사자 조회 및 관리 새로고침됨");
		
		
	}
	
	//---------------------이벤트---------------------
	
	@FXML
    void on_allocate_button_actioned(ActionEvent event) 
	{
		System.out.println("입사자 조회 및 관리 : 입사자 등록(배정) 클릭됨");
		allocate();
    }

    @FXML
    void on_check_button_actioned(ActionEvent event) 
    {
    	System.out.println("입사자 조회 및 관리 : 조회 클릭됨");
    	checkBoarders();
    }

    @FXML
    void on_delete_button_actioned(ActionEvent event) 
    {
    	System.out.println("입사자 조회 및 관리 : 삭제 클릭됨");
    	deleteBoarder();
    }

    @FXML
    void on_insert_button_actioned(ActionEvent event) 
    {
    	System.out.println("입사자 조회 및 관리 : 등록 클릭됨");
    	insertBoarder();
    }
    
	//---------------------로직---------------------

    private void allocate()
    {
    	//입사자 등록(배정) 쿼리 요청
    }
    
    private void checkBoarders()
    {
    	//배정내역 테이블 조회 요청
    }
    
    private void deleteBoarder()
    {
    	String id = delete_id_textfield.getText();
    	String roomNumber = delete_roomNumber_textfield.getText();
    	String semester = delete_semester_textfield.getText();
    	String dormName = delete_dormName_textfield.getText();
    	
    	if(id == null || id.isEmpty())
    	{
    		//학번 비어있음
    		IOHandler.getInstance().showAlert("학번이 비어있습니다.");
    		return;
    	}
    	else if(roomNumber == null || roomNumber.isEmpty())
    	{
    		//호실 번호 비어있음
    		IOHandler.getInstance().showAlert("호실 번호가 비어있습니다.");
    		return;
    	}
    	else if(semester == null || semester.isEmpty())
    	{
    		//학기 없음
    		IOHandler.getInstance().showAlert("학기가 비어있습니다.");
    		return;
    	}
    	else if(dormName == null || dormName.isEmpty())
    	{
    		//생활관명이 없음
    		IOHandler.getInstance().showAlert("생활관명이 비어있습니다.");
    		return;
    	}
    	
    	//서버에 삭제 쿼리 요청 후 성공/실패여부 메시지로 알려주자.
		boolean isSucceed = true;
		if(isSucceed)
		{
			IOHandler.getInstance().showAlert("입사자 삭제에 성공하였습니다.");
			
			//선택한 항목들 클리어
			delete_id_textfield.setText(null);
			delete_roomNumber_textfield.setText(null);
			delete_semester_textfield.setText(null);
			delete_dormName_textfield.setText(null);
		}
		else
		{
			IOHandler.getInstance().showAlert("서류 삭제에 실패하였습니다.");
		}
    }
    
    private void insertBoarder()
    {
    	String id = insert_id_textfield.getText();
    	String roomNumber = insert_roomNumber_textfield.getText();
    	String semester = insert_semester_textfield.getText();
    	String dormName = insert_dormName_textfield.getText();
    	String seat = insert_seat_textfield.getText();
    	LocalDate exitDate = insert_exitDate_datepicker.getValue();
    	String mealType = insert_mealType_textfield.getText();
    	
    	if(id == null || id.isEmpty())
    	{
    		//학번 비어있음
    		IOHandler.getInstance().showAlert("학번이 비어있습니다.");
    		return;
    	}
    	else if(roomNumber == null || roomNumber.isEmpty())
    	{
    		//호실 번호 비어있음
    		IOHandler.getInstance().showAlert("호실 번호가 비어있습니다.");
    		return;
    	}
    	else if(semester == null || semester.isEmpty())
    	{
    		//학기 없음
    		IOHandler.getInstance().showAlert("학기가 비어있습니다.");
    		return;
    	}
    	else if(dormName == null || dormName.isEmpty())
    	{
    		//생활관명이 없음
    		IOHandler.getInstance().showAlert("생활관명이 비어있습니다.");
    		return;
    	}
    	else if(seat == null || seat.isEmpty())
    	{
    		//자리가 없음
    		IOHandler.getInstance().showAlert("자리가 비어있습니다.");
    		return;
    	}
    	else if(exitDate == null || exitDate.toString().isEmpty())
    	{
    		//퇴사예정일이 없음
    		IOHandler.getInstance().showAlert("퇴사예정일이 비어있습니다.");
    		return;
    	}
    	else if(mealType == null || mealType.isEmpty())
    	{
    		//몇일식이 없음
    		IOHandler.getInstance().showAlert("몇일식이 비어있습니다.");
    		return;
    	}
    	
    	//서버에 등록 쿼리 요청 후 성공/실패여부 메시지로 알려주자.
		boolean isSucceed = true;
		if(isSucceed)
		{
			IOHandler.getInstance().showAlert("입사자 등록에 성공하였습니다.");
			
			//선택한 항목들 클리어
			insert_id_textfield.setText(null);
			insert_roomNumber_textfield.setText(null);
			insert_semester_textfield.setText(null);
			insert_dormName_textfield.setText(null);
			insert_seat_textfield.setText(null);
			insert_exitDate_datepicker.setValue(null);
			insert_mealType_textfield.setText(null);
		}
		else
		{
			IOHandler.getInstance().showAlert("입사자 등록에 실패하였습니다.");
		}
    }
    
}