package booking;

public class Bookshow implements Comparable<Bookshow> {
	private String trainid;
	private String dtime;
	private String atime;
	private String dcodes;
	private String acodes;

	public Bookshow() {

	}

	public Bookshow(String trainid, String dtime, String atime, String dcodes, String acodes, int pay) {
		super();
		this.trainid = trainid;
		this.dtime = dtime;
		this.atime = atime;
		this.dcodes = dcodes;
		this.acodes = acodes;
		this.pay = pay;
	}

	public String getTrainid() {
		return trainid;
	}

	public void setTrainid(String trainid) {
		this.trainid = trainid;
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

	public String getDcodes() {
		return dcodes;
	}

	public void setDcodes(String dcodes) {
		this.dcodes = dcodes;
	}

	public String getAcodes() {
		return acodes;
	}

	public void setAcodes(String acodes) {
		this.acodes = acodes;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "Bookshow [trainid=" + trainid + ", dtime=" + dtime + ", atime=" + atime + ", dcodes=" + dcodes
				+ ", acodes=" + acodes + ", pay=" + pay + "]";
	}

	private int pay;

	@Override
	public int compareTo(Bookshow o) {
		 return this.getDtime().split("½Ã")[0].compareTo(o.getDtime().split("½Ã")[0]);
		
	}
}
