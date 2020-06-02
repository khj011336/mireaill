package trainPack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



 public class Train   {
//Static int �߰� (�ڽ�Ŭ������) // �Ϸù�ȣ�� ��ġ���ƴ��ϰ�;
	protected String trainID; // �����ĺ� �Ϸù�ȣ
	protected String trainName; // �����ĺ� �Ϸù�ȣ
	protected int averegeSpeed; // ������ ��ռӵ�
	protected int price; // ���� ǥ����
	protected int seat; // �¼� ������ ���� �迭 2�����迭�� ��뿹��
	protected int maxSeat;// ������ �ִ��¼���
	protected float length;
	protected int RunOrNot;
	protected String DRailCode; // ��߱������ڵ�
	protected String ARailCode; // �����������ڵ�
	protected String DDate; // Departure ���(����)
	protected String DTime; // ���(�ð�)
	protected String Atime; // Arriving ����(�ð�)
	
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
			System.out.println("�߸��� ��߳����Է�");
		} else {
			//DDate(DDate);
			System.out.println("��¥�Է¿Ϸ�");
		}
	}

	public String getDTime() {
		return DTime;
	}

	public void setDTime(String DTime) {
		if (DTime.contains("-") == false || DTime.isEmpty() || DTime.length() != 5) {
			System.out.println("�ùٸ��ð������־��ּ���");
		} else {
			//String dt = DTime(DTime);
			//diffOfMinutesA(dt);
			System.out.println("�ð��Է¿Ϸ�");
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
		String time = "��������";
		if (startDate.contains("-") == false || startDate.isEmpty() || startDate.length() != 10) {
			System.out.println("������ �Ǵ� ���ڸ� �Է����ּ���");
			time = "�߸��� ��߳����Է�";
			return time;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy��MM��dd��");
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
	 * HH-mm ���Ŀ� ���߾� String�������� �ð������޾� ��[0] ��[1] ���� �����迭�� ����
	 */
// (����Ž����)
	public String DTime(String startTime) {
		String textDate = startTime;

		String time = "��������";
		String time1 = "��������";
		if (startTime.contains("-") == false || startTime.isEmpty() || startTime.length() != 5) {
			System.out.println("������ �Ǵ� �ð��� �Է����ּ���");
			String s = "�߸�����������Է�";
			return s;
		} else {
			SimpleDateFormat format = new SimpleDateFormat("HH-mm");
			SimpleDateFormat format1 = new SimpleDateFormat("HH��mm��");

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
//	�Ÿ� = �ӷ� * �ð�
//			�ӷ� = �ð� / �Ÿ�
//			�ð� = �Ÿ� / �ӷ�
		 // km???(�뼱Ŭ����)
		

		Float timeR = length / averegeSpeed;
		System.out.println(length+"lengtth"+averegeSpeed+"averege");
		int hour = (int) length / (int) averegeSpeed;
		float result = timeR - hour;
		int min = (int) (result * 60);
		String beginTime = dtime;
		if (beginTime != null) {
			String timeToString = beginTime.substring(0, 2);
			String timeToString2 = beginTime.substring(3, 5);
			System.out.println(timeToString+"diffofM��");
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
			System.out.println("��߽ð� : " + beginTime);
			System.out.println("�����ð� : " + endTime);
			System.out.println("�ҿ�ð� : �� , " + result1 + "�� �Ŀ� ���������Դϴ�.");
		} else {
			System.out.println("�����ð� �ʱ�ȭ ���� ��߽ð�Ȯ�ιٶ�");
		}

	}

}
