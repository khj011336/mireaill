package booking;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import admin.Admin;
import admin.Admin.insertT;
import adminGui.TrainGu;
import member.Member;
import member.db.MemberDBManager;
import trainContainer.TrainContainer;
import trainPack.Train;

public class BookingDBMgr {
	Connection con;
	
	
	// 외부에서 통신객체가 잘 만들어져 주어짐..
	public BookingDBMgr(Connection con) {
		this.con = con;
	}
	
//	String trainID, String trainName, int pkUser, int dRailCode, int aRailCode, String dStation,
//	String aStation, String name, int age, int ageType, int price, int seat, int fullOrNot, String dDate,
//	String dTime, String aTime, String payDate
	
	public boolean insertNewMemberSeat(booking bk) {
//		Member mb = MemberDBManager.selectOneMemberByPk_user(id);
//		Admin ad = new Admin();
//		insertT it = ad.new insertT();
		// TODO		
		if( con != null ) {
			String sql = "insert into booking values(?, ?, ?, ?, ?, ?, ?, ?, ?, " + 
					"?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bk.getTrainID());
				pstmt.setString(2, bk.getTrainName());
				pstmt.setInt(3, bk.getPkUser());
				pstmt.setInt(4, bk.getDRailCode());
				pstmt.setInt(5, bk.getARailCode());
				pstmt.setString(6, bk.getDStation());
				pstmt.setString(7, bk.getAStation());
				pstmt.setString(8, bk.getName());
				pstmt.setInt(9, bk.getAge());
				pstmt.setInt(10, bk.getAgeType());
				pstmt.setInt(11, bk.getPrice());
				pstmt.setInt(12, bk.getSeat());
				pstmt.setInt(13, bk.getFullOrNot());
				pstmt.setString(14, bk.getDDate());
				pstmt.setString(15, bk.getDTime());
				pstmt.setString(16, bk.getaTime());
				pstmt.setString(17, bk.getPayDate());
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println(bk.getSeat() + " 좌석 배치 완료!");
					return true;
				} else System.out.println(bk.getSeat() + " 좌석 배치 실패!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("통신 장애");
		}
		return false;
	}
	//trainid, trainname 빼고 업데이트
		public  boolean updateMembers(int pkUser, int dRailCode, int aRailCode, String dStation, String aStation, String name, 
				int age, int ageType, int price, int seat, int fullOrNot, String dDate, String dTime, String aTime, String payDate,String trainid) {
			if( con != null ) {
				String sql = "update booking set pk_user = ?, drailcode = ?, arailcode = ?, dstation = ?,"
						+ "astation = ?, name = ?, age = ?, age_type = ?, price = ?, full_or_not = ?,"
						+ "d_date = ?, d_time = ?, a_time = ?, pay_date = sysdate where train_id = ? and seat = ? ";
				try {
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, pkUser);
					pstmt.setInt(2, dRailCode);
					pstmt.setInt(3, aRailCode);
					pstmt.setString(4, dStation);
					pstmt.setString(5, aStation);
					pstmt.setString(6, name);
					pstmt.setInt(7, age);
					pstmt.setInt(8, ageType);
					pstmt.setInt(9, price);
					//pstmt.setInt(10, seat);
					pstmt.setInt(10, fullOrNot);
					pstmt.setString(11, dDate);
					pstmt.setString(12, dTime);
					pstmt.setString(13, aTime);
					pstmt.setString(14, trainid);
					pstmt.setInt(15, seat);
					int r = pstmt.executeUpdate();
					System.out.println(r+"정보");
					if( r == 1 ) {
						System.out.println(pkUser + " 정보 갱신 성공!");
						return true;
					} else {
						System.out.println(pkUser + " 정보 갱신 실패");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else {
				System.out.println("접속 에러.");
			}
			return false;
		}
		
		public  ArrayList<booking> selectAllMembers(String id) {
		ArrayList<booking> ar = new ArrayList<booking>();
		String sql = "select * from booking where train_id = ? order by seat";
		if (con != null) { // 접속된 상태이면...
			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.execute();
				ResultSet rs = pstmt.executeQuery(sql); // 데이터 조회
				while (rs.next()) {
					booking bk = new booking(
					rs.getString("train_id"),
					rs.getString("train_name"),
					rs.getInt("pk_user"),
					rs.getInt("drailcode"),
					rs.getInt("arailcode"),
					rs.getString("dstation"),
					rs.getString("astation"),
					rs.getString("name"),
					rs.getInt("age"),
					rs.getInt("age_type"),
					rs.getInt("price"),
					rs.getInt("seat"),
					rs.getInt("full_or_not"),
					rs.getString("d_date"),
					rs.getString("d_time"),
					rs.getString("a_time"),
					rs.getString("pay_date")
					
					);
					ar.add(bk);
				}
				return ar;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("접속 에러!!");
		}
		return null;
	}
		public  ArrayList<booking> selectAllMembers(String dstation ,String nothing) {
			ArrayList<booking> ar = new ArrayList<booking>();
			String sql = "select * from booking where dstation = ? order by seat";
			if (con != null) { // 접속된 상태이면...
				try {
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, (String)dstation);
					pstmt.execute();
					ResultSet rs = pstmt.executeQuery(sql); // 데이터 조회
					while (rs.next()) {
						booking bk = new booking(
						rs.getString("train_id"),
						rs.getString("train_name"),
						rs.getInt("pk_user"),
						rs.getInt("drailcode"),
						rs.getInt("arailcode"),
						rs.getString("dstation"),
						rs.getString("astation"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getInt("age_type"),
						rs.getInt("price"),
						rs.getInt("seat"),
						rs.getInt("full_or_not"),
						rs.getString("d_date"),
						rs.getString("d_time"),
						rs.getString("a_time"),
						rs.getString("pay_date")
						
						);
						ar.add(bk);
					}
					return ar;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("접속 에러!!");
			}
			return null;
		}
		public  booking selectAllMembers(int pkuser) {
			String sql = "select * from booking where  pk_user = ? order by seat";
			booking bk;
			if (con != null) { // 접속된 상태이면...
				try {
					
					PreparedStatement pstmt = con.prepareStatement(sql);
				
					pstmt.setInt(1, pkuser);
					pstmt.execute();
					ResultSet rs = pstmt.executeQuery(sql); // 데이터 조회
					if (rs.next()) {
						 bk = new booking(
						rs.getString("train_id"),
						rs.getString("train_name"),
						rs.getInt("pk_user"),
						rs.getInt("drailcode"),
						rs.getInt("arailcode"),
						rs.getString("dstation"),
						rs.getString("astation"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getInt("age_type"),
						rs.getInt("price"),
						rs.getInt("seat"),
						rs.getInt("full_or_not"),
						rs.getString("d_date"),
						rs.getString("d_time"),
						rs.getString("a_time"),
						rs.getString("pay_date")
							
						);
						 return bk;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("접속 에러!!");
			}
			return null;
		}

}
	
	
