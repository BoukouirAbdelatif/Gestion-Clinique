package clinique;

import java.awt.EventQueue;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Réservation {

	public JFrame frmRservation;
	private JTable table;
	int id1;
	int id2;
	private JLabel lblRecherche;
	private JTextField txtr;
	private JTextField tnom;
	private JTextField tprenom;
	private Connection con;
    private Statement st;
    private ResultSet rs,rs2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Réservation window = new Réservation();
					window.frmRservation.setVisible(true);
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
			String query3="select patient.idpat as id,patient.nom,patient.prenom,medcin.nom as Medecin,reservation.date as date from patient,reservation,medcin where reservation.idpat=patient.idpat and reservation.id=medcin.id";
		    rs=st.executeQuery(query3);
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		}
			catch(Exception ex){
				
			}
		
	}
	public Réservation() {
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
		frmRservation = new JFrame();
		frmRservation.setTitle("R\u00E9servation");
		frmRservation.setBounds(140,110, 719, 491);
		frmRservation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRservation.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 300, 683, 141);
		frmRservation.getContentPane().add(scrollPane);
		
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
		
		lblRecherche = new JLabel("Recherche");
		lblRecherche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRecherche.setBounds(14, 270, 78, 14);
		frmRservation.getContentPane().add(lblRecherche);
		
		txtr = new JTextField();
		txtr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				String nomr=txtr.getText();
				try {
					String query="select patient.idpat as id,patient.nom,patient.prenom,medcin.nom as Medecin,reservation.date as date from patient,reservation,medcin where reservation.idpat=patient.idpat and reservation.id=medcin.id and patient.nom like '"+nomr+"%'";
				    rs=st.executeQuery(query);
				    table.setModel(DbUtils.resultSetToTableModel(rs));				}catch(Exception ex) {
					
				}
			}
		});
		txtr.setBounds(91, 263, 602, 29);
		frmRservation.getContentPane().add(txtr);
		txtr.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 11, 683, 225);
		frmRservation.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter R\u00E9ndez Vous ");
		lblNewLabel.setForeground(new Color(51, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(256, 0, 199, 36);
		panel.add(lblNewLabel);
		
		tnom = new JTextField();
		tnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tnom.setBounds(76, 94, 190, 20);
		panel.add(tnom);
		tnom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Medecin");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 50, 57, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"", "Djahlate", "Hichour", "Boukouir"}));
		combo.setBounds(76, 47, 190, 22);
		panel.add(combo);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setForeground(new Color(0, 0, 0));
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(20, 98, 46, 14);
		panel.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setForeground(new Color(0, 0, 0));
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrnom.setBounds(290, 98, 46, 14);
		panel.add(lblPrnom);
		
		tprenom = new JTextField();
		tprenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tprenom.setColumns(10);
		tprenom.setBounds(346, 94, 190, 20);
		panel.add(tprenom);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 0, 0));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(20, 137, 46, 14);
		panel.add(lblDate);
		
		JDateChooser date = new JDateChooser();
		date.setBounds(76, 137, 210, 20);
		panel.add(date);
		
		JButton btnNewButton = new JButton("Ajouter RDV");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				String nom=tnom.getText();
				String prenom=tprenom.getText();
				String med=(String) combo.getSelectedItem();
				if(date.equals(null) || nom.equals("") || prenom.equals("") || med.equals("")) {
					JOptionPane.showMessageDialog(null,"veuillez remplir tout les champs","avertissement",JOptionPane.WARNING_MESSAGE);
				}else {
					
					String dat=df.format(date.getDate());
					try {
						String da=df.format(date.getDate());
						String query="insert into patient(nom,prenom)values('"+nom+"','"+prenom+"')";
						st.execute(query);
						
					}catch(Exception ex){
						System.out.println(ex);
					}
					try {
						String q2="select id from medcin where medcin.nom='"+med+"'";
						rs=st.executeQuery(q2);
		                while(rs.next()) {
		                	id1=Integer.parseInt(rs.getString("id"));
		                }
		                
		                String q3="select * from patient ";
		                rs2=st.executeQuery(q3);
		                while(rs2.next()) {
		                	id2=Integer.parseInt(rs2.getString("idpat"));
		                }
		                
						String query2="insert into reservation(id,idpat,date)values('"+id1+"','"+id2+"','"+dat+"')";
						st.execute(query2);
						JOptionPane.showMessageDialog(null,"le patien "+nom+" "+prenom+ " a été ajouté","succée",JOptionPane.INFORMATION_MESSAGE);
                        String query3="select patient.idpat as id,patient.nom,patient.prenom,medcin.nom as Medecin,reservation.date as date from patient,reservation,medcin where reservation.idpat=patient.idpat and reservation.id=medcin.id";
					    rs=st.executeQuery(query3);
					    table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch(Exception ex) {
						System.out.println(ex);
					}
					tnom.setText(null);
					tprenom.setText(null);
					combo.setSelectedItem(null);
					date.setDate(null);

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(271, 191, 184, 23);
		panel.add(btnNewButton);
	}
}
