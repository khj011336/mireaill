package booking.ui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import booking.booking;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class BookingCard extends JPanel {
	private booking bk;
	
private	JLabel lblTrainId;
private	JLabel lblTrainName;
private JLabel lblDDate;
private 	JLabel lblDTime;
private	JLabel lblATime;
private	JLabel lblDStation;
private	JLabel lblAStation;
private	JLabel lblUserName;
private	JLabel lblPrice;
private	JLabel lblSeat;
private	JLabel lblTrainImage;
	public JLabel getLblTrainId() {
	return lblTrainId;
}
public void setLblTrainId(JLabel lblTrainId) {
	this.lblTrainId = lblTrainId;
}
public JLabel getLblTrainName() {
	return lblTrainName;
}
public void setLblTrainName(JLabel lblTrainName) {
	this.lblTrainName = lblTrainName;
}
public JLabel getLblDDate() {
	return lblDDate;
}
public void setLblDDate(JLabel lblDDate) {
	this.lblDDate = lblDDate;
}
public JLabel getLblDTime() {
	return lblDTime;
}
public void setLblDTime(JLabel lblDTime) {
	this.lblDTime = lblDTime;
}
public JLabel getLblATime() {
	return lblATime;
}
public void setLblATime(JLabel lblATime) {
	this.lblATime = lblATime;
}
public JLabel getLblDStation() {
	return lblDStation;
}
public void setLblDStation(JLabel lblDStation) {
	this.lblDStation = lblDStation;
}
public JLabel getLblAStation() {
	return lblAStation;
}
public void setLblAStation(JLabel lblAStation) {
	this.lblAStation = lblAStation;
}
public JLabel getLblUserName() {
	return lblUserName;
}
public void setLblUserName(JLabel lblUserName) {
	this.lblUserName = lblUserName;
}
public JLabel getLblPrice() {
	return lblPrice;
}
public void setLblPrice(JLabel lblPrice) {
	this.lblPrice = lblPrice;
}
public JLabel getLblSeat() {
	return lblSeat;
}
public void setLblSeat(JLabel lblSeat) {
	this.lblSeat = lblSeat;
}
public JLabel getLblTrainImage() {
	return lblTrainImage;
}
public void setLblTrainImage(JLabel lblTrainImage) {
	this.lblTrainImage = lblTrainImage;
}
public JLabel getLblBooking() {
	return lblBooking;
}
public void setLblBooking(JLabel lblBooking) {
	this.lblBooking = lblBooking;
}
public JLabel getLblMsg() {
	return lblMsg;
}
public void setLblMsg(JLabel lblMsg) {
	this.lblMsg = lblMsg;
}
	private JLabel lblBooking;
	private JLabel lblMsg;
	/**
	 * Create the panel.
	 */
	public BookingCard(booking bk) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		lblTrainId = new JLabel("TrainId");
		lblTrainId.setFont(new Font("±¼¸²", Font.ITALIC, 12));
		lblTrainId.setBounds(587, 6, 101, 21);
		add(lblTrainId);
		
		lblTrainName = new JLabel("#0");
		lblTrainName.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblTrainName.setBounds(234, 37, 57, 15);
		add(lblTrainName);
		
		lblDDate = new JLabel("\uCD9C\uBC1C\uB0A0\uC790");
		lblDDate.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblDDate.setText("Ãâ¹ß³¯Â¥ : " + bk.getDDate());
		lblDDate.setBounds(235, 83, 266, 15);
		add(lblDDate);
		
		lblDTime = new JLabel("\uCD9C\uBC1C\uC2DC\uAC04");
		lblDTime.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblDTime.setText(bk.getDTime());
		lblDTime.setBounds(244, 154, 113, 15);
		add(lblDTime);
		
		lblATime = new JLabel("\uB3C4\uCC29\uC2DC\uAC04");
		lblATime.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblATime.setText(bk.getaTime());
		lblATime.setBounds(390, 154, 135, 15);
		add(lblATime);
		
		lblDStation = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblDStation.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblDStation.setText(bk.getDStation());
		lblDStation.setBounds(234, 110, 135, 15);
		add(lblDStation);
		
		lblAStation = new JLabel("\uB3C4\uCC29\uC5ED");
		lblAStation.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblAStation.setText(bk.getAStation());
		lblAStation.setBounds(337, 110, 135, 15);
		add(lblAStation);
		
		lblUserName = new JLabel("\uC720\uC800\uC774\uB984");
		lblUserName.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblUserName.setText(bk.getName());
		lblUserName.setBounds(234, 58, 163, 15);
		add(lblUserName);
		
		lblTrainImage = new JLabel("");
		lblTrainImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrainImage.setIcon(new ImageIcon("./imgs/" + bk.getImgPath()));
		lblTrainImage.setBounds(12, 10, 210, 190);
		add(lblTrainImage);
		
		lblPrice = new JLabel("\uAC00\uACA9");
		lblPrice.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		String price = String.format("%8d¿ø", bk.getPrice());
		lblPrice.setText(price);
		lblPrice.setBounds(474, 37, 177, 15);
		add(lblPrice);
		
		lblSeat = new JLabel("\uC88C\uC11D");
		lblSeat.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		String seat = String.format("%sÁÂ¼®", bk.getSeat());
		lblSeat.setText(seat);
		lblSeat.setBounds(234, 133, 91, 15);
		add(lblSeat);
		
		lblBooking = new JLabel("\uC608\uC57D");
		lblBooking.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lblBooking.setBounds(234, 10, 63, 27);
		add(lblBooking);
		
		
		
		lblMsg = new JLabel("\uC704 \uC815\uBCF4\uB85C \uC608\uB9E4 \uC9C4\uD589 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		lblMsg.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblMsg.setBounds(436, 185, 252, 15);
		add(lblMsg);
		
		JLabel lblNewLabel = new JLabel("\uCD9C\uBC1C \uC2DC\uAC04: ");
		lblNewLabel.setBounds(177, 152, 77, 18);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uCC29 \uC2DC\uAC04: ");
		lblNewLabel_1.setBounds(320, 152, 77, 18);
		add(lblNewLabel_1);
		
	
		updateBookingUI(bk);
	}
	public booking getBk() {
		return bk;
	}
	public void setBk(booking bk) {
		this.bk = bk;
		//updateBookingUI();
	}
//	JLabel lblTrainName;
//	JLabel lblDDate;
//	JLabel lblDTime;
//	JLabel lblATime;
//	JLabel lblDStation;
//	JLabel lblAStation;
//	JLabel lblUserName;
//	JLabel lblPrice;
//	JLabel lblSeat;
//	JLabel lblTrainImage;
	public void updateBookingUI(booking bk) {
		this.lblTrainId.setText("NO. "+bk.getTrainID());
		this.lblTrainName.setText(""+bk.getTrainName());
		this.lblDStation.setText("Ãâ¹ß¿ª : " + bk.getDStation());
		this.lblAStation.setText("µµÂø¿ª : " + bk.getAStation());
		this.lblUserName.setText("¿¹¾àÀÚ : " + bk.getName());
		String price = String.format("¿îÀÓ¿ä±Ý : %8d¿ø", bk.getPrice());
		this.lblPrice.setText(price);
		String seat = String.format("ÁÂ¼® : '%d'¼®", bk.getSeat());
		this.lblSeat.setText(seat);
		lblTrainImage.setIcon(new ImageIcon("./imgs/" + bk.getImgPath()));
	}
}
