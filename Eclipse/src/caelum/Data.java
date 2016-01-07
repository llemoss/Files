package caelum;
//Questao 6:
class Data {
	private int dia;
	private int mes;
	private int ano;

	public setData(dia, mes, ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public String toString(){ //Questao 7 e 9: Mesmo caso, usei logo o toString ao inves do "formatada()" da apostila
		return dia + "/" + mes + "/" + ano;
		}
}