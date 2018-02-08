package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import contactos.GestionContactos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class JVentanaContacto extends JFrame {
     private static JVentanaContacto jvc=null;
	  JPanel contentPane;
	  JTextField txtNombre;
	  JTextField txtEmail;
	  JTextField txtTelefono;

	 
	 public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVentanaContacto frame = new JVentanaContacto();
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
	public JVentanaContacto() {
		this.setVisible(true);
		setTitle("Agregar Contactos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(110, 25, 277, 160);
		contentPane.add(panel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 70, 14);
		panel.add(lblNombre);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(10, 36, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblTelefono = new JLabel("telefono");
		lblTelefono.setBounds(10, 71, 46, 14);
		panel.add(lblTelefono);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(57, 8, 175, 20);
		panel.add(txtNombre);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(57, 36, 175, 20);
		panel.add(txtEmail);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(57, 68, 175, 20);
		panel.add(txtTelefono);
		
		JButton btnGuardarContacto = new JButton("Guardar");
		btnGuardarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionContactos gcontactos=new GestionContactos();
				gcontactos.alta(txtNombre.getText(),txtEmail.getText(),Integer.parseInt(txtTelefono.getText()));
							
				//setVisible(false);
			}
		});
		
		btnGuardarContacto.setBounds(96, 126, 89, 23);
		panel.add(btnGuardarContacto);
		//Pdriamos poner el objeto jvc que mantiene el estado de "singleton" a null
		//jvc=null;
		//pero es mejor gestionar el evento de cierre de ventana 
		//para ello instanciamos una variable de interfaz WindowListener.
	/*	WindowListener lstVentana=new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// Evento que se va a producir cuando se va a cerrar la ventana
				jvc=null;
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		};*/

	}
	
	public static JVentanaContacto NuevaVentanaContacto() { //El método que crea 
		
		if (jvc==null) { //si el obj no existe o no ha sido creado :solo hay un objeto prvate y static ,es decir ambito de clase 
						// y static ,es decir que se comparte por todas las instancias
			jvc=new JVentanaContacto();
		}
		return jvc;
	} 

}
