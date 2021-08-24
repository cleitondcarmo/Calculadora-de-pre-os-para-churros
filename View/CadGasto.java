package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Churros;
import Model.Funcionarios;
import Model.GastoMensal;
import Model.Gerente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class CadGasto extends JFrame {

	private JPanel contentPane;
	private JTextField MaterialLimpeza;
	private JTextField Energia;
	private JTextField Combustivel;
	private JTextField Gas;
	private JTextField Lucro;
	private JTextField MediaChurros;
	private JTextField QuantEmbalagem;
	private JTextField PacoteEmbalagem;
	private JTable table;
	String nomeFunc, nomeGe, nome;
	Double salario, salarioGe, energia, combustivel, gas, materiallimpeza, embalagem, EnergiaUni, CombustivelUni, GasUni, MaterialUni, EmbalagemUni, lucro, total;
	int mediachurros, mediachur;
	ArrayList<Churros> churros = new ArrayList<Churros>(); //armazena os churros
	ArrayList<Funcionarios> funcionario = new ArrayList<Funcionarios>(); //armazena os funcionarios
	ArrayList<GastoMensal> gastomensal = new ArrayList<GastoMensal>(); //armazena o gasto mensal
	ArrayList<Gerente> gerente = new ArrayList<Gerente>(); //armazena o gerente
	Funcionarios f1 = new Funcionarios(nomeFunc = "",  salario = 0.0); //instancia o array de funcionarios
	Gerente g1 = new Gerente(nomeGe = "", salarioGe = 0.0); //instanca o array de gerente
	GastoMensal gm = new GastoMensal(energia=0.0, combustivel=0.0, gas=0.0, materiallimpeza=0.0, embalagem=0.0, EnergiaUni=0.0, CombustivelUni=0.0, GasUni=0.0, MaterialUni=0.0,EmbalagemUni=0.0, mediachurros=0, lucro=0.0); //instancia o array de gasto mensal
	Churros c1 = new Churros(); //instancia o array de churros
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadGasto frame = new CadGasto();
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
	public CadGasto() {
		setTitle("Gasto mensal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 730, 496);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.inactiveCaption);
		desktopPane.setBounds(0, 0, 730, 496);
		panel.add(desktopPane);
		desktopPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("G\u00E1s:");
		lblNewLabel.setBounds(158, 314, 37, 25);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(lblNewLabel);
		
		MaterialLimpeza = new JTextField();
		MaterialLimpeza.setBounds(202, 401, 60, 25);
		desktopPane.add(MaterialLimpeza);
		MaterialLimpeza.setColumns(10);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //volta para a tela inicial
				dispose();
				Tela t = new Tela();
				t.setVisible(true);
			}
		});
		btnNewButton.setBounds(480, 445, 100, 30);
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(btnNewButton);
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);	

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] { //colunas
				"Energia", "Combustível", "Gás", "Material de limpeza", "Embalagem", "Total por churros"
			}
		));
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int numCols = table.getModel().getColumnCount();
				Object [] fila = new Object[numCols]; //inicia novas filas
				
				//faz a conversão dos dados e insere no objeto
				Double gas = Double.parseDouble(Gas.getText());	
				gm.setGas(gas);
				
				Double energia = Double.parseDouble(Energia.getText());	
				gm.setEnergia(energia);
				
				Double combustivel = Double.parseDouble(Combustivel.getText());	
				gm.setCombustivel(combustivel);
				
				Double materiallimpeza = Double.parseDouble(MaterialLimpeza.getText());	
				gm.setMaterialLimpeza(materiallimpeza);
				
				int quantembalagem = Integer.parseInt(QuantEmbalagem.getText());
				Double embalagem = Double.parseDouble(PacoteEmbalagem.getText());
				EmbalagemUni = embalagem / quantembalagem; //divide o valor do pacote pelo numero de embalagens que vem dentro de cada pacote para obter o valor unitario 
				gm.setEmbalagemUni(EmbalagemUni);
								
				gm.setEmbalagem(embalagem);
				
				int mediachurros = Integer.parseInt(MediaChurros.getText());
				mediachur = mediachurros * 4; //pega a media de churros vendidos por semana. Por ser muito incostante as vendas (dias que vende 4 churros, dias que vende 50) a media por dia ou por mes seria inviavel
				gm.setMediachurros(mediachur);
				
				Double lucro = Double.parseDouble(Lucro.getText());	
				gm.setLucro(lucro);

				//converte o valor total em valores de unidade
				EnergiaUni = energia / mediachur;
				gm.setEnergiaUni(EnergiaUni);
				CombustivelUni = combustivel / mediachur;
				gm.setCombustivelUni(CombustivelUni);
				GasUni = gas / mediachur;
				gm.setGasUni(GasUni);
				MaterialUni = materiallimpeza / mediachur;
				gm.setMaterialUni(MaterialUni);
				gastomensal.add(gm);

				try { //grava os dados no arquivo
					FileOutputStream arq = new FileOutputStream("C:\\teste\\cadgm"); //se der erro, cria a pasta "teste" com permissões que funciona
					DataOutputStream gravarArq = new DataOutputStream(arq);
				
				    gravarArq.writeDouble(EnergiaUni);
				    gravarArq.writeDouble(CombustivelUni);
				    gravarArq.writeDouble(GasUni);
				    gravarArq.writeDouble(MaterialUni);
				    gravarArq.writeDouble(EmbalagemUni);
				    gravarArq.writeInt(mediachur);
				    gravarArq.writeDouble(lucro);
				    
				    arq.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	
				//adiciona os valores as linhas da tabela
				fila[0] = EnergiaUni;
				fila[1] = CombustivelUni;
				fila[2] = GasUni;
				fila[3] = MaterialUni;
				fila[4] = EmbalagemUni;
				fila[5] = gm.CalculoGM(gm);
				((DefaultTableModel) table.getModel()).addRow(fila);		
			}
		});
		
		btnNewButton_1.setBounds(150, 445, 100, 30);
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(btnNewButton_1);
		
		Energia = new JTextField();
		Energia.setBounds(202, 371, 60, 25);
		Energia.setColumns(10);
		desktopPane.add(Energia);
		
		Combustivel = new JTextField();
		Combustivel.setBounds(202, 341, 60, 25);
		Combustivel.setColumns(10);
		desktopPane.add(Combustivel);
		
		Gas = new JTextField();
		Gas.setBounds(202, 311, 60, 25);
		Gas.setColumns(10);
		desktopPane.add(Gas);
		
		Lucro = new JTextField();
		Lucro.setBounds(604, 399, 60, 25);
		Lucro.setColumns(10);
		desktopPane.add(Lucro);
		
		MediaChurros = new JTextField();
		MediaChurros.setBounds(604, 369, 60, 25);
		MediaChurros.setColumns(10);
		desktopPane.add(MediaChurros);
		
		QuantEmbalagem = new JTextField();
		QuantEmbalagem.setBounds(604, 339, 60, 25);
		QuantEmbalagem.setColumns(10);
		desktopPane.add(QuantEmbalagem);
		
		PacoteEmbalagem = new JTextField();
		PacoteEmbalagem.setBounds(604, 309, 60, 25);
		PacoteEmbalagem.setColumns(10);
		desktopPane.add(PacoteEmbalagem);
		
		JLabel lblCombstivel = new JLabel("Combust\u00EDvel:");
		lblCombstivel.setBounds(101, 344, 92, 25);
		lblCombstivel.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(lblCombstivel);
		
		JLabel lblEnergia = new JLabel("Energia:");
		lblEnergia.setBounds(135, 374, 60, 25);
		lblEnergia.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(lblEnergia);
		
		JLabel lblMatrialDeLimpeza = new JLabel("Material de limpeza:");
		lblMatrialDeLimpeza.setBounds(52, 404, 140, 25);
		lblMatrialDeLimpeza.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(lblMatrialDeLimpeza);
		
		JLabel lblPacoteDeEmbalagem = new JLabel("Pre\u00E7o de pacote de embalagem:");
		lblPacoteDeEmbalagem.setBounds(375, 312, 218, 25);
		lblPacoteDeEmbalagem.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(lblPacoteDeEmbalagem);
		
		JLabel lblQuantidadeDeEmbalagens = new JLabel("Quantidade de embalagens p/ pacote:");
		lblQuantidadeDeEmbalagens.setBounds(331, 344, 262, 25);
		lblQuantidadeDeEmbalagens.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(lblQuantidadeDeEmbalagens);
		
		JLabel lblMdiaDeChurros = new JLabel("M\u00E9dia de churros vendidos p/ semana:");
		lblMdiaDeChurros.setBounds(324, 374, 277, 25);
		lblMdiaDeChurros.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(lblMdiaDeChurros);
		
		JLabel lblLucroDesejado = new JLabel("Lucro desejado:");
		lblLucroDesejado.setBounds(483, 401, 118, 25);
		lblLucroDesejado.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		desktopPane.add(lblLucroDesejado);
		
		JLabel lblNewLabel_1 = new JLabel("Gastos mensais");
		lblNewLabel_1.setBounds(123, 273, 155, 30);
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Outros dados");
		lblNewLabel_1_1.setBounds(464, 273, 129, 30);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		desktopPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cadastro de outras informa\u00E7\u00F5es");
		lblNewLabel_1_2.setBounds(229, 11, 310, 30);
		lblNewLabel_1_2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		desktopPane.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 39, 730, 223);
		desktopPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
	}
}
