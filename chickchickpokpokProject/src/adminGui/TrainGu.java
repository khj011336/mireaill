package adminGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import admin.Admin;
import admin.Admin.insertT;
import trainPack.Train;
import trainRail.Rail;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.PopupMenu;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class TrainGu extends JFrame {
	JPanel panel_10;
	private JPanel panel_9;
	private JPanel panel_8;
	private JPanel panel_7;
	private JComboBox comboBox_2;
	private JPanel panel_2;
	private JLabel lblCrud;
	private JTextField averegeSpeedT;
	private JTextField seatT;
	private JTextField maxSeatT;
	public JPanel panel_1;
	private JTextField textField;
	private JPanel PnTrainSEL;
	private JTextField DelTEXT;
	private JPanel PnDel;
	private JComboBox Trains;
	private JPanel contentPane;
	private JComboBox SetupArailcode;
	JPanel panel_4;
	insertT adminInner;
	private String updateTrainId;
	JPanel RailPanel;
	JPanel panel_5;
	JPanel panel_6;
	JPanel panel_3;
	public ArrayList<JButton> btnArr;
	private JTextField RailTextLength;
	private JTextField RailTextRailName;
	private JTextField RailTextPrice;
	private JTextField RailTextLocation;
	private JComboBox SetUpTrainID;
	private JTextField RailCodeText;
	private JComboBox SetupDrailcode;
	private DefaultTableModel dft;
	private DefaultTableModel dft1;
	private JLabel lblNewLabel_19;
	private JTable table;
	private JTextField SetupDDateTxt;
	private JTextField SetupDtimeTxt;
	private JTable table_1;
	public DefaultComboBoxModel<String> getTmodel() {
		return Tmodel;
	}

	public void setTmodel(DefaultComboBoxModel<String> tmodel) {
		Tmodel = tmodel;
	}

	private TrainGu frm;
	private DefaultComboBoxModel<String> Tmodel;
	public JTextField getSetupDDateTxt() {
		return SetupDDateTxt;
	}

	public void setSetupDDateTxt(JTextField setupDDateTxt) {
		SetupDDateTxt = setupDDateTxt;
	}

	public JTextField getSetupDtimeTxt() {
		return SetupDtimeTxt;
	}

	public void setSetupDtimeTxt(JTextField setupDtimeTxt) {
		SetupDtimeTxt = setupDtimeTxt;
	}

	public JComboBox getSetupArailcode() {
		return SetupArailcode;
	}

	public void setSetupArailcode(JComboBox setupArailcode) {
		SetupArailcode = setupArailcode;
	}

	public JComboBox getSetUpTrainID() {
		return SetUpTrainID;
	}

	public void setSetUpTrainID(JComboBox setUpTrainID) {
		SetUpTrainID = setUpTrainID;
	}

	public JComboBox getSetupDrailcode() {
		return SetupDrailcode;
	}

	public void setSetupDrailcode(JComboBox setupDrailcode) {
		SetupDrailcode = setupDrailcode;
	}

	public JTextField getSetupDTime() {
		return SetupDDateTxt;
	}

	public void setSetupDTime(JTextField setupDTime) {
		SetupDDateTxt = setupDTime;
	}

	public JTextField getSetupAtime() {
		return SetupDtimeTxt;
	}

	public void setSetupAtime(JTextField setupAtime) {
		SetupDtimeTxt = setupAtime;
	}

	public JPanel getPanel_6() {
		return panel_6;
	}

	public void setPanel_6(JPanel panel_6) {
		this.panel_6 = panel_6;
	}

	public String getUpdateTrainId() {
		return updateTrainId;
	}

	public void setUpdateTrainId(String updateTrainId) {
		this.updateTrainId = updateTrainId;
	}

	private int UpdateNum;
	private String updateValue;

	public String getUpdateValue() {
		return updateValue;
	}

	public void setUpdateValue(String updateValue) {
		this.updateValue = updateValue;
	}

	public DefaultTableModel getDft1() {
		return dft1;
	}

	public void setDft1(DefaultTableModel dft1) {
		this.dft1 = dft1;
	}

	public int getUpdateNum() {
		return UpdateNum;
	}

	public void setUpdateNum(int updateNum) {
		UpdateNum = updateNum;
	}

	public DefaultTableModel getDft() {
		return dft;
	}

	public void setDft(DefaultTableModel dft) {
		this.dft = dft;
	}

	public JTextField getRailCodeText() {
		return RailCodeText;
	}

	public void setRailCodeText(JTextField railCodeText) {
		RailCodeText = railCodeText;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JComboBox getTrains() {
		return Trains;
	}

	public void setTrains(JComboBox trains) {
		Trains = trains;
	}

	public JComboBox getComboBox_2() {
		return comboBox_2;
	}

	public void setComboBox_2(JComboBox comboBox_2) {
		this.comboBox_2 = comboBox_2;
	}

	public JTextField getAveregeSpeedT() {
		return averegeSpeedT;
	}

	public void setAveregeSpeedT(JTextField averegeSpeedT) {
		this.averegeSpeedT = averegeSpeedT;
	}

	public JTextField getSeatT() {

		return seatT;
	}

	public void setSeatT(JTextField seatT) {
		this.seatT = seatT;
	}

	public JTextField getMaxSeatT() {
		return maxSeatT;
	}

	public void setMaxSeatT(JTextField maxSeatT) {
		this.maxSeatT = maxSeatT;
	}

	public JPanel getPanel_2() {
		return panel_2;
	}

	public void setPanel_2(JPanel panel_2) {
		this.panel_2 = panel_2;
	}

	public JLabel getLblCrud() {
		return lblCrud;
	}

	public void setLblCrud(JLabel lblCrud) {
		this.lblCrud = lblCrud;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPanel getPnTrainSEL() {
		return PnTrainSEL;
	}

	public void setPnTrainSEL(JPanel pnTrainSEL) {
		PnTrainSEL = pnTrainSEL;
	}

	public JTextField getDelTEXT() {
		return DelTEXT;
	}

	public void setDelTEXT(JTextField delTEXT) {
		DelTEXT = delTEXT;
	}

	public JPanel getPnDel() {
		return PnDel;
	}

	public void setPnDel(JPanel pnDel) {
		PnDel = pnDel;
	}

//	public void RailTable() {
//		panel_6 = new JPanel();
//		panel_3.add(panel_6, BorderLayout.SOUTH);
//		panel_6.setVisible(false);
//		JScrollPane scrollPane = new JScrollPane();
//		panel_6.add(scrollPane);
//
//		scrollPane.setViewportView(table);
//	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainGu frame = new TrainGu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String findY(JButton j) {
		int Y = Math.abs(btnArr.get(0).getY() - btnArr.get(13).getY());
//		System.out.println(Y + "절대 Y");
		int YR = btnArr.get(0).getY();
		String y = "";
		int id = 0;
		int plust = 13;
		for (int i = 0; i < adminInner.tr.size(); i++) {
			if (j.getY() == YR) {
				y = btnArr.get(id).getText();
				break;
			}
			id += plust;
			YR += Y;
		}
		return y;
	}

	/**
	 * Create the frame.
	 */
	public TrainGu() {
		Admin ad = new Admin();
		ad.connectTrainDB();
		frm = this;
		setTitle("AdminPage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1145, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		
		JLabel lblMirail = new JLabel("MiRail  ");
		lblMirail.setHorizontalAlignment(SwingConstants.CENTER);
		lblMirail.setForeground(Color.BLACK);
		lblMirail.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 22));
		panel.add(lblMirail);
		Traintime tr_1 =new Traintime(true);
		
		tr_1.setForeground(Color.BLACK);
		panel.add(tr_1);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblType = new JLabel("TYPE");
		panel.add(lblType);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Train", "Rail", "TrainContainer" }));
		comboBox.setSelectedIndex(0);

		Trains = new JComboBox();

		comboBox.setMaximumRowCount(3);
		panel.add(comboBox);

		lblCrud = new JLabel("\uC885\uB958");
		panel.add(lblCrud);

		panel.add(Trains);

		JLabel lblNewLabel = new JLabel("\uBA85\uB839");
		panel.add(lblNewLabel);

		comboBox_2 = new JComboBox();

		panel.add(comboBox_2);

		JButton Enter = new JButton("\uC785\uB825");

		panel.add(Enter);
		
		JLabel lblNewLabel_23 = new JLabel("New label");

		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		adminInner = ad.new insertT(this);
		Trains.addActionListener(adminInner);

		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JComboBox jbbox = (JComboBox) e.getSource();
				if (comboBox.getModel().getSelectedItem() == "TrainContainer") {
					if (jbbox.getSelectedItem() == "기차스케쥴셋업") {
						panel_7.setVisible(true);
						panel_4.setVisible(true);
						ArrayList<Train> tr = adminInner.selectAllTrain();
						ArrayList<Rail> Rl = adminInner.selectAllRail();
						String Rail[] = new String[Rl.size()];
						for (int i = 0; i < Rl.size(); i++) {
							Rail[i] = "-" + Rl.get(i).getRailCode() + "-" + Rl.get(i).getRailName();

						}
						String trid[] = new String[tr.size()];

						for (int i = 0; i < tr.size(); i++) {
							if(tr.get(i).getRunOrNot() == 1) {
								trid[i] = String.format("<html><font color="+"\""+"red"+"\""+">%s</font></html>", tr.get(i).getTrainID() + "-" + tr.get(i).getTrainName() + "(운행중)");
							}else {
							trid[i] = tr.get(i).getTrainID() + "-" + tr.get(i).getTrainName() + "-";
							}

						}
						 Tmodel = new DefaultComboBoxModel<String>(trid);
						DefaultComboBoxModel<String> TRail = new DefaultComboBoxModel<String>(Rail);
						DefaultComboBoxModel<String> TRail2 = new DefaultComboBoxModel<String>(Rail);
						SetUpTrainID.setModel(Tmodel);
						SetupDrailcode.setModel(TRail);
						SetupArailcode.setModel(TRail2);
						panel_7.setVisible(true);

					} else {
						panel_7.setVisible(false);
					}
					if (jbbox.getSelectedItem() == "스케쥴전부보기") {
						getPanel_9().setVisible(true);
					} else {
						getPanel_9().setVisible(false);
					}
					if (jbbox.getSelectedItem() == "스케쥴변경") {
						getPanel_9().setVisible(true);
					} if(jbbox.getSelectedItem() == "스케쥴삭제") {
						panel_10.setVisible(true);
						System.out.println();
					}else {
						panel_10.setVisible(false);
					}
						
				} else if (comboBox.getModel().getSelectedItem() == "Rail") {
					panel_2.setVisible(false);
					if (jbbox.getSelectedItem() == "레일추가") {
						RailPanel.setVisible(true);
						panel_4.setVisible(true);

					} else {
						RailPanel.setVisible(false);
					}
					if (jbbox.getSelectedItem() == "레일하나보기") {
						panel_5.setVisible(true);
						panel_4.setVisible(true);
						panel_6.setVisible(true);
						panel_8.setVisible(true);

					} else {
						panel_5.setVisible(false);
						panel_6.setVisible(false);
					}
					if (jbbox.getSelectedItem() == "레일전부보기") {
						panel_6.setVisible(true);
						panel_8.setVisible(true);
					} else {

					}

				} else if (comboBox.getModel().getSelectedItem() == "Train") {

					RailPanel.setVisible(false);
					panel_6.setVisible(false);
					if (jbbox.getSelectedItem() == "기차추가") {
						panel_4.setVisible(true);
						panel_1.setVisible(true);
					} else {
						panel_1.setVisible(false);
					}
					if (jbbox.getSelectedItem() == "기차하나보기") {
						for (int i = 0; i < 13; i++) {
							btnArr.get(i).setBackground(Color.yellow);
						}
						panel_4.setVisible(true);
						PnTrainSEL.setVisible(true);
						panel_8.setVisible(true);
					} else {
						PnTrainSEL.setVisible(false);
					}
					if (jbbox.getSelectedItem() == "기차전부보기") {
						panel_4.setVisible(true);
						panel_2.setVisible(true);
						panel_8.setVisible(true);
					} else {
						panel_2.setVisible(false);
					}
					if (jbbox.getSelectedItem() == "기차갱신") {
						adminInner.ShowAllTrain(adminInner.tr.size());

						for (int i = 0; i < btnArr.size(); i++) {
							btnArr.get(i).setEnabled(true);
						}

						panel_4.setVisible(true);
						panel_2.setVisible(true);
					} else {
						panel_2.setVisible(false);
					}
					if (jbbox.getSelectedItem() == "기차삭제") {
						int Tid = 0;
						adminInner.ShowAllTrain(adminInner.tr.size());
						for (int i = 0; i < adminInner.tr.size(); i++) {
							if (i == 0) {
								btnArr.get(i).setBackground(Color.yellow);
								btnArr.get(i).setEnabled(true);
							} else {
								btnArr.get((i * Tid)).setBackground(Color.yellow);
								btnArr.get(i * Tid).setEnabled(true);
							}
							adminInner.ShowAllTrain(adminInner.tr.size());
							Tid = 13;
						}
						panel_4.setVisible(true);
						PnDel.setVisible(true);

					} else {
						PnDel.setVisible(false);
					}
				}
			}
		});

		panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setVisible(false);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		PnTrainSEL = new JPanel();
		PnTrainSEL.setVisible(false);

		panel_7 = new JPanel();
		panel_7.setVisible(false);
		
		panel_10 = new JPanel();
		panel_10.setVisible(false);
		panel_4.add(panel_10);
		
		JButton btnNewButton = new JButton("\uC0AD\uC81C");
		panel_10.add(btnNewButton);
		panel_4.add(panel_7);

		JLabel lblNewLabel_20 = new JLabel("TrainID");
		panel_7.add(lblNewLabel_20);
