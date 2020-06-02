package pay;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import admin.Admin;
import booking.BookingDBMgr;
import booking.booking;
import booking.ui.BookingCard;
import booking.ui.BookingGui;
import main.MainPageFrame;
import member.Member;
import member.db.MemberDBManager;
import member.myPage.MemberRecipt;
import member.myPage.MemberReciptDBMgr;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class PayGuiMain extends JFrame {

	private JPanel contentPane;
	JPanel panel;
	JTable jt;
	private DefaultTableModel def2;
	public DefaultTableModel getDef2() {
		return def2;
	}


	public void setDef2(DefaultTableModel def2) {
		this.def2 = def2;
	}


	private	TicketCard ticketHome;
	private TicketCardBarcode ticketBarCode;
	JTable jt2;
	public JTable getJt2() {
		return jt2;
	}


	public void setJt2(JTable jt2) {
		this.jt2 = jt2;
	}


	public TicketCard getTicketHome() {
		return ticketHome;
	}


	public void setTicketHome(TicketCard ticketHome) {
		this.ticketHome = ticketHome;
	}


	public TicketCardBarcode getTicketBarCode() {
		return ticketBarCode;
	}


	public void setTicketBarCode(TicketCardBarcode ticketBarCode) {
		this.ticketBarCode = ticketBarCode;
	}


	public BookingCard getPnBookingMsg() {
		return pnBookingMsg;
	}


	public void setPnBookingMsg(BookingCard pnBookingMsg) {
		this.pnBookingMsg = pnBookingMsg;
	}


	public pay getPay() {
		return Pay;
	}


	public void setPay(pay pay) {
		Pay = pay;
	}


	public JLabel getLblUserName() {
		return lblUserName;
	}


	public void setLblUserName(JLabel lblUserName) {
		this.lblUserName = lblUserName;
	}


	public JTable getJt() {
		return jt;
	}


	public void setJt(JTable jt) {
		this.jt = jt;
	}


	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}


	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}


	public JPanel getPnHomeTicket() {
		return pnHomeTicket;
	}


	public void setPnHomeTicket(JPanel pnHomeTicket) {
		this.pnHomeTicket = pnHomeTicket;
	}


	public JPanel getPnBarcordTicket() {
		return pnBarcordTicket;
	}


	public void setPnBarcordTicket(JPanel pnBarcordTicket) {
		this.pnBarcordTicket = pnBarcordTicket;
	}


	public JPanel getPnPayInfo() {
		return pnPayInfo;
	}


	public void setPnPayInfo(JPanel pnPayInfo) {
		this.pnPayInfo = pnPayInfo;
	}


	public JPanel getPnPayInfo2() {
		return pnPayInfo2;
	}


	public void setPnPayInfo2(JPanel pnPayInfo2) {
		this.pnPayInfo2 = pnPayInfo2;
	}


	public JTextField getTxtSumPrice() {
		return txtSumPrice;
	}


	public void setTxtSumPrice(JTextField txtSumPrice) {
		this.txtSumPrice = txtSumPrice;
	}


	public JTextField getTxtPoint1() {
		return txtPoint1;
	}


	public void setTxtPoint1(JTextField txtPoint1) {
		this.txtPoint1 = txtPoint1;
	}


	public JTextField getTxtpPoint2() {
		return txtpPoint2;
	}


	public void setTxtpPoint2(JTextField txtpPoint2) {
		this.txtpPoint2 = txtpPoint2;
	}


	public JTextField getTxtPoint3() {
		return txtPoint3;
	}


	public void setTxtPoint3(JTextField txtPoint3) {
		this.txtPoint3 = txtPoint3;
	}


	public JPanel getPnTitle() {
		return pnTitle;
	}


	private BookingCard pnBookingMsg;
	JFrame PayGuiMain;
	private DefaultTableModel def;
	public DefaultTableModel getDef() {
		return def;
	}


	public void setDef(DefaultTableModel def) {
		this.def = def;
	}


	private pay Pay;
	private	TicketCard HTC;
	private	TicketCardBarcode BTC;
	JButton btnPay; // 첫번째 결제버튼
	private JLabel lblUserName; // 유저네임 동적
	
	JPanel pnTabMembership;
	
	private JTabbedPane tabbedPane;
	private JPanel pnHomeTicket;
	private JPanel pnBarcordTicket;
	private final JPanel pnTitle = new JPanel();
	private JPanel pnPayInfo;
	private JPanel pnPayInfo2;

	private JTextField txtSumPrice; // 예매티켓의 총합 가격
	private JTextField txtPoint1;
	private JTextField txtpPoint2;
	private JTextField txtPoint3;
	Connection con;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//PayGuiMain frame = new PayGuiMain();
				//	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PayGuiMain(Member member ,booking bk ,JFrame jd) {
		this.con = Admin.con;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane =  new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(true);
		contentPane.setVisible(true);
		
