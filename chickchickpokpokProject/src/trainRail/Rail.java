package trainRail;

import java.util.Date;

public class Rail {
	public static String RailNames[];
	private int railCode;
	private String location;
	private int priceOfThis;
	private int lengthOfThis;
	private String time;
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private String railName;
	private int railNumb;

	public int getRailCode() {
		return railCode;
	}

	public void setRailCode(int railCode) {
		this.railCode = railCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPriceOfThis() {
		return priceOfThis;
	}

	public void setPriceOfThis(int priceOfThis) {
		this.priceOfThis = priceOfThis;
	}

	public int getLengthOfThis() {
		return lengthOfThis;
	}

	public void setLengthOfThis(int lengthOfThis) {
		this.lengthOfThis = lengthOfThis;
	}

	public String getRailName() {
		return railName;
	}

	public void setRailName(String railName) {
		this.railName = railName;
	}

	public int getRailNumb() {
		return railNumb;
	}

	public void setRailNumb(int railNumb) {
		this.railNumb = railNumb;
	}

	Rail() {

	}
	public Rail( String location, int priceOfThis, int lengthOfThis, String railName) {
		super();
		this.railCode = -1;
		this.location = location;
		this.priceOfThis = priceOfThis;
		this.lengthOfThis = lengthOfThis;
		this.time = "0";
		this.railName = railName;
		this.railNumb = 0;
	}
	
	public Rail(int railCode, String location, int priceOfThis, int lengthOfThis, String time, String railName,
			int railNumb) {
		super();
		this.railCode = railCode;
		this.location = location;
		this.priceOfThis = priceOfThis;
		this.lengthOfThis = lengthOfThis;
		this.time = time;
		this.railName = railName;
		this.railNumb = railNumb;
	}

	@Override
	public String toString() {
		return "Rail [railCode=" + railCode + ", location=" + location + ", priceOfThis=" + priceOfThis
				+ ", lengthOfThis=" + lengthOfThis + ", time=" + time + ", railName=" + railName + ", railNumb="
				+ railNumb + "]";
	}

}
