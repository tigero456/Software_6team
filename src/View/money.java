package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class money extends JFrame {

	private JPanel contentPane;
	private JPanel Lpanal;
	private JPanel Jpanel;
	private JPanel Mpanel;
	private JPanel Ipanel;
	private JPanel Spanel;
	
	private JLabel LID;
	private JLabel LPW;
	private JTextField LTID;
	private JTextField LTPW;
	private JButton Lbtn;
	private JButton Jbtn;

	private JLabel JoinID;
	private JLabel JoinPW;
	private JLabel JoinNAME;
	private JTextField JTID;
	private JTextField JTPW;
	private JTextField JTNAME;
	private JButton Joinyes;
	private JButton Joinno;
	
	private JLabel label;
	private JLabel label_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Lpanal = new JPanel();
		Lpanal.setBounds(0, 0, 434, 261);
		contentPane.add(Lpanal);
		Lpanal.setLayout(null);

		Jpanel = new JPanel();
		Jpanel.setBounds(0, 0, 434, 261);
		contentPane.add(Jpanel);
		
		Mpanel = new JPanel();
		Mpanel.setBounds(0, 0, 434, 261);
		contentPane.add(Mpanel);
		Mpanel.setLayout(null);
		
		Ipanel = new JPanel();
		Ipanel.setBounds(0, 0, 434, 261);
		contentPane.add(Ipanel);
		Ipanel.setLayout(null);
		
		Spanel = new JPanel();
		Spanel.setBounds(0, 0, 434, 261);
		contentPane.add(Spanel);
		Spanel.setLayout(null);
		
		Jpanel.setVisible(false);
		Mpanel.setVisible(false);
		Ipanel.setVisible(false);
		Spanel.setVisible(false);
		
		
		LTID = new JTextField();
		LTID.setBounds(144, 116, 116, 21);
		LTID.setColumns(10);
		Lpanal.add(LTID);
		
		LID = new JLabel("ID");
		LID.setBounds(100, 119, 11, 15);
		Lpanal.add(LID);
		
		LPW = new JLabel("PASSWD");
		LPW.setBounds(61, 171, 50, 15);
		Lpanal.add(LPW);
		
		LTPW = new JTextField();
		LTPW.setBounds(144, 168, 116, 21);
		LTPW.setColumns(10);
		Lpanal.add(LTPW);
		
		Lbtn = new JButton("로그인");
		Lbtn.setBounds(307, 107, 81, 57);
		Lpanal.add(Lbtn);
		
		label = new JLabel("공과금관리프로그램");
		label.setBounds(68, 32, 288, 42);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		Lpanal.add(label);
		
		Jbtn = new JButton("회원가입");
		Jbtn.setBounds(295, 174, 109, 23);
		Jbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Lpanal.setVisible(false);
				Jpanel.setVisible(true);
				Mpanel.setVisible(false);
				Ipanel.setVisible(false);
				Spanel.setVisible(false);
				
			}
		});
		Lpanal.add(Jbtn);
		Jpanel.setLayout(null);
		
		
		JoinID = new JLabel("아이디");
		JoinID.setBounds(61, 100, 50, 15);
		Jpanel.add(JoinID);
		
		JoinPW = new JLabel("비밀번호");
		JoinPW.setBounds(61, 140, 50, 15);
		Jpanel.add(JoinPW);
		
		JoinNAME = new JLabel("이름");
		JoinNAME.setBounds(61, 180, 50, 15);
		Jpanel.add(JoinNAME);
		
		JTID = new JTextField();
		JTID.setBounds(144, 100, 116, 21);
		Jpanel.add(JTID);
		JTID.setColumns(10);
		
		JTPW = new JTextField();
		JTPW.setBounds(144, 140, 116, 21);
		Jpanel.add(JTPW);
		JTPW.setColumns(10);
		
		JTNAME = new JTextField();
		JTNAME.setBounds(144, 180, 116, 21);
		Jpanel.add(JTNAME);
		JTNAME.setColumns(10);
		
		Joinyes = new JButton("확인");
		Joinyes.setBounds(307, 127, 70, 23);
		Jpanel.add(Joinyes);
		
		Joinno = new JButton("취소");
		Joinno.setBounds(307, 154, 70, 23);
		Jpanel.add(Joinno);
		
		label_1 = new JLabel("회원가입");
		label_1.setFont(new Font("Dialog", Font.BOLD, 30));
		label_1.setBounds(68, 32, 288, 42);
		Jpanel.add(label_1);

		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