//TODO 
		SetUpTrainID = new JComboBox();
		panel_7.add(SetUpTrainID);

		JLabel lblNewLabel_21 = new JLabel("DRailCode");
		panel_7.add(lblNewLabel_21);

		SetupDrailcode = new JComboBox();
		panel_7.add(SetupDrailcode);

		JLabel lblNewLabel_22 = new JLabel("ARailCode");
		panel_7.add(lblNewLabel_22);

		SetupArailcode = new JComboBox();

		panel_7.add(SetupArailcode);

		JLabel SetupDdate = new JLabel("\uCD9C\uBC1C \uB0A0\uC790");
		panel_7.add(SetupDdate);

		SetupDDateTxt = new JTextField();
		panel_7.add(SetupDDateTxt);
		SetupDDateTxt.setColumns(10);
		
		JLabel lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setIcon(new ImageIcon(".\\imgs\\calendar.png"));
		lblNewLabel_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Datetrain dr = new Datetrain(frm);
				
				dr.setVisible(true);
			}
		});
		panel_7.add(lblNewLabel_25);

		JLabel lblNewLabel_24 = new JLabel("\uCD9C\uBC1C \uC2DC\uAC04");
		panel_7.add(lblNewLabel_24);

		SetupDtimeTxt = new JTextField();
		panel_7.add(SetupDtimeTxt);
		SetupDtimeTxt.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<String> cb= (JComboBox)arg0.getSource();
			SetupDtimeTxt.setText(	(String)cb.getSelectedItem());
			}
		});
		DefaultComboBoxModel<String> time = new DefaultComboBoxModel<String>();
		Date dt= new Date();
		for (int i = 1; i <= 24; i++) {
			if(dt.getHours() < i) {
			time.addElement(i+"-"+"00");
			time.addElement(i+"-"+"30");
			}
		}
		comboBox_1.setModel(time);
		panel_7.add(comboBox_1);
		panel_4.add(PnTrainSEL);
		PnTrainSEL.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel LBTrainSelect = new JLabel("TrainID");
		PnTrainSEL.add(LBTrainSelect);
		LBTrainSelect.setHorizontalAlignment(SwingConstants.CENTER);

		textField = new JTextField();
		PnTrainSEL.add(textField);
		textField.setColumns(10);

		panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		dft = new DefaultTableModel(
				new String[] { "RailCode", "Location", "PriceOfThis", "LengthOfThis", "Time", "RailName", "RailNumb" },
				0);

		//
