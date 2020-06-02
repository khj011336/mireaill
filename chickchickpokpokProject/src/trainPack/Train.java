package trainPack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



 public class Train   {
//Static int 추가 (자식클래스에) // 일련번호가 겹치지아니하게;
	protected String trainID; // 기차식별 일련번호
	protected String trainName; // 기차식별 일련번호
	protected int averegeSpeed; // 기차별 평균속도
	protected int price; // 기차 표가격
	protected int seat; // 좌석 유무를 위한 배열 2차원배열로 사용예정
	protected int maxSeat;// 기차별 최대좌석수
	protected float length;
	protected int RunOrNot;
	protected String DRailCode; // 출발기차역코드
	protected String ARailCode; // 도착기차역코드
	protected String DDate; // Departure 출발(날자)
	protected String DTime; // 출발(시간)
	protected String Atime; // Arriving 도착(시간)
	
	public float getLength() {
		return length;
	}

	public int getRunOrNot() {
		return RunOrNot;
	}

	public void setRunOrNot(int runOrNot) {
		RunOrNot = runOrNot;
	}

	public void setMaxSeat(int maxSeat) {
		this.maxSeat = maxSeat;
	}

	public void setLength(float length) {
		this.length = length;
	}
	public String getDRailCode() {
		return DRailCode;
	}

	public String getARailCode() {
		return ARailCode;
	}

	public void setARailCode(String aRailCode) {
		ARailCode = aRailCode;
	}

	public void setDRailCode(String DRailCode) {
		this.DRailCode = DRailCode;
	}

	public String getDDate() {
		return DDate;
	}

	public void setDDate(String DDate) {
		if (DDate.contains("-") == false || DDate.isEmpty() || DDate.length() != 10) {
			System.out.println("잘못된 출발날자입력");
		} else {
			//DDate(DDate);
			System.out.println("날짜입력완료");
		}
	}

	public String getDTime() {
		return DTime;
	}

	public void setDTime(String DTime) {
		if (DTime.contains("-") == false || DTime.isEmpty() || DTime.length() != 5) {
			System.out.println("올바른시간값을넣어주세요");
		} else {
			//String dt = DTime(DTime);
			//diffOfMinutesA(dt);
			System.out.println("시간입력완료");
		}

	}

	public String getAtime() {
		return Atime;
	}

	public void setAtime(String Atime) {
		this.Atime = Atime;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;

	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAveregeSpeed() {
		return averegeSpeed;
	}

	public void setAveregeSpeed(int averegeSpeed) {
		this.averegeSpeed = averegeSpeed;
	}

	public String getTrainID() {
		return trainID;
	}

	public void setTrainID(String trainID) {
		this.trainID = trainID;
	}

	public int getMaxSeat() {
		return maxSeat;
	}

	public Train() {
	}



	

	public Train(String trainID, String trainName, int averegeSpeed, int price, int seat, int maxSeat, float length,
			int runOrNot, String dRailCode, String aRailCode, String dDate, String dTime, String atime) {
		super();
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

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Override
	public String toString() {
		return "Train [maxSeat=" + maxSeat + ", DRailCode=" + DRailCode + ", DDate=" + DDate + ", DTime=" + DTime
				+ ", Atime=" + Atime + " price=" + price + ", averegeSpeed=" + averegeSpeed + ", trainID=" + trainID
				+ "]";
	}

	public String DDate(String startDate) {
		String textDate = startDate;
		String time = "정보없음";
		if (startDate.contains("-") == false || startDate.isEmpty() || startDate.length() != 10) {
			System.out.println("하이픈 또는 날자를 입력해주세요");
			time = "잘못된 출발날자입력";
			return time;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy년MM월dd일");
			try {
				Date date = format.parse(textDate);
				time = format1.format(date);
				DDate = time;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return time;
	}

	/*
	 * HH-mm 형식에 맞추어 String형식으로 시간값을받아 시[0] 일[1] 형식 정수배열로 리턴
	 */
// (맛집탐지견)
	public String DTime(String startTime) {
		String textDate = startTime;

		String time = "정보없음";
		String time1 = "정보없음";
		if (startTime.contains("-") == false || startTime.isEmpty() || startTime.length() != 5) {
			System.out.println("하이픈 또는 시간를 입력해주세요");
			String s = "잘못된출발정보입력";
			return s;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("HH-mm");
			SimpleDateFormat format1 = new SimpleDateFormat("HH시mm분");

			try {
				Date date = format.parse(textDate);
				time = format.format(date);
				time1 = format1.format(date);
				DTime = time1;
			} catch (ParseException e) {
				e.printStackTrace();

			}

		}
		return time;
	}

	public void diffOfMinutesA(String dtime ) {
//	거리 = 속력 * 시간
//			속력 = 시간 / 거리
//			시간 = 거리 / 속력
		 // km???(노선클래스)
		

		Float timeR = length / averegeSpeed;
		System.out.println(length+"lengtth"+averegeSpeed+"averege");
		int hour = (int) length / (int) averegeSpeed;
		float result = timeR - hour;
		int min = (int) (result * 60);
		String beginTime = dtime;
		if (beginTime != null) {
			String timeToString = beginTime.substring(0, 2);
			String timeToString2 = beginTime.substring(3, 5);
			System.out.println(timeToString+"diffofM쪽");
			Integer timeToHour = new Integer(timeToString);
			Integer timeToMin = new Integer(timeToString2);
			int Ahour = (timeToHour + hour);
			int Amin = (timeToMin + min);

			String endTime = String.format("%d-%d", Ahour, Amin);

			SimpleDateFormat formatter = new SimpleDateFormat("HH-mm");
			SimpleDateFormat format1 = new SimpleDateFormat("HH-mm");
			Date beginDate = null;
			Date endDate = null;

			try {
				beginDate = formatter.parse(beginTime);
				endDate = formatter.parse(endTime);

				Atime = format1.format(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			long result1 = (endDate.getTime() - beginDate.getTime()) / (60 * 1000);
			System.out.println("출발시간 : " + beginTime);
			System.out.println("도착시간 : " + endTime);
			System.out.println("소요시간 : 약 , " + result1 + "분 후에 도착예정입니다.");
		} else {
			System.out.println("도착시간 초기화 실패 출발시간확인바람");
		}

	}

}
