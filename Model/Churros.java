package Model;

public class Churros {
	private String nome;
	private int numero;
	private double PrecoCobertura;
	private double PrecoConfeito;
	private double PrecoRecheio;
	private double PrecoFarinha;
	private double PrecoManteiga;
	private double PrecoOleo;
	private double PrecoAcucar;
	private double ConfeitoUni;
	private double RecheioUni;
	private double CoberturaUni;
	private double OleoUni;
	private double AcucarUni;
	private double ManteigaUni;
	private double FarinhaUni;
	
	
	public Churros() {

	}
	
	public Churros(String nome, int numero, double PrecoCobertura, double PrecoConfeito, double PrecoRecheio, double PrecoManteiga, double PrecoOleo, double PrecoAcucar,
				   double ConfeitoUni, double RecheioUni, double CoberturaUni, double OleoUni, double AcucarUni, double ManteigaUni, double FarinhaUni) {
		this.nome = nome;
		this.numero = numero;
		this.PrecoCobertura = PrecoCobertura;
		this.PrecoConfeito = PrecoConfeito;
		this.PrecoRecheio = PrecoRecheio;
		this.PrecoManteiga = PrecoManteiga;
		this.PrecoOleo = PrecoOleo;
		this.PrecoAcucar = PrecoAcucar;
		this.ConfeitoUni = ConfeitoUni;
		this.RecheioUni = RecheioUni;
		this.CoberturaUni = CoberturaUni;
		this.OleoUni = OleoUni;
		this.AcucarUni = AcucarUni;
		this.ManteigaUni = ManteigaUni;
		this.FarinhaUni = FarinhaUni;
	}
	
	public double getFarinhaUni() {
		return FarinhaUni;
	}

	public void setFarinhaUni(double farinhaUni) {
		this.FarinhaUni = farinhaUni;
	}

	public double getRecheioUni() {
		return RecheioUni;
	}

	public void setRecheioUni(double recheioUni) {
		this.RecheioUni = recheioUni;
	}

	public double getCoberturaUni() {
		return CoberturaUni;
	}

	public void setCoberturaUni(double coberturaUni) {
		this.CoberturaUni = coberturaUni;
	}

	public double getOleoUni() {
		return OleoUni;
	}

	public void setOleoUni(double oleoUni) {
		this.OleoUni = oleoUni;
	}

	public double getAcucarUni() {
		return AcucarUni;
	}

	public void setAcucarUni(double acucarUni) {
		this.AcucarUni = acucarUni;
	}

	public double getManteigaUni() {
		return ManteigaUni;
	}

	public void setManteigaUni(double manteigaUni) {
		this.ManteigaUni = manteigaUni;
	}

	public double getConfeitoUni() {
		return ConfeitoUni;
	}

	public void setConfeitoUni(double confeitoUni) {
		this.ConfeitoUni = confeitoUni;
	}

	public double getPrecoFarinha() {
		return PrecoFarinha;
	}

	public void setPrecoFarinha(double precoFarinha) {
		this.PrecoFarinha = precoFarinha;
	}

	public double getPrecoManteiga() {
		return PrecoManteiga;
	}

	public void setPrecoManteiga(double precoManteiga) {
		this.PrecoManteiga = precoManteiga;
	}

	public double getPrecoOleo() {
		return PrecoOleo;
	}

	public void setPrecoOleo(double precoOleo) {
		this.PrecoOleo = precoOleo;
	}

	public double getPrecoAcucar() {
		return PrecoAcucar;
	}

	public void setPrecoAcucar(double precoAcucar) {
		this.PrecoAcucar = precoAcucar;
	}

	public double getPrecoCobertura() {
		return PrecoCobertura;
	}

	public void setPrecoCobertura(double PrecoCobertura) {
		this.PrecoCobertura = PrecoCobertura;
	}

	public double getPrecoConfeito() {
		return PrecoConfeito;
	}

	public void setPrecoConfeito(double PrecoConfeito) {
		this.PrecoConfeito = PrecoConfeito;
	}

	public double getPrecoRecheio() {
		return PrecoRecheio;
	}

	public void setPrecoRecheio(double PrecoRecheio) {
		this.PrecoRecheio = PrecoRecheio;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;	
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public double Calcular() {	//calcula o preço total dos ingredientes por cada churros
		double soma = this.AcucarUni + this.ConfeitoUni + this.FarinhaUni + this.ManteigaUni + this.OleoUni + this.CoberturaUni + this.RecheioUni;
		return soma;
	}
}
