package trainPack;

public class Mugunwha extends Train {
	public Mugunwha() {
		
	}


	public Mugunwha(int averegeSpeed, int seat, int maxSeat) {
		super("0", "무궁화호", averegeSpeed, 0 , seat, maxSeat, 0, 0, "미정", "미정", "미정", "미정", "미정");

	}


	public Mugunwha(String trainID, String trainName, int averegeSpeed, int price, int seat, int maxSeat, float length,
			int runOrNot, String dRailCode, String aRailCode, String dDate, String dTime, String atime) {
		this.trainID = trainID;
		this.trainName = trainName;
		this.averegeSpeed = averegeSpeed;
		this.price = price;
		this.seat = seat;
		this.maxSeat = maxSeat;
		this.length = length;
		RunOrNot = runOrNot;
		DRailCode = dRailCode;
		ARailCode = aRailCode;
		DDate = dDate;
		DTime = dTime;
		Atime = atime;
	}
	@Override
	public String toString() {
		return "Mugunwha [trainID=" + trainID + ", averegeSpeed=" + averegeSpeed + ", price=" + price + ", seat=" + seat
				+ ", maxSeat=" + maxSeat + ", DRailCode=" + DRailCode + ", ARailCode=" + ARailCode + ", DDate=" + DDate
				+ ", DTime=" + DTime + ", Atime=" + Atime + "]";
	}
	
}
