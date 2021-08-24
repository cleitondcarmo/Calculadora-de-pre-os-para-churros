package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import Model.Funcionarios;
import Model.GastoMensal;
import Model.Gerente;

import javax.swing.event.AncestorEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
public class ListarFunc extends JFrame {

	private JPanel contentPane;
	private final JDesktopPane desktopPane = new JDesktopPane();
	String nomeFunc, nome, cargo, nomeGe;
	double salarioT, salarioGe, salario;
	DefaultTableModel model = new DefaultTableModel();
	ArrayList<Funcionarios> funcionario = new ArrayList<Funcionarios>(); //armazena os funcionarios
	ArrayList<GastoMensal> gastomensal = new ArrayList<GastoMensal>(); //armazena o gasto mensal
	ArrayList<Gerente> gerente = new ArrayList<Gerente>(); //armazena o gerente
	Gerente g1 = new Gerente(nomeGe = "", salarioGe = 0);
	Funcionarios f1 = new Funcionarios(nomeFunc = "",  salario = 0.0); //buffer do funcionario
	GastoMensal gm = new GastoMensal(); //buffer do funcionario


	private JTable table;
	private JScrollPane scrollPane;
	private JTextField NomeFuncionario;
	private JTextField SalarioFuncionario;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarFunc frame = new ListarFunc();
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
	public ListarFunc() {
		setTitle("Cadastrar funcion\u00E1rios");
		setBackground(SystemColor.inactiveCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		desktopPane.setBackground(SystemColor.inactiveCaption);
		desktopPane.setBounds(0, 0, 534, 459);
		panel.add(desktopPane);
		desktopPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar funcion\u00E1rios");
		lblNewLabel.setBounds(180, 11, 225, 28);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		desktopPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, 534, 215);
		desktopPane.add(scrollPane);
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);	

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] { //colunas
				"Nome", "Salario", "Cargo", "Bônus","Salario Total"
			}
		));
		scrollPane.setViewportView(table);
		
		JRadioButton OpFunc = new JRadioButton("Funcion\u00E1rio");
		OpFunc.setBackground(SystemColor.inactiveCaption);
		buttonGroup.add(OpFunc);
		OpFunc.setBounds(167, 346, 100, 23);
		desktopPane.add(OpFunc);
		
		JRadioButton OpGer = new JRadioButton("Gerente");
		OpGer.setBackground(SystemColor.inactiveCaption);
		buttonGroup.add(OpGer);
		OpGer.setBounds(280, 345, 73, 23);
		desktopPane.add(OpGer);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {//quando clicado é iniciado o cadastro do funcionario/gerente
			@Override
			public void mouseClicked(MouseEvent e) {
				int numCols = table.getModel().getColumnCount();
				Object [] fila = new Object[numCols]; //cria filas
				
				
				Double salario = Double.parseDouble(SalarioFuncionario.getText());	//converte salario
				String nome = NomeFuncionario.getText().toString(); //converte nome
				
				if(OpFunc.isSelected()) {	//se funcionario for selecionado adiciona o objeto a sua classe		
					f1.setSalario(salario);			
					f1.setNome(nome);
					salarioT = salarioT + f1.calcularbonus(f1);
					funcionario.add(f1);
					gm.setFuncionario(f1);
				}
				if(OpGer.isSelected()) {	//se gerente for selecionado adiciona o objeto a sua classe
					g1.setSalario(salario);
					g1.setNome(nome);
					salarioT = salarioT + g1.calcularbonus(g1);
					gerente.add(g1);
					gm.setGerente(g1);;
				}
				
				try { //grava o salario total
					FileOutputStream arqui = new FileOutputStream("C:\\teste\\cadfunc");  //se der erro, crie a pasta "teste" com permissões que funcionará
					DataOutputStream gravarArqui = new DataOutputStream(arqui);
				
				    gravarArqui.writeDouble(salarioT);
				    
				    arqui.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try { //ler o salario total no arquivo
					FileInputStream arqui = new FileInputStream("C:\\teste\\cadfunc");  //se der erro, cria a pasta "teste" com permissões que funciona
					DataInputStream lerArqui = new DataInputStream(arqui);
					salarioT = lerArqui.readDouble();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//insere as linhas na tabela
				fila[0] = nome;
				fila[1] = salario;
				
				if(OpFunc.isSelected()) { //se funcionario for selecionado o cargo do mesmo sera adicionado
					fila[2] = "Funcionário";
					fila[3] = f1.calcularbonus(f1);
				}
				
				if(OpGer.isSelected()) { //se gerente for selecionado o cargo do mesmo sera adicionado
					fila[2] = "Gerente";
					fila[3] = g1.calcularbonus(g1);
				}
				
				fila[4] = salarioT; //soma o salario total de gerente e funcionario
				((DefaultTableModel) table.getModel()).addRow(fila);
			}
		});			
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(364, 396, 90, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //volta para a tela inicial
				dispose();
				Tela t = new Tela();
				t.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		desktopPane.add(btnNewButton);
		

		btnNewButton_1.setBounds(98, 394, 100, 30);
		desktopPane.add(btnNewButton_1);
		
		JLabel Nomefuncionario = new JLabel("Nome:");
		Nomefuncionario.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		Nomefuncionario.setBounds(104, 289, 46, 23);
		desktopPane.add(Nomefuncionario);
		
		JLabel lblNewLabel_1 = new JLabel("Sal\u00E1rio:");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(98, 318, 65, 23);
		desktopPane.add(lblNewLabel_1);
		
		NomeFuncionario = new JTextField();
		NomeFuncionario.setBounds(167, 288, 287, 20);
		desktopPane.add(NomeFuncionario);
		NomeFuncionario.setColumns(10);
		
		SalarioFuncionario = new JTextField();
		SalarioFuncionario.setBounds(167, 318, 100, 20);
		desktopPane.add(SalarioFuncionario);
		SalarioFuncionario.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cargo:");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(104, 346, 53, 23);
		desktopPane.add(lblNewLabel_1_1);
	}
}
