package com.cebolutions.top.car.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cebolutions.top.car.dto.CarrosVendidosDTO;
import com.cebolutions.top.car.dto.VendaDTO;
import com.cebolutions.top.car.entity.Carro;
import com.cebolutions.top.car.entity.CarroVenda;
import com.cebolutions.top.car.entity.Cor;
import com.cebolutions.top.car.entity.User;
import com.cebolutions.top.car.entity.Venda;
import com.cebolutions.top.car.form.VendaForm;
import com.cebolutions.top.car.repository.CarroRepository;
import com.cebolutions.top.car.repository.CarroVendaRepository;
import com.cebolutions.top.car.repository.CorRepository;
import com.cebolutions.top.car.repository.EnderecoRepository;
import com.cebolutions.top.car.repository.UserRepository;
import com.cebolutions.top.car.repository.VendaRepository;
import com.cebolutions.top.car.service.VendaService;

@RestController
@RequestMapping(value="/venda")
public class VendaController {
	
	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private CarroVendaRepository carroVendaRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CorRepository corRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private VendaService service;
	
	public static final String MIN_QUANTITY = "carro.min.quantity";
	
	@Transactional(readOnly = true)
	@RequestMapping(method = GET)
	public List<VendaDTO> list(){
		List<Venda> vendas = (List<Venda>) repository.findAll();
		
		return vendas.stream()
				.map(VendaDTO::new)
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value="/{id}",method = GET)
	public VendaDTO findById(@PathVariable ("id") Long id){
		Venda venda = repository.findOne(id);
		
		return new VendaDTO(venda);
	}
	
	@Transactional
	@RequestMapping(method=POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public VendaDTO create(@RequestBody VendaForm form){
		
		Venda venda = new Venda();
		User user = userRepository.findOne(form.getUsuarioId());
		CarroVenda carroPersonalizado = carroVendaRepository.findOne(form.getCarroId());
		Carro carro = carroRepository.findOne(carroPersonalizado.getCarro().getId());
		Cor cor = corRepository.findOne(carroPersonalizado.getCor().getId());
		
		
		venda.setDate(LocalDate.now());
		venda.setDataVenda(LocalDateTime.now());
		venda.setCarro(carroPersonalizado);
		venda.setUsuario(user);
		venda.setEnderecoEntrega(enderecoRepository.findOne(form.getEnderecoEntregaId()));
		venda.setValorTotal(form.getValorTotal());
		venda.setVendaCompleta(form.getVendaCompleta());
		//venda.setValorTotal(service.valorVendaTotal(carroPersonalizado.getId(), cor.getId()));
		
		
		/*if(user.getAprovado()){
			if(carro.getQuantidade() > 2){
				carro.setQuantidade(carro.getQuantidade() - 1);
				venda.setVendaCompleta(true);
				venda = repository.save(venda);
			}
		} if(!user.getAprovado()) {
			venda.setVendaCompleta(false);
			venda = repository.save(venda);
		} else {
			repository.delete(venda.getId());
			carroVendaRepository.delete(venda.getCarro().getId());
		}*/
		venda = repository.save(venda);
		return new VendaDTO(venda);
	}
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public VendaDTO update(@PathVariable("id") Long id){
		Venda venda = repository.findOne(id);
		User user = userRepository.findOne(venda.getUsuario().getId());
		Carro carro = carroRepository.findOne(venda.getCarro().getCarro().getId());
		
		if(user.getAprovado()){
			venda.setVendaCompleta(true);
			venda = repository.save(venda);
		} if(!user.getAprovado()) {
			venda.setVendaCompleta(false);
			carro.setQuantidade(carro.getQuantidade() + 1);
			venda = repository.save(venda);
		} else {
			carro.setQuantidade(carro.getQuantidade() + 1);
			repository.delete(venda.getId());
			carroVendaRepository.delete(venda.getCarro().getId());
		}
		
		return new VendaDTO(venda);
	}
	
/*	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@Transactional
	public List<Venda> delete(@PathVariable("id") Long id) {
		List<Venda> findAll = new ArrayList<Venda>();
		repository.delete(id);
		findAll = (List<Venda>) repository.findAll();

		return findAll;
	}*/
	
//	@RequestMapping(value="/{month}", method=GET)
//	@Transactional(readOnly = true)
//	public Integer listByMonth(@PathVariable("month") Integer month){
//		
//		List<Venda> vendas = (List<Venda>) repository.findAll();
//		List<Venda> vendasPorMes = new ArrayList<>();
//		
//		for (Venda venda : vendas) {
//			if (venda.getVendaCompleta() && venda.getDate().getMonthOfYear() == month){
//				vendasPorMes.add(venda);
//			}
//		}
//		
//		return vendasPorMes.size();
//	}
	
	@Transactional(readOnly=true)
	@RequestMapping(value="/carrosVendidos", method=GET)
	public List<CarrosVendidosDTO> listByCarrosVendidos (){
		
		List<Carro> carros = (List<Carro>)carroRepository.findAll();
		
		Map<Carro, Integer> carrosVendidos = new LinkedHashMap<Carro, Integer>();
		carros.forEach(i -> carrosVendidos.put(i, 0));
		
		List<Venda> vendas = (List<Venda>) repository.findAll();
		
		for (Venda v : vendas) {
			Carro carro = v.getCarro().getCarro();
			Integer totalvendas = carrosVendidos.get(carro);
			//List<Venda> vendasPorCarro = (List<Venda>) repository.findByCarro(carro);
			//totalvendas = vendasPorCarro.size();
			if(v.getVendaCompleta()){
				totalvendas += 1;
			}
			carrosVendidos.put(carro, totalvendas);
		}
		
		List<CarrosVendidosDTO> dtos = new ArrayList<CarrosVendidosDTO>(); 
		for (Carro c : carrosVendidos.keySet()) {
			CarrosVendidosDTO dto = new CarrosVendidosDTO();
			dto.setId(c.getId());
			dto.setModelo(c.getModelo());
			dto.setNumeroVendas(carrosVendidos.get(c));
			dtos.add(dto);
		}
		
		dtos.sort(ComparatorPorId);
		
		return dtos;
		
		//carroVendaRepository.findByCarro(carro);
	/*	
		List<Venda> vendasPorCarro = (List<Venda>) repository.findByCarro(carro);
		List<Venda> vendas = new ArrayList<Venda>();
		
		if(vendasPorCarro.size() != 0){
			for (Venda venda : vendasPorCarro) {
				if (venda.getVendaCompleta()) {
					vendas.add(venda);
				}
			}
		}
		

		return vendas.size();*/
	}

	public static Comparator<CarrosVendidosDTO> ComparatorPorId= new Comparator<CarrosVendidosDTO>() {
		public int compare(CarrosVendidosDTO car, CarrosVendidosDTO car2) {
			return car.getId().compareTo(car2.getId());
		}
	};
	
}
