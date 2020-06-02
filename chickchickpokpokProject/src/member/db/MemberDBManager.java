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
	// 비밀번호 암호화
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
	
	// 회원 정보 기억
	public static String LOGGED_IN = null;
	public static int LOGGED_IN_NUMBER = 0;
	// 회원 로그인 인증
	public boolean memberLogin(String id, String pw) {
		if( id == null || id.isEmpty() || pw == null || pw.isEmpty() ) {
			System.out.println("로그인 입력 오류."); // UI구현 필요
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
						System.out.println(id + "계정 로그인 성공!");
						return true;
					} else {
						System.out.println("암호가 틀립니다.");
						return false;
					}
				} else {
					System.out.println("가입되지 않았습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 오류");
		}
		return false;
	}
	// 회원 로그아웃 처리
	public boolean memberLogout(String id) {
		if( id.equals(LOGGED_IN)) {
			// reset
			LOGGED_IN = null;
			LOGGED_IN_NUMBER = 0;
			return true;
		} else {
			System.out.println("로그아웃 실패");
			return false;
		}
	}
	// 회원 아이디 중복 체크
	public int isDuplicatedMember(String id) {
		if( con != null ) // 접속 상태일때만... 
		{
			String sql = 
				"select * from member where id = '"+id+"'";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				//while(rs.next()) { // 결과레코드가 있느냐?
				if( rs.next() == true ) {
					return 1;
				} else {					
					System.out.println(id + " 사용가능한 id임!");
					return 0;
				}
			} catch (SQLException e) {				
				e.printStackTrace();
				return 2;
			}
		} else {
			System.out.println("접속 에러!!");
			return 3;
		}
	}
	// 회원 (레코드) 생성
	public boolean insertNewMemberByAutoPk_user(Member mb) {
		if( mb == null ) {
			System.out.println("입력 회원객체 null!");
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
					System.out.println(mb.getID() +	" 회원 가입 성공! - pstmt");
					return true;
				} else
					System.out.println(mb.getID() +	" 회원 가입 실패... - pstmt");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("접속 에러!!");
		}
		return false;
	}
	// 회원 리스트 조회
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
					System.out.printf("회원 레코드: %d. %s\n %s %s %d세\n", pkUser, ID, name, gender==1?"남성":"여성", age);
					System.out.printf("이메일: %s\n", email);
					System.out.printf("연락처: %s\n", phoneNumber);
					System.out.printf("주소: %s\n", address);
					System.out.printf("생일: %s\n", birthday);
					System.out.printf("등급: %s\n", rank);
					System.out.printf("포인트: %d\n", membership);
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
			System.out.println("접속 에러!!");
		}
		return null;
	}
	// 회원정보 업데이트
	public boolean updateMemberInfo(String id, String name, int gender, int age, String email, String phoneNumber, String address, String birthday) {
		if( id == null || id.isEmpty() ) {
			System.out.println("id 데이터 에러!");
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
					System.out.println( id + " 회원정보 갱신 성공!");
					return true;
				} else {
					System.out.println( id + " 회원정보 갱신 실패!");
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		} else {
			System.out.println("접속 에러!!");
		}
		return false;
	}
	// 회원 비밀번호 업데이트
	public boolean updateMemberPW(String id, String pw) {
		if( id == null || id.isEmpty() ) {
			System.out.println("id 데이터 에러!");
			return false;
		}
		final String notAllowed = "*^$-+~";
		if( pw == null || pw.isEmpty() || pw.length() == 8) { // pw 8자리
			System.out.println("pw 데이터 에러!");
			return false;						
		} else {
			for (int i = 0; i < pw.length(); i++) {
				char c = pw.charAt(i);
				//if( notAllowed.contains(c) ) {
				if( notAllowed.indexOf(c) != -1 ) {
					System.out.println("pw 데이터 에러! - 허용되지않는 문자 포함");
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
					System.out.println( id + " 비밀번호 변경 성공!");
					return true;
				} else {
					System.out.println( id + " 비밀번호 변경 실패!");
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		} else {
			System.out.println("접속 에러!!");
		}
		return false;
	}
	// 회원 삭제
	public boolean deleteOneMember(String pw) {
		if( con != null ) {
			String sql = "delete from member where pw = ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				String strPWencrypt = PWencrypt(pw);
				pstmt.setString(1, strPWencrypt);
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println(pw + " 회원 삭제 성공!");
					return true;
				} else {
					System.out.println(pw + " 회원 삭제 실패!");
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}	
		} else {
			System.out.println("접속 에러!!");
		}
		return false;
	}
	// 활동포인트 갱신
	// family 0~1000	1% 적립
	// silver 1000~2000	3% 적립
	// gold 2000~5000	5% 적립
	// premium 5000		10% 적립
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
			System.out.println("접속 에러!!");
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
				if( r == 1 ) System.out.println( id + "회원 membership 갱신 성공!");
				else System.out.println( id + "회원 membership 갱신 실패...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("접속 에러!!");
		}
	}
}
