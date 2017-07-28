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
 * - Ficar atento com auto-boxing no uso dos m�todos do Java 8.
 * Por exemplo, caso tenhas certeza que sempre ser� um inteiro do tipo primitivo a ser comparado na qtdAlunos
 * poderia ent�o, utilizar:
 * Comparator.comparingInt(Disciplina::getQtdAlunos)
 * inv�s de
 * Comparator.comparing(Disciplina::getQtdAlunos)
 * -------------------------------------------------------------------
 * 
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
		
		//comparePelaQtdAlunos(disciplinas);
		//imprimeDisciplinasComQtdAlunosSuperior35(disciplinas);
		//imprimeQtdAlunosDasDisciplinasComQtdAlunosSuperior35(disciplinas);
		//imprimeSomaQtdAlunosDasDisciplinasComQtdAlunosSuperior35(disciplinas);
		
	
	}

	//Dado as disciplinas que possuem mais que 35 alunos, quero a soma dessa quantidade de alunos das disciplinas filtradas
	private static void imprimeSomaQtdAlunosDasDisciplinasComQtdAlunosSuperior35(List<Disciplina> disciplinas) {
		int sum = disciplinas.stream()
				.filter(d -> d.getQtdAlunos() >= 35)
				.mapToInt(Disciplina::getQtdAlunos)
				.sum();
		System.out.println(sum);
	}

	//Dado as disciplinas que possuem mais que 35 alunos, quero a rela��o dessa quantidade de alunos de cada disciplina
	//Utilizando method references pq � poss�vel
	//No filter n�o � poss�vel utilizar method references, pois � manipulado um outro dado.
	private static void imprimeQtdAlunosDasDisciplinasComQtdAlunosSuperior35(List<Disciplina> disciplinas) {
		disciplinas.stream()
				.filter(d -> d.getQtdAlunos() >= 35)
				.map(Disciplina::getQtdAlunos)
				.forEach(System.out::println);
	}

	//Imprimir todas disciplinas que tenham mais de 35 alunos
	private static void imprimeDisciplinasComQtdAlunosSuperior35(List<Disciplina> disciplinas) {
		disciplinas.stream()
				.filter(d -> d.getQtdAlunos() >= 35)
				.forEach(d -> System.out.println(d.getNome()));
	}

	//Imprime disciplinas ordenadas pela quantidade de alunos
	private static void comparePelaQtdAlunos(List<Disciplina> disciplinas) {
		disciplinas.sort(Comparator.comparing(Disciplina::getQtdAlunos));
		disciplinas.forEach(d -> System.out.println(d.getNome()));
	}

}