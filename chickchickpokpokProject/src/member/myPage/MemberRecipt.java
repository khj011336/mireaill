package member.myPage;

public class MemberRecipt {
 private int Pkuser;
 private String Dstation;
 private String Astation;
 private String Ddate;
 private String trainName;
 private int seat;
 private String Dtime;
 private String Atime;
public int getPkuser() {
	return Pkuser;
}
public void setPkuser(int pkuser) {
	Pkuser = pkuser;
}
public String getDstation() {
	return Dstation;
}
public void setDstation(String dstation) {
	Dstation = dstation;
}
public String getAstation() {
	return Astation;
}
public void setAstation(String astation) {
	Astation = astation;
}
public String getDate() {
	return Ddate;
}
public void setDate(String date) {
	this.Ddate = date;
}
public String getTrainName() {
	return trainName;
}
public void setTrainName(String trainName) {
	this.trainName = trainName;
}
public int getSeat() {
	return seat;
}
public void setSeat(int seat) {
	this.seat = seat;
}
public String getDtime() {
	return Dtime;
}
public void setDtime(String dtime) {
	Dtime = dtime;
}
public String getAtime() {
	return Atime;
}
public void setAtime(String atime) {
	Atime = atime;
}

@Override
public String toString() {
	return "MemberRecipt [Pkuser=" + Pkuser + ", Dstation=" + Dstation + ", Astation=" + Astation + ", date=" + Ddate
			+ ", trainName=" + trainName + ", seat=" + seat + ", Dtime=" + Dtime + ", Atime=" + Atime ;
}
public MemberRecipt( ) {
	
}
public MemberRecipt(int pkuser, String dstation, String astation, String date, String trainName, int seat, String dtime,
		String atime) {
	super();
	Pkuser = pkuser;
	Dstation = dstation;
	Astation = astation;
	this.Ddate = date;
	this.trainName = trainName;
	this.seat = seat;
	Dtime = dtime;
	Atime = atime;
}
 
}
