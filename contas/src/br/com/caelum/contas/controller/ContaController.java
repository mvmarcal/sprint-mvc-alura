package br.com.caelum.contas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	ContaDAO dao;
	
	@Autowired
	public ContaController(ContaDAO dao){
		this.dao = dao;
	}

	@RequestMapping("/form")
	public String form(){
		return "conta/formulario";
	}
	@RequestMapping("/adicionaConta")
	public String adicionaConta(@Valid Conta conta, BindingResult result){
		if(result.hasFieldErrors("descricao"))return "conta/formulario";
		dao.adiciona(conta);
		return "conta/add-conta-sucesso";
	}
	
	@RequestMapping("/pagaConta")
	public void pagaConta(Conta conta, HttpServletResponse resp){
		dao.paga(conta.getId());
		resp.setStatus(200);
	}
	
	@RequestMapping("/deletaConta")
	public String deletaConta(Conta conta){
		dao.remove(conta);
		return "redirect:listaContas";
	}
	
	@RequestMapping("/mostraConta")
	public String mostraConta(Conta conta,Model model){
		model.addAttribute(dao.buscaPorId(conta.getId()));
		return "conta/mostra";
	}
	@RequestMapping("/alteraConta")
	public String alteraConta(Conta conta){
		dao.altera(conta);
		return "redirect:listaContas";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView listaContas(){
		
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas",dao.lista());
		
		return mv;
		
	}
}
