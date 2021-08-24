package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.management.PlatformManagedObject;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.table.TableModel;

import Model.Churros;
import Model.GastoMensal;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;


public class CadChurros extends JFrame {
	ArrayList<Churros> churros = new ArrayList<Churros>(); //armazena os churros
	ArrayList<GastoMensal> gastomensal = new ArrayList<GastoMensal>(); //armazena o gastomensal

	private JPanel contentPane;
	private JTextField nomechurros;
	private JTextField PrecoC;
	private JTextField QuantC;

	private JTextField numcardapio;
	private JTextField PrecoR;
	private JTextField QuantR;
	private JTextField PrecoCon;
	private JTextField QuantCon;
	private JTextField PrecoF;
	private JTextField QuantF;
	private JTextField PrecoA;
	private JTextField QuantA;
	private JTextField PrecoO;
	private JTextField QuantO;
	private JTextField PrecoM;
	private JTextField QuantM;
	
	int mediachur;
	
	double	
	MedidaManteiga=0, MedidaManteiga2=0, ManteigaUni, EnergiaUni,     lucrofinal,
	MedidaAcucar=0,   MedidaAcucar2=0,   AcucarUni,	  CombustivelUni, totalgm,
	MedidaOleo=0,     MedidaOleo2=0,     OleoUni,	  GasUni, 		  Lucro,
	MedidaRecheio=0,  MedidaRecheio2=0,  RecheioUni,  MaterialUni,	  valortotal,
	MedidaCobertura=0,MedidaCobertura2=0,CoberturaUni,EmbalagemUni,   salarioT,
	MedidaConfeito=0, MedidaConfeito2=0, ConfeitoUni, lucro,          salarioUni,
	MedidaFarinha=0,  MedidaFarinha2=0,  FarinhaUni,  total;
	
	private final ButtonGroup massarecheio = new ButtonGroup();
	private final ButtonGroup receitarecheio = new ButtonGroup();
	private final ButtonGroup massaconfeito = new ButtonGroup();
	private final ButtonGroup receitaconfeito = new ButtonGroup();
	private final ButtonGroup massafarinha = new ButtonGroup();
	private final ButtonGroup receitafarinha = new ButtonGroup();
	private final ButtonGroup massaacucar = new ButtonGroup();
	private final ButtonGroup receitaacucar = new ButtonGroup();
	private final ButtonGroup massaoleo = new ButtonGroup();
	private final ButtonGroup receitaoleo = new ButtonGroup();
	private final ButtonGroup massamanteiga = new ButtonGroup();
	private final ButtonGroup receitamanteiga = new ButtonGroup();
	private final ButtonGroup massacobertura = new ButtonGroup();
	private final ButtonGroup receitacobertura = new ButtonGroup();
	
	private JTextField quantC;
	private JTextField quantR;
	private JTextField quantCon;
	private JTextField quantF;
	private JTextField quantA;
	private JTextField quantO;
	private JTextField quantM;
	private JTextField massaC;
	private JTextField massaR;
	private JTextField massaCon;
	private JTextField massaF;
	private JTextField massaA;
	private JTextField massaO;
	private JTextField massaM;
	private JTable table;

	GastoMensal gm = new GastoMensal(); //instancia o array

