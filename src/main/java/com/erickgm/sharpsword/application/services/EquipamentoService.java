package com.erickgm.sharpsword.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickgm.sharpsword.application.dto.request.EquipamentoDtoRequest;
import com.erickgm.sharpsword.application.dto.response.EquipamentoDtoResponse;
import com.erickgm.sharpsword.application.mappers.EquipamentoMapper;
import com.erickgm.sharpsword.domain.entities.Equipamento;
import com.erickgm.sharpsword.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository equipamentoRepository;

	public String cargaInicial() {
		List<Equipamento> itens = new ArrayList<Equipamento>();

		if (equipamentoRepository.count() == 0) {
			itens.add(new Equipamento(null, "Alforge", 50, 1.0, "Mochila acoplada na parte de traz na sela da montaria. Comporta até 40 quilos de equipamento"));
			itens.add(new Equipamento(null, "Aljava Comum", 10, 1.5, "Utensilio usado normalmente nas costas para carregar flechas. Comporta até 20 flechas (compradas separadamente)."));
			itens.add(new Equipamento(null, "Anzol e Linha", 1, 0, "Para pescar"));
			itens.add(new Equipamento(null, "Armadura para animais (Couro)", 300, 35.0, "Concede  +1 de defesa ao animal"));
			itens.add(new Equipamento(null, "Armadura para animais (Simples)", 600, 50, "Concede  +2 de defesa ao animal"));
			itens.add(new Equipamento(null, "Armadura para animais (Batalha)", 1200, 75, "Concede  +3 de defesa ao animal"));
			itens.add(new Equipamento(null, "Armadura para animais (Completa)", 1800, 100, "Concede  +4 de defesa ao animal"));
			itens.add(new Equipamento(null, "Barril", 10, 20, "Barril de madeira para liquidos. Comporta 50 litros de liquido."));
			itens.add(new Equipamento(null, "Barrilete", 5, 6, "Barril de madeira para liquidos. Comporta 10 litros de líquido."));
			itens.add(new Equipamento(null, "Baú Pequeno", 30, 20, "Baú de madeira reforçado. Com alça para cadeado. 50 cm da largura, 25 cm de profundidade e 25 cm de altura."));
			itens.add(new Equipamento(null, "Baú Grande", 50, 60, "Baú de madeira reforçado. Com alça para cadeado. 1 m da largura, 50 cm de profundidade e 50 cm de altura.")); 
			itens.add(new Equipamento(null, "Caixa Pequena", 2, 8, "Caixa quadrada de madeira com 50 cm de lado.")); 
			itens.add(new Equipamento(null, "Caixa Grande", 10, 45, "Caixa retangular de madeira com 1m de largura e altura, e 2m de comprimento.")); 
			itens.add(new Equipamento(null, "Cantil", 5, 0.5, "Recipiente para carregar líquidos feito com couro e armação de madeira e/ou metal. Mais fácil de carregar do que o odre. Cheio de líquido pesa 1kg a mais.")); 
			itens.add(new Equipamento(null, "Capa de lã", 3, 1, "Para proteger do frio.")); 
			itens.add(new Equipamento(null, "Capa de pele", 10, 3, "Para climas muito frios.")); 
			itens.add(new Equipamento(null, "Chapéu", 3, 0.5, "de palha, couro ou lona.")); 
			itens.add(new Equipamento(null, "Cinto oculto", 1, 0.15, "Cinto para adaga pode ser colocado na coxa ou no braço ")); 
			itens.add(new Equipamento(null, "Cinturão de Adagas", 3, 0.25, "Cinto para o peito com espaço para 10 adagas")); 
			itens.add(new Equipamento(null, "Cinto de Ferramentas", 3, 0.4, "Cinto com pequenos bolsos para guardar ferramentas e utensílios.")); 
			itens.add(new Equipamento(null, "Corda Grossa (15m)", 6, 3, "Corda reforçada aguenta 500 kg")); 
			itens.add(new Equipamento(null, "Kit de Arrombamento", 100, 0.4, "Bainha com varias gazuas. Necessário para arrombar fechaduras.")); 
			itens.add(new Equipamento(null, "Kit de Cura", 50, 2, "Bandagens, agulha, linha, faca e pastas de ervas medicinais.")); 
			itens.add(new Equipamento(null, "Mochila Pequena/embornal", 20, 1, "Mochila básica para guardar o essencial. Comporta até 5Kg.")); 
			itens.add(new Equipamento(null, "Mochila Grande", 50, 2, "Mochila reforçada de viagem. Comporta até 20 quilos.")); 
			itens.add(new Equipamento(null, "Frasco de Cerâmica", 2, 0, "Frasco de cerâmica para poções. Comporta 100 ml de líquido.")); 
			itens.add(new Equipamento(null, "Frasco de Tinta", 15, 0, "Suficiente pra dez páginas de texto")); 
			itens.add(new Equipamento(null, "Frasco de Vidro", 4, 0, "Frasco de vidro para poções. Comporta 50 ml de líquido")); 
			itens.add(new Equipamento(null, "Freio, Rédeas e Bocal", 20, 0.45, "Consiste no equipamento que vai na cabeça do animal. O personagem recebe -2 nos testes de cavalgar se não possuir esse equipamento.")); 
			itens.add(new Equipamento(null, "Garatéia Furtiva", 20, 1, "Garatéia forrada com tecido grosso para diminuir o barulho.")); 
			itens.add(new Equipamento(null, "Garrafa de Cerâmica", 5, 0.5, "Garrafa para vinho e cerveja. Comporta 1 litro de líquido.")); 
			itens.add(new Equipamento(null, "Lampião", 20, 0.5, "Este lampião funciona a óleo. Dura 6 horas.")); 
			itens.add(new Equipamento(null, "Luvas", 1, 0, "De lã ou pelica, para proteger do frio.")); 
			itens.add(new Equipamento(null, "Luvas de Couro", 3, 0.5, "Para trabalho pesado ou climas muito frios. ")); 
			itens.add(new Equipamento(null, "Manto", 5, 1, "Capa de lã ou lona com capuz, para proteger do frio.")); 
			itens.add(new Equipamento(null, "Mata Borrão", 5, 0, "Usado para limpar o excesso de tinta ajudando na secagem. Peso desprezível.")); 
			itens.add(new Equipamento(null, "Odre", 2, 0.5, "Cantil que consiste basicamente de um saco de couro com um bocal de madeira e rolha. Cheio de líquido pesa 4kg a mais.")); 
			itens.add(new Equipamento(null, "Óleo combustível", 10, 0.5, "Serve para recarregar lampiões. Se exposto ao fogo, explode (dano igual à 10/fogo em uma área de 2 metros de raio)")); 
			itens.add(new Equipamento(null, "Pá de Acampamento", 5, 1, "Pá pequena para ajudar na montagem do acampamento")); 
			itens.add(new Equipamento(null, "Papiro", 1, 0, "Uma folha. Papel de baixa qualidade feito a partir de uma pasta de junco seco. 100 dessas pesam 1kg")); 
			itens.add(new Equipamento(null, "Pederneira e isqueiro", 5, 0.25, "Uma pedra especial que quando riscada por um metal (isqueiro) gera uma grande quantidade de faíscas. Usada para ascender uma fogueira.")); 
			itens.add(new Equipamento(null, "Pelego", 10, 4, "Couro com lã de ovelha para dormir em cima. Bom para noites frias.")); 
			itens.add(new Equipamento(null, "Pena", 2, 0, "Pena usada para escrever")); 
			itens.add(new Equipamento(null, "Pergaminho", 5, 0, "Uma folha. Pele de cordeiro preparada para receber tinta. E desse material que os grimórios são feitos. 20 dessas pesam 1kg.")); 
			itens.add(new Equipamento(null, "Provisões", 10, 1, "Suficiente para 2 refeições.")); 
			itens.add(new Equipamento(null, "Roupas comuns", 5, 1, "Camisa ou túnica, calções ou saia e sandálias.")); 
			itens.add(new Equipamento(null, "Roupas de festa", 10, 2, "Vestido ou roupas decoradas ou de cores vibrantes.")); 
			itens.add(new Equipamento(null, "Roupas de viagem", 20, 3, "Camisa e calças de lona e botas.")); 
			itens.add(new Equipamento(null, "Sela e estribos", 80, 1, "Confere um bônus de +2 em todos os testes de Cavalgar.")); 
			itens.add(new Equipamento(null, "Tenda Pequena (1 Pessoa)", 35, 3, "Tenda simples para uma pessoa, 1m de altura por 2m de comprimentos e 1m de largura.")); 
			itens.add(new Equipamento(null, "Tenda Média (2 Pessoas)", 50, 6, "Tenda simples para duas pessoas, 1m de altura por 2m de comprimentos e 2m de largura."));					 
			itens.add(new Equipamento(null, "Tenda Grande (4 Pessoas)", 85, 13, "Tenda simples para quatro pessoas, 1,8m de altura por 4m de comprimento e 4m de largura. Essa tenda é muito grande para ser carregada por apenas uma pessoa, ela deve ser posta em uma carroça ou, ao menos, em um cavalo.")); 
			itens.add(new Equipamento(null, "Tenda Grupo (10 Pessoas)", 150, 27, "Lembra um pequeno circo em forma de octógono, possui oito mastros a sua volta e um mastro central maior. Só pode ser transportado em uma carroça. Tem 2,5m de altura por 4m de raio.")); 
			itens.add(new Equipamento(null, "Tocha", 1, 0.5, "Dura uma hora")); 
			itens.add(new Equipamento(null, "Túnica", 3, 1, "Camisa longa que fica sobre as calças.")); 
			itens.add(new Equipamento(null, "Velino", 10, 0.02, "Uma folha. Pele de feto de boi ou cordeiro, preparada para receber tinta. Mais lisa e macia do que pergaminho comum, depois de seca a tinta resiste mesmo que a folha seja molhada. Grimórios a prova d’água podem ser feitos desse material.")); 

			// KIT ESCALADA
			
			//itens.add(new Equipamento(null, "Corda simples (15m)#", 3, 2, "Suporta 200 kg "));
			//itens.add(new Equipamento(null, "Martelete#", 24, 1, "Pequeno martelo usado para fixar os pinos de escalada, a cabeça do martelo é dividida em uma ponta de martelo e outra de picareta.")); 
			//itens.add(new Equipamento(null, "Garatéia#", 12, 1, "Gancho para escalar muros e paredes com 3 anzóis  grandes juntos."));
			//itens.add(new Equipamento(null, "Pinos Para escalada#", 10, 0.4, "10 pinos para escaladas.")); 
			
 			for (Equipamento item : itens) {
				equipamentoRepository.save(item);
			}

			return "Equipamentos carregados";
		}
		return "Não foi possível carregar Equipamentos";
	}
	
	public List<EquipamentoDtoResponse> listarEquipamentos() {
		List<Equipamento> equipamentos =equipamentoRepository.findAll();
		return EquipamentoMapper.mapToListDtoResponse(equipamentos);
	}

	public EquipamentoDtoResponse obterEquipamentoPeloId(long id) {
		Equipamento equipamento = equipamentoRepository.findById(id);
		return EquipamentoMapper.mapToDtoResponse(equipamento);
	}

	public EquipamentoDtoResponse incluirEquipamento(EquipamentoDtoRequest dto) {
		if (dto == null) {
			return null;
		}

		Equipamento equipamento = equipamentoRepository.findByNome(dto.getNome());
		if (equipamento != null) {
			return EquipamentoMapper.mapToDtoResponse(equipamento);
		}

		equipamento = new Equipamento(null, dto.getNome(), dto.getCusto(), dto.getPeso(), dto.getDescricao());
		equipamento = equipamentoRepository.save(equipamento);

		return EquipamentoMapper.mapToDtoResponse(equipamento);
	}

	public EquipamentoDtoResponse alterarEquipamento(long id, EquipamentoDtoRequest dto) {
		Equipamento equipamento = equipamentoRepository.findById(id);
		
		equipamento.modificaValores(dto.getNome(), dto.getCusto(), dto.getPeso(), dto.getDescricao());		
		
		equipamentoRepository.save(equipamento);
		
		return EquipamentoMapper.mapToDtoResponse(equipamento);
	}

	public boolean excluirEquipamento(long id) {
		Equipamento equipamento = equipamentoRepository.findById(id);

		if (equipamento == null) {
			return false;
		}

		equipamentoRepository.delete(equipamento);

		return true;
	}

}