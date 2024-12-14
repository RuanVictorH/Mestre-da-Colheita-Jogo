INFORMAÇÕES GERAIS

Nome do jogo: SurvivalRunner


SurvivalRunner, surgiu com a simples ideia de criarmos um jogo parecido com subwaySurfers, ou seja, um jogo que independente da quantidade de horas jogadas, não possui fim a não ser que o jogador morra. Esse SurvivalRunner não é seu amigo, sua dificuldade com o passar do tempo vai se tornar quase impossivel, ou seja, como um Souls-Like onde a facilidade não anda com você.
Se empenhe para fazer sua melhor pontuação.


Integrantes do grupo:
- Davi Aziz Santos Salazar
- Layon Walker Tobias Pedro
- Marcos Vinícius Matias do Nascimento

GAMEPLAY

Número de classes de atores com ação: 7
Número de classes de mundo: 5
Qual classe que não é ator nem mundo? GerenciadorDeSom
Número de arquivos de áudio usados: 7
Permite várias partidas no próprio gameplay? Sim, o usuario pode apertar R para poder reiniciar a Run, quando ele morrer.
Tem tela inicial? Sim, menu inicial
Tem tela de histórico de pontuação? Sim, temos o placar de pontuacos

REQUISITOS DE OO

Atende aos requisitos de OO da primeira entrega?
    Sim. Todas as propostas foram atendidas.
Tem alta coesão? 
    Sim. tentamos deixar o código o mais coeso possível, nosso
    código tem baixo acoplamento, e tentamos deixar ele fácil de
    entender e criarmos cada classe e método com funções específicas
    (especifíco com mais detalhes em baixo). 
Tem baixo acoplamento?
    Sim tentamos deixar o código com o mínimo de acoplamento.
    Algumas classes precisam chamar as outras, como todas as 
    classes mundo chamam GerenciadorDeSom (exceto Placar). A
    classe MyWorld chama várias classes para criar a parte 
    "jogável" do jogo, entre outros. Mas, não consideramos que
    existe nenhum acoplamento desnecessário.
Usa design baseado em responsabilidade?
    Tentamos deixar cada classe com sua respectiva função, e quando 
    percebemos que ocorria certa repetição de código fizemos o possível
    para retirar tal repetição. Achamos que seja bem fácil realizar alterações
    em nosso código, entendê-lo e manter ele organizado. 
Tem acoplamento implícito?
    Outro caso em que tentamos tirar o máximo possível, mas é possível que
    alguns acoplamentso tenham ficado sem que percebamos.
Tem replicação de código?
    Uma das únicas replicações de código em nosso projeto ocorre
    com alguns métodos da classe Zombie e Obstaculo, nos pensamos
    em utilizar a superclasse GameObject para compartilhar métodos 
    (fizemos isso inicialmente). Porém, Não conseguimos retirar 
    essas replicações porque o Zombie já herdava da superclasse
    AtorAnimado, e a melhor solução era criarmos uma hierarquia
    de classes. Mas, não vimos como isso ia ser benéfico, visto 
    que as classes GameObject e AtorAnimado não tem nada em comum.
    então elas herdariam métodos e atributos desnecessários.
Tem duas superclasses com subclasses com implementação útil? 
    Sim. a classe AtorAnimado serve para animar suas sub-classes,
    fazendo com que as imagens se atualizem, cada uma substituindo
    a anterior. A outra superclasse, GameObject cuida da velocidade
    das subclasses fazendo com que ela mude com o tempo,antes 
    ela também servia para a classe zombie, mas abidicamos da ideia 
    para colocarmos a classe Zombie como subclasse de AtorAnimado.
    Mas, temos o GameObject como superclasse para termos a oportunidade 
    de colocarmos outros obstáculos e objetos que se movem em futuras
    atualizações
    

COMENTÁRIOS (OPCIONAIS)

Algum comentário sobre o tema do trabalho?

O trabalho foi um pouco desafiador porém achei interessante ter essa experiencia, pois tive que lidar com implementação de código, design de menus, procurei soundtracks e tive a ideia de implementar animações (pixel art com varias sprites) para dar uma experiencia diferente na gameplay. - Marcos Vinicius Matias


Algum comentário sobre o Greenfoot?

Utilizar essa plataforma foi muito legal mesmo com pouco conhecimento das funcionalidades da mesma. Sempre tive vontade de implementar algo gráfico e essa primeira experiencia foi muito boa e pude ter uma visão bem diferente ao ver alguma plataforma ou algo do tipo kk.