	Churros c1 = new Churros(); //instancia o array

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadChurros frame = new CadChurros();
					frame.setVisible(true);			
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadChurros() {
		setTitle("Cadastrar churros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 21, 1084, 206);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1084, 206);
		panel.add(desktopPane);
		desktopPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1084, 206);
		desktopPane.add(scrollPane);
		
		//criação de colunas na tabela
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 9));
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Número", "Cobertura", "Confeito", "Recheio", "Farinha", "Manteiga", "A\u00E7\u00FAcar", "\u00D3leo", "Total receita", "Outros", "Lucro","Mão de obra"
				, "Pre\u00E7o sugerido"
			}
		));
		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel.setBounds(151, 238, 318, 29);
		contentPane.add(lblNewLabel);
		
		nomechurros = new JTextField();
		nomechurros.setBounds(197, 239, 272, 21);
		contentPane.add(nomechurros);
		nomechurros.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o cobertura:");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(151, 328, 111, 29);
		contentPane.add(lblNewLabel_1);
		
		PrecoC = new JTextField();
		PrecoC.setBounds(267, 328, 54, 21);
		contentPane.add(PrecoC);
		PrecoC.setColumns(10);
		
		JRadioButton PCkg = new JRadioButton("kg");
		PCkg.setBackground(SystemColor.inactiveCaption);
		massacobertura.add(PCkg);
		PCkg.setBounds(403, 328, 39, 23);
		contentPane.add(PCkg);
		
		JRadioButton PCg = new JRadioButton("g");
		PCg.setBackground(SystemColor.inactiveCaption);
		massacobertura.add(PCg);
		PCg.setBounds(444, 328, 39, 23);
		contentPane.add(PCg);
		
		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o de compra");
		lblNewLabel_2.setFont(new Font("Yu Gothic Light", Font.BOLD, 20));
		lblNewLabel_2.setBounds(151, 287, 161, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Quantidade na receita");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(573, 287, 198, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantidade cobertura:");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(573, 328, 151, 29);
		contentPane.add(lblNewLabel_1_1);
		
		QuantC = new JTextField();
		QuantC.setColumns(10);
		QuantC.setBounds(725, 328, 54, 21);
		contentPane.add(QuantC);
		
		JRadioButton QCkg = new JRadioButton("kg");
		QCkg.setBackground(SystemColor.inactiveCaption);
		receitacobertura.add(QCkg);
		QCkg.setBounds(785, 328, 39, 23);
		contentPane.add(QCkg);
		
		JRadioButton QCg = new JRadioButton("g");
		QCg.setBackground(SystemColor.inactiveCaption);
		receitacobertura.add(QCg);
		QCg.setBounds(826, 328, 39, 23);
		contentPane.add(QCg);
		
		JLabel lblNmeroNoCardpio = new JLabel("N\u00FAmero no card\u00E1pio:");
		lblNmeroNoCardpio.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNmeroNoCardpio.setBounds(573, 238, 138, 29);
		contentPane.add(lblNmeroNoCardpio);
		
		numcardapio = new JTextField();
		numcardapio.setBounds(721, 239, 58, 20);
		contentPane.add(numcardapio);
		numcardapio.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pre\u00E7o recheio:");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(151, 353, 111, 29);
		contentPane.add(lblNewLabel_1_2);
		
		PrecoR = new JTextField();
		PrecoR.setColumns(10);
		PrecoR.setBounds(267, 353, 54, 21);
		contentPane.add(PrecoR);
		
		JRadioButton PRkg = new JRadioButton("kg");
		PRkg.setBackground(SystemColor.inactiveCaption);
		massarecheio.add(PRkg);
		PRkg.setBounds(403, 353, 39, 23);
		contentPane.add(PRkg);
		
		JRadioButton PRg = new JRadioButton("g");
		PRg.setBackground(SystemColor.inactiveCaption);
		massarecheio.add(PRg);
		PRg.setBounds(444, 353, 39, 23);
		contentPane.add(PRg);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantidade recheio:");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(573, 353, 151, 29);
		contentPane.add(lblNewLabel_1_1_1);
		
		QuantR = new JTextField();
		QuantR.setColumns(10);
		QuantR.setBounds(725, 353, 54, 21);
		contentPane.add(QuantR);
		
		JRadioButton QRkg = new JRadioButton("kg");
		QRkg.setBackground(SystemColor.inactiveCaption);
		receitarecheio.add(QRkg);
		QRkg.setBounds(785, 353, 39, 23);
		contentPane.add(QRkg);
		
		JRadioButton QRg = new JRadioButton("g");
		QRg.setBackground(SystemColor.inactiveCaption);
		receitarecheio.add(QRg);
		QRg.setBounds(826, 353, 39, 23);
		contentPane.add(QRg);
		
		JLabel lblNewLabel_1_3 = new JLabel("Pre\u00E7o confeito:");
		lblNewLabel_1_3.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(151, 378, 111, 29);
		contentPane.add(lblNewLabel_1_3);
		
		PrecoCon = new JTextField();
		PrecoCon.setColumns(10);
		PrecoCon.setBounds(267, 378, 54, 21);
		contentPane.add(PrecoCon);
		
		JRadioButton PConkg = new JRadioButton("kg");
		PConkg.setBackground(SystemColor.inactiveCaption);
		massaconfeito.add(PConkg);
		PConkg.setBounds(403, 378, 39, 23);
		contentPane.add(PConkg);
		
		JRadioButton PCong = new JRadioButton("g");
		PCong.setBackground(SystemColor.inactiveCaption);
		massaconfeito.add(PCong);
		PCong.setBounds(444, 378, 39, 23);
		contentPane.add(PCong);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Quantidade confeito:");
		lblNewLabel_1_1_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(573, 378, 151, 29);
		contentPane.add(lblNewLabel_1_1_2);
		
		QuantCon = new JTextField();
		QuantCon.setColumns(10);
		QuantCon.setBounds(725, 378, 54, 21);
		contentPane.add(QuantCon);
		
		JRadioButton QConkg = new JRadioButton("kg");
		QConkg.setBackground(SystemColor.inactiveCaption);
		receitaconfeito.add(QConkg);
		QConkg.setBounds(785, 378, 39, 23);
		contentPane.add(QConkg);
		
		JRadioButton QCong = new JRadioButton("g");
		QCong.setBackground(SystemColor.inactiveCaption);
		receitaconfeito.add(QCong);
		QCong.setBounds(826, 378, 39, 23);
		contentPane.add(QCong);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Pre\u00E7o farinha:");
		lblNewLabel_1_2_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(151, 403, 111, 29);
		contentPane.add(lblNewLabel_1_2_1);
		
		PrecoF = new JTextField();
		PrecoF.setColumns(10);
		PrecoF.setBounds(267, 403, 54, 21);
		contentPane.add(PrecoF);
		
		JRadioButton PFkg = new JRadioButton("kg");
		PFkg.setBackground(SystemColor.inactiveCaption);
		massafarinha.add(PFkg);
		PFkg.setBounds(403, 403, 39, 23);
		contentPane.add(PFkg);
		
		JRadioButton PFg = new JRadioButton("g");
		PFg.setBackground(SystemColor.inactiveCaption);
		massafarinha.add(PFg);
		PFg.setBounds(444, 403, 39, 23);
		contentPane.add(PFg);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Quantidade farinha:");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(573, 403, 151, 29);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		QuantF = new JTextField();
		QuantF.setColumns(10);
		QuantF.setBounds(725, 403, 54, 21);
		contentPane.add(QuantF);
		
		JRadioButton QFkg = new JRadioButton("kg");
		QFkg.setBackground(SystemColor.inactiveCaption);
		receitafarinha.add(QFkg);
		QFkg.setBounds(785, 403, 39, 23);
		contentPane.add(QFkg);
		
		JRadioButton QFg = new JRadioButton("g");
		QFg.setBackground(SystemColor.inactiveCaption);
		receitafarinha.add(QFg);
		QFg.setBounds(826, 403, 39, 23);
		contentPane.add(QFg);
		
		JLabel lblNewLabel_1_4 = new JLabel("Pre\u00E7o a\u00E7ucar:");
		lblNewLabel_1_4.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(151, 428, 111, 29);
		contentPane.add(lblNewLabel_1_4);
		
		PrecoA = new JTextField();
		PrecoA.setColumns(10);
		PrecoA.setBounds(267, 428, 54, 21);
		contentPane.add(PrecoA);
		
		JRadioButton PAkg = new JRadioButton("kg");
		PAkg.setBackground(SystemColor.inactiveCaption);
		massaacucar.add(PAkg);
		PAkg.setBounds(403, 428, 39, 23);
		contentPane.add(PAkg);
		
		JRadioButton PAg = new JRadioButton("g");
		PAg.setBackground(SystemColor.inactiveCaption);
		massaacucar.add(PAg);
		PAg.setBounds(444, 428, 39, 23);
		contentPane.add(PAg);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Quantidade a\u00E7ucar:");
		lblNewLabel_1_1_3.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(573, 428, 151, 29);
		contentPane.add(lblNewLabel_1_1_3);
		
		QuantA = new JTextField();
		QuantA.setColumns(10);
		QuantA.setBounds(725, 428, 54, 21);
		contentPane.add(QuantA);
		
		JRadioButton QAkg = new JRadioButton("kg");
		QAkg.setBackground(SystemColor.inactiveCaption);
		receitaacucar.add(QAkg);
		QAkg.setBounds(785, 428, 39, 23);
		contentPane.add(QAkg);
		
		JRadioButton QAg = new JRadioButton("g");
		QAg.setBackground(SystemColor.inactiveCaption);
		receitaacucar.add(QAg);
		QAg.setBounds(826, 428, 39, 23);
		contentPane.add(QAg);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Pre\u00E7o \u00F3leo:");
		lblNewLabel_1_2_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(151, 453, 111, 29);
		contentPane.add(lblNewLabel_1_2_2);
		
		PrecoO = new JTextField();
		PrecoO.setColumns(10);
		PrecoO.setBounds(267, 453, 54, 21);
		contentPane.add(PrecoO);
		
		JRadioButton POl = new JRadioButton("l");
		POl.setBackground(SystemColor.inactiveCaption);
		massaoleo.add(POl);
		POl.setBounds(403, 453, 39, 23);
		contentPane.add(POl);
		
		JRadioButton POml = new JRadioButton("ml");
		POml.setBackground(SystemColor.inactiveCaption);
		massaoleo.add(POml);
		POml.setBounds(444, 453, 39, 23);
		contentPane.add(POml);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Quantidade \u00F3leo:");
		lblNewLabel_1_1_1_2.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(573, 453, 151, 29);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		QuantO = new JTextField();
		QuantO.setColumns(10);
		QuantO.setBounds(725, 453, 54, 21);
		contentPane.add(QuantO);
		
		JRadioButton QOl = new JRadioButton("l");
		QOl.setBackground(SystemColor.inactiveCaption);
		receitaoleo.add(QOl);
		QOl.setBounds(785, 453, 39, 23);
		contentPane.add(QOl);
		
		JRadioButton QOml = new JRadioButton("ml");
		QOml.setBackground(SystemColor.inactiveCaption);
		receitaoleo.add(QOml);
		QOml.setBounds(826, 453, 39, 23);
		contentPane.add(QOml);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Pre\u00E7o manteiga:");
		lblNewLabel_1_3_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_3_1.setBounds(151, 478, 111, 29);
		contentPane.add(lblNewLabel_1_3_1);
		
		PrecoM = new JTextField();
		PrecoM.setColumns(10);
		PrecoM.setBounds(267, 478, 54, 21);
		contentPane.add(PrecoM);
		
		JRadioButton PMkg = new JRadioButton("kg");
		PMkg.setBackground(SystemColor.inactiveCaption);
		massamanteiga.add(PMkg);
		PMkg.setBounds(403, 478, 39, 23);
		contentPane.add(PMkg);
		
		JRadioButton PMg = new JRadioButton("g");
		PMg.setBackground(SystemColor.inactiveCaption);
		massamanteiga.add(PMg);
		PMg.setBounds(444, 478, 39, 23);
		contentPane.add(PMg);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Quantidade manteiga:");
		lblNewLabel_1_1_2_1.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		lblNewLabel_1_1_2_1.setBounds(573, 478, 151, 29);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		QuantM = new JTextField();
		QuantM.setColumns(10);
		QuantM.setBounds(725, 478, 54, 21);
		contentPane.add(QuantM);
		
		JRadioButton QMkg = new JRadioButton("kg");
		QMkg.setBackground(SystemColor.inactiveCaption);
		receitamanteiga.add(QMkg);
		QMkg.setBounds(785, 478, 39, 23);
		contentPane.add(QMkg);
		
		JRadioButton QMg = new JRadioButton("g");
		QMg.setBackground(SystemColor.inactiveCaption);
		receitamanteiga.add(QMg);
		QMg.setBounds(826, 478, 39, 23);
		contentPane.add(QMg);

		//quando o botão Cadastrar é clicado o churros é adicionado
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//cria nova fila
				int numCols = table.getModel().getColumnCount();
				Object [] fila = new Object[numCols]; 
				
				int Numero = Integer.parseInt(numcardapio.getText()); //converte e add Numero do cardapio
				String nome = nomechurros.getText().toString(); //converte e add nome do churros
				c1.setNome(nome);
				c1.setNumero(Numero);	

