# Projeto-PPS
Projeto IFPB - Padrões de Projeto de Sistemas


Grupo: 
- João Vittor Pereira Menezes
- Silas Leão Rocha Albuquerque
- Kauã Victor Gomes Paiva








Padrões Utilizados:

Bridge:

R3 - Emitir laudo dos seguintes exames: Hemograma, Ultrassonografia e
Ressonância Magnética. Outros tipos de exames poderão surgir no futuro, como
por exemplo o Tomografia. Os novos tipos de exames a serem adicionados não
devem impactar o funcionamento do código já existente.
  
R4 - Gerar laudos para diferentes exames, inicialmente nos formatos texto, HTML e
PDF. Outros tipos de formato poderão surgir no futuro, como por exemplo o JSON.
Os novos formatos de exames a serem adicionados não devem impactar o
funcionamento do código já existente. Qualquer tipo de laudo deve ser gerado em
seu formato específico, inclusive em PDF (utilize a API de sua preferência).

A Solução com Bridge
O padrão Bridge resolve isso desacoplando a abstração (o conceito do Exame) da sua implementação (o GeradorDeLaudo que formata a saída).

Criamos duas hierarquias de classes independentes:

Hierarquia de Exames (Abstração): Exame -> Hemograma, Ultrassonografia, etc.

Hierarquia de Geradores (Implementação): GeradorDeLaudo -> GeradorLaudoTexto, GeradorLaudoHTML, etc.

A "ponte" é a referência que um objeto Exame tem para um objeto GeradorDeLaudo, delegando a ele todo o trabalho de formatação.

Como a Extensibilidade é Garantida
Para Adicionar um Novo Exame (R3): Basta criar uma nova classe que herda de Exame. Ela automaticamente funcionará com todos os formatos já existentes.

Para Adicionar um Novo Formato (R4): Basta criar uma nova classe que implementa GeradorDeLaudo. Todos os exames existentes poderão gerar laudos neste novo formato, sem qualquer modificação.

Chain of Responsability:

R5 - Adicionar as regras de validação de cada exame, de maneira extensível. A validação do Hemograma só analisa se os valores medidos não excede 50% o valor máximo e o mínimo. Por exemplo se para Hemoglobina os valores de referência são de 13.0 a 18.0 milhões/dl , os extemos não podem exceder 6.5 e 27 milhões/dl. No caso de uma ressonância magnética, há diferentes regras de validação que devem ser verificadas, não importa a ordem: (a) verificar a presença de implantes gerais

Foi usado esse padrão nesse requisito de validação porque cada exame tem um validador específico, então há a classe abstrata ValidadorExame que tem a variável de instância para cada tipo de validador e seus métodos que serão utilizados pelas classes concretas, o setNext(), que é padrão para todos e o método validar() que irá ter uma lógica específica em cada. E suas classes concretas, como dito antes tem sua implementação do método validar() e também cada um tem um podeValidar() para saber se ele é a classe certa para o tipo de exame que será validado, ou seja, cada uma pega o exame e checa se pode validar ele ou não, e passa para o próximo.

Observer:

R6 - Notificar o paciente quando um laudo for emitido (inserido no sistema), por
whatsapp. Outros mecanismos de notificação serão adicionados futuramente (e.g.
SMS ou E-mail) e não devem impactar o funcionamento do código já existente.
Qualquer tipo de notificação deve ser gerado de maneira real. 

A classe Notificador (classe Publicadora) está associada por dependência à GeradorDeLaudo por depender do resultado de um laudo para ser acionada, utilizando o Observer para assim que o laudo for gerado, a  função de notificarAssinantes é chamada para ser resolvida nas implementações concretas da interface Assinante. Por existirem multiplos tipos de Assinantes(que prefiram receber por whatsapp, email ou outros que possam ser implementados), a variável assinantes no Notificador é composta por um HashMap que irá guardar o TipoNotificacao para estrutura de decisão, e o Assinante em si, dessa forma, o código consegue decidir e direcionar para qual classe concreta de Assinante a função de notificar será executada e enviada ao assinante. O principio open/close não está sendo ferido, pois a qualquer momento, uma nova classe de Assinante pode ser instanciada, não afetando o código já existente

Strategy:

R7 - O sistema deve permitir a realização de descontos para o custo de examesconforme política definida pelo laboratório. Inicialmente, serão concedidos descontos para convênio (15%) e desconto para idoso (8%). Outros tipos de descontos poderão surgir no futuro, como por exemplo, no mês de campanha do “outubro rosa” (prevenção de câncer de mama). Os novos tipos de exames a serem adicionados não devem impactar o funcionamento do código já existente.

o método strategy foi usado aqui, implementado na classe Pagamento(Contexto), que define a estrategia atual e tem o método pagar , que passa o valor do pagamento utilizando a estratégia definida para ser processado o desconto, a classe DescontoStrategy é a interface Strategy que acaba sendo implementada pelos descontos atuais e futuros(DescontoConvenio e DescontoIdoso atualmente), onde cada uma implementa o método aplicarDesconto da interface, realizando sua lógica de desconto específica. Outros tipos de descontos podem surgir com o tempo, e não há problema em adicionar-los, o funcionamento do código existente é garantido, já que uma nova implementação seria apenas uma adição de implementação da classe DescontoStrategy, sem alterar o funcionamento prévio do código

------------------------------------------------------------------------------------------------------------------------------------------------

R8 – Implementar a solução de priorização de exames usando fila de prioridade. As regras já foram indicadas anteriormente e considerar-se-á as prioridades URGENTE, POUCO URGENTE e ROTINA.

Para esse requisito, não julgamos necessário o uso de um padrão de projeto pois a estrutura de dados fila já pode ser suficiente para implementar o requisito.

-----------------------------------------------------------------------------------------------------------------------------------------------

Facade:

R9 – Implementar o programa principal que simule a execução da aplicação e atendimento de todos os requisitos funcionais.

Como implementação para o programa principal, utilizamos a Classe Sistema <<Facade>>que simplifica o uso de subsistemas complexos, escondendo os detalhes internos por trás de uma interface única, atuando como um "main" do programa em execução, unindo todos os padrões implementados, tendo ligações diretas com o Pagamento(Strategy), ValidadorExame(Chain of Responsability), Notificador(Observer), Exame(Bridge) e ExameState(State).
  

State:

R10 - Adicione um requisito funcional a mais, dentro do escopo do problema, que justifique a inclusão de um padrão de projeto adicional (que antes estivesse fora dos requisitos.

Como requisito bonus, optamos por um requisito de Gerenciamento do Ciclo de Vida do Exame utilizando State, onde o Contexto é a classe Exame do Bridge, o ExameState é a interface State que possui suas 4 implementações concretas são Agendado, EmAnalise, Cancelado e Concluido, gerenciando todos os estados da vida util do exame, atendendo também o principio open/close, ja que novos estados podem ser adicionados ou removidos sem problema no código existente.

