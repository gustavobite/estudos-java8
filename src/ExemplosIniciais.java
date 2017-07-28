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
 */
	public static void main(String[] args) {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(new Disciplina("Ciências", 40));
		disciplinas.add(new Disciplina("Física", 30));
		disciplinas.add(new Disciplina("Informática", 35));
		disciplinas.add(new Disciplina("Geografia", 32));
		disciplinas.add(new Disciplina("Portugês", 40));
		disciplinas.add(new Disciplina("Matemática", 40));
		
		ordenaPelaQtdAlunos(disciplinas);
		imprimeDisciplinasComQtdAlunosSuperior35(disciplinas);
		imprimeQtdAlunosDasDisciplinasComQtdAlunosSuperior35(disciplinas);
		imprimeSomaQtdAlunosDasDisciplinasComQtdAlunosSuperior35(disciplinas);
		
	
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
