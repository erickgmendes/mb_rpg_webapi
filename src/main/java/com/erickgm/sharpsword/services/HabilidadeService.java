package com.erickgm.sharpsword.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.erickgm.sharpsword.domain.entities.Classe;
import com.erickgm.sharpsword.domain.enums.TipoClasse;
import com.erickgm.sharpsword.domain.enums.TipoRaca;
import com.erickgm.sharpsword.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.domain.entities.Habilidade;
import com.erickgm.sharpsword.domain.entities.Raca;
import com.erickgm.sharpsword.domain.enums.TipoHabilidade;
import com.erickgm.sharpsword.repository.HabilidadeRepository;
import com.erickgm.sharpsword.repository.RacaRepository;

@Service
public class HabilidadeService {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private ClasseRepository classeRepository;

    private List<Raca> listaRacasBanco;

    private List<Classe> listaClassesBanco;

    public HabilidadeService() {
    }

    public String cargaInicial() {
        if (habilidadeRepository.count() == 0)
            return cargaHabilidades();
        return "Não foi possível carregar Habilidades";
    }

    private List<Raca> getListaRacasBanco() {
        if (listaRacasBanco == null)
            listaRacasBanco = racaRepository.findAll();

        return listaRacasBanco;
    }

    private List<Classe> getListaClassesBanco() {
        if (listaClassesBanco == null)
            listaClassesBanco = classeRepository.findAll();

        return listaClassesBanco;
    }

    private String gravarHabilidades(List<Habilidade> habilidades) {
        try {
            for (Habilidade habilidade : habilidades)
                habilidadeRepository.save(habilidade);
            return "Habilidades carregadas";
        } catch (Exception e) {
            return "Não foi possível carregar Habilidades";
        }
    }

    private List<Raca> obterListaRaca(TipoRaca tipoRaca) {
        if (tipoRaca == null)
            return getListaRacasBanco();

        List<Raca> retorno = new ArrayList<>();

        Raca raca = this.getListaRacasBanco()
                .stream()
                .filter(n -> n.getNome().equals(tipoRaca.getNome()))
                .findAny()
                .orElse(null);

        retorno.add(raca);

        return retorno;
    }

    private List<Raca> obterListaRaca(List<TipoRaca> tiposRaca) {
        List<Raca> retorno = new ArrayList<>();

        for (TipoRaca tipo : tiposRaca) {
            Raca raca = this.getListaRacasBanco()
                    .stream()
                    .filter(n -> n.getNome().equals(tipo.getNome()))
                    .findAny()
                    .orElse(null); // ifPresent()

            if (raca != null)
                retorno.add(raca);
        }

        return retorno;
    }

    private List<Classe> obterListaClasse(TipoClasse tipoClasse) {
        if (tipoClasse == null)
            return getListaClassesBanco();

        List<Classe> retorno = new ArrayList<>();

        Classe Classe = this.getListaClassesBanco()
                .stream()
                .filter(n -> n.getNome().equals(tipoClasse.getNome()))
                .findAny()
                .orElse(null);

        retorno.add(Classe);

        return retorno;
    }

    private List<Classe> obterListaClasse(List<TipoClasse> tiposClasse) {
        List<Classe> retorno = new ArrayList<>();

        for (TipoClasse tipo : tiposClasse) {
            Classe Classe = this.getListaClassesBanco()
                    .stream()
                    .filter(n -> n.getNome().equals(tipo.getNome()))
                    .findAny()
                    .orElse(null); // ifPresent()

            if (Classe != null)
                retorno.add(Classe);
        }

        return retorno;
    }

