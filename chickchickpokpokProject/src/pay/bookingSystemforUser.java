package pay;

import java.sql.Connection;
import java.util.ArrayList;

import admin.Admin;
import viaRail.ViaRail;
import viaRail.ViaRailDB;

public class bookingSystemforUser {
	private Connection con;
	private String trainid;
	private int drailcode;
	private int arailcode;
	private String ddate;
	private String dtime;
	private String atime;
	private int pay;
	private int length;

	public String getTrainid() {
		return trainid;
	}

	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}

	public int getDrailcode() {
		return drailcode;
	}

	public void setDrailcode(int drailcode) {
		this.drailcode = drailcode;
	}

	public int getArailcode() {
		return arailcode;
	}

	public void setArailcode(int arailcode) {
		this.arailcode = arailcode;
	}

	public String getDdate() {
		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

	public String getAtime() {
		return atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public bookingSystemforUser(Connection con) {
		this.con = con;
	}

	public bookingSystemforUser( Connection con ,String trainid, int drailcode, int arailcode, String ddate,
			String dtime, String atime, int pay, int length) {
		super();
		this.trainid = trainid;
		this.drailcode = drailcode;
		this.arailcode = arailcode;
		this.ddate = ddate;
		this.dtime = dtime;
		this.atime = atime;
		this.pay = pay;
		this.length = length;
	}
	public bookingSystemforUser(  String trainid, int drailcode, int arailcode, String ddate,
			String dtime, String atime, int pay, int length) {
		super();
		this.trainid = trainid;
		this.drailcode = drailcode;
		this.arailcode = arailcode;
		this.ddate = ddate;
		this.dtime = dtime;
		this.atime = atime;
		this.pay = pay;
		this.length = length;
	}

	public bookingSystemforUser bookingAtoB( String Trainid, int drailcode, int arailcode) {
		ViaRailDB vr = new ViaRailDB(con);
		int Tlength = 0;
		int Tpay = 0;
		ArrayList<ViaRail> vrList = vr.selectViaRailAtoB(Trainid);
		System.out.println(vrList.size());
		System.out.println(vrList.size()+"vrsize");
		System.out.println(vrList.size());
		
		for (int i = drailcode ; i < arailcode; i++) {
			Tlength += vrList.get(i-1).getLength();
			System.out.println("ddddd"+i+vrList.get(i-1).getLength()+"ÅäÅ»±æÀÌ");
			Tpay += vrList.get(i-1).getPrice();
			System.out.println("ddddd"+vrList.get(i-1).getPrice()+"ÅäÅ»°¡°Ý");
		}
		
		
		
			
		System.out.println(Tpay+"µ·");
		System.out.println(Tlength+"°Å¸®");
	 String draildate  =	vrList.get(drailcode - 1).getDDate();
	String drailtime =	vrList.get(drailcode - 1).getDTime();
	String arailtime =	vrList.get(drailcode - 1).getATime();
		System.out.println(draildate);
		System.out.println(drailtime);
		System.out.println(arailtime);
		bookingSystemforUser bksf = new bookingSystemforUser(Trainid, drailcode, arailcode, draildate, drailtime, arailtime, Tpay, Tlength);
		return bksf;
	}

	@Override
	public String toString() {
		return "bookingSystemforUser [con=" + con + ", trainid=" + trainid + ", drailcode=" + drailcode + ", arailcode="
				+ arailcode + ", ddate=" + ddate + ", dtime=" + dtime + ", atime=" + atime + ", pay=" + pay
				+ ", length=" + length + "]";
	}

}
