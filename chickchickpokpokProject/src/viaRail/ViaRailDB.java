package viaRail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.Admin;
import admin.Admin.insertT;
import booking.BookingDBMgr;
import booking.booking;
import trainPack.Train;
import trainRail.Rail;

public class ViaRailDB {
	Connection con;
	String time;
	String remem;

	public ViaRailDB(Connection con) {
		this.con = con;
	}

	public void SetTrainViaScedule(String trainId, int DDRail, int AARail, String DDate, String DTime) {
		// 위에서 말한 selectallRail과 selectOneTrain 함수가 사용되는 함수
		Admin ad = new Admin();

		insertT adInner = ad.new insertT();
		ArrayList<Rail> rl = adInner.selectAllRail();
		for (Rail rail : rl) {
			System.out.println(rail);
		}
		System.out.println(rl.size());
		int DorA = 0 ;
		int AorD = 0;
		if(DDRail < AARail) {
			DorA = DDRail;
			AorD = AARail;
		}else if(DDRail > AARail) {
			DorA = AARail;
			AorD = DDRail;
		}
		for (int i = DorA; i < AorD; i++) {
		System.out.println(i+"반대순서");
			int DRail = rl.get(i).getRailCode();
		
			int Amax = 1;
			int Tpay = 0;
			int Tlenth = 0;
			int Startchecker = 1;
			Train tr = adInner.selectOneTrain(trainId);
			System.out.println(tr.getAveregeSpeed() + "스피드");

			System.out.println(tr);
			//
			System.out.println(DRail + "D레일코드");
			//
			if (AARail == (DRail)) {
				Amax = 0;
				System.out.println(Amax + "AMAX");
			}
			int ArailCode = rl.get((DRail - 1) + Amax).getRailCode();
			System.out.println(ArailCode + "A레일코드");
			if (DRail < ArailCode) {
				for (int o = DRail; o <= ArailCode; o++) {
					int price = rl.get((o - 1)).getPriceOfThis();
					int lenth = rl.get((o - 1)).getLengthOfThis();
					Tpay += price;
					Tlenth += lenth;

					if (Startchecker == 1) {
						Tpay = 0;
						Tlenth = 0;
					}
					Startchecker++;

				}
			} else {
				for (int o = ArailCode; o <= DRail; o++) {
					int price = rl.get((o - 1)).getPriceOfThis();
					int lenth = rl.get((o - 1)).getLengthOfThis();
					Tpay += price;
					Tlenth += lenth;

					if (Startchecker == 1) {
						Tpay = 0;
						Tlenth = 0;
					}
					Startchecker++;

				}

			}
			String day = DDate;
			String timeRemem = DTime;
			if (time == null) {
				time = timeRemem;
			} else {
				time = remem;
				System.out.println(time + "   갱신타임");
			}
			System.out.println(time + "  타임!");
			tr.setLength(Tlenth);
			tr.setPrice(Tpay);
			tr.DDate(day);
			String DT = tr.DTime(time);
			tr.diffOfMinutesA(DT); // TODO
			tr.setDRailCode(String.valueOf(DRail));
			tr.setARailCode(String.valueOf(ArailCode));
			remem = tr.getAtime();
			System.out.println(tr.getAtime() + "도착시간하단");
			System.out.println(tr.getARailCode() + "도착");
			System.out.println(tr.getDRailCode() + "출발");
//		String trainID, String trainName, int pkUser, int dRailCode, int aRailCode, String dStation,
//		String aStation, String name, int age, int ageType, int price, int seat, int fullOrNot, String dDate,
//		String dTime, String aTime, String payDate

			if (con != null) {
				String sql = "insert into viaRail values(?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement ptsmt = Admin.con.prepareStatement(sql);
					ptsmt.setInt(1, (DDRail + 1));
					ptsmt.setInt(2, AARail);
					ptsmt.setInt(3, Integer.parseInt(tr.getDRailCode()));
					ptsmt.setInt(4, Integer.parseInt(tr.getARailCode()));
					ptsmt.setString(5, tr.getTrainID());
					ptsmt.setInt(6, tr.getPrice());
					ptsmt.setString(7, tr.getDDate());
					ptsmt.setString(8, tr.getDTime());
					ptsmt.setString(9, tr.getAtime());
					ptsmt.setInt(10, tr.getSeat());
					ptsmt.setFloat(11, tr.getLength());
					ptsmt.setString(12, tr.getTrainName());
					ptsmt.executeUpdate();
					System.out.println("viaRail 업데이트완료");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("SetTrain쪽 통신불량");
			}
		}

	}

	public ArrayList<ViaRail> selectViaRailAtoB(String trainid) {
		ArrayList<ViaRail> vList = new ArrayList<ViaRail>();
		if (con != null) {
			try {
				String sql = "select * from viarail where trainId = ? order by Trainid,drailcode";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, trainid);
				pstmt.execute();
				ResultSet rs = pstmt.executeQuery(sql);
				while (rs.next()) {
					ViaRail vr = new ViaRail(rs.getInt("end"), rs.getInt("dstart"), rs.getString("drailcode"),
							rs.getString("arailcode"), rs.getString("trainid"), rs.getInt("price"),
							rs.getString("ddate"), rs.getString("dtime"), rs.getString("atime"), rs.getInt("seat"),
							rs.getFloat("length"), rs.getString("trainName"));
					vList.add(vr);
				}
				return vList;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("viaRailDb 통신불량");
		}
		return null;
	}

	public ArrayList<ViaRail> selectViaRailAtoB() {
		ArrayList<ViaRail> vList = new ArrayList<ViaRail>();
		if (con != null) {
			try {
				String sql = "select * from viarail ";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					ViaRail vr = new ViaRail(rs.getInt("end"), rs.getInt("dstart"), rs.getString("drailcode"),
							rs.getString("arailcode"), rs.getString("trainid"), rs.getInt("price"),
							rs.getString("ddate"), rs.getString("dtime"), rs.getString("atime"), rs.getInt("seat"),
							rs.getFloat("length"),rs.getString("trainname"));
					vList.add(vr);
				}
				return vList;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("viaRailDb 통신불량");
		}
		return null;
	}
//	public static void main(String[] agrs) {
//		ViaRailDB d = new ViaRailDB(new Admin().con);
//		d.SetTrainViaScedule("1", 1,2, "1995-11-11","15-31");
//	}
}
