package member.myPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import admin.Admin;
import booking.BookingDBMgr;
import booking.booking;
import main.LogPanel;
import main.MainPageFrame;
import member.Member;
import member.db.MemberDBManager;
import pay.TicketCard;
import pay.pay;

import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MemberMyPageDialog extends JDialog {

	private JPanel contentPane;
	private MemberMyPageDialog dlg;
	Connection con;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			MemberMyPageDialog dialog = new MemberMyPageDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	MainPageFrame frm;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textYear;
	private JTextField textDay;
	private JTextField textAddress;
	private JTextField textPNMid;
	private JTextField textPNLast;
	private JTextField textEmail;
	private JTextField textEmail2;
	private JPasswordField pwFirst;
	private JPasswordField pwSecond;
	JComboBox comboPNFirst;
	JComboBox comboGender;
	JPanel pnInfoEdit;
	CardLayout cl_pnInfoEdit;
	JPanel pnPWEdit;
	CardLayout cl_pnPWEdit;
	JButton btnBenefitInfo;
	private JTable table;
	Member mb;
	JLabel lblEmailStatus;
	JLabel lblPNStatus;
	JLabel lblBirthdayStatus;
	JLabel lblAgeStatus;
	JLabel lblGenderStatus;
	JLabel lblNameStatus;
	JLabel lblPWStatus;
	JLabel lblPWCheckStatus;
	JComboBox comboMonth;
	JButton btnMemberEdit;
	JLabel lblEditStatus;
	JComboBox comboEmail;
	boolean bName;
	boolean bGender;
	boolean bAge;
	boolean bEmail;
	boolean bPN;
	boolean bYMD;
	boolean bPW;
	boolean bPWCheck;
	
	public MemberMyPageDialog(MainPageFrame frm, boolean modal) {
		super(frm, modal);
		setModal(true);
		this.con = Admin.con;
		this.dlg = this;
		this.frm = frm;
		bName = false;
		bGender = false;
		bAge = false;
		bEmail = false;
		bPN = false;
		bYMD = false;
		bPW = false;
		bPWCheck = false;
		MemberDBManager mbDBMgr = new MemberDBManager(con);
		mb = new Member();
		mb = mbDBMgr.selectOneMemberByID(LogPanel.LOGGED_IN);
		setTitle("Mirail : My Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 858, 652);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnTop = new JPanel();
		pnTop.setBackground(Color.BLACK);
		FlowLayout fl_pnTop = (FlowLayout) pnTop.getLayout();
		fl_pnTop.setAlignment(FlowLayout.RIGHT);
		contentPane.add(pnTop, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlg.dispose();
			}
		});
		pnTop.add(btnNewButton);
		
		JPanel pnMyPage = new JPanel();
		pnMyPage.setBackground(Color.BLACK);
		contentPane.add(pnMyPage, BorderLayout.CENTER);
		pnMyPage.setLayout(new GridLayout(0, 2, 0, 0));
		
		pnInfoEdit = new JPanel();
		pnInfoEdit.setBackground(Color.BLACK);
		pnMyPage.add(pnInfoEdit);
		cl_pnInfoEdit = new CardLayout(0, 0);
		pnInfoEdit.setLayout(cl_pnInfoEdit);
		
		JPanel pnInfo1 = new JPanel();
		pnInfo1.setLayout(null);
		pnInfo1.setForeground(Color.WHITE);
		pnInfo1.setBackground(Color.BLACK);
		pnInfoEdit.add(pnInfo1, "name_22255315299659");
		
		JLabel lblId = new JLabel((String) null);
		lblId.setForeground(Color.GREEN);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblId.setBounds(12, 10, 57, 15);
		lblId.setText(mb.getID());
		pnInfo1.add(lblId);
		
		JLabel lbl = new JLabel("\uB2D8 \uD68C\uC6D0 \uC815\uBCF4");
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lbl.setBounds(81, 10, 83, 15);
		pnInfo1.add(lbl);
		
		JLabel lblName = new JLabel("\uC774\uB984");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblName.setBounds(12, 78, 57, 15);
		pnInfo1.add(lblName);
		
		JLabel lblNameInfo = new JLabel((String) null);
		lblNameInfo.setForeground(Color.GREEN);
		lblNameInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNameInfo.setBounds(81, 78, 152, 15);
		lblNameInfo.setText(mb.getName());
		pnInfo1.add(lblNameInfo);
		
		JLabel lblGender = new JLabel("\uC131\uBCC4");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblGender.setBounds(12, 128, 57, 15);
		pnInfo1.add(lblGender);
		
		JLabel lblGenderInfo = new JLabel("\uC5EC\uC790");
		lblGenderInfo.setForeground(Color.GREEN);
		lblGenderInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblGenderInfo.setBounds(81, 128, 152, 15);
		lblGenderInfo.setText(mb.getGender()==1?"남자":"여자");
		pnInfo1.add(lblGenderInfo);
		
		JLabel lblAge = new JLabel("\uB098\uC774");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblAge.setBounds(12, 178, 57, 15);
		pnInfo1.add(lblAge);
		
		JLabel lblAgeInfo = new JLabel("0");
		lblAgeInfo.setForeground(Color.GREEN);
		lblAgeInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblAgeInfo.setBounds(81, 178, 152, 15);
		lblAgeInfo.setText(""+mb.getAge());
		pnInfo1.add(lblAgeInfo);
		
		JLabel lblBirthday = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblBirthday.setForeground(Color.WHITE);
		lblBirthday.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblBirthday.setBounds(12, 228, 57, 15);
		pnInfo1.add(lblBirthday);
		
		JLabel lblBirthdayInfo = new JLabel((String) null);
		lblBirthdayInfo.setForeground(Color.GREEN);
		lblBirthdayInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblBirthdayInfo.setBounds(81, 228, 152, 15);
		lblBirthdayInfo.setText(mb.getBirthday());
		pnInfo1.add(lblBirthdayInfo);
		
		JLabel lblPN = new JLabel("\uC5F0\uB77D\uCC98");
		lblPN.setForeground(Color.WHITE);
		lblPN.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblPN.setBounds(12, 278, 57, 15);
		pnInfo1.add(lblPN);
		
		JLabel lblPNInfo = new JLabel((String) null);
		lblPNInfo.setForeground(Color.GREEN);
		lblPNInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblPNInfo.setBounds(81, 278, 152, 15);
		lblPNInfo.setText(mb.getPhoneNumber());
		pnInfo1.add(lblPNInfo);
		
		JLabel lblEmail = new JLabel("\uC774\uBA54\uC77C");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblEmail.setBounds(12, 328, 57, 15);
		pnInfo1.add(lblEmail);
		
		JLabel lblEmailInfo = new JLabel((String) null);
		lblEmailInfo.setForeground(Color.GREEN);
		lblEmailInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblEmailInfo.setBounds(81, 328, 152, 15);
		lblEmailInfo.setText(mb.getEmail());
		pnInfo1.add(lblEmailInfo);
		
		JLabel lblAddress = new JLabel("\uC8FC\uC18C");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setBounds(12, 378, 57, 15);
		pnInfo1.add(lblAddress);
		
		JLabel lblAddressInfo = new JLabel((String) null);
		lblAddressInfo.setForeground(Color.GREEN);
		lblAddressInfo.setBounds(81, 378, 258, 15);
		lblAddressInfo.setText(mb.getAddress());
		pnInfo1.add(lblAddressInfo);
		
		JButton btnInfoEdit = new JButton("\uC815\uBCF4 \uC218\uC815\uD558\uAE30");
		btnInfoEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAddress.setText("");
				textAge.setText("");
				textDay.setText("일");
				textDay.setForeground(Color.LIGHT_GRAY);
				textEmail.setText("");
				textEmail2.setText("직접입력");
				textEmail2.setForeground(Color.LIGHT_GRAY);
				textName.setText("");
				textPNLast.setText("");
				textPNMid.setText("");
				textYear.setText("년(4자)");
				textYear.setForeground(Color.LIGHT_GRAY);
				comboEmail.setSelectedIndex(0);
				comboGender.setSelectedIndex(0);
				comboMonth.setSelectedIndex(0);
				comboPNFirst.setSelectedIndex(0);
				pwFirst.setText("");
				pwSecond.setText("");
				bName = false;
				bGender = false;
				bAge = false;
				bEmail = false;
				bPN = false;
				bYMD = false;
				bPW = false;
				bPWCheck = false;
				lblNameStatus.setText("");
				lblPWStatus.setText("");
				lblPWCheckStatus.setText("");
				btnMemberEdit.setEnabled(false);
				cl_pnInfoEdit.next(pnInfoEdit);
			}
		});
		btnInfoEdit.setBounds(12, 450, 152, 23);
		pnInfo1.add(btnInfoEdit);
		
		JLabel lblPWEditStatus = new JLabel("");
		lblPWEditStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblPWEditStatus.setForeground(Color.WHITE);
		lblPWEditStatus.setBounds(176, 11, 163, 15);
		pnInfo1.add(lblPWEditStatus);
		
		JPanel pnEdit = new JPanel();
		pnEdit.setLayout(null);
		pnEdit.setForeground(Color.WHITE);
		pnEdit.setBackground(Color.BLACK);
		pnInfoEdit.add(pnEdit, "name_22171331284584");
		
		JLabel label_1 = new JLabel((String) null);
		label_1.setForeground(Color.GREEN);
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_1.setBounds(12, 10, 57, 15);
		pnEdit.add(label_1);
		
		JLabel label_2 = new JLabel("\uB2D8 \uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815/\uBCC0\uACBD");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_2.setBounds(81, 10, 152, 15);
		pnEdit.add(label_2);
		
		JLabel label_3 = new JLabel("\uC774\uB984");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_3.setBounds(12, 78, 57, 15);
		pnEdit.add(label_3);
		
		JLabel label_5 = new JLabel("\uC131\uBCC4");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_5.setBounds(12, 128, 57, 15);
		pnEdit.add(label_5);
		
		JLabel label_7 = new JLabel("\uB098\uC774");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_7.setBounds(12, 178, 57, 15);
		pnEdit.add(label_7);
		
		JLabel label_9 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_9.setBounds(12, 228, 57, 15);
		pnEdit.add(label_9);
		
		JLabel label_11 = new JLabel("\uC5F0\uB77D\uCC98");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_11.setBounds(12, 278, 57, 15);
		pnEdit.add(label_11);
		
		JLabel label_13 = new JLabel("\uC774\uBA54\uC77C");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_13.setBounds(12, 328, 57, 15);
		pnEdit.add(label_13);
		
		JLabel label_15 = new JLabel("\uC8FC\uC18C");
		label_15.setForeground(Color.WHITE);
		label_15.setBounds(12, 378, 57, 15);
		pnEdit.add(label_15);
		
		textName = new JTextField();
		textName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( textName.getText() != null && !textName.getText().isEmpty() ) {
					lblNameStatus.setText("멋진 이름이네요!");
					lblNameStatus.setForeground(Color.BLUE);
					System.out.println("이름 사용가능");
					bName = true;
				} else {
					lblNameStatus.setText("이름을 입력 해주세요.");
					lblNameStatus.setForeground(Color.RED);
					System.out.println("이름 사용불가");
					bName = false;
					btnMemberEdit.setEnabled(false);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							lblEditStatus.setText("");
							btnMemberEdit.setEnabled(true);
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
		});
		textName.setForeground(Color.BLACK);
		textName.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textName.setBounds(81, 76, 258, 21);
		pnEdit.add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				char[] cAgeArr = textAge.getText().toCharArray();
				for (int i = 0; i < cAgeArr.length; i++) {
					if( (cAgeArr[i] >= '0' && cAgeArr[i] <= '9')) {
						System.out.println("나이 사용가능");
						bAge = true;
					} else {
						System.out.println("나이 사용불가");
						bAge = false;
						btnMemberEdit.setEnabled(false);
						break;
					}
				}
				if( !bAge ) {
					lblAgeStatus.setText("숫자를 입력해주세요.");
					lblAgeStatus.setForeground(Color.RED);
				} else {
					lblAgeStatus.setText("");
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
		});
		textAge.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textAge.setColumns(10);
		textAge.setBounds(81, 176, 258, 21);
		pnEdit.add(textAge);
		
		comboGender = new JComboBox();
		comboGender.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(comboGender.getSelectedItem().equals("성별")) {
					lblGenderStatus.setText("성별을 선택해주세요.");
					lblGenderStatus.setForeground(Color.RED);
					System.out.println("성별 사용불가");
					bGender = false;
					btnMemberEdit.setEnabled(false);
				} else {
					lblGenderStatus.setText("");
					System.out.println("성별 사용가능");
					bGender = true;
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
		});
		comboGender.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"\uC131\uBCC4", "\uB0A8\uC790", "\uC5EC\uC790"}));
		comboGender.setBounds(81, 126, 258, 21);
		pnEdit.add(comboGender);
		
		textYear = new JTextField();
		textYear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( textYear.getText().equals("년(4자)") ) {
					textYear.setText("");
					textYear.setForeground(Color.BLACK);
				} else {
					textYear.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if( textYear.getText().isEmpty() ) {
					textYear.setText("년(4자)");
					textYear.setForeground(Color.LIGHT_GRAY);
				} else {
					textYear.setForeground(Color.BLACK);
				}
			}
		});
		textYear.setText("\uB144(4\uC790)");
		textYear.setForeground(Color.LIGHT_GRAY);
		textYear.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textYear.setBounds(81, 226, 78, 21);
		pnEdit.add(textYear);
		textYear.setColumns(4);
		
		comboMonth = new JComboBox();
		comboMonth.setFont(new Font("맑은 고딕", Font.BOLD, 11));
		comboMonth.setModel(new DefaultComboBoxModel(new String[] {"\uC6D4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboMonth.setBounds(171, 226, 78, 21);
		pnEdit.add(comboMonth);
		
		textDay = new JTextField();
		textDay.setForeground(Color.LIGHT_GRAY);
		textDay.setText("\uC77C");
		textDay.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( textDay.getText().isEmpty() ) {
					textDay.setText("일");
					textDay.setForeground(Color.LIGHT_GRAY);
				} else {
					textDay.setForeground(Color.BLACK);
				}
				if( textYear.getText() != null && !textYear.getText().isEmpty() 
					&& textDay.getText() != null && !textDay.getText().isEmpty()
					&& !comboMonth.getSelectedItem().equals("월") && textYear.getText().length() < 5
					&& Integer.parseInt(textDay.getText()) < 32 && Integer.parseInt(textDay.getText()) > 0) {
					lblBirthdayStatus.setText("");
					System.out.println("생년월일 사용가능");
					bYMD = true;
				} else {
					lblBirthdayStatus.setText("생년월일을 정확하게 입력/선택 해주세요.");
					lblBirthdayStatus.setForeground(Color.RED);
					System.out.println("생년월일 사용불가");
					bYMD = false;
					btnMemberEdit.setEnabled(false);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if( textDay.getText().equals("일") ) {
					textDay.setText("");
					textDay.setForeground(Color.BLACK);
				} else {
					textDay.setForeground(Color.BLACK);
				}
			}
		});
		textDay.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textDay.setColumns(4);
		textDay.setBounds(261, 226, 78, 21);
		pnEdit.add(textDay);
		
		textAddress = new JTextField();
		textAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( textEmail.getText() != null && !textEmail.getText().isEmpty() 
						&& textEmail2.getText() != null && !textEmail2.getText().isEmpty()
						&& !textEmail2.getText().equals("직접입력") ) {
					lblEmailStatus.setText("");
					System.out.println("이메일 사용가능");
					bEmail = true;
				} else {
					lblEmailStatus.setText("이메일을 입력/선택 해주세요.");
					lblEmailStatus.setForeground(Color.RED);
					System.out.println("이메일 사용불가");
					bEmail = false;
					btnMemberEdit.setEnabled(false);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
					&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
					if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
						btnMemberEdit.setEnabled(true);
						lblEditStatus.setText("");
					}
					else {
						lblEditStatus.setText("입력정보 확인요망");
						lblEditStatus.setForeground(Color.RED);
					}
				} else {
					if( bName && bGender && bAge && bEmail && bPN && bYMD) {
						btnMemberEdit.setEnabled(true);
						lblEditStatus.setText("");
					}
					else {
						lblEditStatus.setText("입력정보 확인요망");
						lblEditStatus.setForeground(Color.RED);
					}
				}
			}
		});
		textAddress.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textAddress.setColumns(10);
		textAddress.setBounds(83, 375, 256, 21);
		pnEdit.add(textAddress);
		
		comboPNFirst = new JComboBox();
		comboPNFirst.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		comboPNFirst.setModel(new DefaultComboBoxModel(new String[] {"010", "02", "031", "032", "033", "041", "042", "043", "044", "051", "052", "053", "054", "055", "061", "062", "063", "064"}));
		comboPNFirst.setBounds(81, 276, 78, 21);
		pnEdit.add(comboPNFirst);
		
		textPNMid = new JTextField();
		textPNMid.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textPNMid.setColumns(4);
		textPNMid.setBounds(171, 276, 78, 21);
		pnEdit.add(textPNMid);
		
		textPNLast = new JTextField();
		textPNLast.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( textEmail.getText() != null && !textEmail.getText().isEmpty() 
						&& textEmail2.getText() != null && !textEmail2.getText().isEmpty()
						&& !textEmail2.getText().equals("직접입력") ) {
					lblEmailStatus.setText("");
					System.out.println("이메일 사용가능");
					bEmail = true;
				} else {
					lblEmailStatus.setText("이메일을 입력/선택 해주세요.");
					lblEmailStatus.setForeground(Color.RED);
					System.out.println("이메일 사용불가");
					bEmail = false;
					btnMemberEdit.setEnabled(false);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
		});
		textPNLast.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textPNLast.setColumns(4);
		textPNLast.setBounds(261, 276, 78, 21);
		pnEdit.add(textPNLast);
		
		JLabel lblNewLabel_4 = new JLabel("-");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(157, 279, 15, 15);
		pnEdit.add(lblNewLabel_4);
		
		JLabel label_4 = new JLabel("-");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("굴림", Font.BOLD, 12));
		label_4.setBounds(247, 279, 15, 15);
		pnEdit.add(label_4);
		
		textEmail = new JTextField();
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( textEmail.getText() != null && !textEmail.getText().isEmpty() 
						&& textEmail2.getText() != null && !textEmail2.getText().isEmpty()
						&& !textEmail2.getText().equals("직접입력") ) {
					lblEmailStatus.setText("");
					System.out.println("이메일 사용가능");
					bEmail = true;
				} else {
					lblEmailStatus.setText("이메일을 입력/선택 해주세요.");
					lblEmailStatus.setForeground(Color.RED);
					System.out.println("이메일 사용불가");
					bEmail = false;
					btnMemberEdit.setEnabled(false);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if( textPNMid.getText() != null && !textPNMid.getText().isEmpty() 
						&& textPNLast.getText() != null && !textPNLast.getText().isEmpty()
						&& textPNMid.getText().length() > 2 && textPNMid.getText().length() < 5
						&& textPNLast.getText().length() == 4 ) {
						lblPNStatus.setText("");
						System.out.println("연락처 사용가능");
						bPN = true;
					} else {
						lblPNStatus.setText("연락처를 정확하게 입력/선택 해주세요.");
						lblPNStatus.setForeground(Color.RED);
						System.out.println("연락처 사용불가");
						bPN = false;
						btnMemberEdit.setEnabled(false);
					}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
		});
		textEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textEmail.setBounds(81, 326, 78, 21);
		pnEdit.add(textEmail);
		textEmail.setColumns(10);
		
		textEmail2 = new JTextField();
		textEmail2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( textEmail2.getText().equals("직접입력") ) {
					textEmail2.setText("직접입력");
					textEmail2.setForeground(Color.LIGHT_GRAY);
				} else {
					textEmail2.setForeground(Color.BLACK);
				}
				if( textEmail.getText() != null && !textEmail.getText().isEmpty() 
						&& textEmail2.getText() != null && !textEmail2.getText().isEmpty()
						&& !textEmail2.getText().equals("직접입력") ) {
					lblEmailStatus.setText("");
					System.out.println("이메일 사용가능");
					bEmail = true;
				} else {
					lblEmailStatus.setText("이메일을 입력/선택 해주세요.");
					lblEmailStatus.setForeground(Color.RED);
					System.out.println("이메일 사용불가");
					bEmail = false;
					btnMemberEdit.setEnabled(false);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if( textEmail2.getText().equals("직접입력") ) {
					textEmail2.setText("");
					textEmail2.setForeground(Color.BLACK);
				} else {
					textEmail2.setForeground(Color.BLACK);
				}
			}
		});
		textEmail2.setText("\uC9C1\uC811\uC785\uB825");
		textEmail2.setForeground(Color.LIGHT_GRAY);
		textEmail2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		textEmail2.setColumns(10);
		textEmail2.setBounds(184, 324, 78, 23);
		pnEdit.add(textEmail2);
		
		comboEmail = new JComboBox();
		comboEmail.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if( !comboEmail.getSelectedItem().equals("직접입력") ) {
					textEmail2.setText((String)comboEmail.getSelectedItem());
					textEmail2.setForeground(Color.BLACK);
					textEmail2.setEditable(false);
				} else {
					textEmail2.setText((String)comboEmail.getSelectedItem());
					textEmail2.setForeground(Color.LIGHT_GRAY);
					textEmail2.setEditable(true);
				}
			}
		});
		comboEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( textEmail.getText() != null && !textEmail.getText().isEmpty() 
						&& textEmail2.getText() != null && !textEmail2.getText().isEmpty()
						&& !textEmail2.getText().equals("직접입력") ) {
					lblEmailStatus.setText("");
					System.out.println("이메일 사용가능");
					bEmail = true;
				} else {
					lblEmailStatus.setText("이메일을 입력/선택 해주세요.");
					lblEmailStatus.setForeground(Color.RED);
					System.out.println("이메일 사용불가");
					bEmail = false;
					btnMemberEdit.setEnabled(false);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
		});
		comboEmail.setModel(new DefaultComboBoxModel(new String[] {"\uC9C1\uC811\uC785\uB825", "naver.com", "daum.net", "google.com"}));
		comboEmail.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		comboEmail.setBackground(Color.WHITE);
		comboEmail.setBounds(261, 324, 78, 23);
		pnEdit.add(comboEmail);
		
		JLabel lblNewLabel_6 = new JLabel("@");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(160, 329, 22, 15);
		pnEdit.add(lblNewLabel_6);
		
		pnPWEdit = new JPanel();
		pnPWEdit.setBackground(Color.BLACK);
		pnPWEdit.setBounds(12, 428, 327, 105);
		pnEdit.add(pnPWEdit);
		cl_pnPWEdit = new CardLayout(0, 0);
		pnPWEdit.setLayout(cl_pnPWEdit);
		
		JPanel pnBlank = new JPanel();
		pnBlank.setBackground(Color.BLACK);
		pnPWEdit.add(pnBlank, "name_23686754554346");
		
		JPanel pnPWEdit2 = new JPanel();
		pnPWEdit2.setBackground(Color.BLACK);
		pnPWEdit.add(pnPWEdit2, "name_23436869055978");
		pnPWEdit2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(12, 10, 83, 15);
		pnPWEdit2.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(12, 60, 83, 15);
		pnPWEdit2.add(lblNewLabel_10);
		
		pwFirst = new JPasswordField();
		pwFirst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				char[] cPWArr = pwFirst.getPassword();
				if(cPWArr.length >= 4 && cPWArr.length <= 8) {
					for (int i = 0; i < cPWArr.length; i++) {
						if( (cPWArr[i] >= 'a' && cPWArr[i] <= 'z') || (cPWArr[i] >= '0' && cPWArr[i] <= '9')) {
							System.out.println("비밀번호 사용가능");
							bPW = true;
						} else {
							System.out.println("비밀번호 사용불가");
							bPW = false;
							btnMemberEdit.setEnabled(false);
							break;
						}
					}
					if( !bPW ) {
						lblPWStatus.setText("비밀번호 형식에 맞지않습니다.");
						lblPWStatus.setForeground(Color.RED);
					} else {
						lblPWStatus.setText("사용 가능한 비밀번호입니다.");
						lblPWStatus.setForeground(Color.BLUE);
					}
				} else {
					System.out.println("비밀번호 사용불가");
					bPW = false;
					btnMemberEdit.setEnabled(false);
					lblPWStatus.setText("비밀번호 형식에 맞지않습니다.");
					lblPWStatus.setForeground(Color.RED);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
		});
		pwFirst.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		pwFirst.setBounds(107, 8, 220, 21);
		pnPWEdit2.add(pwFirst);
		
		pwSecond = new JPasswordField();
		pwSecond.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( pwSecond.getPassword().length != 0 && new String(pwFirst.getPassword()).equals(new String(pwSecond.getPassword())) ) {
					lblPWCheckStatus.setText("비밀번호가 일치합니다.");
					lblPWCheckStatus.setForeground(Color.BLUE);
					System.out.println("비밀번호 확인 일치");
					bPWCheck = true;
				} else if( pwSecond.getPassword().length != 0 ){
					lblPWCheckStatus.setText("비밀번호가 불일치합니다.");
					lblPWCheckStatus.setForeground(Color.RED);
					System.out.println("비밀번호 확인 불일치");
					bPWCheck = false;
					btnMemberEdit.setEnabled(false);
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()) {
						if( bName && bGender && bAge && bEmail && bPN && bYMD && bPW && bPWCheck ) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
					} else {
						if( bName && bGender && bAge && bEmail && bPN && bYMD) {
							btnMemberEdit.setEnabled(true);
							lblEditStatus.setText("");
						}
						else {
							lblEditStatus.setText("입력정보 확인요망");
							lblEditStatus.setForeground(Color.RED);
						}
				}
			}
		});
		pwSecond.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		pwSecond.setBounds(107, 58, 220, 21);
		pnPWEdit2.add(pwSecond);
		
		lblPWStatus = new JLabel("");
		lblPWStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblPWStatus.setForeground(Color.WHITE);
		lblPWStatus.setBounds(107, 33, 220, 15);
		pnPWEdit2.add(lblPWStatus);
		
		lblPWCheckStatus = new JLabel("");
		lblPWCheckStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblPWCheckStatus.setForeground(Color.WHITE);
		lblPWCheckStatus.setBounds(107, 90, 220, 15);
		pnPWEdit2.add(lblPWCheckStatus);
		
		btnMemberEdit = new JButton("\uC218\uC815 \uC644\uB8CC");
		btnMemberEdit.setForeground(Color.BLUE);
		btnMemberEdit.setEnabled(false);
		btnMemberEdit.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnMemberEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pW = "";
				String name = "";
				int age = 0;
				int gender = 0;
				String email = "";
				String phoneNumber = "";
				String address = "";
				String birthday = "";
				if( textName.getText() != null && !textName.getText().isEmpty() ) {
					name = textName.getText();
					lblNameInfo.setText(name);
					lblNameInfo.setForeground(Color.BLUE);
				}
				if( !comboGender.getSelectedItem().equals("성별") ) {
					gender = comboGender.getSelectedItem().equals("남자")?1:2;
					lblGenderInfo.setText((String) comboGender.getSelectedItem());
					lblGenderInfo.setForeground(Color.BLUE);
				}
				if( textAge.getText() != null && !textAge.getText().isEmpty() ) {
					age = Integer.parseInt(textAge.getText());
					lblAgeInfo.setText(""+age);
					lblAgeInfo.setForeground(Color.BLUE);
				}
				if( textEmail.getText() != null && !textEmail.getText().isEmpty() 
					&& textEmail2.getText() != null && !textEmail2.getText().isEmpty() ) {
					email = textEmail.getText()+"@"+textEmail2.getText();
					lblEmailInfo.setText(email);
					lblEmailInfo.setForeground(Color.BLUE);
				}
				if( textPNMid.getText() != null && !textPNMid.getText().isEmpty() 
					&& textPNLast.getText() != null && !textPNLast.getText().isEmpty() ) {
					phoneNumber = (String)comboPNFirst.getSelectedItem()+"-"+textPNMid.getText()+"-"+textPNLast.getText();
					lblPNInfo.setText(phoneNumber);
					lblPNInfo.setForeground(Color.BLUE);
				}
				if( textYear.getText() != null && !textYear.getText().isEmpty() 
					&& textDay.getText() != null && !textDay.getText().isEmpty()
					&& !comboMonth.getSelectedItem().equals("월") ) {
					birthday = textYear.getText() + "-" + (String)comboMonth.getSelectedItem() + "-" + textDay.getText();
					lblBirthdayInfo.setText(birthday);
					lblBirthdayInfo.setForeground(Color.BLUE);
				}
				address = textAddress.getText();
				lblAddressInfo.setText(address);
				lblAddressInfo.setForeground(Color.BLUE);
				mbDBMgr.updateMemberInfo(LogPanel.LOGGED_IN, name, gender, age, email, phoneNumber, address, birthday);
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty()
						&& new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty()
						&& new String(pwFirst.getPassword()).equals(new String(pwSecond.getPassword()))) {
					pW = new String(pwSecond.getPassword());
					lblPWEditStatus.setText("비밀번호가 변경되었습니다.");
					lblPWEditStatus.setForeground(Color.BLUE);
					mbDBMgr.updateMemberPW(LogPanel.LOGGED_IN, pW);
				}
				cl_pnPWEdit.next(pnPWEdit);
				cl_pnInfoEdit.previous(pnInfoEdit);
			}
		});
		btnMemberEdit.setBounds(12, 536, 97, 23);
		pnEdit.add(btnMemberEdit);
		
		JButton btnPWEdit = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		btnPWEdit.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnPWEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_pnPWEdit.next(pnPWEdit);
			}
		});
		btnPWEdit.setBounds(224, 536, 115, 23);
		pnEdit.add(btnPWEdit);
		
		lblEmailStatus = new JLabel("");
		lblEmailStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblEmailStatus.setForeground(Color.WHITE);
		lblEmailStatus.setBounds(81, 350, 258, 15);
		pnEdit.add(lblEmailStatus);
		
		lblPNStatus = new JLabel("");
		lblPNStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblPNStatus.setForeground(Color.WHITE);
		lblPNStatus.setBounds(81, 301, 258, 15);
		pnEdit.add(lblPNStatus);
		
		lblBirthdayStatus = new JLabel("");
		lblBirthdayStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblBirthdayStatus.setForeground(Color.WHITE);
		lblBirthdayStatus.setBounds(81, 251, 258, 15);
		pnEdit.add(lblBirthdayStatus);
		
		lblAgeStatus = new JLabel("");
		lblAgeStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblAgeStatus.setForeground(Color.WHITE);
		lblAgeStatus.setBounds(81, 201, 258, 15);
		pnEdit.add(lblAgeStatus);
		
		lblGenderStatus = new JLabel("");
		lblGenderStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblGenderStatus.setForeground(Color.WHITE);
		lblGenderStatus.setBounds(81, 151, 258, 15);
		pnEdit.add(lblGenderStatus);
		
		lblNameStatus = new JLabel("");
		lblNameStatus.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNameStatus.setForeground(Color.WHITE);
		lblNameStatus.setBounds(81, 101, 258, 15);
		pnEdit.add(lblNameStatus);
		
		lblEditStatus = new JLabel("");
		lblEditStatus.setFont(new Font("굴림", Font.PLAIN, 11));
		lblEditStatus.setBounds(115, 541, 97, 15);
		pnEdit.add(lblEditStatus);
		
		JPanel pnInfo2 = new JPanel();
		pnInfo2.setForeground(Color.GREEN);
		pnInfo2.setBackground(Color.BLACK);
		pnMyPage.add(pnInfo2);
		pnInfo2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBA64\uBC84\uC27D/\uB9C8\uC77C\uB9AC\uC9C0 \uC815\uBCF4");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 10, 175, 15);
		pnInfo2.add(lblNewLabel);
		
		JLabel lblpk = new JLabel("\uBA64\uBC84\uC27D \uBC88\uD638(PK)");
		lblpk.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblpk.setForeground(Color.WHITE);
		lblpk.setBounds(12, 60, 92, 15);
		pnInfo2.add(lblpk);
		
		JLabel lblRank = new JLabel("\uBA64\uBC84\uC27D \uB4F1\uAE09");
		lblRank.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblRank.setForeground(Color.WHITE);
		lblRank.setBounds(12, 110, 64, 15);
		pnInfo2.add(lblRank);
		
		JLabel lblPoint = new JLabel("\uB9C8\uC77C\uB9AC\uC9C0 \uD3EC\uC778\uD2B8");
		lblPoint.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblPoint.setForeground(Color.WHITE);
		lblPoint.setBounds(12, 160, 92, 15);
		pnInfo2.add(lblPoint);
		
		JLabel lblNewLabel_7 = new JLabel("\uAC70\uB798\uB0B4\uC5ED");
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(12, 210, 57, 15);
		pnInfo2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setBounds(116, 60, 133, 15);
		lblNewLabel_1.setText(""+mb.getPkUser());
		pnInfo2.add(lblNewLabel_1);
		
		JLabel lblRankInfo = new JLabel("");
		lblRankInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankInfo.setForeground(Color.GREEN);
		lblRankInfo.setBounds(88, 110, 122, 15);
		lblRankInfo.setText(mb.getRank());
		pnInfo2.add(lblRankInfo);
		
		JLabel lblPointInfo = new JLabel("");
		lblPointInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointInfo.setForeground(Color.GREEN);
		lblPointInfo.setBounds(116, 160, 99, 15);
		lblPointInfo.setText(""+mb.getMembership());
		pnInfo2.add(lblPointInfo);
		
		btnBenefitInfo = new JButton("\uD61C\uD0DD \uC54C\uC544\uBCF4\uAE30");
		btnBenefitInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BenefitInfoDialog mPdlg = new BenefitInfoDialog(dlg, true);
				mPdlg.setVisible(true);
			}
		});
		btnBenefitInfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnBenefitInfo.setBounds(222, 106, 117, 23);
		pnInfo2.add(btnBenefitInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 248, 406, 277);
		pnInfo2.add(scrollPane);

		DefaultTableModel tbm = new DefaultTableModel(new Object[] { "탑승일", "출발역", "도착역", "기차", "좌석", "출발", "도착" },
				0);
		table = new JTable(tbm);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2 = new JLabel("\uC2B9\uCC28\uAD8C\uD655\uC778");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(201, 211, 64, 15);
		pnInfo2.add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("\uC870\uD68C");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingDBMgr bk =new BookingDBMgr(con);
				booking bkC =bk.selectAllMembers(mb.getPkUser());
				if( bkC != null ) {
					pay n = new pay(bkC.getTrainID(), bkC.getTrainName(), bkC.getDStation(), bkC.getAStation(),
							mb.getName(), bkC.getPrice(), bkC.getDDate(), bkC.getDTime(), bkC.getaTime(), bkC.getSeat());
					System.out.println(bkC.getPrice());
					TicketCard t = new TicketCard(n);
					JDialog j = new JDialog(dlg) ;
					JPanel contentPane = new JPanel();
					JPanel jp =t;
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setBounds(100, 100, 458, 341);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					contentPane.setLayout(new BorderLayout(0, 0));
					contentPane.add(jp);
					j.setContentPane(contentPane);
					j.setVisible(true);
				} else {
					pay n = new pay("없음", "없음", "없음", "없음",
							"없음", 0, "없음", "없음", "없음", 0);
					System.out.println(0);
					TicketCard t = new TicketCard(n);
					JDialog j = new JDialog(dlg) ;
					JPanel contentPane = new JPanel();
					JPanel jp =t;
					j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					j.setBounds(100, 100, 458, 341);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					contentPane.setLayout(new BorderLayout(0, 0));
					contentPane.add(jp);
					j.setContentPane(contentPane);
					j.setVisible(true);
				}
			
			}
		});
		btnNewButton_1.setBounds(277, 207, 63, 23);
		pnInfo2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uC804\uCCB4\uC870\uD68C");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
				MemberReciptDBMgr mbR = new MemberReciptDBMgr(con);
				ArrayList<MemberRecipt> mbL = mbR.GetRecipts(mb.getPkUser());
				if( mbL != null) {
					for (int i = 0; i < mbL.size(); i++) {
						tbm.addRow(new Object[] { mbL.get(i).getDate(),mbL.get(i).getDstation(),mbL.get(i).getAstation(),mbL.get(i).getTrainName()
								,mbL.get(i).getSeat(),mbL.get(i).getDtime(),mbL.get(i).getAtime()});
					}
				} else {
					for (int i = 0; i < mbL.size(); i++) {
						tbm.addRow(new Object[] {"없음","없음","없음","없음",0,"없음","없음"});
					}
				}
			}
		});
		btnNewButton_2.setBounds(104, 207, 83, 23);
		pnInfo2.add(btnNewButton_2);
	}
}
