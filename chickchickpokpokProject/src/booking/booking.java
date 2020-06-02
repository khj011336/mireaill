package booking;

import java.util.Date;


public class booking {
//	// trainRail.Rail.java
//	public static String RailNames[];
//	private int railCode; //pk
//	private int priceOfThis;
//	private int lengthOfThis;
//	private String time;
//	private String railName;
//	private int railNumb;
//	
//	// trainPack.Train.java
//	protected String trainID; // 기차식별 일련번호  //pk
//	protected String trainName; // 기차식별 일련번호
//	protected int averegeSpeed; // 기차별 평균속도
//	protected int price; // 기차 표가격
//	protected int seat; // 좌석 유무를 위한 배열 2차원배열로 사용예정
//	protected int maxSeat;// 기차별 최대좌석수
//	protected float length;
//	protected int RunOrNot;
//	protected String DRailCode; // 출발기차역코드
//	protected String ARailCode; // 도착기차역코드
//	protected String DDate; // Departure 출발(날자)
//	protected String DTime; // 출발(시간)
//	protected String aTime; // Arriving 도착(시간)
//	
//	// signUpPage.member.java
//	private int pkUser;
//	private String ID;
//	private String PW;
//	private String name;
//	private int gender;
//	private int age;
//	private String email;
//	private String phoneNumber;
//	private String address;
//	private Date birthday;
//	private Date joinDate;
//	private Date payDate;
//	private String Arailcode;
//	private String Drailcode;
//	private String DTime;
//	private int myWallet;
//	private String rank;
//	private int membership;
	
	public static final int TRAIN_MUGUNGHWA = 0; 
	public static final int TRAIN_SAEMAUL = 1;
	public static final int TRAIN_KTX = 3;
	public static final String[] TRAIN_NAME = { "MUGUNGHWA", "SAEMAUL", "KTX" };
	
	public static final String NONE = " 미정";
	//
	
	private String trainID; //조회담당
	private String trainName; // ktx, 무궁화?	
	private int pkUser; //조회담당
	private int DRailCode; // 출발기차역코드
	private int ARailCode; // 도착기차역코드
	private String DStation;
	private String AStation;
	private String name; // 유저이름
	private int age; // 유저나이? 
	private int ageType; // 성인/청소년/어린이 구분?
	private int price; // 가격
	private int seat; // 좌석
	private int fullOrNot; // 좌석 유무 //crud 1이 예약가능 3이 예약불가능
	private String DDate; // Departure 출발(날자)
	private String DTime; // 출발(시간)
	private String ATime; // Arriving 도착(시간)
	private String payDate; // 결제날자?
	private String imgPath;
	// boolean agreeCheck 동의? 
	
//	int railCode, String trainID, String trainName, int pkUser, String dRailCode,
//	String aRailCode, String dStation, String aStation, String name, int age, 
//	String ageType, int price, int seat, String dDate, String dTime,
//	String aTime, String payDate
	public booking() {}
	
	// 예약 카드 생성자
	public booking(String trainID, String trainName, String DStation, String AStation, String name, int price, 
					int seat, String DDate, String DTime, String ATime, String imgPath) {
		this.trainID = trainID;
		this.trainName = trainName;
		this.DStation = DStation;
		this.AStation = AStation;
		this.name = name;
		this.price = price;
		this.seat = seat;
		this.DDate = DDate;
		this.DTime = DTime;
		this.ATime = ATime;
		this.imgPath = imgPath;
	}
	
	public booking(String trainID, String trainName, int pkUser, int dRailCode, int aRailCode, String dStation,
			String aStation, String name, int age, int ageType, int price, int seat, int fullOrNot, String dDate,
			String dTime, String aTime, String payDate) {
		super();
		this.trainID = trainID;
		this.trainName = trainName;
		this.pkUser = pkUser;
		DRailCode = dRailCode;
		ARailCode = aRailCode;
		DStation = dStation;
		AStation = aStation;
		this.name = name;
		this.age = age;
		this.ageType = ageType;
		this.price = price;
		this.seat = seat;
		this.fullOrNot = fullOrNot;
		DDate = dDate;
		DTime = dTime;
		this.ATime = aTime;
		this.payDate = payDate;
	}



	//
	public String getTrainID() {
		return trainID;
	}
	public void setTrainID(String trainID) {
		this.trainID = trainID;
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
	public int getDRailCode() {
		return DRailCode;
	}
	public void setDRailCode(int dRailCode) {
		DRailCode = dRailCode;
	}
	public int getARailCode() {
		return ARailCode;
	}
	public void setARailCode(int aRailCode) {
		ARailCode = aRailCode;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
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
	public String getaTime() {
		return ATime;
	}
	public void setaTime(String aTime) {
		this.ATime = aTime;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
//	public static void main(String[] args) {
//		
//	}
	
	
	
}
