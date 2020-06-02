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

// private�޼ҵ�� �����ڸ� ����ϰ� ������ ������ �������� ���ʿ��� �ߺ��Լ��� ���̰� �Լ��� ��ӽ�Ű�����Ͽ� protected �� ���� private�Լ��� ������ ���θ޼ҵ忡���� ��밡�� gui ����� ���� Ŭ����  ������ ����Ŭ�����ȿ��� ����
	public static void connectTrainDB() { // ������ �����ڰ� ������ Ŀ��Ʈ DB��Ʈ

		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection(URL, USER, PW);
			System.out.println("���� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("���� ����");
			e1.printStackTrace();
		}
	}

	public static void closeTrainDB() {
		if (con != null) {
			try {
				con.close();
				System.out.println("DB���� ����");
			} catch (SQLException e) {
				System.out.println("DB���� ����");
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

		private void insertNewTrain(Train tr) { // ���� ��ü�� DB�� �����ϱ����ؼ� ���� �ΙDƮ�� �Ŀ� ���ϰ�ü�� length�� �޾Ƽ� �����ð� �ҿ�ð� ��꿡 �ҿ� ����
												// ������
												// ������ �޾� ����Ͽ�
			// train container�� ��ü�� �ø�������

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
						System.out.println("train �Է� �Ϸ�");
					} else {
						System.out.println("train �Է� ����");
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
				if (behavior == "�����߰�") {
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
				} else if (behavior == "�����ϳ�����") {
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

				} else if (behavior == "�������κ���") {
					ShowAllTrain(tr.size());
				} else if (behavior == "��������") {

					updateTrain(oe.getUpdateNum(), oe.getUpdateValue(), oe.getUpdateTrainId());
					ShowAllTrain(tr.size());
					for (int i = 0; i < oe.btnArr.size(); i++) {
						oe.btnArr.get(i).setEnabled(true);
					}
					System.out.println("���ſϷ�");
				} else if (behavior == "��������") {
					String tid = oe.getDelTEXT().getText();
//TODO ��������	
					if (!tid.isEmpty()) {
						delTrain(tid);
					} else {

					}
				ShowAllTrain(tr.size());
				} else if (behavior == "�����߰�") {
					int price = Integer.parseInt(oe.getRailTextPrice().getText());
					int length = Integer.parseInt(oe.getRailTextLength().getText());

					Rail rl = new Rail(oe.getRailTextLocation().getText(), price, length,
							oe.getRailTextRailName().getText());
					insertNewRail(rl);
				} else if (behavior == "�����ϳ�����") {
					Rail rl = selectOneRail(Integer.parseInt(oe.getRailCodeText().getText()));
					System.out.println("����");
					for (int j = 0; j < oe.getDft().getRowCount(); j++) {
						oe.getDft().removeRow(j);
					}


					oe.getDft().addRow(new Object[] { rl.getRailCode(), rl.getLocation(), rl.getPriceOfThis(),
							rl.getLengthOfThis(), rl.getTime(), rl.getRailName(), rl.getRailNumb() });
					oe.getTable().setModel(oe.getDft());

				} else if (behavior == "�������κ���") {
					ArrayList<Rail> rl = selectAllRail();
					System.out.println(rl.size());
					System.out.println("����");
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
				} else if (behavior == "���ϻ���") {
					// TODO ���ϻ���
					//delRail(railNumb);
				} else if (behavior == "����������¾�") {


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
					System.out.println("����" + oe.getSetupDDateTxt().getText() + "�ð�" + oe.getSetupDtimeTxt().getText());
					
					SetTrainScedule(Id, Integer.parseInt(DR), Integer.parseInt(AR), oe.getSetupDDateTxt().getText(),
							oe.getSetupDtimeTxt().getText());

				} else if (behavior == "���������κ���") {
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
				} else if (behavior == "�����캯��") {

				} else if (behavior == "���������") {
				
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
//				if(cob.getModel().getSelectedItem() == "��������") {
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

		// ID�� ����ã�� - ����Ž����
		public Train selectOneTrain(String trainId) { // �� �Լ��� DB�� ����� Ư�� ������ü�� ���� TRainConteiner�� ����ؼ� �ø�
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
				System.out.println("����̾����ϴ�");
			}
			return tr;
		}

		public ArrayList<Train> selectAllTrain() { // Ư����ɾ���
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
				System.out.println("��źҷ�");
			}
			return trL;
		}

		public void updateTrain(int SetNum, Object value, String Trainid) { // Gui�� �޺��ڽ��������� �ؿ� �޴��� ���� 1������ 12������ ��
																				// ���氡�ɸ޴���
			// ������ζ�� ������Ʈ�ϱ����ؼ� ���� �޼ҵ带 �������ϳ� ���Ǹ� ���� �Ÿ���� ��ü�� ������ �𸣱⿡ ������ƮŸ���� ������
			// SetNum�� ���ϴ�Ÿ�� ������ objectŸ�Կ� �ش�Ÿ���� ĳ����
			// �ϳ��� �޼ҵ�� DB�� ������Ʈ�ϱ����� ���� ������ ���� �޼ҵ�
			String[] menu = { "", "trainid", "trainName", "AVEREGESPEED", "price", "seat", "maxseat", "length",
					"RunOrNot", "Drailcode", "Arailcode", "ddate", "dtime", "atime" };
			if (con != null) {
				String sql = "update train set " + menu[SetNum] + " = ? where trainid = ?";
				// System.out.println("1.�����̸�\n2.��ռӵ�\n3.��������\n4.�¼�\n5.���¼�\n6.��������������\n7.����or�ƴ�\n8.��߿�\n9.������(HH-mm)\n"
				// + "10.��߳���\n11.��߽ð�\n12.�����ð�");
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
						System.out.println("���� �����Դϴ�");
						break;
					}
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("��źҷ�");
			}
		}

		private void delTrain(String Trainid) { // ������ü�� ��������� ���� �޼ҵ� pk�� trainid �� �����ĺ� �� ���ϴ� ��ü ��������
			if (con != null) {
				String sql = "DELETE from Train where trainid = ?";
				PreparedStatement pstmt;
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, Trainid);
					int r = pstmt.executeUpdate();
					if (r == 1) {
						System.out.println("������Ʈ�Ϸ�");
					} else {
						System.out.println("���� ����");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

		private void insertNewRail(Rail rail) { // ���� ������ü�� ��������� ���� �μ�Ʈ���� ���� Ŭ���� rail�� �ʵ带 ����
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
						System.out.println("rail update �Ϸ�");
					} else {
						System.out.println("rail �Է� ����");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("insert ����");
			}
		}

		private Rail selectOneRail(int Railcode) { // Train �� ���� �ϳ��� �����ؼ� ���Ŀ� Train db�� Train�� ���ļ� �ø������� ���� �޼ҵ�
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
				System.out.println("����̾����ϴ�");
			}
			return ra;
		}

		public ArrayList<Rail> selectAllRail() { // ���߿� trainconteiner�� �ø������� �߿��� �Լ� �� �Լ���
			// ������ price�� length�� �����Ͽ� �� ���� ���ݰ� ���̸� ��̸���Ʈ�� ���� ����ü�� ���������� ������ ������ȣ�� ������� ����
			// �װ� +=�Ͽ� ��Ż���̿� ��Ż������ ������ �ڼ��Ѽ����� �ؿ� train
			// container���� ����
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

		private void delRail(String railNumb) { // ������ ��������� �Լ�
			if (con != null) {
				String sql = "delet from rail where railNumb = ?";
				PreparedStatement pstmt;
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, railNumb);
					int r = pstmt.executeUpdate();
					if (r == 1) {
						System.out.println("�����Ϸ�");
					} else {
						System.out.println("��������");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		public void SetTrainScedule(String trainId, int DRail, int ARail, String DDate, String DTime) {
			// ������ ���� selectallRail�� selectOneTrain �Լ��� ���Ǵ� �Լ�
			Admin ad = new Admin();

			int Tpay = 0; // �Ÿ��� ���ؼ� å���Ǵ� ��Ż���� ������ ������ �Ÿ��� ����� Ư���� ������ �����ִ´� ���� ��� ����(���ۿ�,0km
							// ,5000���ǰ�����å�� ) ����(���ִ�
			// ����������κ��� 100km ���� �Ÿ������´ٰ� ���� �׷��� ����Rail�� �����ִ� ���������� �Ÿ��� 100km�̱� ������ ���̰��� �Ÿ���
			// 100km ������ 5000��(�뷫)
			// �ؼ� ������ ���������κ��� �Ÿ� ���� ����� �������� �ٸ� length�� price�� �ο� �׸��� selectallRail���� ������������
			// ������� �����ؼ� �ޱ�
			// list(����(���ϳѹ�(PK)1),����(2),�λ�(3)) ��� ������������+=�������� for���� ���鼭 ���
			// ���� ������ ���ֿ��� �λ����� ���ٸ� ������ ���ݰ� ������ �λ꿪���� 2������3������for������ ���Ƽ� ���ݰ� length�� ����������
			// ���Ͽ� ��Ż���ݰ� �Ÿ��� ���
			// if (DrailCode < ArailCode)�� �뵵�� ����ڰ� �λ꿡�� ����ϴ»�Ȳ�̸� ��߿� ��ȣ�� ��������ȣ���� ��ũ�⋚���̰�
			// startchecker �� ������ ��߿��� ������ ���̿� ������ ������ �¾���ϱ⋚���� ����ϴ¿��� ���ݰ� ������ 0���� �ʱ�ȭ �ϱ�����
			int Tlenth = 0;
			int Startchecker = 1;
			Train tr = selectOneTrain(trainId);
			ArrayList<Rail> rai = selectAllRail();
			System.out.println(rai.size()+"������");
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
				System.out.println("SetTrain�� ��źҷ�");
			}
		}

	}

	protected TrainContainer selectOneTrainScedule(int D, int A) { // ������� ����ڿ� ������ ���̻���Ѵ� �޼ҵ�
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
					System.out.println("��ȸ ����");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tr;
	}

	protected ArrayList<TrainContainer> selectAllTrainScedule() { // ���ϸ�������
		
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

	protected ArrayList<TrainContainer> selectAllTrainScedule(int D, int A) { // ���ϸ�������
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

	private void deletOneScedule(String TrainID) { // ��񿡿ö� ���� �������� �����ϱ����� �������� �޼ҵ�
		if (Admin.con != null) {
			String sql = "delete from traincontainer where = " + TrainID;
			try {
				Statement stmt = Admin.con.createStatement();
				int r = stmt.executeUpdate(sql);
				if (r == 1) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("���� ����");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateScedule(int SetNum, Object value, String Trainid) { // Gui�� �޺��ڽ��������� �ؿ� �޴��� ���� 1������ 12������ ��
																			// ���氡�ɸ޴���

		String[] menu = { "", "drailcode", "arailcode", "trainid", "price", "ddate", "dtime", "atime", "seat",
				"length" };
		String[] Guimenu = { "", "��߿�", "������", "������ȣ", "����", "��߳���", "��߽ð�", "�����ð�", "�Ÿ�" };
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
					System.out.println("���� �����Դϴ�");
					break;
				}
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("��źҷ�");
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
