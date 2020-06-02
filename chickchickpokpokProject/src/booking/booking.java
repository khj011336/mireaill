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
//	protected String trainID; // �����ĺ� �Ϸù�ȣ  //pk
//	protected String trainName; // �����ĺ� �Ϸù�ȣ
//	protected int averegeSpeed; // ������ ��ռӵ�
//	protected int price; // ���� ǥ����
//	protected int seat; // �¼� ������ ���� �迭 2�����迭�� ��뿹��
//	protected int maxSeat;// ������ �ִ��¼���
//	protected float length;
//	protected int RunOrNot;
//	protected String DRailCode; // ��߱������ڵ�
//	protected String ARailCode; // �����������ڵ�
//	protected String DDate; // Departure ���(����)
//	protected String DTime; // ���(�ð�)
//	protected String aTime; // Arriving ����(�ð�)
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
	
	public static final String NONE = " ����";
	//
	
	private String trainID; //��ȸ���
	private String trainName; // ktx, ����ȭ?	
	private int pkUser; //��ȸ���
	private int DRailCode; // ��߱������ڵ�
	private int ARailCode; // �����������ڵ�
	private String DStation;
	private String AStation;
	private String name; // �����̸�
	private int age; // ��������? 
	private int ageType; // ����/û�ҳ�/��� ����?
	private int price; // ����
	private int seat; // �¼�
	private int fullOrNot; // �¼� ���� //crud 1�� ���డ�� 3�� ����Ұ���
	private String DDate; // Departure ���(����)
	private String DTime; // ���(�ð�)
	private String ATime; // Arriving ����(�ð�)
	private String payDate; // ��������?
	private String imgPath;
	// boolean agreeCheck ����? 
	
//	int railCode, String trainID, String trainName, int pkUser, String dRailCode,
//	String aRailCode, String dStation, String aStation, String name, int age, 
//	String ageType, int price, int seat, String dDate, String dTime,
//	String aTime, String payDate
	public booking() {}
	
	// ���� ī�� ������
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
