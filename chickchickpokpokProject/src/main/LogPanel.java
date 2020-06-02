package main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import admin.Admin;
import adminGui.TrainGu;
import member.db.MemberDBManager;
import member.signUpPage.MemberSignUpPageDialog;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LogPanel extends JPanel {
	private JTextField txtID;
	private JPasswordField PW;
	private MainPageFrame frm;
	JButton btnLogin;
	JButton btnLogout;
	Connection con;
	/**
	 * Create the panel.
	 */
	public JPanel pnLog;
	public CardLayout cl_pnLog;
	public JLabel lblWelcome;
	
	public static String LOGGED_IN = null;
	public int LOGGED_IN_NUMBER = 0;
	private JPasswordField passwordField;
	
	public LogPanel() {
		this.con = Admin.con;
		MemberDBManager mbDBMgr = new MemberDBManager(con);
		
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pnBlank = new JPanel();
		pnBlank.setBackground(Color.DARK_GRAY);
		panel.add(pnBlank);
		
		pnLog = new JPanel();
		panel.add(pnLog);
		cl_pnLog = new CardLayout(0, 0);
		pnLog.setLayout(cl_pnLog);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setBackground(Color.DARK_GRAY);
		pnLog.add(pnLogin, "name_4463767478386");
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		pnLogin.add(lblID);
		
		txtID = new JTextField();
		txtID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( txtID.getText().equals("°¡ÀÔµÇÁö¾ÊÀº¾ÆÀÌµð") ||
						txtID.getText().equals("¾ÆÀÌµðÀÔ·ÂÇØÁÖ¼¼¿ä")) {
					txtID.setText("");
					txtID.setForeground(Color.BLACK);
				}		
			}
		});
		txtID.setToolTipText("\uD68C\uC6D0\uB2D8\uC758 ID\uB97C \uC785\uB825\uD558\uC138\uC694.");
		txtID.setHorizontalAlignment(SwingConstants.LEFT);
		txtID.setForeground(Color.BLACK);
		txtID.setColumns(10);
		pnLogin.add(txtID);
		
		JLabel lblPW = new JLabel("Password");
		lblPW.setForeground(Color.WHITE);
		lblPW.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		pnLogin.add(lblPW);
		
		PW = new JPasswordField();
		PW.setToolTipText("Password\uB97C \uC785\uB825\uD558\uC138\uC694.");
		PW.setColumns(10);
		pnLogin.add(PW);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().equals("admin") && new String(PW.getPassword()).equals("1234")) {
					TrainGu ad = new TrainGu();
					ad.setVisible(true);
				}
				boolean bLogin = mbDBMgr.memberLogin(txtID.getText(), new String(PW.getPassword()));
				if( bLogin ) {
					LOGGED_IN = txtID.getText();
					btnLogin = (JButton)e.getSource();
					StatusDialog dlg = new StatusDialog(frm, true);
					dlg.lblStatus.setText("·Î±×ÀÎ µÇ¾ú½À´Ï´Ù.");
					Point btnPtScr = btnLogin.getLocationOnScreen();
					int btnW = btnLogin.getWidth();
					int btnH = btnLogin.getHeight();
					dlg.setLocation(btnPtScr.x+btnW/2,btnPtScr.y+(int)(btnH*0.75));
					dlg.setVisible(true);
					cl_pnLog.next(pnLog);
				} else {
					if( txtID.getText().isEmpty() ) {
						txtID.setText("¾ÆÀÌµðÀÔ·ÂÇØÁÖ¼¼¿ä");
						txtID.setForeground(Color.LIGHT_GRAY);
					} else {
						StatusDialog dlg = new StatusDialog(frm, true);
						dlg.lblStatus.setText("ÀÔ·Â Á¤º¸°¡ ¿Ã¹Ù¸£Áö ¾Ê½À´Ï´Ù.");
						dlg.lblStatus.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
						dlg.setVisible(true);
					}
				}
				lblWelcome.setText("'"+LOGGED_IN+"' ´Ô È¯¿µÇÕ´Ï´Ù.");
			}
		});
		btnLogin.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		pnLogin.add(btnLogin);
		
		JButton btnSignUp = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberSignUpPageDialog dlg = new MemberSignUpPageDialog(frm, true);
				dlg.setVisible(true);
			}
		});
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		pnLogin.add(btnSignUp);
		
		JPanel pnLogout = new JPanel();
		pnLogout.setBackground(Color.DARK_GRAY);
		pnLog.add(pnLogout, "name_4476039561376");
		
		lblWelcome = new JLabel("");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		pnLogout.add(lblWelcome);
		
		btnLogout = new JButton("LOGOUT");
		btnLogout.setBackground(Color.WHITE);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGGED_IN = null;
				LOGGED_IN_NUMBER = 0;
				btnLogout = (JButton)e.getSource();
				StatusDialog dlg = new StatusDialog(frm, true);
				dlg.lblStatus.setText("·Î±×¾Æ¿ô µÇ¾ú½À´Ï´Ù.");
				Point btnPtScr = btnLogout.getLocationOnScreen();
				int btnW = btnLogout.getWidth();
				int btnH = btnLogout.getHeight();
				dlg.setLocation(btnPtScr.x+btnW/2,btnPtScr.y+(int)(btnH*0.75));
				dlg.setVisible(true);
				txtID.setText("");
				PW.setText("");
				cl_pnLog.previous(pnLog);
				
			}
		});
		btnLogout.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		pnLogout.add(btnLogout);
		
		JButton btnSecession = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btnSecession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_pnLog.next(pnLog);
			}
		});
		btnSecession.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		pnLogout.add(btnSecession);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		pnLog.add(panel_1, "name_362595831447");
		
		JLabel label_1 = new JLabel("Password");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		panel_1.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password\uB97C \uC785\uB825\uD558\uC138\uC694.");
		passwordField.setColumns(10);
		panel_1.add(passwordField);
		
		JButton button = new JButton("\uD0C8\uD1F4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				PW.setText("");
				mbDBMgr.deleteOneMember(new String(passwordField.getPassword()));
				StatusDialog dlg = new StatusDialog(frm, true);
				dlg.lblStatus.setText("È¸¿øÅ»Åð µÇ¾ú½À´Ï´Ù.");
				dlg.setVisible(true);
				cl_pnLog.next(pnLog);
			}
		});
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		button.setBackground(Color.WHITE);
		panel_1.add(button);

	}

}
