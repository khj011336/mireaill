package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import admin.Admin;
import admin.Admin.insertT;
import adminGui.TrainGu;
import adminGui.Traintime;
import booking.BookingDBMgr;
import booking.Bookshow;
import booking.booking;
import booking.ui.BookingGui;
import booking.ui.ChoiceDlg;
import member.Member;
import member.db.MemberDBManager;
import member.myPage.MemberMyPageDialog;

import pay.bookingSystemforUser;
import railmap.RailMap;
import trainRail.Rail;
import viaRail.ViaRail;
import viaRail.ViaRailDB;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainPageFrame extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table;
	JComboBox DCombo;
	JComboBox ACombo;
	Connection con;
	DefaultTableModel tbm;
	private MainPageFrame frm;
	LogPanel panel_5;
	String loggednow;
	int selectedSeat;
	JFrame frm2;
	String trainname;
	String trainNI[];
	String Dtime;
	String Atime;
	String Drail;
	String Arail;
	int price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					MainPageFrame frame = new MainPageFrame();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPageFrame() {

		this.frm2 = this;
		this.frm = this;
		Admin ad = new Admin();
		ad.connectTrainDB();
		this.con = ad.con;
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("DBÁ¾·á");
				ad.closeTrainDB();
			}
		});
		insertT adinner = ad.new insertT();
		setTitle("Mirail(\uAE30\uCC28\uC608\uB9E4\uD504\uB85C\uADF8\uB7A8)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 676);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("\uB178\uC120 \uC548\uB0B4");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("-\uD589\uC120\uC9C0 \uC548\uB0B4");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("-\uAE30\uCC28\uC694\uAE08 \uC548\uB0B4");
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("-\uC774\uC6A9 \uC548\uB0B4");
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("\uC608\uB9E4 \uBC0F \uC870\uD68C");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("- \uC870\uD68C \uBC0F \uC608\uB9E4");
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("- \uC608\uC57D \uC2B9\uCC28\uAD8C \uC870\uD68C");
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("- \uC608\uC57D \uBCC0\uACBD \uBC0F \uCDE8\uC18C");
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("- \uC608\uB9E4\uD2F0\uCF13 \uCD9C\uB825");
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenu menu = new JMenu("\uB9C8\uC774\uD398\uC774\uC9C0");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("- \uD68C\uC6D0 \uC815\uBCF4");
		menu.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("- \uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
		menu.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("- \uD68C\uC6D0 \uD0C8\uD1F4");
		menu.add(menuItem_2);

		JMenu menu_1 = new JMenu("\uBBF8\uB808\uC77C \uBA64\uBC84\uC2ED");
		menuBar.add(menu_1);

		JMenuItem menuItem_4 = new JMenuItem("- \uBA64\uBC84\uC2ED \uB4F1\uAE09\uC548\uB0B4");
		menu_1.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("- \uBA64\uBC84\uC2ED \uD3EC\uC778\uD2B8 \uC870\uD68C/");
		menu_1.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		Panel panel_4 = new Panel();
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 5, 0, 0));

		Panel panel_6 = new Panel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("MiRail");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 22));
		panel_6.add(lblNewLabel_2);

		Panel panel_7 = new Panel();
		panel_4.add(panel_7);

		JLabel menu_2 = new JLabel("\uB178\uC120 \uC548\uB0B4");
		menu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RailMap rm = new RailMap();
				rm.setVisible(true);
			}
		});
