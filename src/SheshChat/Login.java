package SheshChat;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.UnsupportedLookAndFeelException;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPort;

	/**
	 * Create the frame.
	 */
	public Login() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,380);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(68, 60, 157, 22);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(119, 42, 56, 16);
		contentPane.add(lblName);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(68, 143, 157, 22);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblIpAddress = new JLabel("IP Address:");
		lblIpAddress.setBounds(110, 123, 73, 16);
		contentPane.add(lblIpAddress);
		
		txtPort = new JTextField();
		txtPort.setColumns(10);
		txtPort.setBounds(68, 221, 157, 22);
		contentPane.add(txtPort);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(130, 201, 33, 16);
		contentPane.add(lblPort);
		
		JButton btnLogin = new JButton("Login");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String address = txtAddress.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(name, address, port);
			}
		});
		
		btnLogin.setBounds(98, 307, 97, 25);
		contentPane.add(btnLogin);
	}
	
	private void login(String name, String address, int port) {
		dispose();
		new ClientWindow(name, address, port);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
