package teste2;

import java.util.Scanner;

class Cargo{
	String NomeDoCargo;
	String Açao;
	int Salario;
}


class Dados{
	String nome;
}

class Funcionario{
	Dados dados_do_funcionario = new Dados();
	Cargo cargo = new Cargo();
	public void Mostrar_Informaçoes() {
		System.out.println(dados_do_funcionario.nome);
		System.out.println(cargo.NomeDoCargo);
		System.out.println(cargo.Salario);
	}
	public void Agir(){
		System.out.println(cargo.Açao);
	}
	
}

class Gerente extends Cargo{
	public Gerente() {
		NomeDoCargo = "Gerente";
		Salario = 8000;
		Açao = "Gerenciando";
	}
}
class Vendedor extends Cargo{
	public Vendedor(){
		NomeDoCargo = "Vendedor";
		Salario = 1500;
		Açao = "Vendendo";
	}
}



public class Main {
	public Funcionario CadastrarFuncionario(String nome, String cargo) {
		Funcionario funcionario = new Funcionario();
		System.out.println(nome);
		funcionario.dados_do_funcionario.nome = nome;
		if (cargo.equals("Gerente")){
			funcionario.cargo = new Gerente();
		}else if (cargo.equals("Vendedor")) {
			funcionario.cargo = new Vendedor();
		}
		return funcionario;
	}
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario();
		Main main = new Main();		
		Scanner scanner = new Scanner(System.in);
		String decisao;
		while(true) {
			System.out.println("Bem vindo ao sistema\nO que Deseja?\n[a] Cadastro de Funcionário \n[b] Login \n[c] Sair");
			decisao = scanner.nextLine();
			if (decisao.equals("a")) {
				System.out.println("Digite seu nome: ");
			    String nome = scanner.nextLine();
			    
			    System.out.println("\nDigite o seu cargo: ");
			    String cargo = scanner.nextLine();
			    funcionario = main.CadastrarFuncionario(nome, cargo);
			}else if(decisao.equals("b")) {
				System.out.println("Bem vindo " + funcionario.dados_do_funcionario.nome);
				System.out.println("Bem vindo ao sistema\nO que Deseja?\n[a] Ação \n[b] Sair");
				decisao = scanner.nextLine();
				if (decisao.equals("a")){
					funcionario.Agir();
				}else if (decisao.equals("b")) {
					System.out.println("Saindo");
				}
			}else if(decisao.equals("c")) {
				break;
			}
			
		}
	}
}
