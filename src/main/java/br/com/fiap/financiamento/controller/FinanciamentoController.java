package br.com.fiap.financiamento.controller;

import javax.validation.Valid;

import br.com.fiap.financiamento.dto.FinanciamentoDto;
import br.com.fiap.financiamento.entity.FinanciamentoEntity;
import br.com.fiap.financiamento.service.FinanciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/financiamento")
public class FinanciamentoController {

    @Autowired
    private FinanciamentoService service;

    @PostMapping("/salvar")
    public String salvarFinanciamento(@Valid FinanciamentoDto financiamentoDto, BindingResult result) {
        if (!result.hasErrors()) {
            service.salvarFinanciamento(financiamentoDto);
            return "redirect:/financiamento/listar";
        }
        return "redirect:/erro";
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionarFinanciamento() {
        ModelAndView view = new ModelAndView("adicionar");
        view.addObject("financiamento", new FinanciamentoEntity());
        return view;
    }


    @GetMapping("/listar")
    public ModelAndView listar() {

        ModelAndView view = new ModelAndView("index");

        List<FinanciamentoDto> financiamentos = service.listaFinanciamentos();

        view.addObject("financiamento", new FinanciamentoEntity());

        view.addObject("financiamentos", financiamentos);

        return view;
    }

    @GetMapping("/get/{id}")
    public ModelAndView editar(@PathVariable Long id) {

        FinanciamentoDto financiamento = service.editarFinanciamento(id);

        ModelAndView view = new ModelAndView("adicionar");

        view.addObject("financiamento", new FinanciamentoEntity());

        view.addObject("financiamento", financiamento);

        return view;
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        service.excluirFinanciamento(id);

        return "redirect:/financiamento/listar";
    }

    @GetMapping("/erro")
    public ModelAndView error() {
        ModelAndView view = new ModelAndView("error");
        return view;
    }
}
