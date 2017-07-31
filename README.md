# estudos-java8
Códigos para prática desenvolvimento Java

------ Visão geral sobre Programação Funcional no Java------

- Antes do Java SE 8, o Java suportava três paradigmas de programação — programação procedural, programação orientada a objetos e programação
genérica. O Java SE 8 acrescenta a programação funcional.
- Antes da programação funcional, você normalmente determinava o que queria alcançar e, então, especificava os passos precisos para realizar
essa tarefa.
- Usar um loop para iterar por uma coleção de elementos é conhecido como iteração externa e requer acesso sequencial aos elementos. Essa
iteração também requer variáveis mutáveis.
- Na programação funcional, você especifica o que quer alcançar em uma tarefa, mas não como realizar isso.
- Deixar a biblioteca determinar como iterar por uma coleção de elementos é conhecido como iteração interna. A iteração interna é mais fácil de
paralelizar.
- A programação funcional focaliza a imutabilidade — não modifica a origem de dados que é processada ou qualquer outro estado do programa.

------ Anotações ------

-= Dica (1) =-
- Ficar atento com auto-boxing no uso dos métodos do Java 8.
	Por exemplo, caso tenha certeza que sempre será um inteiro(primitivo) a ser comparado na qtdAlunos poderia então, utilizar:
		Comparator.comparingInt(Disciplina::getQtdAlunos)
	ao invés de
		Comparator.comparing(Disciplina::getQtdAlunos)

-= Dica (2) =-		
- Você pode criar suas próprias interfaces funcionais garantindo que cada uma contenha um único método abstract e zero ou
mais métodos default ou static. Embora não seja necessário, você pode declarar que uma interface é funcional precedendo-a
com a anotação @FunctionalInterface. O compilador então garantirá que a interface contém um único método abstract; caso
contrário, ele vai gerar um erro de compilação.


------ Resumo dos estudos (Java 8) ------

1) Operações intermediárias - Stream

filter 		: Resulta em um Stream contendo apenas os elementos que atendem uma condição.
distinct 	: Resulta em um Stream que contém somente os elementos únicos.
limit 		: Resulta em um Stream com o número especificado de elementos a partir do início do stream original.
map 		: Resulta em um Stream em que cada elemento do Stream original é mapeado para um novo valor.
sorted 		: Resulta em um Stream em que os elementos estão em ordem classificada. O novo Stream tem o mesmo número de elementos que o Stream original.

2) Operações terminais - Stream

forEach 	: Realiza o processamento em cada elemento em um Stream (por exemplo, exibir cada elemento).

2.1) Operações de redução - recebem todos os valores de um Stream e retornam um único valor

average 	: Calcula a média dos elementos em um Stream numérico.
count 		: Retorna o número de elementos em Stream.
max 		: Localiza o maior valor em um Stream numérico.
min 		: Localiza o menor valor em um Stream numérico
reduce 		: Reduz os elementos de uma coleção a um único valor usando uma função de acumulação associativa 

2.2) Operações de redução mutáveis (como uma Collection ou um StringBuilder)

collect 	: Cria uma nova coleção dos elementos contendo os resultados das operações anteriores do Stream.
toArray 	: Cria um array contendo os resultados das operações anteriores do Stream.

3) Operações de pesquisa

findFirst	: Localiza o primeiro elemento no Stream com base nas operações intermediárias realizadas.
findAny 	: Localiza qualquer elemento no Stream com base nas operações intermediárias realizadas.
anyMatch	: Determina se quaisquer elementos no fluxo correspondem a uma condição especificada.
allMatch	: Determina se todos os elementos no fluxo correspondem a uma condição especificada.

Para uma aprimoração no conteúdo, recomendo fazer o curso da ALURA e fazer uma leitura complementar no livro dos Deitel.
Referência bibliográfica:
- Curso ALURA: https://cursos.alura.com.br/course/java8-lambdas
- Java: como programar / Paul Deitel, Harvey Deitel; tradução Edson
Furmankiewicz; revisão técnica Fabio Lucchini. -- São Paulo: Pearson
Education do Brasil, 2017.

<script src="https://gist.github.com/gustavobite/3e1eff20ba93ec51416ea43ba263bb52.js"></script>
