package railmap;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import booking.BookingDBMgr;
import booking.booking;
import booking.ui.ImagePanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

import admin.Admin;

public class RailMap extends JFrame {
	
	private JPanel contentPane;
	
	rail Rail;
	ImageIcon ic;
	JPanel pnBG;
	private JPanel panel;
	private JLabel lblM;
	private JPanel pnA;
	private JPanel JpanelMap;
	JPanel pnCardBG;
	JPanel pnCard;
	public CardLayout cardMgr;
	JLabel lblSeoul ;
	JLabel txtLocation;
	  JLabel txtCP ;
	  JFreeChart jfee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin.connectTrainDB();
					RailMap frame = new RailMap();
					frame.stationPopStat("¼­¿ï");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	private JPanel pnCards;
	
	public static ArrayList<rail> railList = new ArrayList<rail>();
	private JLabel lblO;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblseoul;
	private JLabel lblsuwon;
	private JLabel lblosung;
	private JLabel lblkimchun;
	private JLabel lblmilyang;
	private JLabel lblbusan;
	private  JPanel panel_4 ;
	
		
		
	public void stationPopStat(String dstation) {
		panel_4.removeAll();
		final String[] time = {
			"05H~07H","08H~10H","11H~12H","13H~15H","16H~18H","19H~21H","22H~24H"	
		};
		BookingDBMgr bk = new BookingDBMgr(Admin.con);
		ArrayList<booking> bkl=bk.selectAllMembers(dstation,"dd");
		System.out.println(bkl.size());
		HashMap<String, ArrayList<booking>> hash  = new HashMap<>();
		 
		for (int j = 0; j <time.length; j++) {
			hash.put(time[j], new ArrayList<booking>());
		}
			for (int i = 0; i < bkl.size(); i++) {
				if(bkl.get(i).getPkUser()!=-1) {
					int a = Integer.parseInt(bkl.get(i).getDTime().split("½Ã")[0]);
					System.out.println(a+"integer");
					if(5 <= a&& a<=7) {
						hash.get(time[0]).add(bkl.get(i));
					}else if(8 <= a&& a<=10) {
						hash.get(time[1]).add(bkl.get(i));
					}else if(11 <= a&& a<=12) {
						hash.get(time[2]).add(bkl.get(i));
					}else if(13 <= a&& a<=15) {
						hash.get(time[3]).add(bkl.get(i));
					}else if(16 <= a&& a<=18) {
						hash.get(time[4]).add(bkl.get(i));
					}else if(19 <= a&& a<=21) {
						hash.get(time[5]).add(bkl.get(i));
					}else if(22 <= a&& a<=24) {
						hash.get(time[6]).add(bkl.get(i));
					}
				}
			
		}
			HashMap<String, String> station = new HashMap<String, String>();
			station.put("¼­¿ï","Seoul Station");
			station.put("¼ö¿ø", "Suwon Station");
			station.put("¿À¼Û", "Osung Station");
			station.put("±èÃµ", "Kimchun Station");
			station.put("¹Ð¾ç", "Milyang Station");
			station.put("ºÎ»ê", "Busan Station");

			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; i < hash.size(); i++) {
			int count = 0;
			if(hash.get(time[i]).isEmpty()) {
				dataset.addValue(count, time[i],
						station.get(dstation)+" passenger");	
			}else {
			count = hash.get(time[i]).size();	
			dataset.addValue(count, time[i], station.get(dstation)+" passenger");
				
			}
			
			 		}
		
		jfee = ChartFactory.createBarChart(station.get(dstation)+"(Passengers Status)","Today's Passengers Status ","number of passenger", dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chart = new ChartPanel(jfee);
		panel_4.add(chart);
		
	}
	
	public RailMap() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnBG = new JPanel();
		pnBG.setBounds(5, 78, 1174, 574);
		contentPane.add(pnBG);
		pnBG.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pnBG.add(tabbedPane, BorderLayout.CENTER);
		
		pnA = new JPanel();
		tabbedPane.addTab("°æºÎ¼±", null, pnA, null);
		pnA.setLayout(null);
		ImageIcon imc = new ImageIcon(".\\imgs\\railMap.png");
		JpanelMap = new ImagePanel(imc.getImage());
		
		JpanelMap.setBounds(12, 10, 441, 525);
		pnA.add(JpanelMap);
		JpanelMap.setLayout(null);
		