//		JPanel panel_9 = new JPanel();
//		JTable table_1 = new JTable();
//		table_1.setVisible(true);
//		panel_9.setVisible(false);
//		panel_9.setLayout(new BorderLayout(0, 0));
//		panel_9.add(table_1, BorderLayout.SOUTH);
//		JScrollPane scrollPane_1 = new JScrollPane(table_1);
//		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		//scrollPane.setViewportView(table_1);
//		panel_9.add(scrollPane_1, BorderLayout.NORTH);
		//
		JLabel lblNewLabel_2 = new JLabel("averegeSpeed");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("maxSeat");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_1 = new JLabel("seat");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		averegeSpeedT = new JTextField();
		panel_1.add(averegeSpeedT);
		averegeSpeedT.setColumns(10);

		maxSeatT = new JTextField();
		panel_1.add(maxSeatT);
		maxSeatT.setColumns(10);

		seatT = new JTextField();
		panel_1.add(seatT);
		seatT.setColumns(10);

		JLabel label = new JLabel("");
		panel_1.add(label);

		JLabel lblNewLabel_18 = new JLabel("");
		panel_1.add(lblNewLabel_18);

		PnDel = new JPanel();
		panel_4.add(PnDel);

		JLabel lblDeltrainid = new JLabel("DelTrainID");
		lblDeltrainid.setHorizontalAlignment(SwingConstants.CENTER);
		PnDel.add(lblDeltrainid);

		DelTEXT = new JTextField();
		PnDel.add(DelTEXT);
		DelTEXT.setColumns(10);

		RailPanel = new JPanel();
		panel_4.add(RailPanel);
		RailPanel.setVisible(false);

		JLabel lblNewLabel_15 = new JLabel("location");
		RailPanel.setLayout(new GridLayout(4, 4, 0, 0));
		RailPanel.add(lblNewLabel_15);

		RailTextLocation = new JTextField();
		RailPanel.add(RailTextLocation);
		RailTextLocation.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("priceofThis");
		RailPanel.add(lblNewLabel_17);

		RailTextPrice = new JTextField();
		RailPanel.add(RailTextPrice);
		RailTextPrice.setColumns(10);

		JLabel RailLabel = new JLabel("lengthofThis");
		RailPanel.add(RailLabel);

		RailTextLength = new JTextField();
		RailPanel.add(RailTextLength);
		RailTextLength.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("railName");
		RailPanel.add(lblNewLabel_16);

		RailTextRailName = new JTextField();
		RailPanel.add(RailTextRailName);
		RailTextRailName.setColumns(10);

		panel_5 = new JPanel();
		panel_5.setVisible(false);
		panel_4.add(panel_5);

		lblNewLabel_19 = new JLabel("RailCode");
		panel_5.add(lblNewLabel_19);

		RailCodeText = new JTextField();
		RailCodeText.setText("RailCodeText");
		panel_5.add(RailCodeText);
		RailCodeText.setColumns(10);

		panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.CENTER);
		// new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		//
		// }
		// });TODO
		panel_6 = new JPanel();
		panel_8.add(panel_6);
		table = new JTable();
		getTable().setModel(dft);
		getTable().setVisible(true);
		panel_6.setVisible(false);
		panel_6.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(table);
		panel_6.add(scrollPane);

		panel_2 = new JPanel();
		panel_8.add(panel_2);
		panel_2.setVisible(false);
		panel_2.setLayout(new GridLayout(0, 13, 0, 0));

		JLabel lblNewLabel_5 = new JLabel("trainID");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_5);
		JLabel lblNewLabel_4 = new JLabel("trainName");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_9 = new JLabel("averegeSpeed");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_9);

		JLabel lblNewLabel_8 = new JLabel("price");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_8);

		JLabel lblNewLabel_7 = new JLabel("seat");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("maxSeat");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_6);

		JLabel lblLength = new JLabel("Length");
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblLength);

		JLabel lblRunornot = new JLabel("RunORNot");
		lblRunornot.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblRunornot);

		JLabel lblNewLabel_13 = new JLabel("dRailCode");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_13);

		JLabel lblNewLabel_12 = new JLabel("aRailCode");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_12);

		JLabel lblNewLabel_10 = new JLabel("DDate");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_10);

		JLabel lblNewLabel_14 = new JLabel("Atime");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_14);

		JLabel lblNewLabel_11 = new JLabel("DTime");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_11);
		// TODO
		panel_9 = new JPanel();
		panel_9.setVisible(false);
		panel_8.add(panel_9);
		dft1 = new DefaultTableModel(new String[] { "RailCode", "ArailCode", "TrainID", "Price", "DDate", "DTime",
				"Atime", "Seat", "Length" }, 0);
		table_1 = new JTable(dft1);
		table_1.setFillsViewportHeight(true);
		table_1.setVisible(true);
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setVisible(true);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_9.add(scrollPane_1);

		//

		PnDel.setVisible(false);
		btnArr = new ArrayList<JButton>();
		for (int i = 0; i < 13 * adminInner.tr.size(); i++) {
			JButton jb = new JButton("");
			jb.setSize(10, 10);
			jb.setEnabled(false);
			btnArr.add(jb);

			panel_2.add(jb);
		}

		System.out.println(btnArr.size());
		Enter.addActionListener(adminInner);
		JButton jq = new JButton();
		JFrame jf = new JFrame();
		JTextField jt = new JTextField();
		jq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateValue = jt.getText();
				jf.dispose();
			}
		});
		for (int i = 0; i < btnArr.size(); i++) {
			btnArr.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(btnArr.get(1).getX() + "버튼 X" + btnArr.get(1).getY() + "버튼 Y");
					JButton jbt = (JButton) e.getSource();
					// System.out.println(jbt.get.getName());

					jt.setColumns(10);
					jt.setBounds(0, 0, 100, 100);
					jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jf.setBounds(100, 100, 150, 150);
					JPanel contentPane1;
					contentPane1 = new JPanel();
					contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
					contentPane1.setLayout(new BorderLayout(0, 0));
					contentPane1.add(jt);
					contentPane1.setLayout(new FlowLayout());

					jq.setText("확인");
					contentPane1.add(jq);
					jf.setContentPane(contentPane1);
					jf.setVisible(true);
					int X = jbt.getX();
					int X1 = btnArr.get(0).getX();
					int Xminus = Math.abs(btnArr.get(0).getX() - btnArr.get(1).getX());
					System.out.println(btnArr.get(0).getX() - btnArr.get(1).getX());
					System.out.println(X1 + "aaa" + Xminus);
					int upadate = 1;
					for (int j = 0; j < 13; j++) {
						if (X == X1) {
							updateTrainId = findY(jbt);
							UpdateNum = upadate;
							break;
						}
						upadate++;
						X1 += Xminus;
					}

					System.out.println(jbt.getX() + "X" + jbt.getY() + "Y");
					System.out.println(UpdateNum + "업데이트넘");
					System.out.println(updateTrainId + "트레인아디");
				}

			});
		}
