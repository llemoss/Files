public class Boneco {

	private String estrutura = "\n";
	
	public void removerParte(int vida){
		if (vida == 6){this.estrutura = "\n";}
		else if (vida == 5){this.estrutura = "  O";}
		else if (vida == 4){this.estrutura = "  O\n /\n";}
		else if (vida == 3){this.estrutura = "  O\n /|\n";}
		else if (vida == 2){this.estrutura = "  O\n /|\\";}
		else if (vida == 1){this.estrutura = "  O\n /|\\ \n / \n";}
	}
	
	public String mostrar(){
		return estrutura;
	}
	
}
