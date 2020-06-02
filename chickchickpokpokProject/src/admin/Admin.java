package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import trainContainer.TrainContainer;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import adminGui.TrainGu;
import booking.BookingDBMgr;
import booking.booking;
import pay.bookingSystemforUser;
import trainPack.KTX;
import trainPack.Mugunwha;
import trainPack.Sanuri;
import trainPack.Train;
import trainRail.Rail;
import viaRail.ViaRail;
import viaRail.ViaRailDB;

public class Admin {
	TrainGu train;
	public static Connection con;
	private static String USER = "admin1";
	private static String PW = "1234";
	public static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static int count = 0;

	public String getUSER() {
		return USER;
	}

	public void setUSER(String uSER) {
		USER = uSER;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

// private메소드는 관리자만 사용하고 나머지 유저와 공통적인 불필요한 중복함수를 줄이고 함수를 상속시키기위하여 protected 로 저장 private함수는 관리자 메인메소드에서만 사용가능 gui 만들시 현재 클래스  유저와 현재클래스안에서 구현
	public static void connectTrainDB() { // 유저와 관리자가 공유할 커넥트 DB포트

		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL, USER, PW);
			System.out.println("접속 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("접속 실패");
			e1.printStackTrace();
		}
	}

	public static void closeTrainDB() {
		if (con != null) {
			try {
				con.close();
				System.out.println("DB접속 종료");
			} catch (SQLException e) {
				System.out.println("DB종료 실패");
				e.printStackTrace();
			}

		}

	}

	public class insertT implements ActionListener {
		public insertT() {
			
		}
		private TrainGu oe;
		KTX ktx;
		Sanuri sanuri;
		Mugunwha mugun;
		JComboBox cob;

		public ArrayList<Train> tr;

		public insertT(TrainGu gu) {
			this.oe = gu;
			tr = new ArrayList<Train>();
			tr.addAll(selectAllTrain());
		}

