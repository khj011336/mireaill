package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import member.signUpPage.MemberSignUpPageDialog;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatusDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private StatusDialog dlg;
	public JLabel lblStatus;
	MemberSignUpPageDialog mbSUPdlg;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			StatusDialog dialog = new StatusDialog();
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
	
	/**
	 * @wbp.parser.constructor
	 */
	public StatusDialog(MemberSignUpPageDialog dlg, boolean modal) {
		super(dlg, modal);
		this.dlg = this;
		this.mbSUPdlg = dlg;
		setType(Type.POPUP);
		setBounds(100, 100, 239, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			lblStatus = new JLabel("");
			lblStatus.setForeground(Color.WHITE);
			lblStatus.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
			lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblStatus);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dlg.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public StatusDialog(MainPageFrame frm, boolean modal) {
		super(frm, modal);
		this.dlg = this;
		this.frm = frm;
		setType(Type.POPUP);
		setBounds(100, 100, 239, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			lblStatus = new JLabel("");
			lblStatus.setForeground(Color.WHITE);
			lblStatus.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
			lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblStatus);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dlg.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