		lblO = new JLabel("o");
		lblO.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblO.setForeground(Color.ORANGE);
		lblO.setBounds(133, 133, 10, 15);
		JpanelMap.add(lblO);
		
		label = new JLabel("o");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		label.setBounds(158, 202, 10, 15);
		JpanelMap.add(label);
		
		label_1 = new JLabel("o");
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		label_1.setBounds(190, 274, 10, 15);
		JpanelMap.add(label_1);
		
		label_2 = new JLabel("o");
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		label_2.setBounds(293, 330, 10, 15);
		JpanelMap.add(label_2);
		
		label_3 = new JLabel("o");
		label_3.setForeground(Color.ORANGE);
		label_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		label_3.setBounds(342, 381, 10, 15);
		JpanelMap.add(label_3);
		
		label_4 = new JLabel("o");
		label_4.setForeground(Color.ORANGE);
		label_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		label_4.setBounds(377, 441, 10, 15);
		JpanelMap.add(label_4);
		ArrayList<JLabel> jlb = new ArrayList<JLabel>();
		lblseoul = new JLabel("\uC11C\uC6B8");
		
		lblseoul.setHorizontalAlignment(SwingConstants.CENTER);
		lblseoul.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lblseoul.setBounds(111, 119, 57, 15);
		JpanelMap.add(lblseoul);
		jlb.add(lblseoul);
		lblsuwon = new JLabel("\uC218\uC6D0");
		
		lblsuwon.setHorizontalAlignment(SwingConstants.CENTER);
		lblsuwon.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lblsuwon.setBounds(133, 187, 57, 15);
		JpanelMap.add(lblsuwon);
		jlb.add(lblsuwon);
		lblosung = new JLabel("\uC624\uC1A1");
		lblosung.setHorizontalAlignment(SwingConstants.CENTER);
		lblosung.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lblosung.setBounds(168, 262, 57, 15);
		JpanelMap.add(lblosung);
		jlb.add(lblosung);
		lblkimchun = new JLabel("\uAE40\uCC9C");
		lblkimchun.setHorizontalAlignment(SwingConstants.CENTER);
		lblkimchun.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lblkimchun.setBounds(270, 318, 57, 15);
		JpanelMap.add(lblkimchun);
		jlb.add(lblkimchun);
		lblmilyang = new JLabel("\uBC00\uC591");
		lblmilyang.setHorizontalAlignment(SwingConstants.CENTER);
		lblmilyang.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lblmilyang.setBounds(318, 369, 57, 15);
		JpanelMap.add(lblmilyang);
		jlb.add(lblmilyang);
		lblbusan = new JLabel("\uBD80\uC0B0");
		lblbusan.setHorizontalAlignment(SwingConstants.CENTER);
		lblbusan.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		lblbusan.setBounds(355, 427, 57, 15);
		JpanelMap.add(lblbusan);
		jlb.add(lblbusan);
	 pnCardBG = new ImagePanel(null);
		pnCardBG.setBackground(Color.WHITE);
		pnCardBG.setBounds(462, 10, 695, 525);
		pnA.add(pnCardBG);
		pnCardBG.setLayout(null);
		
		//pnCards = new ImagePanel(r.getImage());
		pnCards = new JPanel();
		pnCards.setBounds(12, 12, 671, 366);
		pnCardBG.add(pnCards);
		 pnCards.setLayout(new BorderLayout(0, 0));
		 
		  lblSeoul = new JLabel("-Let's Mirail");
		  lblSeoul.setFont(new Font("Arial Black", Font.BOLD, 16));
		  pnCards.add(lblSeoul, BorderLayout.CENTER);
		  lblSeoul.setBackground(SystemColor.text);
		  lblSeoul.setHorizontalAlignment(SwingConstants.CENTER);
		  
		  JPanel panel_1 = new JPanel();
		  panel_1.setBackground(Color.BLACK);
		  panel_1.setBounds(39, 442, 609, 1);
		  pnCardBG.add(panel_1);
		  
		  JPanel panel_2 = new JPanel();
		  panel_2.setBackground(Color.BLACK);
		  panel_2.setBounds(39, 478, 609, 1);
		  pnCardBG.add(panel_2);
		  
		  JPanel panel_3 = new JPanel();
		  panel_3.setBorder(new LineBorder(Color.BLACK));
		  panel_3.setBounds(39, 405, 132, 74);
		  pnCardBG.add(panel_3);
		  panel_3.setLayout(null);
		  
