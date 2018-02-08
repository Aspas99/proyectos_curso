package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Contacto;
import contactos.GestionContactos;
import principal.adaptadores.AdaptadorListaCombo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JComboBox;

public class JVentana extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscaEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVentana frame = new JVentana();
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
	public JVentana() {
		setTitle("Agenda Gr\u00E1fica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		GestionContactos gcontactos=new GestionContactos();
		/*
		List listContactos = new List();
		listContactos.setBounds(246, 161, 178, 79);
		contentPane.add(listContactos);
		listContactos.setVisible(false);*/
		
		JButton btnAgregarContacto = new JButton("Agregar Contacto");
		btnAgregarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JVentanaContacto.NuevaVentanaContacto()!=null) {
						JVentanaContacto jvc=new JVentanaContacto();
						jvc.setVisible(true);
				}
			}
		});
		btnAgregarContacto.setBounds(22, 42, 173, 23);
		contentPane.add(btnAgregarContacto);
		
		JLabel lblContacto = new JLabel("");
		lblContacto.setBounds(131, 171, 256, 50);
		contentPane.add(lblContacto);
		
		JButton btnBuscarContacto = new JButton("Buscar Contacto");
		btnBuscarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto c=gcontactos.buscar(txtBuscaEmail.getText());
				lblContacto.setText("Nombre:" + c.getNombre() + " Telefono:" + c.getTelefono());
				lblContacto.setVisible(true);
			//	listContactos.setVisible(false);
				
			}
		});
		btnBuscarContacto.setBounds(22, 102, 173, 23);
		contentPane.add(btnBuscarContacto);
		
		txtBuscaEmail = new JTextField();
		txtBuscaEmail.setBounds(249, 103, 146, 20);
		contentPane.add(txtBuscaEmail);
		txtBuscaEmail.setColumns(10);
		
		
		
		JButton btnListadoContactos = new JButton("Listado Contactos");
		btnListadoContactos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JVContactos jvcontactos=new JVContactos();
				//gcontactos.recuperarTodos().forEach(c->listContactos.add( c.getNombre() +"," + c.getEmail() ));
				//JVContactos.setVisible(true);
				//listContactos.setVisible(true);
				
			}
		});
		
		
		btnListadoContactos.setBounds(22, 161, 173, 23);
		contentPane.add(btnListadoContactos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JVentana.this.dispose(); Esto terminaria la ventana principal pero dejaria las ventanas secundarias ejecutandose 
				System.exit(0); //Finaliza la aplicación Java 
			}
			
		});
		btnSalir.setBounds(22, 227, 89, 23);
		contentPane.add(btnSalir);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(236, 42, 188, 22);
		contentPane.add(comboBox);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto c=(Contacto)comboBox.getSelectedItem();
				gcontactos.eliminar(c.getEmail());
			}
		});
		btnEliminar.setBounds(335, 11, 89, 23);
		contentPane.add(btnEliminar);
		
		//Carga de la lista ComboBox
		AdaptadorListaCombo adp=new AdaptadorListaCombo(gcontactos.recuperarTodos());
		comboBox.setModel(adp);
		
	}
}
