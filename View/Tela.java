package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Tela extends JFrame {

	private JPanel contentPane;
	private final JDesktopPane desktopPane_1 = new JDesktopPane();
	String nomeFunc;
	Double salario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		getContentPane().setLayout(null);


		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 643, 320);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 643, 320);
		panel.add(desktopPane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 686, 410);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		desktopPane_1.setBackground(SystemColor.inactiveCaption);
		desktopPane_1.setBounds(0, 0, 686, 410);
		panel_1.add(desktopPane_1);
		this.setLocationRelativeTo(null);

		JButton btnNewButton = new JButton("Cadrastar churros");
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //chama a tela CadChurros e fecha a atual
				CadChurros cc = new CadChurros();
				cc.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(476, 181, 179, 41);
		desktopPane_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadrastar funcion\u00E1rio");
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() { //chama a tela ListarFunc e fecha a atual
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListarFunc cadfunc = new ListarFunc();
				cadfunc.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(245, 181, 190, 41);
		desktopPane_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Calculadora de pre\u00E7o sugerido para churros");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(79, 53, 537, 41);
		desktopPane_1.add(lblNewLabel);
		
		JButton btnInserirGastoMensal = new JButton("Inserir gasto mensal");
		btnInserirGastoMensal.addActionListener(new ActionListener() { //chama a tela de CadGasto e fecha a atual
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadGasto cadgasto = new CadGasto();			
				cadgasto.setVisible(true);
			}
		});
		btnInserirGastoMensal.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		btnInserirGastoMensal.setBounds(30, 181, 179, 41);
		desktopPane_1.add(btnInserirGastoMensal);
		
		JLabel lblNewLabel_1 = new JLabel("Desenvolvido por Cleiton Do Carmo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(276, 385, 156, 14);
		desktopPane_1.add(lblNewLabel_1);

	}
}
