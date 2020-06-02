package member.signUpPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import admin.Admin;
import main.MainPageFrame;
import main.StatusDialog;
import member.Member;
import member.db.MemberDBManager;
import javax.swing.SwingConstants;

public class MemberSignUpPageDialog extends JDialog {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textAge;
	private JTextField textEmail1;
	private JTextField textYear;
	private JTextField textName;
	private JTextField textDay;
	private JTextField textAddress;
	private JTextField txtPNMiddle;
	private JTextField txtPNLast;
	private JTextField textEmail2;
	private JPasswordField pwFirst;
	private JPasswordField pwSecond;
	private JButton btnSignUp;
	private JComboBox comboEmail;
	private MemberSignUpPageDialog dlg;
	Connection con;
	boolean bID;
	boolean bIDCheck;
	boolean bPW;
	boolean bPWCheck;
	boolean bName;
	boolean bGender;
	boolean bAge;
	boolean bEmail;
	boolean bPN;
	boolean bYMD;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			MemberSignUpPageDialog dialog = new MemberSignUpPageDialog();
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
	
	public MemberSignUpPageDialog(MainPageFrame frm, boolean modal) {
		super(frm, modal);
		this.con =Admin.con;
		this.dlg = this;
		this.frm = frm;
		setResizable(false);
		bID = false;
		bIDCheck = false;
		bPW = false;
		bPWCheck = false;
		bName = false;
		bGender = false;
		bAge = false;
		bEmail = false;
		bPN = false;
		bYMD = false;
		setTitle("Mirail : \uD68C\uC6D0 \uAC00\uC785");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // ���ս� DISPOSE�� ����
		setBounds(100, 100, 600, 810);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.BLACK);
		contentPane.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panelTop.add(panel_2, BorderLayout.NORTH);
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(Color.BLACK);
		panel_2.add(panel_4);
		
