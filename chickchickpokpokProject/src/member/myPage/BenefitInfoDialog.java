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
		String[] header = {"�����(���)", "����Ʈ(Point)", "�� ��"};
		Object[][] data = {
			{"�йи� ȸ��(Family)", "0 ~ 1000", "����Ʈ '1%' ����"}, 
			{"�ǹ� ȸ��(Silver)", "1001 ~ 2000", "����Ʈ '3%' ����"},
			{"��� ȸ��(Gold)", "2001 ~ 5000", "����Ʈ '5%' ����"},
			{"�����̾� ȸ��(Primium)", "5000 �̻�", "����Ʈ '10%' ����"}
		};
		DefaultTableModel dtm
			= new DefaultTableModel(data, header); 
		table.setModel(dtm);
	}
}
