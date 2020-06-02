package viaRail;

import java.sql.Connection;

public class ViaRail {
	private int end;
	private int Dstart;
	private String DRailCode;
	private String ARailCode;
	private String TrainID;
	private int price;
	private String DDate;
	private String DTime;
	private String ATime;
	private int seat;
	public String getTrainName() {
		return TrainName;
	}
	public void setTrainName(String trainName) {
		TrainName = trainName;
	}
	public ViaRail(String trainName) {
		super();
		TrainName = trainName;
	}
	private float length;
	private String TrainName;
	public int getDstart() {
		return Dstart;
	}
	public void setDstart(int dstart) {
		Dstart = dstart;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public ViaRail() {
		
	}
	@Override
	public String toString() {
		return "ViaRail [end=" + end + ", start=" + Dstart  + ", DRailCode=" + DRailCode + ", ARailCode=" + ARailCode
				+ ", TrainID=" + TrainID + ", price=" + price + ", DDate=" + DDate + ", DTime=" + DTime + ", ATime="
				+ ATime + ", seat=" + seat + ", length=" + length + "]";
	}
	public ViaRail(int end, int start, String dRailCode, String aRailCode, String trainID, int price, String dDate,
			String dTime, String aTime, int seat, float length,String TrainName) {
		super();
		this.end = end;
		this.Dstart = start;
		DRailCode = dRailCode;
		ARailCode = aRailCode;
		TrainID = trainID;
		this.price = price;
		DDate = dDate;
		DTime = dTime;
		ATime = aTime;
		this.seat = seat;
		this.length = length;
		this.TrainName = TrainName;
	}
	public int getStart() {
		return Dstart;
	}
	public void setStart(int start) {
		this.Dstart = start;
	}
	public String getDRailCode() {
		return DRailCode;
	}
	public void setDRailCode(String dRailCode) {
		DRailCode = dRailCode;
	}
	public String getARailCode() {
		return ARailCode;
	}
	public void setARailCode(String aRailCode) {
		ARailCode = aRailCode;
	}
	public String getTrainID() {
		return TrainID;
	}
	public void setTrainID(String trainID) {
		TrainID = trainID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDDate() {
		return DDate;
	}
	public void setDDate(String dDate) {
		DDate = dDate;
	}
	public String getDTime() {
		return DTime;
	}
	public void setDTime(String dTime) {
		DTime = dTime;
	}
	public String getATime() {
		return ATime;
	}
	public void setATime(String aTime) {
		ATime = aTime;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}

}
