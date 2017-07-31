import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Disciplina {
	
	private String nome;
	private int qtdAlunos;
	private String categoria;
	
	public Disciplina(String nome, int qtdAlunos, String categoria) {
		this.nome = nome;
		this.qtdAlunos = qtdAlunos;
		this.categoria = categoria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getQtdAlunos() {
		return qtdAlunos;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
}

public class ExemplosIniciais {

	public static void main(String[] args) {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(new Disciplina("Ciências", 40, "Meio ambiente"));
		disciplinas.add(new Disciplina("Física", 30, "Meio ambiente"));
		disciplinas.add(new Disciplina("Informática", 35, "TI"));
		disciplinas.add(new Disciplina("Geografia", 32, "Meio ambiente"));
		disciplinas.add(new Disciplina("Portugês", 40, "Linguística"));
		disciplinas.add(new Disciplina("Matemática", 40, "Exatas"));
		
		ordenaPelaQtdAlunos(disciplinas);
		System.out.println("------------------------");
		imprimeDisciplinasComQtdAlunosSuperior35(disciplinas);
		System.out.println("------------------------");
		imprimeQtdAlunosDasDisciplinasComQtdAlunosSuperior35(disciplinas);
		System.out.println("------------------------");
		imprimeSomaQtdAlunosDasDisciplinasComQtdAlunosSuperior35(disciplinas);
		System.out.println("------------------------");
		aplicandoDistinct(disciplinas);
		System.out.println("------------------------");
		criaNovaListaUtilizandoCollectors(disciplinas);
		System.out.println("------------------------");
		agrupaDisciplinasPorCategoria(disciplinas);
		System.out.println("------------------------");
	}

	//Agrupa disciplinas por categoria e imprime-os
	private static void agrupaDisciplinasPorCategoria(List<Disciplina> disciplinas) {
		Map<String, List<Disciplina>> groupedByCategoria = 
				disciplinas.stream()
					.collect(Collectors.groupingBy(Disciplina::getCategoria));
		
		groupedByCategoria.forEach(
				(categoria, disciplinasDaCategoria) -> 
					{
						System.out.println(categoria);
						disciplinasDaCategoria.forEach(disciplina -> System.out.printf(" %s%n", disciplina.getNome()));
					}
				);
	}

	private static void criaNovaListaUtilizandoCollectors(List<Disciplina> disciplinas) {
		List<String> nomes = disciplinas.stream()
			.filter(d -> d.getQtdAlunos() >= 35)
			.map(Disciplina::getNome)
			.collect(Collectors.toList());
		
		nomes.forEach(System.out::println);
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
