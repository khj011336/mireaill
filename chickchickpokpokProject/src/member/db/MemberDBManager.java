package member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import admin.Admin;
import java.sql.Date;
import member.Member;

public class MemberDBManager {

	Connection con;

	public MemberDBManager(Connection con) {
		this.con = Admin.con;
	}
	// ��й�ȣ ��ȣȭ
	private static int KEY = 0x98765432;
	
	public static int xor(int input) {
		return input ^ KEY;
	}
	
	private static String PWencrypt(String inPW) {
		char xorPW[] = new char[inPW.length()];
		for (int i = 0; i < inPW.length(); i++) {
			int xorC = xor(inPW.charAt(i));
			xorPW[i] = (char) xorC;
		}
		return new String(xorPW);
	}

	private String PWdecrypt(String dbPW) {
		char xorPW[] = new char[dbPW.length()];
		for (int i = 0; i < dbPW.length(); i++) {
			int xorC = xor(dbPW.charAt(i));
			xorPW[i] = (char) xorC;
		}
		return new String(xorPW);
	}
	
	// ȸ�� ���� ���
	public static String LOGGED_IN = null;
	public static int LOGGED_IN_NUMBER = 0;
	// ȸ�� �α��� ����
	public boolean memberLogin(String id, String pw) {
		if( id == null || id.isEmpty() || pw == null || pw.isEmpty() ) {
			System.out.println("�α��� �Է� ����."); // UI���� �ʿ�
			return false;
		}
		if( con != null ) {
			String sql = "select * from member where id = ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				pw = PWencrypt(pw);
//				String strRs = rs.getString("pw");
//				String strPWdecrypt = PWdecrypt(strRs);
				if( rs.next() ) {
//					if( pw.equals(strPWdecrypt) ) {
					if( pw.equals(rs.getString("pw")) ) {
						LOGGED_IN = id;
						LOGGED_IN_NUMBER = rs.getInt("pk_user");
						System.out.println(id + "���� �α��� ����!");
						return true;
					} else {
						System.out.println("��ȣ�� Ʋ���ϴ�.");
						return false;
					}
				} else {
					System.out.println("���Ե��� �ʾҽ��ϴ�.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB ��� ����");
		}
		return false;
	}
	// ȸ�� �α׾ƿ� ó��
	public boolean memberLogout(String id) {
		if( id.equals(LOGGED_IN)) {
			// reset
			LOGGED_IN = null;
			LOGGED_IN_NUMBER = 0;
			return true;
		} else {
			System.out.println("�α׾ƿ� ����");
			return false;
		}
	}
	// ȸ�� ���̵� �ߺ� üũ
	public int isDuplicatedMember(String id) {
		if( con != null ) // ���� �����϶���... 
		{
			String sql = 
				"select * from member where id = '"+id+"'";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				//while(rs.next()) { // ������ڵ尡 �ִ���?
				if( rs.next() == true ) {
					return 1;
				} else {					
					System.out.println(id + " ��밡���� id��!");
					return 0;
				}
			} catch (SQLException e) {				
				e.printStackTrace();
				return 2;
			}
		} else {
			System.out.println("���� ����!!");
			return 3;
		}
	}
	// ȸ�� (���ڵ�) ����
	public boolean insertNewMemberByAutoPk_user(Member mb) {
		if( mb == null ) {
			System.out.println("�Է� ȸ����ü null!");
			return false;
		}
		if( con != null ) {
			String sql = "insert into member values(mirail_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate,null,null,null,null,0,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mb.getID());
				String strPWencrypt = PWencrypt(mb.getPW());
				pstmt.setString(2, strPWencrypt);
				pstmt.setString(3, mb.getName());
				pstmt.setInt(4, mb.getGender());
				pstmt.setInt(5, mb.getAge());
				pstmt.setString(6, mb.getEmail());
				pstmt.setString(7, mb.getPhoneNumber());
				pstmt.setString(8, mb.getAddress());
				pstmt.setString(9, mb.getBirthday());
				pstmt.setString(10, mb.getRank());
				pstmt.setInt(11, mb.getMembership());
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println(mb.getID() +	" ȸ�� ���� ����! - pstmt");
					return true;
				} else
					System.out.println(mb.getID() +	" ȸ�� ���� ����... - pstmt");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("���� ����!!");
		}
		return false;
	}
	// ȸ�� ����Ʈ ��ȸ
	public Member selectOneMemberByID(String LOGGED_IN) {
		String sql = "select * from member where id= '"+LOGGED_IN+"'";
		if( con != null ) {
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql); 
				while ( rs.next() == true ) {
					int pkUser = rs.getInt("pk_user");
					String ID = rs.getString("id");
					String pw = rs.getString("pw");
					pw = PWdecrypt(pw);
					String name = rs.getString("name");
					int gender = rs.getInt("gender");
					int age = rs.getInt("age");
					String email = rs.getString("email");
					String phoneNumber = rs.getString("phonenumber");
					String address = rs.getString("address");
					String birthday = rs.getString("birthday");
					String joinDate = rs.getString("join_date");
					String payDate = rs.getString("pay_date");
					String Arailcode = rs.getString("a_rail_code");
					String Drailcode = rs.getString("d_rail_code");
					String DTime = rs.getString("d_time");
					int myWallet = rs.getInt("my_wallet");
					String rank = rs.getString("rank");
					int membership = rs.getInt("membership");
					System.out.printf("ȸ�� ���ڵ�: %d. %s\n %s %s %d��\n", pkUser, ID, name, gender==1?"����":"����", age);
					System.out.printf("�̸���: %s\n", email);
					System.out.printf("����ó: %s\n", phoneNumber);
					System.out.printf("�ּ�: %s\n", address);
					System.out.printf("����: %s\n", birthday);
					System.out.printf("���: %s\n", rank);
					System.out.printf("����Ʈ: %d\n", membership);
					String[] JDArr = joinDate.split("/");
					String strPkUser = "";
					for (int i = 0; i < JDArr.length; i++) {
						strPkUser += JDArr[i];
					}
					pkUser += Integer.parseInt(strPkUser); 
					Member mb = new Member(pkUser, ID, pw, name, gender, age, email, phoneNumber, address, birthday, joinDate, payDate, Arailcode, Drailcode, DTime, myWallet, rank, membership);
					return mb;
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} else {
			System.out.println("���� ����!!");
		}
		return null;
	}
	// ȸ������ ������Ʈ
	public boolean updateMemberInfo(String id, String name, int gender, int age, String email, String phoneNumber, String address, String birthday) {
		if( id == null || id.isEmpty() ) {
			System.out.println("id ������ ����!");
			return false;
		}
		if( con != null ) {
			String sql = "update member set name=?, gender=?, age=?, email=?, phonenumber=?, address=?, birthday=? where id=?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, gender);
				pstmt.setInt(3, age);
				pstmt.setString(4, email);
				pstmt.setString(5, phoneNumber);
				pstmt.setString(6, address);
				pstmt.setString(7, birthday);
				pstmt.setString(8, id);
				int r = pstmt.executeUpdate();				
				if( r == 1 ) {
					System.out.println( id + " ȸ������ ���� ����!");
					return true;
				} else {
					System.out.println( id + " ȸ������ ���� ����!");
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		} else {
			System.out.println("���� ����!!");
		}
		return false;
	}
	// ȸ�� ��й�ȣ ������Ʈ
	public boolean updateMemberPW(String id, String pw) {
		if( id == null || id.isEmpty() ) {
			System.out.println("id ������ ����!");
			return false;
		}
		final String notAllowed = "*^$-+~";
		if( pw == null || pw.isEmpty() || pw.length() == 8) { // pw 8�ڸ�
			System.out.println("pw ������ ����!");
			return false;						
		} else {
			for (int i = 0; i < pw.length(); i++) {
				char c = pw.charAt(i);
				//if( notAllowed.contains(c) ) {
				if( notAllowed.indexOf(c) != -1 ) {
					System.out.println("pw ������ ����! - �������ʴ� ���� ����");
					return false;
				}
			}
		}
		if( con != null ) {
			String sql = "update member set pw=? where id=?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				String strPWencrypt = PWencrypt(pw);
				pstmt.setString(1, strPWencrypt);
				pstmt.setString(2, id);
				int r = pstmt.executeUpdate();				
				if( r == 1 ) {
					System.out.println( id + " ��й�ȣ ���� ����!");
					return true;
				} else {
					System.out.println( id + " ��й�ȣ ���� ����!");
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		} else {
			System.out.println("���� ����!!");
		}
		return false;
	}
	// ȸ�� ����
	public boolean deleteOneMember(String pw) {
		if( con != null ) {
			String sql = "delete from member where pw = ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				String strPWencrypt = PWencrypt(pw);
				pstmt.setString(1, strPWencrypt);
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println(pw + " ȸ�� ���� ����!");
					return true;
				} else {
					System.out.println(pw + " ȸ�� ���� ����!");
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}	
		} else {
			System.out.println("���� ����!!");
		}
		return false;
	}
	// Ȱ������Ʈ ����
	// family 0~1000	1% ����
	// silver 1000~2000	3% ����
	// gold 2000~5000	5% ����
	// premium 5000		10% ����
	public void selectMembershipPoint(String id) {
		if( con != null ) {
			String sql = "select membership from where id = '"+id+"'";
			try {
				Statement stmt = con.createStatement();
//				stmt
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("���� ����!!");
		}
	}
	
	public void  updateMembershipPoint(String id, int membership) {
		if( id != null && !id.isEmpty() && membership > 0 )
		if( con != null ) {
			Member mb = selectOneMemberByID(id);
			int mbPoint = mb.getMembership();
			mbPoint += membership;
			String sql = "update member set membership = ? where id = ?";
			try {
				PreparedStatement pstmt	= con.prepareStatement(sql);
				pstmt.setFloat(1, mbPoint);
				pstmt.setString(2, id);
				int r = pstmt.executeUpdate();
				if( r == 1 ) System.out.println( id + "ȸ�� membership ���� ����!");
				else System.out.println( id + "ȸ�� membership ���� ����...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("���� ����!!");
		}
	}
}
