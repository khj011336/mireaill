package member;

import java.util.Date;

import member.db.MemberDBManager;

public class Member {
	private int pkUser;
	private String ID;
	private String PW;
	private String name;
	private int gender;
	private int age;
	private String email;
	private String phoneNumber;
	private String address;
	private String birthday;
	private String joinDate;
	private String payDate;
	private String Arailcode;
	private String Drailcode;
	private String DTime;
	private int myWallet;
	private String rank;
	private int membership;
	
	public int getPkUser() {
		return pkUser;
	}
	public void setPkUser(int pkUser) {
		this.pkUser = pkUser;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getArailcode() {
		return Arailcode;
	}
	public void setArailcode(String Arailcode) {
		this.Arailcode = Arailcode;
	}
	public String getDrailcode() {
		return Drailcode;
	}
	public void setDrailcode(String Drailcode) {
		this.Drailcode = Drailcode;
	}
	public String getDTime() {
		return DTime;
	}
	public void setDTime(String DTime) {
		this.DTime = DTime;
	}
	public int getMyWallet() {
		return myWallet;
	}
	public void setMyWallet(int myWallet) {
		this.myWallet = myWallet;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getMembership() {
		return membership;
	}
	public void setMembership(int membership) {
		this.membership = membership;
	}
	
	@Override
	public String toString() {
		return "Member [pkUser=" + pkUser + ", ID=" + ID + ", PW=" + PW + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", birthday=" + birthday + ", joinDate=" + joinDate + ", payDate=" + payDate + ", Arailcode="
				+ Arailcode + ", Drailcode=" + Drailcode + ", DTime=" + DTime + ", myWallet=" + myWallet + ", rank="
				+ rank + ", membership=" + membership + "]";
	}
	
	public Member() {}
	public Member(String iD, String pW, String name, int gender, int age, String email, String phoneNumber, String address, String birthday) {
		this(0, iD, pW, name, gender, age, email, phoneNumber, address, birthday, "", "", "", "", "", 0, "Family", 100);
	}
	public Member(int pkUser, String iD, String pW, String name, int gender, int age, String email, String phoneNumber,
			String address, String birthday, String joinDate, String payDate, String Arailcode, String Drailcode,
			String DTime, int myWallet, String rank, int membership) {
		super();
		this.pkUser = pkUser;
		ID = iD;
		PW = pW;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.birthday = birthday;
		this.joinDate = joinDate;
		this.payDate = payDate;
		this.Arailcode = Arailcode;
		this.Drailcode = Drailcode;
		this.DTime = DTime;
		this.myWallet = myWallet;
		this.rank = rank;
		this.membership = membership;
	}
	
}