package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/springproject";
	private String user = "atom";
	private String password = "1234";
	
	//싱글톤으로 conn객체를 만들어서 사용하기
	private static Connection conn; 
	//static - method 영역에 생성(method(프로그램이 실행되고 끝날때까지 살아있음)-stack(기본타입 올라감)-hip(참조타입 올라감-new로 생성) 3가지 영역)
	@SuppressWarnings("unused")//사용 안했다는 노란줄 에러 제거, 실제로는 사용됨(DBconnection() 호출)
	private static DBConnection instance = new DBConnection();
	
	//io,db,thread - 예외처리 필요
	private DBConnection() {
		try {
			Class.forName(driver); //예외처리 필요
			conn = DriverManager.getConnection(url, user, password); //io객체, 예외처리 필요
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 오류"+e.getMessage()); //driver 가 없는 상황 = lib의 커넥터
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패" + e.getMessage()); //url, user, password가 없는 상황
		}
	}
/*
	public static DBConnection getInstance() {
		return instance;
	}
*/
	public static Connection getConn() { // Connection을 호출할떄는 conn을 이용해서 호출하기 위해 getConn 작성
		return conn;
	}
	
	
	
}
