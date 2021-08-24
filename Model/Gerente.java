package Model;

public class Gerente extends Funcionarios {
	private double bonus;
	
	public Gerente(String nome, double salario) {	
		super(nome, salario);
	}
	
	public double calcularbonus(Gerente gerente) { //calcula o bonus do gerente
		bonus = ((this.getSalario() * 10) / 100);
		bonus = bonus + this.getSalario();		
		return bonus;	
	}
}
