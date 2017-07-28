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
 * Anotações
 * 
 * -= Dica (1) =-
 * - Ficar atento com auto-boxing no uso dos métodos do Java 8.
 * Por exemplo, caso tenha certeza que sempre será um inteiro(primitivo) a ser comparado na qtdAlunos
 * poderia então, utilizar:
 * Comparator.comparingInt(Disciplina::getQtdAlunos)
 * ao invés de
 * Comparator.comparing(Disciplina::getQtdAlunos)
 * -------------------------------------------------------------------
 * 
 * 1) Operações Stream intermediárias

filter : Resulta em um fluxo contendo apenas os elementos que atendem uma condição.
distinct : Resulta em um fluxo que contém somente os elementos únicos.
limit : Resulta em um fluxo com o número especificado de elementos a partir do início do fluxo original.
map : Resulta em um fluxo em que cada elemento do fluxo original é mapeado para um novo valor.
sorted : Resulta em um fluxo em que os elementos estão em ordem classificada. O novo fluxo tem o mesmo número de elementos que o fluxo original.

2) Operações Stream terminais

forEach : Realiza o processamento em cada elemento em um fluxo (por exemplo, exibir cada elemento).

2.1) Operações de redução - recebem todos os valores no fluxo e retornam um único valor

average : Calcula a média dos elementos em um fluxo numérico.
count : Retorna o número de elemen
 * 
 */
	public static void main(String[] args) {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(new Disciplina("Ciências", 40));
		disciplinas.add(new Disciplina("Física", 30));
		disciplinas.add(new Disciplina("Informática", 35));
		disciplinas.add(new Disciplina("Geografia", 32));
		disciplinas.add(new Disciplina("Portugês", 40));
		disciplinas.add(new Disciplina("Matemática", 40));
		
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

	// Método apenas para exemplificar uso de distinct
	// Neste caso, imprimirá os resultados de forma unificada (sem repetição) baseando-se no map(getQtdAlunos)
	private static void aplicandoDistinct(List<Disciplina> disciplinas) {
		disciplinas.stream()
			.filter(d -> d.getQtdAlunos() >= 35)
			.map(Disciplina::getQtdAlunos)
			.distinct()
			.forEach(System.out::println);
	}

	//Problemática: Dado as disciplinas que possuem mais que 35 alunos, quero a soma dessa quantidade de alunos das disciplinas filtradas.
	private static void imprimeSomaQtdAlunosDasDisciplinasComQtdAlunosSuperior35(List<Disciplina> disciplinas) {
		int sum = disciplinas.stream()
				.filter(d -> d.getQtdAlunos() >= 35)
				.mapToInt(Disciplina::getQtdAlunos)
				.sum();
		System.out.println(sum);
	}

	//Problemática: Dado de entrada as disciplinas que possuem mais que 35 alunos, quero a relação dessa quantidade de alunos de cada disciplina que será filtrada.
	//Dica: No "map" e "forEach" estou utilizando method references pq existe essa possibilidade.
	//No filter não é possível utilizar method references, pois é manipulado um outro dado em conjunto.
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
