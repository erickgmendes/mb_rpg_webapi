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

    public String cargaInicial() {
        String retorno = "";

        if (habilidadeRepository.count() == 0)
            return cargaHabilidades();

        return "Não foi possível carregar Habilidades";
    }

    public HabilidadeService() {
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

        // G E R A I S

        habilidades.add(new Habilidade(null, "Agilidade Heróica", TipoHabilidade.SUPORTE, todasRacas,
                todasClasses, 5,
                "Você possui uma agilidade e flexibilidade que já lhe salvaram em muitas ocasiões. Você tem Agilidade +1",
                null, null, 5, null, "Agilidade+1"));

        habilidades.add(new Habilidade(null, "Atletismo", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
                "Você treinou exercícios físicos durante muito tempo – seja por vontade própria ou por necessidade – e é muito bom nisso. Você recebe +2 em testes para correr, escalar, nadar, se equilibrar, prender o fôlego ou qualquer outra atividade que exija força física e coordenação motora. Esse bônus também se aplica em testes para evitar ser derrubado.",
                null, null, null, null, null));

        habilidades.add(new Habilidade(null, "Força Heróica", TipoHabilidade.ACAO, todasRacas, todasClasses, 5,
                "Você possui uma força e resistência forjadas na batalha. Você tem Força +1.", null, null, null, null,
                "Força+1"));

        habilidades.add(new Habilidade(null, "Força Interior", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
                "Você é capaz de se manter em pé usando sua vontade e força interiores. Você recupera 5 Pontos de Vida.",
                null, null, null, "Vontade 4 ou mais.", null));

        habilidades.add(new Habilidade(null, "Inteligência Heroica", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 5,
                "Você possui uma percepção e uma capacidade de raciocínio extremamente afiadas. Você tem Inteligência +1.",
                null, null, null, null, "Inteligência+1"));

        habilidades.add(new Habilidade(null, "Nanismo", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
                "Você é menor do que a média de sua raça – em média entre 1 e 1,2 metros de altura. Você pode rolar +1d6 quando fizer testes para se esconder, se mover em silêncio ou passar despercebido de qualquer forma. Além disso, seu bônus automático de Defesa é 6 ao invés de 5. No entanto, armas corporais que requerem duas mãos são grandes demais para que você possa usá-las com eficiência, e você precisa usar ambas as mãos para usar qualquer arma corporal com FN 5 ou mais.",
                "Você só pode selecionar essa Habilidade durante a criação do personagem.", null, null, null, null));

        habilidades.add(new Habilidade(null, "Nervos de Aço", TipoHabilidade.ESPECIAL, todasRacas, todasClasses, 5,
                "Você tem um autocontrole invejável e é capaz de se concentrar mesmo quando outros entrariam em desespero. Você tem +20 Pontos de Mana.",
                null, null, null, null, "Mana+20"));

        habilidades.add(new Habilidade(null, "Recursos", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
                "Você possui (ou possuía) um pequeno negócio ou vem de uma família nobre. Você começa o jogo com o dobro das moedas inicias.",
                "Esta habilidade só pode ser escolhida durante a criação do Personagem.", null, null, null, null));

        habilidades.add(new Habilidade(null, "Vontade de Ferro", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 5,
                "Você não se entrega com facilidade e é muito difícil derrubar você em combate. Você tem +20 Pontos de vida.",
                null, null, null, null, "PV+20"));

        habilidades.add(new Habilidade(null, "Vontade Heróica", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 5,
                "Sua determinação e autoconfiança são quase inabaláveis. Você tem Vontade +1.", null, null, null, null,
                "Vontade+1"));

        // R A Ç A S

        // Todas menos Aesir
        habilidades.add(new Habilidade(null, "Fúria de Batalha", TipoHabilidade.REACAO, todasRacasMenosAesir, todasClasses, 1,
                "Quando você é ferido você é tomado por uma irrefreável fúria destrutiva, ficando neste estado até o final do combate – ou até ficar dois turnos sem atacar. Você precisa sofrer pelo menos 1 ponto de dano de qualquer fonte – inclusive auto-infligido – para que essa Habilidade possa ser ativada. Enquanto estiver em Fúria, você recebe Força +2 e fica imune a efeitos de Medo.",
                null, null, 30, null, "Força+2"));

        // Todas menos Mahok
        habilidades.add(new Habilidade(null, "Sentidos Apurados", TipoHabilidade.SUPORTE, todasRacasMenosMahok, todasClasses, 1,
                "Você possui sentidos treinados e extremamente apurados e aprendeu a confiar instintivamente no que eles captam. Você recebe +2 em todos os testes de para perceber, procurar, observar, ouvir ou usar seus cinco sentidos e também em testes de Iniciativa.",
                null, null, 0, null, "Força+2"));

        // Faunos
        habilidades.add(new Habilidade(null, "Patas com Cascos", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Você possui fortes patas munidas de cascos resistentes. Você pode rolar +1d6 quando fizer testes de correr, saltar ou desviar de obstáculos, e seu Deslocamento é aumentado em 1. Além disso, se fizer ataques desarmados com seus cascos, seu dano será Força +2/Contusão.",
                null, null, null, null, "Força+2"));

        habilidades.add(new Habilidade(null, "Cascos Ágeis", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Você é mais ágil e veloz do que a maioria dos Faunos. Você tem Agilidade +1, Deslocamento +1 e a distância dos seus saltos é aumentada em 1 metro.",
                null, null, null, null, "Agilidade+1;Deslocamento+1"));

        habilidades.add(new Habilidade(null, "Flauta de Pã", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Você ouviu, tocou e dançou várias músicas ao redor de fogueiras com seu povo – e talvez com aqueles que você encontrou em suas andanças – e adquiriu uma imensa prática em vários estilos de instrumentos de sopro. Sempre que estiver usando uma flauta ou outro instrumento de sopro, a você recebe +2 em seus testes para executar músicas (incluindo as Habilidades do tipo Música).",
                null, null, null, null, null));

        habilidades.add(new Habilidade(null, "Marrada", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Você pode desferir um poderoso golpe com seus chifres. Este é um ataque desarmado que causa dano igual à Força +2/Contusão. Caso use esse ataque com uma ação de Encontrão, o alvo precisa vencer um teste de Força (Dificuldade igual à sua Determinação +2) ou será derrubado.",
                null, null, null, null, null));

        habilidades.add(new Habilidade(null, "Patas Fortes", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                " Você possui pernas mais fortes do que a maioria dos membros da sua raça. Você pode rolar +1d6 quando fizer testes de corrida, salto, evitar quedas, etc. Além disso, o dano dos seus ataques com cascos é aumentado em +2.",
                null, null, null, null, null));

        habilidades.add(new Habilidade(null, "Pintura Corporal", TipoHabilidade.SUPORTE, faunos, todasClasses, 1,
                "Pinturas corporais são comuns entre os Faunos, utilizadas em rituais ou simplesmente como forma de expressão artística. Você deposita muita fé nos significados tradicionais das pinturas, ao ponto de conseguir se beneficiar dessa convicção quando estiver usando uma pintura. Sempre que estiver usando uma pintura corporal e que ela esteja completamente à mostra, você recebe um dos benefícios listados. Apenas uma pintura corporal pode ser usada por vez. Uma pintura corporal dura até você tomar banho – intencionalmente ou não! - ou dormir. Pintura de Caça: Realizada ao redor dos olhos e nas mãos. Você recebe +1 em seus testes ligados à visão e ataques à distância. Além disso, seus ataques à distância causam +1 de dano. Pintura de Guerra: Realizada nos braços, mãos e peito. Seus ataques corporais causam +2 de dano e você recebe Defesa +1 (Este é um bônus de esquiva). Pintura de Oração: Realizada ao redor da boca e pescoço. Você recebe +2 em todos os seus testes ligados à sua voz e instrumentos musicais de sopro, incluindo interações sociais (como convencer ou mentir) e cantar ou usar instrumentos musicais de sopro (incluindo Habilidades do tipo Música). Pintura Ritual: Realizada no peito e no rosto. Você recebe +1 em todos os seus testes ligados à liguagem corporal (como dançar, seduzir ou detectar mentiras) e Habilidades do tipo Magia. Especial: A tintura necessária para a pintura é feita com materiais simples, facilmente encontrados na natureza (como folhas ou frutas trituradas, carvão e argila) e geralmente não tem custo, mas o Mestre pode exigir que o personagem gaste meia hora em busca dos materiais necessários e no preparo da tintura. O processo de aplicar a pintura demora cerca de 10 minutos, e exige sucesso num teste de Inteligência (Dificuldade 8) que pode ser realizado por você mesmo ou por alguém em quem você confia.",
                null, null, null, null, null));

        // Faunos e Jubans
		habilidades.add(new Habilidade(null, "Sentidos de Caçador", TipoHabilidade.SUPORTE, faunos_Jubans, todasClasses, 1,
				"Você possui uma audição aguçada e uma visão treinada. Você rola +1d6 em todos os seus testes de Inteligência envolvendo percepção, para perceber e rastrear alvos.",
				null, null, null, null, null));

		// Faens e Elfos
		habilidades.add(new Habilidade(null, "Herança Feérica", TipoHabilidade.SUPORTE, faens_elfos, todasClasses, 1,
				"Você possui algumas características comuns aos seus ancestrais feéricos. Você é imune a qualquer efeito mental e efeito de medo além de perceber automaticamente ilusões. Você também ganha +5 Pontos de Mana.",
				null, null, null, null, "Mana+5"));

		habilidades.add(new Habilidade(null, "Dom da Magia", TipoHabilidade.SUPORTE, faens_elfos, todasClasses, 1,
				"Você é capaz de canalizar magias muito mais facilmente. As dificuldades de todas as Magia são diminuídas em 1 para você. Você também tem +5 Pontos de Mana.",
				null, null, null, null, "Mana+5"));

		habilidades.add(new Habilidade(null, "Invisibilidade Natural", TipoHabilidade.ACAO, faens_elfos, todasClasses, 1,
				"Você possui uma das habilidades mais características das fadas. Você é capaz de se mesclar à vegetação à sua volta, ficando invisível por até uma hora. É preciso estar em uma área com vegetação densa – um bosque, um jardim de topiarias ou uma estufa, por exemplo – e o efeito é cancelado se você deixar a área de vegetação, sofrer algum dano, atacar ou lançar uma magia.",
				null, null, 10, "Herança Feérica", null));

		habilidades.add(new Habilidade(null, "Luzes das Fadas", TipoHabilidade.ACAO, faens_elfos, todasClasses, 1,
				"Você possui uma habilidade comuns às fadas. Você pode criar até três pequenos globos de luz que ficam dançando pelo ar. Você pode comandá-los, mas eles não podem se afastar mais que três metros do você. Eles duram uma hora, mas você pode dispersá-los quando desejar. Os globos produzem iluminação igual à de uma tocha, e você pode realizar um ataque à distância para atingir os olhos de um alvo com um dos globos de luz (que se extingue no processo), deixando-o Distraído por 1 turno.",
				null, null, 15, "Herança Feérica", null));

		// Faunos, Elfos e Tailox
		habilidades.add(new Habilidade(null, "Raça Florestal", TipoHabilidade.SUPORTE, faunos_elfos_tailox, todasClasses, 1,
				"Você se sente confortável e renovado quando está sob a proteção da vegetação. Quando estiver dentro de uma floresta, bosque ou selva você recebe +2 em todos os seus testes.",
				null, null, null, null, ""));

		// Aesires e Jubans
		habilidades.add(new Habilidade(null, "Robustez", TipoHabilidade.SUPORTE, aesires_jubans, todasClasses, 1,
				"Você possui uma constituição vigorosa para os padrões da sua raça. Você tem +5 Pontos de vida e rola +1d6 em testes de Força para resistir à fadiga, venenos e doenças.",
				null, null, null, null, null));

		// Firas e Levents
		habilidades.add(new Habilidade(null, "Mente Iluminada", TipoHabilidade.SUPORTE, firas_levents, todasClasses, 1,
				"Você possui uma clareza única de raciocínio. Você tem Vontade +1 e +5 Pontos de Mana.", null, null,
				null, null, "Vontade+1;Mana+5"));

		// Anões e Mahoks
		habilidades.add(new Habilidade(null, "Estabilidade", TipoHabilidade.SUPORTE, anoes_mahoks, todasClasses, 1,
				" Você gosta de ter os dois pés solidamente plantados no chão – e faz isso muito bem! Você sempre rola +1d6 em todos os seus testes de evitar quedas e manter o equilíbrio.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Nascido nas Montanhas", TipoHabilidade.SUPORTE, anoes_mahoks, todasClasses, 1,
				"Você nasceu ou passou grande parte da sua vida em ambientes montanhosos. Você recebe +2 em seus testes ligados à locais rochosos e montanhosos – como escalar rocha (nua ou trabalhada), percepção e sobrevivência em áreas montanhosas, identificar animais dessas regiões, avaliar formações rochosas e pedras brutas ou trabalhadas (incluindo construções de pedra e pedras preciosas) e para trabalhar em pedra – seja artesanato, alvenaria ou joalheria.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Audácia", TipoHabilidade.SUPORTE, humanos_tailox, todasClasses, 1,
				"Você enfrenta ameaças e situações de perigo com entusiasmo. Sempre que estiver frente à uma situação de risco eminente – saltar entre duas bordas de um precipício, equilibrar-se em uma corda sobre um rio de lava, entrar em um combate ou qualquer situação em que você possa potencialmente perder a vida (ou pelo se ferir seriamente), você recupera imediatamente 10 Pontos de Vida ou 10 Pontos de Mana, à sua escolha. Essa Habilidade só pode ser usada uma vez para cada situação de risco, e apenas quando o risco se apresentar – não depois da sua primeira ação em um combate ou depois de cair, por exemplo.",
				null, null, null, null, null));

		// Humanos e Mahoks
		habilidades.add(new Habilidade(null, "Gregário", TipoHabilidade.SUPORTE, humanos_mahoks, todasClasses, 1,
				"Você consegue compreender muito rapidamente as estruturas sociais de uma cultura e seus indivíduos e é capaz de fazer amigos em qualquer lugar. Depois de cinco minutos de conversa, a pessoa com quem você esteja interagindo – e que não seja obviamente hostil a você, como um captor ou um inimigo jurado – torna-se propensa a ajudá-lo. Essa Habilidade geralmente serve para colher informações gerais (apesar de segredos não serem possíveis de conseguir) ou pequenos favores – como ser apresentado a alguém ou conseguir uma cerveja de graça. Você também recebe +2 em testes de seduzir, mentir, detectar mentiras ou qualquer outra interação social.",
				null, null, null, null, null));

		// Faens
		habilidades.add(new Habilidade(null, "Constituição Feérica", TipoHabilidade.SUPORTE, faens, todasClasses, 1,
				"Você possui uma constituição leve e um par de asas que lhe permitem voar. Você pode voar em qualquer direção (com o dobro da sua movimentação normal) e pode parar no ar. No entanto, suas asas precisam bater continua e velozmente, e você não pode planar nem permanecer no ar por mais do que uma hora antes de ter que descansá-las por pelo menos meia hora. Enquanto está voando, o bater das suas asas produzem um zumbido característico e facilmente audível, e é impossível para você se mover em silêncio enquanto voa.",
				"O dano de qualquer manobra de Encontrão usada em voo é duplicado (mas o dano da arma que você usar no Encontrão não é alterado, nem quaisquer outros possíveis efeitos de Encontrão).",
				null, null, null, null));

		habilidades.add(new Habilidade(null, "Isnuu", TipoHabilidade.SUPORTE, faens, todasClasses, 1,
				"Você nasceu com uma grande afinidade com a magia. Sua pele e seus cabelos são de tons esverdeados, e você pode selecionar Habilidades da lista do Feiticeiro como se fossem da sua Habilidade – desde que preencha os requisitos. Além disso, as dificuldades de todas as Magia são diminuídas em 1 para você.",
				"Você só pode selecionar essa Habilidade durante a criação do personagem", null, null, null, null));

		habilidades.add(new Habilidade(null, "Presença Real", TipoHabilidade.SUPORTE, faens, todasClasses, 1,
				"Você é capaz de uma comunicação rudimentar – dentro das capacidades do animal – com qualquer Besta do tipo insectóide ou aracnídeos, e é capaz de dar comandos simples que serão obedecidos prontamente, dentro das capacidades da criatura. Você também é automaticamente bem sucedido em testes de Força para resistir quando for afetado por qualquer Habilidade do tipo Característica de todas as criaturas dos tipos Aracnídeo e Insectóide. Além disso, todas as suas Habilidades que envolvam criaturas do tipo Besta (Companheiro Animal, Convocar animais, Forma Animal e guardião da Natureza) passam a incluir criaturas dos tipos Aracnídeo e Insectóide.",
				null, null, 5, null, null));

		habilidades.add(new Habilidade(null, "Voador Exímio", TipoHabilidade.SUPORTE, faens, todasClasses, 1,
				"Você praticou voos de longa duração, tendo passado muito tempo no ar, adquirindo uma resistência e habilidade incomum de voo. Você pode voar continuamente por até seis horas antes de precisar parar para descansar suas asas, e recebe Defesa +1 enquanto estiver voando (este é um Bônus de Esquiva).",
				null, null, null, "Força 3", "Defesa+1"));

		// Elfos
		habilidades.add(new Habilidade(null, "Benção de Lathellanis", TipoHabilidade.SUPORTE, elfos, todasClasses, 1,
				"A proteção de Lathellanis é evidente em você, assim como uma pálida sombra da astúcia da divindade da natureza. Você é imune à todas as doenças de origem natural ou mágica, Dreno de Energia e efeitos que causem Envelhecimento (de qualquer tipo ou origem). Além disso, Você rola +1d6 em todos os seus testes de Inteligência para perceber e rastrear alvos.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Arborícola", TipoHabilidade.SUPORTE, elfos, todasClasses, 1,
				"Você passou muitos anos explorando as copas das árvores, e se sente à vontade entre os galhos. Você é automaticamente bem-sucedido em testes para escalar árvores e seu Deslocamento não é reduzido quando estiver se movimentando pelas copas das árvores. Você também recebe um bônus de +2 em todos os seus testes para se mover em silencio, se esconder e se movimentar enquanto estiver em cima de uma árvore.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Intelecto Élfico", TipoHabilidade.SUPORTE, elfos, todasClasses, 1,
				"Seu raciocínio é veloz e objetivo. Você tem Inteligência +1 e +5 Pontos de Mana.", null, null, null,
				null, "Inteligência+1;Mana+5"));

		// Anões
		habilidades.add(new Habilidade(null, "Coração da Montanha", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
				"Sua constituição foi forjada nos subterrâneos agrestes e impiedosos, onde apenas os mais resistentes conseguem sobreviver. Você é imune a todos os venenos naturais e mágicos e rola +1d6 em testes para resistir à fadiga, doenças e quaisquer outros efeitos físicos. Além disso, sua Carga é calculada como se você tivesse Força +2.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Cabeça Dura", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
				"Você é extremamente teimoso e é muito difícil dissuadi-lo de uma opinião, intimidá-lo, controlar sua mente ou manipulá-lo de qualquer forma. Você tem Vontade +1 e Determinação +2.",
				null, null, null, null, "Vontade+1;Determinação+2"));

		habilidades.add(new Habilidade(null, "Coração da Montanha 2", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
				"Você é ainda mais vigoroso e resistente que a maioria dos Anões. Você tem +5 Pontos de Vida e é imune à todas as doenças de origem natural ou mágica e rola +1d6 em testes para resistir a quaisquer efeitos de fadiga ou outros efeitos físicos. Esse bônus se acumula com o bônus de Vigor da Montanha.",
				null, null, null, null, "PV+5"));

		habilidades.add(new Habilidade(null, "Duro como Pedra", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
				"Sua pele é mais grossa e resistente que a da maioria dos outros Anões. Você tem +10 Pontos de Vida e Defesa +1 (esse bônus de Defesa conta como Armadura).",
				"Você só pode selecionar essa Habilidade durante a criação do personagem.", null, null, null,
				"PV+10;Defesa+1"));

		habilidades.add(new Habilidade(null, "Forjado à Fogo", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
				"Você passou muito tempo nas forjas ou nasceu abençoado por Hou com uma resistência inata ao fogo e seus malefícios. Você possui Resistência ao Fogo e sua visão e respiração não são afetadas por fumaça.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Raça Subterrânea", TipoHabilidade.SUPORTE, anoes, todasClasses, 1,
				"Você está acostumado aos ambientes subterrâneos e se sente confortável neles. Quando estiver dentro de cavernas ou em ambientes subterrâneos, você ganha +1 em todos os testes. Você também consegue enxergar na completa escuridão, mas nessas condições não consegue distinguir cores.",
				null, null, null, null, null));

		// Aesires
		habilidades.add(new Habilidade(null, "Vigor Nórdico", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
				"Você nasceu em uma região gelada, e os rigores climáticos de Eishelm tornaram você vigoroso e resiliente. Você é Resistente à Frio e não é afetado nem por efeitos de climas gelados nem por efeitos provenientes de danos por Frio (como Enregelamento).",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Berserkir", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
				"Você é um escolhido do Urso como seu protegido, e é amparado pela resistência dele quando evoca a Fúria Bestial. Enquanto estiver em Fúria Bestial, você fica Resistente à Corte, Resistente à Perfuração e Resistente à Contusão. Você não pode estar usando armaduras ou escudos para que essa Habilidade tenha efeito, já que o Urso espera que você considere a proteção dele acima de qualquer proteção mundana.",
				"Se você tiver um Espírito Animal que não seja o Urso, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Urso como seu Espírito Animal.",
				null, 30, "Fúria Bestial, Vontade 4", null));

		habilidades.add(new Habilidade(null, "Bravura Selvagem 1", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
				"Você confia mais nas suas habilidades naturais do que em armaduras para se defender. Quando não estiver usando armadura, você recebe +2 em sua Defesa. Quando escolhe essa Habilidade, você deve escolher se este será um bônus de Bloqueio ou Esquiva. Essa escolha é permanente e não pode ser mudada mais tarde.",
				null, null, null, null, "Defesa+2"));

		habilidades.add(new Habilidade(null, "Bravura Selvagem 2", TipoHabilidade.SUPORTE, aesires, todasClasses, 5,
				"Você veste sua bravura em batalha melhor do que alguns vestem armaduras. O Bônus Defesa conferido por Bravura Selvagem 1 aumenta para +4 e você pode escolher se esse bônus será de Bloqueio ou Esquiva no início de cada um de seus turnos, como uma ação livre.",
				null, null, null, "Bravura Selvagem 1", null));

		habilidades.add(new Habilidade(null, "Fúria Bestial", TipoHabilidade.ACAO, aesires, todasClasses, 1,
				"Você foi tocado pelo espírito do Urso ou pelo espírito do Lobo, e pode invocar a fúria que provém do instinto de sobrevivência deles. Enquanto estiver neste estado você recebe Força +2 e fica imune a Efeitos de Medo. Este efeito dura até o final da batalha ou até que você fique dois turnos sem atacar. Você não pode estar em Fúria Bestial e Fúria de Batalha ao mesmo tempo.",
				"Se você tiver um Espírito Animal que não seja o Urso ou o Lobo, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Lobo ou o Urso como seu Espírito Animal.",
				null, null, null, null));

		habilidades.add(new Habilidade(null, "Potência", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
				"Você é mais forte e resistente do que a maioria dos indivíduos da sua raça. Você tem Força+1 e +5 Pontos de Vida.",
				null, null, null, null, "Força+1;PV+5"));

		habilidades.add(new Habilidade(null, "Ulfhednar", TipoHabilidade.SUPORTE, aesires, todasClasses, 1,
				"O Lobo considerou você um guerreiro digno, e ele lhe imbuirá de sua selvageria quando você evocar a Fúria Bestial, desferindo ataques muito mais violentos. O bônus de Força de Fúria Bestial passa a ser +4 e seus ataques desarmados causam +2 de dano. Você não pode estar usando armadura ou escudos para que essa Habilidade tenha efeito – já que o Lobo despreza a defesa em detrimento do ataque.",
				"Se você tiver um Espírito Animal que não seja o Lobo, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Lobo como seu Espírito Animal.",
				null, null, "Fúria Bestial, Vontade 4", null));

		// Firas
		habilidades.add(new Habilidade(null, "Habitante do Deserto", TipoHabilidade.SUPORTE, firas, todasClasses, 1,
				"Você descende de um povo que enfrentou os rigores do deserto sem esmorecer. Você é Resistente a Fogo e pode passar até 5 dias sem precisar ingerir água. Além disso, você não é afetado por climas particularmente quentes ou áridos.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Chamas Internas 1", TipoHabilidade.ACAO, firas, todasClasses, 1,
				" O Vigor de Hou incendeia seu espírito e encandece seu corpo. Você é capaz de produzir tanto calor em seu interior que se torna incandescente durante 1 minuto, ficando Imune à Fogo (ou, se você já possui Imunidade à Fogo, você passa a absorver fogo, recuperando uma quantidade de Pontos de Vida iguais à qualquer quantidade de dano por fogo que sofreria). Além disso, qualquer um que toca-lo (ou que seja atingido por seus ataques desarmados) sofre dano igual à 6/Fogo.",
				null, null, 10, null, null));

		habilidades.add(new Habilidade(null, "Chamas Internas 2", TipoHabilidade.ACAO, firas, todasClasses, 1,
				"O Vigor de Hou incendeia seu espírito e encandece seu corpo. Você é capaz de produzir tanto calor em seu interior que se torna incandescente durante 1 minuto, ficando Imune à Fogo (ou, se você já possui Imunidade à Fogo, você passa a absorver fogo, recuperando uma quantidade de Pontos de Vida iguais à qualquer quantidade de dano por fogo que sofreria). Além disso, qualquer um que toca-lo (ou que seja atingido por seus ataques desarmados) sofre dano igual à 6/Fogo.",
				null, null, 20, "Chamas Internas 1", null));

		habilidades.add(new Habilidade(null, "Cavaleiro Experiente", TipoHabilidade.SUPORTE, firas, todasClasses, 1,
				"Você passou muito tempo com animais de montaria e conhece seus hábitos, características e como lidar com eles. Você recebe +1d6 em todas as suas rolagens referentes à criaturas com a Habilidade Montaria – incluindo cavalgar, treinar e atacar.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Fulgurante", TipoHabilidade.ACAO, firas, todasClasses, 1,
				"Seus olhos são um reflexo do brilho de Hou que queima dentro de você. Você é capaz de enxergar normalmente no escuro, e não é afetado por efeitos que restrinjam a visão – como fumaça, poeira, areia, chuva, magias que causem cegueira, etc. No entanto, seus olhos sempre emitem um brilho considerável, e isso torna sua presença extremamente fácil de notar, principalmente no escuro. Você sempre realiza seus testes para se esconder como se fosse Inapto.",
				"Você só pode selecionar essa Habilidade durante a criação do personagem.", null, null, null, null));

		habilidades.add(new Habilidade(null, "Sopro de Fogo", TipoHabilidade.ACAO, firas, todasClasses, 1,
				"Você é capaz de externar o calor do seu corpo na forma de potentes labaredas. Todos que estiverem numa área até 3 metros a sua frente sofrem dano igual à 20/fogo.",
				null, null, 30, "Chamas Internas 1, Vontade 5", null));

		habilidades.add(new Habilidade(null, "Vigor do Deserto", TipoHabilidade.SUPORTE, firas, todasClasses, 1,
				"Você não só se adaptou como se fortaleceu no calor escaldante do deserto. Você é Imune ao Fogo e não precisa beber líquidos para se hidratar – você retira umidade suficiente dos alimentos e nunca precisa ingerir água.",
				null, null, null, null, null));

		// Humanos
		habilidades.add(new Habilidade(null, "Adaptabilidade", TipoHabilidade.SUPORTE, humanos, todasClasses, 1,
				"Você se adaptou ao ambiente em que cresceu ou à atividade que escolheu – ou precisou – desempenhar. Você tem +1 em qualquer um dos seus Atributos a sua escolha.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Assuntos Diversos", TipoHabilidade.ACAO, humanos, todasClasses, 1,
				"Você estudou e praticou um pouco de tudo ao longo da sua vida. Você pode rolar +1d6 em um teste qualquer à sua escolha.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Barganha", TipoHabilidade.SUPORTE, humanos, todasClasses, 1,
				"Você é um praticante das artes da negociação, oratória, retórica e sofisma. Você pode rolar +1d6 em todos os seus testes que envolvam comércio e outras negociações.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Diversidade", TipoHabilidade.SUPORTE, humanos, todasClasses, 1,
				"Você focou seus esforços e interesse em uma ampla gama de atividades. Escolha um Atributo diferente do que escolheu para Adaptabilidade. Você tem +1 nesse Atributo.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "O Dobro ou Nada", TipoHabilidade.REACAO, humanos, todasClasses, 1,
				"Você está acostumado à dar chance para sua sorte – às vezes, além do que seria considerado saudável. Quando falhar em um teste, você pode fazer o teste novamente, ignorando completamente o primeiro resultado. No caso de sucesso, além de passar no teste, qualquer efeito numérico proveniente do sucesso (dano causado por um ataque, duração de uma magia, PVs curados com uso de primeiros socorros, etc.) é dobrado. Mas se o teste for uma falha, ela deve ser considerada como uma falha crítica, com todos os seus possíveis efeitos numéricos dobrados. No caso de uma falha crítica nesse teste, o Mestre deve considerar que o fracasso foi uma falha crítica particularmente desastrosa – com efeitos limitados apenas pela sua imaginação sádica. Você só pode usar essa Habilidade uma vez por turno.",
				null, null, 20, "Sorte", null));

		habilidades.add(new Habilidade(null, "Sorte", TipoHabilidade.REACAO, humanos, todasClasses, 1,
				"Você está acostumado a contar com a sorte – e ela costuma lhe sorrir. Você pode rolar novamente um dado cujo resultado seja 1. Você só pode usar essa Habilidade uma vez por turno.",
				null, null, 10, null, null));

		// Jubans
		habilidades.add(new Habilidade(null, "Corpo Pesado", TipoHabilidade.SUPORTE, jubans, todasClasses, 1,
				"Você possui uma musculatura poderosa – e pesada. Você rola +1d6 em testes de para não ser derrubado e para realizar encontrões, mas é considerado Inapto em testes de natação, escalada e salto. Além disso, você precisa de uma ação de rodada completa para se levantar ao invés de uma ação de movimento, mas sua Carga é calculada como se você tivesse Força +2.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Fortaleza", TipoHabilidade.SUPORTE, jubans, todasClasses, 1,
				"Você é particularmente robusto e estoico. Você tem Resistência à Contusão e tem +5 Pontos de Vida.",
				"Você só pode selecionar essa Habilidade durante a criação do personagem.", null, null, null, "PV+5"));

		habilidades.add(new Habilidade(null, "Garras", TipoHabilidade.SUPORTE, jubans, todasClasses, 1,
				"Você treinou o uso de suas garras como ferramentas e armas. Você pode realizar ataques desarmados com suas garras, causando dano igual à Força+2/Perfuração. Suas garras também podem ser utilizadas para cortar cordas, panos e outros materiais com pouca dureza, e você recebe um bônus de +2 em seus testes de escalar, agarrar e segurar.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Imparável", TipoHabilidade.REACAO, jubans, todasClasses, 1,
				" Derrubar você permanentemente é uma tarefa bem difícil! Uma vez por combate, quando seus Pontos de Vida chegarem à zero, você ignora totalmente o dano que o derrubaria.",
				null, null, 20, "Fortaleza, Vontade 5", null));

		habilidades.add(new Habilidade(null, "Mordida Poderosa", TipoHabilidade.ACAO, jubans, todasClasses, 1,
				"Você pode usar seus dentes para fazer um ataque desarmado. O dano da sua mordida é igual a Força +4/Corte.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Rugido de Ahogr", TipoHabilidade.ACAO, jubans, todasClasses, 1,
				"Você aprendeu a canalizar a fúria de Ahogr em um poderoso rugido. Todos os oponentes que estiverem a até 10 metros à sua frente devem fazer um teste de Vontade (Dificuldade igual à sua Determinação). Aqueles que falharem no teste ficam Amedrontados e Atordoados por 1 turno (ver Condições, pág. 169). Um oponente só é afetado por esta habilidade uma vez por combate. Este é um efeito de Medo.",
				null, null, 20, null, null));

		// Levents
		habilidades.add(new Habilidade(null, "Asas Pesadas", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
				"Você possui grandes asas e pode voar, precisando de um espaço igual à sua envergadura para pegar impulso antes de alçar voo. Quando estiver voando, você não pode parar no ar (mas pode planar) e seu deslocamento em voo é o dobro de seu deslocamento normal.",
				"O dano de qualquer manobra de Encontrão usada em voo é duplicado (mas o dano da arma que você usar no Encontrão não é alterado, nem quaisquer outros possíveis efeitos do Encontrão). A envergadura do personagem é duas vezes a sua altura.",
				null, null, null, null));

		habilidades.add(new Habilidade(null, "Asas Fortes", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
				"Você desenvolveu suas capacidades musculares de forma que ultrapassa os limites naturais dos outros Levent durante o voo. Você é capaz de parar no ar e não precisa pegar impulso para decolar, desde que tenha espaço suficiente para abrir as asas. Além disso, em manobras de Encontrão quando estiver voando, você recebe um bônus igual à sua Força para qualquer efeito relevante, incluindo danos e tentativas de derrubar oponentes, por exemplo.",
				null, null, null, "Força 4", null));

		habilidades.add(new Habilidade(null, "Contato com Espíritos", TipoHabilidade.ACAO, levents, todasClasses, 1,
				"Você pode se comunicar com os espíritos que estejam próximos. Você é capaz de ouvir e ver qualquer espírito num raio de 20 metros. Esse efeito dura 10 minutos. Você pode gastar 10 Pontos de Mana enquanto estiver sob o efeito dessa Habilidade para ser capaz de tocar espíritos por 1 minuto.",
				null, null, 5, null, null));

		habilidades.add(new Habilidade(null, "Comunhão com Espíritos", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
				"Enquanto estiver utilizando Contato com Espíritos, você pode tocar outro personagem que será capaz de ouvir e ver qualquer espírito num raio de 20 metros por 10 minutos. Um personagem sob esse efeito pode gastar 10 Pontos de Mana para ser capaz de tocar espíritos por 1 minuto.",
				null, null, 10, "Contato com Espíritos", null));

		habilidades.add(new Habilidade(null, "Dançarino do Ar", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
				"Você praticou voo com um entusiasmo incomum e aperfeiçoou enormemente suas perícias aéreas. Enquanto estiver voando, você recebe um bônus de +2 em testes de acrobacia, tentativas de realizar um encontrão, testes de movimento e qualquer outra manobra aérea. Este bônus também estende-se a sua Defesa (este é considerado um bônus de Esquiva).",
				null, null, null, "Agilidade 5", null));

		habilidades.add(new Habilidade(null, "Movimento Brusco", TipoHabilidade.REACAO, levents, todasClasses, 1,
				"Você realiza um movimento veloz e potente com as suas asas para se deslocar rapidamente e escapar de um golpe iminente. Quando estiver voando e for atingido por um ataque, você pode anunciar que está realizando um movimento brusco, e perder a quantidade de dano que sofreria em Pontos de Mana ao invés de Pontos de Vida. Se estiver no chão, você só pode utilizar esta Habilidade contra ataques à distância. Você só pode usar esta Habilidade uma vez por rodada. Se um ataque causar mais dano do que você tem Pontos de Mana quando utilizar esta Habilidade, o dano excedente causará a perda normal de Pontos de Vida.",
				null, null, null, "Dançarino do Ar", null));

		habilidades.add(new Habilidade(null, "Olhos de águia", TipoHabilidade.SUPORTE, levents, todasClasses, 1,
				"Você possui olhos naturalmente potentes, com capacidades de percepção únicas. Você pode rolar +1d6 quando fizer testes que envolvam a visão, e consegue distinguir detalhes à uma distância em quilômetros igual à sua Inteligência. Você também consegue ver pobremente na escuridão, sendo capaz de distinguir vultos e formas, mas não detalhes específicos (como cores, inscrições ou fisionomias).",
				"Você só pode selecionar essa Habilidade durante a criação do personagem.", null, null, null, null));

		// Mahoks
		habilidades.add(new Habilidade(null, "Pele de Pedra", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
				"Sua pele é composta por uma grossa camada de rocha que o tornam extremamente resistente e pesado. Você recebe +1d6 em todos os seus testes para evitar ser derrubado, resistir à doenças e venenos, empurrar ou segurar peso, mas é considerado Inapto em testes de escalar, saltar, correr ou se mover com agilidade. Você precisa de um turno inteiro para se levantar, ao invés de uma ação de movimento e para você é impossível nadar. Você não possui o sentido do tato, mas não sente desconforto por ambientes com condições climáticas hostis. Seus ataques desarmados causam dano igual a Força +2/Contusão e você tem Defesa +4 (Esse bônus de Defesa conta como Armadura). Além disso, sua pele tem as características de uma armadura Pesada, mas a conformação única da sua pele o impede de usar armaduras, e qualquer roupa precisa ser feita sob medida para você, custando duas vezes mais que o normal.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Abraço de Pedra", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
				"Você possui mãos fortes, acostumadas a agarrar e segurar com eficiência. Você recebe +2 em seus testes de agarrar, apertar, escalar e para resistir à tentativas de desarmá-lo. Além disso, quando apertar um alvo (veja Ações e Testes, na página 24) você causa 2 pontos de dano adicionais. Esses bônus se acumulam com os bônus de Braços Extras 1 e 2.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Braços Extras 1", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
				"Você possui um par de braços a mais. Estes braços não são hábeis o suficiente para realizar ataques, mas podem segurar itens (incluindo escudos) e auxiliam em tentativas de segurar e agarrar com firmeza, oferecendo um bônus de +1 em seus testes de agarrar, apertar e escalar. Além disso, quando apertar um alvo (veja Ações e Testes, na página 23) você causa 2 pontos de dano adicionais. Esses bônus se acumulam com os bônus de Abraço de Pedra.",
				"Você só pode selecionar essa Habilidade durante a criação do personagem.", null, null, null, null));

		habilidades.add(new Habilidade(null, "Braços Extras 2", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
				"Você treinou com seus braços extras para ser hábil com eles. Você pode realizar um ataque extra por turno com seu par extra de braços, mas não pode utilizar Habilidades de Ação nos turnos em que fizer isso. Além disso, quando apertar um alvo (veja Ações e Testes, na página 24) você causa 2 pontos de dano adicionais. Esse bônus de dano se acumula com os bônus de Abraço de Pedra e Braços Extras 1.",
				null, null, null, "Braços Extras 1", null));

		habilidades.add(new Habilidade(null, "Pele de Pedra 2", TipoHabilidade.SUPORTE, mahoks, todasClasses, 1,
				"Sua pele é mais espessa do que a da maioria dos outros Mahoks, seja esta uma característica inata sua ou por você estar apresentando os primeiros sinais de envelhecimento. Você é Resistente à Perfuração e tem +5 Pontos de Vida. Além disso, sua pele adquire também as características de uma armadura Rígida (além da característica Pesada).",
				null, null, null, null, "PV+5"));

		// Tailox
		habilidades.add(new Habilidade(null, "Pernas Vulpinas", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
				"Suas pernas são flexíveis e próprias para saltar, terminando em pés pequenos dotados de solas acolchoadas que permitem que você ande quase sem fazer sons. Você rola +1d6 quando fizer testes para saltar, correr e se mover em silêncio. Além disso, você tem Deslocamento +1 e a distância dos seus saltos é aumentada em 1 metro.",
				null, null, null, null, "Deslocamento+1"));

		habilidades.add(new Habilidade(null, "Astuto", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
				"Você é mais astuto que a maioria dos indivíduos da sua raça. Você tem Inteligência +1 e recebe +2 em todos os testes de Inteligência e Agilidade que envolvam percepção, mover-se em silêncio, camuflagem, furtar bolsos, e teste semelhantes. Audácia",
				null, null, null, null, "Inteligência+1;TestesInteligência+2"));

		habilidades.add(new Habilidade(null, "Contos da Estrada", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
				"Através de várias histórias e canções contadas ao redor de fogueiras com viajantes que você encontrou em suas andanças, você acumulou um vasto conhecimento oral sobre inúmeros assuntos. Você rola +1d6 quando fizer testes de Inteligência referentes a qualquer tipo de conhecimento, não importando o quão inacessível seja este conhecimento.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Faro", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
				"Você possui um faro extremamente aguçado. Você rola +1d6 quando puder fazer testes que envolvam o faro, e pode perceber, detectar, rastrear e identificar pessoas e locais através dele. O Mestre pode realizar testes para ver se você consegue farejar mesmo quando você não estiver ativamente procurando odores específicos.Você possui um faro extremamente aguçado. Você rola +1d6 quando puder fazer testes que envolvam o faro, e pode perceber, detectar, rastrear e identificar pessoas e locais através dele. O Mestre pode realizar testes para ver se você consegue farejar mesmo quando você não estiver ativamente procurando odores específicos.",
				null, null, null, null, null));

		habilidades.add(new Habilidade(null, "Forma da Raposa", TipoHabilidade.ACAO, tailox, todasClasses, 1,
				"Você atingiu um estágio tão profundo de compreensão do Mtii’Ruah que se tornou capaz de assumir uma forma mais próxima da essência de Ellenis. Quando assume a forma de raposa, todos os itens que você estiver carregando são absorvidos pela nova forma (eles não oferecem nenhum bônus), mas estarão com você quando voltar à sua forma normal. apesar de continuar entendendo qualquer linguagem que conheça, você consegue se comunicar apenas com raposas e você não pode lançar magias, ativar itens mágicos, usar armas ou qualquer item que requeira as mãos. Na forma de raposa você recebe +2 em todos os testes que envolvam percepção, se esconder, mover-se em silêncio e saltar e seu Deslocamento é aumentado em 1. Esses bônus se acumulam com os bônus de Pernas Vulpinas. Além disso seu bônus automático de Defesa é 7 ao invés de 5 e você pode usar suas presas para desferir ataques de mordida que causam dano igual à Força +2/Corte.",
				null, null, 10, "Raça Florestal, Vontade 5", null));

		habilidades.add(new Habilidade(null, "Visão Auditiva", TipoHabilidade.SUPORTE, tailox, todasClasses, 1,
				"Seus ouvidos são tão treinados e sensíveis que você não precisa usar seus olhos para se localizar. Você consegue perceber o tamanho e a localização aproximada dos objetos ao seu redor usando apenas a audição, e só é considerado cego se, além da sua visão, sua audição também for anulada de alguma forma. Quando estiver se guiando apenas pela audição você não é capaz de distinguir detalhes específicos (como cores, inscrições ou fisionomias). Você também pode rolar +1d6 quando fizer testes que envolvam a audição.",
				null, null, null, null, null));

		// C L A S S E S

		// Bardos
		habilidades.add(new Habilidade(null, "Poesia dos Bardos", TipoHabilidade.SUPORTE, todasRacas, todasClasses, 1,
				"",
				null, null, 5, null, ""));

		return gravarHabilidades(habilidades);
    }

	public List<Habilidade> listarHabilidades() {
        return habilidadeRepository.findAll();
    }

    public Habilidade obterHabilidadePeloId(long id) {
        return habilidadeRepository.findById(id);
    }
}