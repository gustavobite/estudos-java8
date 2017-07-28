import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Disciplina {
	
	private String nome;
	private int qtdAlunos;
	
	public Disciplina(String nome, int qtdAlunos) {
		this.nome = nome;
		this.qtdAlunos = qtdAlunos;
	}
	
	public String getNome() {
		return nome;
	}
	public int getQtdAlunos() {
		return qtdAlunos;
	}
	
}

public class ExemplosIniciais {

/**
 * Anota��es
 * 
 * -= Dica (1) =-
 * - Ficar atento com auto-boxing no uso dos m�todos do Java 8.
 * Por exemplo, caso tenha certeza que sempre ser� um inteiro(primitivo) a ser comparado na qtdAlunos
 * poderia ent�o, utilizar:
 * Comparator.comparingInt(Disciplina::getQtdAlunos)
 * ao inv�s de
 * Comparator.comparing(Disciplina::getQtdAlunos)
 * -------------------------------------------------------------------
 * 
 * 1) Opera��es Stream intermedi�rias

filter : Resulta em um fluxo contendo apenas os elementos que atendem uma condi��o.
distinct : Resulta em um fluxo que cont�m somente os elementos �nicos.
limit : Resulta em um fluxo com o n�mero especificado de elementos a partir do in�cio do fluxo original.
map : Resulta em um fluxo em que cada elemento do fluxo original � mapeado para um novo valor.
sorted : Resulta em um fluxo em que os elementos est�o em ordem classificada. O novo fluxo tem o mesmo n�mero de elementos que o fluxo original.

2) Opera��es Stream terminais

forEach : Realiza o processamento em cada elemento em um fluxo (por exemplo, exibir cada elemento).

2.1) Opera��es de redu��o - recebem todos os valores no fluxo e retornam um �nico valor

average : Calcula a m�dia dos elementos em um fluxo num�rico.
count : Retorna o n�mero de elemen
 * 
 */
	public static void main(String[] args) {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(new Disciplina("Ci�ncias", 40));
		disciplinas.add(new Disciplina("F�sica", 30));
		disciplinas.add(new Disciplina("Inform�tica", 35));
		disciplinas.add(new Disciplina("Geografia", 32));
		disciplinas.add(new Disciplina("Portug�s", 40));
		disciplinas.add(new Disciplina("Matem�tica", 40));
		
		//ordenaPelaQtdAlunos(disciplinas);
		//imprimeDisciplinasComQtdAlunosSuperior35(disciplinas);
		//imprimeQtdAlunosDasDisciplinasComQtdAlunosSuperior35(disciplinas);
		//imprimeSomaQtdAlunosDasDisciplinasComQtdAlunosSuperior35(disciplinas);
		//aplicandoDistinct(disciplinas);
		
		disciplinas.stream()
		.filter(d -> d.getQtdAlunos() >= 35)
		.map(Disciplina::getQtdAlunos)
		.limit(1).forEach(System.out::println);;
	
	}

	// M�todo apenas para exemplificar uso de distinct
	// Neste caso, imprimir� os resultados de forma unificada (sem repeti��o) baseando-se no map(getQtdAlunos)
	private static void aplicandoDistinct(List<Disciplina> disciplinas) {
		disciplinas.stream()
			.filter(d -> d.getQtdAlunos() >= 35)
			.map(Disciplina::getQtdAlunos)
			.distinct()
			.forEach(System.out::println);
	}

	//Problem�tica: Dado as disciplinas que possuem mais que 35 alunos, quero a soma dessa quantidade de alunos das disciplinas filtradas.
	private static void imprimeSomaQtdAlunosDasDisciplinasComQtdAlunosSuperior35(List<Disciplina> disciplinas) {
		int sum = disciplinas.stream()
				.filter(d -> d.getQtdAlunos() >= 35)
				.mapToInt(Disciplina::getQtdAlunos)
				.sum();
		System.out.println(sum);
	}

	//Problem�tica: Dado de entrada as disciplinas que possuem mais que 35 alunos, quero a rela��o dessa quantidade de alunos de cada disciplina que ser� filtrada.
	//Dica: No "map" e "forEach" estou utilizando method references pq existe essa possibilidade.
	//No filter n�o � poss�vel utilizar method references, pois � manipulado um outro dado em conjunto.
	private static void imprimeQtdAlunosDasDisciplinasComQtdAlunosSuperior35(List<Disciplina> disciplinas) {
		disciplinas.stream()
				.filter(d -> d.getQtdAlunos() >= 35)
				.map(Disciplina::getQtdAlunos)
				.forEach(System.out::println);
	}

	//Imprime todas disciplinas que possuam mais de 35 alunos.
	private static void imprimeDisciplinasComQtdAlunosSuperior35(List<Disciplina> disciplinas) {
		disciplinas.stream()
				.filter(d -> d.getQtdAlunos() >= 35)
				.forEach(d -> System.out.println(d.getNome()));
	}

	//Imprime disciplinas ordenadas pela quantidade de alunos.
	private static void ordenaPelaQtdAlunos(List<Disciplina> disciplinas) {
		disciplinas.sort(Comparator.comparing(Disciplina::getQtdAlunos));
		disciplinas.forEach(d -> System.out.println(d.getNome()));
	}

}