//-----------------------------------------COBERTURA---------------------------------------
				//converte o tipo
				double PrecoCobertura = Double.parseDouble(PrecoC.getText());
				c1.setPrecoCobertura(PrecoCobertura);
				double quantreceiC = Double.parseDouble(QuantC.getText());
				double quantchurC = Double.parseDouble(quantC.getText());
				double quantmassaC = Double.parseDouble(massaC.getText());
				
				//conversão de kg e g
				if(PCkg.isSelected()) {
					MedidaCobertura = 1000;
				}
				
				if(PCg.isSelected()) {
					MedidaCobertura = 1;
				}
				
				if(QCkg.isSelected()) {
					MedidaCobertura2 = 1000;
				}
				
				if(QCg.isSelected()) {
					MedidaCobertura2 = 1;
				}
				
				//conversão do valor total para o valor unitario
				CoberturaUni = MedidaCobertura * quantmassaC;
				CoberturaUni = CoberturaUni / (MedidaCobertura2 * quantreceiC);
				CoberturaUni = CoberturaUni * quantchurC;
				CoberturaUni = PrecoCobertura / CoberturaUni;
				c1.setCoberturaUni(CoberturaUni);
//-----------------------------------------CONFEITO---------------------------------------

				double PrecoConfeito = Double.parseDouble(PrecoCon.getText());
				c1.setPrecoConfeito(PrecoConfeito);
				double quantreceiCon = Double.parseDouble(QuantCon.getText());
				double quantchurCon = Double.parseDouble(quantCon.getText());
				double quantmassaCon = Double.parseDouble(massaCon.getText());
				
				if(PConkg.isSelected()) {
					MedidaConfeito = 1000;
				}
				
				if(PCong.isSelected()) {
					MedidaConfeito = 1;
				}
				
				if(QConkg.isSelected()) {
					MedidaConfeito2 = 1000;
				}
				
				if(QCong.isSelected()) {
					MedidaConfeito2 = 1;
				}
				
				ConfeitoUni = MedidaConfeito * quantmassaCon;
				ConfeitoUni = ConfeitoUni / (MedidaConfeito2 * quantreceiCon);
				ConfeitoUni = ConfeitoUni * quantchurCon;
				ConfeitoUni = PrecoConfeito / ConfeitoUni;


				c1.setConfeitoUni(ConfeitoUni);
