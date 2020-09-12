package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CarroController;
import Controller.ThreadCarro;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField textVencedor;
	private JTextField textPerdedor;

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
		setBounds(100, 100, 700, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel carroUm = new JLabel("CARRO 1");
		carroUm.setForeground(Color.RED);
		carroUm.setBounds(10, 79, 70, 14);
		contentPane.add(carroUm);
		
		JLabel carroDois = new JLabel("CARRO 2");
		carroDois.setForeground(Color.BLUE);
		carroDois.setBounds(10, 118, 70, 14);
		contentPane.add(carroDois);
		
		textVencedor = new JTextField();
		textVencedor.setEditable(false);
		textVencedor.setBounds(335, 322, 86, 20);
		contentPane.add(textVencedor);
		textVencedor.setColumns(10);
		
		textPerdedor = new JTextField();
		textPerdedor.setEditable(false);
		textPerdedor.setColumns(10);
		textPerdedor.setBounds(335, 370, 86, 20);
		contentPane.add(textPerdedor);
		
		JLabel lblVencedor = new JLabel("Vencedor");
		lblVencedor.setBounds(183, 325, 97, 14);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor");
		lblPerdedor.setBounds(183, 373, 97, 14);
		contentPane.add(lblPerdedor);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setBounds(524, 369, 89, 23);
		contentPane.add(btnCorrer);
		CarroController CarroController = new CarroController(carroUm, carroDois, btnCorrer, textVencedor, textPerdedor);
		btnCorrer.addActionListener(CarroController);

	}
}