		JLabel label = new JLabel("\uBBF8\uB808\uC77C - \uD3B8\uB9AC\uD55C \uCCA0\uB3C4 \uC608\uC57D!");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("���� ���", Font.BOLD, 15));
		label.setBackground(SystemColor.menu);
		panel_4.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panelTop.add(panel_3, BorderLayout.SOUTH);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("���� ���", Font.BOLD, 12));
		textPane.setForeground(Color.WHITE);
		textPane.setEditable(false);
		textPane.setText(" - \uBBF8\uB808\uC77C \uCCA0\uB3C4\uC608\uC57D \uD504\uB85C\uADF8\uB7A8 \uD68C\uC6D0 \uAC00\uC785\uC744 \uD658\uC601\uD569\uB2C8\uB2E4.\r\n - \uD3B8\uB9AC\uD55C \uC11C\uBE44\uC2A4\uB97C \uC774\uC6A9\uD558\uAE30 \uC704\uD574 \uC544\uB798\uC758 \uC815\uBCF4\uB97C \uAE30\uC785\uD574\uC8FC\uC2DC\uAE30 \uBC14\uB78D\uB2C8\uB2E4.\r\n\r\n\t- ' * ' \uD45C\uC2DC\uB294 \uD544\uC218\uC785\uB825\uC0AC\uD56D\uC785\uB2C8\uB2E4.\r\n\t- \uD68C\uC6D0 \uAC00\uC785\uC744 \uD558\uC2DC\uBA74 \uD3EC\uC778\uD2B8 '100\" Point\uB97C \uC9C0\uAE09\uD569\uB2C8\uB2E4.\r\n");
		textPane.setBackground(Color.BLACK);
		panel_3.add(textPane);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.DARK_GRAY);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(21, 1, 0, 5));
		
		JPanel panelID1 = new JPanel();
		panelID1.setForeground(Color.WHITE);
		panelID1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelID1);
		panelID1.setLayout(null);
		
		JLabel lblID = new JLabel("* \uC544\uC774\uB514");
		lblID.setBounds(0, 0, 92, 23);
		lblID.setFont(new Font("���� ���", Font.BOLD, 12));
		lblID.setForeground(Color.WHITE);
		panelID1.add(lblID);
		
		JLabel lblIDStatus = new JLabel("");
		lblIDStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblIDStatus.setForeground(Color.YELLOW);
		lblIDStatus.setBounds(104, 0, 328, 23);
		panelID1.add(lblIDStatus);
		
		JPanel panelID2 = new JPanel();
		panelID2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelID2);
		panelID2.setLayout(new GridLayout(0, 2, 0, 0));
		
		textID = new JTextField("���̵� �Է��ϼ���.");
		textID.setForeground(Color.LIGHT_GRAY);
		textID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblIDStatus.setText("5~20���� ���� ��ҹ���, ���� ���� ����");
				lblIDStatus.setForeground(Color.YELLOW);
				if( textID.getText().equals("���̵� �Է��ϼ���.") ) {
					textID.setText("");
					textID.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				char[] cIDArr = textID.getText().toCharArray();
				if( textID.getText().equals("") ) {
					textID.setText("���̵� �Է��ϼ���.");
					textID.setForeground(Color.LIGHT_GRAY);
				}
				if(textID.getText().length() >= 5 && textID.getText().length() <= 20) {
					for (int i = 0; i < cIDArr.length; i++) {
						if( (cIDArr[i] >= 'a' && cIDArr[i] <= 'z') || (cIDArr[i] >= 'A' && cIDArr[i] <= 'Z')
								|| (cIDArr[i] >= '0' && cIDArr[i] <= '9')) {
							System.out.println("���̵� ��밡��");
							bID = true;
						} else {
							System.out.println("���̵� ���Ұ�");
							bID = false;
							btnSignUp.setEnabled(false);
							break;
						}
					}
					if( !bID ) {
						lblIDStatus.setText("���̵� ���Ŀ� �����ʽ��ϴ�.");
						lblIDStatus.setForeground(Color.RED);
					} else {
						lblIDStatus.setText("�ߺ� Ȯ�� ���ּ���.");
						lblIDStatus.setForeground(Color.BLUE);
					}
				} else {
					System.out.println("���̵� ���Ұ�");
					bID = false;
					btnSignUp.setEnabled(false);
					lblIDStatus.setText("���̵� ���Ŀ� �����ʽ��ϴ�.");
					lblIDStatus.setForeground(Color.RED);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		textID.setFont(new Font("���� ���", Font.BOLD, 12));
		textID.setForeground(Color.LIGHT_GRAY);
		panelID2.add(textID);
		textID.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5 \uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MemberDBManager mbMgr = new MemberDBManager(con);
				String id = textID.getText();
				int dup = mbMgr.isDuplicatedMember(id);
				String errMsg = null;
				char[] cIDArr = textID.getText().toCharArray();
				switch (dup) {
				case 0:
					// �α��� �̸��� �ߺ����� �ʾҴ�
					if(textID.getText().length() >= 5 && textID.getText().length() <= 20) {
						for (int i = 0; i < cIDArr.length; i++) {
							if( (cIDArr[i] >= 'a' && cIDArr[i] <= 'z') || (cIDArr[i] >= 'A' && cIDArr[i] <= 'Z')
									|| (cIDArr[i] >= '0' && cIDArr[i] <= '9')) {
								System.out.println("���̵� ��밡��");
								bIDCheck = true;
							} else {
								System.out.println("���̵� ���Ұ�");
								bIDCheck = false;
								btnSignUp.setEnabled(false);
								break;
							}
						}
						
						if( !bIDCheck ) {
							lblIDStatus.setText("���̵� ���Ŀ� �����ʽ��ϴ�.");
							lblIDStatus.setForeground(Color.RED);
						} else {
							lblIDStatus.setText("��� ������ ���̵��Դϴ�.");
							lblIDStatus.setForeground(Color.BLUE);
						}
					} else {
						System.out.println("���̵� ���Ұ�");
						bIDCheck = false;
						btnSignUp.setEnabled(false);
						lblIDStatus.setText("���̵� ���Ŀ� �����ʽ��ϴ�.");
						lblIDStatus.setForeground(Color.RED);
					}
					break;
				case 1: errMsg = "���̵� �ߺ��Ǿ����ϴ�.";
				case 2: if( errMsg == null )  
							errMsg = "DB ����!!";
				case 3: if( errMsg == null )
							errMsg = "��� ����!!";
					lblIDStatus.setForeground(Color.RED);
					lblIDStatus.setText(errMsg);
				default:
					break;
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		btnNewButton.setFont(new Font("���� ���", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		panelID2.add(btnNewButton);
		
		JPanel panelPW1 = new JPanel();
		panelPW1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelPW1);
		panelPW1.setLayout(null);
		
		JLabel lblPW = new JLabel("* \uBE44\uBC00\uBC88\uD638");
		lblPW.setBounds(0, 0, 92, 23);
		lblPW.setFont(new Font("���� ���", Font.BOLD, 12));
		lblPW.setForeground(Color.WHITE);
		panelPW1.add(lblPW);
		
		JLabel lblPWStatus = new JLabel("");
		lblPWStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblPWStatus.setForeground(Color.WHITE);
		lblPWStatus.setBounds(104, 0, 328, 23);
		panelPW1.add(lblPWStatus);
		
		JPanel panelPW2 = new JPanel();
		panelPW2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelPW2);
		panelPW2.setLayout(new GridLayout(0, 1, 0, 0));
		
		pwFirst = new JPasswordField();
		pwFirst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblPWStatus.setText("4~8���� ���� �ҹ���, ���� ���� ����");
				lblPWStatus.setForeground(Color.YELLOW);
			}
			@Override
			public void focusLost(FocusEvent e) {
				char[] cPWArr = pwFirst.getPassword();
				if(cPWArr.length >= 4 && cPWArr.length <= 8) {
					for (int i = 0; i < cPWArr.length; i++) {
						if( (cPWArr[i] >= 'a' && cPWArr[i] <= 'z') || (cPWArr[i] >= '0' && cPWArr[i] <= '9')) {
							System.out.println("��й�ȣ ��밡��");
							bPW = true;
						} else {
							System.out.println("��й�ȣ ���Ұ�");
							bPW = false;
							btnSignUp.setEnabled(false);
							break;
						}
					}
					if( !bPW ) {
						lblPWStatus.setText("��й�ȣ ���Ŀ� �����ʽ��ϴ�.");
						lblPWStatus.setForeground(Color.RED);
					} else {
						lblPWStatus.setText("��� ������ ��й�ȣ�Դϴ�.");
						lblPWStatus.setForeground(Color.BLUE);
					}
				} else {
					System.out.println("��й�ȣ ���Ұ�");
					bPW = false;
					btnSignUp.setEnabled(false);
					lblPWStatus.setText("��й�ȣ ���Ŀ� �����ʽ��ϴ�.");
					lblPWStatus.setForeground(Color.RED);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		pwFirst.setFont(new Font("���� ���", Font.BOLD, 12));
		panelPW2.add(pwFirst);
		
		JPanel panelPWCheck1 = new JPanel();
		panelPWCheck1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelPWCheck1);
		panelPWCheck1.setLayout(null);
		
		JLabel lblPWCheck = new JLabel("* \uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lblPWCheck.setBounds(0, 0, 92, 23);
		lblPWCheck.setFont(new Font("���� ���", Font.BOLD, 12));
		lblPWCheck.setForeground(Color.WHITE);
		panelPWCheck1.add(lblPWCheck);
		
		JLabel lblPWCheckStatus = new JLabel("");
		lblPWCheckStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblPWCheckStatus.setForeground(Color.WHITE);
		lblPWCheckStatus.setBounds(104, 0, 328, 23);
		panelPWCheck1.add(lblPWCheckStatus);
		
		JPanel panelPWCheck2 = new JPanel();
		panelPWCheck2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelPWCheck2);
		panelPWCheck2.setLayout(new GridLayout(0, 1, 0, 0));
		
		pwSecond = new JPasswordField();
		pwSecond.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( pwSecond.getPassword().length != 0 && new String(pwFirst.getPassword()).equals(new String(pwSecond.getPassword())) ) {
					lblPWCheckStatus.setText("��й�ȣ�� ��ġ�մϴ�.");
					lblPWCheckStatus.setForeground(Color.BLUE);
					System.out.println("��й�ȣ Ȯ�� ��ġ");
					bPWCheck = true;
				} else if( pwSecond.getPassword().length != 0 ){
					lblPWCheckStatus.setText("��й�ȣ�� ����ġ�մϴ�.");
					lblPWCheckStatus.setForeground(Color.RED);
					System.out.println("��й�ȣ Ȯ�� ����ġ");
					bPWCheck = false;
					btnSignUp.setEnabled(false);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		pwSecond.setFont(new Font("���� ���", Font.BOLD, 12));
		panelPWCheck2.add(pwSecond);
		
		JPanel panelName1 = new JPanel();
		panelName1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelName1);
		panelName1.setLayout(null);
		
		JLabel lblName = new JLabel("* \uC774\uB984");
		lblName.setBounds(0, 0, 92, 23);
		lblName.setFont(new Font("���� ���", Font.BOLD, 12));
		lblName.setForeground(Color.WHITE);
		panelName1.add(lblName);
		
		JLabel lblNameStatus = new JLabel("");
		lblNameStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblNameStatus.setForeground(Color.WHITE);
		lblNameStatus.setBounds(104, 0, 328, 23);
		panelName1.add(lblNameStatus);
		
		JPanel panelName2 = new JPanel();
		panelName2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelName2);
		panelName2.setLayout(new GridLayout(0, 1, 0, 0));
		
		textName = new JTextField();
		textName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if( textName.getText() != null && !textName.getText().isEmpty() ) {
					lblNameStatus.setText("���� �̸��̳׿�!");
					lblNameStatus.setForeground(Color.BLUE);
					System.out.println("�̸� ��밡��");
					bName = true;
				} else {
					lblNameStatus.setText("�̸��� �Է� ���ּ���.");
					lblNameStatus.setForeground(Color.RED);
					System.out.println("�̸� ���Ұ�");
					bName = false;
					btnSignUp.setEnabled(false);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		textName.setFont(new Font("���� ���", Font.BOLD, 12));
		panelName2.add(textName);
		textName.setColumns(10);
		
		JPanel panelGender1 = new JPanel();
		panelGender1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelGender1);
		panelGender1.setLayout(null);
		
		JLabel lblGender = new JLabel("* \uC131\uBCC4");
		lblGender.setBounds(0, 0, 92, 23);
		lblGender.setFont(new Font("���� ���", Font.BOLD, 12));
		lblGender.setForeground(Color.WHITE);
		panelGender1.add(lblGender);
		
		JLabel lblGenderStatus = new JLabel("");
		lblGenderStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblGenderStatus.setForeground(Color.WHITE);
		lblGenderStatus.setBounds(104, 0, 328, 23);
		panelGender1.add(lblGenderStatus);
		
		JPanel panelGender2 = new JPanel();
		panelGender2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelGender2);
		panelGender2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(comboBoxGender.getSelectedItem().equals("����")) {
					lblGenderStatus.setText("������ �������ּ���.");
					lblGenderStatus.setForeground(Color.RED);
					System.out.println("���� ���Ұ�");
					bGender = false;
					btnSignUp.setEnabled(false);
				} else {
					lblGenderStatus.setText("");
					System.out.println("���� ��밡��");
					bGender = true;
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		comboBoxGender.setFont(new Font("���� ���", Font.PLAIN, 12));
		comboBoxGender.setBackground(Color.WHITE);
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"\uC131\uBCC4", "\uB0A8\uC790", "\uC5EC\uC790"}));
		panelGender2.add(comboBoxGender);
		
		JPanel panelAge1 = new JPanel();
		panelAge1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelAge1);
		panelAge1.setLayout(null);
		
		JLabel lblAge = new JLabel("* \uB098\uC774");
		lblAge.setBounds(0, 0, 92, 23);
		lblAge.setFont(new Font("���� ���", Font.BOLD, 12));
		lblAge.setForeground(Color.WHITE);
		panelAge1.add(lblAge);
		
		JLabel lblAgeStatus = new JLabel("");
		lblAgeStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblAgeStatus.setForeground(Color.WHITE);
		lblAgeStatus.setBounds(104, 0, 328, 23);
		panelAge1.add(lblAgeStatus);
		
		JPanel panelAge2 = new JPanel();
		panelAge2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelAge2);
		panelAge2.setLayout(new GridLayout(1, 0, 0, 0));
		
		textAge = new JTextField();
		textAge.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				char[] cAgeArr = textAge.getText().toCharArray();
				for (int i = 0; i < cAgeArr.length; i++) {
					if( (cAgeArr[i] >= '0' && cAgeArr[i] <= '9')) {
						System.out.println("���� ��밡��");
						bAge = true;
					} else {
						System.out.println("���� ���Ұ�");
						bAge = false;
						btnSignUp.setEnabled(false);
						break;
					}
				}
				if( !bAge ) {
					lblAgeStatus.setText("���ڸ� �Է����ּ���.");
					lblAgeStatus.setForeground(Color.RED);
				} else {
					lblAgeStatus.setText("");
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		textAge.setFont(new Font("���� ���", Font.BOLD, 12));
		textAge.setText("");
		panelAge2.add(textAge);
		textAge.setColumns(10);
		
		JPanel panelEmail1 = new JPanel();
		panelEmail1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelEmail1);
		panelEmail1.setLayout(null);
		
		JLabel lblEmail = new JLabel("* \uC774\uBA54\uC77C\uC8FC\uC18C");
		lblEmail.setBounds(0, 0, 92, 23);
		lblEmail.setFont(new Font("���� ���", Font.BOLD, 12));
		lblEmail.setForeground(Color.WHITE);
		panelEmail1.add(lblEmail);
		
		JLabel lblEmailStatus = new JLabel("");
		lblEmailStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblEmailStatus.setForeground(Color.WHITE);
		lblEmailStatus.setBounds(104, 0, 328, 23);
		panelEmail1.add(lblEmailStatus);
		
		JPanel panelEmail2 = new JPanel();
		panelEmail2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelEmail2);
		panelEmail2.setLayout(new GridLayout(1, 0, 0, 0));
		
		textEmail1 = new JTextField();
		textEmail1.setFont(new Font("���� ���", Font.BOLD, 12));
		textEmail1.setBackground(Color.WHITE);
		textEmail1.setText("");
		panelEmail2.add(textEmail1);
		textEmail1.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(Color.WHITE);
		panel_5.setBackground(Color.DARK_GRAY);
		panelEmail2.add(panel_5);
		
		JLabel label_1 = new JLabel("@");
		label_1.setForeground(Color.WHITE);
		panel_5.add(label_1);
		
		textEmail2 = new JTextField();
		textEmail2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( textEmail2.getText().equals("�����Է�") ) {
					textEmail2.setText("");
					textEmail2.setForeground(Color.BLACK);
				} else {
					textEmail2.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if( textEmail2.getText().equals("�����Է�") ) {
					textEmail2.setText("�����Է�");
					textEmail2.setForeground(Color.LIGHT_GRAY);
				} else {
					textEmail2.setForeground(Color.BLACK);
				}
			}
		});
		textEmail2.setFont(new Font("���� ���", Font.BOLD, 12));
		textEmail2.setForeground(Color.LIGHT_GRAY);
		textEmail2.setText("\uC9C1\uC811\uC785\uB825");
		panelEmail2.add(textEmail2);
		textEmail2.setColumns(10);
		
		comboEmail = new JComboBox();
		comboEmail.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if( !comboEmail.getSelectedItem().equals("�����Է�") ) {
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
		comboEmail.setFont(new Font("���� ���", Font.PLAIN, 12));
		comboEmail.setBackground(Color.WHITE);
		comboEmail.setModel(new DefaultComboBoxModel(new String[] {"\uC9C1\uC811\uC785\uB825", "naver.com", "daum.net", "google.com"}));
		panelEmail2.add(comboEmail);
		
		JPanel panelPhoneNumber1 = new JPanel();
		panelPhoneNumber1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelPhoneNumber1);
		panelPhoneNumber1.setLayout(null);
		
		JLabel lblPhoneNumber = new JLabel("* \uC5F0\uB77D\uCC98");
		lblPhoneNumber.setBounds(0, 0, 92, 23);
		lblPhoneNumber.setFont(new Font("���� ���", Font.BOLD, 12));
		lblPhoneNumber.setForeground(Color.WHITE);
		panelPhoneNumber1.add(lblPhoneNumber);
		
		JLabel lblPNStatus = new JLabel("");
		lblPNStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblPNStatus.setForeground(Color.WHITE);
		lblPNStatus.setBounds(104, 0, 328, 23);
		panelPhoneNumber1.add(lblPNStatus);
		
		JPanel panelPhoneNumber2 = new JPanel();
		panelPhoneNumber2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelPhoneNumber2);
		panelPhoneNumber2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox comboPNFirst = new JComboBox();
		comboPNFirst.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( textEmail1.getText() != null && !textEmail1.getText().isEmpty() 
						&& textEmail2.getText() != null && !textEmail2.getText().isEmpty()
						&& !textEmail2.getText().equals("�����Է�") ) {
					lblEmailStatus.setText("");
					System.out.println("�̸��� ��밡��");
					bEmail = true;
				} else {
					lblEmailStatus.setText("�̸����� �Է�/���� ���ּ���.");
					lblEmailStatus.setForeground(Color.RED);
					System.out.println("�̸��� ���Ұ�");
					bEmail = false;
					btnSignUp.setEnabled(false);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		comboPNFirst.setFont(new Font("���� ���", Font.PLAIN, 12));
		comboPNFirst.setBackground(Color.WHITE);
		comboPNFirst.setModel(new DefaultComboBoxModel(new String[] {"010", "02", "031", "032", "033", "041", "042", "043", "044", "051", "052", "053", "054", "055", "061", "062", "063", "064"}));
		panelPhoneNumber2.add(comboPNFirst);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panelPhoneNumber2.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		txtPNMiddle = new JTextField();
		txtPNMiddle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( textEmail1.getText() != null && !textEmail1.getText().isEmpty() 
						&& textEmail2.getText() != null && !textEmail2.getText().isEmpty()
						&& !textEmail2.getText().equals("�����Է�") ) {
					lblEmailStatus.setText("");
					System.out.println("�̸��� ��밡��");
					bEmail = true;
				} else {
					lblEmailStatus.setText("�̸����� �Է�/���� ���ּ���.");
					lblEmailStatus.setForeground(Color.RED);
					System.out.println("�̸��� ���Ұ�");
					bEmail = false;
					btnSignUp.setEnabled(false);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		txtPNMiddle.setFont(new Font("���� ���", Font.BOLD, 12));
		panelPhoneNumber2.add(txtPNMiddle);
		txtPNMiddle.setColumns(4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panelPhoneNumber2.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1);
		
		txtPNLast = new JTextField();
		txtPNLast.setFont(new Font("���� ���", Font.BOLD, 12));
		panelPhoneNumber2.add(txtPNLast);
		txtPNLast.setColumns(4);
		
		JPanel panelBirthday1 = new JPanel();
		panelBirthday1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelBirthday1);
		panelBirthday1.setLayout(null);
		
		JLabel lblBirthday = new JLabel("* \uC0DD\uB144\uC6D4\uC77C");
		lblBirthday.setBounds(0, 0, 92, 23);
		lblBirthday.setFont(new Font("���� ���", Font.BOLD, 12));
		lblBirthday.setForeground(Color.WHITE);
		panelBirthday1.add(lblBirthday);
		
		JLabel lblBirthdayStatus = new JLabel("");
		lblBirthdayStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblBirthdayStatus.setForeground(Color.WHITE);
		lblBirthdayStatus.setBounds(104, 0, 328, 23);
		panelBirthday1.add(lblBirthdayStatus);
		
		JPanel panelBirthday2 = new JPanel();
		panelBirthday2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelBirthday2);
		panelBirthday2.setLayout(new GridLayout(0, 3, 5, 0));
		
		textYear = new JTextField();
		textYear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if( txtPNMiddle.getText() != null && !txtPNMiddle.getText().isEmpty() 
					&& txtPNLast.getText() != null && !txtPNLast.getText().isEmpty()
					&& txtPNMiddle.getText().length() > 2 && txtPNMiddle.getText().length() < 5
					&& txtPNLast.getText().length() == 4 ) {
					lblPNStatus.setText("");
					System.out.println("����ó ��밡��");
					bPN = true;
				} else {
					lblPNStatus.setText("����ó�� ��Ȯ�ϰ� �Է�/���� ���ּ���.");
					lblPNStatus.setForeground(Color.RED);
					System.out.println("����ó ���Ұ�");
					bPN = false;
					btnSignUp.setEnabled(false);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
				if( textYear.getText().equals("��(4��)") ) {
					textYear.setText("");
					textYear.setForeground(Color.BLACK);
				} else {
					textYear.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if( textYear.getText().isEmpty() ) {
					textYear.setText("��(4��)");
					textYear.setForeground(Color.LIGHT_GRAY);
				} else {
					textYear.setForeground(Color.BLACK);
				}
			}
		});
		textYear.setFont(new Font("���� ���", Font.BOLD, 12));
		textYear.setForeground(Color.LIGHT_GRAY);
		textYear.setText("\uB144(4\uC790)");
		panelBirthday2.add(textYear);
		textYear.setColumns(10);
		
		JComboBox comboBoxMonth = new JComboBox();
		comboBoxMonth.setFont(new Font("���� ���", Font.PLAIN, 12));
		comboBoxMonth.setBackground(Color.WHITE);
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"\uC6D4", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		panelBirthday2.add(comboBoxMonth);
		
		textDay = new JTextField();
		textDay.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( textDay.getText().equals("��") ) {
					textDay.setText("");
					textDay.setForeground(Color.BLACK);
				} else {
					textDay.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if( textDay.getText().isEmpty() ) {
					textDay.setText("��");
					textDay.setForeground(Color.LIGHT_GRAY);
				} else {
					textDay.setForeground(Color.BLACK);
				}
				if( textYear.getText() != null && !textYear.getText().isEmpty() 
					&& textDay.getText() != null && !textDay.getText().isEmpty()
					&& !comboBoxMonth.getSelectedItem().equals("��") && textYear.getText().length() < 5
					&& Integer.parseInt(textDay.getText()) < 32 && Integer.parseInt(textDay.getText()) > 0) {
					lblBirthdayStatus.setText("");
					System.out.println("������� ��밡��");
					bYMD = true;
				} else {
					lblBirthdayStatus.setText("��������� ��Ȯ�ϰ� �Է�/���� ���ּ���.");
					lblBirthdayStatus.setForeground(Color.RED);
					System.out.println("������� ���Ұ�");
					bYMD = false;
					btnSignUp.setEnabled(false);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		textDay.setFont(new Font("���� ���", Font.BOLD, 12));
		textDay.setForeground(Color.LIGHT_GRAY);
		textDay.setText("\uC77C");
		panelBirthday2.add(textDay);
		textDay.setColumns(10);
		
		JPanel panelAddress1 = new JPanel();
		panelAddress1.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelAddress1);
		panelAddress1.setLayout(null);
		
		JLabel lblAddress = new JLabel("\uC8FC\uC18C (\uC0AC\uB294 \uACF3)");
		lblAddress.setBounds(0, 0, 92, 23);
		lblAddress.setFont(new Font("���� ���", Font.BOLD, 12));
		lblAddress.setForeground(Color.WHITE);
		panelAddress1.add(lblAddress);
		
		JLabel lblAddressStatus = new JLabel("");
		lblAddressStatus.setFont(new Font("���� ���", Font.BOLD, 12));
		lblAddressStatus.setForeground(Color.WHITE);
		lblAddressStatus.setBounds(104, 0, 328, 23);
		panelAddress1.add(lblAddressStatus);
		
		JPanel panelAddress2 = new JPanel();
		panelAddress2.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelAddress2);
		panelAddress2.setLayout(new GridLayout(0, 1, 0, 0));
		
		textAddress = new JTextField();
		textAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if( textYear.getText() != null && !textYear.getText().isEmpty() 
					&& textDay.getText() != null && !textDay.getText().isEmpty()
					&& !comboBoxMonth.getSelectedItem().equals("��") && textYear.getText().length() < 5
					&& Integer.parseInt(textDay.getText()) < 32 && Integer.parseInt(textDay.getText()) > 0) {
					lblBirthdayStatus.setText("");
					System.out.println("������� ��밡��");
					bYMD = true;
				} else {
					lblBirthdayStatus.setText("��������� ��Ȯ�ϰ� �Է�/���� ���ּ���.");
					lblBirthdayStatus.setForeground(Color.RED);
					System.out.println("������� ���Ұ�");
					bYMD = false;
					btnSignUp.setEnabled(false);
				}
				if( bID && bPW && bPWCheck && bName	&& bGender && bAge && bEmail && bPN && bYMD) btnSignUp.setEnabled(true);
			}
		});
		textAddress.setFont(new Font("���� ���", Font.BOLD, 12));
		panelAddress2.add(textAddress);
		textAddress.setColumns(10);
		
		JPanel panelSignUp = new JPanel();
		panelSignUp.setBackground(Color.DARK_GRAY);
		panelCenter.add(panelSignUp);
		panelSignUp.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnSignUp = new JButton("\uAC00\uC785\uD558\uAE30");
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.setEnabled(false);
		btnSignUp.setFont(new Font("���� ���", Font.BOLD, 12));
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDBManager mbDBMgr = new MemberDBManager(con);
				String iD = "";
				String pW = "";
				String name = "";
				int age = 0;
				int gender = 0;
				String email = "";
				String phoneNumber = "";
				String address = "";
				String birthday = "";
				if( textID.getText() != null && !textID.getText().isEmpty() ) {
					iD = textID.getText();
				}
				if( new String(pwFirst.getPassword()) != null && !new String(pwFirst.getPassword()).isEmpty() ) {
					pW = new String(pwFirst.getPassword());
				}
				if( new String(pwSecond.getPassword()) != null && !new String(pwSecond.getPassword()).isEmpty() ) {
					if( pW.equals(new String(pwSecond.getPassword())) ) {
						pW = new String(pwSecond.getPassword());
					}
				}
				if( textName.getText() != null && !textName.getText().isEmpty() ) {
					name = textName.getText();
				}
				if( !comboBoxGender.getSelectedItem().equals("����") ) {
					gender = comboBoxGender.getSelectedItem().equals("����")?1:2;
				}
				if( textAge.getText() != null && !textAge.getText().isEmpty() ) {
					age = Integer.parseInt(textAge.getText());
				}
				if( textEmail1.getText() != null && !textEmail1.getText().isEmpty() 
					&& textEmail2.getText() != null && !textEmail2.getText().isEmpty() ) {
					email = textEmail1.getText()+"@"+textEmail2.getText();
				}
				if( txtPNMiddle.getText() != null && !txtPNMiddle.getText().isEmpty() 
					&& txtPNLast.getText() != null && !txtPNLast.getText().isEmpty() ) {
					phoneNumber = (String)comboPNFirst.getSelectedItem()+"-"+txtPNMiddle.getText()+"-"+txtPNLast.getText();
				}
				if( textYear.getText() != null && !textYear.getText().isEmpty() 
					&& textDay.getText() != null && !textDay.getText().isEmpty()
					&& !comboBoxMonth.getSelectedItem().equals("��") ) {
					birthday = textYear.getText() + "-" + (String)comboBoxMonth.getSelectedItem() + "-" + textDay.getText();
				}
				address = textAddress.getText();
				Member mb = new Member(iD, pW, name, gender, age, email, phoneNumber, address, birthday);
				boolean b = mbDBMgr.insertNewMemberByAutoPk_user(mb);
				if( b ) {
					dlg.dispose();
					System.out.println("ȸ������ ����");
					StatusDialog sDlg = new StatusDialog(dlg, true);
					sDlg.lblStatus.setText("ȸ���� �ǽŰ� ȯ���մϴ�.");
					sDlg.lblStatus.setFont(new Font("���� ���", Font.BOLD, 15));
					sDlg.setVisible(true);
				}
				else System.out.println("ȸ������ ����");
			}
		});
		panelSignUp.add(btnSignUp);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(Color.DARK_GRAY);
		contentPane.add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBlank1 = new JLabel("                 ");
		lblBlank1.setBackground(Color.BLACK);
		panelEast.add(lblBlank1);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.DARK_GRAY);
		contentPane.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBlank2 = new JLabel("                  ");
		lblBlank2.setBackground(Color.DARK_GRAY);
		panelWest.add(lblBlank2);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(Color.DARK_GRAY);
		contentPane.add(panelBottom, BorderLayout.SOUTH);
	}

}
