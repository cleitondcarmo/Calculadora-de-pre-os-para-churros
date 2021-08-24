package Model;

public class GastoMensal {
	private double Energia;
	private double Combustivel;
	private double Gas;
	private double MaterialLimpeza;
	private double embalagem;
	private double EnergiaUni;
	private double CombustivelUni;
	private double GasUni;
	private double MaterialUni;
	private double EmbalagemUni;
	private int mediachurros;
	private double lucro;
	private double soma;
	private Churros churros;
	private Funcionarios funcionarios;
	private Gerente gerente;
	

	public GastoMensal(double energia, double combustivel, double gas, double materiallimpeza, double embalagem, double energiauni, double combustiveluni, double gasuni,
	double materialuni, Double embalagemuni, int mediachurros, double lucro){
		this.Combustivel = combustivel;
		this.Energia = energia;
		this.Gas = gas;
		this.MaterialLimpeza = materiallimpeza;
		this.embalagem = embalagem;
		this.lucro = lucro;
		this.mediachurros = mediachurros;
		this.EnergiaUni = energiauni;
		this.CombustivelUni = combustiveluni;
		this.GasUni = gasuni;
		this.MaterialUni = materialuni;
		this.EmbalagemUni = embalagemuni;
	}	

	public GastoMensal(double energia, double combustivel, double gas, double materiallimpeza, double embalagem, double energiauni, double combustiveluni, double gasuni,
			double materialuni, Double embalagemuni, int mediachurros, double lucro, Churros churros, Funcionarios funcionarios, Gerente gerente) {
		this.Combustivel = combustivel;
		this.Energia = energia;
		this.Gas = gas;
		this.MaterialLimpeza = materiallimpeza;
		this.embalagem = embalagem;
		this.lucro = lucro;
		this.mediachurros = mediachurros;
		this.EnergiaUni = energiauni;
		this.CombustivelUni = combustiveluni;
		this.GasUni = gasuni;
		this.MaterialUni = materialuni;
		this.EmbalagemUni = embalagemuni;
		this.churros = churros;
		this.funcionarios = funcionarios;
		this.gerente = gerente;
	}
	public GastoMensal() {
		
	}
	public double getEnergiaUni() {
		return EnergiaUni;
	}

	public void setEnergiaUni(double energiaUni) {
		this.EnergiaUni = energiaUni;
	}

	public double getCombustivelUni() {
		return CombustivelUni;
	}
	
	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public void setFuncionarios(Funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void setCombustivelUni(double combustivelUni) {
		this.CombustivelUni = combustivelUni;
	}

	public double getGasUni() {
		return GasUni;
	}

	public void setGasUni(double gasUni) {
		this.GasUni = gasUni;
	}

	public double getMaterialUni() {
		return MaterialUni;
	}

	public void setMaterialUni(double materialUni) {
		this.MaterialUni = materialUni;
	}

	public double getEmbalagemUni() {
		return EmbalagemUni;
	}

	public void setEmbalagemUni(double embalagemUni) {
		this.EmbalagemUni = embalagemUni;
	}

	public double getLucro() {
		return lucro;
	}

	public void setLucro(double lucro) {
		this.lucro = lucro;
	}
	
	public double getEmbalagem() {
		return embalagem;
	}
	public void setEmbalagem(double embalagem) {
		this.embalagem = embalagem;
	}

	public double getMaterialLimpeza() {
		return MaterialLimpeza;
	}

	public void setMaterialLimpeza(double materialLimpeza) {
		this.MaterialLimpeza = materialLimpeza;
	}
	
	public void setFuncionario(Funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionarios getFuncionarios() {
		return funcionarios;
	}

	public Churros getChurros() {
		return churros;
	}

	public void setChurros(Churros churros) {
		this.churros = churros;
	}

	public double getEnergia() {
		return Energia;
	}

	public void setEnergia(double energia) {
		this.Energia = energia;
	}

	public double getCombustivel() {
		return Combustivel;
	}

	public void setCombustivel(double combustivel) {
		this.Combustivel = combustivel;
	}

	public double getGas() {
		return Gas;
	}

	public void setGas(double gas) {
		this.Gas = gas;
	}	
	
	public int getMediachurros() {
		return mediachurros;
	}

	public void setMediachurros(int mediachurros) {
		this.mediachurros = mediachurros;
	}

	public double CalculoGM(GastoMensal gm) { //calcula o gasto mensal total por churros
		soma = this.EnergiaUni + this.CombustivelUni + this.GasUni + this.MaterialUni + this.EmbalagemUni;
		return soma;
	}
	public double CalculoGeral(Churros churros, GastoMensal gm) { //calcula o gasto mensal total + o total de ingredientes por churros
		soma = this.EnergiaUni + this.CombustivelUni + this.GasUni + this.MaterialUni + this.EmbalagemUni + churros.Calcular();
		return soma;
	}
}