//-----------------------------------------RECHEIO---------------------------------------
				
				double PrecoRecheio = Double.parseDouble(PrecoR.getText());
				c1.setPrecoRecheio(PrecoRecheio);
				double quantreceiR = Double.parseDouble(QuantR.getText());
				double quantchurR = Double.parseDouble(quantR.getText());
				double quantmassaR = Double.parseDouble(massaR.getText());
				
				if(PRkg.isSelected()) {
					MedidaRecheio = 1000;
				}
				
				if(PRg.isSelected()) {
					MedidaRecheio = 1;
				}
				
				if(QRkg.isSelected()) {
					MedidaRecheio2 = 1000;
				}
				
				if(QRg.isSelected()) {
					MedidaRecheio2 = 1;
				}
				
				RecheioUni = MedidaRecheio * quantmassaR;
				RecheioUni = RecheioUni / (MedidaRecheio2 * quantreceiR);
				RecheioUni = RecheioUni * quantchurR;
				RecheioUni = PrecoRecheio / RecheioUni;
				c1.setRecheioUni(RecheioUni);
//-----------------------------------------FARINHA---------------------------------------
		
				double PrecoFarinha = Double.parseDouble(PrecoF.getText());
				c1.setPrecoFarinha(PrecoFarinha);
				double quantreceiF = Double.parseDouble(QuantF.getText());
				double quantchurF = Double.parseDouble(quantF.getText());
				double quantmassaF = Double.parseDouble(massaF.getText());
				
				if(PFkg.isSelected()) {
					MedidaFarinha = 1000;
				}
				
				if(PFg.isSelected()) {
					MedidaFarinha = 1;
				}
				
				if(QFkg.isSelected()) {
					MedidaFarinha2 = 1000;
				}
				
				if(QFg.isSelected()) {
					MedidaFarinha2 = 1;
				}
				
				FarinhaUni = MedidaFarinha * quantmassaF;
				FarinhaUni = FarinhaUni / (MedidaFarinha2 * quantreceiF);
				FarinhaUni = FarinhaUni * quantchurF;
				FarinhaUni = PrecoFarinha / FarinhaUni;
				c1.setFarinhaUni(FarinhaUni);
