package main;
import java.util.Random;
import java.util.Scanner;

class Rolls{
	public int roll_4d5(){
		int[] rolls = new int[4]; 
		int men = 0;
		int sum = 0;
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			rolls[i] = random.nextInt(6);
			if (i == 0) {
				men = rolls[i];
			}else {
				if (men > rolls[i]) {				
					men = rolls[i];				
				}
			}
			sum += rolls[i];
		}
		return (sum - men);	
	}
}

class Job{	
	 String nome;
	 String[] backpack = new String[20];
	 public void mostrar_items() {
		 System.out.println("Backpack/ ");
		 for (String item : backpack) {
			 if (item == null) {
				  break;
			 }
			 System.out.println(item);
		 }
	 }
}

class Fighter extends Job{
	public Fighter() {
		nome = "Fighter";
		backpack[0] = "Espada";
		backpack[1] = "Escudo";
	}
}

class Wizard extends Job{
	public Wizard(){
		nome = "Wizard";
		backpack[0] = "Cajado";
		backpack[1] = "Grimório";
	}
}

class Personagem{
	Rolls rolls = new Rolls();
	String nome;
	String race;
	String[] stats = {"força","destreza","constituição","inteligência","sabedoria","carisma"};
	Job job;
	int[] stats_number = {rolls.roll_4d5(),rolls.roll_4d5(),rolls.roll_4d5(),rolls.roll_4d5(),rolls.roll_4d5(),rolls.roll_4d5(),};
	public void Select_job(String job_name) {
		if (job_name.equals("Fighter")) {
			this.job = new Fighter();
		}else if (job_name.equals("Wizard")) {
			this.job = new Wizard();
		}else {
			System.out.println("Classe inesistente");
		} 
	}
	public void Modify_stats(String stats_name,int Value) {
		int a = 0;
		for (String stat : this.stats) {
			if (stat == stats_name) {
				this.stats_number[a] += Value;
				break;
			}
			a++;
		}
	}
	public void Mostrar_ficha() {
		System.out.println("Ficha/");
		System.out.print("Nome: ");
		System.out.println(this.nome);
		System.out.print("Job: ");
		System.out.println(this.job.nome);
		System.out.print("Race: ");
		System.out.println(this.race);
		System.out.println("Sheets:");
		for (int a = 0; a < 6;a++) {
			System.out.print(this.stats[a] + ": ");
			System.out.println(this.stats_number[a]);
		}
		this.job.mostrar_items();
	}
}

class Elfo extends Personagem{
	public Elfo(String player_name,String Job_name) {
		nome = player_name;
		Select_job(Job_name);
		race = "Elfo";
		Modify_stats("inteligência",2);
		Modify_stats("destreza",2);
	}
}

class Humano extends Personagem{
	public Humano(String player_name,String Job_name) {
		nome = player_name;
		Select_job(Job_name);
		race = "Humano";
		Modify_stats("força",2);
		Modify_stats("destreza",3);
	}
}

public class main{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter your name: ");
	    String name = scanner.nextLine();
	    System.out.println("Enter your race: ");
	    String race = scanner.nextLine();
	    if (race.equals("Elfo")) {
	    	System.out.print("Enter your Job: ");
		    String job = scanner.nextLine();
		    Elfo player = new Elfo(name,job);
		    player.Mostrar_ficha();
	    
	    }else if (race.equals("Humano")) {
	    	System.out.print("Enter your Job: ");
		    String job = scanner.nextLine();
		    Humano player = new Humano(name,job);
		    player.Mostrar_ficha();
	    }
	}	
}