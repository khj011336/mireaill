package railmap;

public class rail {

	
	private String StationName;
	private String location;
	private String phoneNum;
	private String imgPath;
	
	public rail() {}
	public rail(String stationName, String location, String phoneNum, String imgPath) {
		super();
		StationName = stationName;
		this.location = location;
		this.phoneNum = phoneNum;
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "rail [StationName=" + StationName + ", location=" + location + ", phoneNum=" + phoneNum + ", imgPath="
				+ imgPath + "]";
	}
	public String getStationName() {
		return StationName;
	}
	public void setStationName(String stationName) {
		StationName = stationName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
}
