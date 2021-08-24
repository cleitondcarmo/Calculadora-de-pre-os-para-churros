package Model;

public class Funcionarios {
	private String nome;
	private double Salario;
	private double bonus;

	public Funcionarios(String nome, double salario) {
		this.nome = nome;
		this.Salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return Salario;
	}

	public void setSalario(double salario) {
		Salario = salario;
	}
	
	public double calcularbonus(Funcionarios funcionario) { //calcula o bonus do funcionario
		bonus = ((this.Salario * 5) / 100);
		bonus = bonus + this.Salario;		
		return bonus;	
	}
}


