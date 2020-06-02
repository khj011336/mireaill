package barcode;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.GridBagLayout;

public class BarcodePanel extends JPanel {

	private ArrayList<JPanel> pnList;
	private JLabel lblLeft_1;
	private JLabel lblLeft_2;
	private JLabel lblLeft_3;
	private JLabel lblLeft_4;
	private JLabel lblLeft_5;
	private JLabel lblLeft_6;
	private JLabel lblRight_1;
	private JLabel lblRight_2;
	private JLabel lblRight_3;
	private JLabel lblRight_4;
	private JLabel lblRight_5;
	private JLabel lblRight_6;
	
	/**
	 * Create the panel.
	 */
	
	public void barcodeLeftPattern(String num, JPanel pn1, JPanel pn2, JPanel pn3, JPanel pn4, JPanel pn5, JPanel pn6, JPanel pn7) {
		switch (num) {
		case "0":
			pn4.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "1":
			pn3.setBackground(Color.BLACK);
			pn4.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "2":
			pn3.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "3":
			pn2.setBackground(Color.BLACK);
			pn3.setBackground(Color.BLACK);
			pn4.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "4":
			pn2.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "5":
			pn2.setBackground(Color.BLACK);
			pn3.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "6":
			pn2.setBackground(Color.BLACK);
			pn4.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "7":
			pn2.setBackground(Color.BLACK);
			pn3.setBackground(Color.BLACK);
			pn4.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "8":
			pn2.setBackground(Color.BLACK);
			pn3.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;
		case "9":
			pn4.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			pn7.setBackground(Color.BLACK);
			break;

		default:
			break;
		}
	}
	
	public void barcodeRightPattern(String num, JPanel pn1, JPanel pn2, JPanel pn3, JPanel pn4, JPanel pn5, JPanel pn6, JPanel pn7) {
		switch (num) {
		case "0":
			pn1.setBackground(Color.BLACK);
			pn2.setBackground(Color.BLACK);
			pn3.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			break;
		case "1":
			pn1.setBackground(Color.BLACK);
			pn2.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			break;
		case "2":
			pn1.setBackground(Color.BLACK);
			pn2.setBackground(Color.BLACK);
			pn4.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			break;
		case "3":
			pn1.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			break;
		case "4":
			pn1.setBackground(Color.BLACK);
			pn3.setBackground(Color.BLACK);
			pn4.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			break;
		case "5":
			pn1.setBackground(Color.BLACK);
			pn4.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			pn6.setBackground(Color.BLACK);
			break;
		case "6":
			pn1.setBackground(Color.BLACK);
			pn3.setBackground(Color.BLACK);
			break;
		case "7":
			pn1.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			break;
		case "8":
			pn1.setBackground(Color.BLACK);
			pn4.setBackground(Color.BLACK);
			break;
		case "9":
			pn1.setBackground(Color.BLACK);
			pn2.setBackground(Color.BLACK);
			pn3.setBackground(Color.BLACK);
			pn5.setBackground(Color.BLACK);
			break;
		default:
			break;
		}
	}
	
