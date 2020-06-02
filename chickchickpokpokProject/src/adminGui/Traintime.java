package adminGui;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class Traintime extends JPanel implements Runnable {
	JLabel TrainTime;
	boolean br;
	/**
	 * Create the panel.
	 */
	
	public Traintime(boolean br) {
		
		this.br = br;
		TrainTime = new JLabel();
		TrainTime.setForeground(Color.WHITE);
		TrainTime.setBackground(Color.DARK_GRAY);
		TrainTime.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		TrainTime.setVisible(true);
		Thread t = new Thread(this);
		t.start();
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.add(TrainTime);
	}
	public String TrainTime() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
				int month = now.get(Calendar.MONTH);
				int date = now.get(Calendar.DATE);
				int hour = now.get(Calendar.HOUR_OF_DAY);
				int minute = now.get(Calendar.MINUTE);
				int second = now.get(Calendar.SECOND);
				String Thour = "";
				String Tminute = "";
				String Tsecond = "";
				if(hour < 10) {
		            Thour = "0" + hour;
		        } else {
		            Thour = String.valueOf(hour);
		        }
		        if(minute < 10) {
		            Tminute = "0" + minute;
		            
		        } else {
		            Tminute = String.valueOf(minute);
		        }
		        if(second < 10) {
		            Tsecond = "0" + second;
		        } else {
		            Tsecond = String.valueOf(second);
		        }
		        if(br) {
		        	TrainTime.setForeground(Color.black);
		        	setBorder(new LineBorder(Color.white));
		        return String.format("<html><color=black>%s³â%s¿ù%sÀÏ</font>&nbsp;&nbsp;&nbsp;%s:%s:%s</html>", year,(month+1),date,Thour,Tminute,Tsecond);
		        }else {
		        return String.format("<html><color=black>%s³â%s¿ù%sÀÏ&nbsp;&nbsp;%s:%s:%s</html>", year,(month+1),date,Thour,Tminute,Tsecond);
		        }
		    }
//	public static void main(String[] args) {
//		Ttime t = new Ttime();
//		JFrame fr = new JFrame();
//		fr.add(t);
//		t.setVisible(true);
//		
//	}
		 
		    @Override
		    public void run() {
		        while (true) {
		            this.TrainTime.setText(TrainTime());
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }
		        }
		    }
		    }