//		//menu_2.addAncestorListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				RailMap rm = new RailMap();
//				rm.setVisible(true);
//			}
//		});
		menu_2.setForeground(Color.WHITE);
		menu_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		panel_7.add(menu_2);

		JMenuItem menuItem_3 = new JMenuItem("-\uD589\uC120\uC9C0 \uC548\uB0B4");
		menu_2.add(menuItem_3);

		JMenuItem menuItem_6 = new JMenuItem("-\uAE30\uCC28\uC694\uAE08 \uC548\uB0B4");
		menu_2.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("-\uC774\uC6A9 \uC548\uB0B4");
		menu_2.add(menuItem_7);

		Panel panel_8 = new Panel();
		panel_4.add(panel_8);

		JLabel label_2 = new JLabel("\uC608\uB9E4 \uBC0F \uC870\uD68C");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loggednow = panel_5.LOGGED_IN;
				BookingGui gu = new BookingGui(con, loggednow);
				gu.setVisible(true);
			}
		});
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		panel_8.add(label_2);

		Panel panel_9 = new Panel();
		panel_4.add(panel_9);

		JMenu menu_4 = new JMenu("\uB9C8\uC774\uD398\uC774\uC9C0");
		menu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (LogPanel.LOGGED_IN != null && !LogPanel.LOGGED_IN.isEmpty()) {
					MemberMyPageDialog dlg = new MemberMyPageDialog(frm, true);

					dlg.setVisible(true);
				}
			}
		});
		menu_4.setForeground(Color.WHITE);
		menu_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		panel_9.add(menu_4);

		JMenuItem menuItem_12 = new JMenuItem("- \uD68C\uC6D0 \uC815\uBCF4");
		menu_4.add(menuItem_12);

		JMenuItem menuItem_13 = new JMenuItem("- \uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
		menu_4.add(menuItem_13);

		JMenuItem menuItem_14 = new JMenuItem("- \uD68C\uC6D0 \uD0C8\uD1F4");
		menu_4.add(menuItem_14);

		Panel panel_10 = new Panel();
		panel_4.add(panel_10);

		JMenu menu_5 = new JMenu("\uBBF8\uB808\uC77C \uBA64\uBC84\uC2ED");
		menu_5.setForeground(Color.WHITE);
		menu_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		panel_10.add(menu_5);

		JMenuItem menuItem_15 = new JMenuItem("- \uBA64\uBC84\uC2ED \uB4F1\uAE09\uC548\uB0B4");
		menu_5.add(menuItem_15);

		JMenuItem menuItem_16 = new JMenuItem("- \uBA64\uBC84\uC2ED \uD3EC\uC778\uD2B8 \uC870\uD68C/");
		menu_5.add(menuItem_16);

		panel_5 = new LogPanel();

		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		contentPane.add(panel_3, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));

		Panel panel_11 = new Panel();
		panel_2.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));

		Panel panel_19 = new Panel();
		FlowLayout flowLayout = (FlowLayout) panel_19.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		panel_11.add(panel_19);
		panel_19.setVisible(true);
		JLabel label = new JLabel("\uCD9C\uBC1C\uC5ED");
		label.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		panel_19.add(label);

		DCombo = new JComboBox();

		ArrayList<Rail> rl = adinner.selectAllRail();
		String[] railNames = new String[rl.size()];
		String[] railNames2 = new String[rl.size()];
		for (int i = 0; i < rl.size(); i++) {
			railNames[i] = "-" + rl.get(i).getRailCode() + "-" + rl.get(i).getRailName();
			railNames2[i] = "-" + rl.get(i).getRailCode() + "-" + rl.get(i).getRailName();
		}
		DCombo.setModel(new DefaultComboBoxModel(railNames));
		panel_19.add(DCombo);

		Panel panel_20 = new Panel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_20.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		panel_11.add(panel_20);

		JLabel label_1 = new JLabel("\uB3C4\uCC29\uC5ED \uC870\uD68C :");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		panel_20.add(label_1);

		ACombo = new JComboBox();
		ACombo.setModel(new DefaultComboBoxModel(railNames2));
		panel_20.add(ACombo);
		ACombo.setVisible(true);

		Panel panel_12 = new Panel();
		panel_12.setBackground(Color.DARK_GRAY);
		panel_2.add(panel_12, BorderLayout.CENTER);

		panel_12.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_12.add(scrollPane, BorderLayout.CENTER);

		tbm = new DefaultTableModel(new Object[] { "±âÂ÷ÀÌ¸§", "Ãâ¹ß½Ã°£", "µµÂø½Ã°£", "Ãâ¹ß¿ª", "µµÂø¿ª", "°¡°Ý" }, 0);

		JPanel panel_22 = new JPanel();
		panel_22.setBackground(Color.DARK_GRAY);
		panel_12.add(panel_22, BorderLayout.SOUTH);
		panel_22.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("\uC870\uD68C");
		ViaRailDB vr = new ViaRailDB(con);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int d = tbm.getRowCount();
				for (int j = 0; j < d; j++) {
					tbm.removeRow(0);
				}

				System.out.println("´­¸²");
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
				int count = 0;
				// TODO ¹è¿­Á¤·Ä//
				ArrayList<Bookshow> bkLst = new ArrayList<Bookshow>();
				for (int i = 0; i < vvrs.size(); i++) {
					if (vvrs.get(i).getDstart() >= Integer.parseInt(Acode)) {
						if (vvrs.get(i).getDRailCode().equals(Dcode)) {
							// if ((vvrs.get(i).getEnd()+"").equals(Dcode) ) {
							System.out.println(vvrs.get(i).getEnd() + "·¹ÀÏÄÚµå !!!!!");
							dtime = vvrs.get(i).getDTime();
							trainid = vvrs.get(i).getTrainID();
							ShowTrainid = vvrs.get(i).getTrainID() + "-" + vvrs.get(i).getTrainName() + "-";
						} else {
							continue;
						}
						for (int j = 0; j < vvrs.size(); j++) {

							if (vvrs.get(j).getTrainID().equals(trainid) && vvrs.get(j).getARailCode().equals(Acode)) {
								System.out.println(vvrs.get(j).getARailCode() + "·¹ÀÏÄÚµå !");
								atime = vvrs.get(j).getATime();

							} else {
								continue;
							}
						}

						bookingSystemforUser bkst = new bookingSystemforUser(con);
						bookingSystemforUser bk = bkst.bookingAtoB(trainid, Integer.parseInt(Dcode),
								Integer.parseInt(Acode));
						if (atime.isEmpty())
							atime = "¾øÀ½-¾øÀ½";
						String Atime[] = atime.split("-");
						Bookshow bks = new Bookshow(ShowTrainid, dtime, String.format("%s½Ã%sºÐ", Atime[0], Atime[1]),
								DcodeS, AcodeS, bk.getPay());

						bkLst.add(bks);

					}
				}

				System.out.println(bkLst);
				Comparator<Bookshow> salesComparator = new Comparator<Bookshow>() {
					@Override
					public int compare(Bookshow o1, Bookshow o2) {
						return (o1.getDtime()).compareTo(o2.getDtime());
					}
				};
				Collections.sort(bkLst, salesComparator);

				for (int i = 0; i < bkLst.size(); i++) {
					// Collections.sort(bkLst);
					tbm.addRow(
							new Object[] { bkLst.get(i).getTrainid(), bkLst.get(i).getDtime(), bkLst.get(i).getAtime(),
									bkLst.get(i).getDcodes(), bkLst.get(i).getAcodes(), bkLst.get(i).getPay() });
				}

			}
		});
		JTable table = new JTable();

		scrollPane.setViewportView(table);
		table.setEnabled(true);

		table.setModel(tbm);
		panel_22.add(btnNewButton, BorderLayout.EAST);

		JButton btnNewButton_1 = new JButton("\uC608\uB9E4");

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					trainname = (String) table.getValueAt(row, 0);
					trainNI = trainname.split("-");
					System.out.println(trainNI[0] + trainNI[1]);
					Dtime = (String) table.getValueAt(row, 1);
					Atime = (String) table.getValueAt(row, 2);
					Drail = (String) table.getValueAt(row, 3);
					Arail = (String) table.getValueAt(row, 4);
					price = (int) table.getValueAt(row, 5);