		  JLabel lblNewLabel_1 = new JLabel("\uC704\uCE58");
		  lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		  lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabel_1.setBounds(32, 12, 62, 18);
		  panel_3.add(lblNewLabel_1);
		  
		  JLabel lblNewLabel_2 = new JLabel("\uC5F0\uB77D\uCC98");
		  lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		  lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		  lblNewLabel_2.setBounds(32, 44, 62, 18);
		  panel_3.add(lblNewLabel_2);
		  
		   txtLocation = new JLabel("");
		  txtLocation.setHorizontalAlignment(SwingConstants.CENTER);
		  txtLocation.setBounds(198, 412, 419, 18);
		  pnCardBG.add(txtLocation);
		   txtCP = new JLabel("");
		  txtCP.setHorizontalAlignment(SwingConstants.CENTER);
		  txtCP.setBounds(198, 455, 419, 18);
		  pnCardBG.add(txtCP);
		  panel_4 = new JPanel();
		  tabbedPane.addTab("\uC2DC\uAC04\uBCC4 \uC774\uC6A9\uAC1D \uD604\uD669", null, panel_4, null);
		  panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		  for (int i = 0; i < jlb.size(); i++) {
			jlb.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					JLabel jb=(JLabel)arg0.getSource();
					if(jb == lblseoul) {
					ImageIcon ic = new ImageIcon("./imgs/station_¼­¿ï¿ª.jpg");
					stationPopStat("¼­¿ï");
					txtLocation.setText("¼­¿ï ¿ë»ê±¸ µ¿ÀÚµ¿ 43-205");
					txtCP.setText("02-752-4251");
					lblSeoul.setIcon(ic);
					}else if(jb ==lblsuwon){
						ImageIcon ic = new ImageIcon("./imgs/station_¼ö¿ø¿ª.jpg");
						txtLocation.setText("°æ±âµµ ¼ö¿ø½Ã ÆÈ´Þ±¸ ´ö¿µ´ë·Î 924 ¼ö¿ø¿ª");
						stationPopStat("¼ö¿ø");
						txtCP.setText("031-253-2724");
						lblSeoul.setIcon(ic);
					}else if (jb == lblosung) {
						ImageIcon ic = new ImageIcon("./imgs/Staion_¿À¼Û¿ª.jpg");
						txtLocation.setText("ÃæºÏ Ã»ÁÖ½Ã Èï´ö±¸ ¿À¼ÛÀ¾ ¿À¼Û°¡¶ô·Î 123");
						stationPopStat("¿À¼Û");
						txtCP.setText("043-231-4542");
						lblSeoul.setIcon(ic);
					}else if (jb == lblkimchun) {
						ImageIcon ic = new ImageIcon("./imgs/station_±èÃµ¿ª.jpg");
						txtLocation.setText("°æºÏ ±èÃµ½Ã ³²¸é Çõ½Å1·Î 51 ±èÃµ(±¸¹Ì)¿ª");
						stationPopStat("±èÃµ");
						txtCP.setText("054-437-2752");
						lblSeoul.setIcon(ic);
					}else if(jb == lblmilyang) {
						ImageIcon ic = new ImageIcon("./imgs/station_¹Ð¾ç¿ª.jpg");
						txtLocation.setText("°æ³² ¹Ð¾ç½Ã Áß¾Ó·Î 62");
						stationPopStat("¹Ð¾ç");
						txtCP.setText("055-352-7778");
						lblSeoul.setIcon(ic);
					}else if (jb == lblbusan) {
						ImageIcon ic = new ImageIcon("./imgs/station_ºÎ»ê¿ª.jpg");
						txtLocation.setText("ºÎ»ê µ¿±¸ Áß¾Ó´ë·Î 206 (ÃÊ·®3µ¿ 1187-1¹øÁö)ºÎ»ê¿ª");
						stationPopStat("ºÎ»ê");
						txtCP.setText("051-440-2288");
						lblSeoul.setIcon(ic);
					}
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					JLabel jb = (JLabel)arg0.getSource();
					jb.setBackground(Color.CYAN);
					jb.setOpaque(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					JLabel jb = (JLabel)e.getSource();
					jb.setBackground(Color.white);
					jb.setOpaque(false);
				}
			});
		  }

		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 1184, 68);
		contentPane.add(panel);
		
		lblM = new JLabel("- LET'S MIRAIL TRAIN");
		lblM.setFont(new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 15));
		lblM.setBounds(27, 20, 211, 36);
		panel.add(lblM);
	  
		
	
	}
}
