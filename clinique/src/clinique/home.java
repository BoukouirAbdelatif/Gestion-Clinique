package clinique;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;

public class home {

	private JFrame frame;
	JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblMdecin;
	private JLabel lblQuitter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 789, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			
				label.setIcon(new ImageIcon("lib/img33.png"));
				label_1.setIcon(new ImageIcon("lib/img22.png"));
				lblNewLabel_1.setIcon(new ImageIcon("lib/img11.png"));



			}
		});
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 773, 407);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		ImageIcon img=new ImageIcon("lib/med2.jpg");
		
		lblNewLabel_1 = new JLabel(new ImageIcon("lib/img11.png"));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Réservation r=new Réservation();
				r.frmRservation.setVisible(true);
			}
		});
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				lblNewLabel_1.setIcon(new ImageIcon("lib/img1.png"));
			}
		});
		
		lblNewLabel_2 = new JLabel("Gestion De Clinique");
		lblNewLabel_2.setForeground(new Color(102, 102, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_2.setBounds(486, 43, 394, 39);
		panel.add(lblNewLabel_2);
		lblNewLabel_1.setBounds(170, 254, 70, 48);
		panel.add(lblNewLabel_1);
		
		label = new JLabel(new ImageIcon("lib/img33.png"));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				medcin m=new medcin();
				m.frmMdcin.setVisible(true);
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label.setIcon(new ImageIcon("lib/img3.png"));
			}
		});
		label.setBounds(340, 254, 70, 48);
		panel.add(label);
		
		label_1 = new JLabel(new ImageIcon("lib/img22.png"));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		label_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_1.setIcon(new ImageIcon("lib/img2.png"));
			}
		});
		label_1.setBounds(503, 254, 70, 48);
		panel.add(label_1);
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(0, 0, 773, 272);
		
		panel.add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("Reservation");
		lblNewLabel_3.setBounds(170, 317, 70, 14);
		panel.add(lblNewLabel_3);
		
		lblMdecin = new JLabel("M\u00E9decin");
		lblMdecin.setBounds(350, 317, 70, 14);
		panel.add(lblMdecin);
		
		lblQuitter = new JLabel("Quitter");
		lblQuitter.setBounds(519, 317, 70, 14);
		panel.add(lblQuitter);

	}
}
