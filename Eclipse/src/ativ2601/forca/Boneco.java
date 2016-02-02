package ativ2601.forca;

public class Boneco {

	private String estrutura = "\n";
	private int vida = 6;
	private boolean dead = false;
	
	public void removerParte(){
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
	
	public void setVida(int vida){
		this.vida = vida;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	
	
}
