package booking.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import booking.BookingDBMgr;
import booking.booking;
import member.Member;
import pay.PayGuiMain;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class ChoiceDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ChoiceDlg dlg;
	JFrame bfm;
	BookingCard pnBookingMsg;
	JDialog jdg ;
//	public ChoiceDlg(JFrame owner, String title, boolean modal) {
//		super(owner, title, modal);
//		dlgTitle = title;
//	}	
	public ChoiceDlg(JFrame bfm, boolean modal, booking bk ,Connection con,Member member) {
		super(bfm, modal);
		jdg = this;
		setResizable(false);
		this.bfm = bfm;
		this.dlg = this;
		setTitle("\uC608\uB9E4 \uC815\uBCF4");
		setBounds(100, 100, 800, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setOpaque(true);
		contentPanel.setVisible(true);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JPanel pnBookingList = new JPanel();
		
		pnBookingList.setBounds(38, 10, 700, 219);
		pnBookingList.setOpaque(true);
		pnBookingList.setVisible(true);
		contentPanel.add(pnBookingList);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("\uD655\uC778");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				btnOk.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						//TODO
						//member Imb = member;
						int agetype = 1;
							PayGuiMain paymain = new PayGuiMain(member,bk,bfm);
							paymain.getLblUserName().setText(member.getName());
							paymain.setVisible(true);
							paymain.getDef().addRow(new Object[] {bk.getDDate(),bk.getTrainID(),bk.getTrainName(),
									bk.getDStation(),bk.getDTime(),bk.getAStation(),bk.getaTime(),"1",bk.getPrice()});
							paymain.getDef2().addRow(new Object[] {bk.getSeat(),(member.getAge()<18? "청소년":"성인"),bk.getPrice(),"0",bk.getPrice()});
							paymain.getTxtSumPrice().setText(bk.getPrice()+"");
							dispose();
						
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancel = new JButton("\uCDE8\uC18C");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				
				buttonPane.add(btnCancel);
			}
		}
	
		pnBookingList.setLayout(new BorderLayout(0, 0));
		pnBookingMsg = new BookingCard(bk);
	
		pnBookingList.add(pnBookingMsg);
		
		
	}
}
