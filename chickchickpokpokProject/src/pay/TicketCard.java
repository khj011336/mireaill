package pay;

import javax.swing.JPanel;
import javax.swing.SwingConstants;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;

public class TicketCard extends JPanel {
	
	
	private pay pay;
	
	JLabel lblTrainId;
	JLabel lblTrainName;
	JLabel lblDDate;
	JLabel lblDTime;
	JLabel lblATime;
	JLabel lblDStation;
	JLabel lblAStation;
	JLabel lblUserName;
	JLabel lblPrice;
	JLabel lblSeat;
	private JLabel lblD;
	private JLabel lblA;
	private JLabel lblTN;
	private JLabel lblT;
	private JLabel lblSeatNo;
	private JLabel label;
	private JLabel lblU;
	/**
	 * Create the panel.
	 */
	public TicketCard(pay HTP) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblTrainId = new JLabel("TrainId");
		lblTrainId.setFont(new Font("±¼¸²", Font.ITALIC, 10));
		lblTrainId.setBounds(160, 4, 79, 21);
		add(lblTrainId);
		
		lblTrainName = new JLabel("KTX?");
		lblTrainName.setFont(new Font("HYÇìµå¶óÀÎM", Font.BOLD, 20));
		lblTrainName.setText(HTP.getTrainName());
		lblTrainName.setBounds(48, 208, 96, 25);
		add(lblTrainName);
		
		lblDDate = new JLabel("\uCD9C\uBC1C\uB0A0\uC790");
		lblDDate.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 11));
		lblDDate.setText(HTP.getDDate());
		lblDDate.setBounds(12, 79, 266, 25);
		add(lblDDate);
		
		lblDTime = new JLabel("\uCD9C\uBC1C\uC2DC\uAC04");
		lblDTime.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblDTime.setText(HTP.getDTime());
		lblDTime.setBounds(12, 152, 113, 15);
		add(lblDTime);
		
		lblATime = new JLabel("\uB3C4\uCC29\uC2DC\uAC04");
		lblATime.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblATime.setText(HTP.getATime());
		lblATime.setBounds(154, 152, 124, 15);
		add(lblATime);
		
		lblDStation = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblDStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDStation.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lblDStation.setText(HTP.getDStation());
		lblDStation.setBounds(0, 114, 91, 50);
		add(lblDStation);
		
		lblAStation = new JLabel("\uB3C4\uCC29\uC5ED");
		lblAStation.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lblAStation.setText(HTP.getAStation());
		lblAStation.setBounds(160, 114, 91, 50);
		add(lblAStation);
		
		lblUserName = new JLabel("\uC720\uC800\uC774\uB984");
		lblUserName.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		lblUserName.setText(HTP.getUserName());
		lblUserName.setBounds(160, 215, 88, 15);
		add(lblUserName);
		
		lblPrice = new JLabel("\uAC00\uACA9");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		String price = String.format("%8d¿ø", HTP.getPrice());
		lblPrice.setText(" 0\uC6D0");
		lblPrice.setBounds(124, 268, 96, 15);
		add(lblPrice);
		
		lblSeat = new JLabel("\uC88C\uC11D");
		lblSeat.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		String seat = String.format("'%s'ÁÂ¼®", HTP.getSeat());
		lblSeat.setText(seat);
		lblSeat.setBounds(48, 257, 96, 32);
		add(lblSeat);
		
		this.pay = HTP;
		
		JLabel lblMirailEn = new JLabel("MIRAIL");
		lblMirailEn.setFont(new Font("Eras Bold ITC", Font.ITALIC, 20));
		lblMirailEn.setBounds(12, -5, 82, 38);
		add(lblMirailEn);
		
		JLabel lblMirailKr = new JLabel("\uBBF8\uB808\uC77C\uCCA0\uB3C4");
		lblMirailKr.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblMirailKr.setBounds(89, -5, 75, 34);
		add(lblMirailKr);
		
		JLabel lbltrTicketKr = new JLabel("\uC5F4 \uCC28 \uC2B9 \uCC28 \uAD8C");
		lbltrTicketKr.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
		lbltrTicketKr.setBounds(48, 31, 157, 38);
		add(lbltrTicketKr);
		
		JLabel lblTicketEn = new JLabel("Train Ticket");
		lblTicketEn.setFont(new Font("Arial Unicode MS", Font.PLAIN, 9));
		lblTicketEn.setBounds(103, 66, 71, 15);
		add(lblTicketEn);
		
		JLabel lblArrowImg = new JLabel("");
		lblArrowImg.setIcon(new ImageIcon(".\\imgs\\Arrow.png"));
		lblArrowImg.setBounds(91, 127, 57, 50);
		add(lblArrowImg);
		
		lblD = new JLabel("\uCD9C\uBC1C(From)");
		lblD.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		lblD.setBounds(12, 102, 71, 15);
		add(lblD);
		
		lblA = new JLabel("\uB3C4\uCC29(To)");
		lblA.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		lblA.setBounds(142, 102, 57, 15);
		add(lblA);
		
		lblTN = new JLabel("Train No.");
		lblTN.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		lblTN.setBounds(12, 186, 57, 15);
		add(lblTN);
		
		lblT = new JLabel("\uC5F4\uCC28");
		lblT.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblT.setBounds(12, 212, 73, 21);
		add(lblT);
		
		lblSeatNo = new JLabel("Seat No.");
		lblSeatNo.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		lblSeatNo.setBounds(12, 243, 57, 15);
		add(lblSeatNo);
		
		label = new JLabel("\uC88C\uC11D");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		label.setBounds(12, 268, 37, 15);
		add(label);
		
		lblU = new JLabel("User Info.");
		lblU.setFont(new Font("±¼¸²", Font.PLAIN, 11));
		lblU.setBounds(160, 186, 60, 15);
		add(lblU);
		
	}
	public pay getPay() {
		return pay;
	}
	public void setP(pay Pay) {
		this.pay = Pay;
		updateBookingUI();
	}

//	private String trainId;
//	private String trainName;
//	private int pkUser;
////		private int DrailCode;
////		private int ArailCode;  
//	private String DStation;
//	private String AStation;
//	private String UserName;
//	private int age;
//	private int ageType;
//	private int price;
//	private int fullOrNot;
//	private String DDate;
//	private String DTime;
//	private String ATime;
//	private String PayDate;
//	private String imgPath;
	
	// Æ¼ÄÏ / ÀÌ¹ÌÁöÆÐ½º´Â ¹ÙÄÚµå
	public void updateBookingUI() {
		this.lblTrainId.setText(""+pay.getTrainId());
		this.lblDDate.setText(pay.getDDate());
		this.lblDStation.setText(pay.getDStation());
		this.lblAStation.setText(pay.getAStation());
		this.lblDTime.setText(pay.getDTime());
		this.lblATime.setText(pay.getATime());
		this.lblTrainName.setText(pay.getTrainName());
		this.lblUserName.setText(pay.getUserName());
		String seat = String.format(""+pay.getSeat());
		this.lblSeat.setText(seat);
		String price = String.format(pay.getPrice()+"¿ø");
		this.lblPrice.setText(price);
	}
}
