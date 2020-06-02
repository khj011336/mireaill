package booking.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.text.AbstractDocument.BranchElement;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import admin.Admin;
import admin.Admin.insertT;
import booking.BookingDBMgr;
import booking.Bookshow;
import booking.booking;
import main.LogPanel;
import main.xbox;
import member.Member;
import member.db.MemberDBManager;
import pay.bookingSystemforUser;
import trainPack.Train;
import trainRail.Rail;
import viaRail.ViaRail;
import viaRail.ViaRailDB;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class BookingGui extends JFrame{
	JPanel pnSeatBooking;
	private JPanel contentPane;
	private JTable tableTime;
	JLabel lblChair; // 좌석
	JLabel lblSysDate; // 현재 날자 표시
	ArrayList<JLabel> SeatArray;
	Connection con;
	JPanel pnSeat;
	int selectedSeat;
	JLabel lblBookingInfo;
	JFrame jfm;
//	ArrayList<JLabel> SeatArray = new ArrayList<JLabel>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		Admin ad = new Admin();
//		ad.connectTrainDB();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookingGui frame = new BookingGui(con);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

	BookingGui Bfrm;

	public BookingGui(Connection con,String logged) {
		Admin ad = new Admin();
		Bfrm = this;
		insertT innerAD = ad.new insertT();
		setTitle("MIRAIL : \uC2B9\uCC28\uAD8C \uC608\uB9E4");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JLabel label = new JLabel("\uC2B9\uCC28\uAD8C \uC608\uB9E4");
		label.setBackground(Color.BLACK);
		label.setForeground(Color.BLACK);
		label.setBounds(31, 5, 848, 40);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		contentPane.add(label);

		JComboBox DCombo = new JComboBox();
		ArrayList<Rail> Rl = innerAD.selectAllRail();
		String Rail[] = new String[Rl.size()];
		for (int i = 0; i < Rl.size(); i++) {
			Rail[i] = "-" + Rl.get(i).getRailCode() + "-" + Rl.get(i).getRailName();
			System.out.println(Rail[i]);

		}
		DefaultComboBoxModel<String> TRail = new DefaultComboBoxModel<String>(Rail);
		DefaultComboBoxModel<String> TRail2 = new DefaultComboBoxModel<String>(Rail);
		DCombo.setModel(TRail);
		DCombo.setBounds(484, 63, 87, 21);
		contentPane.add(DCombo);

		JLabel lblCal = new JLabel("\uB2EC\uB825");
		lblCal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCal.setBackground(Color.WHITE);
		lblCal.setBounds(175, 63, 57, 21);
		lblCal.setOpaque(true);
		contentPane.add(lblCal);

		JLabel lblSel = new JLabel("\uC5F4\uCC28\uC2DC\uAC04\uC870\uD68C");
		lblSel.setFont(new Font("굴림", Font.BOLD, 13));
		lblSel.setBounds(41, 39, 87, 21);
		contentPane.add(lblSel);

		// 오늘의 날자
		Date date = new Date();
		SimpleDateFormat todayDate = new SimpleDateFormat("yyyy 년 MM 월 dd 일");
		lblSysDate = new JLabel(todayDate.format(date));
		lblSysDate.setBackground(Color.WHITE);
		lblSysDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblSysDate.setBounds(51, 63, 112, 21);
		lblSysDate.setOpaque(true);
		contentPane.add(lblSysDate);

		JComboBox ACombo = new JComboBox();
		ACombo.setModel(TRail2);
		ACombo.setBounds(642, 63, 87, 21);
		contentPane.add(ACombo);

		DefaultTableModel tbm = new DefaultTableModel(new Object[] { "기차이름", "출발시간", "도착시간", "출발역", "도착역", "가격" }, 0);
		
		JButton btnSel = new JButton("\uC870\uD68C");
		ViaRailDB vr = new ViaRailDB(con);

		btnSel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int d = tbm.getRowCount();
				for (int j = 0; j < d; j++) {
					tbm.removeRow(0);
				}
				System.out.println("눌림");
				ArrayList<ViaRail> vvrs = vr.selectViaRailAtoB();
				System.out.println(vvrs.size() + "ssssssssss");
				System.out.println(vvrs);
				String D = (String) DCombo.getModel().getSelectedItem();
				String A = (String) ACombo.getModel().getSelectedItem();

				String Acode = A.split("-")[1];
				String AcodeS = A.split("-")[2];
				String Dcode = D.split("-")[1];
				System.out.println(Dcode);
				System.out.println(AcodeS);
				String DcodeS = D.split("-")[2];
				String trainid = "";
				String dtime = "";
				String atime = "";
				String ShowTrainid = "";
				 ArrayList<Bookshow> bkLst = new ArrayList<Bookshow>();
				for (int i = 0; i < vvrs.size(); i++) {
					if (vvrs.get(i).getDstart() >= Integer.parseInt(Acode)) {
						if (vvrs.get(i).getDRailCode().equals(Dcode)) {
							dtime = vvrs.get(i).getDTime();
							System.out.println(dtime);
							trainid = vvrs.get(i).getTrainID();
							ShowTrainid = vvrs.get(i).getTrainID() + "-" + vvrs.get(i).getTrainName() + "-";
						} else {
							continue;
						}
						for (int j = 0; j < vvrs.size(); j++) {
							if (vvrs.get(j).getTrainID().equals(trainid) && vvrs.get(j).getARailCode().equals(Acode)) {
								atime = vvrs.get(j).getATime();

							} else {
								continue;
							}
						}

						bookingSystemforUser bkst = new bookingSystemforUser(con);
						bookingSystemforUser bk = bkst.bookingAtoB(trainid, Integer.parseInt(Dcode),
								Integer.parseInt(Acode));
						if(atime.isEmpty()) atime = "없음-없음";
						String Atime[] = atime.split("-");
						Bookshow bks = new Bookshow(ShowTrainid,dtime,String.format("%s시%s분",Atime[0],Atime[1] ),DcodeS,AcodeS,bk.getPay());
						
						bkLst.add(bks);
						
					}
				}
				Comparator<Bookshow> salesComparator = new Comparator<Bookshow>() {
		            @Override
		            public int compare(Bookshow o1, Bookshow o2) {
		                return  (o1.getDtime()).compareTo(o2.getDtime());
		            }
		        };
				Collections.sort(bkLst,salesComparator);
				for (int i = 0; i < bkLst.size(); i++) {
					tbm.addRow(new Object[] {bkLst.get(i).getTrainid(),bkLst.get(i).getDtime(),bkLst.get(i).getAtime(),bkLst.get(i).getDcodes(),
							bkLst.get(i).getAcodes(),bkLst.get(i).getPay()});
				}

			}
		});
		btnSel.setBounds(737, 62, 97, 23);
		contentPane.add(btnSel);

		JPanel pnTimeTable = new JPanel();
		pnTimeTable.setBounds(41, 94, 793, 153);
		contentPane.add(pnTimeTable);

		String column[] = { "열차번호", "기차종류", "행선지", "출발시간", "도착시간", "운행방향" }; // F
		DefaultTableModel def = new DefaultTableModel(column, 0);
		
		
		JTable jt = new JTable(def);
		jt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable jb = (JTable) e.getSource();
				int row = jt.getSelectedRow();
				String trainame = (String) jt.getValueAt(row, 0);
				String tranid = trainame.split("-")[0];
			ArrayList<JLabel>	SeatArray = new ArrayList<JLabel>();
		
			BookingDBMgr bmgr = new BookingDBMgr(con);
			ArrayList<booking> seatox = bmgr.selectAllMembers(tranid);
		 
		
				for (int i = 0; i < seatox.size(); i++) {
					SeatArray.add(new JLabel(i + 1 + ""));
					SeatArray.get(i).setIcon(new ImageIcon(".\\imgs\\chair.png"));
					SeatArray.get(i).setForeground(Color.black);
					SeatArray.get(i).setEnabled(true);
				}

			 
				System.out.println(seatox.size() + "size");
				for (int j = 0; j < seatox.size(); j++) {
					System.out.println(seatox.get(j).getPkUser());
					if (seatox.get(j).getPkUser() != -1) {
						SeatArray.get(j).setText("   ");
						SeatArray.get(j).setForeground(Color.red);
						SeatArray.get(j).setEnabled(false);
					}
				}
				if( pnSeat != null ) {
					pnSeat.removeAll();
					if( pnSeatBooking != null )
						pnSeatBooking.remove(pnSeat);
					pnSeat = null;
				}
				//
				pnSeat = new JPanel();
				pnSeat.setBounds(188, 34, 530, 142);
				for (int i = 0; i < seatox.size(); i++) {
					pnSeat.add(SeatArray.get(i));	
				}
				pnSeat.setLayout(new GridLayout(2, 0, 0, 0));
				for (int i = 0; i < seatox.size(); i++) {
					SeatArray.get(i).addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							JLabel lblseat = (JLabel) e.getSource();
						System.out.println(lblseat.getText()+"잇냐");
						int ak;
							if (lblseat.isEnabled()) {
								ak = Integer.parseInt(lblseat.getText())-1;
								if (!lblseat.getText().equals("0")) {
											SeatArray.get(ak).setIcon(new ImageIcon(
													".\\imgs\\choice_chair.png"));
											selectedSeat = Integer.parseInt(SeatArray.get(ak).getText());
											SeatArray.get(ak).setText("0");
											SeatArray.get(ak).setForeground(Color.white);
								} else {
										System.out.println(lblseat.getText());
										for (int j = 0; j < seatox.size(); j++) {
											if(SeatArray.get(j).getText().equals("0") ) {
											SeatArray.get(j).setIcon(new ImageIcon(
													".\\imgs\\chair.png"));
											SeatArray.get(j).setText(j+1 + "");
											SeatArray.get(j).setForeground(Color.black);
											}
										}
								}
							}
						}
					});
				}
				pnSeatBooking.add(pnSeat);
				jb.getValueAt(row, 0);
				pnSeat.setVisible(true);
				System.out.println("눌림");
				lblBookingInfo.setText(trainame);
			 
			}
		});
		jt.setModel(tbm);
		pnTimeTable.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.add(jt);
		scrollPane.setViewportView(jt);
		pnTimeTable.add(scrollPane);

		JLabel lblNumOfPeaple = new JLabel("\uC778\uC6D0 \uC815\uBCF4");
		lblNumOfPeaple.setBounds(41, 283, 87, 15);
		contentPane.add(lblNumOfPeaple);

		JLabel lblNumOfPeapleInfo = new JLabel("\uC778\uC6D0");
		lblNumOfPeapleInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfPeapleInfo.setToolTipText("");
		lblNumOfPeapleInfo.setBounds(51, 308, 57, 15);
		contentPane.add(lblNumOfPeapleInfo);

		JComboBox cbAdult = new JComboBox();
		cbAdult.setModel(new DefaultComboBoxModel(new String[] { "\uC131\uC778", "1\uBA85", "2\uBA85", "3\uBA85",
				"4\uBA85", "5\uBA85", "6\uBA85", "7\uBA85", "8\uBA85" }));
		cbAdult.setBounds(108, 305, 64, 21);
		contentPane.add(cbAdult);

		JComboBox cbChild = new JComboBox();
		cbChild.setModel(new DefaultComboBoxModel(new String[] { "\uC720\uC544", "1\uBA85", "2\uBA85", "3\uBA85",
				"4\uBA85", "5\uBA85", "6\uBA85", "7\uBA85", "8\uBA85" }));
		cbChild.setBounds(184, 305, 64, 21);
		contentPane.add(cbChild);

		JButton btnChoice = new JButton("\uC120\uD0DD");
		btnChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				booking bk;
				int row = jt.getSelectedRow();
				if (row != -1) {
					String trainname = (String) jt.getValueAt(row, 0);
					String trainNI[] = trainname.split("-");
					System.out.println(trainNI[0] + trainNI[1]);
					String Dtime = (String) jt.getValueAt(row, 1);
					String Atime = (String) jt.getValueAt(row, 2);
					String Drail = (String) jt.getValueAt(row, 3);
					String Arail = (String) jt.getValueAt(row, 4);
					int price = (int) jt.getValueAt(row, 5);

					System.out.println(selectedSeat + "dddddd");
					MemberDBManager mb = new MemberDBManager(con);
					Member nemb = mb.selectOneMemberByID(logged);
					Date dt =new Date();
					SimpleDateFormat simple = new SimpleDateFormat("YYYY-MM-dd");
				String d =new String(simple.format(dt));
					
					if(logged != null) {
					bk = new booking(trainNI[0], trainNI[1], Drail, Arail, nemb.getName(), price, selectedSeat, d,
							Dtime, Atime, "");
					ChoiceDlg Cdlg = new ChoiceDlg(Bfrm, false, bk, con, nemb);
					Cdlg.setVisible(true);
					Cdlg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}else {
						xbox x = new xbox();
						x.setVisible(true);
						//TODO
					}
				}

			}
		});
		btnChoice.setBounds(737, 304, 97, 23);
		contentPane.add(btnChoice);

		JLabel lblSeatBooking = new JLabel("\uC88C\uC11D \uC608\uB9E4");
		lblSeatBooking.setFont(new Font("돋움", Font.BOLD, 13));
		lblSeatBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeatBooking.setBounds(41, 336, 87, 32);
		contentPane.add(lblSeatBooking);

		lblBookingInfo = new JLabel("\uC608\uB9E4 \uC815\uBCF4 : ");
		lblBookingInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingInfo.setBounds(51, 378, 783, 31);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		lblBookingInfo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(lblBookingInfo);

		final ImageIcon icon = new ImageIcon(".//imgs/trainSeat.png");
	pnSeatBooking = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		btnChoice.setBounds(737, 281, 97, 23);
		contentPane.add(btnChoice);
		pnSeatBooking.setBounds(51, 434, 783, 211);
		contentPane.add(pnSeatBooking);
		pnSeatBooking.setLayout(null);

 

		JLabel lblNewLabel = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(426, 66, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uCC29\uC5ED");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(579, 66, 57, 15);
		contentPane.add(lblNewLabel_1);

 
	}


}
