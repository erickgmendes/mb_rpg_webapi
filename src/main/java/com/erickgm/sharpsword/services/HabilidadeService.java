package com.erickgm.sharpsword.services;

import com.erickgm.sharpsword.domain.entities.Classe;
import com.erickgm.sharpsword.domain.entities.Habilidade;
import com.erickgm.sharpsword.domain.entities.Raca;
import com.erickgm.sharpsword.domain.enums.TipoClasse;
import com.erickgm.sharpsword.domain.enums.TipoHabilidade;
import com.erickgm.sharpsword.domain.enums.TipoRaca;
import com.erickgm.sharpsword.repository.ClasseRepository;
import com.erickgm.sharpsword.repository.HabilidadeRepository;
import com.erickgm.sharpsword.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

// Habilidades
        TipoHabilidade suporte = TipoHabilidade.SUPORTE;
        TipoHabilidade acao = TipoHabilidade.ACAO;
        TipoHabilidade reacao = TipoHabilidade.REACAO;
        TipoHabilidade especial = TipoHabilidade.ESPECIAL;

        // Todas as raças
        List<Raca> todasRacas = obterListaRaca(TipoRaca.obterTodas());
        // Humanos e Mahoks
        List<Raca> humanos_mahoks = obterListaRaca(TipoRaca.obterDupla(TipoRaca.HUMANO, TipoRaca.MAHOK));
        // Todas menos Aesir
        List<Raca> todasRacasMenosAesir = obterListaRaca(TipoRaca.obterTodasMenos(TipoRaca.AESIR));
        // Todas menos Mahok
        List<Raca> todasRacasMenosMahok = obterListaRaca(TipoRaca.obterTodasMenos(TipoRaca.MAHOK));
        // Faunos
        List<Raca> faunos = obterListaRaca(TipoRaca.FAUNO);
        // Faunos e Jubans
        List<Raca> faunos_Jubans = obterListaRaca(TipoRaca.obterDupla(TipoRaca.FAUNO, TipoRaca.JUBAN));
        // Faens e Elfos
        List<Raca> faens_elfos = obterListaRaca(TipoRaca.obterDupla(TipoRaca.FAEN, TipoRaca.ELFO));
        // Faunos, Elfos e Tailox
        List<Raca> faunos_elfos_tailox = obterListaRaca(TipoRaca.obterTrio(TipoRaca.FAUNO, TipoRaca.ELFO, TipoRaca.TAILOX));
        // Aesires e Jubans
        List<Raca> aesires_jubans = obterListaRaca(TipoRaca.obterDupla(TipoRaca.AESIR, TipoRaca.JUBAN));
        // Firas e Levents
        List<Raca> firas_levents = obterListaRaca(TipoRaca.obterDupla(TipoRaca.FIRA, TipoRaca.LEVENT));
        // Anões e Mahoks
        List<Raca> anoes_mahoks = obterListaRaca(TipoRaca.obterDupla(TipoRaca.ANAO, TipoRaca.MAHOK));
        // Humanos e Tailox
        List<Raca> humanos_tailox = obterListaRaca(TipoRaca.obterDupla(TipoRaca.HUMANO, TipoRaca.TAILOX));
        // Faens
        List<Raca> faens = obterListaRaca(TipoRaca.FAEN);
        // Elfos
        List<Raca> elfos = obterListaRaca(TipoRaca.ELFO);
        // Anões
        List<Raca> anoes = obterListaRaca(TipoRaca.ANAO);
        // Aesires
        List<Raca> aesires = obterListaRaca(TipoRaca.AESIR);
        // Firas
        List<Raca> firas = obterListaRaca(TipoRaca.FIRA);
        // Humanos
        List<Raca> humanos = obterListaRaca(TipoRaca.HUMANO);
        // Jubans
        List<Raca> jubans = obterListaRaca(TipoRaca.JUBAN);
        // Levents
        List<Raca> levents = obterListaRaca(TipoRaca.LEVENT);
        // Mahoks
        List<Raca> mahoks = obterListaRaca(TipoRaca.MAHOK);
        // Tailox
        List<Raca> tailox = obterListaRaca(TipoRaca.TAILOX);
        // Todas as Classes
        List<Classe> todasClasses = obterListaClasse(TipoClasse.obterTodas());
        // Raças: Humanos e Mahoks / Classe: Bardo
        List<Classe> bardos = obterListaClasse(TipoClasse.BARDO);
        // Druidas
        List<Classe> druidas = obterListaClasse(TipoClasse.DRUIDA);
        // Espadachim
        List<Classe> espadachins = obterListaClasse(TipoClasse.ESPADACHIM);
        // Feiticeiro
        List<Classe> feiticeiros = obterListaClasse(TipoClasse.FEITICEIRO);
        // Guerreiro
        List<Classe> guerreiros = obterListaClasse(TipoClasse.GUERREIRO);
        // Ladinos
        List<Classe> ladinos = obterListaClasse(TipoClasse.LADINO);
        // Paladinos
        List<Classe> paladinos = obterListaClasse(TipoClasse.PALADINO);
        // Patrulheiros
        List<Classe> patrulheiros = obterListaClasse(TipoClasse.PATRULHEIRO);
        // Runicos
        List<Classe> runicos = obterListaClasse(TipoClasse.RUNICO);
        // Sacerdotes
        List<Classe> sacerdotes = obterListaClasse(TipoClasse.SACERDOTE);
        // Xamã
        List<Classe> xamas = obterListaClasse(TipoClasse.XAMA);
        // Ladinos e Patrulheiros
        List<Classe> ladinos_patrulheiros = obterListaClasse(TipoClasse.obterDupla(TipoClasse.LADINO, TipoClasse.PATRULHEIRO));
        // Anões, Mahoks e Guerreiros e Paladinos
        List<Classe> guerreiros_paladinos = obterListaClasse(TipoClasse.obterDupla(TipoClasse.GUERREIRO, TipoClasse.PALADINO));
        // Bardos, ladinos e patrulheiros
        List<Classe> bardos_ladinos_patrulheiros = obterListaClasse(TipoClasse.obterTrio(TipoClasse.BARDO, TipoClasse.LADINO, TipoClasse.PATRULHEIRO));
        // Bardos e ladinos
        List<Classe> bardos_ladinos = obterListaClasse(TipoClasse.obterDupla(TipoClasse.BARDO, TipoClasse.LADINO));
        // Bardos, espadachins e ladinos
        List<Classe> bardos_espadachins_ladinos = obterListaClasse(TipoClasse.obterTrio(TipoClasse.BARDO, TipoClasse.ESPADACHIM, TipoClasse.LADINO));
        // Bardos, Espadachins, Ladinos e Patrulheiro
        List<Classe> bardos_espadachins_ladinos_patrulheiro = obterListaClasse(TipoClasse.obterQuarteto(TipoClasse.BARDO, TipoClasse.ESPADACHIM, TipoClasse.LADINO, TipoClasse.PATRULHEIRO));
        // Bardos e Espadachins
        List<Classe> bardos_espadachins = obterListaClasse(TipoClasse.obterDupla(TipoClasse.BARDO, TipoClasse.ESPADACHIM));
        // Bardos, Espadachins e Paladinos
        List<Classe> bardos_espadachins_paladinos = obterListaClasse(TipoClasse.obterTrio(TipoClasse.BARDO, TipoClasse.ESPADACHIM, TipoClasse.PALADINO));
        // Bardos e Guerreiros
        List<Classe> bardos_guerreiros_paladinos = obterListaClasse(TipoClasse.obterTrio(TipoClasse.BARDO, TipoClasse.GUERREIRO, TipoClasse.PALADINO));
        // Bardos e Guerreiros
        List<Classe> bardos_guerreiros = obterListaClasse(TipoClasse.obterDupla(TipoClasse.BARDO, TipoClasse.GUERREIRO));
        // Druidas e Feiticeiros
        List<Classe> druidas_feiticeiros = obterListaClasse(TipoClasse.obterDupla(TipoClasse.DRUIDA, TipoClasse.FEITICEIRO));
        // Espadachim, Guerreiro, Paladinos e Rúnicos
        List<Classe> espadachins_guerreiros_paladinos_runicos = obterListaClasse(TipoClasse.obterQuarteto(TipoClasse.ESPADACHIM, TipoClasse.GUERREIRO, TipoClasse.PALADINO, TipoClasse.RUNICO));
        // Espadachim, Guerreiro, Paladinos, Rúnicos e Xamãs
        List<Classe> espadachins_guerreiros_paladinos_runicos_xamas = obterListaClasse(TipoClasse.obterQuinteto(TipoClasse.ESPADACHIM, TipoClasse.GUERREIRO, TipoClasse.PALADINO, TipoClasse.RUNICO, TipoClasse.XAMA));
        // Espadachim, Guerreiro e Paladinos
        List<Classe> espadachins_guerreiros_paladinos = obterListaClasse(TipoClasse.obterTrio(TipoClasse.ESPADACHIM, TipoClasse.GUERREIRO, TipoClasse.PALADINO));
        // Espadachim e Guerreiro
        List<Classe> espadachins_guerreiros = obterListaClasse(TipoClasse.obterDupla(TipoClasse.DRUIDA, TipoClasse.FEITICEIRO));
        // Espadachins, guerreiros e ladinos
        List<Classe> espadachins_guerreiros_ladinos = obterListaClasse(TipoClasse.obterTrio(TipoClasse.ESPADACHIM, TipoClasse.GUERREIRO, TipoClasse.LADINO));
        // Espadachins e Ladinos
        List<Classe> espadachins_ladinos = obterListaClasse(TipoClasse.obterDupla(TipoClasse.ESPADACHIM, TipoClasse.LADINO));
        // Espadachins, Ladinos e Patrulheiros
        List<Classe> espadachins_ladinos_patrulheiros = obterListaClasse(TipoClasse.obterTrio(TipoClasse.ESPADACHIM, TipoClasse.LADINO, TipoClasse.PATRULHEIRO));
        // Druidas, Patrulheiros
        List<Classe> druidas_patrulheiros = obterListaClasse(TipoClasse.obterDupla(TipoClasse.DRUIDA, TipoClasse.PATRULHEIRO));
        // Druidas, Patrulheiros e Xamãs
        List<Classe> druidas_patrulheiros_xamas = obterListaClasse(TipoClasse.obterTrio(TipoClasse.DRUIDA, TipoClasse.PATRULHEIRO, TipoClasse.XAMA));
        // Feiticeiros e Rúnicos
        List<Classe> feiticeiros_runico = obterListaClasse(TipoClasse.obterDupla(TipoClasse.FEITICEIRO, TipoClasse.RUNICO));
        // Druidas, Feiticeiros e Rúnicos
        List<Classe> druidas_feiticeiros_runico = obterListaClasse(TipoClasse.obterTrio(TipoClasse.DRUIDA, TipoClasse.FEITICEIRO, TipoClasse.RUNICO));
        // Druidas e Sacerdotes
        List<Classe> druidas_sacerdotes = obterListaClasse(TipoClasse.obterDupla(TipoClasse.DRUIDA, TipoClasse.SACERDOTE));
        // Feiticeiros e Runicos
        List<Classe> feiticeiros_runicos = obterListaClasse(TipoClasse.obterDupla(TipoClasse.FEITICEIRO, TipoClasse.RUNICO));
        // Guerreiros, Paladinos e Rúnicos
        List<Classe> guerreiros_paladinos_runicos = obterListaClasse(TipoClasse.obterTrio(TipoClasse.GUERREIRO, TipoClasse.PALADINO, TipoClasse.RUNICO));
        // Druidas, Feiticeiros, Rúnicos e Sacerdotes
        List<Classe> druidas_feiticeiros_runicos_sacerdotes = obterListaClasse(TipoClasse.obterQuarteto(TipoClasse.DRUIDA, TipoClasse.FEITICEIRO, TipoClasse.RUNICO, TipoClasse.SACERDOTE));
        // Espadachins, Guerreiros e Rúnicos
        List<Classe> espadachins_guerreiros_runicos = obterListaClasse(TipoClasse.obterTrio(TipoClasse.ESPADACHIM, TipoClasse.GUERREIRO, TipoClasse.RUNICO));
        // Guerreiros e Xamãs
        List<Classe> guerreiros_xamas = obterListaClasse(TipoClasse.obterDupla(TipoClasse.GUERREIRO, TipoClasse.XAMA));
        // Espadachins, Guerreiros, Ladinos e Xamãs
        List<Classe> espadachins_guerreiros_ladinos_xamas = obterListaClasse(TipoClasse.obterQuarteto(TipoClasse.ESPADACHIM, TipoClasse.GUERREIRO, TipoClasse.LADINO, TipoClasse.XAMA));
        // Sacerdotes e Xamãs
        List<Classe> sacerdotes_xamas = obterListaClasse(TipoClasse.obterDupla(TipoClasse.SACERDOTE , TipoClasse.XAMA));
        habilidades.add(
                new Habilidade(
                        null,
                        "Agilidade Heróica",
                        suporte,
                        todasRacas,
                        todasClasses,
                        5,
                        "Você possui uma agilidade e flexibilidade que já lhe salvaram em muitas ocasiões. Você tem Agilidade +1",
                        "",
                        "",
                        "5",
                        "",
                        0,
                        1,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                ));

        habilidades.add(
                new Habilidade(
                        null,
                        "Atletismo",
                        suporte,
                        todasRacas,
                        todasClasses,
                        1,
                        "Você treinou exercícios físicos durante muito tempo – seja por vontade própria ou por necessidade – e é muito bom nisso. Você recebe +2 em testes para correr, escalar, nadar, se equilibrar, prender o fôlego ou qualquer outra atividade que exija força física e coordenação motora. Esse bônus também se aplica em testes para evitar ser derrubado.",
                        "",
                        "",
                        null,
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Força Heróica",
                        acao,
                        todasRacas,
                        todasClasses,
                        5,
                        "Você possui uma força e resistência forjadas na batalha. Você tem Força +1.",
                        "",
                        "",
                        "",
                        "",
                        1,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Força Interior",
                        suporte,
                        todasRacas,
                        todasClasses,
                        1,
                        "Você é capaz de se manter em pé usando sua vontade e força interiores. Você recupera 5 Pontos de Vida.",
                        "",
                        "",
                        "",
                        "Vontade 4 ou mais.",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Inteligência Heroica",
                        suporte,
                        todasRacas,
                        todasClasses,
                        5,
                        "Você possui uma percepção e uma capacidade de raciocínio extremamente afiadas. Você tem Inteligência +1.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        1,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Nanismo",
                        suporte,
                        todasRacas,
                        todasClasses,
                        1,
                        "Você é menor do que a média de sua raça – em média entre 1 e 1,2 metros de altura. Você pode rolar +1d6 quando fizer testes para se esconder, se mover em silêncio ou passar despercebido de qualquer forma. Além disso, seu bônus automático de Defesa é 6 ao invés de 5. No entanto, armas corporais que requerem duas mãos são grandes demais para que você possa usá-las com eficiência, e você precisa usar ambas as mãos para usar qualquer arma corporal com FN 5 ou mais.",
                        "Você só pode selecionar essa Habilidade durante a criação do personagem.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Nervos de Aço",
                        especial,
                        todasRacas,
                        todasClasses,
                        5,
                        "Você tem um autocontrole invejável e é capaz de se concentrar mesmo quando outros entrariam em desespero. Você tem +20 Pontos de Mana.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        20,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Recursos",
                        suporte,
                        todasRacas,
                        todasClasses,
                        1,
                        "Você possui (ou possuía) um pequeno negócio ou vem de uma família nobre. Você começa o jogo com o dobro das moedas inicias.",
                        "Esta habilidade só pode ser escolhida durante a criação do Personagem.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Vontade de Ferro",
                        suporte,
                        todasRacas,
                        todasClasses,
                        5,
                        "Você não se entrega com facilidade e é muito difícil derrubar você em combate. Você tem +20 Pontos de vida.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        20,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Vontade Heróica",
                        suporte,
                        todasRacas,
                        todasClasses,
                        5,
                        "Sua determinação e autoconfiança são quase inabaláveis. Você tem Vontade +1.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        1,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Fúria de Batalha",
                        reacao,
                        todasRacasMenosAesir,
                        todasClasses,
                        1,
                        "Quando você é ferido você é tomado por uma irrefreável fúria destrutiva, ficando neste estado até o final do combate – ou até ficar dois turnos sem atacar. Você precisa sofrer pelo menos 1 ponto de dano de qualquer fonte – inclusive auto-infligido – para que essa Habilidade possa ser ativada. Enquanto estiver em Fúria, você recebe Força +2 e fica imune a efeitos de Medo.",
                        "",
                        "",
                        "30",
                        "",
                        2,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Sentidos Apurados",
                        suporte,
                        todasRacasMenosMahok,
                        todasClasses,
                        1,
                        "Você possui sentidos treinados e extremamente apurados e aprendeu a confiar instintivamente no que eles captam. Você recebe +2 em todos os testes de para perceber, procurar, observar, ouvir ou usar seus cinco sentidos e também em testes de Iniciativa.",
                        "",
                        "",
                        "",
                        "",
                        2,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Patas com Cascos",
                        suporte,
                        faunos,
                        todasClasses,
                        1,
                        "Você possui fortes patas munidas de cascos resistentes. Você pode rolar +1d6 quando fizer testes de correr, saltar ou desviar de obstáculos, e seu Deslocamento é aumentado em 1. Além disso, se fizer ataques desarmados com seus cascos, seu dano será Força +2/Contusão.",
                        "",
                        "",
                        "",
                        "",
                        2,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Cascos Ágeis",
                        suporte,
                        faunos,
                        todasClasses,
                        1,
                        "Você é mais ágil e veloz do que a maioria dos Faunos. Você tem Agilidade +1, Deslocamento +1 e a distância dos seus saltos é aumentada em 1 metro.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        1,
                        0,
                        0,
                        0,
                        0,
                        0,
                        1,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Flauta de Pã",
                        suporte,
                        faunos,
                        todasClasses,
                        1,
                        "Você ouviu, tocou e dançou várias músicas ao redor de fogueiras com seu povo – e talvez com aqueles que você encontrou em suas andanças – e adquiriu uma imensa prática em vários estilos de instrumentos de sopro. Sempre que estiver usando uma flauta ou outro instrumento de sopro, a você recebe +2 em seus testes para executar músicas (incluindo as Habilidades do tipo Música).",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Marrada",
                        suporte,
                        faunos,
                        todasClasses,
                        1,
                        "Você pode desferir um poderoso golpe com seus chifres. Este é um ataque desarmado que causa dano igual à Força +2/Contusão. Caso use esse ataque com uma ação de Encontrão, o alvo precisa vencer um teste de Força (Dificuldade igual à sua Determinação +2) ou será derrubado.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Patas Fortes",
                        suporte,
                        faunos,
                        todasClasses,
                        1,
                        "Você possui pernas mais fortes do que a maioria dos membros da sua raça. Você pode rolar +1d6 quando fizer testes de corrida, salto, evitar quedas, etc. Além disso, o dano dos seus ataques com cascos é aumentado em +2.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Pintura Corporal",
                        suporte,
                        faunos,
                        todasClasses,
                        1,
                        "Pinturas corporais são comuns entre os Faunos, utilizadas em rituais ou simplesmente como forma de expressão artística. Você deposita muita fé nos significados tradicionais das pinturas, ao ponto de conseguir se beneficiar dessa convicção quando estiver usando uma pintura. Sempre que estiver usando uma pintura corporal e que ela esteja completamente à mostra, você recebe um dos benefícios listados. Apenas uma pintura corporal pode ser usada por vez. Uma pintura corporal dura até você tomar banho – intencionalmente ou não! - ou dormir. Pintura de Caça: Realizada ao redor dos olhos e nas mãos. Você recebe +1 em seus testes ligados à visão e ataques à distância. Além disso, seus ataques à distância causam +1 de dano. Pintura de Guerra: Realizada nos braços, mãos e peito. Seus ataques corporais causam +2 de dano e você recebe Defesa +1 (Este é um bônus de esquiva). Pintura de Oração: Realizada ao redor da boca e pescoço. Você recebe +2 em todos os seus testes ligados à sua voz e instrumentos musicais de sopro, incluindo interações sociais (como convencer ou mentir) e cantar ou usar instrumentos musicais de sopro (incluindo Habilidades do tipo Música). Pintura Ritual: Realizada no peito e no rosto. Você recebe +1 em todos os seus testes ligados à liguagem corporal (como dançar, seduzir ou detectar mentiras) e Habilidades do tipo Magia. Especial: A tintura necessária para a pintura é feita com materiais simples, facilmente encontrados na natureza (como folhas ou frutas trituradas, carvão e argila) e geralmente não tem custo, mas o Mestre pode exigir que o personagem gaste meia hora em busca dos materiais necessários e no preparo da tintura. O processo de aplicar a pintura demora cerca de 10 minutos, e exige sucesso num teste de Inteligência (Dificuldade 8) que pode ser realizado por você mesmo ou por alguém em quem você confia.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Sentidos de Caçador",
                        suporte,
                        faunos_Jubans,
                        todasClasses,
                        1,
                        "Você possui uma audição aguçada e uma visão treinada. Você rola +1d6 em todos os seus testes de Inteligência envolvendo percepção, para perceber e rastrear alvos.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Herança Feérica",
                        suporte,
                        faens_elfos,
                        todasClasses,
                        1,
                        "Você possui algumas características comuns aos seus ancestrais feéricos. Você é imune a qualquer efeito mental e efeito de medo além de perceber automaticamente ilusões. Você também ganha +5 Pontos de Mana.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        5,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Dom da Magia",
                        suporte,
                        faens_elfos,
                        todasClasses,
                        1,
                        "Você é capaz de canalizar magias muito mais facilmente. As dificuldades de todas as Magia são diminuídas em 1 para você. Você também tem +5 Pontos de Mana.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        5,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Invisibilidade Natural",
                        acao,
                        faens_elfos,
                        todasClasses,
                        1,
                        "Você possui uma das habilidades mais características das fadas. Você é capaz de se mesclar à vegetação à sua volta, ficando invisível por até uma hora. É preciso estar em uma área com vegetação densa – um bosque, um jardim de topiarias ou uma estufa, por exemplo – e o efeito é cancelado se você deixar a área de vegetação, sofrer algum dano, atacar ou lançar uma magia.",
                        "",
                        "",
                        "10",
                        "Herança Feérica",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Luzes das Fadas",
                        acao,
                        faens_elfos,
                        todasClasses,
                        1,
                        "Você possui uma habilidade comuns às fadas. Você pode criar até três pequenos globos de luz que ficam dançando pelo ar. Você pode comandá-los, mas eles não podem se afastar mais que três metros do você. Eles duram uma hora, mas você pode dispersá-los quando desejar. Os globos produzem iluminação igual à de uma tocha, e você pode realizar um ataque à distância para atingir os olhos de um alvo com um dos globos de luz (que se extingue no processo), deixando-o Distraído por 1 turno.",
                        "",
                        "",
                        "15",
                        "Herança Feérica",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Raça Florestal",
                        suporte,
                        faunos_elfos_tailox,
                        todasClasses,
                        1,
                        "Você se sente confortável e renovado quando está sob a proteção da vegetação. Quando estiver dentro de uma floresta, bosque ou selva você recebe +2 em todos os seus testes.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Robustez",
                        suporte,
                        aesires_jubans,
                        todasClasses,
                        1,
                        "Você possui uma constituição vigorosa para os padrões da sua raça. Você tem +5 Pontos de vida e rola +1d6 em testes de Força para resistir à fadiga, venenos e doenças.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mente Iluminada",
                        suporte,
                        firas_levents,
                        todasClasses,
                        1,
                        "Você possui uma clareza única de raciocínio. Você tem Vontade +1 e +5 Pontos de Mana.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        1,
                        5,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Nascido nas Montanhas",
                        suporte,
                        anoes_mahoks,
                        todasClasses,
                        1,
                        "Você nasceu ou passou grande parte da sua vida em ambientes montanhosos. Você recebe +2 em seus testes ligados à locais rochosos e montanhosos – como escalar rocha (nua ou trabalhada), percepção e sobrevivência em áreas montanhosas, identificar animais dessas regiões, avaliar formações rochosas e pedras brutas ou trabalhadas (incluindo construções de pedra e pedras preciosas) e para trabalhar em pedra – seja artesanato, alvenaria ou joalheria.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Audácia",
                        suporte,
                        humanos_tailox,
                        todasClasses,
                        1,
                        "Você enfrenta ameaças e situações de perigo com entusiasmo. Sempre que estiver frente à uma situação de risco eminente – saltar entre duas bordas de um precipício, equilibrar-se em uma corda sobre um rio de lava, entrar em um combate ou qualquer situação em que você possa potencialmente perder a vida (ou pelo se ferir seriamente), você recupera imediatamente 10 Pontos de Vida ou 10 Pontos de Mana, à sua escolha. Essa Habilidade só pode ser usada uma vez para cada situação de risco, e apenas quando o risco se apresentar – não depois da sua primeira ação em um combate ou depois de cair, por exemplo.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Gregário",
                        suporte,
                        humanos_mahoks,
                        bardos,
                        1,
                        "Você consegue compreender muito rapidamente as estruturas sociais de uma cultura e seus indivíduos e é capaz de fazer amigos em qualquer lugar. Depois de cinco minutos de conversa, a pessoa com quem você esteja interagindo – e que não seja obviamente hostil a você, como um captor ou um inimigo jurado – torna-se propensa a ajudá-lo. Essa Habilidade geralmente serve para colher informações gerais (apesar de segredos não serem possíveis de conseguir) ou pequenos favores – como ser apresentado a alguém ou conseguir uma cerveja de graça. Você também recebe +2 em testes de seduzir, mentir, detectar mentiras ou qualquer outra interação social.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Constituição Feérica",
                        suporte,
                        faens,
                        todasClasses,
                        1,
                        "Você possui uma constituição leve e um par de asas que lhe permitem voar. Você pode voar em qualquer direção (com o dobro da sua movimentação normal) e pode parar no ar. No entanto, suas asas precisam bater continua e velozmente, e você não pode planar nem permanecer no ar por mais do que uma hora antes de ter que descansá-las por pelo menos meia hora. Enquanto está voando, o bater das suas asas produzem um zumbido característico e facilmente audível, e é impossível para você se mover em silêncio enquanto voa.",
                        "O dano de qualquer manobra de Encontrão usada em voo é duplicado (mas o dano da arma que você usar no Encontrão não é alterado, nem quaisquer outros possíveis efeitos de Encontrão).",
                        "0",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Isnuu",
                        suporte,
                        faens,
                        todasClasses,
                        1,
                        "Você nasceu com uma grande afinidade com a magia. Sua pele e seus cabelos são de tons esverdeados, e você pode selecionar Habilidades da lista do Feiticeiro como se fossem da sua Habilidade – desde que preencha os requisitos. Além disso, as dificuldades de todas as Magia são diminuídas em 1 para você.",
                        "Você só pode selecionar essa Habilidade durante a criação do personagem",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Presença Real",
                        suporte,
                        faens,
                        todasClasses,
                        1,
                        "Você é capaz de uma comunicação rudimentar – dentro das capacidades do animal – com qualquer Besta do tipo insectóide ou aracnídeos, e é capaz de dar comandos simples que serão obedecidos prontamente, dentro das capacidades da criatura. Você também é automaticamente bem sucedido em testes de Força para resistir quando for afetado por qualquer Habilidade do tipo Característica de todas as criaturas dos tipos Aracnídeo e Insectóide. Além disso, todas as suas Habilidades que envolvam criaturas do tipo Besta (Companheiro Animal, Convocar animais, Forma Animal e guardião da Natureza) passam a incluir criaturas dos tipos Aracnídeo e Insectóide.",
                        "",
                        "",
                        "5",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Voador Exímio",
                        suporte,
                        faens,
                        todasClasses,
                        1,
                        "Você praticou voos de longa duração, tendo passado muito tempo no ar, adquirindo uma resistência e habilidade incomum de voo. Você pode voar continuamente por até seis horas antes de precisar parar para descansar suas asas, e recebe Defesa +1 enquanto estiver voando (este é um Bônus de Esquiva).",
                        "",
                        "",
                        "",
                        "Força 3",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        1,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Benção de Lathellanis",
                        suporte,
                        elfos,
                        todasClasses,
                        1,
                        "A proteção de Lathellanis é evidente em você, assim como uma pálida sombra da astúcia da divindade da natureza. Você é imune à todas as doenças de origem natural ou mágica, Dreno de Energia e efeitos que causem Envelhecimento (de qualquer tipo ou origem). Além disso, Você rola +1d6 em todos os seus testes de Inteligência para perceber e rastrear alvos.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Arborícola",
                        suporte,
                        elfos,
                        todasClasses,
                        1,
                        "Você passou muitos anos explorando as copas das árvores, e se sente à vontade entre os galhos. Você é automaticamente bem-sucedido em testes para escalar árvores e seu Deslocamento não é reduzido quando estiver se movimentando pelas copas das árvores. Você também recebe um bônus de +2 em todos os seus testes para se mover em silencio, se esconder e se movimentar enquanto estiver em cima de uma árvore.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Intelecto Élfico",
                        suporte,
                        elfos,
                        todasClasses,
                        1,
                        "Seu raciocínio é veloz e objetivo. Você tem Inteligência +1 e +5 Pontos de Mana.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        1,
                        0,
                        5,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Coração da Montanha",
                        suporte,
                        anoes,
                        todasClasses,
                        1,
                        "Sua constituição foi forjada nos subterrâneos agrestes e impiedosos, onde apenas os mais resistentes conseguem sobreviver. Você é imune a todos os venenos naturais e mágicos e rola +1d6 em testes para resistir à fadiga, doenças e quaisquer outros efeitos físicos. Além disso, sua Carga é calculada como se você tivesse Força +2.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Cabeça Dura",
                        suporte,
                        anoes,
                        todasClasses,
                        1,
                        "Você é extremamente teimoso e é muito difícil dissuadi-lo de uma opinião, intimidá-lo, controlar sua mente ou manipulá-lo de qualquer forma. Você tem Vontade +1 e *Determinação +2.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        1,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Coração da Montanha 2",
                        suporte,
                        anoes,
                        todasClasses,
                        1,
                        "Você é ainda mais vigoroso e resistente que a maioria dos Anões. Você tem +5 Pontos de Vida e é imune à todas as doenças de origem natural ou mágica e rola +1d6 em testes para resistir a quaisquer efeitos de fadiga ou outros efeitos físicos. Esse bônus se acumula com o bônus de Vigor da Montanha.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        5,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Duro como Pedra",
                        suporte,
                        anoes,
                        todasClasses,
                        1,
                        "Sua pele é mais grossa e resistente que a da maioria dos outros Anões. Você tem +10 Pontos de Vida e Defesa +1 (esse bônus de Defesa conta como Armadura).",
                        "Você só pode selecionar essa Habilidade durante a criação do personagem.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        10,
                        1,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Forjado à Fogo",
                        suporte,
                        anoes,
                        todasClasses,
                        1,
                        "Você passou muito tempo nas forjas ou nasceu abençoado por Hou com uma resistência inata ao fogo e seus malefícios. Você possui Resistência ao Fogo e sua visão e respiração não são afetadas por fumaça.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Raça Subterrânea",
                        suporte,
                        anoes,
                        todasClasses,
                        1,
                        "Você está acostumado aos ambientes subterrâneos e se sente confortável neles. Quando estiver dentro de cavernas ou em ambientes subterrâneos, você ganha +1 em todos os testes. Você também consegue enxergar na completa escuridão, mas nessas condições não consegue distinguir cores.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Vigor Nórdico",
                        suporte,
                        aesires,
                        todasClasses,
                        1,
                        "Você nasceu em uma região gelada, e os rigores climáticos de Eishelm tornaram você vigoroso e resiliente. Você é Resistente à Frio e não é afetado nem por efeitos de climas gelados nem por efeitos provenientes de danos por Frio (como Enregelamento).",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Berserkir",
                        suporte,
                        aesires,
                        todasClasses,
                        1,
                        "Você é um escolhido do Urso como seu protegido, e é amparado pela resistência dele quando evoca a Fúria Bestial. Enquanto estiver em Fúria Bestial, você fica Resistente à Corte, Resistente à Perfuração e Resistente à Contusão. Você não pode estar usando armaduras ou escudos para que essa Habilidade tenha efeito, já que o Urso espera que você considere a proteção dele acima de qualquer proteção mundana.",
                        "Se você tiver um Espírito Animal que não seja o Urso, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Urso como seu Espírito Animal.",
                        "",
                        "30",
                        "Fúria Bestial, Vontade 4",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Bravura Selvagem 1",
                        suporte,
                        aesires,
                        xamas,
                        1,
                        "Você confia mais nas suas habilidades naturais do que em armaduras para se defender. Quando não estiver usando armadura, você recebe +2 em sua Defesa. Quando escolhe essa Habilidade, você deve escolher se este será um bônus de Bloqueio ou Esquiva. Essa escolha é permanente e não pode ser mudada mais tarde.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        2,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Bravura Selvagem 2",
                        suporte,
                        aesires,
                        todasClasses,
                        5,
                        "Você veste sua bravura em batalha melhor do que alguns vestem armaduras. O Bônus Defesa conferido por Bravura Selvagem 1 aumenta para +4 e você pode escolher se esse bônus será de Bloqueio ou Esquiva no início de cada um de seus turnos, como uma ação livre.",
                        "",
                        "",
                        "",
                        "Bravura Selvagem 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Fúria Bestial",
                        acao,
                        aesires,
                        todasClasses,
                        1,
                        "Você foi tocado pelo espírito do Urso ou pelo espírito do Lobo, e pode invocar a fúria que provém do instinto de sobrevivência deles. Enquanto estiver neste estado você recebe Força +2 e fica imune a Efeitos de Medo. Este efeito dura até o final da batalha ou até que você fique dois turnos sem atacar. Você não pode estar em Fúria Bestial e Fúria de Batalha ao mesmo tempo.",
                        "Se você tiver um Espírito Animal que não seja o Urso ou o Lobo, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Lobo ou o Urso como seu Espírito Animal.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Potência",
                        suporte,
                        aesires,
                        todasClasses,
                        1,
                        "Você é mais forte e resistente do que a maioria dos indivíduos da sua raça. Você tem Força+1 e +5 Pontos de Vida.",
                        "",
                        "",
                        "",
                        "",
                        1,
                        0,
                        0,
                        0,
                        0,
                        5,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ulfhednar",
                        suporte,
                        aesires,
                        todasClasses,
                        1,
                        "O Lobo considerou você um guerreiros digno, e ele lhe imbuirá de sua selvageria quando você evocar a Fúria Bestial, desferindo ataques muito mais violentos. O bônus de Força de Fúria Bestial passa a ser +4 e seus ataques desarmados causam +2 de dano. Você não pode estar usando armadura ou escudos para que essa Habilidade tenha efeito – já que o Lobo despreza a defesa em detrimento do ataque.",
                        "Se você tiver um Espírito Animal que não seja o Lobo, você não pode possuir esta Habilidade. Se você possuir esta Habilidade, você só pode escolher o Lobo como seu Espírito Animal.",
                        "",
                        "",
                        "Fúria Bestial, Vontade 4",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Habitante do Deserto",
                        suporte,
                        firas,
                        todasClasses,
                        1,
                        "Você descende de um povo que enfrentou os rigores do deserto sem esmorecer. Você é Resistente a Fogo e pode passar até 5 dias sem precisar ingerir água. Além disso, você não é afetado por climas particularmente quentes ou áridos.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Chamas Internas 1",
                        acao,
                        firas,
                        todasClasses,
                        1,
                        " O Vigor de Hou incendeia seu espírito e encandece seu corpo. Você é capaz de produzir tanto calor em seu interior que se torna incandescente durante 1 minuto, ficando Imune à Fogo (ou, se você já possui Imunidade à Fogo, você passa a absorver fogo, recuperando uma quantidade de Pontos de Vida iguais à qualquer quantidade de dano por fogo que sofreria). Além disso, qualquer um que toca-lo (ou que seja atingido por seus ataques desarmados) sofre dano igual à 6/Fogo.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Chamas Internas 2",
                        acao,
                        firas,
                        todasClasses,
                        1,
                        "O Vigor de Hou incendeia seu espírito e encandece seu corpo. Você é capaz de produzir tanto calor em seu interior que se torna incandescente durante 1 minuto, ficando Imune à Fogo (ou, se você já possui Imunidade à Fogo, você passa a absorver fogo, recuperando uma quantidade de Pontos de Vida iguais à qualquer quantidade de dano por fogo que sofreria). Além disso, qualquer um que toca-lo (ou que seja atingido por seus ataques desarmados) sofre dano igual à 6/Fogo.",
                        "",
                        "",
                        "20",
                        "Chamas Internas 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(new Habilidade(null, "Cavaleiro Experiente",
                        suporte,
                        firas,
                        todasClasses,
                        1,
                        "Você passou muito tempo com animais de montaria e conhece seus hábitos, características e como lidar com eles. Você recebe +1d6 em todas as suas rolagens referentes à criaturas com a Habilidade Montaria – incluindo cavalgar, treinar e atacar.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(new Habilidade(
                        null,
                        "Fulgurante",
                        acao,
                        firas,
                        todasClasses,
                        1,
                        "Seus olhos são um reflexo do brilho de Hou que queima dentro de você. Você é capaz de enxergar normalmente no escuro, e não é afetado por efeitos que restrinjam a visão – como fumaça, poeira, areia, chuva, magias que causem cegueira, etc. No entanto, seus olhos sempre emitem um brilho considerável, e isso torna sua presença extremamente fácil de notar, principalmente no escuro. Você sempre realiza seus testes para se esconder como se fosse Inapto.",
                        "Você só pode selecionar essa Habilidade durante a criação do personagem.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Sopro de Fogo",
                        acao,
                        firas,
                        todasClasses,
                        1,
                        "Você é capaz de externar o calor do seu corpo na forma de potentes labaredas. Todos que estiverem numa área até 3 metros a sua frente sofrem dano igual à 20/fogo.",
                        "",
                        "",
                        "30",
                        "Chamas Internas 1, Vontade 5",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Vigor do Deserto",
                        suporte,
                        firas,
                        todasClasses,
                        1,
                        "Você não só se adaptou como se fortaleceu no calor escaldante do deserto. Você é Imune ao Fogo e não precisa beber líquidos para se hidratar – você retira umidade suficiente dos alimentos e nunca precisa ingerir água.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Adaptabilidade",
                        suporte,
                        humanos,
                        todasClasses,
                        1,
                        "Você se adaptou ao ambiente em que cresceu ou à atividade que escolheu – ou precisou – desempenhar. Você tem +1 em qualquer um dos seus Atributos a sua escolha.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Assuntos Diversos",
                        acao,
                        humanos,
                        todasClasses,
                        1,
                        "Você estudou e praticou um pouco de tudo ao longo da sua vida. Você pode rolar +1d6 em um teste qualquer à sua escolha.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Barganha",
                        suporte,
                        humanos,
                        todasClasses,
                        1,
                        "Você é um praticante das artes da negociação, oratória, retórica e sofisma. Você pode rolar +1d6 em todos os seus testes que envolvam comércio e outras negociações.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Diversidade",
                        suporte,
                        humanos,
                        todasClasses,
                        1,
                        "Você focou seus esforços e interesse em uma ampla gama de atividades. Escolha um Atributo diferente do que escolheu para Adaptabilidade. Você tem +1 nesse Atributo.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "O Dobro ou Nada",
                        reacao,
                        humanos,
                        todasClasses,
                        1,
                        "Você está acostumado à dar chance para sua sorte – às vezes, além do que seria considerado saudável. Quando falhar em um teste, você pode fazer o teste novamente, ignorando completamente o primeiro resultado. No caso de sucesso, além de passar no teste, qualquer efeito numérico proveniente do sucesso (dano causado por um ataque, duração de uma magia, PVs curados com uso de primeiros socorros, etc.) é dobrado. Mas se o teste for uma falha, ela deve ser considerada como uma falha crítica, com todos os seus possíveis efeitos numéricos dobrados. No caso de uma falha crítica nesse teste, o Mestre deve considerar que o fracasso foi uma falha crítica particularmente desastrosa – com efeitos limitados apenas pela sua imaginação sádica. Você só pode usar essa Habilidade uma vez por turno.",
                        "",
                        "",
                        "20",
                        "Sorte",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Sorte",
                        reacao,
                        humanos,
                        todasClasses,
                        1,
                        "Você está acostumado a contar com a sorte – e ela costuma lhe sorrir. Você pode rolar novamente um dado cujo resultado seja 1. Você só pode usar essa Habilidade uma vez por turno.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Corpo Pesado",
                        suporte,
                        jubans,
                        todasClasses,
                        1,
                        "Você possui uma musculatura poderosa – e pesada. Você rola +1d6 em testes de para não ser derrubado e para realizar encontrões, mas é considerado Inapto em testes de natação, escalada e salto. Além disso, você precisa de uma ação de rodada completa para se levantar ao invés de uma ação de movimento, mas sua Carga é calculada como se você tivesse Força +2.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Fortaleza",
                        suporte,
                        jubans,
                        todasClasses,
                        1,
                        "Você é particularmente robusto e estoico. Você tem Resistência à Contusão e tem +5 Pontos de Vida.",
                        "Você só pode selecionar essa Habilidade durante a criação do personagem.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        5,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Garras",
                        suporte,
                        jubans,
                        todasClasses,
                        1,
                        "Você treinou o uso de suas garras como ferramentas e armas. Você pode realizar ataques desarmados com suas garras, causando dano igual à Força+2/Perfuração. Suas garras também podem ser utilizadas para cortar cordas, panos e outros materiais com pouca dureza, e você recebe um bônus de +2 em seus testes de escalar, agarrar e segurar.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Imparável",
                        reacao,
                        jubans,
                        todasClasses,
                        1,
                        "Derrubar você permanentemente é uma tarefa bem difícil! Uma vez por combate, quando seus Pontos de Vida chegarem à zero, você ignora totalmente o dano que o derrubaria.",
                        "",
                        "",
                        "20",
                        "Fortaleza, Vontade 5",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mordida Poderosa",
                        acao,
                        jubans,
                        todasClasses,
                        1,
                        "Você pode usar seus dentes para fazer um ataque desarmado. O dano da sua mordida é igual a Força +4/Corte.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Rugido de Ahogr",
                        acao,
                        jubans,
                        todasClasses,
                        1,
                        "Você aprendeu a canalizar a fúria de Ahogr em um poderoso rugido. Todos os oponentes que estiverem a até 10 metros à sua frente devem fazer um teste de Vontade (Dificuldade igual à sua Determinação). Aqueles que falharem no teste ficam Amedrontados e Atordoados por 1 turno (ver Condições, pág. 169). Um oponente só é afetado por esta habilidade uma vez por combate. Este é um efeito de Medo.",
                        "",
                        "",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Asas Pesadas",
                        suporte,
                        levents,
                        todasClasses,
                        1,
                        "Você possui grandes asas e pode voar, precisando de um espaço igual à sua envergadura para pegar impulso antes de alçar voo. Quando estiver voando, você não pode parar no ar (mas pode planar) e seu deslocamento em voo é o dobro de seu deslocamento normal.",
                        "O dano de qualquer manobra de Encontrão usada em voo é duplicado (mas o dano da arma que você usar no Encontrão não é alterado, nem quaisquer outros possíveis efeitos do Encontrão). A envergadura do personagem é duas vezes a sua altura.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Asas Fortes",
                        suporte,
                        levents,
                        todasClasses,
                        1,
                        "Você desenvolveu suas capacidades musculares de forma que ultrapassa os limites naturais dos outros Levent durante o voo. Você é capaz de parar no ar e não precisa pegar impulso para decolar, desde que tenha espaço suficiente para abrir as asas. Além disso, em manobras de Encontrão quando estiver voando, você recebe um bônus igual à sua Força para qualquer efeito relevante, incluindo danos e tentativas de derrubar oponentes, por exemplo.",
                        "",
                        "",
                        "",
                        "Força 4",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Contato com Espíritos",
                        acao,
                        levents,
                        xamas,
                        1,
                        "Você pode se comunicar com os espíritos que estejam próximos. Você é capaz de ouvir e ver qualquer espírito num raio de 20 metros. Esse efeito dura 10 minutos. Você pode gastar 10 Pontos de Mana enquanto estiver sob o efeito dessa Habilidade para ser capaz de tocar espíritos por 1 minuto.",
                        "",
                        "",
                        "5",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Comunhão com Espíritos",
                        suporte,
                        levents,
                        xamas,
                        1,
                        "Enquanto estiver utilizando Contato com Espíritos, você pode tocar outro personagem que será capaz de ouvir e ver qualquer espírito num raio de 20 metros por 10 minutos. Um personagem sob esse efeito pode gastar 10 Pontos de Mana para ser capaz de tocar espíritos por 1 minuto.",
                        "",
                        "",
                        "10",
                        "Contato com Espíritos",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Dançarino do Ar",
                        suporte,
                        levents,
                        todasClasses,
                        1,
                        "Você praticou voo com um entusiasmo incomum e aperfeiçoou enormemente suas perícias aéreas. Enquanto estiver voando, você recebe um bônus de +2 em testes de acrobacia, tentativas de realizar um encontrão, testes de movimento e qualquer outra manobra aérea. Este bônus também estende-se a sua Defesa (este é considerado um bônus de Esquiva).",
                        "",
                        "",
                        "",
                        "Agilidade 5",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Movimento Brusco",
                        reacao,
                        levents,
                        todasClasses,
                        1,
                        "Você realiza um movimento veloz e potente com as suas asas para se deslocar rapidamente e escapar de um golpe iminente. Quando estiver voando e for atingido por um ataque, você pode anunciar que está realizando um movimento brusco, e perder a quantidade de dano que sofreria em Pontos de Mana ao invés de Pontos de Vida. Se estiver no chão, você só pode utilizar esta Habilidade contra ataques à distância. Você só pode usar esta Habilidade uma vez por rodada. Se um ataque causar mais dano do que você tem Pontos de Mana quando utilizar esta Habilidade, o dano excedente causará a perda normal de Pontos de Vida.",
                        "",
                        "",
                        "",
                        "Dançarino do Ar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Olhos de águia",
                        suporte,
                        levents,
                        todasClasses,
                        1,
                        "Você possui olhos naturalmente potentes, com capacidades de percepção únicas. Você pode rolar +1d6 quando fizer testes que envolvam a visão, e consegue distinguir detalhes à uma distância em quilômetros igual à sua Inteligência. Você também consegue ver pobremente na escuridão, sendo capaz de distinguir vultos e formas, mas não detalhes específicos (como cores, inscrições ou fisionomias).",
                        "Você só pode selecionar essa Habilidade durante a criação do personagem.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Pele de Pedra",
                        suporte,
                        mahoks,
                        todasClasses,
                        1,
                        "Sua pele é composta por uma grossa camada de rocha que o tornam extremamente resistente e pesado. Você recebe +1d6 em todos os seus testes para evitar ser derrubado, resistir à doenças e venenos, empurrar ou segurar peso, mas é considerado Inapto em testes de escalar, saltar, correr ou se mover com agilidade. Você precisa de um turno inteiro para se levantar, ao invés de uma ação de movimento e para você é impossível nadar. Você não possui o sentido do tato, mas não sente desconforto por ambientes com condições climáticas hostis. Seus ataques desarmados causam dano igual a Força +2/Contusão e você tem Defesa +4 (Esse bônus de Defesa conta como Armadura). Além disso, sua pele tem as características de uma armadura Pesada, mas a conformação única da sua pele o impede de usar armaduras, e qualquer roupa precisa ser feita sob medida para você, custando duas vezes mais que o normal.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Abraço de Pedra",
                        suporte,
                        mahoks,
                        todasClasses,
                        1,
                        "Você possui mãos fortes, acostumadas a agarrar e segurar com eficiência. Você recebe +2 em seus testes de agarrar, apertar, escalar e para resistir à tentativas de desarmá-lo. Além disso, quando apertar um alvo (veja Ações e Testes, na página 24) você causa 2 pontos de dano adicionais. Esses bônus se acumulam com os bônus de Braços Extras 1 e 2.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Braços Extras 1",
                        suporte,
                        mahoks,
                        todasClasses,
                        1,
                        "Você possui um par de braços a mais. Estes braços não são hábeis o suficiente para realizar ataques, mas podem segurar itens (incluindo escudos) e auxiliam em tentativas de segurar e agarrar com firmeza, oferecendo um bônus de +1 em seus testes de agarrar, apertar e escalar. Além disso, quando apertar um alvo (veja Ações e Testes, na página 23) você causa 2 pontos de dano adicionais. Esses bônus se acumulam com os bônus de Abraço de Pedra.",
                        "Você só pode selecionar essa Habilidade durante a criação do personagem.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Braços Extras 2",
                        suporte,
                        mahoks,
                        todasClasses,
                        1,
                        "Você treinou com seus braços extras para ser hábil com eles. Você pode realizar um ataque extra por turno com seu par extra de braços, mas não pode utilizar Habilidades de Ação nos turnos em que fizer isso. Além disso, quando apertar um alvo (veja Ações e Testes, na página 24) você causa 2 pontos de dano adicionais. Esse bônus de dano se acumula com os bônus de Abraço de Pedra e Braços Extras 1.",
                        "",
                        "",
                        "",
                        "Braços Extras 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Pele de Pedra 2",
                        suporte,
                        mahoks,
                        todasClasses,
                        1,
                        "Sua pele é mais espessa do que a da maioria dos outros Mahoks, seja esta uma característica inata sua ou por você estar apresentando os primeiros sinais de envelhecimento. Você é Resistente à Perfuração e tem +5 Pontos de Vida. Além disso, sua pele adquire também as características de uma armadura Rígida (além da característica Pesada).",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        5,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Pernas Vulpinas",
                        suporte,
                        tailox,
                        todasClasses,
                        1,
                        "Suas pernas são flexíveis e próprias para saltar, terminando em pés pequenos dotados de solas acolchoadas que permitem que você ande quase sem fazer sons. Você rola +1d6 quando fizer testes para saltar, correr e se mover em silêncio. Além disso, você tem Deslocamento +1 e a distância dos seus saltos é aumentada em 1 metro.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        1,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Astuto",
                        suporte,
                        tailox,
                        todasClasses,
                        1,
                        "Você é mais astuto que a maioria dos indivíduos da sua raça. Você tem Inteligência +1 e recebe +2 em todos os testes de Inteligência e Agilidade que envolvam percepção, mover-se em silêncio, camuflagem, furtar bolsos, e teste semelhantes. Audácia",
                        "",
                        "",
                        "",
                        "",
                        1,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Contos da Estrada",
                        suporte,
                        tailox,
                        todasClasses,
                        1,
                        "Através de várias histórias e canções contadas ao redor de fogueiras com viajantes que você encontrou em suas andanças, você acumulou um vasto conhecimento oral sobre inúmeros assuntos. Você rola +1d6 quando fizer testes de Inteligência referentes a qualquer tipo de conhecimento, não importando o quão inacessível seja este conhecimento.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(new Habilidade(
                        null,
                        "Faro",
                        suporte,
                        tailox,
                        todasClasses,
                        1,
                        "Você possui um faro extremamente aguçado. Você rola +1d6 quando puder fazer testes que envolvam o faro, e pode perceber, detectar, rastrear e identificar pessoas e locais através dele. O Mestre pode realizar testes para ver se você consegue farejar mesmo quando você não estiver ativamente procurando odores específicos.Você possui um faro extremamente aguçado. Você rola +1d6 quando puder fazer testes que envolvam o faro, e pode perceber, detectar, rastrear e identificar pessoas e locais através dele. O Mestre pode realizar testes para ver se você consegue farejar mesmo quando você não estiver ativamente procurando odores específicos.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Forma da Raposa",
                        acao,
                        tailox,
                        todasClasses,
                        1,
                        "Você atingiu um estágio tão profundo de compreensão do Mtii’Ruah que se tornou capaz de assumir uma forma mais próxima da essência de Ellenis. Quando assume a forma de raposa, todos os itens que você estiver carregando são absorvidos pela nova forma (eles não oferecem nenhum bônus), mas estarão com você quando voltar à sua forma normal. apesar de continuar entendendo qualquer linguagem que conheça, você consegue se comunicar apenas com raposas e você não pode lançar magias, ativar itens mágicos, usar armas ou qualquer item que requeira as mãos. Na forma de raposa você recebe +2 em todos os testes que envolvam percepção, se esconder, mover-se em silêncio e saltar e seu Deslocamento é aumentado em 1. Esses bônus se acumulam com os bônus de Pernas Vulpinas. Além disso seu bônus automático de Defesa é 7 ao invés de 5 e você pode usar suas presas para desferir ataques de mordida que causam dano igual à Força +2/Corte.",
                        "",
                        "",
                        "10",
                        "Raça Florestal, Vontade 5",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Visão Auditiva",
                        suporte,
                        tailox,
                        todasClasses,
                        1,
                        "Seus ouvidos são tão treinados e sensíveis que você não precisa usar seus olhos para se localizar. Você consegue perceber o tamanho e a localização aproximada dos objetos ao seu redor usando apenas a audição, e só é considerado cego se, além da sua visão, sua audição também for anulada de alguma forma. Quando estiver se guiando apenas pela audição você não é capaz de distinguir detalhes específicos (como cores, inscrições ou fisionomias). Você também pode rolar +1d6 quando fizer testes que envolvam a audição.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Poesia dos Bardos",
                        suporte,
                        todasRacas,
                        bardos,
                        1,
                        "Através das inúmeras canções e poemas épicos, você conhece muitas histórias e lendas. Você pode rolar +1d6 quando fizer testes referentes à qualquer tipo de conhecimento. Se o conhecimento em questão for considerado perdido, maçante ou técnico para figurar uma canção ou poema, não há como o Bardo conseguir informações sobre o assunto.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Canção do Triunfo",
                        acao,
                        todasRacas,
                        bardos,
                        1,
                        "Você canta uma música relembrando os êxitos e vitórias do grupo, seus feitos mais memoráveis e exaltando seus laços de amizade, aumentando a moral do grupo. Todos os seus aliados (incluindo você) que puderem ouvir essa canção recuperam 5 Pontos e Vida por turno, enquanto você continuar a tocar essa Música.",
                        "",
                        "",
                        "25",
                        "Melodia do Repouso",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Canção Exultante",
                        acao,
                        todasRacas,
                        bardos,
                        1,
                        "Você canta uma música exaltando as capacidades e qualidades dos seus aliados, deixando-os confiantes. Todos os seus aliados (incluindo você) que puderem ouvir essa canção recebem +1 em todos os seus testes enquanto você continuar a tocar essa Música.",
                        "",
                        "",
                        "",
                        "Melodia do Repouso",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Grito Ensurdecedor",
                        acao,
                        todasRacas,
                        bardos,
                        1,
                        "Você solta um grito tão alto e poderoso que faz com que todos ao redor fiquem atordoados. Todas as criaturas em uma área de 10 metros à sua frente ficam atordoadas por um número de turnos igual à sua Vontade.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Grito Estilhaçador",
                        acao,
                        todasRacas,
                        bardos,
                        1,
                        "Seu agudo é tão poderoso que você pode direcionar um grito capaz de romper vidros, cristais e tímpanos! Tudo e todos em até 10 metros à sua frente sofrem dano igual a 10/Corte. Criaturas com Corpo Amórfico, objetos inanimados e estruturas que sejam atingidas por esse grito sofrem o dobro do dano.",
                        "",
                        "",
                        "20",
                        "Grito Ensurdecedor",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Melodia Dançante",
                        acao,
                        todasRacas,
                        bardos,
                        1,
                        "Você toca ritmos empolgantes que fazem com que todos que escutarem esta música sintam uma vontade incontrolável de dançar. Todos os Humanoides que estiverem escutando sua música rolam um confronto de Vontade contra você. Aqueles que tiverem um resultado mais baixo que o seu começarão a dançar incontrolavelmente, realizando todos os seus testes baseados em Agilidade como se fosse Inábil e ficando com Defesa -1 enquanto você continuar a tocar essa Melodia. Este é um efeito mental.",
                        "Personagens usando Dança das Espadas são imunes a esse efeito.",
                        "",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Melodia do Enjoo",
                        acao,
                        todasRacas,
                        bardos,
                        1,
                        "Sua melodia é perfeitamente desconexa e perturbadora. Todas as criaturas vivas que puderem lhe escutar rolam um confronto de Vontade contra você a cada turno em que você continuar tocando. Aqueles que tiverem um resultado mais baixo do que você ficam enjoados, sofrendo um redutor de -1 em sua Defesa e testes de ataque até o final do turno. Qualquer um que obtenha 3 resultados mais baixos que os seus em confrontos para resistir a esse efeito durante um mesmo combate ficarão tão enjoados que vomitarão, ficando Paralisados durante 1 turno.",
                        "",
                        "",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Melodia do Repouso",
                        acao,
                        todasRacas,
                        bardos,
                        1,
                        "Você toca uma série de canções simples e relaxantes, que permitem que todos os que a ouvirem repousem com serenidade e recobrem suas forças. Qualquer um que escute sua canção por pelo menos 10 minutos – mesmo que esteja dormindo – recupera o dobro de Pontos de Mana e de Pontos de Vida devido ao descanso por aquele período. Tocar a Melodia do Repouso é considerado descanso, e os efeitos dessa música também afetam você.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Melodia Sonífera",
                        acao,
                        todasRacas,
                        bardos,
                        1,
                        "Você toca uma melodia lenta e ritmada, que acalma a ponto de fazer quem a escuta cair no sono. Após 3 turnos ouvindo essa Melodia, todos que puderem escutá-la (menos você) rolam um confronto de Vontade contra você. Aqueles que tiverem um resultado menor que o seu caem em um sono profundo que dura 1 hora. Este é um efeito mental.",
                        "",
                        "",
                        "15",
                        "Melodia do Repouso",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre das Notas",
                        reacao,
                        todasRacas,
                        bardos,
                        1,
                        "Sempre que você fizer um teste que envolva contar histórias, entreter uma plateia, cantar ou tocar instrumento musicais (incluindo Habilidades do tipo Música) você pode rolar novamente 1 dos dados. Você pode escolher com qual dos resultados vai ficar. Você só pode usar esta Habilidade 1 vez por turno.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Canção da Sereia",
                        acao,
                        todasRacas,
                        bardos,
                        5,
                        "Você canta uma música melancólica capaz de deixar aqueles que a escutam enfeitiçados. Todos que estiverem a até 10 metros de você e puderem ouvir a canção rolam um confronto de Vontade contra você a cada turno enquanto você continuar cantando. Alvos que tenham um resultado menor do que o seu não poderão realizar qualquer ação exceto tentar se aproximar de você enquanto você estiver cantando – ou ficar imóvel lhe observando se estiverem a 1 metro ou menos de você. Esse efeito é cancelado e o alvo fica imune aos seus efeitos até o fim do combate se a vítima sofrer algum dano enquanto estiver sob efeito dessa Música. Enquanto estiver sob o efeito dessa Música o alvo é considerado Desprevenido para todos os seus aliados – mas não para você. Este é um efeito mental.",
                        "",
                        "",
                        "20",
                        "Eloquente",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Canção Desconcentrante",
                        acao,
                        todasRacas,
                        bardos,
                        5,
                        "Você canta uma canção com tom jocoso e com uma melodia irritante que prende a atenção dos ouvintes e não permite que eles se concentrem. Todos que estiverem a até 10 metros de você e puderem ouvir a canção rolam um confronto de Vontade contra você a cada turno enquanto você continuar cantando. Alvos que tenham um resultado menor do que o seu são considerados Distraídos até o final do seu próximo turno. Este é um efeito mental.",
                        "",
                        "",
                        "20",
                        "Melodia do Enjoo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Melodia da Fúria",
                        acao,
                        todasRacas,
                        bardos,
                        5,
                        "Você toca um ritmo primitivo, que faz com que todos os Humanoides que o escutem sintam seus instintos mais violentos aflorarem. Todos os Humanoides capazes de escutar essa canção desferem seus ataques com mais selvageria, causando +5 de dano, mas sofrendo um redutor de -2 em sua Defesa enquanto você continuar a tocar essa música. Este é um efeito mental.",
                        "",
                        "",
                        "10",
                        "Melodia Dançante",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Melodia dos Animais",
                        acao,
                        todasRacas,
                        bardos,
                        5,
                        "Escolha um tipo de Besta (mamífero, réptil ou ave). Todas as criaturas do tipo escolhido que puderem escutar sua música ficarão fascinadas com ela e o seguirão enquanto você continuar a tocar. Os alvos não irão realizar qualquer ação além de seguir você para onde for enquanto você continuar a tocar. Esse efeito é cancelado se o alvo sofrer algum dano enquanto estiver sob efeito dessa Música, mas se você continuar a tocar essa Música o alvo será afetado novamente no começo do seu próximo turno. Este é um efeito mental.",
                        "",
                        "",
                        "10",
                        "Canção da Sereia",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Virtuoso",
                        suporte,
                        todasRacas,
                        bardos,
                        5,
                        "Você treinou exaustivamente até se tornar um mestre no uso de instrumentos musicais. Você rola +1d6 em todos os testes envolvendo tocar instrumentos musicais (incluindo Habilidades do tipo Música).",
                        "",
                        "",
                        "",
                        "Mestre das Notas",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Vocalista",
                        suporte,
                        todasRacas,
                        bardos,
                        5,
                        "Você treinou sua voz para se tornar mais potente e límpida e sua dicção mais clara e segura. Você recebe +2 em todos os testes que envolvam a fala – como mentir, seduzir, barganhar ou cantar (incluindo Canções, mas não Melodias) – e na sua Determinação para determinar se os alvos de seus Gritos e Rugidos são afetados por seus efeitos. Além disso, seus Gritos e Rugidos têm a área de efeito dobrada.",
                        "",
                        "",
                        "",
                        "Pelo menos uma Habilidade de Grito",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Canção do Réquiem",
                        acao,
                        todasRacas,
                        bardos,
                        10,
                        "Você toca uma música que fala sobre a morte, derrota e fracasso dos ancestrais do alvo e do sofrimento e amarguras que ele ainda provará no futuro. A cada turno em que você canta essa canção e o alvo estiver a menos de 10 metros de você e puder escutá-lo, ele rola um Confronto de Vontade contra você. O alvo tem sua moral tão profundamente atingida pela canção que perde 20 Pontos de Mana sempre que rolar esse Confronto (independente do resultado), e se ficar sem Pontos de Mana devido aos efeitos dessa canção, ele imediatamente entra em um estado de profundo pesar e tristeza, e se entregará sem resistir. Além disso, se tiver um resultado menor do que o seu na rolagem, ele é tomado por um profundo pesar e sofrimento decorrente dos desgostos que já viveu, além das perspectivas de um futuro negro, perdendo 50 Pontos de Vida. Este é um efeito mental.",
                        "",
                        "",
                        "80",
                        "Virtuoso, Canção Desesperadora",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Conhecimento Místico",
                        suporte,
                        todasRacas,
                        druidas_sacerdotes,
                        1,
                        "Você está ligado as energias místicas provenientes de forças superiores e consegue comungar com elas. Você pode ler e utilizar tomos mágicos e desenhar Selos Místicos (veja a página 36 para regras sobre magia). Você também pode entrar em um estado de transe se concentrando por 1 minuto. Enquanto continuar meditando dessa forma, você recupera uma quantidade de Pontos de Mana igual à sua Vontade a cada 10 minutos.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Asas Celestiais",
                        acao,
                        todasRacas,
                        druidas_sacerdotes,
                        1,
                        "Desenhando um Selo Místico sobre uma criatura viva, você faz surgir em suas costas um grande par de asas. O alvo ganha a Habilidade Asas Pesadas. Esse Selo dura por 1 Hora.",
                        "",
                        "10",
                        "20",
                        "Caminhada Mágica",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Bestializar",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Desenhando um Selo Místico sobre qualquer aliado do tipo Besta, Humanóide ou Troglodita, ele recebe +2 de Força e Agilidade e desenvolve garras e dentes afiados (dano igual à Força +2/Corte) pela duração do efeito. Esse Selo Místico dura 1 minuto.",
                        "",
                        "11",
                        "20",
                        "Benção de Ellenis",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Bons Frutos",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Desenhando um Selo Místico sobre uma planta você faz com que ela desenvolva flores, frutas ou raízes. Uma planta só vai gerar flores ou frutos se ela normalmente for capaz disso. Utilizando essa magia sobre uma planta comestível, é possível alimentar um número de pessoas igual à sua Vontade. Um personagem que consuma uma dessas plantas recupera o dobro de Pontos de vida e Mana por descanso durante as próximas 6 horas. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "8",
                        "",
                        "Sabedoria Selvagem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Caminhada Mágica",
                        acao,
                        todasRacas,
                        druidas_sacerdotes,
                        1,
                        "Desenhando um Selo Místico sobre uma criatura viva, você permite que ela possa caminhar sobre qualquer tipo de superfície (incluindo líquidos), paredes ou teto e não sofre nenhum tipo de redutor ou penalidade de movimentação por terrenos difíceis ou acidentados. Finalmente, o alvo pode escolher á vontade se vai deixar rastros ou não enquanto esta runa estiver ativa sobre ele. Esse Selo Místico dura 1 hora.",
                        "",
                        "9",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Convocar Animais",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Desenhando um Selo Místico sobre si mesmo, você consegue atrair todas as Bestas escolhidas entre Mamífero, Ave, Réptil ou Peixe que estejam a até 1 km de você. Os animais não estarão sob seu controle, mas se sentirão inclinados a ajudá-lo dentro de suas capacidades – animais com temperamento pacífico ou covarde não irão entrar em combate, mas animais sobreviventes ou agressivos não terão problemas com isso. Esse Selo Místico dura 1 hora. Depois disso, as Bestas afetadas voltarão pacificamente para os locais de onde vieram.",
                        "Você pode refinar o tipo específico de animal ('Ursos', 'Marsupiais', 'Batráquios') ou até mesmo um animal específico ('Aquele esquilo com quem eu conversei ontem', 'meu Companheiro Animal', 'O cão do guarda-caça') quando conjurar essa magia.",
                        "10",
                        "10",
                        "Benção de Ellenis",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Entrelaçar",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Desenhando um Selo Místico sobre o solo você faz com que plantas comecem a brotar e agarrem um alvo que esteja com os pés no chão, reduzindo seu Deslocamento a 0 e sua Agilidade em -2 enquanto estiver preso dessa forma. Para se soltar, ele (ou outro personagem) deve passar uma quantidade de turnos igual à Vontade do conjurador cortando as plantas (com uma arma que faça dano por corte), ou passar em um teste de Força (Dificuldade igual à Determinação do conjurador). As plantas murcham e se desfazem após 1 minuto. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "10",
                        "10",
                        "Sabedoria Selvagem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Evocar Temporal",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Desenhando um Selo Místico sobre si mesmo, você inicia uma poderosa tempestade de chuva ou vento. A tempestade cobre uma área de 1 km de diâmetro e se move conforme você se desloca, permanecendo centrada em você. Todos na área realizam seus testes como se fossem Inaptos. O temporal leva 3 turnos para se formar e o Selo Místico se dissipa em um número de minutos igual à sua Vontade.",
                        "",
                        "11",
                        "20",
                        "Princípio Natural",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Fruto Revigorante",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Desenhando um Selo Místico sobre uma planta frutífera – mesmo morta – você faz com que ela desenvolva um único fruto grande e suculento capaz de restaurar 30 Pontos de Vida de quem o ingerir. Se não for ingerida, a fruta perde sua capacidade de cura após 1 minuto. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "10",
                        "10",
                        "Bons Frutos",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mover Terra",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Você desenha um Selo Místico sobre o solo, fazendo com que ele se mova subitamente sob os pés de seus adversários (todos em uma área de 2 metros de diâmetro dentro de sua área de visão precisam fazer um teste de Agilidade com Dificuldade igual à sua Determinação ou cairão). Você também pode abrir uma passagem através de pedra ou terra. Essa passagem terá aproximadamente 2 metros de diâmetro e uma profundidade igual à sua Vontade em metros. Você pode deixar a passagem aberta, criando um túnel, ou fechá-la atrás de si depois que passar. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "11",
                        "15",
                        "Princípio Natural",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Princípio Natural",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Você desenha um Selo Místico no ar que se transforma em uma pequena quantidade de terra, água ou ar. Um punhado de terra pode ser usado para nutrir uma pequena planta, uma porção de água pode ser usada para matar a sede de uma pessoa e uma porção de ar criado desse modo permite que uma criatura respire normalmente por até 10 minutos debaixo d’água. Essa magia pode ser conjurada na forma de uma rajada mágica. Uma rajada de água pode apagar uma chama do tamanho de uma fogueira de acampamento, uma rajada de ar derruba ou espalha objetos leves e pequenos e uma rajada de pedras causa dano igual a 8/ Contusão. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados e qualquer quantidade de terra, água ou ar criada são permanentes.",
                        "",
                        "8",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Rajada de Água",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Você desenha um Selo Místico no ar de onde uma massa de água jorra em um poderoso jato. Um alvo dentro de sua linha de visão sofre dano igual a 6/Contusão e precisa vencer uma rolagem de Força (Dificuldade igual à Determinação do conjurador) para não cair. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados mas qualquer quantidade de água criada é permanente.",
                        "",
                        "10",
                        "10",
                        "Princípio Natural",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Rajada de Espinhos",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Desenhando um Selo Místico em um item de madeira você faz com que ele desenvolva espinhos longos e afiados que se projetam atingindo um número de alvos igual à sua Vontade que estiverem à uma distância de até 10 metros à sua frente, causando dano igual à 12/Perfuração. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "10",
                        "10",
                        "Sabedoria Selvagem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Turbilhão",
                        acao,
                        todasRacas,
                        druidas,
                        1,
                        "Desenhando um Selo Místico sobre você mesmo e em seguida realizando um rápido movimento circular com as mãos você dispara poderosas rajadas de água. Todas as criaturas a até 10 metros de você sofrem um dano igual à 6/contusão e precisam vencer um teste de Força (Dificuldade igual à sua Determinação) para não serem arremessados um número de metros igual à sua Vontade e ficando caídos. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados e qualquer quantidade de água criada é permanente.",
                        "",
                        "12",
                        "25",
                        "Rajada de àgua",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Conjurar Abrigo",
                        acao,
                        todasRacas,
                        druidas,
                        5,
                        "Você desenha um Selo Místico sobre o solo, de onde uma estrutura simples e resistente se ergue seguindo a sua vontade. O custo em Mana da Magia depende do tamanho da estrutura: 10 Pontos de Mana criam um domo para até 4 pessoas, 20 Pontos de Mana criam uma cabana para até 10 pessoas, 40 Pontos de Mana criam uma torre para até 20 pessoas e 80 Pontos de Mana criam um pequeno forte para até 40 pessoas. O Selo Místico se dissipa depois de 24h, fazendo com que a estrutura comece a desmoronar lentamente.",
                        "",
                        "12",
                        "Variável",
                        "Mover Terra",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Despertar a Flora",
                        acao,
                        todasRacas,
                        druidas,
                        5,
                        "Você desenha um Selo Místico sobre uma planta, imbuindo ela com percepção e fala de uma criatura inteligente além de capacidade de movimentação. Um rosto se cria no caule ou tronco da planta e pode interagir com qualquer um. Nenhuma planta gosta de ser incomodada e elas tendem a não ser muito amistosas. O custo em Mana da Magia depende do tamanho da planta: 10 Pontos de Mana para afetar uma planta pequena, 20 Pontos de Mana para afetar uma planta média, 40 Pontos de Mana para afetar uma planta grande e 80 Pontos de Mana para afetar uma planta gigante. Trate uma planta sob efeito dessa magia como um Golem de madeira do tamanho apropriado, exceto o Tipo que será Esfinge e o Temperamento que será Pacífico. O Selo Místico dura 1 minuto por ponto de Vontade do conjurador.",
                        "",
                        "13",
                        null,
                        "Entrelaçar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Evocar Nevasca",
                        acao,
                        todasRacas,
                        druidas,
                        5,
                        "Desenhando um Selo Místico sobre si mesmo, você pode iniciar um nevasca ou chuva de granizo que cobre uma área de 1 km de diâmetro. Essa área se move conforme você se desloca, permanecendo centrada em você. Todos na área, exceto você, sofrem dano igual a 6/Frio (nevasca) ou 6/ Contusão (granizo) a cada turno que estiverem desabrigados e todos os testes dentro da área são realizados como se os personagens fossem Inaptos. O temporal leva 3 turnos para se formar e o Selo Místico se dissipa em um número de minutos igual à sua vontade.",
                        "",
                        "12",
                        "40",
                        "Evocar Temporal",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Gavinhas e Espinhos",
                        acao,
                        todasRacas,
                        druidas,
                        5,
                        "Desenhando um Selo Místico sobre o solo você faz com que plantas espinhosas comecem a brotar e agarrem um alvo que esteja com os pés no chão. O alvo fica com Deslocamento 0, é considerado Desprevenido e sofre uma quantidade de dano igual a 10/Perfuração. Para se soltar ele (ou outro personagem) deve passar uma quantidade de turnos igual à sua Vontade cortando as plantas (com uma arma que faça dano por corte), ou passar em um teste de Força (Dificuldade igual à Determinação do conjurador). Toda vez que ataca as plantas ou fracassa no teste de Força, o alvo sofre dano igual a 10/Perfuração. As plantas murcham e se desfazem após 1 minuto. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "12",
                        "25",
                        "Entrelaçar, Rajada de Espinhos",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Olho do Furacão",
                        acao,
                        todasRacas,
                        druidas,
                        5,
                        "Desenhando um Selo Místico sobre si mesmo, você cria um poderoso turbilhão de vento em uma área com um diâmetro em metros igual à sua Vontade e uma altura igual à 10 vezes sua Vontade. Essa área tem um olho central com cerca de 2 metros de diâmetro onde não há vento. O furacão se move conforme você se desloca, permanecendo centrado em você. Todos dentro da área do furacão devem fazer um teste de Força (Dificuldade igual à sua Determinação) para não serem arremessados um número de metros igual à sua Vontade, ficando caídos. Vencendo 2 testes consecutivos um personagem consegue chegar ao olho do furacão – mas o conjurador pode se deslocar para tentar engolfar personagens na parede de vento outra vez. O furacão impede a linha de visão através dele. Este Selo Místico dura uma quantidade de turnos igual à Vontade do conjurador.",
                        "",
                        "14",
                        "40",
                        "Evocar Temporal",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Orbe de Contenção",
                        acao,
                        todasRacas,
                        druidas,
                        5,
                        "Conjurando um Selo Místico sobre um item esférico com pelo menos 10 cm de diâmetro (um ovo de canidrako ou uma maçã por exemplo) que não tenha nenhum Selo Místico ou Runa Arcana sobre ele, o item passa a ser capaz de absorver qualquer Besta que tenha o temperamento Protetor com relação á você, simplesmente tocando-o. Enquanto estiver dentro da orbe o tempo não passa para o animal (ele não envelhece, não precisa comer ou dormir e não é afetado por efeitos de sangramentos, venenos ou doenças, nem recupera Pontos de Vida e Mana por descanso). Liberar o animal exige que o conjurador destrua o item (geralmente arremessando-o no chão) o que exige uma ação padrão, mas não exige novos testes para conjurar a magia. Esse Selo Místico dura indefinidamente até o item ser destruído.",
                        "",
                        "12",
                        "20",
                        "Convocar Animais",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Punho de Pedra",
                        acao,
                        todasRacas,
                        druidas,
                        5,
                        "Você desenha um Selo Místico sobre o solo (ou em uma estrutura de pedra como Paredes de alvenaria, estátuas de pedra e tetos de cavernas), fazendo com que uma coluna se projete violentamente da estrutura. Um alvo dessa magia sofre dano igual à 30/Contusão e precisa vencer um teste de Força (dificuldade igual à Determinação do conjurador) para não ser derrubado. A coluna tem cerca de 1 metro de diâmetro e uma extensão em metros igual à Vontade do conjurador. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados, mas a coluna de pedra é permanente.",
                        "",
                        "12",
                        "30",
                        "Mover Terra",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Hierofante",
                        suporte,
                        todasRacas,
                        druidas,
                        10,
                        "Você adquiriu um vínculo poderoso com a natureza e um vasto entendimento de seu funcionamento. Você recebe +2 em seus testes com relação a natureza, animais e magias e o custo de todas as magias que você lançar é diminuído em 5. Além disso, você pode atrair um segundo Companheiro Animal seguindo as mesmas regras descritas em Companheiro Animal 1. Seu segundo Companheiro Animal recebe os benefícios de todas as Habilidades Companheiro Animal que você tiver.",
                        "",
                        "",
                        "",
                        "Princípio Natural, Companheiro Animal 1, Sabedoria Selvagem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Dança das Espadas 1",
                        acao,
                        todasRacas,
                        espadachins,
                        1,
                        "Você pode entrar em um fluxo incessante de movimentos fluidos e vigorosos. Enquanto estiver neste estado você recebe Agilidade +2 e recebe +1d6 em seus testes de dança. Este efeito dura até 5 minutos ou até que você pare, ou seja alvo de um efeito que o impeça da continuar se movendo continuamente (Constringido, Derrubado, amedrontado, etc.).",
                        "",
                        "",
                        "30",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Desarmar Oponente",
                        acao,
                        todasRacas,
                        espadachins,
                        1,
                        "Você pode usar a sua arma para tirar a arma do seu oponente. Faça um teste resistido de Agilidade contra Força ou Agilidade do adversário (dependendo do que ele usar para combater), somando a FN das armas (a sua e a do seu adversário) nas suas respectivas rolagens. Se você estiver desarmado, use apenas Agilidade. Se o seu adversário tiver um sucesso igual ou menor do que o seu, a arma dele cairá no chão entre você e ele.",
                        "",
                        "",
                        "20",
                        "Ataque Redirecionado",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Panache",
                        suporte,
                        todasRacas,
                        espadachins,
                        1,
                        "Você possui uma bravura petulante e uma confiança inabalável nas suas próprias habilidades. Enquanto não estiver usando armadura, você recebe +1 na Defesa para cada 2 pontos de Vontade. Esse é um bônus de Esquiva.",
                        "",
                        "",
                        "",
                        "Língua Afiada",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Touché",
                        acao,
                        todasRacas,
                        espadachins,
                        1,
                        " Faça um ataque corporal com uma arma que estiver empunhando com apenas 1 mão, rolando +1d6 no teste.",
                        "Se você utilizar uma Habilidade de Ação, seus efeitos se aplicam a apenas um dos seus ataques – mas você ainda pode fazer um ataque normal com a outra arma no mesmo turno, antes ou depois de utilizar a Habilidade de Ação.",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Dança das Espadas 2",
                        suporte,
                        todasRacas,
                        espadachins,
                        5,
                        "Quando entra em combate, seu fluxo de movimentos pode criar um estado de hipnose autoinduzida, produzindo efeitos quase sobre-humanos de agilidade, velocidade e foco. Sempre que você estiver usando Dança das Espadas, você recebe um acréscimo de +2 na sua Agilidade (acumulado com o bônus de Dança das Espadas 1) e em sua Determinação. Este efeito dura enquanto durar o efeito de Dança das Espadas 1.",
                        "",
                        "",
                        "",
                        "Dança das Espadas 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Decapitar",
                        reacao,
                        todasRacas,
                        espadachins,
                        5,
                        " Quando fizer ataques contra alvos específicos visando áreas vitais, todo dano de Corte que você causar será o triplo do normal, ao invés do dobro. Se você tiver um sucesso crítico nesse ataque, o alvo morre imediatamente.",
                        "",
                        "",
                        "",
                        "Retalhar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Retalhar",
                        suporte,
                        todasRacas,
                        espadachins,
                        5,
                        "Sempre que você rolar um Sucesso Crítico em um ataque corporal usando uma arma que cause dano por Corte ou Perfuração, o dano será multiplicado por 3 ao invés de 2. Este é um efeito de sangramento.",
                        "",
                        "",
                        "",
                        "Corte Arterial",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Tempestade de Lâminas",
                        reacao,
                        todasRacas,
                        espadachins,
                        5,
                        "Sempre que acertar um ataque corporal você pode fazer 1 ataque normal extra com a mesma arma. Esse efeito só pode ser usado 1 vez por turno com cada arma que você estiver usando.",
                        "",
                        "",
                        "",
                        "Golpes Rápidos",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Senhor das Lâminas",
                        suporte,
                        todasRacas,
                        espadachins,
                        10,
                        "Sempre que for realizar um teste de ataque corpo-a-corpo usando uma arma que cause dano por corte ou perfuração, você pode rolar +1d6.",
                        "",
                        "",
                        "",
                        "Touché",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Arco Voltaico",
                        reacao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Você aprendeu a usar sua capacidade de teleporte na velocidade de um raio! Desenhando uma Runa Arcana sobre si mesmo, você sempre pode ativá-la se for alvo de um ataque ou magia que cause dano (mas não perda de vida ou outros efeitos que não causem dano), se teleportando para algum lugar a um número de metros igual à sua Inteligência de onde você está, evitando o ataque completamente. Essa Runa Arcana se dissipa apenas quando você dormir (ou perder a consciência de alguma forma) e não quando é ativada – mas consome seu custo em Mana sempre que seu efeito for desencadeado.",
                        "",
                        "12",
                        "15",
                        "Relâmpago 1, Teleporte 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Aríete Mágico",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Você projeta um poderoso golpe mágico capaz de derrubar oponentes – e estruturas! Desenhando uma runa arcana no ar, você projeta uma rajada de energia mágica bruta que causa dano igual a 10/Contusão em um alvo em sua linha de visão, e obriga o alvo a vencer um teste de Força com dificuldade igual à Determinação do conjurador para não ser derrubado. Itens inanimados e estruturas sofrem o dobro do dano normal. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "10",
                        "10",
                        "Telecinésia",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Bola de Fogo",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma runa Arcana no ar você projeta uma esfera de chamas de 20 cm de diâmetro contra um alvo na sua linha de visão. A esfera explode ao atingir o alvo, causando dano igual a 20/Fogo nele e 10/Fogo em tudo e todos em até 2 metros dele. Objetos inanimados inflamáveis atingidos por essa magia tendem a entrar em combustão. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "12",
                        "20",
                        "Inflamar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Congelar",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma runa Arcana sobre um objeto ou superfície, você infunde um frio intenso congelando-o. Essa magia pode congelar até 200 litros de líquido ou de material sólido por ponto de Inteligência do conjurador. Apenas matéria inanimada pode ser afetada por essa magia. Essa magia pode ser usada para criar uma camada de gelo grosso (cerca de 5 centímetros) e extremamente escorregadio numa área circular com um diâmetro igual à sua Inteligência. Qualquer criatura sobre essa superfície (incluindo você) precisa fazer um teste de Agilidade (Dificuldade 12) sempre que realizar um ataque, se mover ou tentar se levantar. Uma falha nesse teste significa que o personagem cai. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados, mas o gelo criado é permanente e descongela em velocidade normal.",
                        "",
                        "8",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Eletricidade Estática",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma runa Arcana sobre um objeto ou criatura, você o carrega com uma forte carga de eletricidade estática, prendendo-o à qualquer superfície em que estiver tocando. Pode ser usado em um item portátil para tornar impossível que ele seja derrubado ou em uma criatura para impedir que ela tire os pés do chão – reduzindo seu Deslocamento para 0 e sua Agilidade em -2. Um alvo afetado dessa forma pode fazer um teste de Força com dificuldade igual à Determinação do conjurador como uma ação de movimento para tentar tirar os pés do chão. Essa Runa Arcana dura 1 minuto, mas se a criatura afetada conseguir tirar um dos pés do chão, seus efeitos sobre ela se dissipam imediatamente.",
                        "",
                        "8",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Inflamar",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma Runa Arcana entre você e um objeto ou superfície dentro de sua linha de visão você faz com que ele irrompa em chamas. O custo depende do tamanho da chama criada: criar a chama em uma vela tem custo 0, enquanto uma chama suficiente para acender uma tocha tem custo 5 e fazer uma fogueira de acampamento irromper em chamas imediatamente tem custo 10. Você pode produzir uma explosão de chamas diretamente sobre um item segurado por uma criatura ou na superfície onde ela está, causando dano igual a 4/Fogo, por 0 Pontos de Mana, 8/Fogo por 5 Pontos de Mana ou 12/Fogo por 10 Pontos de Mana. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados, mas material combustível afetado se incendeia automaticamente.",
                        "",
                        "8",
                        "Variado",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Infravisão",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Você desenha uma Runa Arcana sobre um alvo, que passa a perceber o calor que emana dos objetos e criaturas sobrepondo a sua visão normal. Ele pode enxergar normalmente em locais sem iluminação nenhuma, pode perceber criaturas invisíveis pelo calor (ou frio) que elas emanam e consegue identificar ilusões, já que elas não emanam calor nem frio. Essa Runa Arcana dura 1 hora.",
                        "",
                        "9",
                        "5",
                        "Detectar Magia, Inflamar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Invocar Elemental 1",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Você conjura um pequeno Elemental de Fogo ou do Gelo desenhando uma runa Elemental no ar. O Elemental obedecerá todos os seus comandos e agirá a partir do turno seguinte, logo depois de você. A runa que mantém o Elemental coeso se dissipa depois de 10 minutos. Veja os dados dos Elementais no Monstrum Codex para mais detalhes.",
                        "",
                        "9",
                        "15",
                        "Congelar e Inflamar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Invocar Elemental 2",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Você conjura um Elemental Médio de Fogo ou do Gelo desenhando uma Runa arcana no ar. O Elemental obedecerá todos os seus comandos e agirá a partir do turno seguinte, logo depois de você. A runa que mantém o Elemental coeso se dissipa depois de 10 minutos. Veja os dados dos Elementais no Monstrum Codex para mais detalhes.",
                        "",
                        "11",
                        "30",
                        "Invocar Elemental 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Levitar",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma Runa Arcana sobre uma criatura, você faz com que ela seja capaz de voar livremente no ar para qualquer direção no seu deslocamento normal. Essa Runa Arcana dura 1 hora, mas se dissipa automaticamente se alvo tocar o solo.",
                        "",
                        "11",
                        "20",
                        "Telecinésia",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Manto Crepitante",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Você desenha uma Runa Arcana sobre uma criatura, envolvendo-a numa aura elétrica extremamente brilhante. A aura ilumina uma área de 20 metros ao seu redor, tornando-a clara como se fosse dia, de forma que, qualquer um tentando acertar você à distância (com ataques ou magias) fica ofuscado, realizando seus ataques como se fossem Inaptos. Além disso, a aura elétrica causa dano igual a 10/Eletricidade em qualquer um que tocar em você ou golpeá-lo com ataques corporais. Essa Runa dura 1 minuto, mas pode ser dissipada a qualquer momento pela criatura sobre a qual foi desenhada.",
                        "",
                        "9",
                        "15",
                        "Eletricidade Estática",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Parede de Gelo",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma runa Arcana no ar, você congela a umidade do ambiente na forma de uma grossa parede de gelo. A parede tem 3 metros de altura por 3 de largura e 1 metro de espessura, e pode ser criada em qualquer ângulo. A parede tem 60 Pontos de Vida, Defesa 10, é Vulnerável ao Fogo e sempre que receber dano por Frio recupera Pontos de Vida ao invés de sofrer dano. Ela pode suportar até 500 quilos de peso sobre ela antes de quebrar. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados, mas o gelo criado é permanente e descongela em velocidade normal.",
                        "",
                        "10",
                        "15",
                        "Congelar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Rajada de Gelo",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma Runa arcana no ar você projeta a partir dela uma rajada de energia mágica que causa dano igual a 20/Frio em um alvo dentro da sua linha de visão. Se o alvo for uma criatura viva, ele fica Enregelado por 1 turno. Se a magia tiver como alvo um objeto inanimado, ela congela até 100 litros ou 100 quilos de material. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados, mas o gelo criado é permanente e descongela em velocidade normal.",
                        "",
                        "12",
                        "20",
                        "Congelar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Relâmpago 1",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "A partir de uma Runa Arcana que desenha no ar você dispara uma faísca elétrica contra um alvo dentro de seu campo de visão. O alvo sofre um dano igual a 20/Eletricidade e fica Atordoado por 2 rodadas. Alvos usando armaduras de metal sofrem o dobro do redutor (-2 na Defesa, no Deslocamento e em todos os seus testes). A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "10",
                        "20",
                        "Eletricidade Estática",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Rajada Elemental",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma runa Arcana no ar você pode disparar uma rajada de energia elemental em qualquer alvo que possa ver. Essa magia causa 8 pontos de dano elemental (Fogo, Frio ou Eletricidade) escolhido no momento que o conjurador lança a magia. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "8",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Telecinésia",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma Runa Arcana entre você e um objeto ou criatura dentro de sua linha de visão, você pode mover o alvo através de uma energia mágica invisível. O alvo pode ser movido à vontade em qualquer direção, e até mesmo ser erguido no ar, mas apenas de forma lenta (1 metro por turno no máximo). A dificuldade será igual ao peso do alvo dividido por 5 (arredondado para baixo) Se estiver usando essa magia sobre si próprio, diminua a sua Vontade da Dificuldade final. A dificuldade mínima dessa magia será sempre 8, independente do peso do alvo ou da Vontade do Conjurador. Essa Runa Arcana dura por tanto tempo quanto você estiver concentrado nela, mas se o alvo for uma criatura, ela pode cancelar os efeitos dessa Runa no início do seu turno se vencer um teste de Força com dificuldade igual à Determinação do conjurador. *Dificuldade variável.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Teleporte 1",
                        acao,
                        todasRacas,
                        feiticeiros,
                        1,
                        "Desenhando uma Runa Arcana sobre si mesmo enquanto fita um local você se teleporta de onde está para o ponto que está olhando. Você pode levar alguém com você se puder tocar o alvo e ele concordar (ou estiver inconsciente). Some +2 na dificuldade da magia para cada pessoa além de você. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "12",
                        "30",
                        "Levitar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Aptidão Elemental",
                        suporte,
                        todasRacas,
                        feiticeiros_runicos,
                        5,
                        "Você possui um domínio considerável sobre as energias mais elementares da magia. Todas as suas magias custam 5 Pontos de Mana a menos para serem conjuradas e todas as suas magias e técnicas que causam dano por Fogo, Frio ou Eletricidade causam 5 pontos de dano a mais.",
                        "",
                        "",
                        "",
                        "Mente Disciplinada",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Eletrosfera",
                        acao,
                        todasRacas,
                        feiticeiros,
                        5,
                        "Você desenha uma Runa Arcana sobre si mesmo, fazendo um turbilhão de raios elétricos emanarem a partir dela. No final do seu turno, tudo e todos que estiver a uma quantidade de metros igual à sua Inteligência ao seu redor sofrem uma quantidade de dano igual a 20/Eletricidade. Alvos usando armaduras com a Característica Pesada que sofram esse dano também ficam Atordoadas por 1 turno. Essa Runa Arcana dura uma quantidade de turnos igual à sua Vontade.",
                        "",
                        "13",
                        "40",
                        "Relâmpago 2",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Incandescer",
                        acao,
                        todasRacas,
                        feiticeiros,
                        5,
                        "Desenhando uma Runa Arcana sobre um objeto ou superfície, você faz com que ele aquece ao ponto de incandescer ou inflamar. Objetos de pedra e metal se tornarão quentes ao ponto de tornarem-se candentes, causando dano igual a 20/Fogo em qualquer coisa que tocarem – e produzindo uma quantidade considerável de calor. Metais aquecidos a esse ponto amolecem e podem ser facilmente dobrados ou quebrados. Objetos combustíveis irão se inflamar instantaneamente, e pegarão fogo mesmo que estejam ensopados – a água vai evaporar em segundos antes que eles entrem em combustão. Essa magia pode ser usada em armas, armaduras e vestimentas de criaturas vivas. Note que o objeto alvo se aquece por inteiro. Assim, uma árvore inteira secaria e então irromperia em chamas, e uma imensa sessão de uma caverna poderia subitamente se tornar mortalmente quente. Essa Runa dura um número de turnos igual à sua Inteligência, mas materiais inflamáveis que irrompam em chamas vão queimar enquanto houver combustível disponível, mesmo depois da runa se dissipar.",
                        "",
                        "14",
                        "50",
                        "Inferno",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Inferno",
                        acao,
                        todasRacas,
                        feiticeiros,
                        5,
                        "Desenhando uma Runa arcana sobre o solo, você faz com que uma área de 4 metros de diâmetro dentro da sua linha de visão entre em combustão enquanto é atingido por uma chuva de brasas e fogo. Todos que tiverem nessa área sofrem dano igual a 30/Fogo quando essa magia for lançada e mais 30/Fogo no início de cada turno que iniciarem dentro da área. Esta Runa Arcana dura 1 rodada por ponto de Inteligência que você tiver, mas você posse dissipá-la a qualquer momento. Material inflamável na área irrompe em chamas instantaneamente.",
                        "",
                        "13",
                        "40",
                        "Bola de Fogo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Invocar Elemental 3",
                        acao,
                        todasRacas,
                        feiticeiros,
                        5,
                        "Você conjura um grande Elemental de Fogo ou do Gelo desenhando uma runa Arcana no ar. O Elemental obedecerá todos os seus comandos e agirá a partir do turno seguinte, logo depois de você. A Runa Arcana que mantém o Elemental coeso se dissipa depois de 10 minutos. Veja os dados dos Elementais no Monstrum Codex para mais detalhes.",
                        "",
                        "13",
                        "60",
                        "Invocar Elemental 2",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Prisão de Gelo",
                        acao,
                        todasRacas,
                        feiticeiros,
                        5,
                        "Desenhando uma runa arcana sobre uma criatura ou objeto você cria um imenso bloco de gelo ao redor dele. O alvo pode ter um peso máximo igual a 100 vezes sua Inteligência em quilos. Uma criatura presa dentro do bloco é considerada Paralisada, sofre dano igual a 10/Frio no começo de cada um de seus turnos e só pode ser alvo de efeitos mentais. O bloco tem 60 Pontos de Vida, Defesa 10, é Vulnerável a Fogo e sempre que receber dano por Frio recupera Pontos de Vida ao invés de sofrer dano. Ataques de Eletricidade causam dano normal ao bloco, mas também causa a mesma quantidade de dano na criatura presa dentro dele. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados, mas o gelo criado é permanente e descongela em velocidade normal.",
                        "",
                        "13",
                        "40",
                        "Parede de Gelo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Relâmpago 2",
                        acao,
                        todasRacas,
                        feiticeiros,
                        5,
                        "Você projeta uma poderosa rajada de energia elétrica em um alvo dentro de seu campo de visão a partir de uma runa Arcana que você desenha no ar. O alvo sofre um dano igual a 40/Eletricidade, e precisa fazer um teste de Força com dificuldade igual a sua Determinação ou ficará Paralisado por 1 turno. Alvos usando armaduras de metal realizam esse teste como se fossem Inaptos. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "12",
                        "30",
                        "Relâmpago 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Teleporte 2",
                        acao,
                        todasRacas,
                        feiticeiros,
                        5,
                        "Desenhando uma runa arcana sobre si mesmo enquanto se concentra em um local qualquer que já tenha visitado pelo menos uma vez, você se teleportar imediatamente para o local pretendido. Você pode levar alguém com você se puder tocar o alvo e ele concordar (ou estiver inconsciente). Some +2 na dificuldade da magia para cada pessoa além de você. A Runa Arcana se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "14",
                        "50",
                        "Teleporte 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Tempestade de Gelo",
                        acao,
                        todasRacas,
                        feiticeiros,
                        5,
                        "Desenhando uma runa Arcana sobre o solo você pode evocar uma tempestade de gelo em uma área circular de 10 metros de diâmetro que você possa ver. Uma chuva de pedaços finos e afiados de gelo cai sobre a área. Todos que estiverem na área escolhida sofrerão dano igual a 10/Corte + 10/Frio quando essa magia for lançada. A cada turno em começar dentro da área de efeito um personagem sofre dano igual a 10/Corte + 10/Frio e fica Enregelado por 1 rodada. A Runa Arcana dura 1 rodada por ponto de Inteligência que você tiver, mas você pode dissipá-la a qualquer momento.",
                        "",
                        "13",
                        "40",
                        "Rajada de Gelo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Maestria Elemental",
                        suporte,
                        todasRacas,
                        feiticeiros,
                        10,
                        "Você possui um profundo conhecimento sobre a essência elemental da magia. Sempre que você for alvo de uma magia ou efeito que o deixa Resistente ao Frio, Fogo ou Eletricidade, você fica Imune aquele elemento. Se você já for Resistente a um elemento e receber Resistência a ele através de uma magia, você passa a absorver o elemento (recuperando uma quantidade de Pontos de Vida iguais a qualquer quantidade de dano que sofreria daquele elemento). Além disso, todas as magias e técnicas que você conjura e que causem dano por fogo, frio ou eletricidade causam 5 pontos de dano a mais (esse bônus se acumula com o bônus de Aptidão Elemental).",
                        "",
                        "",
                        "",
                        "Resistência Elemental, Aptidão Elemental",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Anular Golpe",
                        reacao,
                        todasRacas,
                        guerreiros,
                        1,
                        "Você se especializou em perceber e evitar os ataques mais complexos dos seus adversários. Sempre que um oponente utilizar uma Habilidade de Ação do tipo Técnica, você pode evitar totalmente seus efeitos (incluindo o dano). O custo dessa Habilidade é o mesmo da Técnica a ser evitada. Você só pode utilizar essa Habilidade 1 vez por turno.",
                        "",
                        "",
                        "",
                        "Defesa Agressiva",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque do Búfalo",
                        acao,
                        todasRacas,
                        guerreiros_xamas,
                        1,
                        "Faça uma manobra de encontrão. Se acertar o ataque, além de causar o dano normal pelo encontrão, o alvo precisa vencer um teste de Força (Dificuldade igual à sua Determinação mais a FN da arma que estiver usando) ou será derrubado. Alvos com o dobro do seu peso não são afetados.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Simultâneo",
                        acao,
                        todasRacas,
                        guerreiros,
                        1,
                        "Você está acostumado a lutar em grupo e sabe como abrir a guarda de um adversário para que seus aliados possam atingi-lo. Faça um ataque corporal contra um oponente. Se acertar, todos aliados que estiverem adjacentes ao mesmo oponente poderão fazer um ataque corporal normal contra ele imediatamente.",
                        "",
                        "",
                        "20",
                        "Combate em Grupo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Brigão",
                        suporte,
                        todasRacas,
                        guerreiros_xamas,
                        1,
                        "Você está acostumado à combater desarmado. Você rola +1 em seus ataques desarmados e adiciona +2 nos danos desses ataques.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Combate em Grupo",
                        reacao,
                        todasRacas,
                        guerreiros,
                        1,
                        "Você ganha +1 nos testes de ataques corporais para cada aliado que esteja em combate corporal com o alvo.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Combate Pesado",
                        reacao,
                        todasRacas,
                        guerreiros,
                        1,
                        "Sempre que você fizer uma manobra de encontrão ou um ataque corporal enquanto estiver portando uma arma de duas mãos ou um escudo, você pode rolar novamente 1 dos dados em seus testes de ataque. Você pode escolher com qual dos resultados vai ficar. Você só pode usar esta Habilidade 1 vez por turno.",
                        "",
                        "",
                        "10",
                        "Combate Tático",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Defesa Agressiva",
                        suporte,
                        todasRacas,
                        guerreiros,
                        1,
                        "Você entende que a melhor defesa é um ataque eficiente. Quando estiver empunhando uma arma corporal de duas mãos, duas armas corporais ou um escudo, você recebe +1 em seus testes de ataque corporal e +1 na sua Defesa. Esse bônus de Defesa é considerado um bônus de Bloqueio.",
                        "",
                        "",
                        "",
                        "Defletor",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Golpe Devastador 1",
                        acao,
                        todasRacas,
                        guerreiros,
                        1,
                        "Você pode fazer um ataque corporal que causa o dobro de dano, e se acertar, o alvo precisa vencer um confronto de Força (adicione a FN da arma que estiver usando no seu teste) contra você ou ficará Paralisado por um turno.",
                        "",
                        "",
                        "30",
                        "Nocautear",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Golpe com Escudo",
                        reacao,
                        todasRacas,
                        guerreiros,
                        1,
                        "Se você estiver portando um escudo e errar um ataque corporal com sua arma, você pode imediatamente fazer um ataque corporal normal contra o mesmo alvo com seu escudo. Um ataque com um escudo causa dano igual à Força + FN do escudo/Contusão.",
                        "",
                        "",
                        "5",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Transpor",
                        suporte,
                        todasRacas,
                        guerreiros,
                        1,
                        "Você sabe encontrar os espaços deixados pelo escudo do adversário. Ignore sempre o bônus de Bloqueio da Defesa do oponente.",
                        "",
                        "",
                        "",
                        "Defesa Agressiva",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Força de Explosão",
                        suporte,
                        todasRacas,
                        guerreiros,
                        5,
                        "Quando fizer ataques que têm chance de derrubar o oponente você pode afetar alvos até 10 vezes mais pesados do que você (a maioria dos ataques que derrubam oponentes só afetam alvos com até o dobro do seu peso). Além disso, se você usar qualquer Habilidade que derrube o oponente, a dificuldade para resistir ao efeito e aumentada em +2.",
                        "",
                        "",
                        "",
                        "Ataque do Búfalo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Golpe Devastador 2",
                        acao,
                        todasRacas,
                        guerreiros,
                        1,
                        "Faça um ataque corporal contra o alvo. Se acertar, o ataque causa o triplo do dano normal e o alvo precisa vencer um confronto de Força (adicione a FN da arma que estiver usando no seu teste) contra você ou ficará Paralisado por um turno.",
                        "",
                        "",
                        "60",
                        "Golpe Devastador 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Investida Forte",
                        suporte,
                        todasRacas,
                        guerreiros,
                        5,
                        "Sempre que acertar uma manobra de encontrão usando um escudo, o alvo precisa vencer um teste de Resistência (Dificuldade igual à sua Determinação + a FN do escudo que você estiver usando) ou será derrubado. Alvos com o dobro do seu peso não são afetados. Um ataque com um escudo causa dano igual à Força + FN do escudo/Contusão.",
                        "",
                        "",
                        "",
                        "Golpe com Escudo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre de Armas 3",
                        acao,
                        todasRacas,
                        guerreiros,
                        10,
                        "Faça um ataque corporal contra uma criatura. Se o ataque acertar o alvo, ao invés do dano normal da arma, os Pontos de Vida atuais dele são reduzidos à metade. No caso de um sucesso crítico no ataque, o oponente é morto instantaneamente.",
                        "",
                        "",
                        "50",
                        "Mestre de Armas 2",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Gatuno",
                        suporte,
                        todasRacas,
                        ladinos,
                        1,
                        "Você aprendeu com a dura vida nas ruas a sobreviver na selva urbana. Você nunca é considerado Inapto quando tentar furtar bolsos ou arrombar fechaduras usando um kit de arrombamento. Além disso, você rola +1d6 quando tentar escalar, se esconder e tentar passar despercebido.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Evasivo",
                        acao,
                        todasRacas,
                        ladinos,
                        1,
                        "Você realiza um ataque seguido de uma movimentação errática para confundir seu oponente. Faça um ataque baseado em Agilidade. Se acertar, o alvo realiza seus ataques contra você como se fosse Inapto durante o próximo turno. Se o ataque for à distância e houver alguma cobertura à disposição, você pode se esconder tornando impossível para o alvo lhe atacar enquanto ele não o ver primeiro.",
                        "",
                        "",
                        "10",
                        "Evasão",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Contatos no Crime",
                        suporte,
                        todasRacas,
                        ladinos,
                        1,
                        "Você possui muitos contatos entre os criminosos – pequenos e grandes. Com isto você pode descobrir informações privilegiadas ou comprar e vender mercadoria roubada. Obviamente o mestre poderá restringir informações se isso for atrapalhar o andamento ou a trama da campanha, e você nem sempre será capaz de encontrar qualquer item à disposição em qualquer lugar – mas o mercado negro nas grandes cidades costuma estar abastecido de praticamente qualquer item disponível na campanha. Criminosos pagarão metade do preço normal de qualquer item que você quiser vender – desde que tenham dinheiro para tanto – e venderão itens com um custo um terço menor do que o normal. Itens proibido ou controlados, no entanto, podem ser extremamente caros. Informações terão um preço dependendo da importância e dificuldade de obtê-las, de acordo com a vontade do Mestre.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Flanquear",
                        suporte,
                        todasRacas,
                        ladinos,
                        1,
                        "Você prefere atacar seus alvos quando eles estão desatentos – e é muito eficiente fazendo isso! Sempre que você e pelo menos mais um aliado estiverem em alcance corporal de um oponente, você considera aquele oponente Despreparado em relação a você. Você só pode flanquear um alvo por turno. Se 2 ou mais adversários estiverem adjacentes a você e a um aliado ao mesmo tempo, você deve definir qual deles vai flanquear.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Flexível",
                        suporte,
                        todasRacas,
                        ladinos,
                        1,
                        "Você tem o corpo muito flexível, capaz de se dobrar, esticar e espremer de maneiras extremas. Você pode passar por aberturas como se tivesse apenas metade do seu tamanho, consegue escorregar para fora de grilhões e amarras com facilidade, pode se esticar e dobrar de modos a alcançar pontos de apoio difíceis numa escalada além de ser mais ágil quando corre e escapa de obstáculos, recebendo um bônus de +2 em qualquer teste que envolva esse tipo de circunstância.",
                        "Armaduras com a Característica Pesada impedem que você receba os bônus por esta Habilidade.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre das Adagas 1",
                        acao,
                        todasRacas,
                        ladinos,
                        1,
                        "Você se especializou em arremessar armas pequenas de forma eficiente. Você pode arremessar 2 armas com a característica Arremesso e FN 1.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre das Adagas 2",
                        acao,
                        todasRacas,
                        ladinos,
                        1,
                        "Você refinou sua técnica de arremesso de pequenos objetos. Você pode arremessar até 4 armas com a característica Arremesso e FN 1.",
                        "",
                        "",
                        "",
                        "Mestre das Adagas 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "En Passant",
                        reacao,
                        todasRacas,
                        ladinos,
                        5,
                        "Se um alvo que está adjacente a você tentar se afastar ou se levantar, você pode imediatamente fazer uma ação normal (sem Habilidades de Ação) contra ele. O alvo é considerado Despreparado contra essa ação",
                        "",
                        "",
                        "",
                        "Flanquear",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Explorar Surpresa",
                        acao,
                        todasRacas,
                        ladinos,
                        5,
                        "Faça um ataque contra um alvo Despreparado. Esse ataque causa o dobro do dano normal.",
                        "",
                        "",
                        "20",
                        "Flanquear",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Improvisação Ladina",
                        suporte,
                        todasRacas,
                        ladinos,
                        5,
                        "Você pode pegar garrafas quebradas, lascas de madeira ou osso, pedaços de vidro ou mesmo de gelo e usar como se fosse uma adaga. Em geral uma adaga improvisada dessa forma se torna inútil depois de um ataque. Você também pode montar ou desarmar armadilhas e abrir fechaduras sem ter os materiais apropriados, desde que possa improvisar gazuas ou ferramentas – com agulhas, galhos, lascas de pedra, pedaços de armas, etc.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre das Adagas 3",
                        acao,
                        todasRacas,
                        ladinos,
                        5,
                        "Você é um mestre da técnica de arremessar pequenos objetos! Você pode arremessar até 6 armas com a característica Arremesso e FN 1.",
                        "",
                        "",
                        "",
                        "Mestre das Adagas 2",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre Especialista",
                        suporte,
                        todasRacas,
                        ladinos,
                        10,
                        "Sempre que uma Habilidade oferecer um bônus de +1d6 em uma determinada ação, você recebe +2d6 para aquela ação ao invés disso.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Código da Justiça",
                        suporte,
                        todasRacas,
                        paladinos,
                        1,
                        "Você confia nas leis para se apoiar e possui uma crença inabalável na ordem. Você sempre respeita as leis vigentes nos locais onde está e não permite que outros as descumpram impunemente. Sua fé na ordem faz com que criaturas geradas no caos se sintam repelidas por você. Todo demônio, morto-vivo ou espírito deve ser bem sucedido em um teste Vontade (Dificuldade igual à sua Determinação) ou não será capaz de se aproximar ou atacar você. Criaturas desses tipos com Mente Vazia fazem seus testes de baseados em Força, e se falhar serão completamente destruídas.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Código da Lealdade",
                        suporte,
                        todasRacas,
                        paladinos,
                        1,
                        "Você nunca ataca um combatente que já está derrotado, nem luta ou permite que outros lutem de forma injusta ou com deslealdade, e jamais trai ou permite que outros traiam aqueles que confiam em você. Você recupera o dobro de Pontos de Vida (por descanso, através de poções, magias, etc.) e é imune a venenos e doenças naturais ou mágicas.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Combate Montado",
                        suporte,
                        todasRacas,
                        paladinos,
                        1,
                        "Sempre que fizer um ataque corporal enquanto estiver sobre uma montaria, acrescente +6 de dano ao ataque.",
                        "",
                        "",
                        "",
                        "Cavaleiro Experiente",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Égide",
                        reacao,
                        todasRacas,
                        paladinos,
                        1,
                        "Você sempre está pronto para se interpor diante do perigo. Se um ataque ou magia for atingir um alvo adjacente a você, você pode se interpor e sofrer o ataque no lugar do alvo original. Você sofre apenas metade do dano do ataque ou magia, mas sofre quaisquer outros efeitos normalmente.",
                        "",
                        "",
                        "",
                        "Código da Coragem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Justiça Final 1",
                        acao,
                        todasRacas,
                        paladinos,
                        1,
                        "Você pode fazer um ataque corporal que, se acertar, causa o dobro do dano normal, ou o triplo do dano normal se a criatura for um demônio, morto-vivo ou espírito.",
                        "",
                        "",
                        "25",
                        "Código da Justiça",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Montaria Especial 1",
                        suporte,
                        todasRacas,
                        paladinos,
                        1,
                        "Um animal especial foi atraído pela aura de nobreza que você exala. Ele é extremamente fiel e fará de tudo para protegê-lo. Com assovios e sons você consegue pedir para que ele faça ações simples. Além disso, ele tem 10 Pontos de Vida a mais do que um animal comum de seu tipo. Você pode escolher entre um Cavalo de Guerra, um Pônei de Guerra ou um Camelo de Guerra. Se sua montaria morrer, outro animal do mesmo tipo será atraído em seu lugar assim que você estiver em uma região em que esse tipo de animal seja comum.",
                        "",
                        "",
                        "",
                        "Código da Cortesia",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Montaria Especial 2",
                        suporte,
                        todasRacas,
                        paladinos,
                        1,
                        "Sua montaria especial foi tocada pela sua aura de coragem e tornou-se ainda mais ligada a você. Sua montaria é totalmente imune a efeitos mentais e efeitos de Medo, e recebe +10 Pontos de Vida.",
                        "",
                        "",
                        "",
                        "Montaria Especial 1, Código da Coragem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        10,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Motivar",
                        acao,
                        todasRacas,
                        paladinos,
                        1,
                        "Você profere palavras de encorajamento que inspiram seus aliados, recuperando sua moral e vontade. Todos os aliados num raio de 1 metro por ponto de Vontade que você tiver e que puderem lhe ouvir recuperam imediatamente 10 Pontos de Vida e quaisquer efeitos de Medo que os estiver afetando é removido. Estes efeitos não afetam o personagem usando essa Habilidade.",
                        "",
                        "",
                        "30",
                        "Código da Lealdade",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Banir",
                        acao,
                        todasRacas,
                        paladinos,
                        5,
                        "Sua crença na ordem natural das coisas é tão arrebatadora que você é capaz de purgar criaturas geradas do caos. Tocando uma criatura do tipo morto-vivo, demônio ou espírito, você pode destruí-las (no caso de mortos-vivos e espíritos) ou bani-las de volta aos seus planos de origem (no caso de demônios) a menos que passem em um teste de Vontade (Dificuldade igual à sua Determinação). Criaturas desses tipos com Mente Vazia não podem resistir a esse efeito e são automaticamente destruídas ou banidas. ",
                        "",
                        "",
                        "30",
                        "Código da Justiça",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Comando Heroico",
                        acao,
                        todasRacas,
                        paladinos,
                        5,
                        "Você ordena uma palavra a um aliado (pule, resista, viva, acerte, etc.) e o alvo realiza imediatamente aquela ação. A ordem não pode ser negativa (falhe, morra, caia, etc.). O alvo ainda rola seu teste normalmente, apenas para verificar a possibilidade de um sucesso crítico – qualquer outro resultado (mesmo uma falha crítica) é considerado um sucesso normal.",
                        "",
                        "",
                        "30",
                        "Motivar",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Destemor",
                        suporte,
                        todasRacas,
                        paladinos,
                        5,
                        "Sua coragem o impulsiona em situações de perigo para si e para seus companheiros. Sempre que for realizar um teste que represente um risco direto para você ou para um amigo (incluindo praticamente todas as situações de combate), você soma +2 ao resultado de todas as suas rolagens.",
                        "",
                        "",
                        "",
                        "Código da Coragem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Justiça Final 2",
                        acao,
                        todasRacas,
                        paladinos,
                        5,
                        "Você pode fazer um ataque corporal que, se acertar, causa o triplo do dano normal ou o quádruplo se a criatura for um demônio, morto-vivo ou espírito.",
                        "",
                        "",
                        "50",
                        "Justiça Final 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Montaria Especial 3",
                        suporte,
                        todasRacas,
                        paladinos,
                        5,
                        "Sua montaria desenvolveu um vínculo profundo com você, permitindo que você veja pelos olhos dela apenas se concentrando. Ela também recebe +1 em Força e +1 em Vontade e é capaz de enxergar criaturas invisíveis. ",
                        "",
                        "",
                        "",
                        "Montaria Especial 2, Código da Honestidade",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Integridade",
                        suporte,
                        todasRacas,
                        paladinos,
                        10,
                        "Sua inflexibilidade moral é tanta, que você não se dá por vencido nem diante da morte certa. Quando um ataque, magia, música ou técnica reduziriam seus Pontos de Vida a ponto de deixá-lo Por Um Fio, você ignora totalmente seu dano e quaisquer outros efeitos. Essa Habilidade não tem efeito em venenos, doenças ou fatores ambientais que causem dano",
                        "",
                        "",
                        "10",
                        "Austeridade, Destemor",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Arqueria",
                        suporte,
                        todasRacas,
                        patrulheiros,
                        1,
                        "Você recebe +2 em todos os seus ataques à distância (incluindo arremessos) e em testes envolvendo Arcos, Bestas, Prodds e fundas de todos os tipos. Você sabe como consertar essas armas e como fabricar a munição para elas.",
                        "Para consertar as armas ou fabricar a munição, você deve ter as matérias primas adequadas e as ferramentas, com isso faça um teste de Inteligência, a dificuldade é 10 (o Mestre pode aumentar a dificuldade no caso de consertos muito complexos ou de uma fabricação do zero).",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Caçador de [Criatura]",
                        suporte,
                        todasRacas,
                        patrulheiros,
                        1,
                        "Você se especializou em caçar um tipo de criatura. Escolha entre Humanoides, Trogloditas, Bestas ou Esfinges. Você sempre causa +2 pontos de dano em todos os ataques contra este tipo de criatura. Além disso, você recebe +2 em todos os seus testes relacionados a esse tipo de criatura.",
                        "",
                        "",
                        "",
                        "Armadilheiro",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Chuva de Flechas",
                        acao,
                        todasRacas,
                        patrulheiros,
                        1,
                        "Você pode atirar até 4 flechas em um só ataque em múltiplos oponentes. Faça uma rolagem para cada flecha, que devem ter alvos diferentes. ",
                        "",
                        "",
                        "30",
                        "Flechas Rápida",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Disparo Forte",
                        acao,
                        todasRacas,
                        patrulheiros,
                        1,
                        "Faça um ataque à distância. Se acertar, some +8 ao dano da arma",
                        "",
                        "",
                        "10",
                        "Retesar Eficiente",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Disparo Certeiro",
                        acao,
                        todasRacas,
                        patrulheiros,
                        1,
                        "Você realiza um ataque à distância rolando +1d6.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Flechas Rápidas",
                        reacao,
                        todasRacas,
                        patrulheiros,
                        1,
                        "Após fazer um ataque normal usando um arco, você pode fazer imediatamente outro ataque normal com o arco.",
                        "Esta Habilidade só pode ser usada 1 vez por turno.",
                        "",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Precisão",
                        suporte,
                        todasRacas,
                        patrulheiros,
                        1,
                        "Você confia mais em uma pontaria bem feita do que em força bruta quando arremessa armas ou dispara com arcos. Quando fizer ataques à distância você pode usar Inteligência ou Agilidade ao invés de Força para calcular o dano de armas de distância e de arremesso.",
                        "",
                        "",
                        "",
                        "Disparo Certeiro",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Retesar Eficiente",
                        suporte,
                        todasRacas,
                        patrulheiros,
                        1,
                        "Você possui uma técnica eficiente em retesar arcos e bestas. Quando estiver usando uma besta ou prodd de qualquer tipo, você ignora a Característica Carregar dessas armas. Quando estiver usando um arco ou funda de qualquer tipo, o dano de seus ataques à distância é aumentado em +2.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Caçador de [Monstro]",
                        suporte,
                        todasRacas,
                        patrulheiros,
                        5,
                        "Escolha um monstro (orc, troll, ogro, goblin ou qualquer outro monstro) quando comprar esta habilidade. Você sempre causa +6 de dano em todos os ataques contra este tipo de monstro e rola +1d6 em testes relacionados a eles.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Chuva de Flechas 2",
                        acao,
                        todasRacas,
                        patrulheiros,
                        5,
                        "Você pode atirar até 6 flechas em um só ataque. Faça uma rolagem para cada flecha, que podem ter alvos diferentes.",
                        "",
                        "",
                        "40",
                        "Chuva de Flechas",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Empalar",
                        suporte,
                        todasRacas,
                        patrulheiros,
                        5,
                        "Se você rolar um Sucesso Crítico em um ataque à distância (incluindo arremessos) usando uma arma que cause dano por Perfuração, o dano será multiplicado por 3 ao invés de 2. Este é um efeito de sangramento.",
                        "",
                        "",
                        "",
                        "Ataque Aleijador, Disparo Certeiro",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Matador de [Criatura]",
                        suporte,
                        todasRacas,
                        patrulheiros,
                        5,
                        "Escolha uma criatura dentre aquelas do tipo que escolheu para Caçador (Goblins, Orcs, Gnolls ou Draconianos se você escolheu Humanóides, por exemplo). Você sempre causa +4 pontos de dano em todos os ataques contra este tipo de criatura (esse bônus se acumula com o bônus de Caçador de [Criatura]). Além disso, você rola +1d6 em todos os testes relacionados a essa criatura (esse bônus se acumula com o bônus de Caçador de [Criatura]).",
                        "",
                        "",
                        "",
                        "Caçador de [Criatura]",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Olho da Águia",
                        reacao,
                        todasRacas,
                        patrulheiros,
                        5,
                        "Sempre que você fizer um ataque à distância (incluindo arremessos) você pode rolar novamente 1 dos dados. Você pode escolher com qual dos resultados vai ficar. Você só pode usar esta Habilidade 1 vez por turno.",
                        "",
                        "",
                        "10",
                        "Disparo Certeiro",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Arqueria de Mestre",
                        suporte,
                        todasRacas,
                        patrulheiros,
                        10,
                        "Você sempre rola +1d6 para ataques à distância (incluindo arremessos).",
                        "",
                        "",
                        "",
                        "Olho da Águia",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Arma Fiel",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Você pode fazer um item portátil vir até você desenhando uma Runa Arcana no ar entre você e o objeto. O item precisa estar em sua linha de visão, e irá desaparecer de onde está e aparecer na sua mão. Essa magia só funciona com itens portáteis como armas, escudos, ferramentas ou frascos e o item precisa estar marcado com sua Runa pessoal. Além disso, você precisa ter pelo menos uma mão livre para que essa magia funcione.",
                        "",
                        "12",
                        "20",
                        "Enfeitiçar Arma 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Arma Incandescente",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal. Esse ataque causa o dano normal da arma e um dano adicional igual a 10/Fogo. Esse efeito pode ser usado para inflamar objetos combustíveis – mas não faz alvos vivos irromperem em chamas.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Arma Gélida",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal. Esse ataque causa o dano normal da arma, mais um dano adicional igual a 8/Frio. Se esse efeito for conjurado enquanto a arma estiver submersa em líquido, ele congela uma esfera de meio metro de diâmetro (aproximadamente 125 litros). ",
                        "",
                        "",
                        "5",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Arma Relampejante",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal. Esse ataque causa o dano normal da arma, mais um dano adicional igual a 10/Eletricidade. Ignore bônus de Armadura e Bloqueio se o alvo estiver usando armaduras ou escudos de metal ou se estiver usando uma arma de metal para bloquear.",
                        "",
                        "",
                        "15",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Armadura Fiel",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Você pode fazer uma vestimenta vir até você desenhando uma Runa Arcana no ar entre você e ela. O item precisa estar em sua linha de visão, e irá desaparecer de onde está e aparecer vestido no seu corpo. Essa magia só funciona com itens que possam ser vestidos, como armaduras, roupas, mochilas ou cintos e o item precisa estar marcado com sua Runa pessoal. Além disso, você precisa ter espaço para que o item seja vestido para que essa magia funcione – é impossível trazer uma mochila se você já estiver usando alguma coisa nas costas, ou trazer uma armadura se você já estiver usando uma.",
                        "",
                        "12",
                        "30",
                        "Arma Fiel, Enfeitiçar Armadura",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Fantasma",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal. Esse ataque causa +8 de dano e afeta criaturas incorpóreas como se elas não tivessem essa Habilidade.",
                        "",
                        "",
                        "15",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Conjurar Escudo",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Você desenha uma Runa Arcana no ar e ela se transforma em um escudo de energia para proteger uma criatura dentro de sua linha de visão. O escudo flutua ao redor do alvo, bloqueando ataques, mas pode ser segurado como um escudo normal. Ele garante um Bônus de Bloqueio de +2, e se for segurado tem FN 2 e ocupa 1 mão. A Runa Arcana que mantém o escudo se dissipa depois de 1 minuto.",
                        "",
                        "10",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Desativar Item",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Você pode desativar temporariamente um item mágico desenhando uma Runa Arcana sobre ele, fazendo com que todos os efeitos mágicos fornecidos pelo item deixem de funcionar por 10 minutos por ponto de Inteligência que você tiver – mas ele ainda conta como um item mágico para qualquer efeito que afete ou não afete itens mágicos especificamente. Itens mágicos de aura Nula ou Divina não são afetados por essa Habilidade. Esta Habilidade também dissipa todas as Runas Arcanas e Selos Místicos do item tocado.",
                        "",
                        "11",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Enfeitiçar Arma 1",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Desenhando uma Runa Arcana sobre uma arma, você confere um bônus de +1 nas rolagens de ataque e nos danos dessa arma. Essa Runa Arcana dura 1 minuto.",
                        "",
                        "10",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Enfeitiçar Armadura",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Desenhando uma Runa Arcana sobre uma armadura ou vestimenta, você aumenta o bônus de defesa do item em +1 (ou confere +1 de Armadura para uma peça de roupa comum). Essa Runa Arcana dura 1 minuto.",
                        "",
                        "10",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Onda de Chamas",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal, contra um alvo dentro da sua linha de visão. Esse ataque produz uma onda flamejante que causa dano igual a 10/Fogo. Esse efeito pode ser usado para inflamar objetos combustíveis – mas não faz alvos vivos irromperem em chamas.",
                        "",
                        "",
                        "10",
                        "Arma Incandescente",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Onda de Frio",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal, contra um alvo dentro da sua linha de visão. Esse ataque produz uma rajada de ar gélido e partículas de gelo que causa igual a 10/Frio. Se o alvo for um líquido, ele congela uma área de até 10 metros quadrados, com cerca de 10 centímetros de espessura.",
                        "",
                        "",
                        "10",
                        "Arma Gélida",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Onda de Raios",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal, contra um alvo dentro da sua linha de visão. Esse ataque produz uma descarga elétrica que causa igual a 10/Eletricidade. Esse ataque ignora qualquer escudo ou armadura com a Característica Pesada e quaisquer bônus de bloqueio do alvo.",
                        "",
                        "",
                        "15",
                        "Arma Relampejante",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Onda Fantasma",
                        acao,
                        todasRacas,
                        runicos,
                        1,
                        "Faça um ataque corporal contra um alvo que possa ver. Você precisa estar usando uma arma que esteja marcada com sua Runa pessoal. Esse ataque produz uma onda espectral que ignora paredes, portas, armaduras, escudos e quaisquer outros obstáculos inorgânicos. Essa rajada causa 10 de dano (o tipo de dano causado pelo ataque será o mesmo do tipo que a arma usada puder causar normalmente) e afeta criaturas incorpóreas como se elas fossem sólidas.",
                        "",
                        "",
                        "15",
                        "Ataque Fantasma",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Chocante",
                        acao,
                        todasRacas,
                        runicos,
                        5,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal. Esse ataque causa o dano normal da arma em conjunto com uma potente rajada elétrica que causa 10/eletricidade e faz com que o alvo fique Paralisado por 2 turno. Ignore bônus de Armadura e Bloqueio se o alvo estiver usando armaduras ou escudos de metal ou se estiver usando uma arma de metal para bloquear.",
                        "Alvos Imunes à Eletricidade não são afetados por essa Habilidade – mas alvos Resistentes à Eletricidade são afetados normalmente",
                        "",
                        "25",
                        "Arma Relampejante",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Congelante",
                        acao,
                        todasRacas,
                        runicos,
                        5,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal. Esse ataque causa o dano normal da arma além de 8/Frio e congela dentro de um bloco de gelo (o alvo é considerado Paralisado e só pode ser afetado por efeitos Mentais) e sofre dano igual a 8/Frio no começo de seu turno. Esse efeito dura uma quantidade de turnos igual à sua Inteligência.",
                        "O bloco de gelo contendo o personagem pode ser destruído se sofrer uma quantidade de dano igual à Determinação do conjurador da magia. O bloco de gelo é imune a ataques que causem dano por Frio e ataques que causam dano por Eletricidade também afetam o alvo congelado.",
                        "",
                        "30",
                        "Arma Gélida",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Flamejante",
                        acao,
                        todasRacas,
                        runicos,
                        5,
                        "Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal. Esse ataque causa o dano normal da arma além de 10/fogo e faz o alvo entrar em combustão (o alvo sofre uma quantidade de dano igual a 10/fogo no começo do seu turno) por uma quantidade de turnos igual à sua Inteligência ou até que as chamas sejam apagadas de alguma forma.",
                        "Um personagem em combustão pode gastar seu turno rolando no chão para apagar as chamas. Ele será considerado Caído e Despreparado enquanto fizer isso.",
                        "",
                        "20",
                        "Arma Incandescente",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Golpe do Vento",
                        acao,
                        todasRacas,
                        runicos,
                        5,
                        "Você é capaz de cortar o ar, enviando uma rajada de vento mágico que corta alvos distantes. Faça um ataque corporal com uma arma que esteja marcada com sua Runa pessoal contra um alvo dentro da sua linha de visão. Esse ataque causa o dano normal da arma.",
                        "",
                        "Defesa do Alvo",
                        "20",
                        "Enfeitiçar Arma 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Enfeitiçar Arma 2",
                        acao,
                        todasRacas,
                        runicos,
                        5,
                        "Desenhando uma Runa Arcana sobre uma arma, você confere um bônus de +3 nas rolagens de ataque e nos danos dessa arma. Essa Runa Arcana dura 1 minuto.",
                        "",
                        "12",
                        "25",
                        "Enfeitiçar Arma",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Destruição Elemental",
                        suporte,
                        todasRacas,
                        runicos,
                        10,
                        "Você se tornou extremamente hábil no controle das energias elementais. Sempre que usar uma técnica ou magia que causa dano por Fogo, Frio ou Eletricidade, esse dano é dobrado.",
                        "",
                        "",
                        "",
                        "Arma Incandescente, Arma Gélida e Arma Relampejante",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Armadilheiro",
                        acao,
                        todasRacas,
                        ladinos_patrulheiros,
                        1,
                        "Você se especializou em desarmar e preparar armadilhas. Você nunca é considerado Inapto para desarmar armadilhas e se tiver os materiais e o tempo necessários, você pode armar uma armadilha. Faça um teste de Inteligência: O resultado do teste será a dificuldade para a armadilha ser percebida e desarmada.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Camuflagem",
                        suporte,
                        todasRacas,
                        ladinos_patrulheiros,
                        5,
                        "Você pode se camuflar em florestas usando galhos, folhas e lama, ou nas sombras de becos e ruas usando uma capa preta e talvez fuligem ou barro. Quando puder usar o ambiente a seu favor dessa forma, você pode rolar +1d6 nos testes para se esconder.",
                        "",
                        "",
                        "",
                        "Furtivo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Emboscar",
                        acao,
                        todasRacas,
                        ladinos_patrulheiros,
                        5,
                        "Você se especializou em emboscar inimigos incapazes de percebê-lo. Quando fizer um ataque à distância contra um alvo Desprevenido (ver Condições, pág. 169), faça imediatamente um Confronto com sua Agilidade versus Inteligência do alvo. Se o seu resultado for mais alto do que o do alvo, ele não consegue perceber de onde veio o ataque, tornando impossível para o alvo lhe atacar (ou mesmo ter uma ideia aproximada da sua posição, a menos que ela seja óbvia) enquanto você permanecer escondido.",
                        "",
                        "",
                        "20",
                        "Camuflagem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Passo Leve",
                        reacao,
                        todasRacas,
                        ladinos_patrulheiros,
                        5,
                        "Sempre que você fizer um teste para mover-se em silencio, se esconder ou camuflar ou bater carteiras você pode rolar novamente 1 dos dados. Você pode escolher com qual dos resultados vai ficar. Esta Habilidade só pode ser usada uma vez por turno.",
                        "",
                        "",
                        "10",
                        "Furtivo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Estabilidade",
                        suporte,
                        anoes_mahoks,
                        guerreiros_paladinos,
                        1,
                        " Você gosta de ter os dois pés solidamente plantados no chão – e faz isso muito bem! Você sempre rola +1d6 em todos os seus testes de evitar quedas e manter o equilíbrio.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

// Guerreiros e Paladinos
        habilidades.add(
                new Habilidade(
                        null,
                        "Defletor",
                        suporte,
                        todasRacas,
                        guerreiros_paladinos,
                        1,
                        "Você está acostumado a se defender de projéteis. Enquanto estiver empunhando uma arma corporal de duas mãos, duas armas corporais ou um escudo, você recebe +2 no seu bônus de Bloqueio contra ataques à distância. Esse bônus de Defesa é considerado um bônus de Bloqueio.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Nocautear",
                        acao,
                        todasRacas,
                        guerreiros_paladinos,
                        1,
                        "Faça um ataque corporal que cause dano por Contusão. Se acertar, além de sofrer o dano normal do ataque, o alvo fica Paralisado (veja Condições na página 169) por 1 turno.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Parede de Escudos",
                        suporte,
                        todasRacas,
                        guerreiros_paladinos,
                        1,
                        "Você está acostumado a lutar em grupo e usar seu escudo para proteger seus aliados. Enquanto você estiver usando um escudo, todos os aliados adjacentes a você recebem um bônus de +1 na Defesa. Este é um bônus de Bloqueio.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Guerreiro de Aço 2",
                        suporte,
                        todasRacas,
                        guerreiros_paladinos_runicos,
                        5,
                        "Você está extremamente acostumado a usar armaduras pesadas e se sente confortável quando verga uma. Você considera a FN de Qualquer armadura com a Característica Pesada como tendo FN-1 para todos os propósitos. Essa redução se acumula com a redução fornecida por Guerreiro de Aço 1.",
                        "",
                        "",
                        "",
                        "Guerreiro de Aço 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Furtivo",
                        suporte,
                        todasRacas,
                        bardos_ladinos_patrulheiros,
                        1,
                        "Você é particularmente discreto quando quer. Você pode rolar +1d6 quando fizer testes para se mover em silêncio, se esconder, camuflar, ou usar disfarces.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Malabarista",
                        suporte,
                        todasRacas,
                        bardos_ladinos,
                        1,
                        "Você tem uma ótima coordenação para jogar e pegar objetos no ar. Além de poder realizar malabarismos – mesmo usando objetos perigosos como adagas ou tochas – como entretenimento, você recebe +2 em todas as suas jogadas para arremessar objetos e +1 na Defesa contra ataques à distância. Esse bônus de Defesa conta como Esquiva.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Trapaceiro Impecável",
                        suporte,
                        todasRacas,
                        bardos_ladinos,
                        5,
                        "Você está acostumado a enganar e mentir, e seu raciocínio se tornou tão condicionado a extrapolar situações rapidamente que até ler (ou mesmo dominar) sua mente é mais difícil! Sua Inteligência é considerada o dobro em Confrontos para tentar esconder ou dissimular a verdade e para calcular sua Determinação contra efeitos mentais – exceto os de medo.",
                        "",
                        "",
                        "",
                        "Eloquente",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Eloquente",
                        suporte,
                        todasRacas,
                        bardos_espadachins_ladinos,
                        1,
                        "Você tem um talento de convencer ou comover outras pessoas apenas falando do jeito certo. Você recebe +1d6 em todos os seus testes para persuadir, mentir, perceber mentiras, intimidar ou em qualquer outra interação social.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Evasão",
                        reacao,
                        todasRacas,
                        bardos_espadachins_ladinos_patrulheiro,
                        1,
                        "Se o seu inimigo fizer um ataque corporal e acertar, você pode declarar evasão, e obrigar o inimigo a rolar novamente o teste de ataque. Você pode escolher com qual dos resultados o oponente vai ficar. Esta Habilidade só pode ser usada uma vez por rodada.",
                        "",
                        "",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Truque Sujo",
                        acao,
                        todasRacas,
                        bardos_espadachins_ladinos_patrulheiro,
                        1,
                        "Quando estiver em distância corporal do oponente e ele estiver te vendo, faça um Confronto de Inteligência contra o alvo. Se você tiver um resultado igual ou maior do que o do oponente nesse teste, você realiza um truque sujo (joga areia nos olhos do oponente, joga um pano em seu rosto, enrola uma corda em suas pernas, etc.) fazendo com que o alvo fique confuso ou desequilibrado, não podendo realizar nenhuma ação no próximo turno, e sendo considerado Desprevenido por 1 turno.",
                        "",
                        "",
                        "10",
                        "Evasão",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Língua Afiada",
                        acao,
                        todasRacas,
                        bardos_espadachins,
                        1,
                        "Você possui uma língua ferina e um talento especial para insultar seus adversários. Escolha um inimigo do tipo Humanoide ou Esfinge. Você faz uma série de comentários jocosos ou degradantes sobre ele. Faça um confronto de Vontade contra o alvo. Se você tiver um resultado igual ou maior do que o alvo e se ele for capaz de entendê-lo, ele ataca você em detrimento de qualquer outro alvo, e é considerado Desprevenido para todos os seus aliados – mas não para você. Este é um efeito mental.",
                        "",
                        "",
                        "10",
                        "Eloquente",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Coração da Batalha",
                        reacao,
                        todasRacas,
                        bardos_espadachins_paladinos,
                        5,
                        "Quando sofrer algum dano proveniente de um ataque, Magia, ou Música você recupera 5 Pontos de Mana. Você só pode usar esta Habilidade uma vez por turno.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Grito de Guerra 1",
                        acao,
                        todasRacas,
                        bardos_guerreiros_paladinos,
                        1,
                        "Você pode dar um grito fervoroso que motiva todos seus aliados. Eles recebem (assim como você) +1 em todas as rolagens até o final da batalha. Além disso, remova todos os efeitos de Medo que estiverem afetando os seus aliados. Você não pode usar esta Habilidade se estiver sob qualquer efeito de Medo. Este é um efeito mental.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Grito de Guerra 2",
                        acao,
                        todasRacas,
                        bardos_guerreiros_paladinos,
                        5,
                        "Você pode dar um grito fervoroso que motiva todos seus aliados. Eles recebem (assim como você) +2 em todas as rolagens até o final da batalha. Além disso, remova todos os efeitos de Medo que estiverem afetando os seus aliados. Você não pode usar esta Habilidade se estiver sob qualquer efeito de Medo.",
                        "",
                        "",
                        "15",
                        " Grito de Guerra 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Dissipar Magia",
                        acao,
                        todasRacas,
                        druidas_feiticeiros_runicos_sacerdotes,
                        5,
                        "Você dissipa todas as Runas Arcanas ou Selos Místicos de uma criatura, objeto ou estrutura com seu toque. Essa Habilidade não tem efeito em Runas ou Selos com efeitos instantâneos (como Curar Ferimentos, Rajada de Espinhos ou Teleporte) nem reverte efeitos permanentes de magia (como restaurar os Pontos de Vida perdidos devido a uma Bola de Fogo, dissipar água criada por Princípio Natural ou reverter água afetada por Raio Gélido de volta ao estado líquido). Você pode também escolher quais Runas ou Selos dissipar e quais não, caso o alvo tenha mais de um Selo ou Runa afetando-o. O custo para dissipar um Selo ou Runa é igual ao custo usado para conjurá-los.",
                        "",
                        "",
                        "Variável",
                        "Aparar Magia",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Grito de Intimidação",
                        acao,
                        todasRacas,
                        bardos_guerreiros,
                        5,
                        "Você pode dar um grito para intimidar seus inimigos. Todos os oponentes que estiverem a até 10 metros à sua frente que tiverem uma Determinação menor do que a sua ficam Paralisados por 2 turnos. Esse é um efeito de Medo.",
                        "",
                        "",
                        "35",
                        "Grito de Guerra 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mente Disciplinada",
                        suporte,
                        todasRacas,
                        feiticeiros_runicos,
                        1,
                        "Você possui uma vontade extremamente organizada, acostumada a se concentrar em tarefas complexas. Você tem Determinação +2 e as dificuldades de todas as magias que você realiza são reduzidas em 1.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Resistência Elemental",
                        acao,
                        todasRacas,
                        feiticeiros_runicos,
                        1,
                        "Desenhando uma Runa Arcana sobre uma criatura ou objeto, você confere Resistência ao Fogo, Frio ou Eletricidade a ele. Essa Runa Arcana dura por 1 minuto.",
                        "",
                        "9",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Combate Tático",
                        reacao,
                        todasRacas,
                        espadachins_guerreiros_paladinos_runicos_xamas,
                        1,
                        "Se você derrotar um oponente com um ataque corporal, você pode imediatamente realizar outro ataque corporal normal (mas não Habilidades de Ação).",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Guerreiro de Aço 1",
                        suporte,
                        todasRacas,
                        espadachins_guerreiros_paladinos_runicos,
                        1,
                        "Você está acostumado a usar armaduras pesadas. Você considera a FN de qualquer armadura com a Característica Pesada como tendo FN-1 para todos os propósitos.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Sem Escapatória",
                        reacao,
                        todasRacas,
                        espadachins_guerreiros_paladinos_runicos_xamas,
                        1,
                        "Se um oponente que está adjacente a você tentar se afastar ou se levantar, você pode imediatamente fazer um ataque corporal normal contra ele. Se acertar, além de sofrer o dano normal pelo ataque, o oponente não poderá se deslocar neste turno.",
                        "",
                        "",
                        "",
                        "Combate Tático",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre de Armas 1",
                        suporte,
                        todasRacas,
                        espadachins_guerreiros_paladinos,
                        1,
                        "Você é particularmente eficiente no uso de armas brancas. Sempre que realizar um ataque corporal usando uma arma, adicione 3 ao dano do ataque.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Implacável",
                        suporte,
                        todasRacas,
                        espadachins_guerreiros_paladinos_runicos_xamas,
                        5,
                        "Sempre que errar um ataque corporal, o alvo sofre metade do dano normal do ataque (arredondando para baixo).",
                        "",
                        "",
                        "",
                        "Sem Escapatória",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Valor da Vitória",
                        reacao,
                        todasRacas,
                        espadachins_guerreiros_paladinos,
                        5,
                        "Cada vez que você derrota um oponente (isso inclui se ele se render ou fugir após a batalha) você recupera 5 pontos de vida e 5 pontos de mana.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Giratório",
                        acao,
                        todasRacas,
                        espadachins_guerreiros,
                        1,
                        "Você realiza um ataque amplo, girando sua arma para atingir todos os oponentes próximos. Faça um ataque corporal contra cada alvo dentro do seu alcance corporal.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Investida Mortal",
                        acao,
                        todasRacas,
                        espadachins_guerreiros,
                        1,
                        "Faça uma manobra de encontrão contra um alvo. Esse ataque causa +10 de dano, e se acertar deixa o alvo Atordoado (O personagem tem -1 na Defesa, no Deslocamento e em todos os seus testes) por 1 turno.",
                        "",
                        "",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre de Armas 2",
                        suporte,
                        todasRacas,
                        espadachins_guerreiros_runicos,
                        5,
                        "Você é extremamente eficaz no uso de armas brancas. Sempre que realizar um ataque corporal bem sucedido, adicione 3 ao dano do ataque. Esse bônus de dano se acumula com o bônus fornecido por Mestre de armas 1.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Combate com Duas Armas 1",
                        suporte,
                        todasRacas,
                        espadachins_guerreiros_ladinos_xamas,
                        1,
                        "Você treinou para usar duas armas em combate de forma eficiente. Você pode fazer um ataque para cada arma que estiver segurando, desde que pelo menos uma delas tenha uma FN igual à metade (ou menos) do que a Força do personagem.",
                        "Se você utilizar uma Habilidade de Ação, seus efeitos se aplicam a apenas um dos seus ataques – mas você ainda pode fazer um ataque normal com a outra arma no mesmo turno, antes ou depois de utilizar a Habilidade de Ação.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Combate com Duas Armas 2",
                        suporte,
                        todasRacas,
                        espadachins_guerreiros_ladinos,
                        5,
                        "Como Combate com Duas Armas 1, mas você pode usar duas armas com a mesma FN.",
                        "Se você utilizar uma Habilidade de Ação, seus efeitos se aplicam a apenas um dos seus ataques – mas você ainda pode fazer um ataque normal com a outra arma no mesmo turno, antes ou depois de utilizar a Habilidade de Ação.",
                        "",
                        "",
                        "Combate com Duas Armas 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Acrobata",
                        suporte,
                        todasRacas,
                        espadachins_ladinos,
                        1,
                        "Você sempre rola +1d6 em seus testes de equilíbrio, salto, piruetas e qualquer outra tentativa de se deslocar que exija coordenação, flexibilidade e precisão. Além disso, você sofre apenas metade dos danos por queda.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Aparar",
                        suporte,
                        todasRacas,
                        espadachins_ladinos,
                        1,
                        "Você pode usar qualquer coisa que esteja em suas mãos para afastar e desviar golpes desferidos contra você. Enquanto estiver com um objeto em pelo menos uma das mãos, você recebe Defesa +1. Se estiver segurando uma objeto em ambas as mãos ou um objeto em cada mão você recebe Defesa +2. Este e um bônus de Esquiva.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Redirecionado",
                        reacao,
                        todasRacas,
                        espadachins_ladinos,
                        1,
                        "Quando um oponente errar um ataque corporal contra você, você pode direcionar o ataque dele para outro alvo. O novo alvo precisa estar adjacente a você ou ao oponente que errou o ataque. Esse ataque acerta automaticamente – sem chance de errar ou de ser um sucesso decisivo. Esta Habilidade só pode ser usada uma vez por rodada.",
                        "",
                        "",
                        "",
                        "Evasão",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Corte Arterial",
                        acao,
                        todasRacas,
                        espadachins_ladinos,
                        1,
                        "Faça um ataque corporal com uma arma de corte ou perfuração. Se acertar, a vítima começará a sangrar, perdendo 10 Pontos de Vida no início de cada um de seus turnos. Este é um efeito de sangramento.",
                        "",
                        "",
                        "30",
                        "Ataque Aleijador",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Golpes Rápidos",
                        acao,
                        todasRacas,
                        espadachins_ladinos,
                        1,
                        "Você pode fazer dois ataques corporais com uma arma que estiver empunhando, desde que esteja empunhando a arma com apenas 1 mão.",
                        "",
                        "",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Movimentos Evasivos",
                        suporte,
                        todasRacas,
                        espadachins_ladinos,
                        1,
                        "Você ganha +1 na sua Defesa para cada 2 pontos que tiver em Agilidade. Esta habilidade só funciona se você estiver sem armadura. Esse é um bônus de Esquiva.",
                        "",
                        "",
                        "",
                        "Acrobata",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ripostar",
                        reacao,
                        todasRacas,
                        espadachins_ladinos,
                        5,
                        "Você está sempre atento à guarda do oponente, esperando uma falha para contra-atacar de modo oportuno. Sempre que um oponente fizer um ataque contra você e errar, você pode imediatamente fazer um ataque normal contra aquele oponente.",
                        "",
                        "",
                        "",
                        "Ataque Redirecionado",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Ataque Aleijador",
                        acao,
                        todasRacas,
                        espadachins_ladinos_patrulheiros,
                        1,
                        "Faça um ataque corpo-a-corpo ou à distância, visando o quadril, joelho ou tornozelo do alvo, comprometendo sua locomoção e deixando um ferimento doloroso. Além de receber o dano normal pelo ataque, o alvo fica com seu Deslocamento reduzido em 1 e sempre que se deslocar ou fizer um teste de Agilidade que envolva as pernas ele sofre 10 pontos de dano. Esse é um efeito de Sangramento.",
                        "",
                        "",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Falhas da Armadura",
                        suporte,
                        todasRacas,
                        espadachins_ladinos_patrulheiros,
                        1,
                        "Você sabe como acertar ataques entre as frestas e falhas das armaduras do inimigo. Ignore sempre o bônus de Armadura da Defesa do oponente.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Companheiro Animal 1",
                        suporte,
                        todasRacas,
                        druidas_patrulheiros_xamas,
                        1,
                        "Você possui uma ligação de fidelidade com um animal. Escolha uma Besta dos tipos Mamífero, Ave, Réptil ou Peixe e faça um teste de Vontade (Dificuldade igual à soma de todos os atributos do animal +1 para cada metro de tamanho que o animal tiver). Se passar no teste, o animal escolhido será atraído para você e lhe será fiel até a morte (ele passa a ter o temperamento Protetor). Se o animal morrer, você pode tentar atrair outro animal – que não precisa ser do mesmo tipo escolhido anteriormente – com fazendo o mesmo teste. Este teste pode ser realizado 1 vez por dia. Você pode atrair 1 animal de cada vez com essa Habilidade.",
                        "Se essa Habilidade for escolhida durante a criação do personagem, o animal já estará com você, sem a necessidade de qualquer teste para atraí-lo, desde que a dificuldade para atraí-lo seja menor do que a soma dos Atributos do personagem.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Companheiro Animal 2",
                        suporte,
                        todasRacas,
                        druidas_patrulheiros_xamas,
                        1,
                        "Seu companheiro animal recebe +1 em 2 Atributos à sua escolha, +5 Pontos de vida e +5 Pontos de Mana. Além disso, seu companheiro Animal recebe uma Habilidade do tipo Técnica à sua escolha (desde que faça sentido; o Mestre tem a palavra final sobre o assunto).",
                        "",
                        "",
                        "",
                        "Companheiro Animal 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Espírito Animal",
                        suporte,
                        todasRacas,
                        druidas_patrulheiros_xamas,
                        1,
                        "Seu espírito possui a forma de um animal. Escolha um Espírito Animal para ser seu guia. Essa escolha é permanente.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Herbalismo",
                        suporte,
                        todasRacas,
                        druidas_patrulheiros_xamas,
                        1,
                        "Você pode rolar testes de Inteligência para criar poções básicas e, enquanto estiver em um ambiente selvagem, você e seus aliados não são afetados por doenças e venenos naturais – seus aliados passam a ser imunes depois de um dia inteiro que estiverem com você, desde que eles aceitem suas dicas do que comer e do que não comer. Além disso, enquanto estiver em terreno natural que possa fornecer ervas, folhas e frutos (qualquer lugar exceto cidades, desertos ou regiões glaciais) você sempre faz testes de primeiros socorros como se tivesse um Kit de Cura à mão.",
                        "",
                        "",
                        "",
                        "Sabedoria Selvagem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Sabedoria Selvagem",
                        suporte,
                        todasRacas,
                        druidas_patrulheiros_xamas,
                        1,
                        "Você passou muito tempo em ambientes selvagens e dedicou muito tempo ao estudo da natureza em todas as suas formas. Você rola +1d6 em testes que envolvam a natureza como forragear, rastrear, encontrar abrigo, identificar ervas, etc.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Companheiro Animal 3",
                        suporte,
                        todasRacas,
                        druidas_patrulheiros_xamas,
                        5,
                        "Seu Companheiro Animal recebe +1 em todos os seus Atributos e +10 Pontos de Vida ou +10 Pontos de Mana à sua escolha. Além disso, seu Companheiro Animal recebe uma Habilidade do tipo Técnica à sua escolha (desde que faça sentido; o Mestre tem a palavra final sobre o assunto).",
                        "",
                        "",
                        "",
                        "Companheiro animal 2",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Venefício",
                        acao,
                        todasRacas,
                        druidas_patrulheiros,
                        5,
                        "Você é um especialista na fabricação, aplicação e cura de venenos. Você pode produzir qualquer veneno ou antídoto avançado.",
                        "Se você tiver alguma Habilidade do tipo Magia que cause dano por Perfuração ou Corte em um alvo, ela também aplicam um efeito de veneno potente (O alvo perde 5 Pontos de Vida por turno) além do dano normal. Esse veneno é considerado mágico e permanece ativo por uma quantidade de turnos igual à sua Vontade ou até ser curado.",
                        "",
                        "",
                        "Herbalismo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Benção de Ellenis",
                        suporte,
                        todasRacas,
                        druidas_patrulheiros_xamas,
                        1,
                        "Você é capaz de se comunicar com qualquer Besta do tipo Mamífero, Ave, Réptil ou Peixe. Essa comunicação é rudimentar, baseada nas capacidades da criatura em questão. Além disso, você receber +2 em todas as rolagens envolvendo essas criaturas e poder alterar o temperamento delas em 1 passo (Furioso ou Cruel para Agressivo, Agressivo para Sobrevivente, Sobrevivente para Pacífico e Pacífico para Covarde ou vice-versa) com um teste de Vontade (Dificuldade igual à Determinação do alvo) – esse efeito não funciona em animais com temperamento Servo ou Protetor. Animais selvagens só irão aceitar “conversar” se tiverem temperamento pacífico ou sobrevivente, a menos que estejam aprisionados ou encurralados de alguma forma.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Conhecimento Arcano",
                        acao,
                        todasRacas,
                        feiticeiros_runico,
                        1,
                        "Você é capaz de decifrar e canalizar os fenômenos do sobrenatural. Você pode ler e utilizar tomos mágicos e desenhar Runas Arcanas (veja a página 36 para regras sobre magia). Você também é capaz de canalizar sua energia para a conjuração de fenômenos mágicos com eficiência. Sempre que usar uma Habilidade do tipo Magia, você pode gastar Pontos de Vida ao invés de Pontos de Mana para pagar seu custo. Nesse caso, cada 2 Pontos de Vida equivalem à 1 Ponto de Mana.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Detectar Magia",
                        acao,
                        todasRacas,
                        druidas_feiticeiros_runicos_sacerdotes,
                        1,
                        "Concentrando-se nos fluxos de energias mágicas, você pode enxergar a aura de objetos mágicos, Runas Arcanas e Selos Místicos. Você pode analisar a aura mágica de um Selo, Runa ou objeto para entender suas propriedades observando-a por 1 minuto.",
                        "",
                        "8",
                        "0",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Aparar Magia",
                        reacao,
                        todasRacas,
                        druidas_feiticeiros_runicos_sacerdotes,
                        1,
                        "Sempre que for alvo de uma Magia que cause dano ou perda de vida, você pode reduzir aquele dano ou perda de vida pela metade. Essa Habilidade não afeta quaisquer outros efeitos da magia além de dano ou perda de vida.",
                        "Se você tiver Resistência ao tipo de dano que a magia causa, você não sofre dano e evita qualquer outro efeito da magia.",
                        "",
                        "5",
                        "Detectar Magia",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Abençoar Aliados 1",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Você desenha um Selo Místico sobre sí mesmo que concede um bônus de +1 em todas as suas rolagens. Todos os seus aliados que estiverem à uma distância em metros de você igual à sua Determinação quando você desenha este Selo também são afetados  por ele. Esse Selo Místico dura 1 minuto.",
                        "",
                        "10",
                        "10",
                        "Graça Divina",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Abençoar Objeto",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Você desenha um Selo Místico sobre uma arma ou armadura para que ela se torne mais eficiente contra criaturas sobrenaturais. Uma arma abençoada causa +6 de dano contra demônios, mortos-vivos e espíritos, além de atingir criaturas incorpóreas como se elas não tivessem a Habilidade Corpo Intangível. Se você abençoar uma armadura, qualquer demônio, morto-vivo ou espírito que tocá-la (incluindo com ataques desarmados) perde imediatamente 6 Pontos de Vida – e perde 6 Pontos de vida a cada turno que comece em contato com a armadura. Esse Selo Místico dura 1 hora.",
                        "",
                        "8",
                        "10",
                        "Graça Divina",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Asceta",
                        suporte,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Através de sua dedicação aos dogmas de sua divindade ou panteão, você adquiriu um considerável conhecimento e uma compreensão intuitiva sobre seus desígnios. Você rola +1 em todos os seus testes envolvendo magias (incluindo conjurá-las) e conhecimento. Além disso, todas as suas magias de Cura recuperam 5 Pontos de Vida a mais.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Aura de Cura 1",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Você desenha um Selo Místico sobre sí mesmo que recupera 10 Pontos de Vida. Todas as criaturas vivas que estiverem à uma distância em metros de você igual à sua Determinação quando você desenha este selo também são afetados por ele. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "11",
                        "15",
                        "Curar Ferimentos 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Cariátide",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Você pode dar movimentos para uma estátua desenhando um Selo Místico sobre ela. A estátua precisa ter uma forma aproximadamente humanoide e toda feita de um mesmo material. O custo da magia depende do tamanho da estátua: 20 Pontos de Mana para uma estátua pequena, 40 Pontos de Mana para uma estátua média e 80 Pontos de Mana para uma estátua grande. A estátua terá as características de um Golem do material e tamanho apropriados. Esse Selo Místico dura 1 Minuto. Veja os dados dos Golens no Monstrum Codex para mais detalhes.",
                        "",
                        "12",
                        "Variável",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Conjurar Arma dos Deuses",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Você desenha um Selo Místico no ar que se materializa na forma da arma favorecida pela sua divindade. O Selo Místico que conjura a arma se dissipa após 1 minuto, mas se você soltar a arma ele se dissipa imediatamente.",
                        "",
                        "10",
                        "20",
                        "Dogma",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Conjurar Lança do Destino",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Você desenha um Selo Místico no ar que assume a forma de uma lança de luz. A lança arremete na direção de um alvo que você possa ver e causa dano igual a 10/Perfuração. Se a criatura for um demônio, morto-vivo ou espírito a lança causa o dobro do dano. Após atingir o alvo a lança se dissipa em uma explosão de luz, e o alvo precisa fazer um teste de Vontade (dificuldade igual à sua Determinação) ou fica Distraído por 1 turno. Demônios, mortos-vivos ou espíritos não têm direito ao teste para evitar ficarem Distraídos. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "10",
                        "15",
                        "Exorcismo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Conjurar Broquel Místico",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Você desenha um Selo Místico sobre uma criatura que se materializa na forma de um escudo que flutua ao redor do alvo defletindo ataques, mas pode ser segurado como um escudo normal. Ele garante Esquiva +2, e se for segurado tem FN 2, ocupa 1 mão e seu bônus passa a ser de Bloqueio. Esse Selo Místico dura 1 minuto.",
                        "",
                        "10",
                        "10",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Corpo Fechado",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Desenhando um Selo Místico sobre um alvo, você confere Resistência à Contusão, Corte ou Perfuração a ele. Esse Selo Místico dura por 1 minuto.",
                        "",
                        "12",
                        "20",
                        "Proteção Mística",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Curar Ferimentos 1",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Desenhando um Selo Místico sobre uma criatura viva que recupera imediatamente 10 Pontos de Vida. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "8",
                        "5",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Dogma",
                        suporte,
                        todasRacas,
                        sacerdotes_xamas,
                        1,
                        "Você segue estritamente os ensinamentos de uma divindade que, em troca, lhe concede um favor especial. Escolha um Dogma para seguir. Essa escolha é permanente e não pode ser mudada posteriormente.",
                        "Um personagem que não siga os Dogmas de uma divindade específica é considerado um Discípulo do Panteão ou Sacerdote do Panteão e não está vinculado a nenhuma divindade em particular – nem recebe quaisquer benefícios ou precisa seguir nenhuma conduta específica.",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Exorcismo",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Você desenha um Selo Místico no ar que expurga os mortos-vivos, demônios e espíritos que estiverem a uma distância em metros igual à sua Determinação ao seu redor, fazendo com que eles imediatamente percam 10 Pontos de Vida e 10 Pontos de Mana. Criaturas afetadas que tenham Mente Vazia perdem todos os seus Pontos devida e Mana imediatamente. Mortos-vivos destruídos por essa magia voltarão a ser cadáveres inanimados e não poderão ser reanimados novamente, demônios são imediatamente enviados de volta ao inferno e não podem sair de lá por 1 ano e espíritos são permanentemente dissipados. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "11",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Graça Divina",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Desenhando um Selo Místico sobre uma criatura viva, você imbui ela com a graça de sua Divindade. O alvo recebe +1 em todas as suas rolagens. Este Selo Místico dura por 1 minuto.",
                        "",
                        "8",
                        "5",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Proteção Mística",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Desenhando um Selo Divino sobre uma criatura viva, você à deixa imune a todos os efeitos mentais, efeitos de Medo, e Ilusões. Este Selo dura uma quantidade de horas igual à Vontade do conjurador.",
                        "",
                        "10",
                        "10",
                        "Toque Místico",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Purgar",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Desenhando um Selo Místico sobre uma criatura, objeto ou superfície, você os purifica de impurezas mundanas. Qualquer veneno ou agente infeccioso de origem natural afetado por essa magia se torna água pura  e límpida, incluindo substâncias que estiverem em alimentos ou bebidas. Qualquer criatura afetada é imediatamente curada de qualquer veneno, doença, infecção de origem natural e também de quaisquer efeitos de sangramento. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "10",
                        "10",
                        "Curar Ferimentos 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Toque Místico",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Desenhando um Selo Místico sobre uma criatura viva você a infunde com inspiração momentânea. Se o alvo usar uma Habilidade com Custo de Mana igual ou menor a 30, ele não gasta nenhum Ponto de Mana. Essa magia não tem efeito em Habilidades com Custo de Mana maiores do que 30 e não pode ser usada sobre você mesmo. Este Selo Místico dura até o final do próximo turno do alvo, mas se ele gastar Pontos de Mana antes disso, o Selo se dissipa imediatamente.",
                        "",
                        "10",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Velocidade",
                        acao,
                        todasRacas,
                        sacerdotes,
                        1,
                        "Desenhando um Selo Místico sobre uma criatura viva você aumenta a velocidade dela, deixando-a com o dobro do Deslocamento e de ações. Este Selo Místico se dissipa no final do próximo turno do alvo.",
                        "",
                        "11",
                        "20",
                        "Caminhada Mágica",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Abençoar Aliados 2",
                        acao,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Você desenha um Selo Místico sobre sí mesmo que concede um bônus de +2 em todas as suas rolagens. Todos os seus aliados que estiverem à uma distância em metros de você igual à sua Determinação quando você desenha este Selo também são afetados por ele. Esse Selo Místico dura 1 minuto.",
                        "",
                        "12",
                        "15",
                        "Abençoar Aliados 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Aura de Cura 2",
                        acao,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Você desenha um Selo Místico sobre sí mesmo que recupera 30 Pontos de Vida. Todas as criaturas vivas que estiverem à uma distância em metros de você igual à sua Determinação quando você desenha este Selo também são afetados por ele. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "13",
                        "30",
                        "Aura de Cura 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Círculo da Proteção",
                        acao,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Você desenha um Selo Místico no ar que se transforma em uma barreira de energia centrada em você e com um diâmetro igual á sua Vontade. A barreira é imaterial, indestrutível, imóvel, translúcida e bloqueia qualquer magia (tanto de fora para dentro quanto de dentro para fora). Além disso, qualquer demônio, morto-vivo ou espírito perde 20 Pontos de Vida A cada turno em começar dentro da barreira. O Selo Místico dura tanto tempo quanto você se mantiver dentro da barreira e concentrado em mantê-la.",
                        "",
                        "13",
                        "40",
                        "Conjurar Broquel Místico, Exorcismo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Conjurar Falange do Destino",
                        acao,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Você desenha um Selo Místico no ar que se transforma em um conjunto de lanças de luz igual à metade da sua Vontade que arremetem imediatamente na direção de seus inimigos. Cada lança causa dano igual a 10/Perfuração. Se o alvo for um demônio, morto-vivo ou espírito, a lança causa o triplo de dano. Após atingir o alvo a lança se dissipa em uma explosão de luz, e o alvo precisa fazer um teste de Vontade (dificuldade igual à Determinação do conjurador) ou fica Distraído por 1 turno. Demônios, mortos-vivos e espíritos não tem direito ao teste para evitarem ficar Distraídos. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "Você pode atingir o mesmo alvo com várias lanças, ou um alvo com cada lança.",
                        "12",
                        "60",
                        "Conjurar Lança do Destino",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Criar Golem",
                        acao,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Você pode dar movimentos para um receptáculo especialmente preparado. Você precisa de um receptáculo de forma aproximadamente humanoide todo feito de um mesmo material com uma pedra preciosa incrustada nele. A pedra preciosa precisa ter um valor de 400 moedas para cada metro de altura do Golem. Você então desenha um Selo Místico sobre o receptáculo, que se torna um Golem do material e tamanho apropriados. O Selo Místico que mantém o Golem dura 1 hora. Veja os dados de diversos tipos de Golens no Monstrum Codex para mais detalhes.",
                        "",
                        "14",
                        "60",
                        "Cariátide",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Curar Ferimentos 2",
                        acao,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Desenhando um Selo Místico sobre uma criatura viva, ela recupera imediatamente 60 pontos de vida. O Selo Místico se dissipa imediatamente depois que seus efeitos são desencadeados.",
                        "",
                        "12",
                        "30",
                        "Curar Ferimentos 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Manter Golem",
                        acao,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Você desenha um Selo Místico sobre um Golem que você tenha criado, com o objetivo de fortalecer sua coesão. Cada vez que você desenhar este Selo Místico sobre o Golem, a duração do Selo que o mantém ativo será duplicada. Você pode desenhar quantos selos desses quiser sobre um Golem, e seus efeitos são cumulativos.",
                        "",
                        "12",
                        "10",
                        "Criar Golem",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Portal",
                        acao,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Desenhando um Selo Místico no ar, ele se torna uma passagem (com o tamanho aproximado de uma porta) até um local onde haja outro Selo da sua divindade (pode ser uma igreja que você conheça, ou algum lugar onde você tenha escrito um Selo da sua divindade previamente). A distância entre os dois pontos é irrelevante. Este Selo Místico dura 1 minuto, mas você pode dissipá-lo à qualquer momento.",
                        "",
                        "14",
                        "60",
                        "Caminhada Mágica",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Primaz",
                        suporte,
                        todasRacas,
                        sacerdotes,
                        5,
                        "Você acumulou um grande conhecimento sobre os desígnios das divindades. Você rola +1 em todos os seus testes envolvendo magias (incluindo conjurá-las) e conhecimento (esse bônus se acumula com os bônus de Asceta). Além disso, o custo de todas as Habilidades do tipo Magia que você lançar é diminuído em 5.",
                        "",
                        "",
                        "",
                        "Clérigo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Pontífice",
                        suporte,
                        todasRacas,
                        sacerdotes,
                        10,
                        "Você adquiriu uma profunda ligação e um conhecimento extremamente amplo sobre a magia e seu fluxo das Divindades para o mundo material. Você rola +2 em todos os seus testes envolvendo magias (incluindo conjurá-las), todas as suas magias de Cura recuperam 5 Pontos de Vida a mais e o custo de todas as Habilidades do tipo Magia que você lançar é diminuído em 5. Além disso todos os Selos Místicos que você desenhar duram o dobro do tempo normal.",
                        "",
                        "",
                        "",
                        "Primaz",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Guia Espiritual",
                        suporte,
                        todasRacas,
                        xamas,
                        1,
                        "Você possui um Guia Espiritual que está constantemente com você. Este Guia pode assumir qualquer forma, mas normalmente escolhe a forma de um animal com o qual você tenha uma ligação ou de um de seus ancestrais. Ele se mantém sempre alerta e próximo de você, e irá lhe despertar se algum perigo se aproximar enquanto você estiver dormindo, além de lhe avisar de qualquer perigo imediato, garantir um bônus de +2 em seus testes de Iniciativa. O Guia Espiritual também pode oferecer conselhos e ajuda quando necessário. Quando estiver diante de uma situação que envolva um teste ligado à animais (adestrar, convocar um Companheiro Animal), natureza (rastrear, procurar abrigo) ou algum outro conhecimento que seu Guia poderia ter (como lidar com outros espíritos) você pode meditar por 1 hora em busca de orientação de seu Guia, recebendo +1d6 no teste apropriado.",
                        "",
                        "",
                        "",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        true
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Chamado do Alfa",
                        acao,
                        todasRacas,
                        xamas,
                        1,
                        "Você solta um poderoso uivo (ou uma poderosa vibração sob a água) que será entendida como um chamado irresistível para os animais que o ouvirem. Você consegue atrair todas as Bestas (Escolha entre Mamífero, Ave, Réptil ou Peixe) do tipo escolhido que estejam a até 500 metros por ponto de Força que você tenha. Os animais não estarão sob seu controle, mas se sentirão inclinados a ajudá-lo dentro de suas capacidades – animais com temperamento pacífico ou covarde não irão entrar em combate, mas animais sobreviventes ou agressivos não terão problemas com isso. ",
                        "Você pode refinar o tipo específico de animal (Ursos, Marsupiais, Batráquios) ou até mesmo um animal específico (Aquele esquilo com quem eu conversei ontem, meu Companheiro Animal, O cão do guarda-caça) quando conjurar essa magia.",
                        "",
                        "20",
                        "Benção de Ellenis",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Cura Espiritual",
                        acao,
                        todasRacas,
                        xamas,
                        1,
                        "Com seu toque você pode recuperar as energias de um espírito. Você pode curar até 40 Pontos de Vida de uma criatura com Corpo Intangível, além de remover quaisquer efeitos Mentais, de medo, Selos Místicos e Runas Arcanas que a estiverem afetando.",
                        "",
                        "",
                        "20",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Forma Animal 1",
                        acao,
                        todasRacas,
                        xamas,
                        1,
                        "Você pode se transformar em qualquer Besta dos tipos Mamífero, Réptil, Ave ou Peixe com até 1,5 metros de tamanho. Use as estatísticas do animal em que se transformou, mantendo apenas sua Inteligência, Vontade, Pontos de Vida e Pontos de Mana. Não é possível lançar magias, usar armas ou falar com criaturas que não sejam da espécie em que você se transformou enquanto este efeito estiver ativo. Todo o equipamento que você estiver carregando é absorvido e desaparece na transformação e nenhum deles oferecerá nenhum modificador enquanto você permanecer na forma animal (incluindo itens mágicos). Você pode permanecer nesta forma por até 1 hora, mas pode retomar sua forma natural à qualquer momento.",
                        "",
                        "",
                        "20",
                        "Benção de Ellenis",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Invocar Espírito Animal",
                        acao,
                        todasRacas,
                        xamas,
                        1,
                        "Você invoca um espírito animal espectral para protegê-lo. Esse espectro tem a forma do seu Espírito Animal, mas os Atributos dele serão todos iguais à sua Vontade. Além das Habilidades normais do animal, todos os Espíritos Animais terão Mente Bloqueada e Corpo Intangível. Seus ataques causam dano igual à Força +2 por Corte, Perfuração ou Esmagamento – o que for mais apropriado, de acordo com os ataques do animal – e recebem os bônus referentes ao seu Espírito Animal. Espíritos Animais têm 30 Pontos de Vida e 30 Pontos de Mana. Espíritos Animais são sempre Bestas do tipo Espírito com o temperamento Servo. Essa magia dura 1 minuto ou até o animal espectral ser destruído.",
                        "Águias Espectrais invocadas por essa magia recebem +1 em seus ataques corporais ao invés do bônus normal.",
                        "",
                        "20",
                        "Espírito Animal, Contato com Espíritos",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Rugido do Alfa",
                        acao,
                        todasRacas,
                        xamas,
                        1,
                        "Você emite um rugido capaz de abalar até o mais valente dos predadores Todos os oponentes que estiverem a até 10 metros à sua frente que tiverem uma Determinação menor do que a sua ficam Paralisados por 1 turno. Um oponente só é afetado por esta habilidade uma vez por combate. Este é um efeito de Medo.",
                        "",
                        "",
                        "40",
                        "Rugido do Predador",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Rugido do Predador",
                        acao,
                        todasRacas,
                        xamas,
                        1,
                        "Você emite um rugido amedrontador. Todos os oponentes que estiverem a até 10 metros à sua frente que tiverem uma Determinação menor do que a sua ficam Amedrontados por 1 turno. Um oponente só é afetado por esta habilidade uma vez por combate. Este é um efeito de Medo.",
                        "",
                        "",
                        "25",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Vantagem Animal 1",
                        acao,
                        todasRacas,
                        xamas,
                        1,
                        "Você pode transformar uma pequena parte do seu corpo para que ela assuma uma característica animal, lhe conferindo uma Habilidade temporária. Você pode transformar seus olhos para captar mais luz como uma coruja, recebendo Visão no Escuro, tornar suas unhas em garras de um tigre e receber Garras ou modificar seu nariz para que se pareça com o de um lobo, recebendo Faro, por exemplo. Apenas pequenas modificações são possíveis, e as possibilidades devem ser discutidas com o Mestre. Esse efeito dura 1 hora, mas você pode cancelá-lo quando quiser.",
                        "",
                        "",
                        "10",
                        "Forma Animal 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Atropelar",
                        suporte,
                        todasRacas,
                        xamas,
                        5,
                        "Quando usar Ataque do Búfalo, se o alvo for derrubado ele sofre um dano adicional igual a 6/Contusão para cada 100 quilos de peso que você tiver.",
                        "",
                        "",
                        "0",
                        "Ataque do Búfalo",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Caminhada Fantasma",
                        acao,
                        todasRacas,
                        xamas,
                        5,
                        "Você tornou-se um canal entre o mundo físico e o mundo espiritual. Você (e tudo o que você estiver carregando) pode tomar a forma de um espírito, adquirindo a Habilidade Corpo Intangível – você não tem peso, pode voar ao seu Deslocamento normal em qualquer direção e atravessar objetos sólidos. Você pode materializar partes do seu corpo, permitindo que você ataque ou conjure magias, e a menos que escolha o contrário, você é Imune à Corte, Perfuração e Contusão. Magias que causem danos desses tipos, no entanto, afetam você normalmente. Além disso, você pode ver, ouvir e tocar espíritos ou criaturas com a Habilidade Corpo Intangível enquanto estiver sob efeito dessa Habilidade. Este efeito dura um número de minutos igual à sua Determinação. Se o efeito terminar enquanto você estiver dentro de algum material sólido, você é expelido para fora e sofre dano igual a 30/Contusão.",
                        "Se você tiver Imunidade Espiritual, os efeitos dessa Habilidade não funcionam enquanto você estiver sob efeito de Caminhada Fantasma.",
                        "",
                        "40",
                        "Comunhão com Espíritos",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Companheiro Espiritual",
                        suporte,
                        todasRacas,
                        xamas,
                        5,
                        "Seus Espíritos Animais conjurados duram permanentemente (mas você ainda pode cancelar o efeito quando quiser) e recebem +20 PV, ou +20 PM, ou +10 PV e +10 PM à sua escolha quando você os conjura. No entanto, enquanto esses Espíritos Animais estiverem conjurados, você não pode recuperar os Pontos de Mana gastos para conjurá-los. Depois que eles forem dissipados (ou destruídos) você pode recuperar esses Pontos de Mana normalmente.",
                        "",
                        "",
                        "",
                        "Invocar Espírito Animal",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Estraçalhar",
                        acao,
                        todasRacas,
                        xamas,
                        5,
                        "Você salta sobre um alvo atacando com tudo o que tem! Faça um Encontrão realizando todos os seus possíveis ataques corporais (em geral dois socos/garradas/ataques com armas, dois chutes/ataques com cascos e uma cabeçada/mordida/marrada). Se você possuir Habilidades do tipo Característica que permitam mais ataques (como Braços Extras 2) você pode realizar todos estes ataques.",
                        "",
                        "",
                        "35",
                        "Combate com Duas Armas 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Forma Animal 2",
                        acao,
                        todasRacas,
                        xamas,
                        5,
                        "Sua capacidade de assumir a forma de um animal permite que você se transforme em qualquer Besta dos tipos Mamífero, Ave, Réptil ou Peixe com até 3 metros de tamanho. Use as estatísticas do animal em que se transformou, mantendo apenas sua Inteligência, Vontade, pontos de vida e pontos de Mana. Não é possível lançar magias, usar armas ou falar com criaturas que não sejam da espécie em que você se transformou enquanto este efeito estiver ativo. Todo o equipamento que você estiver carregando é absorvido e desaparece na transformação, nenhum deles oferecerá qualquer modificadores enquanto você permanecer na forma animal (incluindo itens mágicos). Você pode permanecer nesta forma por até 1 hora, mas pode retomar sua forma natural a qualquer momento",
                        "",
                        "Variável",
                        "30",
                        "Forma Animal 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Imunidade Espiritual",
                        suporte,
                        todasRacas,
                        xamas,
                        5,
                        "Você não recebe nenhum dano de criaturas do tipo Espírito e rola +1d6 em todos os testes de Vontade ligados a estas criaturas.",
                        "",
                        "",
                        "",
                        "Comunhão com Espíritos",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Mestre Domador",
                        suporte,
                        todasRacas,
                        xamas,
                        5,
                        "Você é capaz de domar animais com extrema facilidade. Quando você captura uma criatura do tipo Besta, pode fazer um teste de Vontade com dificuldade igual à soma de todos os Atributos do animal depois que tiver cativo e bem tratado por pelo menos 1 dia inteiro. Se conseguir sucesso no teste, a criatura passa a ser considerada seu Companheiro Animal e a ter o Temperamento Protetor. Se falhar no teste, você pode tentar novamente uma vez por dia. No caso de uma falha crítica no teste, você perde completamente a confiança do animal e não será capaz de domá-lo. Você pode liberar um animal domado dessa forma. Nesse caso, o temperamento da criatura volta ao normal, mas quaisquer bônus que ele receba por suas Habilidades de Companheiro Animal permanecem. Você pode ter, simultaneamente, uma quantidade de Companheiros Animais igual à metade da sua Vontade (arredondada para baixo). ",
                        "",
                        "",
                        "0",
                        "",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Vantagem Animal 2",
                        acao,
                        todasRacas,
                        xamas,
                        5,
                        "Você pode transformar uma parte do seu corpo para que ela assuma uma característica animal, lhe conferindo uma Habilidade temporária. Você pode transformar seus braços em asas de grifo, recebendo Asas Pesadas, transformar sua cabeça para a de um lobo atroz e receber Mordida Poderosa ou desenvolver guelras como as de um tubarão, recebendo Anfíbio, por exemplo. Quaisquer modificações são possíveis, mas as possibilidades devem ser discutidas com o Mestre. Esse efeito dura 10 minutos, mas você pode cancelá-lo a qualquer momento.",
                        "",
                        "",
                        "20",
                        "Vantagem Animal 1",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );

        habilidades.add(
                new Habilidade(
                        null,
                        "Guardião da Natureza",
                        suporte,
                        todasRacas,
                        xamas,
                        10,
                        "Sua capacidade de assumir a forma de um animal permite que você se transforme em qualquer Besta dos tipos Mamífero, Ave, Réptil ou Peixe de qualquer tamanho. O custo de Mana e a Dificuldade de qualquer Habilidade relacionada a animais também são reduzidos à metade – Transformar-se em qualquer Besta maior do que 3 metros consome 20 pontos de Mana. Finalmente, todas as habilidades de assumir formas animais passam a ter duração permanente – mas você pode cancelar seus efeitos a qualquer momento.",
                        "",
                        "",
                        "0",
                        "Forma Animal 2",
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        false
                )
        );


        return gravarHabilidades(habilidades);
    }

    public List<Habilidade> listarHabilidades() {
        return habilidadeRepository.findAll();
    }

    public Habilidade obterHabilidadePeloId(long id) {
        return habilidadeRepository.findById(id);
    }
}