//-----------------------------------------MANTEIGA---------------------------------------
				double PrecoManteiga = Double.parseDouble(PrecoM.getText());
				c1.setPrecoManteiga(PrecoManteiga);
				double quantreceiM = Double.parseDouble(QuantM.getText());
				double quantchurM = Double.parseDouble(quantM.getText());
				double quantmassaM = Double.parseDouble(massaM.getText());
				
				if(PMkg.isSelected()) {
					MedidaManteiga = 1000;
				}
				
				if(PMg.isSelected()) {
					MedidaManteiga = 1;
				}
				
				if(QMkg.isSelected()) {
					MedidaManteiga2 = 1000;
				}
				
				if(QMg.isSelected()) {
					MedidaManteiga2 = 1;
				}
				
				ManteigaUni = MedidaManteiga * quantmassaM;
				ManteigaUni = ManteigaUni / (MedidaManteiga2 * quantreceiM);
				ManteigaUni = ManteigaUni * quantchurM;
				ManteigaUni = PrecoManteiga / ManteigaUni;
				c1.setManteigaUni(ManteigaUni);
//-----------------------------------------OLEO---------------------------------------

				double PrecoOleo = Double.parseDouble(PrecoO.getText());
				c1.setPrecoOleo(PrecoOleo);
				double quantrecheiO= Double.parseDouble(QuantO.getText());
				double quantchurO = Double.parseDouble(quantO.getText());
				double quantmassaO = Double.parseDouble(massaO.getText());
				
				if(POl.isSelected()) {
					MedidaOleo = 1000;
				}
				
				if(POml.isSelected()) {
					MedidaOleo = 1;
				}
				
				if(QOl.isSelected()) {
					MedidaOleo2 = 1000;
				}
				
				if(QOml.isSelected()) {
					MedidaOleo2 = 1;
				}
				
				OleoUni = MedidaOleo * quantmassaO;
				OleoUni = OleoUni / (MedidaOleo2 * quantrecheiO);
				OleoUni = OleoUni * quantchurO;
				OleoUni = PrecoOleo / OleoUni;
				c1.setOleoUni(OleoUni);