//		contentPane.setVisible(true);
//		contentPane.setOpaque(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 262, 250, 400);
		panel.setVisible(true);
		panel.setOpaque(true);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		panel.add(tabbedPane, BorderLayout.CENTER);
		
		// HOMETICKET
		pnHomeTicket = new JPanel();
		pnHomeTicket.setBackground(Color.WHITE);
		tabbedPane.addTab("홈 티켓(인쇄)", null, pnHomeTicket, null);
		Pay = new pay(bk.getTrainID(), bk.getTrainName(),bk.getDStation(), bk.getAStation(), member.getName(), bk.getPrice(), bk.getDDate(), bk.getDTime(), bk.getaTime(), bk.getSeat());
		HTC = new TicketCard(Pay); 
		HTC.setP(Pay);
		System.out.println("예매티켓-HOME티켓");
		pnHomeTicket.setOpaque(true);
		pnHomeTicket.setVisible(true);
		pnHomeTicket.setLayout(new BorderLayout(0, 0));
		pnHomeTicket.add(HTC);
		
		// BARCODE TICKET
		pnBarcordTicket = new JPanel();
		tabbedPane.addTab("스마트 티켓(바코드)", null, pnBarcordTicket, null);
		Pay = new pay(bk.getTrainID(), bk.getTrainName(),bk.getDStation(), bk.getAStation(), member.getName(), bk.getPrice(), bk.getDDate(), bk.getDTime(), bk.getaTime(), bk.getSeat());
		BTC = new TicketCardBarcode(Pay);
		BTC.setP(Pay);
		System.out.println("예매티켓-BARCODE티켓");
		pnBarcordTicket.setOpaque(true);
		pnBarcordTicket.setVisible(true);
		pnBarcordTicket.setLayout(new BorderLayout(0, 0));
		pnBarcordTicket.add(BTC);
