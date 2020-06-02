package pay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import member.Member;


public class PayDBMgr {
	// utilȭ �Ҷ� properties �̿��Ͽ� ������ ����
		public static final String USER = "java";
		public static final String PW = "1234";
		public static final String URL
		// = "jdbc:oracle:thin@192.168.0.1:1521:xe";
		// = "jdbc:oracle:thin@127.0.0.1:1521:xe";
				= "jdbc:oracle:thin:@localhost:1521:xe";
		// = "jdbc:oracle:thin@192.168.0.119:1521:xe";
		// = "jdbc:oracle:thin@�ּ�:��Ʈ:xe";
		// = "jdbc:oracle:thin@�ּ�:��Ʈ:orcl";
		public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
		public static Connection con;


		public static void main(String[] args) {
			connectDB();
			
			
			closeDB();
		}
		
		public static void connectDB() {
			//
			try {
				// ����̹� Ŭ������ �̸� �޸𸮿� �ε�
				Class.forName(DRIVER_NAME);
				// Connection con
				con = DriverManager.getConnection(URL, USER, PW);
				System.out.println("DB���� ���� ����!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB���� ���� ����!");
				e.printStackTrace();
			}
		}

		// DB ���� ���� ����
		public static void closeDB() {
			if (con != null) { // ���� ����� ���¶��..
				try {
					con.close();
					System.out.println("DB ���� ����!!");
				} catch (SQLException e) {
					System.out.println("DB ���� ����!!");
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
					System.out.println(pay.getUserName() + " ȸ�� ��ȸ �Ϸ�");
					return true;
				} else {
					System.out.println(pay.getUserName() + " ȸ�� ��ȸ ���� ");
					return false;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("��� �ҷ�.");
		}
		return false;
	}
	
	// ��� ���̵�, ��й�ȣ, ����� ��ȣ�� ����ȸ�� ��ȸ
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
//			System.out.println("���� ����");
//		}
//	
//	}
}