//-----------------------------------------ACUCAR---------------------------------------
				
				double PrecoAcucar = Double.parseDouble(PrecoA.getText());
				c1.setPrecoAcucar(PrecoAcucar);
				double quantreceiA = Double.parseDouble(QuantA.getText());
				double quantchurA = Double.parseDouble(quantA.getText());
				double quantmassaA = Double.parseDouble(massaA.getText());
				
				if(PAkg.isSelected()) {
					MedidaAcucar = 1000;
				}
				
				if(PAg.isSelected()) {
					MedidaAcucar = 1;
				}
				
				if(QAkg.isSelected()) {
					MedidaAcucar2 = 1000;
				}
				
				if(QAg.isSelected()) {
					MedidaAcucar2 = 1;
				}
				
				AcucarUni = MedidaAcucar * quantmassaA;
				AcucarUni = AcucarUni / (MedidaAcucar2 * quantreceiA);
				AcucarUni = AcucarUni * quantchurA;
				AcucarUni = PrecoAcucar / AcucarUni;

				c1.setAcucarUni(AcucarUni);
//------------------------------------------------------------------------------------------
				churros.add(c1);//adiciona o churros atual na lista de churros
				gm.setChurros(c1);
			    
				try { //ler os arquivos de CadGasto e ListarFunc
					FileInputStream arq = new FileInputStream("C:\\teste\\cadgm");
					DataInputStream lerArq = new DataInputStream(arq);
					FileInputStream arqui = new FileInputStream("C:\\teste\\cadfunc");			
					DataInputStream lerArqui = new DataInputStream(arqui);
					EnergiaUni = lerArq.readDouble();
					CombustivelUni = lerArq.readDouble();
					GasUni = lerArq.readDouble();
					MaterialUni = lerArq.readDouble();
					EmbalagemUni = lerArq.readDouble();
					mediachur = lerArq.readInt();
					lucro = lerArq.readDouble();
					salarioT = lerArqui.readDouble();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				totalgm = EnergiaUni + CombustivelUni + GasUni + MaterialUni + EmbalagemUni; //total do gasto mensal
				salarioT = salarioT / mediachur; //obtem o valor de mão de obra por churros
				total = totalgm + c1.Calcular() + salarioT;  //soma gasto mensal + ingredientes + mão de obra
				Lucro = (total * lucro) / 100; //obtem o lucro por cada churros
				valortotal = total + Lucro; //soma o lucro com os gastos
				
				//adiciona os valores as linhas na tabela
				fila[0] = c1.getNome();
				fila[1] = c1.getNumero();
				fila[2] = c1.getCoberturaUni();
				fila[3] = c1.getConfeitoUni();
				fila[4] = c1.getRecheioUni();
				fila[5] = c1.getFarinhaUni();
				fila[6] = c1.getManteigaUni();
				fila[7] = c1.getAcucarUni();
				fila[8] = c1.getOleoUni();
				fila[9] = c1.Calcular();
				fila[10] = totalgm;
				fila[11] = Lucro;
				fila[12] = salarioT;
				fila[13] = valortotal;
				((DefaultTableModel) table.getModel()).addRow(fila);			
			}
		});

		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnNewButton.setBounds(317, 518, 114, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00FAmero de churros poss\u00EDveis de se");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblNewLabel_3.setBounds(826, 275, 198, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" fazer com essa quantidade");
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 11));
		lblNewLabel_4.setBounds(853, 292, 144, 22);
		contentPane.add(lblNewLabel_4);
		
		quantC = new JTextField();
		quantC.setColumns(10);
		quantC.setBounds(894, 328, 54, 21);
		contentPane.add(quantC);
		
		quantR = new JTextField();
		quantR.setColumns(10);
		quantR.setBounds(894, 353, 54, 21);
		contentPane.add(quantR);
		
		quantCon = new JTextField();
		quantCon.setColumns(10);
		quantCon.setBounds(894, 378, 54, 21);
		contentPane.add(quantCon);
		
		quantF = new JTextField();
		quantF.setColumns(10);
		quantF.setBounds(894, 403, 54, 21);
		contentPane.add(quantF);
		
		quantA = new JTextField();
		quantA.setColumns(10);
		quantA.setBounds(894, 428, 54, 21);
		contentPane.add(quantA);
		
		quantO = new JTextField();
		quantO.setColumns(10);
		quantO.setBounds(894, 453, 54, 21);
		contentPane.add(quantO);
		
		quantM = new JTextField();
		quantM.setColumns(10);
		quantM.setBounds(894, 478, 54, 21);
		contentPane.add(quantM);
		
		JLabel lblNewLabel_3_1 = new JLabel("Quantidade");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic Light", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(343, 288, 105, 29);
		contentPane.add(lblNewLabel_3_1);
		
		massaC = new JTextField();
		massaC.setColumns(10);
		massaC.setBounds(343, 328, 54, 21);
		contentPane.add(massaC);
		
		massaR = new JTextField();
		massaR.setColumns(10);
		massaR.setBounds(343, 353, 54, 21);
		contentPane.add(massaR);
		
		massaCon = new JTextField();
		massaCon.setColumns(10);
		massaCon.setBounds(343, 378, 54, 21);
		contentPane.add(massaCon);
		
		massaF = new JTextField();
		massaF.setColumns(10);
		massaF.setBounds(343, 403, 54, 21);
		contentPane.add(massaF);
		
		massaA = new JTextField();
		massaA.setColumns(10);
		massaA.setBounds(343, 428, 54, 21);
		contentPane.add(massaA);
		
		massaO = new JTextField();
		massaO.setColumns(10);
		massaO.setBounds(343, 453, 54, 21);
		contentPane.add(massaO);
		
		massaM = new JTextField();
		massaM.setColumns(10);
		massaM.setBounds(343, 478, 54, 21);
		contentPane.add(massaM);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //volta pra tela inicial
				dispose();
				Tela t = new Tela();
				t.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		btnNewButton_1.setBounds(683, 518, 114, 32);
		contentPane.add(btnNewButton_1);
	}
}