		private void insertNewTrain(Train tr) { // 기차 객체를 DB에 생성하기위해서 만든 인섵트문 후에 레일객체의 length를 받아서 도착시간 소요시간 계산에 소요 또한
												// 각역의
												// 가격을 받아 계산하여
			// train container에 객체를 올리기위함

			if (con != null) {
				String sql = "insert into Train values(train_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, tr.getTrainName());
					pstmt.setInt(2, tr.getAveregeSpeed());
					pstmt.setInt(3, tr.getPrice());
					pstmt.setInt(4, tr.getSeat());
					pstmt.setInt(5, tr.getMaxSeat());
					pstmt.setFloat(6, tr.getLength());
					pstmt.setInt(7, tr.getRunOrNot());
					pstmt.setString(8, tr.getDRailCode());
					pstmt.setString(9, tr.getARailCode());
					pstmt.setString(10, tr.getDDate());
					pstmt.setString(11, tr.getDTime());
					pstmt.setString(12, tr.getAtime());
					int rs = pstmt.executeUpdate();
					if (rs == 1) {
						System.out.println("train 입력 완료");
					} else {
						System.out.println("train 입력 실패");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String behavior = (String) oe.getComboBox_2().getSelectedItem();
			if (e.getSource() instanceof JButton) {
				if (behavior == "기차추가") {
					int averegeSpeed = Integer.parseInt(oe.getAveregeSpeedT().getText());
					int seat = Integer.parseInt(oe.getMaxSeatT().getText());
					int maxSeat = Integer.parseInt(oe.getSeatT().getText());
					if (oe.getTrains().getSelectedItem() == "KTX") {
						ktx = new KTX(averegeSpeed, seat, maxSeat);

						for (int i = 0; i < 13; i++) {
							oe.btnArr.add(new JButton(""));
						}
						insertNewTrain(ktx);
						tr.add(ktx);
						ShowAllTrain(tr.size());
					} else if (oe.getTrains().getSelectedItem() == "Sanuri") {
						sanuri = new Sanuri(averegeSpeed, seat, maxSeat);
						insertNewTrain(sanuri);
						tr.add(sanuri);
						for (int i = 0; i < 13; i++) {
							oe.btnArr.add(new JButton(""));
						}
						ShowAllTrain(tr.size());
					} else if (oe.getTrains().getSelectedItem() == "Mugunwha") {
						mugun = new Mugunwha(averegeSpeed, seat, maxSeat);
						insertNewTrain(mugun);
						tr.add(mugun);
						for (int i = 0; i < 13; i++) {
							oe.btnArr.add(new JButton(""));
						}
						ShowAllTrain(tr.size());
					}
				} else if (behavior == "기차하나보기") {
					for (int i = 0; i < oe.btnArr.size(); i++) {
						oe.btnArr.get(i).setText("");
						oe.btnArr.get(i).setEnabled(false);
					}
					count = 0;
					Train tr = selectOneTrain(oe.getTextField().getText());
					oe.btnArr.get(count++).setText(tr.getTrainID());

					oe.btnArr.get((count++)).setText(tr.getTrainName());

					oe.btnArr.get(count++).setText(String.valueOf((tr.getAveregeSpeed())));

					oe.btnArr.get(count++).setText(String.valueOf((tr.getPrice())));

					oe.btnArr.get(count++).setText(String.valueOf((tr.getSeat())));

					oe.btnArr.get(count++).setText(String.valueOf((tr.getMaxSeat())));

					oe.btnArr.get(count++).setText(String.format("%f", tr.getLength()));

					oe.btnArr.get(count++).setText(String.valueOf(tr.getRunOrNot()));

					oe.btnArr.get(count++).setText(tr.getDRailCode());

					oe.btnArr.get(count++).setText(tr.getARailCode());

					oe.btnArr.get(count++).setText(tr.getDDate());
					oe.btnArr.get(count++).setText(tr.getDTime());
					oe.btnArr.get(count++).setText(tr.getAtime());
					oe.getPanel_2().setVisible(true);

				} else if (behavior == "기차전부보기") {
					ShowAllTrain(tr.size());
				} else if (behavior == "기차갱신") {

					updateTrain(oe.getUpdateNum(), oe.getUpdateValue(), oe.getUpdateTrainId());
					ShowAllTrain(tr.size());
					for (int i = 0; i < oe.btnArr.size(); i++) {
						oe.btnArr.get(i).setEnabled(true);
					}
					System.out.println("갱신완료");
				} else if (behavior == "기차삭제") {
					String tid = oe.getDelTEXT().getText();
//TODO 기차삭제	
					if (!tid.isEmpty()) {
						delTrain(tid);
					} else {

					}
				ShowAllTrain(tr.size());
				} else if (behavior == "레일추가") {
					int price = Integer.parseInt(oe.getRailTextPrice().getText());
					int length = Integer.parseInt(oe.getRailTextLength().getText());

					Rail rl = new Rail(oe.getRailTextLocation().getText(), price, length,
							oe.getRailTextRailName().getText());
					insertNewRail(rl);
				} else if (behavior == "레일하나보기") {
					Rail rl = selectOneRail(Integer.parseInt(oe.getRailCodeText().getText()));
					System.out.println("눌림");
					for (int j = 0; j < oe.getDft().getRowCount(); j++) {
						oe.getDft().removeRow(j);
					}


					oe.getDft().addRow(new Object[] { rl.getRailCode(), rl.getLocation(), rl.getPriceOfThis(),
							rl.getLengthOfThis(), rl.getTime(), rl.getRailName(), rl.getRailNumb() });
					oe.getTable().setModel(oe.getDft());

				} else if (behavior == "레일전부보기") {
					ArrayList<Rail> rl = selectAllRail();
					System.out.println(rl.size());
					System.out.println("눌림");
					 int size =oe.getDft().getRowCount();
					for (int j = 0; j < size; j++) {
						oe.getDft().removeRow(0);
					}
					for (int i = 0; i < rl.size(); i++) {
						oe.getDft()
								.addRow(new Object[] { rl.get(i).getRailCode(), rl.get(i).getLocation(),
										rl.get(i).getPriceOfThis(), rl.get(i).getLengthOfThis(), rl.get(i).getTime(),
										rl.get(i).getRailName(), rl.get(i).getRailNumb() });
					}
					oe.getTable().setModel(oe.getDft());
				} else if (behavior == "레일삭제") {
					// TODO 레일삭제
					//delRail(railNumb);
				} else if (behavior == "기차스케쥴셋업") {


					//TODO
					String ID = (String) oe.getSetUpTrainID().getSelectedItem();
					String Drail = (String) oe.getSetupDrailcode().getSelectedItem();
					String Arail = (String) oe.getSetupArailcode().getSelectedItem();
					String DR = Drail.split("-")[1];
					System.out.println(DR);
					String AR = Arail.split("-")[1];
					System.out.println(AR);
					String Id = ID.split("-")[0];
					System.out.println(Id);
					System.out.println("날자" + oe.getSetupDDateTxt().getText() + "시간" + oe.getSetupDtimeTxt().getText());
					
					SetTrainScedule(Id, Integer.parseInt(DR), Integer.parseInt(AR), oe.getSetupDDateTxt().getText(),
							oe.getSetupDtimeTxt().getText());

				} else if (behavior == "스케쥴전부보기") {
					ArrayList<TrainContainer> tc = selectAllTrainScedule();
					int size = oe.getDft1().getRowCount();
					for (int j = 0; j < size; j++) {
						oe.getDft1().removeRow(0);
						 
					}
					for (int i = 0; i < tc.size(); i++) {
						System.out.println(tc.get(i).toString());
						tc.get(i).getPrice();
						oe.getDft1().addRow(new Object[] { tc.get(i).getDRailCode(), tc.get(i).getARailCode(),
								tc.get(i).getTrainID(), tc.get(i).getPrice(), tc.get(i).getDDate(),
								tc.get(i).getDTime(), tc.get(i).getATime(), tc.get(i).getSeat(), tc.get(i).getLength()

						});
						
					}
					oe.getTable_1().setModel(oe.getDft1());
				} else if (behavior == "스케쥴변경") {

				} else if (behavior == "스케쥴삭제") {
				
					//deletOneScedule(TrainID);
					ArrayList<TrainContainer> tc = selectAllTrainScedule();
					int size = oe.getDft1().getRowCount();
					for (int j = 0; j < size; j++) {
						oe.getDft1().removeRow(0);
						 
					}
					for (int i = 0; i < tc.size(); i++) {
						System.out.println(tc.get(i).toString());
						tc.get(i).getPrice();
						oe.getDft1().addRow(new Object[] { tc.get(i).getDRailCode(), tc.get(i).getARailCode(),
								tc.get(i).getTrainID(), tc.get(i).getPrice(), tc.get(i).getDDate(),
								tc.get(i).getDTime(), tc.get(i).getATime(), tc.get(i).getSeat(), tc.get(i).getLength()

						});
						
					}
					oe.getTable_1().setModel(oe.getDft1());
					//if(train)
					//deletOneScedule(TrainID);
				}

			} // else if (e.getSource() instanceof JComboBox) {
//				cob = (JComboBox) e.getSource();
//				if(cob.getModel().getSelectedItem() == "기차갱신") {
//			
//				}
//				oe.panel_1.setVisible(true);
//			
//			}
		}

		public void ShowAllTrain(int max) {

			for (int i = 0; i < oe.btnArr.size(); i++) {
			
				oe.btnArr.get(i).setText("");
				oe.btnArr.get(i).setBackground(Color.WHITE);
				oe.btnArr.get(i).setEnabled(false);
			}
			tr = new ArrayList<Train>();
			tr.addAll(selectAllTrain());
			if(max != tr.size()) {
				max = tr.size();
			}
			count = 0;
			for (int i = 0; i < max; i++) {
				oe.btnArr.get(count++).setText(tr.get(i).getTrainID());
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get((count++)).setText(tr.get(i).getTrainName());
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(String.valueOf((tr.get(i).getAveregeSpeed())));
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(String.valueOf((tr.get(i).getPrice())));
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(String.valueOf((tr.get(i).getSeat())));
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(String.valueOf((tr.get(i).getMaxSeat())));
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(String.format("%.2f", tr.get(i).getLength()));
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(String.valueOf(tr.get(i).getRunOrNot()));
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(tr.get(i).getDRailCode());
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(tr.get(i).getARailCode());
				oe.getPanel_2().add(oe.btnArr.get(count - 1));

				oe.btnArr.get(count++).setText(tr.get(i).getDDate());
				oe.getPanel_2().add(oe.btnArr.get(count - 1));
				oe.btnArr.get(count++).setText(tr.get(i).getDTime());
				oe.getPanel_2().add(oe.btnArr.get(count - 1));
				oe.btnArr.get(count++).setText(tr.get(i).getAtime());
				oe.getPanel_2().add(oe.btnArr.get(count - 1));
			}

			oe.getPanel_2().setVisible(true);
		}

		// ID로 기차찾기 - 맛집탐지견
		public Train selectOneTrain(String trainId) { // 이 함수로 DB에 저장된 특정 기차객체를 따와 TRainConteiner로 계산해서 올림
			Train tr = new Train();
			if (con != null) {

				String sql = "select * from train where trainid = " + trainId;
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						String trainID = rs.getString("trainID");
						String trainName = rs.getString("trainname");
						int averegeSpeed = rs.getInt("averegespeed");
						int price = rs.getInt("price");
						int seat = rs.getInt("seat");
						int maxSeat = rs.getInt("maxseat");
						float length = rs.getFloat("length");
						int runOrNot = rs.getInt("runornot");
						String dRailCode = rs.getString("DRailcode");
						String aRailCode = rs.getString("ARailcode");
						String dDate = rs.getString("ddate");
						String dTime = rs.getString("dtime");
						String atime = rs.getString("atime");
						tr = new Train(trainID, trainName, averegeSpeed, price, seat, maxSeat, length, runOrNot,
								dRailCode, aRailCode, dDate, dTime, atime);
						return tr;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("대상이없습니다");
			}
			return tr;
		}

		public ArrayList<Train> selectAllTrain() { // 특정기능없음
			String sql = "select * from train ";
			Train tr = null;
			ArrayList<Train> trL = new ArrayList<Train>();
			if (con != null) {
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);

					while (rs.next()) {
						String trainID = rs.getString("trainID");
						String trainName = rs.getString("trainname");
						int averegeSpeed = rs.getInt("averegeSpeed");
						int price = rs.getInt("price");
						int seat = rs.getInt("seat");
						int maxSeat = rs.getInt("maxseat");
						float length = rs.getFloat("length");
						int runOrNot = rs.getInt("runornot");
						String dRailCode = rs.getString("DRailcode");
						String aRailCode = rs.getString("ARailcode");
						String dDate = rs.getString("ddate");
						String dTime = rs.getString("dtime");
						String atime = rs.getString("atime");
						tr = new Train(trainID, trainName, averegeSpeed, price, seat, maxSeat, length, runOrNot,
								dRailCode, aRailCode, dDate, dTime, atime);

						trL.add(tr);
					}
					return trL;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("통신불량");
			}
			return trL;
		}

		public void updateTrain(int SetNum, Object value, String Trainid) { // Gui에 콤보박스형식으로 밑에 메뉴를 츌력 1번부터 12번까지 의
																				// 변경가능메뉴들
			// 원래대로라면 업데이트하기위해서 각각 메소드를 만들어야하나 편의를 위해 어떤타입의 객체가 들어올줄 모르기에 오브젝트타입을 받은후
			// SetNum로 원하는타입 지정후 object타입에 해당타입을 캐스팅
			// 하나의 메소드로 DB를 업데이트하기위해 만든 관리자 전용 메소드
			String[] menu = { "", "trainid", "trainName", "AVEREGESPEED", "price", "seat", "maxseat", "length",
					"RunOrNot", "Drailcode", "Arailcode", "ddate", "dtime", "atime" };
			if (con != null) {
				String sql = "update train set " + menu[SetNum] + " = ? where trainid = ?";
				// System.out.println("1.기차이름\n2.평균속도\n3.열차가격\n4.좌석\n5.총좌석\n6.도착지까지길이\n7.운행or아니\n8.출발역\n9.도착역(HH-mm)\n"
				// + "10.출발날자\n11.출발시간\n12.도착시간");
				try {
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(2, Trainid);
					switch (SetNum) {
					case 1:
						pstmt.setString(1, (String) value);
						break;
					case 2:
						pstmt.setString(1, (String) value);
						break;
					case 3:
						pstmt.setInt(1, Integer.parseInt((String) value));
						break;
					case 4:
						pstmt.setInt(1, Integer.parseInt((String) value));
						break;
					case 5:
						pstmt.setInt(1, Integer.parseInt((String) value));
						break;
					case 6:
						pstmt.setInt(1, Integer.parseInt((String) value));
						break;
					case 7:
						pstmt.setFloat(1, (float)((int) value));
						break;
					case 8:
						pstmt.setInt(1, Integer.parseInt((String) value));
						break;
					case 9:
						pstmt.setString(1, (String) value);
						break;
					case 10:
						pstmt.setString(1, (String) value);
						break;
					case 11:
						pstmt.setString(1, (String) value);
						break;
					case 12:
						pstmt.setString(1, (String) value);
						break;
					case 13:
						pstmt.setString(1, (String) value);
						break;

					default:
						System.out.println("없는 설정입니다");
						break;
					}
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("통신불량");
			}
		}

		private void delTrain(String Trainid) { // 기차객체를 지우기위해 만든 메소드 pk인 trainid 로 기차식별 후 원하는 객체 삭제가능
			if (con != null) {
				String sql = "DELETE from Train where trainid = ?";
				PreparedStatement pstmt;
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, Trainid);
					int r = pstmt.executeUpdate();
					if (r == 1) {
						System.out.println("업데이트완료");
					} else {
						System.out.println("삭제 실패");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

		private void insertNewRail(Rail rail) { // 위에 기차객체를 만들기위해 만든 인서트문과 같음 클래스 rail의 필드를 받음
			if (con != null) {
				String sql = "insert into Rail values(rail_seq.nextval, ?, ?, ?, ?, ?, ?)";
				try {
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, rail.getLocation());
					pstmt.setInt(2, rail.getPriceOfThis());
					pstmt.setInt(3, rail.getLengthOfThis());
					pstmt.setString(4, "3");
					pstmt.setString(5, rail.getRailName());
					pstmt.setInt(6, rail.getRailNumb());
					int rs = pstmt.executeUpdate();
					if (rs == 1) {
						System.out.println("rail update 완료");
					} else {
						System.out.println("rail 입력 실패");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("insert 실패");
			}
		}

		private Rail selectOneRail(int Railcode) { // Train 과 같이 하나를 선택해서 추후에 Train db에 Train과 합쳐서 올리기위해 만든 메소드
			Rail ra = null;
			if (con != null) {
				String sql = "select * from Rail where RailCode = " + Railcode;
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						int railCode = rs.getInt("railCode");
						String location = rs.getString("location");
						int priceOfThis = rs.getInt("priceOfThis");
						int lengthOfThis = rs.getInt("lengthOfThis");
						String time = rs.getString("time");
						String railName = rs.getString("railName");
						int railNumb = rs.getInt("railNumb");
						ra = new Rail(railCode, location, priceOfThis, lengthOfThis, time, railName, railNumb);
						return ra;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("대상이없습니다");
			}
			return ra;
		}

		public ArrayList<Rail> selectAllRail() { // 나중에 trainconteiner에 올리기위해 중요한 함수 이 함수로
			// 레일의 price와 length를 나열하여 각 역의 가격과 길이를 어레이리스트에 저장 각객체의 절대적으로 정해진 순서번호를 순서대로 나열
			// 그걸 +=하여 토탈길이와 토탈가격을 가져옴 자세한설명은 밑에 train
			// container에서 설명
			String sql = "select * from rail order by railcode asc";
			Rail ra = null;
			ArrayList<Rail> raL = new ArrayList<Rail>();
			if (con != null) {
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);

					while (rs.next()) {
						int railCode = rs.getInt("railCode");
						String location = rs.getString("location");
						int priceOfThis = rs.getInt("priceOfThis");
						int lengthOfThis = rs.getInt("lengthOfThis");
						String time = rs.getString("time");
						String railName = rs.getString("railName");
						int railNumb = rs.getInt("railNumb");
						ra = new Rail(railCode, location, priceOfThis, lengthOfThis, time, railName, railNumb);

						raL.add(ra);
					}
					return raL;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return raL;
		}

		private void delRail(String railNumb) { // 레일을 지우기위한 함수
			if (con != null) {
				String sql = "delet from rail where railNumb = ?";
				PreparedStatement pstmt;
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, railNumb);
					int r = pstmt.executeUpdate();
					if (r == 1) {
						System.out.println("삭제완료");
					} else {
						System.out.println("삭제실패");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public void SetTrainScedule(String trainId, int DRail, int ARail, String DDate, String DTime) {
			// 위에서 말한 selectallRail과 selectOneTrain 함수가 사용되는 함수
			Admin ad = new Admin();

			int Tpay = 0; // 거리에 비래해서 책정되는 토탈가격 각역은 전역과 거리에 비례해 특정의 가격을 갖고있는대 예를 들면 서울(시작역,0km
							// ,5000원의가격을책정 ) 광주(광주는
			// 서울기준으로부터 100km 정도 거리가나온다고 가정 그래서 광주Rail이 갖구있는 원점으로의 거리는 100km이기 떄문에 역이갖는 거리는
			// 100km 가격은 5000원(대략)
			// 해서 각역의 기준점으로부터 거리 등을 계산해 각역마다 다른 length와 price를 부여 그리고 selectallRail으로 오름차순으로
			// 순서대로 저장해서 받구
			// list(서울(레일넘버(PK)1),광주(2),부산(3)) 출발 도착역에따라+=연산으로 for문을 돌면서 계산
			// 예로 유저가 광주에서 부산으로 간다면 광주의 가격과 렝스를 부산역까지 2번부터3번까지for문으로 돌아서 가격과 length를 순차적으로
			// 더하여 토탈가격과 거리를 계산
			// if (DrailCode < ArailCode)의 용도는 사용자가 부산에서 출발하는상황이면 출발역 번호가 도착역번호보다 더크기떄문이고
			// startchecker 의 목적은 출발역이 기준이 길이와 가격의 기준이 돠어야하기떄문에 출발하는역의 가격과 렝스를 0으로 초기화 하기위함
			int Tlenth = 0;
			int Startchecker = 1;
			Train tr = selectOneTrain(trainId);
			ArrayList<Rail> rai = selectAllRail();
			System.out.println(rai.size()+"사이즈");
			int DrailCode = rai.get((DRail - 1)).getRailCode();
			int ArailCode = rai.get((ARail - 1)).getRailCode();
			String trainID = tr.getTrainID();
			if (DrailCode < ArailCode) {
				for (int o = DrailCode; o <= ArailCode; o++) {
					int price = rai.get((o - 1)).getPriceOfThis();
					int lenth = rai.get((o - 1)).getLengthOfThis();
					Tpay += price;
					Tlenth += lenth;
					if (Startchecker == 1) {
						Tpay = 0;
						Tlenth = 0;
					}
					Startchecker++;

				}
			} else {
				for (int o = ArailCode; o <= DrailCode; o++) {
					int price = rai.get((o - 1)).getPriceOfThis();
					int lenth = rai.get((o - 1)).getLengthOfThis();
					Tpay += price;
					Tlenth += lenth;
					if (Startchecker == 1) {
						Tpay = 0;
						Tlenth = 0;
					}
					Startchecker++;
				}
			}
		
			updateTrain(8, "1", trainId);
			tr.setLength(Tlenth);
			tr.setPrice(Tpay);
			tr.DDate(DDate);
			String DT = tr.DTime(DTime);
			ViaRailDB vdb = new ViaRailDB(con);
			vdb.SetTrainViaScedule(trainID, (DRail-1), ARail, DDate, DTime);
			tr.diffOfMinutesA(DT); // TODO
//			String trainID, String trainName, int pkUser, int dRailCode, int aRailCode, String dStation,
//			String aStation, String name, int age, int ageType, int price, int seat, int fullOrNot, String dDate,
//			String dTime, String aTime, String payDate
			booking book = new booking(trainID, tr.getTrainName(), -1, DrailCode, ArailCode, rai.get((DrailCode-1)).getRailName(),
										rai.get((ArailCode-1)).getRailName(), null, -1, -1, tr.getPrice(), tr.getSeat(), -1, tr.getDDate(),
										tr.getDTime(), tr.getAtime(), null);
			BookingDBMgr bdb = new BookingDBMgr(Admin.con);
			for (int i = 1; i <= tr.getSeat(); i++) {
			bdb.insertNewMemberSeat(book);
			book.setSeat(i);
			}
			if (Admin.con != null) {
				String sql = "insert into TrainContainer values(?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement ptsmt = Admin.con.prepareStatement(sql);
					ptsmt.setInt(1, DrailCode);
					ptsmt.setInt(2, ArailCode);
					ptsmt.setString(3, tr.getTrainID());
					ptsmt.setInt(4, tr.getPrice());
					ptsmt.setString(5, tr.getDDate());
					ptsmt.setString(6, tr.getDTime());
					ptsmt.setString(7, tr.getAtime());
					ptsmt.setInt(8, tr.getSeat());
					ptsmt.setFloat(9, tr.getLength());
					ptsmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("SetTrain쪽 통신불량");
			}
		}

	}

	protected TrainContainer selectOneTrainScedule(int D, int A) { // 여기부턴 사용자와 어드민이 같이사용한는 메소드
		TrainContainer tr = new TrainContainer();
		if (Admin.con != null) {
			String sql = "select * from TrainContainer where drailcode = " + "'" + D + "'" + " , arailcode =" + "'" + A
					+ "'";
			try {
				Statement stmt = Admin.con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					tr.setDRailCode(rs.getString("dRailCode"));
					tr.setARailCode(rs.getString("arailcode"));
					tr.setTrainID(rs.getString("trainid"));
					tr.setDDate(rs.getString("price"));
					tr.setDTime(rs.getString("ddate"));
					tr.setATime(rs.getString("atime"));
					tr.setSeat(rs.getInt("seat"));
					tr.setLength(rs.getInt("length"));
					return tr;
				} else {
					System.out.println("조회 실패");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tr;
	}

	protected ArrayList<TrainContainer> selectAllTrainScedule() { // 이하마찬가지
		
		ArrayList<TrainContainer> trL = new ArrayList<TrainContainer>();
		if (Admin.con != null) {
			String sql = "select * from TrainContainer ";
			try {
				Statement stmt = Admin.con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
					while (rs.next()) {
						
						String dRailCode = (rs.getString("dRailCode"));
						String aRailCode =(rs.getString("arailcode"));
						String trainID =(rs.getString("trainid"));
						int pirce = (rs.getInt("price"));
						String dDate =(rs.getString("ddate"));
						String dTime =(rs.getString("dtime"));
						String aTime = (rs.getString("atime"));
						int seat =(rs.getInt("seat"));
						float length = (rs.getFloat("length"));
				TrainContainer tr = new TrainContainer(dRailCode, aRailCode, trainID, pirce,
						dDate, dTime, aTime, seat, length);
						trL.add(tr);
					}
					return trL;
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trL;
	}

	protected ArrayList<TrainContainer> selectAllTrainScedule(int D, int A) { // 이하마찬가지
		ArrayList<TrainContainer> trL = new ArrayList<TrainContainer>();
		if (Admin.con != null) {
			String sql = "select * from TrainContainer where drailcode = " + D + " , arailcode =" + A;
			try {
				Statement stmt = Admin.con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
					while (rs.next()) {
						String dRailCode = (rs.getString("dRailCode"));
						String aRailCode =(rs.getString("arailcode"));
						String trainID =(rs.getString("trainid"));
						int pirce = (rs.getInt("price"));
						String dDate =(rs.getString("ddate"));
						String dTime =(rs.getString("dtime"));
						String aTime = (rs.getString("atime"));
						int seat =(rs.getInt("seat"));
						float length = (rs.getFloat("length"));
				TrainContainer tr = new TrainContainer(dRailCode, aRailCode, trainID, pirce,
						dDate, dTime, aTime, seat, length);
						trL.add(tr);
					}
					return trL;
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trL;
	}

	private void deletOneScedule(String TrainID) { // 디비에올라간 기차 스케쥴을 삭제하기위한 어드민전용 메소드
		if (Admin.con != null) {
			String sql = "delete from traincontainer where = " + TrainID;
			try {
				Statement stmt = Admin.con.createStatement();
				int r = stmt.executeUpdate(sql);
				if (r == 1) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateScedule(int SetNum, Object value, String Trainid) { // Gui에 콤보박스형식으로 밑에 메뉴를 츌력 1번부터 12번까지 의
																			// 변경가능메뉴들

		String[] menu = { "", "drailcode", "arailcode", "trainid", "price", "ddate", "dtime", "atime", "seat",
				"length" };
		String[] Guimenu = { "", "출발역", "도착역", "기차번호", "가격", "출발날자", "출발시간", "도착시간", "거리" };
		if (con != null) {
			String sql = "update traincontainer set " + menu[SetNum] + " = ? where trainid = ?";

			try {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(2, Trainid);
				switch (SetNum) {
				case 1:
					pstmt.setString(1, (String) value);
					break;
				case 2:
					pstmt.setString(1, (String) value);
					break;
				case 3:
					pstmt.setString(1, (String) value);
					break;
				case 4:
					pstmt.setString(1, (String) value);
					break;
				case 5:
					pstmt.setString(1, (String) value);
					break;
				case 6:
					pstmt.setString(1, (String) value);
					break;
				case 7:
					pstmt.setString(1, (String) value);
					break;
				case 8:
					pstmt.setInt(1, Integer.parseInt((String) value));
					break;
				case 9:
					pstmt.setFloat(1, Float.parseFloat((String) value));
					break;

				default:
					System.out.println("없는 설정입니다");
					break;
				}
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("통신불량");
		}
	}

	public static void main(String[] args) {
		Admin ad = new Admin();
		connectTrainDB();
		//	ViaRailDB d = new ViaRailDB(con);
			bookingSystemforUser bk = new bookingSystemforUser(con);
			//d.SetTrainViaScedule("1", 0,1, "1995-11-11","15-31");
	//	ArrayList<ViaRail> rl = d.selectViaRailAtoB("31");
		
		//for (ViaRail viaRail : rl) {
		//	System.out.println(viaRail);
	//	}
	//	bk.bookingAtoB("31", 1, 3);
//		connectTrainDB();
//		d.SetTrainViaScedule("31", 1, 4, "1995-01-01", "15-15");
////	ad.insertNewRail(mr);
//		ad.updateScedule(8, "16", "1");
////	ad.insertNewRail(mr2);
//d.SetTrainViaScedule("1", 0,1, "1995-11-11","15-31");
		
		closeTrainDB();
	}
}
