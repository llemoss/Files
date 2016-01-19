package caelum;
//Questao 6:
class Data {
	private int dia;
	private int mes;
	private int ano;

	public void setData(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public String toString(){ //Questao 7 e 9: Mesmo caso, usei logo o toString ao inves do "formatada()" da apostila
		return dia + "/" + mes + "/" + ano;
		}
}