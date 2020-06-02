package trainContainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import admin.Admin;
import trainPack.Train;
import trainRail.Rail;

public class TrainContainer {
	private String DRailCode;
	private String ARailCode;
	private String TrainID;
	private int price;
	private String DDate;
	private String DTime;
	private String ATime;
	private int seat;
	private float length;
	Connection con;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setLength(float length) {
		this.length = length;
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

	public void setLength(int length) {
		this.length = length;
	}

	public TrainContainer() {

	}

	public TrainContainer(String dRailCode, String aRailCode, String trainID, int pirce, String dDate, String dTime,
			String aTime, int seat, float length) {
		super();
		DRailCode = dRailCode;
		ARailCode = aRailCode;
		TrainID = trainID;
		this.price = pirce;
		DDate = dDate;
		DTime = dTime;
		ATime = aTime;
		this.seat = seat;
		this.length = length;
	}

	@Override
	public String toString() {
		return "TrainContainer [DRailCode=" + DRailCode + ", ARailCode=" + ARailCode + ", TrainID=" + TrainID
				+ ", pirce=" + price + ", DDate=" + DDate + ", DTime=" + DTime + ", ATime=" + ATime + ", seat=" + seat
				+ ", length=" + length + "]";
	}

	

}
