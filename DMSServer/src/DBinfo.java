

public class DBinfo {
	static final String DRIVER_NAME = "mysql";
	static final String HOSTNAME = "wehatejava.czztgstzacsv.us-east-1.rds.amazonaws.com";
	static final String PORT = "3306";
	static final String DB_NAME = "Prototype";													//DB이름
	static final String USER_NAME = "admin"; 													//DB에 접속할 사용자 이름을 상수로 정의
	static final String PASSWORD = "En2i3oHKLGh9UlnbYFP1"; 										//사용자의 비밀번호를 상수로 정의
	static final String DB_URL = 
					"jdbc:" + 
					DRIVER_NAME + "://" + 
					HOSTNAME + ":" + 
					PORT + "/" + 
					DB_NAME + "?user=" + 
					USER_NAME + "&password=" + 
					PASSWORD; 
	
	public static String getDriverName() {
		return DRIVER_NAME;
	}
	public static String getHostname() {
		return HOSTNAME;
	}
	public static String getPort() {
		return PORT;
	}
	public static String getDbName() {
		return DB_NAME;
	}
	public static String getUserName() {
		return USER_NAME;
	}
	public static String getPassword() {
		return PASSWORD;
	}
	public static String getDbUrl() {
		return DB_URL;
	}
	
}