//		System.out.println("예매티켓-BARCODE티켓");
//		ticketBarCode.setOpaque(true);
//		ticketBarCode.setVisible(true);
//		ticketBarCode.setLayout(new BorderLayout(0, 0));
//		ticketBarCode.add(ticketBarCode);
		
		pnTitle.setBackground(new Color(173, 216, 230));
		pnTitle.setBounds(0, 0, 1184, 68);
		contentPane.add(pnTitle);
		pnTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("< \uC2B9\uCC28\uAD8C \uBBF8\uB9AC\uBCF4\uAE30 >");
		lblNewLabel.setFont(new Font("HY바다M", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 225, 220, 36);
		pnTitle.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uACB0\uC81C / \uBC1C\uAD8C");
		lblNewLabel_1.setIcon(new ImageIcon(".\\imgs\\ticket.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("HY바다M", Font.BOLD, 35));
		lblNewLabel_1.setBounds(6, 0, 291, 65);
		pnTitle.add(lblNewLabel_1);
		
		JLabel lblLe = new JLabel("- LET'S MIRAIL TRAIN");
		lblLe.setFont(new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 15));
		lblLe.setBounds(309, 22, 211, 36);
		pnTitle.add(lblLe);
		
		JPanel pnUser = new JPanel();
		pnUser.setBackground(Color.WHITE);
		pnUser.setBounds(0, 68, 250, 196);
		contentPane.add(pnUser);
		pnUser.setLayout(null);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(".\\imgs\\user.png"));
		lblIcon.setBounds(43, 56, 76, 65);
		pnUser.add(lblIcon);
		
		lblUserName = new JLabel("'\uBC29\uC724\uC11D'");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("HY강M", Font.BOLD, 18));
		lblUserName.setBounds(114, 77, 76, 44);
		pnUser.add(lblUserName);
		
		JLabel lblUserTitle = new JLabel("\uBCF4\uB2E4 \uD3B8\uB9AC\uD55C \uC608\uC57D, \uBBF8\uB808\uC77C!");
		lblUserTitle.setFont(new Font("HY강M", Font.BOLD, 15));
		lblUserTitle.setBounds(12, 10, 207, 21);
		pnUser.add(lblUserTitle);
		
		JLabel lblNewLabel_2 = new JLabel("\uACE0\uAC1D\uB2D8\uC758 \uC5EC\uC815 \uC815\uBCF4\uC785\uB2C8\uB2E4.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("HY강M", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 144, 226, 21);
		pnUser.add(lblNewLabel_2);
		
		// Pay-1, Table
		String column[] = {"승차일자", "열차번호", "열차종류", "출발역", "출발시각", "도착역", "도착시각", "예약매수", "총 결제금액"}; //F
		 def= new DefaultTableModel(column, 0);

		JPanel pnMain = new JPanel();
		pnMain.setBackground(Color.WHITE);
		pnMain.setBounds(250, 68, 934, 594);
		contentPane.add(pnMain);
		pnMain.setLayout(null);
		
		JPanel pnPointPay = new JPanel();
		pnPointPay.setBounds(24, 312, 885, 260);
		pnMain.add(pnPointPay);
		pnPointPay.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		pnPointPay.add(tabbedPane_1, BorderLayout.CENTER);
		
		pnTabMembership = new JPanel();
		// pnPayInfo2.set
		tabbedPane_1.addTab("멤버쉽 포인트 결제", null, pnTabMembership, null);
		pnTabMembership.setLayout(null);
		
		JLabel lblUserPoint = new JLabel("\uC794\uC561 \uD3EC\uC778\uD2B8");
		lblUserPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserPoint.setFont(new Font("HY강M", Font.BOLD, 17));
		lblUserPoint.setBounds(521, 51, 171, 20);
		pnTabMembership.add(lblUserPoint);
		
		JLabel lblPayPoint = new JLabel("\uACB0\uC81C \uC608\uC815 \uD3EC\uC778\uD2B8");
		lblPayPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPayPoint.setFont(new Font("HY강M", Font.BOLD, 17));
		lblPayPoint.setBounds(521, 91, 171, 20);
		pnTabMembership.add(lblPayPoint);
		
		JLabel lblresulfPoint = new JLabel("\uACB0\uC81C \uD6C4 \uB0A8\uC740 \uD3EC\uC778\uD2B8");
		lblresulfPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblresulfPoint.setFont(new Font("HY강M", Font.BOLD, 17));
		lblresulfPoint.setBounds(521, 132, 171, 20);
		pnTabMembership.add(lblresulfPoint);
		
		txtPoint1 = new JTextField();
		txtPoint1.setText(""+member.getMembership());
		txtPoint1.setBounds(704, 46, 150, 25);
		pnTabMembership.add(txtPoint1);
		txtPoint1.setColumns(10);
		
		txtpPoint2 = new JTextField();
		txtpPoint2.setForeground(new Color(255, 69, 0));
		txtpPoint2.setBounds(704, 86, 150, 25);
		pnTabMembership.add(txtpPoint2);
		txtpPoint2.setColumns(10);
		
		txtPoint3 = new JTextField();
		txtPoint3.setForeground(new Color(65, 105, 225));
		txtPoint3.setBounds(704, 127, 150, 25);
		pnTabMembership.add(txtPoint3);
		txtPoint3.setColumns(10);
		
		JButton btnPointPay = new JButton("\uCD5C\uC885\uACB0\uC81C\uD558\uAE30");
		btnPointPay.setFont(new Font("HY강M", Font.BOLD, 18));
		btnPointPay.setBounds(683, 186, 171, 35);
		pnTabMembership.add(btnPointPay);
		
		JPanel pnBG = new JPanel();
		pnBG.setBackground(new Color(119, 136, 153));
		pnBG.setBounds(12, 10, 910, 260);
		pnMain.add(pnBG);
		pnBG.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("'\uACB0\uC81C'");
		lblNewLabel_3.setBounds(12, 10, 53, 25);
		pnBG.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("HY강M", Font.BOLD, 17));
		
				pnPayInfo = new JPanel();
				pnPayInfo.setBounds(12, 35, 885, 87);
				pnBG.add(pnPayInfo);
				pnPayInfo.setLayout(null);
				pnPayInfo.setLayout(new BorderLayout(0, 0));
				// def.addRow(rowData); // TODO
				 jt = new JTable(def);
				// jt.addMouseListener(new MouseAdapter() {
				// @Override
				// public void mouseClicked(MouseEvent e) {
				// JTable jb = (JTable)e.getSource();
				// int row = jb.getSelectedRow();
				// jb.getValueAt(row, 0);
				// pnSeat.setVisible(true);
				// System.out.println("눌림");
				//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
				// });
				// jt.setModel(tbm);
				ListSelectionModel selecet = jt.getSelectionModel();
				JScrollPane scrollPane = new JScrollPane();
				pnPayInfo.add(scrollPane, BorderLayout.CENTER);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane.add(jt);
				scrollPane.setViewportView(jt);
				
		String column2[] = { "좌석정보", "승객유형", "운임요금", "할인금액", "영수금액" }; // F
		 def2 = new DefaultTableModel(column2, 0);			
				pnPayInfo2 = new JPanel();
				pnPayInfo2.setBounds(12, 127, 885, 92);
				pnBG.add(pnPayInfo2);
				pnPayInfo2.setLayout(new BorderLayout(0, 0));
		
		
				 jt2 = new JTable(def2);
				JScrollPane scrollPane_1 = new JScrollPane();
				pnPayInfo2.add(scrollPane_1, BorderLayout.CENTER);
				scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				scrollPane_1.setViewportView(jt2);
				
				txtSumPrice = new JTextField();
				txtSumPrice.setBounds(673, 229, 116, 21);
				pnBG.add(txtSumPrice);
				txtSumPrice.setFont(new Font("HY강M", Font.BOLD, 15));
				txtSumPrice.setForeground(new Color(255, 0, 0));
				txtSumPrice.setHorizontalAlignment(SwingConstants.CENTER);
				txtSumPrice.setText("P");
				txtSumPrice.setColumns(10);
				
				btnPay = new JButton("\uACB0\uC81C");
				btnPay.setBounds(801, 226, 97, 28);
				pnBG.add(btnPay);
				btnPay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						BookingDBMgr bdb = new BookingDBMgr(con);
						boolean b = bdb.updateMembers(member.getPkUser(), bk.getDRailCode(), bk.getARailCode(), 
								bk.getDStation(), bk.getAStation(), member.getName(), member.getAge(), 
								member.getAge(), bk.getPrice(), bk.getSeat(), 1, bk.getDDate(), bk.getDTime(), bk.getaTime(), "",bk.getTrainID());
						MemberReciptDBMgr db = new MemberReciptDBMgr(con);
						MemberRecipt mb = new MemberRecipt(member.getPkUser(), bk.getDStation(), bk.getAStation(), 
								bk.getDDate(), bk.getTrainID()+"-"+bk.getTrainName()+"-", bk.getSeat(), bk.getDTime(), bk.getaTime());
						db.insertRecipt(mb);
						if(b) {
							if(jd instanceof MainPageFrame) {
								dispose();	
							}else {
							jd.dispose();
							dispose();}
							
						}
					}
				});
				btnPay.setFont(new Font("HY강M", Font.BOLD, 15));
				
				JLabel lblNewLabel_4 = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561");
				lblNewLabel_4.setBounds(547, 226, 122, 27);
				pnBG.add(lblNewLabel_4);
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_4.setFont(new Font("HY강M", Font.BOLD, 17));
				
				JPanel pnBG2 = new JPanel();
				pnBG2.setBackground(new Color(70, 130, 180));
				pnBG2.setBounds(12, 277, 910, 307);
				pnMain.add(pnBG2);
				pnBG2.setLayout(null);
				
				JLabel lblPointPay = new JLabel("'\uD3EC\uC778\uD2B8 \uACB0\uC81C'");
				lblPointPay.setForeground(new Color(0, 0, 0));
				lblPointPay.setBounds(12, 10, 122, 20);
				pnBG2.add(lblPointPay);
				lblPointPay.setFont(new Font("HY강M", Font.BOLD, 17));
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(29, 43, 861, 168);
//		pnMain.add(scrollPane);
//		
//		String column[] = {"열차번호", "기차종류", "행선지", "출발시간", "도착시간", "운행방향"}; //F
//		DefaultTableModel def= new DefaultTableModel(column, 0);
//		table = new JTable();
//		scrollPane.setViewportView(table);
		// Pay-1, Table
	}
}
