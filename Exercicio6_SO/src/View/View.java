package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.JogoController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUm;
	private JTextField textFieldDois;
	private JTextField textFieldTres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUm = new JTextField();
		textFieldUm.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUm.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldUm.setEditable(false);
		textFieldUm.setBounds(87, 143, 97, 100);
		contentPane.add(textFieldUm);
		textFieldUm.setColumns(10);
		
		textFieldDois = new JTextField();
		textFieldDois.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDois.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldDois.setEditable(false);
		textFieldDois.setColumns(10);
		textFieldDois.setBounds(243, 143, 97, 100);
		contentPane.add(textFieldDois);
		
		textFieldTres = new JTextField();
		textFieldTres.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTres.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldTres.setEditable(false);
		textFieldTres.setColumns(10);
		textFieldTres.setBounds(396, 143, 97, 100);
		contentPane.add(textFieldTres);
		
		JButton btnJogar = new JButton("Jogar");
		btnJogar.setBounds(475, 318, 89, 23);
		contentPane.add(btnJogar);
		JogoController jogoController = new JogoController(textFieldUm, textFieldDois, textFieldTres, btnJogar);
		btnJogar.addActionListener(jogoController); 

		JLabel lblNewLabel = new JLabel("CA\u00C7A N\u00CDQUEL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 40, 456, 51);
		contentPane.add(lblNewLabel);
	}

}
