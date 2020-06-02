package member.myPage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BenefitInfoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private BenefitInfoDialog dlg;
	private MemberMyPageDialog mPdlg;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			BenefitInfoDialog dialog = new BenefitInfoDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public BenefitInfoDialog(MemberMyPageDialog mPdlg, boolean modal) {
		super(mPdlg, modal);
		setTitle("Mirail : \uB4F1\uAE09\uBCC4 \uD61C\uD0DD");
		this.dlg = this;
		this.mPdlg = mPdlg;
		setBounds(100, 100, 440, 156);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		contentPanel.add(table, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
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
		showTable();
	}
	
	public void showTable() {
		String[] header = {"멤버쉽(등급)", "포인트(Point)", "혜 택"};
		Object[][] data = {
			{"패밀리 회원(Family)", "0 ~ 1000", "포인트 '1%' 적립"}, 
			{"실버 회원(Silver)", "1001 ~ 2000", "포인트 '3%' 적립"},
			{"골드 회원(Gold)", "2001 ~ 5000", "포인트 '5%' 적립"},
			{"프리미엄 회원(Primium)", "5000 이상", "포인트 '10%' 적립"}
		};
		DefaultTableModel dtm
			= new DefaultTableModel(data, header); 
		table.setModel(dtm);
	}
}
