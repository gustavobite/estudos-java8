# estudos-java8
C�digos para pr�tica desenvolvimento Java

------ Vis�o geral sobre Programa��o Funcional no Java------

- Antes do Java SE 8, o Java suportava tr�s paradigmas de programa��o � programa��o procedural, programa��o orientada a objetos e programa��o
gen�rica. O Java SE 8 acrescenta a programa��o funcional.
- Antes da programa��o funcional, voc� normalmente determinava o que queria alcan�ar e, ent�o, especificava os passos precisos para realizar
essa tarefa.
- Usar um loop para iterar por uma cole��o de elementos � conhecido como itera��o externa e requer acesso sequencial aos elementos. Essa
itera��o tamb�m requer vari�veis mut�veis.
- Na programa��o funcional, voc� especifica o que quer alcan�ar em uma tarefa, mas n�o como realizar isso.
- Deixar a biblioteca determinar como iterar por uma cole��o de elementos � conhecido como itera��o interna. A itera��o interna � mais f�cil de
paralelizar.
- A programa��o funcional focaliza a imutabilidade � n�o modifica a origem de dados que � processada ou qualquer outro estado do programa.

------ Anota��es ------

-= Dica (1) =-
- Ficar atento com auto-boxing no uso dos m�todos do Java 8.
	Por exemplo, caso tenha certeza que sempre ser� um inteiro(primitivo) a ser comparado na qtdAlunos poderia ent�o, utilizar:
		Comparator.comparingInt(Disciplina::getQtdAlunos)
	ao inv�s de
		Comparator.comparing(Disciplina::getQtdAlunos)

-= Dica (2) =-		
- Voc� pode criar suas pr�prias interfaces funcionais garantindo que cada uma contenha um �nico m�todo abstract e zero ou
mais m�todos default ou static. Embora n�o seja necess�rio, voc� pode declarar que uma interface � funcional precedendo-a
com a anota��o @FunctionalInterface. O compilador ent�o garantir� que a interface cont�m um �nico m�todo abstract; caso
contr�rio, ele vai gerar um erro de compila��o.


------ Resumo dos estudos (Java 8) ------

1) Opera��es intermedi�rias - Stream

filter 		: Resulta em um Stream contendo apenas os elementos que atendem uma condi��o.
distinct 	: Resulta em um Stream que cont�m somente os elementos �nicos.
limit 		: Resulta em um Stream com o n�mero especificado de elementos a partir do in�cio do stream original.
map 		: Resulta em um Stream em que cada elemento do Stream original � mapeado para um novo valor.
sorted 		: Resulta em um Stream em que os elementos est�o em ordem classificada. O novo Stream tem o mesmo n�mero de elementos que o Stream original.

2) Opera��es terminais - Stream

forEach 	: Realiza o processamento em cada elemento em um Stream (por exemplo, exibir cada elemento).

2.1) Opera��es de redu��o - recebem todos os valores de um Stream e retornam um �nico valor

average 	: Calcula a m�dia dos elementos em um Stream num�rico.
count 		: Retorna o n�mero de elementos em Stream.
max 		: Localiza o maior valor em um Stream num�rico.
min 		: Localiza o menor valor em um Stream num�rico
reduce 		: Reduz os elementos de uma cole��o a um �nico valor usando uma fun��o de acumula��o associativa 

2.2) Opera��es de redu��o mut�veis (como uma Collection ou um StringBuilder)

collect 	: Cria uma nova cole��o dos elementos contendo os resultados das opera��es anteriores do Stream.
toArray 	: Cria um array contendo os resultados das opera��es anteriores do Stream.

3) Opera��es de pesquisa

findFirst	: Localiza o primeiro elemento no Stream com base nas opera��es intermedi�rias realizadas.
findAny 	: Localiza qualquer elemento no Stream com base nas opera��es intermedi�rias realizadas.
anyMatch	: Determina se quaisquer elementos no fluxo correspondem a uma condi��o especificada.
allMatch	: Determina se todos os elementos no fluxo correspondem a uma condi��o especificada.

Para uma aprimora��o no conte�do, recomendo fazer o curso da ALURA e fazer uma leitura complementar no livro dos Deitel.

Refer�ncia bibliogr�fica:
- Curso ALURA: https://cursos.alura.com.br/course/java8-lambdas
- Java: como programar / Paul Deitel, Harvey Deitel; tradu��o Edson
Furmankiewicz; revis�o t�cnica Fabio Lucchini. -- S�o Paulo: Pearson
Education do Brasil, 2017.