//					MemberDBManager mb = new MemberDBManager(con);
//					Member nemb = mb.selectOneMemberByID(panel_5.LOGGED_IN);
//					BookingDBMgr bdb = new BookingDBMgr(con);
//					ArrayList<booking> bkl =bdb.selectAllMembers(trainNI[0]);
//					selectedSeat = 0;
//					for (int i = 0; i < bkl.size(); i++) {
//						System.out.println(bkl.get(i).getPkUser());
//						if(bkl.get(i).getPkUser() == -1) {
//							selectedSeat = bkl.get(i).getSeat();
//							break;
//						}
//					}
				}
			}
		});

		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MemberDBManager mb = new MemberDBManager(con);
				Member nemb = mb.selectOneMemberByID(panel_5.LOGGED_IN);
				BookingDBMgr bdb = new BookingDBMgr(con);
				ArrayList<booking> bkl = bdb.selectAllMembers(trainNI[0]);
				selectedSeat = 0;
				for (int i = 0; i < bkl.size(); i++) {
					System.out.println(bkl.get(i).getPkUser());
					if (bkl.get(i).getPkUser() == -1) {
						selectedSeat = bkl.get(i).getSeat();
						break;
					}
				}

				if (panel_5.LOGGED_IN != null && nemb != null && selectedSeat != 0) {
					booking bk = new booking(trainNI[0], trainNI[1], Drail, Arail, nemb.getName(), price, selectedSeat,
							"2020-1-1", Dtime, Atime, "");
					System.out.println(1 + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
					ChoiceDlg Cdlg = new ChoiceDlg(frm2, false, bk, con, nemb);
					Cdlg.setVisible(true);
					// Cdlg.setModal(true);
					Cdlg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				} else {
					xbox x = new xbox();
					x.setVisible(true);
				}
			}
		});

		panel_22.add(btnNewButton_1, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("                                                                           ");
		panel_22.add(lblNewLabel, BorderLayout.WEST);

		Panel panel_18 = new Panel();
		panel_18.setForeground(Color.WHITE);

		contentPane.add(panel_18, BorderLayout.WEST);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(Color.DARK_GRAY);
		lblNewLabel_3.setVisible(true);
		panel_18.setLayout(new BorderLayout(0, 0));
		lblNewLabel_3.setBorder(new LineBorder(Color.white));
		lblNewLabel_3.setIcon(new ImageIcon(".\\imgs\\c4.jpg"));
		panel_18.add(lblNewLabel_3);

		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.DARK_GRAY);
		panel_18.add(panel_21, BorderLayout.SOUTH);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		panel_21.add(lblNewLabel_4);

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.DARK_GRAY);
		panel_18.add(panel_23, BorderLayout.NORTH);
		Traintime tr = new Traintime(false);
		panel_23.add(tr);
		tr.setBackground(Color.DARK_GRAY);
		tr.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
