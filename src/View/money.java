package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.controller;
import VO.duesVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import javax.swing.JTextArea;

public class money extends JFrame {

	int loginid=0;
	private JPanel contentPane;
	private JPanel Lpanal;
	private JPanel Jpanel;
	private JPanel Mpanel;
	private JPanel Ipanel;
	private JPanel Spanel;
	private JPanel SPpanel;
	private JPanel Dpanel;
	private JPanel Cpanel;
	private JPanel CNpanel;
	
	private JLabel LID;
	private JLabel LPW;
	private JTextField LTID;
	private JPasswordField LTPW;
	private JButton Lbtn;
	private JButton Jbtn;

	private JLabel JoinID;
	private JLabel JoinPW;
	private JLabel JoinNAME;
	private JTextField JTID;
	private JPasswordField JTPW;
	private JTextField JTNAME;
	private JButton Joinyes;
	private JButton Joinno;

	private JTextField ITname;
	private JTextField ITmoney;
	private JTextField ITdate;

	private JLabel Syear;
	private JLabel Smonth;
	private JTextField STyear;
	private JTextField STmonth;
	private JButton Searchbtn;
	private JButton Snobtn;

	private JLabel Cname;
	private JLabel Cmoney;
	private JLabel Cdate;
	private JButton Cchangebtn;
	private JButton Cnobtn;
	
	private JTextField CTname;
	private JTextField CTmoney;
	private JTextField CTdate;
	private JTextField CNTnumber;

	private JLabel Dnumber;
	private JTextField DTnumber;
	private JButton Dbtn;
	private JButton Dnobtn;
	