//		Trains.setModel(new DefaultComboBoxModel(new String[] { "KTX", "Mugunwha", "Sanuri" }));
		// comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "기차추가", "기차하나보기",
		// "기차전부보기", "기차갱신", "기차삭제" }));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> comboBox = (JComboBox) e.getSource();
				String cb = comboBox.getSelectedItem().toString();
				if (cb == "Train") {
					panel_10.setVisible(false);
					RailPanel.setVisible(false);
					panel_6.setVisible(false);
					getPanel_9().setVisible(false);
					PnDel.setVisible(false);
					panel_7.setVisible(false);
					RailPanel.setVisible(false);
					Trains.setModel(new DefaultComboBoxModel(new String[] { "KTX", "Mugunwha", "Sanuri", }));
					comboBox_2.setModel(
							new DefaultComboBoxModel(new String[] { "기차추가", "기차하나보기", "기차전부보기", "기차갱신", "기차삭제" }));
					Trains.setVisible(true);
					lblCrud.setVisible(true);

				} else if (cb == "Rail") {
					panel_10.setVisible(false);
					panel_5.setVisible(false);
					getPanel_9().setVisible(false);
					panel_2.setVisible(false);
					PnDel.setVisible(false);
					panel_7.setVisible(false);
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "레일추가", "레일하나보기", "레일전부보기", "레일삭제" }));
					Trains.setVisible(false);
					lblCrud.setVisible(false);
					panel_1.setVisible(false);
				} else if (cb == "TrainContainer") {
					panel_5.setVisible(false);
					RailPanel.setVisible(false);
					panel_6.setVisible(false);
					panel_2.setVisible(false);
					PnDel.setVisible(false);
					panel_7.setVisible(false);
					comboBox_2.setModel(
							new DefaultComboBoxModel(new String[] { "기차스케쥴셋업", "스케쥴전부보기", "스케쥴변경", "스케쥴삭제" }));
					Trains.setVisible(false);
					lblCrud.setVisible(false);
					panel_1.setVisible(false);
				}
			}

		});
	}

	public JTable getTable_1() {
		return table_1;
	}

	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}

	public JPanel getPanel_9() {
		return panel_9;
	}

	public void setPanel_9(JPanel panel_9) {
		this.panel_9 = panel_9;
	}

	public JTextField getRailTextLength() {
		return RailTextLength;
	}

	public void setRailTextLength(JTextField railTextLength) {
		RailTextLength = railTextLength;
	}

	public JTextField getRailTextRailName() {
		return RailTextRailName;
	}

	public void setRailTextRailName(JTextField railTextRailName) {
		RailTextRailName = railTextRailName;
	}

	public JTextField getRailTextPrice() {
		return RailTextPrice;
	}

	public void setRailTextPrice(JTextField railTextPrice) {
		RailTextPrice = railTextPrice;
	}

	public JTextField getRailTextLocation() {
		return RailTextLocation;
	}

	public void setRailTextLocation(JTextField railTextLocation) {
		RailTextLocation = railTextLocation;
	}

}
