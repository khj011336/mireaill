package adminGui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Datetrain extends JDialog {
	JPanel panel_12;
	JPanel panel_1;
	ArrayList<JButton> jbL;
	private final JPanel contentPanel = new JPanel();
	String date ;
	int year;
	int month;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Datetrain dialog = new Datetrain(new TrainGu());
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Datetrain(TrainGu setup) {
		setBounds(100, 100, 541, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
		 panel_12 = new JPanel();
				panel.add(panel_12, BorderLayout.NORTH);
				panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					JLabel lblMirail = new JLabel("MiRail                               ");
					lblMirail.setHorizontalAlignment(SwingConstants.CENTER);
					lblMirail.setForeground(Color.WHITE);
					lblMirail.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 22));
					panel_12.add(lblMirail);
				}
				{
					JLabel lblNewLabel = new JLabel("2020\uB144");
					lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 21));
					panel_12.add(lblNewLabel);
					
				}
				
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
					comboBox.setSelectedIndex(0);
					panel_12.add(comboBox);
					comboBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							JComboBox g =(JComboBox)arg0.getSource();
							
							 year = 2020;
							 month = Integer.parseInt((String)g.getSelectedItem());
							int totaldays = 0;

							// 1 ~ 12월별 일수

							// 년도 계산
							for (int i = 0; i < 42; i++) {
								jbL.get(i).setEnabled(true);
								jbL.get(i).setText("");
								jbL.get((i)).setBorder(new LineBorder(Color.white));
							}
							for (int y = 1; y < year; y++) {
								if (y % 400 == 0) {
									totaldays += 366;
								} else if (y % 100 == 0) {
									totaldays += 365;
								} else if (y % 4 == 0) {
									totaldays += 366;
								} else {
									totaldays += 365;
								}

							}

							boolean bLeapYear = true;
							if (year % 400 == 0) {
								bLeapYear = true;
							} else if (year % 100 == 0) {
								bLeapYear = false;
							} else if (year % 4 == 0) {
								bLeapYear = true;
							} else {
								bLeapYear = false;
							}

							int daysInMonth[] = { 31, bLeapYear ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
							for (int m = 0; m < month - 1; m++) {
								totaldays += daysInMonth[m];
							}
							totaldays++;
							int yoil = totaldays % 7;
						
							int o =0;
							for (int i = 0; i < yoil; i++) {
								
								jbL.get(i).setText("");
								o++;
							}
							Calendar dt = Calendar.getInstance();
							int d =dt.get(Calendar.DAY_OF_MONTH);
							int M =dt.get(Calendar.MONTH);
							for (int day = 1; day <= daysInMonth[month - 1]; day++) {
								
								
								jbL.get(o++).setText(day+"");
								System.out.println(d+"    "+ M);
								if(d== day&&month-1== M ) {
									jbL.get((o-1)).setBorder(new LineBorder(Color.red));
								}
								if(month-1== M&&d>day) {
									jbL.get((o-1)).setEnabled(false);
									
								}
							}
							}
							
					});
				
				}
				{
					JLabel lblNewLabel_1 = new JLabel("\uC6D4");
					panel_12.add(lblNewLabel_1);
				}
			}
			{
				 panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new GridLayout(7, 7, 0, 0));
				{
					JButton btnNewButton_3 = new JButton("\uC77C");
					btnNewButton_3.setEnabled(false);
					panel_1.add(btnNewButton_3);
				}
				{
					JButton btnNewButton_2 = new JButton("\uC6D4");
					btnNewButton_2.setEnabled(false);
					panel_1.add(btnNewButton_2);
				}
				{
					JButton btnNewButton_1 = new JButton("\uD654");
					btnNewButton_1.setEnabled(false);
					panel_1.add(btnNewButton_1);
				}
				{
					JButton btnNewButton_4 = new JButton("\uC218");
					btnNewButton_4.setEnabled(false);
					panel_1.add(btnNewButton_4);
				}
				{
					JButton btnNewButton_5 = new JButton("\uBAA9");
					btnNewButton_5.setEnabled(false);
					panel_1.add(btnNewButton_5);
				}
				{
					JButton btnNewButton_6 = new JButton("\uAE08");
					btnNewButton_6.setEnabled(false);
					panel_1.add(btnNewButton_6);
				}
				{
					JButton btnNewButton = new JButton("\uD1A0");
					btnNewButton.setEnabled(false);
					panel_1.add(btnNewButton);
				}
			}
		}
		jbL = new ArrayList<JButton>();
//		int year = 2020;
//		int month = 1;
//		int totaldays = 0;
//
//		// 1 ~ 12월별 일수
//
//		// 년도 계산
//		for (int y = 1; y < year; y++) {
//			if (y % 400 == 0) {
//				totaldays += 366;
//			} else if (y % 100 == 0) {
//				totaldays += 365;
//			} else if (y % 4 == 0) {
//				totaldays += 366;
//			} else {
//				totaldays += 365;
//			}
//
//		}
//
//		boolean bLeapYear = true;
//		if (year % 400 == 0) {
//			bLeapYear = true;
//		} else if (year % 100 == 0) {
//			bLeapYear = false;
//		} else if (year % 4 == 0) {
//			bLeapYear = true;
//		} else {
//			bLeapYear = false;
//		}
//
//		int daysInMonth[] = { 31, bLeapYear ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
//		for (int m = 0; m < month - 1; m++) {
//			totaldays += daysInMonth[m];
//		}
	//	totaldays++;
		//int yoil = totaldays % 7;
		ButtonGroup gr = new ButtonGroup();
		
		for (int i = 0; i < 42; i++) {
			jbL.add(new JButton());
			jbL.get(i).setBackground(Color.gray);
			jbL.get(i).setBorder(new LineBorder(Color.WHITE));
			panel_1.add(jbL.get(i));
			jbL.get(i).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for (int j = 0; j < 42; j++) {
						jbL.get(j).setBorder(new LineBorder(Color.WHITE));
					}
					
					JButton jb = (JButton)e.getSource();
					date = jb.getText();
					jb.setBorder(new LineBorder(Color.ORANGE));
				}
			});
		}
//		int o =0;
//		for (int i = 0; i < yoil; i++) {
//			jbL.get(i).setText("");
//			o++;
//			panel_1.add(jbL.get(i));
//		}
//		for (int day = 1; day <= daysInMonth[month - 1]; day++) {
//			jbL.get(day+o).setText(day+"");
//			panel_1.add(jbL.get(day+o));
//		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					setup.getSetupDDateTxt().setText(String.format("%d-%d-%s", year,month,date));
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
