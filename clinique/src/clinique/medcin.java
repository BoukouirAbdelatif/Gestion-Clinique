package clinique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class medcin {

	public JFrame frmMdcin;
	private JTable table;
	private JTextField txt;
	JRadioButton tt;
	JRadioButton par;
	private Connection con;
    private Statement st;
    private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medcin window = new medcin();
					window.frmMdcin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public void afficher() {
		try {
			String query="select medcin.nom as Medecin,patient.nom as patient, reservation.date from patient,reservation,medcin where reservation.idpat=patient.idpat and reservation.id=medcin.id";
		    rs=st.executeQuery(query);
		    table.setModel(DbUtils.resultSetToTableModel(rs));			
		    }
		catch(Exception ex) {
			
		    }
	}
	public medcin() {
		initialize();
		try{
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clinique","root","");
            st=con.createStatement();
        }catch(Exception ex){
            System.out.println("Error: "+ex);
            
        }
		afficher();
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMdcin = new JFrame();
		frmMdcin.setTitle("M\u00E9decin");
		frmMdcin.setBounds(140, 100, 715, 481);
		frmMdcin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMdcin.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 104, 669, 267);
		frmMdcin.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		tt = new JRadioButton("Tout");
		tt.setSelected(true);
		tt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				par.setSelected(false);
				try {
				String query="select medcin.nom as Medecin,patient.nom as patient, reservation.date from patient,reservation,medcin where reservation.idpat=patient.idpat and reservation.id=medcin.id";
			    rs=st.executeQuery(query);
			    table.setModel(DbUtils.resultSetToTableModel(rs));			
			    }
			catch(Exception ex) {
				
			    }
			}
		});
		tt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tt.setBounds(16, 70, 82, 23);
		frmMdcin.getContentPane().add(tt);
		
		par = new JRadioButton("par M\u00E9decin");
		par.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tt.setSelected(false);
				txt.setVisible(true);
			}
		});
		par.setFont(new Font("Tahoma", Font.PLAIN, 13));
		par.setBounds(101, 70, 109, 23);
		frmMdcin.getContentPane().add(par);
		
		txt = new JTextField();
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String rech=txt.getText();
				try {
					String query="select medcin.nom as Medecin, patient.nom as patient, reservation.date from patient,reservation,medcin where reservation.idpat=patient.idpat and reservation.id=medcin.id and medcin.nom like '"+rech+"%'";
				    rs=st.executeQuery(query);
				    table.setModel(DbUtils.resultSetToTableModel(rs));				}catch(Exception ex) {
					
				}
			}
		});
		txt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt.setBounds(213, 70, 167, 20);
		frmMdcin.getContentPane().add(txt);
		txt.setColumns(10);
		txt.setVisible(false);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMdcin.dispose();
			}
		});
		btnQuitter.setBounds(600, 408, 89, 23);
		frmMdcin.getContentPane().add(btnQuitter);
		
		JLabel lblNewLabel = new JLabel("Recherche par Medcin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(281, 11, 280, 23);
		frmMdcin.getContentPane().add(lblNewLabel);
	}
}
