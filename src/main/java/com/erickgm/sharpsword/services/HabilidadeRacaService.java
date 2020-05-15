package com.erickgm.sharpsword.services;

import com.erickgm.sharpsword.domain.entities.*;
import com.erickgm.sharpsword.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HabilidadeRacaService {

    @Autowired
    private HabilidadeRacaRepository habilidadeRacaRepository;

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    @Autowired
    private RacaRepository racaRepository;

    public HabilidadeRaca obterHabilidadeRacaPeloId(long id) {
        return habilidadeRacaRepository.findById(id);
    }

    public String cargaInicial() {
        if (habilidadeRacaRepository.count() == 0)
            return cargaHabilidadesRaca();
        return "Não foi possível carregar Habilidades de Raça";
    }

    private String cargaHabilidadesRaca() {
        Raca anao = racaRepository.findByNome("Anão");
        Raca elfo = racaRepository.findByNome("Elfo");
        Raca faen = racaRepository.findByNome("Faen");
        Raca humano = racaRepository.findByNome("Humano");
        Raca aesir = racaRepository.findByNome("aesir");
        Raca fauno = racaRepository.findByNome("Fauno");
        Raca fira = racaRepository.findByNome("Fira");
        Raca juban = racaRepository.findByNome("Juban");
        Raca levent = racaRepository.findByNome("Levent");
        Raca mahok = racaRepository.findByNome("Mahok");
        Raca tailox = racaRepository.findByNome("Tailox");

        Habilidade abracoDePedra = habilidadeRepository.findByNome("Abraço de Pedra");
        Habilidade adaptabilidade = habilidadeRepository.findByNome("Adaptabilidade");
        Habilidade agilidadeHeroica = habilidadeRepository.findByNome("Agilidade Heróica");
        Habilidade arboricola = habilidadeRepository.findByNome("Arborícola");
        Habilidade asasFortes = habilidadeRepository.findByNome("Asas Fortes");
        Habilidade asasPesadas = habilidadeRepository.findByNome("Asas Pesadas");
        Habilidade assuntosDiversos = habilidadeRepository.findByNome("Assuntos Diversos");
        Habilidade astuto = habilidadeRepository.findByNome("Astuto");
        Habilidade atletismo = habilidadeRepository.findByNome("Atletismo");
        Habilidade audacia = habilidadeRepository.findByNome("Audácia");
        Habilidade barganha = habilidadeRepository.findByNome("Barganha");
        Habilidade bencaodeLathellanis = habilidadeRepository.findByNome("Benção de Lathellanis");
        Habilidade berserkir = habilidadeRepository.findByNome("Berserkir");
        Habilidade bracosExtras1 = habilidadeRepository.findByNome("Braços Extras 1");
        Habilidade bracosExtras2 = habilidadeRepository.findByNome("Braços Extras 2");
        Habilidade bravuraSelvagem1 = habilidadeRepository.findByNome("Bravura Selvagem 1");
        Habilidade bravuraSelvagem2 = habilidadeRepository.findByNome("Bravura Selvagem 2");
        Habilidade cabecaDura = habilidadeRepository.findByNome("Cabeça Dura");
        Habilidade cascosAgeis = habilidadeRepository.findByNome("Cascos Ágeis");
        Habilidade cavaleiroExperiente = habilidadeRepository.findByNome("Cavaleiro Experiente");
        Habilidade chamasInternas1 = habilidadeRepository.findByNome("Chamas Internas 1");
        Habilidade chamasInternas2 = habilidadeRepository.findByNome("Chamas Internas 2");
        Habilidade comunhaoComEspiritos = habilidadeRepository.findByNome("Comunhão com Espíritos");
        Habilidade constituicaoFeerica = habilidadeRepository.findByNome("Constituição Feérica");
        Habilidade contatoComEspiritos = habilidadeRepository.findByNome("Contato com Espíritos");
        Habilidade contosDaEstrada = habilidadeRepository.findByNome("Contos da Estrada");
        Habilidade coracaoDaMontanha = habilidadeRepository.findByNome("Coração da Montanha");
        Habilidade coracaodaMontanha2 = habilidadeRepository.findByNome("Coração da Montanha 2");
        Habilidade corpoPesado = habilidadeRepository.findByNome("Corpo Pesado");
        Habilidade dancarinoDoAr = habilidadeRepository.findByNome("Dançarino do Ar");
        Habilidade diversidade = habilidadeRepository.findByNome("Diversidade");
        Habilidade domDaMagia = habilidadeRepository.findByNome("Dom da Magia");
        Habilidade duroComoPedra = habilidadeRepository.findByNome("Duro como Pedra");
        Habilidade faro = habilidadeRepository.findByNome("Faro");
        Habilidade flautaDePa = habilidadeRepository.findByNome("Flauta de Pã");
        Habilidade forcaHeroica = habilidadeRepository.findByNome("Força Heróica");
        Habilidade forcaInterior = habilidadeRepository.findByNome("Força Interior");
        Habilidade forjadoAFogo = habilidadeRepository.findByNome("Forjado à Fogo");
        Habilidade formaDaRaposa = habilidadeRepository.findByNome("Forma da Raposa");
        Habilidade fortaleza = habilidadeRepository.findByNome("Fortaleza");
        Habilidade fulgurante = habilidadeRepository.findByNome("Fulgurante");
        Habilidade furiaBestial = habilidadeRepository.findByNome("Fúria Bestial");
        Habilidade furiaDeBatalha = habilidadeRepository.findByNome("Fúria de Batalha");
        Habilidade garras = habilidadeRepository.findByNome("Garras");
        Habilidade gregario = habilidadeRepository.findByNome("Gregário");
        Habilidade habitantedoDeserto = habilidadeRepository.findByNome("Habitante do Deserto");
        Habilidade herancaFeerica = habilidadeRepository.findByNome("Herança Feérica");
        Habilidade imparavel = habilidadeRepository.findByNome("Imparável");
        Habilidade intelectoElfico = habilidadeRepository.findByNome("Intelecto Élfico");
        Habilidade inteligenciaHeroica = habilidadeRepository.findByNome("Inteligência Heroica");
        Habilidade invisibilidadeNatural = habilidadeRepository.findByNome("Invisibilidade Natural");
        Habilidade isnuu = habilidadeRepository.findByNome("Isnuu");
        Habilidade luzesDasFadas = habilidadeRepository.findByNome("Luzes das Fadas");
        Habilidade marrada = habilidadeRepository.findByNome("Marrada");
        Habilidade menteIluminada = habilidadeRepository.findByNome("Mente Iluminada");
        Habilidade mordidaPoderosa = habilidadeRepository.findByNome("Mordida Poderosa");
        Habilidade movimentoBrusco = habilidadeRepository.findByNome("Movimento Brusco");
        Habilidade nanismo = habilidadeRepository.findByNome("Nanismo");
        Habilidade nascidoNasMontanhas = habilidadeRepository.findByNome("Nascido nas Montanhas");
        Habilidade nervosdeAco = habilidadeRepository.findByNome("Nervos de Aço");
        Habilidade oDobroOuNada = habilidadeRepository.findByNome("O Dobro ou Nada");
        Habilidade olhosDeAguia = habilidadeRepository.findByNome("Olhos de águia");
        Habilidade patasComCascos = habilidadeRepository.findByNome("Patas com Cascos");
        Habilidade patasFortes = habilidadeRepository.findByNome("Patas Fortes");
        Habilidade peleDePedra = habilidadeRepository.findByNome("Pele de Pedra");
        Habilidade peleDePedra2 = habilidadeRepository.findByNome("Pele de Pedra 2");
        Habilidade pernasVulpinas = habilidadeRepository.findByNome("Pernas Vulpinas");
        Habilidade pinturaCorporal = habilidadeRepository.findByNome("Pintura Corporal");
        Habilidade potencia = habilidadeRepository.findByNome("Potência");
        Habilidade presencaReal = habilidadeRepository.findByNome("Presença Real");
        Habilidade racaFlorestal = habilidadeRepository.findByNome("Raça Florestal");
        Habilidade racaSubterranea = habilidadeRepository.findByNome("Raça Subterrânea");
        Habilidade recursos = habilidadeRepository.findByNome("Recursos");
        Habilidade robustez = habilidadeRepository.findByNome("Robustez");
        Habilidade rugidodeAhogr = habilidadeRepository.findByNome("Rugido de Ahogr");
        Habilidade sentidosDeCacador = habilidadeRepository.findByNome("Sentidos de Caçador");
        Habilidade soproDeFogo = habilidadeRepository.findByNome("Sopro de Fogo");
        Habilidade sentidosApurados = habilidadeRepository.findByNome("Sentidos Apurados");
        Habilidade sorte = habilidadeRepository.findByNome("Sorte");
        Habilidade ulfhednar = habilidadeRepository.findByNome("Ulfhednar");
        Habilidade vigorDoDeserto = habilidadeRepository.findByNome("Vigor do Deserto");
        Habilidade vigorNordico = habilidadeRepository.findByNome("Vigor Nórdico");
        Habilidade visaoAuditiva = habilidadeRepository.findByNome("Visão Auditiva");
        Habilidade voadorEximio = habilidadeRepository.findByNome("Voador Exímio");
        Habilidade vontadeDeFerro = habilidadeRepository.findByNome("Vontade de Ferro");
        Habilidade vontadeHeroica = habilidadeRepository.findByNome("Vontade Heróica");
        Habilidade estabilidade = habilidadeRepository.findByNome("Estabilidade");

        // Todas as raças
        List<Raca> todasRacas = new ArrayList<>();
        todasRacas.add(anao);
        todasRacas.add(elfo);
        todasRacas.add(faen);
        todasRacas.add(humano);
        todasRacas.add(aesir);
        todasRacas.add(fauno);
        todasRacas.add(fira);
        todasRacas.add(juban);
        todasRacas.add(levent);
        todasRacas.add(mahok);
        todasRacas.add(tailox);

        for (Raca raca : todasRacas) {
            habilidadeRacaRepository.save(new HabilidadeRaca(agilidadeHeroica, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(atletismo, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(forcaHeroica, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(forcaInterior, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(inteligenciaHeroica, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(nanismo, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(nervosdeAco, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(recursos, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(vontadeDeFerro, raca, false));
            habilidadeRacaRepository.save(new HabilidadeRaca(vontadeHeroica, raca, false));
        }

        // Automáticas
        habilidadeRacaRepository.save(new HabilidadeRaca(coracaoDaMontanha, anao, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(vigorNordico, aesir, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(bencaodeLathellanis, elfo, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(constituicaoFeerica, faen, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(patasComCascos, fauno, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(habitantedoDeserto, fira, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(adaptabilidade, humano, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(corpoPesado, juban, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(asasPesadas, levent, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(peleDePedra, mahok, true));
        habilidadeRacaRepository.save(new HabilidadeRaca(pernasVulpinas, tailox, true));

        // Todas as racas menos Aesir
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, anao, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, elfo, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, faen, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, humano, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, fauno, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, fira, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, juban, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, levent, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, mahok, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaDeBatalha, tailox, false));

        // Todas as racas menos Mahok
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, anao, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, elfo, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, faen, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, humano, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, aesir, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, fauno, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, fira, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, juban, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, levent, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosApurados, tailox, false));

        // Aesir
        habilidadeRacaRepository.save(new HabilidadeRaca(berserkir, aesir, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(bravuraSelvagem1, aesir, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(bravuraSelvagem2, aesir, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(furiaBestial, aesir, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(potencia, aesir, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(robustez, aesir, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(ulfhednar, aesir, false));

        // Anões
        habilidadeRacaRepository.save(new HabilidadeRaca(cabecaDura, anao, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(coracaodaMontanha2, anao, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(duroComoPedra, anao, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(estabilidade, mahok, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(forjadoAFogo, anao, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(nascidoNasMontanhas, anao, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(racaSubterranea, anao, false));

        // Elfos
        habilidadeRacaRepository.save(new HabilidadeRaca(herancaFeerica, elfo, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(domDaMagia, elfo, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(invisibilidadeNatural, elfo, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(luzesDasFadas, elfo, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(racaFlorestal, elfo, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(arboricola, elfo, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(intelectoElfico, elfo, false));

        // Faens
        habilidadeRacaRepository.save(new HabilidadeRaca(domDaMagia, faen, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(herancaFeerica, faen, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(invisibilidadeNatural, faen, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(isnuu, faen, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(luzesDasFadas, faen, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(presencaReal, faen, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(voadorEximio, faen, false));

        // Faunos
        habilidadeRacaRepository.save(new HabilidadeRaca(cascosAgeis, fauno, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(flautaDePa, fauno, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(marrada, fauno, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(patasFortes, fauno, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(pinturaCorporal, fauno, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(racaFlorestal, fauno, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosDeCacador, fauno, false));

        //Firas
        habilidadeRacaRepository.save(new HabilidadeRaca(cavaleiroExperiente, fira, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(chamasInternas1, fira, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(chamasInternas2, fira, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(fulgurante, fira, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(menteIluminada, fira, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(soproDeFogo, fira, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(vigorDoDeserto, fira, false));

        //Humanos
        habilidadeRacaRepository.save(new HabilidadeRaca(assuntosDiversos, humano, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(audacia, humano, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(barganha, humano, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(diversidade, humano, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(gregario, humano, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(oDobroOuNada, humano, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sorte, humano, false));

        // Jubans
        habilidadeRacaRepository.save(new HabilidadeRaca(fortaleza, juban, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(garras, juban, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(imparavel, juban, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(mordidaPoderosa, juban, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(robustez, juban, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(rugidodeAhogr, juban, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(sentidosDeCacador, juban, false));

        // Levents
        habilidadeRacaRepository.save(new HabilidadeRaca(asasFortes, levent, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(comunhaoComEspiritos, levent, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(contatoComEspiritos, levent, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(dancarinoDoAr, levent, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(menteIluminada, levent, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(movimentoBrusco, levent, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(olhosDeAguia, levent, false));

        // Mahoks
        habilidadeRacaRepository.save(new HabilidadeRaca(abracoDePedra, mahok, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(bracosExtras1, mahok, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(bracosExtras2, mahok, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(estabilidade, mahok, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(gregario, mahok, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(nascidoNasMontanhas, mahok, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(peleDePedra2, mahok, false));

        // Tailox
        habilidadeRacaRepository.save(new HabilidadeRaca(astuto, tailox, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(audacia, tailox, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(contosDaEstrada, tailox, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(faro, tailox, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(formaDaRaposa, tailox, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(racaFlorestal, tailox, false));
        habilidadeRacaRepository.save(new HabilidadeRaca(visaoAuditiva, tailox, false));

        return "Habilidades de Raça carregadas";
    }
}