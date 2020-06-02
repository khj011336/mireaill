package member.myPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.Admin;

public class MemberReciptDBMgr {
	Connection  con;

	public MemberReciptDBMgr(Connection con) {
		this.con = con;
	}
	public boolean insertRecipt(MemberRecipt rc) {
		if(con!= null) {
			String sql = "insert into memberrecipt values(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, rc.getPkuser());
				pstmt.setString(2, rc.getDstation());
				pstmt.setString(3, rc.getAstation());
				pstmt.setString(4, rc.getDate());
				pstmt.setString(5, rc.getTrainName());
				pstmt.setInt(6, rc.getSeat());
				pstmt.setString(7, rc.getDtime());
				pstmt.setString(8, rc.getAtime());
				int r= pstmt.executeUpdate();
				if(r == 1) {
					return true;
				}else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("레십트 통신불량");
		}
		return false;
	}
	public ArrayList<MemberRecipt> GetRecipts(int pk) {
		ArrayList<MemberRecipt> mbrL = new ArrayList<MemberRecipt>();
		if(con!= null) {
			String sql = "select * from memberrecipt where pkuser =" +pk+" order by ddate";
			try {
				Statement pstmt= con.createStatement();
				ResultSet rc =pstmt.executeQuery(sql);
				while(rc.next()) {
					
				MemberRecipt mbr = new MemberRecipt(
				 rc.getInt("Pkuser"),
				rc.getString("dstation"),
				rc.getString("astation"),
				rc.getString("ddate"),
				rc.getString("trainname"),
				rc.getInt("seat"),
				rc.getString("dtime"),
				rc.getString("atime")
				);
				mbrL.add(mbr);
				}
				return mbrL;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("레십트 통신불량");
		}
		return null;
	}
//	public static void main(String[] args) {
//		Admin.connectTrainDB();
//		MemberRecipt rc = new MemberRecipt(1, "1", "1", "1", "1", 1, "1", "1");
//	
//		MemberReciptDBMgr r = new MemberReciptDBMgr(Admin.con);
//		r.insertRecipt(rc);
//		ArrayList<MemberRecipt>  z= r.GetRecipts(1);
//		System.out.println(z.toString());
//	}
 
}
 