    private String cargaHabilidades() {
        List<Habilidade> habilidades = new ArrayList<>();

        // Configuração das Raças
        List<Raca> todasRacas = obterListaRaca(TipoRaca.obterTodas());

        List<Raca> faunos = obterListaRaca(TipoRaca.FAUNO);
        List<Raca> jubans = obterListaRaca(TipoRaca.JUBAN);
        List<Raca> faens = obterListaRaca(TipoRaca.FAEN);
        List<Raca> elfos = obterListaRaca(TipoRaca.ELFO);
        List<Raca> tailox = obterListaRaca(TipoRaca.TAILOX);
        List<Raca> aesires = obterListaRaca(TipoRaca.AESIR);
        List<Raca> firas = obterListaRaca(TipoRaca.FIRA);
        List<Raca> levents = obterListaRaca(TipoRaca.LEVENT);
        List<Raca> anoes = obterListaRaca(TipoRaca.ANAO);
        List<Raca> mahoks = obterListaRaca(TipoRaca.MAHOK);
        List<Raca> humanos = obterListaRaca(TipoRaca.HUMANO);

        List<Raca> todasRacasMenosAesir = obterListaRaca(TipoRaca.obterTodasMenos(TipoRaca.AESIR));
        List<Raca> todasRacasMenosMahok = obterListaRaca(TipoRaca.obterTodasMenos(TipoRaca.MAHOK));

        List<Raca> faunos_Jubans = obterListaRaca(TipoRaca.obterDupla(TipoRaca.FAUNO, TipoRaca.JUBAN));
        List<Raca> faens_elfos = obterListaRaca(TipoRaca.obterDupla(TipoRaca.FAEN, TipoRaca.ELFO));
        List<Raca> faunos_elfos_tailox = obterListaRaca(TipoRaca.obterTrio(TipoRaca.FAUNO, TipoRaca.ELFO, TipoRaca.TAILOX));
        List<Raca> aesires_jubans = obterListaRaca(TipoRaca.obterDupla(TipoRaca.AESIR, TipoRaca.JUBAN));
        List<Raca> firas_levents = obterListaRaca(TipoRaca.obterDupla(TipoRaca.FIRA, TipoRaca.LEVENT));
        List<Raca> anoes_mahoks = obterListaRaca(TipoRaca.obterDupla(TipoRaca.ANAO, TipoRaca.MAHOK));
        List<Raca> humanos_tailox = obterListaRaca(TipoRaca.obterDupla(TipoRaca.HUMANO, TipoRaca.TAILOX));
        List<Raca> humanos_mahoks = obterListaRaca(TipoRaca.obterDupla(TipoRaca.HUMANO, TipoRaca.MAHOK));

        // Configuração das Classes
        List<Classe> todasClasses = obterListaClasse(TipoClasse.obterTodas());

        List<Classe> bardos = obterListaClasse(TipoClasse.BARDO);
        List<Classe> druidas = obterListaClasse(TipoClasse.DRUIDA);

        // G E R A I S

        habilidades.add(new Habilidade(null, "Agilidade Heróica", TipoHabilidade.SUPORTE, todasRacas,
                todasClasses, 5,
                "Você possui uma agilidade e flexibilidade que já lhe salvaram em muitas ocasiões. Você tem Agilidade +1",
                "", 0, 5, "", "Agilidade+1"));

        habilidades.add(new Habilidade(null, "Atletismo", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
                "Você treinou exercícios físicos durante muito tempo – seja por vontade própria ou por necessidade – e é muito bom nisso. Você recebe +2 em testes para correr, escalar, nadar, se equilibrar, prender o fôlego ou qualquer outra atividade que exija força física e coordenação motora. Esse bônus também se aplica em testes para evitar ser derrubado.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Força Heróica", TipoHabilidade.ACAO, todasRacas, todasClasses, 5,
                "Você possui uma força e resistência forjadas na batalha. Você tem Força +1.",
                "", 0, 0, "","Força+1"));

        habilidades.add(new Habilidade(null, "Força Interior", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
                "Você é capaz de se manter em pé usando sua vontade e força interiores. Você recupera 5 Pontos de Vida.",
                "", 0, 0, "Vontade 4 ou mais.", ""));

        habilidades.add(new Habilidade(null, "Inteligência Heroica", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 5,
                "Você possui uma percepção e uma capacidade de raciocínio extremamente afiadas. Você tem Inteligência +1.",
                "", 0, 0, "", "Inteligência+1"));

        habilidades.add(new Habilidade(null, "Nanismo", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
                "Você é menor do que a média de sua raça – em média entre 1 e 1,2 metros de altura. Você pode rolar +1d6 quando fizer testes para se esconder, se mover em silêncio ou passar despercebido de qualquer forma. Além disso, seu bônus automático de Defesa é 6 ao invés de 5. No entanto, armas corporais que requerem duas mãos são grandes demais para que você possa usá-las com eficiência, e você precisa usar ambas as mãos para usar qualquer arma corporal com FN 5 ou mais.",
                "Você só pode selecionar essa Habilidade durante a criação do personagem.", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Nervos de Aço", TipoHabilidade.ESPECIAL, todasRacas, todasClasses, 5,
                "Você tem um autocontrole invejável e é capaz de se concentrar mesmo quando outros entrariam em desespero. Você tem +20 Pontos de Mana.",
                "", 0, 0, "", "Mana+20"));

        habilidades.add(new Habilidade(null, "Recursos", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
                "Você possui (ou possuía) um pequeno negócio ou vem de uma família nobre. Você começa o jogo com o dobro das moedas inicias.",
                "Esta habilidade só pode ser escolhida durante a criação do Personagem.", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Vontade de Ferro", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 5,
                "Você não se entrega com facilidade e é muito difícil derrubar você em combate. Você tem +20 Pontos de vida.",
                "", 0, 0, "", "PV+20"));

        habilidades.add(new Habilidade(null, "Vontade Heróica", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 5,
                "Sua determinação e autoconfiança são quase inabaláveis. Você tem Vontade +1.",
                "", 0, 0, "","Vontade+1"));

        // R A Ç A S

        // Todas menos Aesir
        habilidades.add(new Habilidade(null, "Fúria de Batalha", TipoHabilidade.REACAO, todasRacasMenosAesir, todasClasses, 1,
                "Quando você é ferido você é tomado por uma irrefreável fúria destrutiva, ficando neste estado até o final do combate – ou até ficar dois turnos sem atacar. Você precisa sofrer pelo menos 1 ponto de dano de qualquer fonte – inclusive auto-infligido – para que essa Habilidade possa ser ativada. Enquanto estiver em Fúria, você recebe Força +2 e fica imune a efeitos de Medo.",
                "", 0, 30, "", "Força+2"));

        // Todas menos Mahok
        habilidades.add(new Habilidade(null, "Sentidos Apurados", TipoHabilidade.SUPORTE, todasRacasMenosMahok, todasClasses, 1,
                "Você possui sentidos treinados e extremamente apurados e aprendeu a confiar instintivamente no que eles captam. Você recebe +2 em todos os testes de para perceber, procurar, observar, ouvir ou usar seus cinco sentidos e também em testes de Iniciativa.",
                "", 0, 0, "", "Força+2"));

        // Faunos
        habilidades.add(new Habilidade(null, "Patas com Cascos", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Você possui fortes patas munidas de cascos resistentes. Você pode rolar +1d6 quando fizer testes de correr, saltar ou desviar de obstáculos, e seu Deslocamento é aumentado em 1. Além disso, se fizer ataques desarmados com seus cascos, seu dano será Força +2/Contusão.",
                "", 0, 0, "", "Força+2"));

        habilidades.add(new Habilidade(null, "Cascos Ágeis", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Você é mais ágil e veloz do que a maioria dos Faunos. Você tem Agilidade +1, Deslocamento +1 e a distância dos seus saltos é aumentada em 1 metro.",
                "", 0, 0, "", "Agilidade+1;Deslocamento+1"));

        habilidades.add(new Habilidade(null, "Flauta de Pã", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Você ouviu, tocou e dançou várias músicas ao redor de fogueiras com seu povo – e talvez com aqueles que você encontrou em suas andanças – e adquiriu uma imensa prática em vários estilos de instrumentos de sopro. Sempre que estiver usando uma flauta ou outro instrumento de sopro, a você recebe +2 em seus testes para executar músicas (incluindo as Habilidades do tipo Música).",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Marrada", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Você pode desferir um poderoso golpe com seus chifres. Este é um ataque desarmado que causa dano igual à Força +2/Contusão. Caso use esse ataque com uma ação de Encontrão, o alvo precisa vencer um teste de Força (Dificuldade igual à sua Determinação +2) ou será derrubado.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Patas Fortes", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                " Você possui pernas mais fortes do que a maioria dos membros da sua raça. Você pode rolar +1d6 quando fizer testes de corrida, salto, evitar quedas, etc. Além disso, o dano dos seus ataques com cascos é aumentado em +2.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Pintura Corporal", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Pinturas corporais são comuns entre os Faunos, utilizadas em rituais ou simplesmente como forma de expressão artística. Você deposita muita fé nos significados tradicionais das pinturas, ao ponto de conseguir se beneficiar dessa convicção quando estiver usando uma pintura. Sempre que estiver usando uma pintura corporal e que ela esteja completamente à mostra, você recebe um dos benefícios listados. Apenas uma pintura corporal pode ser usada por vez. Uma pintura corporal dura até você tomar banho – intencionalmente ou não! - ou dormir. Pintura de Caça: Realizada ao redor dos olhos e nas mãos. Você recebe +1 em seus testes ligados à visão e ataques à distância. Além disso, seus ataques à distância causam +1 de dano. Pintura de Guerra: Realizada nos braços, mãos e peito. Seus ataques corporais causam +2 de dano e você recebe Defesa +1 (Este é um bônus de esquiva). Pintura de Oração: Realizada ao redor da boca e pescoço. Você recebe +2 em todos os seus testes ligados à sua voz e instrumentos musicais de sopro, incluindo interações sociais (como convencer ou mentir) e cantar ou usar instrumentos musicais de sopro (incluindo Habilidades do tipo Música). Pintura Ritual: Realizada no peito e no rosto. Você recebe +1 em todos os seus testes ligados à liguagem corporal (como dançar, seduzir ou detectar mentiras) e Habilidades do tipo Magia. Especial: A tintura necessária para a pintura é feita com materiais simples, facilmente encontrados na natureza (como folhas ou frutas trituradas, carvão e argila) e geralmente não tem custo, mas o Mestre pode exigir que o personagem gaste meia hora em busca dos materiais necessários e no preparo da tintura. O processo de aplicar a pintura demora cerca de 10 minutos, e exige sucesso num teste de Inteligência (Dificuldade 8) que pode ser realizado por você mesmo ou por alguém em quem você confia.",
                "", 0, 0, "", ""));

        // Faunos e Jubans
        habilidades.add(new Habilidade(null, "Sentidos de Caçador", TipoHabilidade.SUPORTE, faunos_Jubans, todasClasses, 1,
                "Você possui uma audição aguçada e uma visão treinada. Você rola +1d6 em todos os seus testes de Inteligência envolvendo percepção, para perceber e rastrear alvos.",
                "", 0, 0, "", ""));

        // Faens e Elfos
        habilidades.add(new Habilidade(null, "Herança Feérica", TipoHabilidade.SUPORTE, faens_elfos, todasClasses, 1,
                "Você possui algumas características comuns aos seus ancestrais feéricos. Você é imune a qualquer efeito mental e efeito de medo além de perceber automaticamente ilusões. Você também ganha +5 Pontos de Mana.",
                "", 0, 0, "", "Mana+5"));

        habilidades.add(new Habilidade(null, "Dom da Magia", TipoHabilidade.SUPORTE, faens_elfos, todasClasses, 1,
                "Você é capaz de canalizar magias muito mais facilmente. As dificuldades de todas as Magia são diminuídas em 1 para você. Você também tem +5 Pontos de Mana.",
                "", 0, 0, "", "Mana+5"));

        habilidades.add(new Habilidade(null, "Invisibilidade Natural", TipoHabilidade.ACAO, faens_elfos, todasClasses, 1,
                "Você possui uma das habilidades mais características das fadas. Você é capaz de se mesclar à vegetação à sua volta, ficando invisível por até uma hora. É preciso estar em uma área com vegetação densa – um bosque, um jardim de topiarias ou uma estufa, por exemplo – e o efeito é cancelado se você deixar a área de vegetação, sofrer algum dano, atacar ou lançar uma magia.",
                "", 0, 10, "Herança Feérica", ""));

        habilidades.add(new Habilidade(null, "Luzes das Fadas", TipoHabilidade.ACAO, faens_elfos, todasClasses, 1,
                "Você possui uma habilidade comuns às fadas. Você pode criar até três pequenos globos de luz que ficam dançando pelo ar. Você pode comandá-los, mas eles não podem se afastar mais que três metros do você. Eles duram uma hora, mas você pode dispersá-los quando desejar. Os globos produzem iluminação igual à de uma tocha, e você pode realizar um ataque à distância para atingir os olhos de um alvo com um dos globos de luz (que se extingue no processo), deixando-o Distraído por 1 turno.",
                "", 0, 15, "Herança Feérica", ""));

        // Faunos, Elfos e Tailox
        habilidades.add(new Habilidade(null, "Raça Florestal", TipoHabilidade.SUPORTE, faunos_elfos_tailox, todasClasses, 1,
                "Você se sente confortável e renovado quando está sob a proteção da vegetação. Quando estiver dentro de uma floresta, bosque ou selva você recebe +2 em todos os seus testes.",
                "", 0, 0, "", ""));

        // Aesires e Jubans
        habilidades.add(new Habilidade(null, "Robustez", TipoHabilidade.SUPORTE, aesires_jubans, todasClasses, 1,
                "Você possui uma constituição vigorosa para os padrões da sua raça. Você tem +5 Pontos de vida e rola +1d6 em testes de Força para resistir à fadiga, venenos e doenças.",
                "", 0, 0, "", ""));

        // Firas e Levents
        habilidades.add(new Habilidade(null, "Mente Iluminada", TipoHabilidade.SUPORTE, firas_levents, todasClasses, 1,
                "Você possui uma clareza única de raciocínio. Você tem Vontade +1 e +5 Pontos de Mana.",
                "", 0,0, "", "Vontade+1;Mana+5"));

        // Anões e Mahoks
        habilidades.add(new Habilidade(null, "Estabilidade", TipoHabilidade.SUPORTE, anoes_mahoks, todasClasses, 1,
                " Você gosta de ter os dois pés solidamente plantados no chão – e faz isso muito bem! Você sempre rola +1d6 em todos os seus testes de evitar quedas e manter o equilíbrio.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Nascido nas Montanhas", TipoHabilidade.SUPORTE, anoes_mahoks, todasClasses, 1,
                "Você nasceu ou passou grande parte da sua vida em ambientes montanhosos. Você recebe +2 em seus testes ligados à locais rochosos e montanhosos – como escalar rocha (nua ou trabalhada), percepção e sobrevivência em áreas montanhosas, identificar animais dessas regiões, avaliar formações rochosas e pedras brutas ou trabalhadas (incluindo construções de pedra e pedras preciosas) e para trabalhar em pedra – seja artesanato, alvenaria ou joalheria.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Audácia", TipoHabilidade.SUPORTE, humanos_tailox, todasClasses, 1,
                "Você enfrenta ameaças e situações de perigo com entusiasmo. Sempre que estiver frente à uma situação de risco eminente – saltar entre duas bordas de um precipício, equilibrar-se em uma corda sobre um rio de lava, entrar em um combate ou qualquer situação em que você possa potencialmente perder a vida (ou pelo se ferir seriamente), você recupera imediatamente 10 Pontos de Vida ou 10 Pontos de Mana, à sua escolha. Essa Habilidade só pode ser usada uma vez para cada situação de risco, e apenas quando o risco se apresentar – não depois da sua primeira ação em um combate ou depois de cair, por exemplo.",
                "", 0, 0, "", ""));

        // Raças: Humanos e Mahoks / Classe: Bardo
        habilidades.add(new Habilidade(null, "Gregário", TipoHabilidade.SUPORTE, humanos_mahoks, bardos, 1,
                "Você consegue compreender muito rapidamente as estruturas sociais de uma cultura e seus indivíduos e é capaz de fazer amigos em qualquer lugar. Depois de cinco minutos de conversa, a pessoa com quem você esteja interagindo – e que não seja obviamente hostil a você, como um captor ou um inimigo jurado – torna-se propensa a ajudá-lo. Essa Habilidade geralmente serve para colher informações gerais (apesar de segredos não serem possíveis de conseguir) ou pequenos favores – como ser apresentado a alguém ou conseguir uma cerveja de graça. Você também recebe +2 em testes de seduzir, mentir, detectar mentiras ou qualquer outra interação social.",
                "", 0, 0, "", ""));

        // Faens
        habilidades.add(new Habilidade(null, "Constituição Feérica", TipoHabilidade.SUPORTE, faens, todasClasses, 1,
                "Você possui uma constituição leve e um par de asas que lhe permitem voar. Você pode voar em qualquer direção (com o dobro da sua movimentação normal) e pode parar no ar. No entanto, suas asas precisam bater continua e velozmente, e você não pode planar nem permanecer no ar por mais do que uma hora antes de ter que descansá-las por pelo menos meia hora. Enquanto está voando, o bater das suas asas produzem um zumbido característico e facilmente audível, e é impossível para você se mover em silêncio enquanto voa.",
                "O dano de qualquer manobra de Encontrão usada em voo é duplicado (mas o dano da arma que você usar no Encontrão não é alterado, nem quaisquer outros possíveis efeitos de Encontrão).",
                0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Isnuu", TipoHabilidade.SUPORTE, faens, todasClasses, 1,
                "Você nasceu com uma grande afinidade com a magia. Sua pele e seus cabelos são de tons esverdeados, e você pode selecionar Habilidades da lista do Feiticeiro como se fossem da sua Habilidade – desde que preencha os requisitos. Além disso, as dificuldades de todas as Magia são diminuídas em 1 para você.",
                "Você só pode selecionar essa Habilidade durante a criação do personagem", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Presença Real", TipoHabilidade.SUPORTE, faens, todasClasses, 1,
                "Você é capaz de uma comunicação rudimentar – dentro das capacidades do animal – com qualquer Besta do tipo insectóide ou aracnídeos, e é capaz de dar comandos simples que serão obedecidos prontamente, dentro das capacidades da criatura. Você também é automaticamente bem sucedido em testes de Força para resistir quando for afetado por qualquer Habilidade do tipo Característica de todas as criaturas dos tipos Aracnídeo e Insectóide. Além disso, todas as suas Habilidades que envolvam criaturas do tipo Besta (Companheiro Animal, Convocar animais, Forma Animal e guardião da Natureza) passam a incluir criaturas dos tipos Aracnídeo e Insectóide.",
                "", 0, 5, "", ""));

        habilidades.add(new Habilidade(null, "Voador Exímio", TipoHabilidade.SUPORTE, faens, todasClasses, 1,
                "Você praticou voos de longa duração, tendo passado muito tempo no ar, adquirindo uma resistência e habilidade incomum de voo. Você pode voar continuamente por até seis horas antes de precisar parar para descansar suas asas, e recebe Defesa +1 enquanto estiver voando (este é um Bônus de Esquiva).",
                "", 0, 0, "Força 3", "Defesa+1"));

        // Elfos
        habilidades.add(new Habilidade(null, "Benção de Lathellanis", TipoHabilidade.SUPORTE, elfos, todasClasses, 1,
                "A proteção de Lathellanis é evidente em você, assim como uma pálida sombra da astúcia da divindade da natureza. Você é imune à todas as doenças de origem natural ou mágica, Dreno de Energia e efeitos que causem Envelhecimento (de qualquer tipo ou origem). Além disso, Você rola +1d6 em todos os seus testes de Inteligência para perceber e rastrear alvos.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Arborícola", TipoHabilidade.SUPORTE, elfos, todasClasses, 1,
                "Você passou muitos anos explorando as copas das árvores, e se sente à vontade entre os galhos. Você é automaticamente bem-sucedido em testes para escalar árvores e seu Deslocamento não é reduzido quando estiver se movimentando pelas copas das árvores. Você também recebe um bônus de +2 em todos os seus testes para se mover em silencio, se esconder e se movimentar enquanto estiver em cima de uma árvore.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Intelecto Élfico", TipoHabilidade.SUPORTE, elfos, todasClasses, 1,
                "Seu raciocínio é veloz e objetivo. Você tem Inteligência +1 e +5 Pontos de Mana.",
                "", 0, 0,"", "Inteligência+1;Mana+5"));

        // Anões
        habilidades.add(new Habilidade(null, "Coração da Montanha", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
                "Sua constituição foi forjada nos subterrâneos agrestes e impiedosos, onde apenas os mais resistentes conseguem sobreviver. Você é imune a todos os venenos naturais e mágicos e rola +1d6 em testes para resistir à fadiga, doenças e quaisquer outros efeitos físicos. Além disso, sua Carga é calculada como se você tivesse Força +2.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Cabeça Dura", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
                "Você é extremamente teimoso e é muito difícil dissuadi-lo de uma opinião, intimidá-lo, controlar sua mente ou manipulá-lo de qualquer forma. Você tem Vontade +1 e Determinação +2.",
                "", 0, 0, "", "Vontade+1;Determinação+2"));

        habilidades.add(new Habilidade(null, "Coração da Montanha 2", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
                "Você é ainda mais vigoroso e resistente que a maioria dos Anões. Você tem +5 Pontos de Vida e é imune à todas as doenças de origem natural ou mágica e rola +1d6 em testes para resistir a quaisquer efeitos de fadiga ou outros efeitos físicos. Esse bônus se acumula com o bônus de Vigor da Montanha.",
                "", 0, 0, "", "PV+5"));

        habilidades.add(new Habilidade(null, "Duro como Pedra", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
                "Sua pele é mais grossa e resistente que a da maioria dos outros Anões. Você tem +10 Pontos de Vida e Defesa +1 (esse bônus de Defesa conta como Armadura).",
                "Você só pode selecionar essa Habilidade durante a criação do personagem.", null, null, null,
                "PV+10;Defesa+1"));

        habilidades.add(new Habilidade(null, "Forjado à Fogo", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
                "Você passou muito tempo nas forjas ou nasceu abençoado por Hou com uma resistência inata ao fogo e seus malefícios. Você possui Resistência ao Fogo e sua visão e respiração não são afetadas por fumaça.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Raça Subterrânea", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
                "Você está acostumado aos ambientes subterrâneos e se sente confortável neles. Quando estiver dentro de cavernas ou em ambientes subterrâneos, você ganha +1 em todos os testes. Você também consegue enxergar na completa escuridão, mas nessas condições não consegue distinguir cores.",
                "", 0, null, "", ""));

        // Aesires
        habilidades.add(new Habilidade(null, "Vigor Nórdico", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
                "Você nasceu em uma região gelada, e os rigores climáticos de Eishelm tornaram você vigoroso e resiliente. Você é Resistente à Frio e não é afetado nem por efeitos de climas gelados nem por efeitos provenientes de danos por Frio (como Enregelamento).",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Berserkir", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
                "Você é um escolhido do Urso como seu protegido, e é amparado pela resistência dele quando evoca a Fúria Bestial. Enquanto estiver em Fúria Bestial, você fica Resistente à Corte, Resistente à Perfuração e Resistente à Contusão. Você não pode estar usando armaduras ou escudos para que essa Habilidade tenha efeito, já que o Urso espera que você considere a proteção dele acima de qualquer proteção mundana.",
                "Se você tiver um Espírito Animal que não seja o Urso, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Urso como seu Espírito Animal.",
                0, 30, "Fúria Bestial, Vontade 4", ""));

        habilidades.add(new Habilidade(null, "Bravura Selvagem 1", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
                "Você confia mais nas suas habilidades naturais do que em armaduras para se defender. Quando não estiver usando armadura, você recebe +2 em sua Defesa. Quando escolhe essa Habilidade, você deve escolher se este será um bônus de Bloqueio ou Esquiva. Essa escolha é permanente e não pode ser mudada mais tarde.",
                null, null, null, null, "Defesa+2"));

        habilidades.add(new Habilidade(null, "Bravura Selvagem 2", TipoHabilidade.SUPORTE, aesires, todasClasses, 5,
                "Você veste sua bravura em batalha melhor do que alguns vestem armaduras. O Bônus Defesa conferido por Bravura Selvagem 1 aumenta para +4 e você pode escolher se esse bônus será de Bloqueio ou Esquiva no início de cada um de seus turnos, como uma ação livre.",
                null, null, null, "Bravura Selvagem 1", null));

        habilidades.add(new Habilidade(null, "Fúria Bestial", TipoHabilidade.ACAO, aesires, todasClasses, 1,
                "Você foi tocado pelo espírito do Urso ou pelo espírito do Lobo, e pode invocar a fúria que provém do instinto de sobrevivência deles. Enquanto estiver neste estado você recebe Força +2 e fica imune a Efeitos de Medo. Este efeito dura até o final da batalha ou até que você fique dois turnos sem atacar. Você não pode estar em Fúria Bestial e Fúria de Batalha ao mesmo tempo.",
                "Se você tiver um Espírito Animal que não seja o Urso ou o Lobo, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Lobo ou o Urso como seu Espírito Animal.",
                0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Potência", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
                "Você é mais forte e resistente do que a maioria dos indivíduos da sua raça. Você tem Força+1 e +5 Pontos de Vida.",
                "", 0, 0, "", "Força+1;PV+5"));

        habilidades.add(new Habilidade(null, "Ulfhednar", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
                "O Lobo considerou você um guerreiro digno, e ele lhe imbuirá de sua selvageria quando você evocar a Fúria Bestial, desferindo ataques muito mais violentos. O bônus de Força de Fúria Bestial passa a ser +4 e seus ataques desarmados causam +2 de dano. Você não pode estar usando armadura ou escudos para que essa Habilidade tenha efeito – já que o Lobo despreza a defesa em detrimento do ataque.",
                "Se você tiver um Espírito Animal que não seja o Lobo, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Lobo como seu Espírito Animal.",
                0, 0, "Fúria Bestial, Vontade 4", ""));

        // Firas
        habilidades.add(new Habilidade(null, "Habitante do Deserto", TipoHabilidade.SUPORTE, firas, todasClasses, 1,
                "Você descende de um povo que enfrentou os rigores do deserto sem esmorecer. Você é Resistente a Fogo e pode passar até 5 dias sem precisar ingerir água. Além disso, você não é afetado por climas particularmente quentes ou áridos.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Chamas Internas 1", TipoHabilidade.ACAO, firas, todasClasses, 1,
                " O Vigor de Hou incendeia seu espírito e encandece seu corpo. Você é capaz de produzir tanto calor em seu interior que se torna incandescente durante 1 minuto, ficando Imune à Fogo (ou, se você já possui Imunidade à Fogo, você passa a absorver fogo, recuperando uma quantidade de Pontos de Vida iguais à qualquer quantidade de dano por fogo que sofreria). Além disso, qualquer um que toca-lo (ou que seja atingido por seus ataques desarmados) sofre dano igual à 6/Fogo.",
                "", 0, 10, "", ""));

        habilidades.add(new Habilidade(null, "Chamas Internas 2", TipoHabilidade.ACAO, firas, todasClasses, 1,
                "O Vigor de Hou incendeia seu espírito e encandece seu corpo. Você é capaz de produzir tanto calor em seu interior que se torna incandescente durante 1 minuto, ficando Imune à Fogo (ou, se você já possui Imunidade à Fogo, você passa a absorver fogo, recuperando uma quantidade de Pontos de Vida iguais à qualquer quantidade de dano por fogo que sofreria). Além disso, qualquer um que toca-lo (ou que seja atingido por seus ataques desarmados) sofre dano igual à 6/Fogo.",
                "", 0, 20, "Chamas Internas 1", ""));

        habilidades.add(new Habilidade(null, "Cavaleiro Experiente", TipoHabilidade.SUPORTE, firas, todasClasses, 1,
                "Você passou muito tempo com animais de montaria e conhece seus hábitos, características e como lidar com eles. Você recebe +1d6 em todas as suas rolagens referentes à criaturas com a Habilidade Montaria – incluindo cavalgar, treinar e atacar.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Fulgurante", TipoHabilidade.ACAO, firas, todasClasses, 1,
                "Seus olhos são um reflexo do brilho de Hou que queima dentro de você. Você é capaz de enxergar normalmente no escuro, e não é afetado por efeitos que restrinjam a visão – como fumaça, poeira, areia, chuva, magias que causem cegueira, etc. No entanto, seus olhos sempre emitem um brilho considerável, e isso torna sua presença extremamente fácil de notar, principalmente no escuro. Você sempre realiza seus testes para se esconder como se fosse Inapto.",
                "Você só pode selecionar essa Habilidade durante a criação do personagem.", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Sopro de Fogo", TipoHabilidade.ACAO, firas, todasClasses, 1,
                "Você é capaz de externar o calor do seu corpo na forma de potentes labaredas. Todos que estiverem numa área até 3 metros a sua frente sofrem dano igual à 20/fogo.",
                "", 0, 30, "Chamas Internas 1, Vontade 5", ""));

        habilidades.add(new Habilidade(null, "Vigor do Deserto", TipoHabilidade.SUPORTE, firas, todasClasses, 1,
                "Você não só se adaptou como se fortaleceu no calor escaldante do deserto. Você é Imune ao Fogo e não precisa beber líquidos para se hidratar – você retira umidade suficiente dos alimentos e nunca precisa ingerir água.",
                "", 0, 0, "", ""));

        // Humanos
        habilidades.add(new Habilidade(null, "Adaptabilidade", TipoHabilidade.SUPORTE, humanos, todasClasses, 1,
                "Você se adaptou ao ambiente em que cresceu ou à atividade que escolheu – ou precisou – desempenhar. Você tem +1 em qualquer um dos seus Atributos a sua escolha.",
                null, null, null, null, null));

        habilidades.add(new Habilidade(null, "Assuntos Diversos", TipoHabilidade.ACAO, humanos, todasClasses, 1,
                "Você estudou e praticou um pouco de tudo ao longo da sua vida. Você pode rolar +1d6 em um teste qualquer à sua escolha.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Barganha", TipoHabilidade.SUPORTE, humanos, todasClasses, 1,
                "Você é um praticante das artes da negociação, oratória, retórica e sofisma. Você pode rolar +1d6 em todos os seus testes que envolvam comércio e outras negociações.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Diversidade", TipoHabilidade.SUPORTE, humanos, todasClasses, 1,
                "Você focou seus esforços e interesse em uma ampla gama de atividades. Escolha um Atributo diferente do que escolheu para Adaptabilidade. Você tem +1 nesse Atributo.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "O Dobro ou Nada", TipoHabilidade.REACAO, humanos, todasClasses, 1,
                "Você está acostumado à dar chance para sua sorte – às vezes, além do que seria considerado saudável. Quando falhar em um teste, você pode fazer o teste novamente, ignorando completamente o primeiro resultado. No caso de sucesso, além de passar no teste, qualquer efeito numérico proveniente do sucesso (dano causado por um ataque, duração de uma magia, PVs curados com uso de primeiros socorros, etc.) é dobrado. Mas se o teste for uma falha, ela deve ser considerada como uma falha crítica, com todos os seus possíveis efeitos numéricos dobrados. No caso de uma falha crítica nesse teste, o Mestre deve considerar que o fracasso foi uma falha crítica particularmente desastrosa – com efeitos limitados apenas pela sua imaginação sádica. Você só pode usar essa Habilidade uma vez por turno.",
                "", 0, 20, "Sorte", ""));

        habilidades.add(new Habilidade(null, "Sorte", TipoHabilidade.REACAO, humanos, todasClasses, 1,
                "Você está acostumado a contar com a sorte – e ela costuma lhe sorrir. Você pode rolar novamente um dado cujo resultado seja 1. Você só pode usar essa Habilidade uma vez por turno.",
                "", 0, 10, "", ""));

        // Jubans
        habilidades.add(new Habilidade(null, "Corpo Pesado", TipoHabilidade.SUPORTE, jubans, todasClasses, 1,
                "Você possui uma musculatura poderosa – e pesada. Você rola +1d6 em testes de para não ser derrubado e para realizar encontrões, mas é considerado Inapto em testes de natação, escalada e salto. Além disso, você precisa de uma ação de rodada completa para se levantar ao invés de uma ação de movimento, mas sua Carga é calculada como se você tivesse Força +2.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Fortaleza", TipoHabilidade.SUPORTE, jubans, todasClasses, 1,
                "Você é particularmente robusto e estoico. Você tem Resistência à Contusão e tem +5 Pontos de Vida.",
                "Você só pode selecionar essa Habilidade durante a criação do personagem.", 0, 0, "", "PV+5"));

        habilidades.add(new Habilidade(null, "Garras", TipoHabilidade.SUPORTE, jubans, todasClasses, 1,
                "Você treinou o uso de suas garras como ferramentas e armas. Você pode realizar ataques desarmados com suas garras, causando dano igual à Força+2/Perfuração. Suas garras também podem ser utilizadas para cortar cordas, panos e outros materiais com pouca dureza, e você recebe um bônus de +2 em seus testes de escalar, agarrar e segurar.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Imparável", TipoHabilidade.REACAO, jubans, todasClasses, 1,
                " Derrubar você permanentemente é uma tarefa bem difícil! Uma vez por combate, quando seus Pontos de Vida chegarem à zero, você ignora totalmente o dano que o derrubaria.",
                "", 0, 20, "Fortaleza, Vontade 5", ""));

        habilidades.add(new Habilidade(null, "Mordida Poderosa", TipoHabilidade.ACAO, jubans, todasClasses, 1,
                "Você pode usar seus dentes para fazer um ataque desarmado. O dano da sua mordida é igual a Força +4/Corte.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Rugido de Ahogr", TipoHabilidade.ACAO, jubans, todasClasses, 1,
                "Você aprendeu a canalizar a fúria de Ahogr em um poderoso rugido. Todos os oponentes que estiverem a até 10 metros à sua frente devem fazer um teste de Vontade (Dificuldade igual à sua Determinação). Aqueles que falharem no teste ficam Amedrontados e Atordoados por 1 turno (ver Condições, pág. 169). Um oponente só é afetado por esta habilidade uma vez por combate. Este é um efeito de Medo.",
                "", 0, 20, "", ""));

        // Levents
        habilidades.add(new Habilidade(null, "Asas Pesadas", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
                "Você possui grandes asas e pode voar, precisando de um espaço igual à sua envergadura para pegar impulso antes de alçar voo. Quando estiver voando, você não pode parar no ar (mas pode planar) e seu deslocamento em voo é o dobro de seu deslocamento normal.",
                "O dano de qualquer manobra de Encontrão usada em voo é duplicado (mas o dano da arma que você usar no Encontrão não é alterado, nem quaisquer outros possíveis efeitos do Encontrão). A envergadura do personagem é duas vezes a sua altura.",
                "", 0, 0, ""));

        habilidades.add(new Habilidade(null, "Asas Fortes", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
                "Você desenvolveu suas capacidades musculares de forma que ultrapassa os limites naturais dos outros Levent durante o voo. Você é capaz de parar no ar e não precisa pegar impulso para decolar, desde que tenha espaço suficiente para abrir as asas. Além disso, em manobras de Encontrão quando estiver voando, você recebe um bônus igual à sua Força para qualquer efeito relevante, incluindo danos e tentativas de derrubar oponentes, por exemplo.",
                "", 0, 0, "Força 4", ""));

        habilidades.add(new Habilidade(null, "Contato com Espíritos", TipoHabilidade.ACAO, levents, todasClasses, 1,
                "Você pode se comunicar com os espíritos que estejam próximos. Você é capaz de ouvir e ver qualquer espírito num raio de 20 metros. Esse efeito dura 10 minutos. Você pode gastar 10 Pontos de Mana enquanto estiver sob o efeito dessa Habilidade para ser capaz de tocar espíritos por 1 minuto.",
                "", 0, 5, "", ""));

        habilidades.add(new Habilidade(null, "Comunhão com Espíritos", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
                "Enquanto estiver utilizando Contato com Espíritos, você pode tocar outro personagem que será capaz de ouvir e ver qualquer espírito num raio de 20 metros por 10 minutos. Um personagem sob esse efeito pode gastar 10 Pontos de Mana para ser capaz de tocar espíritos por 1 minuto.",
                "", 0, 10, "Contato com Espíritos", ""));

        habilidades.add(new Habilidade(null, "Dançarino do Ar", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
                "Você praticou voo com um entusiasmo incomum e aperfeiçoou enormemente suas perícias aéreas. Enquanto estiver voando, você recebe um bônus de +2 em testes de acrobacia, tentativas de realizar um encontrão, testes de movimento e qualquer outra manobra aérea. Este bônus também estende-se a sua Defesa (este é considerado um bônus de Esquiva).",
                "", 0, 0, "Agilidade 5", ""));

        habilidades.add(new Habilidade(null, "Movimento Brusco", TipoHabilidade.REACAO, levents, todasClasses, 1,
                "Você realiza um movimento veloz e potente com as suas asas para se deslocar rapidamente e escapar de um golpe iminente. Quando estiver voando e for atingido por um ataque, você pode anunciar que está realizando um movimento brusco, e perder a quantidade de dano que sofreria em Pontos de Mana ao invés de Pontos de Vida. Se estiver no chão, você só pode utilizar esta Habilidade contra ataques à distância. Você só pode usar esta Habilidade uma vez por rodada. Se um ataque causar mais dano do que você tem Pontos de Mana quando utilizar esta Habilidade, o dano excedente causará a perda normal de Pontos de Vida.",
                "", 0, 0, "Dançarino do Ar", ""));

        habilidades.add(new Habilidade(null, "Olhos de águia", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
                "Você possui olhos naturalmente potentes, com capacidades de percepção únicas. Você pode rolar +1d6 quando fizer testes que envolvam a visão, e consegue distinguir detalhes à uma distância em quilômetros igual à sua Inteligência. Você também consegue ver pobremente na escuridão, sendo capaz de distinguir vultos e formas, mas não detalhes específicos (como cores, inscrições ou fisionomias).",
                "Você só pode selecionar essa Habilidade durante a criação do personagem.", 0, 0, "", ""));

        // Mahoks
        habilidades.add(new Habilidade(null, "Pele de Pedra", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
                "Sua pele é composta por uma grossa camada de rocha que o tornam extremamente resistente e pesado. Você recebe +1d6 em todos os seus testes para evitar ser derrubado, resistir à doenças e venenos, empurrar ou segurar peso, mas é considerado Inapto em testes de escalar, saltar, correr ou se mover com agilidade. Você precisa de um turno inteiro para se levantar, ao invés de uma ação de movimento e para você é impossível nadar. Você não possui o sentido do tato, mas não sente desconforto por ambientes com condições climáticas hostis. Seus ataques desarmados causam dano igual a Força +2/Contusão e você tem Defesa +4 (Esse bônus de Defesa conta como Armadura). Além disso, sua pele tem as características de uma armadura Pesada, mas a conformação única da sua pele o impede de usar armaduras, e qualquer roupa precisa ser feita sob medida para você, custando duas vezes mais que o normal.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Abraço de Pedra", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
                "Você possui mãos fortes, acostumadas a agarrar e segurar com eficiência. Você recebe +2 em seus testes de agarrar, apertar, escalar e para resistir à tentativas de desarmá-lo. Além disso, quando apertar um alvo (veja Ações e Testes, na página 24) você causa 2 pontos de dano adicionais. Esses bônus se acumulam com os bônus de Braços Extras 1 e 2.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Braços Extras 1", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
                "Você possui um par de braços a mais. Estes braços não são hábeis o suficiente para realizar ataques, mas podem segurar itens (incluindo escudos) e auxiliam em tentativas de segurar e agarrar com firmeza, oferecendo um bônus de +1 em seus testes de agarrar, apertar e escalar. Além disso, quando apertar um alvo (veja Ações e Testes, na página 23) você causa 2 pontos de dano adicionais. Esses bônus se acumulam com os bônus de Abraço de Pedra.",
                "Você só pode selecionar essa Habilidade durante a criação do personagem.", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Braços Extras 2", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
                "Você treinou com seus braços extras para ser hábil com eles. Você pode realizar um ataque extra por turno com seu par extra de braços, mas não pode utilizar Habilidades de Ação nos turnos em que fizer isso. Além disso, quando apertar um alvo (veja Ações e Testes, na página 24) você causa 2 pontos de dano adicionais. Esse bônus de dano se acumula com os bônus de Abraço de Pedra e Braços Extras 1.",
                "", 0, 0, "Braços Extras 1", ""));

        habilidades.add(new Habilidade(null, "Pele de Pedra 2", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
                "Sua pele é mais espessa do que a da maioria dos outros Mahoks, seja esta uma característica inata sua ou por você estar apresentando os primeiros sinais de envelhecimento. Você é Resistente à Perfuração e tem +5 Pontos de Vida. Além disso, sua pele adquire também as características de uma armadura Rígida (além da característica Pesada).",
                "", 0, 0, "", "PV+5"));

        // Tailox
        habilidades.add(new Habilidade(null, "Pernas Vulpinas", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
                "Suas pernas são flexíveis e próprias para saltar, terminando em pés pequenos dotados de solas acolchoadas que permitem que você ande quase sem fazer sons. Você rola +1d6 quando fizer testes para saltar, correr e se mover em silêncio. Além disso, você tem Deslocamento +1 e a distância dos seus saltos é aumentada em 1 metro.",
                "", 0, 0, "", "Deslocamento+1"));

        habilidades.add(new Habilidade(null, "Astuto", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
                "Você é mais astuto que a maioria dos indivíduos da sua raça. Você tem Inteligência +1 e recebe +2 em todos os testes de Inteligência e Agilidade que envolvam percepção, mover-se em silêncio, camuflagem, furtar bolsos, e teste semelhantes. Audácia",
                "", 0, 0, "", "Inteligência+1;TestesInteligência+2"));

        habilidades.add(new Habilidade(null, "Contos da Estrada", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
                "Através de várias histórias e canções contadas ao redor de fogueiras com viajantes que você encontrou em suas andanças, você acumulou um vasto conhecimento oral sobre inúmeros assuntos. Você rola +1d6 quando fizer testes de Inteligência referentes a qualquer tipo de conhecimento, não importando o quão inacessível seja este conhecimento.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Faro", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
                "Você possui um faro extremamente aguçado. Você rola +1d6 quando puder fazer testes que envolvam o faro, e pode perceber, detectar, rastrear e identificar pessoas e locais através dele. O Mestre pode realizar testes para ver se você consegue farejar mesmo quando você não estiver ativamente procurando odores específicos.Você possui um faro extremamente aguçado. Você rola +1d6 quando puder fazer testes que envolvam o faro, e pode perceber, detectar, rastrear e identificar pessoas e locais através dele. O Mestre pode realizar testes para ver se você consegue farejar mesmo quando você não estiver ativamente procurando odores específicos.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Forma da Raposa", TipoHabilidade.ACAO, tailox, todasClasses, 1,
                "Você atingiu um estágio tão profundo de compreensão do Mtii’Ruah que se tornou capaz de assumir uma forma mais próxima da essência de Ellenis. Quando assume a forma de raposa, todos os itens que você estiver carregando são absorvidos pela nova forma (eles não oferecem nenhum bônus), mas estarão com você quando voltar à sua forma normal. apesar de continuar entendendo qualquer linguagem que conheça, você consegue se comunicar apenas com raposas e você não pode lançar magias, ativar itens mágicos, usar armas ou qualquer item que requeira as mãos. Na forma de raposa você recebe +2 em todos os testes que envolvam percepção, se esconder, mover-se em silêncio e saltar e seu Deslocamento é aumentado em 1. Esses bônus se acumulam com os bônus de Pernas Vulpinas. Além disso seu bônus automático de Defesa é 7 ao invés de 5 e você pode usar suas presas para desferir ataques de mordida que causam dano igual à Força +2/Corte.",
                "", 0, 10, "Raça Florestal, Vontade 5", ""));

        habilidades.add(new Habilidade(null, "Visão Auditiva", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
                "Seus ouvidos são tão treinados e sensíveis que você não precisa usar seus olhos para se localizar. Você consegue perceber o tamanho e a localização aproximada dos objetos ao seu redor usando apenas a audição, e só é considerado cego se, além da sua visão, sua audição também for anulada de alguma forma. Quando estiver se guiando apenas pela audição você não é capaz de distinguir detalhes específicos (como cores, inscrições ou fisionomias). Você também pode rolar +1d6 quando fizer testes que envolvam a audição.",
                "", 0, 0, "", ""));

        // C L A S S E S

        // Bardos
        habilidades.add(new Habilidade(null, "Poesia dos Bardos", TipoHabilidade.SUPORTE, todasRacas, bardos, 1,
                "Através das inúmeras canções e poemas épicos, você conhece muitas histórias e lendas. Você pode rolar +1d6 quando fizer testes referentes à qualquer tipo de conhecimento. Se o conhecimento em questão for considerado perdido, maçante ou técnico para figurar uma canção ou poema, não há como o Bardo conseguir informações sobre o assunto.",
				"", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Canção do Triunfo", TipoHabilidade.ACAO, todasRacas, bardos, 1,
                "Você canta uma música relembrando os êxitos e vitórias do grupo, seus feitos mais memoráveis e exaltando seus laços de amizade, aumentando a moral do grupo. Todos os seus aliados (incluindo você) que puderem ouvir essa canção recuperam 5 Pontos e Vida por turno, enquanto você continuar a tocar essa Música.",
				"", 0, 25, "Melodia do Repouso", ""));

        habilidades.add(new Habilidade(
                null, "Canção Exultante", TipoHabilidade.ACAO, todasRacas, bardos, 1,
                "Você canta uma música exaltando as capacidades e qualidades dos seus aliados, deixando-os confiantes. Todos os seus aliados (incluindo você) que puderem ouvir essa canção recebem +1 em todos os seus testes enquanto você continuar a tocar essa Música.",
				"", 0, 0, "Melodia do Repouso", ""));

        habilidades.add(new Habilidade(null, "Eloquente", TipoHabilidade.SUPORTE, todasRacas, bardos, 1,
                "Você tem um talento de convencer ou comover outras pessoas apenas falando do jeito certo. Você recebe +1d6 em todos os seus testes para persuadir, mentir, perceber mentiras, intimidar ou em qualquer outra interação social.",
				"", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Evasão", TipoHabilidade.REACAO, todasRacas, bardos, 1,
                "Se o seu inimigo fizer um ataque corporal e acertar, você pode declarar evasão, e obrigar o inimigo a rolar novamente o teste de ataque. Você pode escolher com qual dos resultados o oponente vai ficar. Esta Habilidade só pode ser usada uma vez por rodada.",
                "", 0, 20, "", ""));

        habilidades.add(new Habilidade(null, "Furtivo", TipoHabilidade.SUPORTE, todasRacas, bardos, 1,
                "Você é particularmente discreto quando quer. Você pode rolar +1d6 quando fizer testes para se mover em silêncio, se esconder, camuflar, ou usar disfarces.",
				"", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Grito de Guerra 1", TipoHabilidade.ACAO, todasRacas, bardos, 1,
                "Você pode dar um grito fervoroso que motiva todos seus aliados. Eles recebem (assim como você) +1 em todas as rolagens até o final da batalha. Além disso, remova todos os efeitos de Medo que estiverem afetando os seus aliados. Você não pode usar esta Habilidade se estiver sob qualquer efeito de Medo. Este é um efeito mental.",
				"", 0, 10, "", ""));

        habilidades.add(new Habilidade(null, "Grito Ensurdecedor", TipoHabilidade.ACAO, todasRacas, bardos, 1,
                "Você solta um grito tão alto e poderoso que faz com que todos ao redor fiquem atordoados. Todas as criaturas em uma área de 10 metros à sua frente ficam atordoadas por um número de turnos igual à sua Vontade.",
				"", 0, 10, "", ""));

		habilidades.add(new Habilidade(null, "Grito Estilhaçador", TipoHabilidade.ACAO, todasRacas, bardos, 1,
				"Seu agudo é tão poderoso que você pode direcionar um grito capaz de romper vidros, cristais e tímpanos! Tudo e todos em até 10 metros à sua frente sofrem dano igual a 10/Corte. Criaturas com Corpo Amórfico, objetos inanimados e estruturas que sejam atingidas por esse grito sofrem o dobro do dano.",
				"", 0, 20, "Grito Ensurdecedor", ""));

		habilidades.add(new Habilidade(null, "Língua Afiada", TipoHabilidade.ACAO, todasRacas, bardos, 1,
				"Você possui uma língua ferina e um talento especial para insultar seus adversários. Escolha um inimigo do tipo Humanoide ou Esfinge. Você faz uma série de comentários jocosos ou degradantes sobre ele. Faça um confronto de Vontade contra o alvo. Se você tiver um resultado igual ou maior do que o alvo e se ele for capaz de entendê-lo, ele ataca você em detrimento de qualquer outro alvo, e é considerado Desprevenido para todos os seus aliados – mas não para você. Este é um efeito mental.",
				"", 0, 10, "Eloquente", ""));

		habilidades.add(new Habilidade(null, "Malabarista", TipoHabilidade.SUPORTE, todasRacas, bardos, 1,
				"Você tem uma ótima coordenação para jogar e pegar objetos no ar. Além de poder realizar malabarismos – mesmo usando objetos perigosos como adagas ou tochas – como entretenimento, você recebe +2 em todas as suas jogadas para arremessar objetos e +1 na Defesa contra ataques à distância. Esse bônus de Defesa conta como Esquiva.",
				"", 0, 0, "", ""));

		habilidades.add(new Habilidade(null, "Melodia Dançante", TipoHabilidade.ACAO, todasRacas, bardos, 1,
				"Você toca ritmos empolgantes que fazem com que todos que escutarem esta música sintam uma vontade incontrolável de dançar. Todos os Humanoides que estiverem escutando sua música rolam um confronto de Vontade contra você. Aqueles que tiverem um resultado mais baixo que o seu começarão a dançar incontrolavelmente, realizando todos os seus testes baseados em Agilidade como se fosse Inábil e ficando com Defesa -1 enquanto você continuar a tocar essa Melodia. Este é um efeito mental.",
				"Personagens usando Dança das Espadas são imunes a esse efeito.", null, 20, "", ""));

		habilidades.add(new Habilidade(null, "Melodia do Enjoo", TipoHabilidade.ACAO, todasRacas, bardos, 1,
				"Sua melodia é perfeitamente desconexa e perturbadora. Todas as criaturas vivas que puderem lhe escutar rolam um confronto de Vontade contra você a cada turno em que você continuar tocando. Aqueles que tiverem um resultado mais baixo do que você ficam enjoados, sofrendo um redutor de -1 em sua Defesa e testes de ataque até o final do turno. Qualquer um que obtenha 3 resultados mais baixos que os seus em confrontos para resistir a esse efeito durante um mesmo combate ficarão tão enjoados que vomitarão, ficando Paralisados durante 1 turno.",
				"", 0, 20, "", ""));

		habilidades.add(new Habilidade(null, "Melodia do Repouso", TipoHabilidade.ACAO, todasRacas, bardos, 1,
				"Você toca uma série de canções simples e relaxantes, que permitem que todos os que a ouvirem repousem com serenidade e recobrem suas forças. Qualquer um que escute sua canção por pelo menos 10 minutos – mesmo que esteja dormindo – recupera o dobro de Pontos de Mana e de Pontos de Vida devido ao descanso por aquele período. Tocar a Melodia do Repouso é considerado descanso, e os efeitos dessa música também afetam você.",
				"", 0, 0, "", ""));

		habilidades.add(new Habilidade(null, "Melodia Sonífera", TipoHabilidade.ACAO, todasRacas, bardos, 1,
				"Você toca uma melodia lenta e ritmada, que acalma a ponto de fazer quem a escuta cair no sono. Após 3 turnos ouvindo essa Melodia, todos que puderem escutá-la (menos você) rolam um confronto de Vontade contra você. Aqueles que tiverem um resultado menor que o seu caem em um sono profundo que dura 1 hora. Este é um efeito mental.",
				"", 0, 15, "Melodia do Repouso", ""));

		habilidades.add(new Habilidade(null, "Mestre das Notas", TipoHabilidade.REACAO, todasRacas, bardos, 1,
				"Sempre que você fizer um teste que envolva contar histórias, entreter uma plateia, cantar ou tocar instrumento musicais (incluindo Habilidades do tipo Música) você pode rolar novamente 1 dos dados. Você pode escolher com qual dos resultados vai ficar. Você só pode usar esta Habilidade 1 vez por turno.",
				"", 0, 10, "", ""));

		habilidades.add(new Habilidade(null, "Truque Sujo", TipoHabilidade.ACAO, todasRacas, bardos, 1,
				"Quando estiver em distância corporal do oponente e ele estiver te vendo, faça um Confronto de Inteligência contra o alvo. Se você tiver um resultado igual ou maior do que o do oponente nesse teste, você realiza um truque sujo (joga areia nos olhos do oponente, joga um pano em seu rosto, enrola uma corda em suas pernas, etc.) fazendo com que o alvo fique confuso ou desequilibrado, não podendo realizar nenhuma ação no próximo turno, e sendo considerado Desprevenido por 1 turno.",
				"", 0, 10, "Evasão", ""));

		habilidades.add(new Habilidade(null, "Canção da Sereia", TipoHabilidade.ACAO, todasRacas, bardos, 5,
				"Você canta uma música melancólica capaz de deixar aqueles que a escutam enfeitiçados. Todos que estiverem a até 10 metros de você e puderem ouvir a canção rolam um confronto de Vontade contra você a cada turno enquanto você continuar cantando. Alvos que tenham um resultado menor do que o seu não poderão realizar qualquer ação exceto tentar se aproximar de você enquanto você estiver cantando – ou ficar imóvel lhe observando se estiverem a 1 metro ou menos de você. Esse efeito é cancelado e o alvo fica imune aos seus efeitos até o fim do combate se a vítima sofrer algum dano enquanto estiver sob efeito dessa Música. Enquanto estiver sob o efeito dessa Música o alvo é considerado Desprevenido para todos os seus aliados – mas não para você. Este é um efeito mental.",
				"", 0, 20, "Eloquente", ""));

		habilidades.add(new Habilidade(null, "Canção Desconcentrante", TipoHabilidade.ACAO, todasRacas, bardos, 5,
				"Você canta uma canção com tom jocoso e com uma melodia irritante que prende a atenção dos ouvintes e não permite que eles se concentrem. Todos que estiverem a até 10 metros de você e puderem ouvir a canção rolam um confronto de Vontade contra você a cada turno enquanto você continuar cantando. Alvos que tenham um resultado menor do que o seu são considerados Distraídos até o final do seu próximo turno. Este é um efeito mental.",
				"", 0, 20, "Melodia do Enjoo", ""));

		habilidades.add(new Habilidade(null, "Coração da Batalha", TipoHabilidade.REACAO, todasRacas, bardos, 5,
				"Quando sofrer algum dano proveniente de um ataque, Magia, ou Música você recupera 5 Pontos de Mana. Você só pode usar esta Habilidade uma vez por turno.",
				"", 0, 0, "", ""));

		habilidades.add(new Habilidade(null, "Grito de Guerra 2", TipoHabilidade.ACAO, todasRacas, bardos, 5,
				"Você pode dar um grito fervoroso que motiva todos seus aliados. Eles recebem (assim como você) +2 em todas as rolagens até o final da batalha. Além disso, remova todos os efeitos de Medo que estiverem afetando os seus aliados. Você não pode usar esta Habilidade se estiver sob qualquer efeito de Medo.",
				"", 0, 15, " Grito de Guerra 1", ""));

		habilidades.add(new Habilidade(null, "Grito de Intimidação", TipoHabilidade.ACAO, todasRacas, bardos, 5,
				"Você pode dar um grito para intimidar seus inimigos. Todos os oponentes que estiverem a até 10 metros à sua frente que tiverem uma Determinação menor do que a sua ficam Paralisados por 2 turnos. Esse é um efeito de Medo.",
				"", 0, 35, "Grito de Guerra 1", ""));

		habilidades.add(new Habilidade(null, "Melodia da Fúria", TipoHabilidade.ACAO, todasRacas, bardos, 5,
				"Você toca um ritmo primitivo, que faz com que todos os Humanoides que o escutem sintam seus instintos mais violentos aflorarem. Todos os Humanoides capazes de escutar essa canção desferem seus ataques com mais selvageria, causando +5 de dano, mas sofrendo um redutor de -2 em sua Defesa enquanto você continuar a tocar essa música. Este é um efeito mental.",
				"", 0, 10, "Melodia Dançante", ""));

		habilidades.add(new Habilidade(null, "Melodia dos Animais", TipoHabilidade.ACAO, todasRacas, bardos, 5,
				"Escolha um tipo de Besta (mamífero, réptil ou ave). Todas as criaturas do tipo escolhido que puderem escutar sua música ficarão fascinadas com ela e o seguirão enquanto você continuar a tocar. Os alvos não irão realizar qualquer ação além de seguir você para onde for enquanto você continuar a tocar. Esse efeito é cancelado se o alvo sofrer algum dano enquanto estiver sob efeito dessa Música, mas se você continuar a tocar essa Música o alvo será afetado novamente no começo do seu próximo turno. Este é um efeito mental.",
				"", 0, 10, "Canção da Sereia", ""));

		habilidades.add(new Habilidade(null, "Trapaceiro Impecável", TipoHabilidade.SUPORTE, todasRacas, bardos, 5,
				"Você está acostumado a enganar e mentir, e seu raciocínio se tornou tão condicionado a extrapolar situações rapidamente que até ler (ou mesmo dominar) sua mente é mais difícil! Sua Inteligência é considerada o dobro em Confrontos para tentar esconder ou dissimular a verdade e para calcular sua Determinação contra efeitos mentais – exceto os de medo.",
				"", 0, 0, "Eloquente", ""));

		habilidades.add(new Habilidade(null, "Virtuoso", TipoHabilidade.SUPORTE, todasRacas, bardos, 5,
				"Você treinou exaustivamente até se tornar um mestre no uso de instrumentos musicais. Você rola +1d6 em todos os testes envolvendo tocar instrumentos musicais (incluindo Habilidades do tipo Música).",
				"", 0, 0, "Mestre das Notas", ""));

		habilidades.add(new Habilidade(null, "Vocalista", TipoHabilidade.SUPORTE, todasRacas, bardos, 5,
				"Você treinou sua voz para se tornar mais potente e límpida e sua dicção mais clara e segura. Você recebe +2 em todos os testes que envolvam a fala – como mentir, seduzir, barganhar ou cantar (incluindo Canções, mas não Melodias) – e na sua Determinação para determinar se os alvos de seus Gritos e Rugidos são afetados por seus efeitos. Além disso, seus Gritos e Rugidos têm a área de efeito dobrada.",
				"", 0, 0, "Pelo menos uma Habilidade de Grito", ""));

		habilidades.add(new Habilidade(null, "Canção do Réquiem", TipoHabilidade.ACAO, todasRacas, bardos, 10,
				"Você toca uma música que fala sobre a morte, derrota e fracasso dos ancestrais do alvo e do sofrimento e amarguras que ele ainda provará no futuro. A cada turno em que você canta essa canção e o alvo estiver a menos de 10 metros de você e puder escutá-lo, ele rola um Confronto de Vontade contra você. O alvo tem sua moral tão profundamente atingida pela canção que perde 20 Pontos de Mana sempre que rolar esse Confronto (independente do resultado), e se ficar sem Pontos de Mana devido aos efeitos dessa canção, ele imediatamente entra em um estado de profundo pesar e tristeza, e se entregará sem resistir. Além disso, se tiver um resultado menor do que o seu na rolagem, ele é tomado por um profundo pesar e sofrimento decorrente dos desgostos que já viveu, além das perspectivas de um futuro negro, perdendo 50 Pontos de Vida. Este é um efeito mental.",
				"", 0, 80, "Virtuoso, Canção Desesperadora", ""));

		// Druidas
		habilidades.add(new Habilidade(null, "Conhecimento Místico", TipoHabilidade.SUPORTE, todasRacas, druidas, 1,
				"Você está ligado as energias místicas provenientes de forças superiores e consegue comungar com elas. Você pode ler e utilizar tomos mágicos e desenhar Selos Místicos (veja a página 36 para regras sobre magia). Você também pode entrar em um estado de transe se concentrando por 1 minuto. Enquanto continuar meditando dessa forma, você recupera uma quantidade de Pontos de Mana igual à sua Vontade a cada 10 minutos.",
				"", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Aparar Magia", TipoHabilidade.REACAO, todasRacas, druidas, 1,
                "Sempre que for alvo de uma Magia que cause dano ou perda de vida, você pode reduzir aquele dano ou perda de vida pela metade. Essa Habilidade não afeta quaisquer outros efeitos da magia além de dano ou perda de vida.",
                "Se você tiver Resistência ao tipo de dano que a magia causa, você não sofre dano e evita qualquer outro efeito da magia.", null, 5, "Detectar Magia", ""));

        habilidades.add(new Habilidade(null, "Asas Celestiais", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre uma criatura viva, você faz surgir em suas costas um grande par de asas. O alvo ganha a Habilidade Asas Pesadas. Esse Selo dura por 1 Hora.",
                "", 10, 20, " Caminhada Mágica", ""));

        habilidades.add(new Habilidade(null, "Benção de Ellenis", TipoHabilidade.SUPORTE, todasRacas, druidas, 1,
                "Você é capaz de se comunicar com qualquer Besta do tipo Mamífero, Ave, Réptil ou Peixe. Essa comunicação é rudimentar, baseada nas capacidades da criatura em questão. Além disso, você receber +2 em todas as rolagens envolvendo essas criaturas e poder alterar o temperamento delas em 1 passo (Furioso ou Cruel para Agressivo, Agressivo para Sobrevivente, Sobrevivente para Pacífico e Pacífico para Covarde ou vice-versa) com um teste de Vontade (Dificuldade igual à Determinação do alvo) – esse efeito não funciona em animais com temperamento Servo ou Protetor. Animais selvagens só irão aceitar “conversar” se tiverem temperamento pacífico ou sobrevivente, a menos que estejam aprisionados ou encurralados de alguma forma.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Bestializar", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre qualquer aliado do tipo Besta, Humanóide ou Troglodita, ele recebe +2 de Força e Agilidade e desenvolve garras e dentes afiados (dano igual à Força +2/Corte) pela duração do efeito. Esse Selo Místico dura 1 minuto.",
                "", 11, 20, "Benção de Ellenis", ""));

        habilidades.add(new Habilidade(null, "Bons Frutos", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre uma planta você faz com que ela desenvolva flores, frutas ou raízes. Uma planta só vai gerar flores ou frutos se ela normalmente for capaz disso. Utilizando essa magia sobre uma planta comestível, é possível alimentar um número de pessoas igual à sua Vontade. Um personagem que consuma uma dessas plantas recupera o dobro de Pontos de vida e Mana por descanso durante as próximas 6 horas. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                "", 8, 0, "Sabedoria Selvagem", ""));

        habilidades.add(new Habilidade(null, "Caminhada Mágica", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre uma criatura viva, você permite que ela possa caminhar sobre qualquer tipo de superfície (incluindo líquidos), paredes ou teto e não sofre nenhum tipo de redutor ou penalidade de movimentação por terrenos difíceis ou acidentados. Finalmente, o alvo pode escolher á vontade se vai deixar rastros ou não enquanto esta runa estiver ativa sobre ele. Esse Selo Místico dura 1 hora.",
                "", 9, 10, "", ""));

        habilidades.add(new Habilidade(null, "Companheiro Animal 1", TipoHabilidade.SUPORTE, todasRacas, druidas, 1,
                "Você possui uma ligação de fidelidade com um animal. Escolha uma Besta dos tipos Mamífero, Ave, Réptil ou Peixe e faça um teste de Vontade (Dificuldade igual à soma de todos os atributos do animal +1 para cada metro de tamanho que o animal tiver). Se passar no teste, o animal escolhido será atraído para você e lhe será fiel até a morte (ele passa a ter o temperamento Protetor). Se o animal morrer, você pode tentar atrair outro animal – que não precisa ser do mesmo tipo escolhido anteriormente – com fazendo o mesmo teste. Este teste pode ser realizado 1 vez por dia. Você pode atrair 1 animal de cada vez com essa Habilidade.",
                "Se essa Habilidade for escolhida durante a criação do personagem, o animal já estará com você, sem a necessidade de qualquer teste para atraí-lo, desde que a dificuldade para atraí-lo seja menor do que a soma dos Atributos do personagem.", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Companheiro Animal 2", TipoHabilidade.SUPORTE, todasRacas, druidas, 1,
                "Seu companheiro animal recebe +1 em 2 Atributos à sua escolha, +5 Pontos de vida e +5 Pontos de Mana. Além disso, seu companheiro Animal recebe uma Habilidade do tipo Técnica à sua escolha (desde que faça sentido; o Mestre tem a palavra final sobre o assunto).",
                "", 0, 0, "Companheiro Animal 1", ""));

        habilidades.add(new Habilidade(null, "Convocar Animais", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre si mesmo, você consegue atrair todas as Bestas escolhidas entre Mamífero, Ave, Réptil ou Peixe que estejam a até 1 km de você. Os animais não estarão sob seu controle, mas se sentirão inclinados a ajudá-lo dentro de suas capacidades – animais com temperamento pacífico ou covarde não irão entrar em combate, mas animais sobreviventes ou agressivos não terão problemas com isso. Esse Selo Místico dura 1 hora. Depois disso, as Bestas afetadas voltarão pacificamente para os locais de onde vieram.",
                "Você pode refinar o tipo específico de animal ('Ursos', 'Marsupiais', 'Batráquios') ou até mesmo um animal específico ('Aquele esquilo com quem eu conversei ontem', 'meu Companheiro Animal', 'O cão do guarda-caça') quando conjurar essa magia.", 10, 10, "Benção de Ellenis", ""));

        habilidades.add(new Habilidade(null, "Detectar Magia", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Concentrando-se nos fluxos de energias mágicas, você pode enxergar a aura de objetos mágicos, Runas Arcanas e Selos Místicos. Você pode analisar a aura mágica de um Selo, Runa ou objeto para entender suas propriedades observando-a por 1 minuto.",
                "", 8, 0, "", ""));

        habilidades.add(new Habilidade(null, "Entrelaçar", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre o solo você faz com que plantas comecem a brotar e agarrem um alvo que esteja com os pés no chão, reduzindo seu Deslocamento a 0 e sua Agilidade em -2 enquanto estiver preso dessa forma. Para se soltar, ele (ou outro personagem) deve passar uma quantidade de turnos igual à Vontade do conjurador cortando as plantas (com uma arma que faça dano por corte), ou passar em um teste de Força (Dificuldade igual à Determinação do conjurador). As plantas murcham e se desfazem após 1 minuto. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                "", 10, 10, "Sabedoria Selvagem", ""));

        habilidades.add(new Habilidade(null, "Espírito Animal", TipoHabilidade.SUPORTE, todasRacas, druidas, 1,
                "Seu espírito possui a forma de um animal. Escolha um Espírito Animal para ser seu guia. Essa escolha é permanente.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Evocar Temporal", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre si mesmo, você inicia uma poderosa tempestade de chuva ou vento. A tempestade cobre uma área de 1 km de diâmetro e se move conforme você se desloca, permanecendo centrada em você. Todos na área realizam seus testes como se fossem Inaptos. O temporal leva 3 turnos para se formar e o Selo Místico se dissipa em um número de minutos igual à sua Vontade.",
                "", 11, 20, "Princípio Natural", ""));

        habilidades.add(new Habilidade(null, "Fruto Revigorante", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre uma planta frutífera – mesmo morta – você faz com que ela desenvolva um único fruto grande e suculento capaz de restaurar 30 Pontos de Vida de quem o ingerir. Se não for ingerida, a fruta perde sua capacidade de cura após 1 minuto. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                "", 10, 10, "Bons Frutos", ""));

        habilidades.add(new Habilidade(null, "Herbalismo", TipoHabilidade.SUPORTE, todasRacas, druidas, 1,
                "Você pode rolar testes de Inteligência para criar poções básicas e, enquanto estiver em um ambiente selvagem, você e seus aliados não são afetados por doenças e venenos naturais – seus aliados passam a ser imunes depois de um dia inteiro que estiverem com você, desde que eles aceitem suas dicas do que comer e do que não comer. Além disso, enquanto estiver em terreno natural que possa fornecer ervas, folhas e frutos (qualquer lugar exceto cidades, desertos ou regiões glaciais) você sempre faz testes de primeiros socorros como se tivesse um Kit de Cura à mão.",
                "", 0, 0, "Sabedoria Selvagem", ""));

        habilidades.add(new Habilidade(null, "Mover Terra", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Você desenha um Selo Místico sobre o solo, fazendo com que ele se mova subitamente sob os pés de seus adversários (todos em uma área de 2 metros de diâmetro dentro de sua área de visão precisam fazer um teste de Agilidade com Dificuldade igual à sua Determinação ou cairão). Você também pode abrir uma passagem através de pedra ou terra. Essa passagem terá aproximadamente 2 metros de diâmetro e uma profundidade igual à sua Vontade em metros. Você pode deixar a passagem aberta, criando um túnel, ou fechá-la atrás de si depois que passar. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                "", 11, 15, "Princípio Natural", ""));

        habilidades.add(new Habilidade(null, "Princípio Natural", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Você desenha um Selo Místico no ar que se transforma em uma pequena quantidade de terra, água ou ar. Um punhado de terra pode ser usado para nutrir uma pequena planta, uma porção de água pode ser usada para matar a sede de uma pessoa e uma porção de ar criado desse modo permite que uma criatura respire normalmente por até 10 minutos debaixo d’água. Essa magia pode ser conjurada na forma de uma rajada mágica. Uma rajada de água pode apagar uma chama do tamanho de uma fogueira de acampamento, uma rajada de ar derruba ou espalha objetos leves e pequenos e uma rajada de pedras causa dano igual a 8/ Contusão. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados e qualquer quantidade de terra, água ou ar criada são permanentes.",
                "", 8, 0, "", ""));

        habilidades.add(new Habilidade(null, "Rajada de Água", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Você desenha um Selo Místico no ar de onde uma massa de água jorra em um poderoso jato. Um alvo dentro de sua linha de visão sofre dano igual a 6/Contusão e precisa vencer uma rolagem de Força (Dificuldade igual à Determinação do conjurador) para não cair. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados mas qualquer quantidade de água criada é permanente.",
                "", 10, 10, "Princípio Natural", ""));

        habilidades.add(new Habilidade(null, "Rajada de Espinhos", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico em um item de madeira você faz com que ele desenvolva espinhos longos e afiados que se projetam atingindo um número de alvos igual à sua Vontade que estiverem à uma distância de até 10 metros à sua frente, causando dano igual à 12/Perfuração. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                "", 10, 10, "Sabedoria Selvagem", ""));

        habilidades.add(new Habilidade(null, "Sabedoria Selvagem", TipoHabilidade.SUPORTE, todasRacas, druidas, 1,
                "Você passou muito tempo em ambientes selvagens e dedicou muito tempo ao estudo da natureza em todas as suas formas. Você rola +1d6 em testes que envolvam a natureza como forragear, rastrear, encontrar abrigo, identificar ervas, etc.",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "Turbilhão", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "Desenhando um Selo Místico sobre você mesmo e em seguida realizando um rápido movimento circular com as mãos você dispara poderosas rajadas de água. Todas as criaturas a até 10 metros de você sofrem um dano igual à 6/contusão e precisam vencer um teste de Força (Dificuldade igual à sua Determinação) para não serem arremessados um número de metros igual à sua Vontade e ficando caídos. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados e qualquer quantidade de água criada é permanente.",
                "", 12, 25, "Rajada de àgua", ""));

        habilidades.add(new Habilidade(null, "", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "",
                "", 0, 0, "", ""));

        habilidades.add(new Habilidade(null, "", TipoHabilidade.ACAO, todasRacas, druidas, 1,
                "",
                "", 0, 0, "", ""));
        return gravarHabilidades(habilidades);
    }

    public List<Habilidade> listarHabilidades() {
        return habilidadeRepository.findAll();
    }

    public Habilidade obterHabilidadePeloId(long id) {
        return habilidadeRepository.findById(id);
    }
}