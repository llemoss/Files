class Aluno{
	String nome;
	int matricula;
	int idade;
	String curso;

	public String toString(){
		return "Aluno: " + nome + "Matricula: " + matricula + "Idade: " + idade + "Curso: " + curso; 
	}
}

class TestaAluno{
	public static void main(String[] args){
		Aluno aluno = new Aluno();
		aluno.nome = "Rogerio da Silva";
		System.out.println(aluno);
	}
}