	private JLabel label;
	private JLabel label_1;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					money frame = new money();
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
	public money() {
		try {
			Socket socket = new Socket("localhost",7856);
			controller con = new controller(socket);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
						Lpanal = new JPanel();
						Lpanal.setBounds(0, 0, 834, 601);
						contentPane.add(Lpanal);
						Lpanal.setLayout(null);
						
						
						LTID = new JTextField();
						LTID.setBounds(295, 287, 211, 39);
						LTID.setColumns(10);
						Lpanal.add(LTID);
						
						LID = new JLabel("ID");
						LID.setFont(new Font("??????", Font.BOLD, 30));
						LID.setBounds(112, 272, 101, 57);
						Lpanal.add(LID);
						
						LPW = new JLabel("PASSWD");
						LPW.setFont(new Font("??????", Font.BOLD, 30));
						LPW.setBounds(112, 363, 171, 69);
						Lpanal.add(LPW);
						
						LTPW = new JPasswordField();
						LTPW.setBounds(295, 384, 211, 39);
						LTPW.setColumns(10);
						Lpanal.add(LTPW);
						
						Lbtn = new JButton("?????????");
						Lbtn.setBounds(589, 278, 144, 102);
						Lbtn.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int[] i=con.login(LTID.getText(),LTPW.getText());
								if(i[0]==1) {
									loginid=i[1];
									JOptionPane.showMessageDialog( money.this, "????????? ??????!");
									Lpanal.setVisible(false);
									Jpanel.setVisible(false);
									Mpanel.setVisible(true);
									Ipanel.setVisible(false);
									Spanel.setVisible(false);
									SPpanel.setVisible(false);
									Dpanel.setVisible(false);
									Cpanel.setVisible(false);
									CNpanel.setVisible(false);
									
								}
								else {
									JOptionPane.showMessageDialog( money.this, "????????? ??????!");
								}
								
							}
						});
						Lpanal.add(Lbtn);
						
						label = new JLabel("???????????????????????????");
						label.setBounds(142, 90, 500, 111);
						label.setFont(new Font("Dialog", Font.BOLD, 50));
						Lpanal.add(label);
						
						Jbtn = new JButton("????????????");
						Jbtn.setBounds(589, 420, 144, 39);
						Jbtn.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Lpanal.setVisible(false);
								Jpanel.setVisible(true);
								Mpanel.setVisible(false);
								Ipanel.setVisible(false);
								Spanel.setVisible(false);
								SPpanel.setVisible(false);
								Dpanel.setVisible(false);
								Cpanel.setVisible(false);
								CNpanel.setVisible(false);
								
							}
						});
						Lpanal.add(Jbtn);
				
						Jpanel = new JPanel();
						Jpanel.setBounds(0, 0, 834, 601);
						contentPane.add(Jpanel);
						
						Jpanel.setLayout(null);
						
						
						JoinID = new JLabel("?????????");
						JoinID.setFont(new Font("??????", Font.BOLD, 30));
						JoinID.setBounds(112, 200, 101, 69);
						Jpanel.add(JoinID);
						
						JoinPW = new JLabel("????????????");
						JoinPW.setFont(new Font("??????", Font.BOLD, 30));
						JoinPW.setBounds(77, 269, 148, 69);
						Jpanel.add(JoinPW);
						
						/*JoinNAME = new JLabel("??????");
						JoinNAME.setFont(new Font("??????", Font.BOLD, 30));
						JoinNAME.setBounds(143, 339, 101, 69);
						Jpanel.add(JoinNAME);*/
						
						JTID = new JTextField();
						JTID.setBounds(295, 220, 211, 39);
						Jpanel.add(JTID);
						JTID.setColumns(10);
						
						JTPW = new JPasswordField();
						JTPW.setBounds(295, 290, 211, 39);
						Jpanel.add(JTPW);
						JTPW.setColumns(10);
						
						/*JTNAME = new JTextField();
						JTNAME.setBounds(295, 360, 211, 39);
						Jpanel.add(JTNAME);
						JTNAME.setColumns(10);*/
						
						
						Joinyes = new JButton("??????");
						Joinyes.setBounds(600, 232, 120, 60);
						Joinyes.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int i=con.join(JTID.getText(),JTPW.getText());
								if(i==0) {
									JOptionPane.showMessageDialog( money.this, "?????? ????????? ?????????");
									JTID.setText("");
									JTPW.setText("");
									
								}
								else {
									
									JOptionPane.showMessageDialog( money.this, "???????????? ??????!");
									Lpanal.setVisible(true);
									Jpanel.setVisible(false);
									Mpanel.setVisible(false);
									Ipanel.setVisible(false);
									Spanel.setVisible(false);
									SPpanel.setVisible(false);
									Dpanel.setVisible(false);
									Cpanel.setVisible(false);
									CNpanel.setVisible(false);
								}
								
							}
						});
						Jpanel.add(Joinyes);
						
						Joinno = new JButton("??????");
						Joinno.setBounds(600, 325, 120, 60);
						Joinno.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								Lpanal.setVisible(true);
								Jpanel.setVisible(false);
								Mpanel.setVisible(false);
								Ipanel.setVisible(false);
								Spanel.setVisible(false);
								SPpanel.setVisible(false);
								Dpanel.setVisible(false);
								Cpanel.setVisible(false);
								CNpanel.setVisible(false);
								
							}
						});
						Jpanel.add(Joinno);
						
						label_1 = new JLabel("????????????");
						label_1.setFont(new Font("Dialog", Font.BOLD, 50));
						label_1.setBounds(300, 60, 300, 111);
						Jpanel.add(label_1);
				
				Mpanel = new JPanel();
				Mpanel.setBounds(0, 0, 834, 601);
				contentPane.add(Mpanel);
				Mpanel.setLayout(null);
				
				JButton Mbtn = new JButton("????????? ??????");
				Mbtn.setFont(new Font("??????", Font.BOLD, 30));
				Mbtn.setBounds(131, 140, 284, 67);
				Mbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(true);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				Mpanel.add(Mbtn);
				
				JButton MSbtn = new JButton("?????? ??????");
				MSbtn.setFont(new Font("??????", Font.BOLD, 30));
				MSbtn.setBounds(131, 257, 284, 67);
				MSbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(true);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				Mpanel.add(MSbtn);
				
				JButton MCbtn = new JButton("?????? ??????");
				MCbtn.setFont(new Font("??????", Font.BOLD, 30));
				MCbtn.setBounds(131, 384, 289, 67);
				Mpanel.add(MCbtn);
				
				JButton Sbtn = new JButton("??????");
				Sbtn.setFont(new Font("??????", Font.BOLD, 30));
				Sbtn.setBounds(560, 192, 208, 197);
				Mpanel.add(Sbtn);
				
				Ipanel = new JPanel();
				Ipanel.setBounds(0, 0, 834, 601);
				contentPane.add(Ipanel);
				Ipanel.setLayout(null);
				
				JLabel Iname = new JLabel("??????");
				Iname.setFont(new Font("??????", Font.BOLD, 30));
				Iname.setBounds(232, 129, 101, 69);
				Ipanel.add(Iname);
				
				JLabel Imoney = new JLabel("??????");
				Imoney.setFont(new Font("??????", Font.BOLD, 30));
				Imoney.setBounds(232, 254, 101, 69);
				Ipanel.add(Imoney);
				
				JLabel Idate = new JLabel("??????(??????)");
				Idate.setFont(new Font("??????", Font.BOLD, 30));
				Idate.setBounds(165, 375, 168, 69);
				Ipanel.add(Idate);
				
				ITname = new JTextField();
				ITname.setBounds(415, 150, 211, 39);
				Ipanel.add(ITname);
				ITname.setColumns(10);
				
				ITmoney = new JTextField();
				ITmoney.setBounds(415, 275, 211, 39);
				Ipanel.add(ITmoney);
				ITmoney.setColumns(10);
				
				ITdate = new JTextField();
				ITdate.setBounds(415, 396, 211, 39);
				Ipanel.add(ITdate);
				ITdate.setColumns(10);
				
				JButton Ibtn = new JButton("??????");
				Ibtn.setFont(new Font("??????", Font.BOLD, 25));
				Ibtn.setBounds(225, 503, 134, 46);
				Ibtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						con.add(ITname.getText(), ITmoney.getText(), ITdate.getText(), loginid);
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(true);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				Ipanel.add(Ibtn);
				
				JButton Ino = new JButton("??????");
				Ino.setFont(new Font("??????", Font.BOLD, 25));
				Ino.setBounds(461, 503, 134, 46);
				Ino.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(true);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				Ipanel.add(Ino);
				
				Spanel = new JPanel();
				Spanel.setBounds(0, 0, 834, 601);
				contentPane.add(Spanel);
				Spanel.setLayout(null);
				
				Syear = new JLabel("???(4??????)");
				Syear.setFont(new Font("??????", Font.BOLD, 30));
				Syear.setBounds(201, 169, 145, 69);
				Spanel.add(Syear);
				
				Smonth = new JLabel("???(2??????)");
				Smonth.setFont(new Font("??????", Font.BOLD, 30));
				Smonth.setBounds(201, 314, 145, 69);
				Spanel.add(Smonth);
				
				STyear = new JTextField();
				STyear.setBounds(401, 190, 211, 39);
				Spanel.add(STyear);
				STyear.setColumns(10);
				
				STmonth = new JTextField();
				STmonth.setBounds(401, 335, 211, 39);
				Spanel.add(STmonth);
				STmonth.setColumns(10);
				

				SPpanel = new JPanel();
				SPpanel.setBounds(0, 0, 834, 601);
				contentPane.add(SPpanel);
				SPpanel.setLayout(null);
				
				
				Searchbtn = new JButton("??????");
				Searchbtn.setFont(new Font("??????", Font.BOLD, 30));
				Searchbtn.setBounds(225, 453, 134, 46);
				Searchbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						List<duesVO> x;
						
						x=con.searchdate(STyear.getText(), STmonth.getText(), loginid);

						textArea.setText("??????  ??????   ??????   ??????\n");   
						for(int i=0;i<x.size();i++) {
							textArea.append(x.get(i).getDues_id()+" ");
							textArea.append(x.get(i).getDues_name()+"    ");
							textArea.append(x.get(i).getDues()+"        ");
							textArea.append(x.get(i).getDues_date()+"\n"); 
						}
						
						
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(true);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				Spanel.add(Searchbtn);
				
				Snobtn = new JButton("??????");
				Snobtn.setFont(new Font("??????", Font.BOLD, 30));
				Snobtn.setBounds(461, 453, 134, 46);
				Snobtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(true);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				Spanel.add(Snobtn);
				 
				
				
				
				
				JButton SPchangebtn = new JButton("??????");
				SPchangebtn.setBounds(175, 481, 134, 46);
				SPchangebtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(true);
						
					}
				});
				SPpanel.add(SPchangebtn);
				
				JButton SPdeletebtn = new JButton("??????");
				SPdeletebtn.setBounds(376, 481, 134, 46);
				SPdeletebtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(true);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				SPpanel.add(SPdeletebtn);
				
				JButton SPnobtn = new JButton("??????");
				SPnobtn.setBounds(582, 481, 134, 46);
				SPnobtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(true);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				SPpanel.add(SPnobtn);
				
				textArea = new JTextArea();
				textArea.setBounds(80, 30, 700, 300);
				SPpanel.add(textArea);
				
				SPchangebtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(true);
						CNpanel.setVisible(false);
						
					}
				});
				SPchangebtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(true);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				SPchangebtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(true);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				SPchangebtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(true);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				SPpanel.setVisible(false);
				
				CNpanel = new JPanel();
				CNpanel.setBounds(0, 0, 834, 601);
				contentPane.add(CNpanel);
				CNpanel.setLayout(null);
				
				JLabel CNnumber = new JLabel("??????");
				CNnumber.setBounds(196, 223, 145, 69);
				CNpanel.add(CNnumber);
				CNnumber.setFont(new Font("??????", Font.BOLD, 30));
				
				CNTnumber = new JTextField();
				CNTnumber.setBounds(377, 240, 221, 39);
				CNpanel.add(CNTnumber);
				CNTnumber.setColumns(10);
				
				JButton CNcbtn = new JButton("??????");
				CNcbtn.setBounds(216, 442, 134, 46);
				CNcbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(true);
						CNpanel.setVisible(false);
						
					}
				});
				CNpanel.add(CNcbtn);
				
				JButton CNnobtn = new JButton("??????");
				CNnobtn.setBounds(462, 443, 134, 46);
				CNnobtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(true);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				CNpanel.add(CNnobtn);
				CNpanel.setVisible(false);
				
				Cpanel = new JPanel();
				Cpanel.setBounds(0, 0, 834, 601);
				contentPane.add(Cpanel);
				Cpanel.setLayout(null);
				
				Cname = new JLabel("??????");
				Cname.setFont(new Font("??????", Font.BOLD, 30));
				Cname.setBounds(232, 129, 101, 69);
				Cpanel.add(Cname);
				
				Cmoney = new JLabel("??????");
				Cmoney.setFont(new Font("??????", Font.BOLD, 30));
				Cmoney.setBounds(232, 254, 101, 69);
				Cpanel.add(Cmoney);
				
				Cdate = new JLabel("??????(??????)");
				Cdate.setFont(new Font("??????", Font.BOLD, 30));
				Cdate.setBounds(165, 375, 154, 69);
				Cpanel.add(Cdate);
				
				CTname = new JTextField();
				CTname.setBounds(415, 150, 211, 39);
				Cpanel.add(CTname);
				CTname.setColumns(10);
				
				CTmoney = new JTextField();
				CTmoney.setBounds(415, 275, 211, 39);
				Cpanel.add(CTmoney);
				CTmoney.setColumns(10);
				
				CTdate = new JTextField();
				CTdate.setBounds(415, 396, 211, 39);
				Cpanel.add(CTdate);
				CTdate.setColumns(10);
				
				Cchangebtn = new JButton("??????");
				Cchangebtn.setBounds(225, 503, 134, 46);
				Cpanel.add(Cchangebtn);
				
				Cnobtn = new JButton("??????");
				Cnobtn.setBounds(461, 503, 134, 46);
				Cnobtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(false);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(true);
						
					}
				});
				Cpanel.add(Cnobtn);
				Cpanel.setVisible(false);
				
				Dpanel = new JPanel();
				Dpanel.setBounds(0, 0, 834, 601);
				contentPane.add(Dpanel);
				Dpanel.setLayout(null);
				
				Dnumber = new JLabel("??????");
				Dnumber.setFont(new Font("??????", Font.BOLD, 30));
				Dnumber.setBounds(192, 219, 145, 69);
				Dpanel.add(Dnumber);
				
				DTnumber = new JTextField();
				DTnumber.setColumns(10);
				DTnumber.setBounds(377, 240, 221, 39);
				Dpanel.add(DTnumber);
				
				Dbtn = new JButton("??????");
				Dbtn.setBounds(216, 442, 134, 46);
				Dbtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						con.del(DTnumber.getText());
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(true);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				Dpanel.add(Dbtn);
				
				Dnobtn = new JButton("??????");
				Dnobtn.setBounds(462, 443, 134, 46);
				Dnobtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Lpanal.setVisible(false);
						Jpanel.setVisible(false);
						Mpanel.setVisible(false);
						Ipanel.setVisible(false);
						Spanel.setVisible(false);
						SPpanel.setVisible(true);
						Dpanel.setVisible(false);
						Cpanel.setVisible(false);
						CNpanel.setVisible(false);
						
					}
				});
				Dpanel.add(Dnobtn);
				Dpanel.setVisible(false);

				Jpanel.setVisible(false);
				Mpanel.setVisible(false);
				Spanel.setVisible(false);
				Ipanel.setVisible(false);

		setSize(834, 601);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
