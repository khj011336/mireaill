package pay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import member.Member;


public class PayDBMgr {
	// util화 할때 properties 이용하여 설정할 예정
		public static final String USER = "java";
		public static final String PW = "1234";
		public static final String URL
		// = "jdbc:oracle:thin@192.168.0.1:1521:xe";
		// = "jdbc:oracle:thin@127.0.0.1:1521:xe";
				= "jdbc:oracle:thin:@localhost:1521:xe";
		// = "jdbc:oracle:thin@192.168.0.119:1521:xe";
		// = "jdbc:oracle:thin@주소:포트:xe";
		// = "jdbc:oracle:thin@주소:포트:orcl";
		public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
		public static Connection con;


		public static void main(String[] args) {
			connectDB();
			
			
			closeDB();
		}
		
		public static void connectDB() {
			//
			try {
				// 드라이버 클래스를 미리 메모리에 로딩
				Class.forName(DRIVER_NAME);
				// Connection con
				con = DriverManager.getConnection(URL, USER, PW);
				System.out.println("DB서버 접속 성공!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB서버 접속 실패!");
				e.printStackTrace();
			}
		}

		// DB 서버 연결 종료
		public static void closeDB() {
			if (con != null) { // 현재 연결된 상태라면..
				try {
					con.close();
					System.out.println("DB 종료 성공!!");
				} catch (SQLException e) {
					System.out.println("DB 종료 실패!!");
					e.printStackTrace();
				}
			}
		}
	
	public boolean insertPayMember(pay pay) {
		if( con != null ) {
			String sql = "insert into pay_member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pay.getTrainId());
				pstmt.setString(2, pay.getTrainName());
				pstmt.setInt(3, pay.getPkUser());
				pstmt.setString(4, pay.getDStation());
				pstmt.setString(5, pay.getAStation());
				pstmt.setString(6, pay.getUserName());
				pstmt.setInt(7, pay.getAge());
				pstmt.setInt(8, pay.getAgeType());
				pstmt.setInt(9, pay.getPrice());
				pstmt.setInt(10, pay.getFullOrNot());
				pstmt.setString(11, pay.getDDate());
				pstmt.setString(12, pay.getDTime());
				pstmt.setString(13, pay.getATime());
				pstmt.setString(14, pay.getPayDate());
				pstmt.setString(15, pay.getImgPath());
				pstmt.setInt(16, pay.getSeat());
				pstmt.setInt(17, pay.getMembership());
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println(pay.getUserName() + " 회원 조회 완료");
					return true;
				} else {
					System.out.println(pay.getUserName() + " 회원 조회 실패 ");
					return false;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("통신 불량.");
		}
		return false;
	}
	
	// 멤버 아이디, 비밀번호, 멤버쉽 번호로 단일회원 조회
//	public pay selectOneMemberByIdPwMp(String ID, String PW, String MP) {
//		
//		if( con != null ) {
//			String sql = "select * from pay_member where id = ?, pw = ?, mp = ?";
//			try {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, ID);
//				pstmt.setString(2, PW);
//				pstmt.setString(3, MP);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("접속 에러");
//		}
//	
//	}
}
