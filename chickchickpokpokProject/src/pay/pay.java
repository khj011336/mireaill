package pay;

public class pay {

	//필드
	
	/*
	부킹카드에서 멤버정보, 예매정보 빼와서 멤버 CRUD 하나 새로 만들어서 DB로 전송하면 예약은 끝.
	결제에서 확인을 누르면 멤버쪽으로 전송
	결제를 하면 멤버 쪽에 저장
	필드 따와서 새로 만들면하면 됨(멤버쪽 저장할 필드와 예매 기차 저장할 필드)
	
	 */
	private String ID;
	private String PW; // USER 비밀번호, 결제할 때 필요?
	private int MyWallet;
	private int membership;
	
	private String trainId; 		
	private String trainName;		
	private int pkUser;
//	private int DrailCode;
//	private int ArailCode;
	private String DStation;
	private String AStation;
	private String userName;
	private int age;
	private int ageType;
	private int price;
	private int fullOrNot;
	private String DDate;
	private String DTime;
	private String ATime;
	private String PayDate;
	private String imgPath;
	private int seat;
	

	
	public pay() {}
	//
	public pay(String trainId, String trainName, String dStation, String aStation, String UserName, int price,
			String dDate, String dTime, String aTime, int seat) {
		this("", "", 0, 0, trainId, trainName, 0, dStation, aStation, UserName, 0, 0, price, 0, dDate, dTime, aTime, "", "", seat);
	}
	public pay(String trainId, String trainName, String dStation, String aStation, String UserName, int price,
			String dDate, String dTime, String aTime, int seat, String imgPath) {
		this("", "", 0, 0, trainId, trainName, 0, dStation, aStation, UserName, 0, 0, price, 0, dDate, dTime, aTime, "", imgPath, seat);
	}
	
	public pay(String iD, String pW, int myWallet, int membership, String trainId, String trainName, int pkUser,
			String dStation, String aStation, String userName, int age, int ageType, int price, int fullOrNot,
			String dDate, String dTime, String aTime, String payDate, String imgPath, int seat) {
		super();
		ID = iD;
		PW = pW;
		MyWallet = myWallet;
		this.membership = membership;
		this.trainId = trainId;
		this.trainName = trainName;
		this.pkUser = pkUser;
		DStation = dStation;
		AStation = aStation;
		this.userName = userName;
		this.age = age;
		this.ageType = ageType;
		this.price = price;
		this.fullOrNot = fullOrNot;
		DDate = dDate;
		DTime = dTime;
		ATime = aTime;
		PayDate = payDate;
		this.imgPath = imgPath;
		this.seat = seat;
	}
	//
	@Override
	public String toString() {
		return "pay [ID=" + ID + ", PW=" + PW + ", MyWallet=" + MyWallet + ", membership=" + membership + ", trainId="
				+ trainId + ", trainName=" + trainName + ", pkUser=" + pkUser + ", DStation=" + DStation + ", AStation="
				+ AStation + ", userName=" + userName + ", age=" + age + ", ageType=" + ageType + ", price=" + price
				+ ", fullOrNot=" + fullOrNot + ", DDate=" + DDate + ", DTime=" + DTime + ", ATime=" + ATime
				+ ", PayDate=" + PayDate + ", imgPath=" + imgPath + ", seat=" + seat + "]";
	}
	//
	public String getTrainId() {
		return trainId;
	}
	
	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getPkUser() {
		return pkUser;
	}
	public void setPkUser(int pkUser) {
		this.pkUser = pkUser;
	}
	public String getDStation() {
		return DStation;
	}
	public void setDStation(String dStation) {
		DStation = dStation;
	}
	public String getAStation() {
		return AStation;
	}
	public void setAStation(String aStation) {
		AStation = aStation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String UserName) {
		userName = UserName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAgeType() {
		return ageType;
	}
	public void setAgeType(int ageType) {
		this.ageType = ageType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFullOrNot() {
		return fullOrNot;
	}
	public void setFullOrNot(int fullOrNot) {
		this.fullOrNot = fullOrNot;
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
	public String getPayDate() {
		return PayDate;
	}
	public void setPayDate(String payDate) {
		PayDate = payDate;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public int getMyWallet() {
		return MyWallet;
	}
	public void setMyWallet(int myWallet) {
		MyWallet = myWallet;
	}
	public int getMembership() {
		return membership;
	}
	public void setMembership(int membership) {
		this.membership = membership;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
}