	public BarcodePanel() {
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String s = sdf.format(today);
		
		setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pnTop = new JPanel();
		add(pnTop);
		pnTop.setLayout(new GridLayout(0, 15, 0, 0));
		
		JPanel pnFirst1 = new JPanel();
		pnTop.add(pnFirst1);
		pnFirst1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnF1_1 = new JPanel();
		pnFirst1.add(pnF1_1);
		
		JPanel pnF1_2 = new JPanel();
		pnFirst1.add(pnF1_2);
		
		JPanel pnF1_3 = new JPanel();
		pnFirst1.add(pnF1_3);
		
		JPanel pnF1_4 = new JPanel();
		pnFirst1.add(pnF1_4);
		
		JPanel pnF1_5 = new JPanel();
		pnF1_5.setBackground(Color.BLACK);
		pnFirst1.add(pnF1_5);
		
		JPanel pnF1_6 = new JPanel();
		pnFirst1.add(pnF1_6);
		
		JPanel pnF1_7 = new JPanel();
		pnF1_7.setBackground(Color.BLACK);
		pnFirst1.add(pnF1_7);
		
		JPanel pnL1_1 = new JPanel();
		pnTop.add(pnL1_1);
		pnL1_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pn1 = new JPanel();
		pnL1_1.add(pn1);
		
		JPanel pn2 = new JPanel();
		pnL1_1.add(pn2);
		
		JPanel pn3 = new JPanel();
		pnL1_1.add(pn3);
		
		JPanel pn4 = new JPanel();
		pnL1_1.add(pn4);
		
		JPanel pn5 = new JPanel();
		pnL1_1.add(pn5);
		
		JPanel pn6 = new JPanel();
		pnL1_1.add(pn6);
		
		JPanel pn7 = new JPanel();
		pnL1_1.add(pn7);
		
		JPanel pnL1_2 = new JPanel();
		pnTop.add(pnL1_2);
		pnL1_2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel = new JPanel();
		pnL1_2.add(panel);
		
		JPanel panel_1 = new JPanel();
		pnL1_2.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		pnL1_2.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		pnL1_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		pnL1_2.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		pnL1_2.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		pnL1_2.add(panel_6);
		
		JPanel pnL1_3 = new JPanel();
		pnTop.add(pnL1_3);
		pnL1_3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_7 = new JPanel();
		pnL1_3.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		pnL1_3.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		pnL1_3.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		pnL1_3.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		pnL1_3.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		pnL1_3.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		pnL1_3.add(panel_13);
		
		JPanel pnL1_4 = new JPanel();
		pnTop.add(pnL1_4);
		pnL1_4.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_14 = new JPanel();
		pnL1_4.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		pnL1_4.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		pnL1_4.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		pnL1_4.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		pnL1_4.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		pnL1_4.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		pnL1_4.add(panel_20);
		
		JPanel pnL1_5 = new JPanel();
		pnTop.add(pnL1_5);
		pnL1_5.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_21 = new JPanel();
		pnL1_5.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		pnL1_5.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		pnL1_5.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		pnL1_5.add(panel_24);
		
		JPanel panel_25 = new JPanel();
		pnL1_5.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		pnL1_5.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		pnL1_5.add(panel_27);
		
		JPanel pnL1_6 = new JPanel();
		pnTop.add(pnL1_6);
		pnL1_6.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_28 = new JPanel();
		pnL1_6.add(panel_28);
		
		JPanel panel_29 = new JPanel();
		pnL1_6.add(panel_29);
		
		JPanel panel_30 = new JPanel();
		pnL1_6.add(panel_30);
		
		JPanel panel_31 = new JPanel();
		pnL1_6.add(panel_31);
		
		JPanel panel_32 = new JPanel();
		pnL1_6.add(panel_32);
		
		JPanel panel_33 = new JPanel();
		pnL1_6.add(panel_33);
		
		JPanel panel_34 = new JPanel();
		pnL1_6.add(panel_34);
		
		JPanel pnMid1 = new JPanel();
		pnTop.add(pnMid1);
		pnMid1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnM1_1 = new JPanel();
		pnMid1.add(pnM1_1);
		
		JPanel pnM1_2 = new JPanel();
		pnMid1.add(pnM1_2);
		
		JPanel pnM1_3 = new JPanel();
		pnM1_3.setBackground(Color.BLACK);
		pnMid1.add(pnM1_3);
		
		JPanel pnM1_4 = new JPanel();
		pnMid1.add(pnM1_4);
		
		JPanel pnM1_5 = new JPanel();
		pnM1_5.setBackground(Color.BLACK);
		pnMid1.add(pnM1_5);
		
		JPanel pnM1_6 = new JPanel();
		pnMid1.add(pnM1_6);
		
		JPanel pnM1_7 = new JPanel();
		pnMid1.add(pnM1_7);
		
		JPanel pnR1_1 = new JPanel();
		pnTop.add(pnR1_1);
		pnR1_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_35 = new JPanel();
		pnR1_1.add(panel_35);
		
		JPanel panel_36 = new JPanel();
		pnR1_1.add(panel_36);
		
		JPanel panel_37 = new JPanel();
		pnR1_1.add(panel_37);
		
		JPanel panel_38 = new JPanel();
		pnR1_1.add(panel_38);
		
		JPanel panel_39 = new JPanel();
		pnR1_1.add(panel_39);
		
		JPanel panel_40 = new JPanel();
		pnR1_1.add(panel_40);
		
		JPanel panel_41 = new JPanel();
		pnR1_1.add(panel_41);
		
		JPanel pnR1_2 = new JPanel();
		pnTop.add(pnR1_2);
		pnR1_2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_42 = new JPanel();
		pnR1_2.add(panel_42);
		
		JPanel panel_43 = new JPanel();
		pnR1_2.add(panel_43);
		
		JPanel panel_44 = new JPanel();
		pnR1_2.add(panel_44);
		
		JPanel panel_45 = new JPanel();
		pnR1_2.add(panel_45);
		
		JPanel panel_46 = new JPanel();
		pnR1_2.add(panel_46);
		
		JPanel panel_47 = new JPanel();
		pnR1_2.add(panel_47);
		
		JPanel panel_48 = new JPanel();
		pnR1_2.add(panel_48);
		
		JPanel pnR1_3 = new JPanel();
		pnTop.add(pnR1_3);
		pnR1_3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_49 = new JPanel();
		pnR1_3.add(panel_49);
		
		JPanel panel_50 = new JPanel();
		pnR1_3.add(panel_50);
		
		JPanel panel_51 = new JPanel();
		pnR1_3.add(panel_51);
		
		JPanel panel_52 = new JPanel();
		pnR1_3.add(panel_52);
		
		JPanel panel_53 = new JPanel();
		pnR1_3.add(panel_53);
		
		JPanel panel_54 = new JPanel();
		pnR1_3.add(panel_54);
		
		JPanel panel_55 = new JPanel();
		pnR1_3.add(panel_55);
		
		JPanel pnR1_4 = new JPanel();
		pnTop.add(pnR1_4);
		pnR1_4.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_56 = new JPanel();
		pnR1_4.add(panel_56);
		
		JPanel panel_57 = new JPanel();
		pnR1_4.add(panel_57);
		
		JPanel panel_58 = new JPanel();
		pnR1_4.add(panel_58);
		
		JPanel panel_59 = new JPanel();
		pnR1_4.add(panel_59);
		
		JPanel panel_60 = new JPanel();
		pnR1_4.add(panel_60);
		
		JPanel panel_61 = new JPanel();
		pnR1_4.add(panel_61);
		
		JPanel panel_62 = new JPanel();
		pnR1_4.add(panel_62);
		
		JPanel pnR1_5 = new JPanel();
		pnTop.add(pnR1_5);
		pnR1_5.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_63 = new JPanel();
		pnR1_5.add(panel_63);
		
		JPanel panel_64 = new JPanel();
		pnR1_5.add(panel_64);
		
		JPanel panel_65 = new JPanel();
		pnR1_5.add(panel_65);
		
		JPanel panel_66 = new JPanel();
		pnR1_5.add(panel_66);
		
		JPanel panel_67 = new JPanel();
		pnR1_5.add(panel_67);
		
		JPanel panel_68 = new JPanel();
		pnR1_5.add(panel_68);
		
		JPanel panel_69 = new JPanel();
		pnR1_5.add(panel_69);
		
		JPanel pnR1_6 = new JPanel();
		pnTop.add(pnR1_6);
		pnR1_6.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_70 = new JPanel();
		pnR1_6.add(panel_70);
		
		JPanel panel_71 = new JPanel();
		pnR1_6.add(panel_71);
		
		JPanel panel_72 = new JPanel();
		pnR1_6.add(panel_72);
		
		JPanel panel_73 = new JPanel();
		pnR1_6.add(panel_73);
		
		JPanel panel_74 = new JPanel();
		pnR1_6.add(panel_74);
		
		JPanel panel_75 = new JPanel();
		pnR1_6.add(panel_75);
		
		JPanel panel_76 = new JPanel();
		pnR1_6.add(panel_76);
		
		JPanel pnLast1 = new JPanel();
		pnTop.add(pnLast1);
		pnLast1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnLast1_1 = new JPanel();
		pnLast1_1.setBackground(Color.BLACK);
		pnLast1.add(pnLast1_1);
		
		JPanel pnLast1_2 = new JPanel();
		pnLast1.add(pnLast1_2);
		
		JPanel pnLast1_3 = new JPanel();
		pnLast1_3.setBackground(Color.BLACK);
		pnLast1.add(pnLast1_3);
		
		JPanel pnLast1_4 = new JPanel();
		pnLast1.add(pnLast1_4);
		
		JPanel pnLast1_5 = new JPanel();
		pnLast1.add(pnLast1_5);
		
		JPanel pnLast1_6 = new JPanel();
		pnLast1.add(pnLast1_6);
		
		JPanel pnLast1_7 = new JPanel();
		pnLast1.add(pnLast1_7);
		
		JPanel pnBottom = new JPanel();
		add(pnBottom);
		pnBottom.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel pnBottom1 = new JPanel();
		pnBottom.add(pnBottom1);
		pnBottom1.setLayout(new GridLayout(0, 15, 0, 0));
		
		JPanel pnFirst2 = new JPanel();
		pnBottom1.add(pnFirst2);
		pnFirst2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnF2_1 = new JPanel();
		pnFirst2.add(pnF2_1);
		
		JPanel pnF2_2 = new JPanel();
		pnFirst2.add(pnF2_2);
		
		JPanel pnF2_3 = new JPanel();
		pnFirst2.add(pnF2_3);
		
		JPanel pnF2_4 = new JPanel();
		pnFirst2.add(pnF2_4);
		
		JPanel pnF2_5 = new JPanel();
		pnF2_5.setBackground(Color.BLACK);
		pnFirst2.add(pnF2_5);
		
		JPanel pnF2_6 = new JPanel();
		pnFirst2.add(pnF2_6);
		
		JPanel pnF2_7 = new JPanel();
		pnF2_7.setBackground(Color.BLACK);
		pnFirst2.add(pnF2_7);
		
		JPanel pnL2_1 = new JPanel();
		pnBottom1.add(pnL2_1);
		pnL2_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_77 = new JPanel();
		pnL2_1.add(panel_77);
		
		JPanel panel_78 = new JPanel();
		pnL2_1.add(panel_78);
		
		JPanel panel_79 = new JPanel();
		pnL2_1.add(panel_79);
		
		JPanel panel_80 = new JPanel();
		pnL2_1.add(panel_80);
		
		JPanel panel_81 = new JPanel();
		pnL2_1.add(panel_81);
		
		JPanel panel_82 = new JPanel();
		pnL2_1.add(panel_82);
		
		JPanel panel_83 = new JPanel();
		pnL2_1.add(panel_83);
		
		JPanel pnL2_2 = new JPanel();
		pnBottom1.add(pnL2_2);
		pnL2_2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_84 = new JPanel();
		pnL2_2.add(panel_84);
		
		JPanel panel_85 = new JPanel();
		pnL2_2.add(panel_85);
		
		JPanel panel_86 = new JPanel();
		pnL2_2.add(panel_86);
		
		JPanel panel_87 = new JPanel();
		pnL2_2.add(panel_87);
		
		JPanel panel_88 = new JPanel();
		pnL2_2.add(panel_88);
		
		JPanel panel_89 = new JPanel();
		pnL2_2.add(panel_89);
		
		JPanel panel_90 = new JPanel();
		pnL2_2.add(panel_90);
		
		JPanel pnL2_3 = new JPanel();
		pnBottom1.add(pnL2_3);
		pnL2_3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_91 = new JPanel();
		pnL2_3.add(panel_91);
		
		JPanel panel_92 = new JPanel();
		pnL2_3.add(panel_92);
		
		JPanel panel_93 = new JPanel();
		pnL2_3.add(panel_93);
		
		JPanel panel_94 = new JPanel();
		pnL2_3.add(panel_94);
		
		JPanel panel_95 = new JPanel();
		pnL2_3.add(panel_95);
		
		JPanel panel_96 = new JPanel();
		pnL2_3.add(panel_96);
		
		JPanel panel_97 = new JPanel();
		pnL2_3.add(panel_97);
		
		JPanel pnL2_4 = new JPanel();
		pnBottom1.add(pnL2_4);
		pnL2_4.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_98 = new JPanel();
		pnL2_4.add(panel_98);
		
		JPanel panel_99 = new JPanel();
		pnL2_4.add(panel_99);
		
		JPanel panel_100 = new JPanel();
		pnL2_4.add(panel_100);
		
		JPanel panel_101 = new JPanel();
		pnL2_4.add(panel_101);
		
		JPanel panel_102 = new JPanel();
		pnL2_4.add(panel_102);
		
		JPanel panel_103 = new JPanel();
		pnL2_4.add(panel_103);
		
		JPanel panel_104 = new JPanel();
		pnL2_4.add(panel_104);
		
		JPanel pnL2_5 = new JPanel();
		pnBottom1.add(pnL2_5);
		pnL2_5.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_105 = new JPanel();
		pnL2_5.add(panel_105);
		
		JPanel panel_106 = new JPanel();
		pnL2_5.add(panel_106);
		
		JPanel panel_107 = new JPanel();
		pnL2_5.add(panel_107);
		
		JPanel panel_108 = new JPanel();
		pnL2_5.add(panel_108);
		
		JPanel panel_109 = new JPanel();
		pnL2_5.add(panel_109);
		
		JPanel panel_110 = new JPanel();
		pnL2_5.add(panel_110);
		
		JPanel panel_111 = new JPanel();
		pnL2_5.add(panel_111);
		
		JPanel pnL2_6 = new JPanel();
		pnBottom1.add(pnL2_6);
		pnL2_6.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_112 = new JPanel();
		pnL2_6.add(panel_112);
		
		JPanel panel_113 = new JPanel();
		pnL2_6.add(panel_113);
		
		JPanel panel_114 = new JPanel();
		pnL2_6.add(panel_114);
		
		JPanel panel_115 = new JPanel();
		pnL2_6.add(panel_115);
		
		JPanel panel_116 = new JPanel();
		pnL2_6.add(panel_116);
		
		JPanel panel_117 = new JPanel();
		pnL2_6.add(panel_117);
		
		JPanel panel_118 = new JPanel();
		pnL2_6.add(panel_118);
		
		JPanel pnMid2 = new JPanel();
		pnBottom1.add(pnMid2);
		pnMid2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnM2_1 = new JPanel();
		pnMid2.add(pnM2_1);
		
		JPanel pnM2_2 = new JPanel();
		pnMid2.add(pnM2_2);
		
		JPanel pnM2_3 = new JPanel();
		pnM2_3.setBackground(Color.BLACK);
		pnMid2.add(pnM2_3);
		
		JPanel pnM2_4 = new JPanel();
		pnMid2.add(pnM2_4);
		
		JPanel pnM2_5 = new JPanel();
		pnM2_5.setBackground(Color.BLACK);
		pnMid2.add(pnM2_5);
		
		JPanel pnM2_6 = new JPanel();
		pnMid2.add(pnM2_6);
		
		JPanel pnM2_7 = new JPanel();
		pnMid2.add(pnM2_7);
		
		JPanel pnR2_1 = new JPanel();
		pnBottom1.add(pnR2_1);
		pnR2_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_119 = new JPanel();
		pnR2_1.add(panel_119);
		
		JPanel panel_120 = new JPanel();
		pnR2_1.add(panel_120);
		
		JPanel panel_121 = new JPanel();
		pnR2_1.add(panel_121);
		
		JPanel panel_122 = new JPanel();
		pnR2_1.add(panel_122);
		
		JPanel panel_123 = new JPanel();
		pnR2_1.add(panel_123);
		
		JPanel panel_124 = new JPanel();
		pnR2_1.add(panel_124);
		
		JPanel panel_125 = new JPanel();
		pnR2_1.add(panel_125);
		
		JPanel pnR2_2 = new JPanel();
		pnBottom1.add(pnR2_2);
		pnR2_2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_126 = new JPanel();
		pnR2_2.add(panel_126);
		
		JPanel panel_127 = new JPanel();
		pnR2_2.add(panel_127);
		
		JPanel panel_128 = new JPanel();
		pnR2_2.add(panel_128);
		
		JPanel panel_129 = new JPanel();
		pnR2_2.add(panel_129);
		
		JPanel panel_130 = new JPanel();
		pnR2_2.add(panel_130);
		
		JPanel panel_131 = new JPanel();
		pnR2_2.add(panel_131);
		
		JPanel panel_132 = new JPanel();
		pnR2_2.add(panel_132);
		
		JPanel pnR2_3 = new JPanel();
		pnBottom1.add(pnR2_3);
		pnR2_3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_133 = new JPanel();
		pnR2_3.add(panel_133);
		
		JPanel panel_134 = new JPanel();
		pnR2_3.add(panel_134);
		
		JPanel panel_135 = new JPanel();
		pnR2_3.add(panel_135);
		
		JPanel panel_136 = new JPanel();
		pnR2_3.add(panel_136);
		
		JPanel panel_137 = new JPanel();
		pnR2_3.add(panel_137);
		
		JPanel panel_138 = new JPanel();
		pnR2_3.add(panel_138);
		
		JPanel panel_139 = new JPanel();
		pnR2_3.add(panel_139);
		
		JPanel pnR2_4 = new JPanel();
		pnBottom1.add(pnR2_4);
		pnR2_4.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_140 = new JPanel();
		pnR2_4.add(panel_140);
		
		JPanel panel_141 = new JPanel();
		pnR2_4.add(panel_141);
		
		JPanel panel_142 = new JPanel();
		pnR2_4.add(panel_142);
		
		JPanel panel_143 = new JPanel();
		pnR2_4.add(panel_143);
		
		JPanel panel_144 = new JPanel();
		pnR2_4.add(panel_144);
		
		JPanel panel_145 = new JPanel();
		pnR2_4.add(panel_145);
		
		JPanel panel_146 = new JPanel();
		pnR2_4.add(panel_146);
		
		JPanel pnR2_5 = new JPanel();
		pnBottom1.add(pnR2_5);
		pnR2_5.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_147 = new JPanel();
		pnR2_5.add(panel_147);
		
		JPanel panel_148 = new JPanel();
		pnR2_5.add(panel_148);
		
		JPanel panel_149 = new JPanel();
		pnR2_5.add(panel_149);
		
		JPanel panel_150 = new JPanel();
		pnR2_5.add(panel_150);
		
		JPanel panel_151 = new JPanel();
		pnR2_5.add(panel_151);
		
		JPanel panel_152 = new JPanel();
		pnR2_5.add(panel_152);
		
		JPanel panel_153 = new JPanel();
		pnR2_5.add(panel_153);
		
		JPanel pnR2_6 = new JPanel();
		pnBottom1.add(pnR2_6);
		pnR2_6.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_154 = new JPanel();
		pnR2_6.add(panel_154);
		
		JPanel panel_155 = new JPanel();
		pnR2_6.add(panel_155);
		
		JPanel panel_156 = new JPanel();
		pnR2_6.add(panel_156);
		
		JPanel panel_157 = new JPanel();
		pnR2_6.add(panel_157);
		
		JPanel panel_158 = new JPanel();
		pnR2_6.add(panel_158);
		
		JPanel panel_159 = new JPanel();
		pnR2_6.add(panel_159);
		
		JPanel panel_160 = new JPanel();
		pnR2_6.add(panel_160);
		
		JPanel pnLast2 = new JPanel();
		pnBottom1.add(pnLast2);
		pnLast2.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnLast2_1 = new JPanel();
		pnLast2_1.setBackground(Color.BLACK);
		pnLast2.add(pnLast2_1);
		
		JPanel pnLast2_2 = new JPanel();
		pnLast2.add(pnLast2_2);
		
		JPanel pnLast2_3 = new JPanel();
		pnLast2_3.setBackground(Color.BLACK);
		pnLast2.add(pnLast2_3);
		
		JPanel pnLast2_4 = new JPanel();
		pnLast2.add(pnLast2_4);
		
		JPanel pnLast2_5 = new JPanel();
		pnLast2.add(pnLast2_5);
		
		JPanel pnLast2_6 = new JPanel();
		pnLast2.add(pnLast2_6);
		
		JPanel pnLast2_7 = new JPanel();
		pnLast2.add(pnLast2_7);
		
		JPanel pnBottom2 = new JPanel();
		pnBottom.add(pnBottom2);
		pnBottom2.setLayout(new GridLayout(0, 15, 0, 0));
		
		JPanel pnFirst3 = new JPanel();
		pnBottom2.add(pnFirst3);
		pnFirst3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnF3_1 = new JPanel();
		pnFirst3.add(pnF3_1);
		
		JPanel pnF3_2 = new JPanel();
		pnFirst3.add(pnF3_2);
		
		JPanel pnF3_3 = new JPanel();
		pnFirst3.add(pnF3_3);
		
		JPanel pnF3_4 = new JPanel();
		pnFirst3.add(pnF3_4);
		
		JPanel pnF3_5 = new JPanel();
		pnF3_5.setBackground(Color.BLACK);
		pnFirst3.add(pnF3_5);
		
		JPanel pnF3_6 = new JPanel();
		pnFirst3.add(pnF3_6);
		
		JPanel pnF3_7 = new JPanel();
		pnF3_7.setBackground(Color.BLACK);
		pnFirst3.add(pnF3_7);
		
		lblLeft_1 = new JLabel();
		lblLeft_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeft_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblLeft_1.setText(""+s.charAt(0));
		pnBottom2.add(lblLeft_1);
		
		lblLeft_2 = new JLabel();
		lblLeft_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeft_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblLeft_2.setText(""+s.charAt(1));
		pnBottom2.add(lblLeft_2);
		
		lblLeft_3 = new JLabel();
		lblLeft_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeft_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblLeft_3.setText(""+s.charAt(2));
		pnBottom2.add(lblLeft_3);
		
		lblLeft_4 = new JLabel();
		lblLeft_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeft_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblLeft_4.setText(""+s.charAt(3));
		pnBottom2.add(lblLeft_4);
		
		lblLeft_5 = new JLabel();
		lblLeft_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeft_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblLeft_5.setText(""+s.charAt(4));
		pnBottom2.add(lblLeft_5);
		
		lblLeft_6 = new JLabel();
		lblLeft_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeft_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblLeft_6.setText(""+s.charAt(5));
		pnBottom2.add(lblLeft_6);
		
		JPanel pnMid3 = new JPanel();
		pnBottom2.add(pnMid3);
		pnMid3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnM3_1 = new JPanel();
		pnMid3.add(pnM3_1);
		
		JPanel pnM3_2 = new JPanel();
		pnMid3.add(pnM3_2);
		
		JPanel pnM3_3 = new JPanel();
		pnM3_3.setBackground(Color.BLACK);
		pnMid3.add(pnM3_3);
		
		JPanel pnM3_4 = new JPanel();
		pnMid3.add(pnM3_4);
		
		JPanel pnM3_5 = new JPanel();
		pnM3_5.setBackground(Color.BLACK);
		pnMid3.add(pnM3_5);
		
		JPanel pnM3_6 = new JPanel();
		pnMid3.add(pnM3_6);
		
		JPanel pnM3_7 = new JPanel();
		pnMid3.add(pnM3_7);
		
		lblRight_1 = new JLabel();
		lblRight_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRight_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblRight_1.setText(""+s.charAt(6));
		pnBottom2.add(lblRight_1);
		
		lblRight_2 = new JLabel();
		lblRight_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRight_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblRight_2.setText(""+s.charAt(7));
		pnBottom2.add(lblRight_2);
		
		lblRight_3 = new JLabel();
		lblRight_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRight_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblRight_3.setText(""+s.charAt(8));
		pnBottom2.add(lblRight_3);
		
		lblRight_4 = new JLabel();
		lblRight_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblRight_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblRight_4.setText(""+s.charAt(9));
		pnBottom2.add(lblRight_4);
		
		lblRight_5 = new JLabel();
		lblRight_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblRight_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblRight_5.setText(""+s.charAt(10));
		pnBottom2.add(lblRight_5);
		
		lblRight_6 = new JLabel();
		lblRight_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblRight_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblRight_6.setText(""+s.charAt(11));
		pnBottom2.add(lblRight_6);		
		
		JPanel pnLast3 = new JPanel();
		pnBottom2.add(pnLast3);
		pnLast3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel pnLast3_1 = new JPanel();
		pnLast3_1.setBackground(Color.BLACK);
		pnLast3.add(pnLast3_1);
		
		JPanel pnLast3_2 = new JPanel();
		pnLast3.add(pnLast3_2);
		
		JPanel pnLast3_3 = new JPanel();
		pnLast3_3.setBackground(Color.BLACK);
		pnLast3.add(pnLast3_3);
		
		JPanel pnLast3_4 = new JPanel();
		pnLast3.add(pnLast3_4);
		
		JPanel pnLast3_5 = new JPanel();
		pnLast3.add(pnLast3_5);
		
		JPanel pnLast3_6 = new JPanel();
		pnLast3.add(pnLast3_6);
		
		JPanel pnLast3_7 = new JPanel();
		pnLast3.add(pnLast3_7);
		
		barcodeLeftPattern(""+s.charAt(0), pn1, pn2, pn3, pn4, pn5, pn6, pn7);
		barcodeLeftPattern(""+s.charAt(1), panel, panel_1, panel_2, panel_3, panel_4, panel_5, panel_6);
		barcodeLeftPattern(""+s.charAt(2), panel_7, panel_8, panel_9, panel_10, panel_11, panel_12, panel_13);
		barcodeLeftPattern(""+s.charAt(3), panel_14, panel_15, panel_16, panel_17, panel_18, panel_19, panel_20);
		barcodeLeftPattern(""+s.charAt(4), panel_21, panel_22, panel_23, panel_24, panel_25, panel_26, panel_27);
		barcodeLeftPattern(""+s.charAt(5), panel_28, panel_29, panel_30, panel_31, panel_32, panel_33, panel_34);
		barcodeRightPattern(""+s.charAt(6), panel_35, panel_36, panel_37, panel_38, panel_39, panel_40, panel_41);
		barcodeRightPattern(""+s.charAt(7), panel_42, panel_43, panel_44, panel_45, panel_46, panel_47, panel_48);
		barcodeRightPattern(""+s.charAt(8), panel_49, panel_50, panel_51, panel_52, panel_53, panel_54, panel_55);
		barcodeRightPattern(""+s.charAt(9), panel_56, panel_57, panel_58, panel_59, panel_60, panel_61, panel_62);
		barcodeRightPattern(""+s.charAt(10), panel_63, panel_64, panel_65, panel_66, panel_67, panel_68, panel_69);
		barcodeRightPattern(""+s.charAt(11), panel_70, panel_71, panel_72, panel_73, panel_74, panel_75, panel_76);
		barcodeLeftPattern(""+s.charAt(0), panel_77, panel_78, panel_79, panel_80, panel_81, panel_82, panel_83);
		barcodeLeftPattern(""+s.charAt(1), panel_84, panel_85, panel_86, panel_87, panel_88, panel_89, panel_90);
		barcodeLeftPattern(""+s.charAt(2), panel_91, panel_92, panel_93, panel_94, panel_95, panel_96, panel_97);
		barcodeLeftPattern(""+s.charAt(3), panel_98, panel_99, panel_100, panel_101, panel_102, panel_103, panel_104);
		barcodeLeftPattern(""+s.charAt(4), panel_105, panel_106, panel_107, panel_108, panel_109, panel_110, panel_111);
		barcodeLeftPattern(""+s.charAt(5), panel_112, panel_113, panel_114, panel_115, panel_116, panel_117, panel_118);
		barcodeRightPattern(""+s.charAt(6), panel_119, panel_120, panel_121, panel_122, panel_123, panel_124, panel_125);
		barcodeRightPattern(""+s.charAt(7), panel_126, panel_127, panel_128, panel_129, panel_130, panel_131, panel_132);
		barcodeRightPattern(""+s.charAt(8), panel_133, panel_134, panel_135, panel_136, panel_137, panel_138, panel_139);
		barcodeRightPattern(""+s.charAt(9), panel_140, panel_141, panel_142, panel_143, panel_144, panel_145, panel_146);
		barcodeRightPattern(""+s.charAt(10), panel_147, panel_148, panel_149, panel_150, panel_151, panel_152, panel_153);
		barcodeRightPattern(""+s.charAt(11), panel_154, panel_155, panel_156, panel_157, panel_158, panel_159, panel_160);
	}

}
