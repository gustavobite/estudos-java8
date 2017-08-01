import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

// Classe para ver detalhes da API de datas criada no Java 8
public class Datas {

	public static void main(String[] args) {
		
		// Toda a API de data é imutável, ou seja, sempre que for manipular, atribua o resultado a uma nova variável.
		
		LocalDate hoje = LocalDate.now();
		System.out.println("Hoje: " + hoje);
		System.out.println("------------------------");
		
		LocalDate meuNascimento = LocalDate.of(1991, 10, 21);
		Period periodo = Period.between(meuNascimento, hoje);
		System.out.println("Quantidade de anos que passou: " + periodo.getYears());
		System.out.println("------------------------");
		
		LocalDate diaSemanaCaiMeuAniversario = LocalDate.of(hoje.getYear(), 10, 21);
		System.out.println(diaSemanaCaiMeuAniversario.getDayOfWeek());
		System.out.println("------------------------");
		
		//Formatando uma data
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = diaSemanaCaiMeuAniversario.format(dateTimeFormatter);
		System.out.println(valorFormatado);
		System.out.println("------------------------");
	}
}
