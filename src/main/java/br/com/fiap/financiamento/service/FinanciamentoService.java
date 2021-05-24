package br.com.fiap.financiamento.service;

import br.com.fiap.financiamento.dto.FinanciamentoDto;
import br.com.fiap.financiamento.entity.FinanciamentoEntity;
import br.com.fiap.financiamento.repository.FinanciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FinanciamentoService {

    @Autowired
    private FinanciamentoRepository repository;

    public FinanciamentoDto salvarFinanciamento(FinanciamentoDto financiamentoDto) {
        FinanciamentoEntity entity = financiamentoDto.toEntity();
        entity = repository.save(entity);
        FinanciamentoDto dto = financiamentoEntityToDto(entity);
        return dto;
    }

    public List<FinanciamentoDto> listaFinanciamentos() {

        List<FinanciamentoEntity> financiamentoEntities = repository.findAll();

        List<FinanciamentoDto> financiamentoDtos = financiamentoDtoToEntity(financiamentoEntities);

        return financiamentoDtos;
    }

    public FinanciamentoDto editarFinanciamento(Long id) {
        FinanciamentoDto convidadoDto = null;

        Optional<FinanciamentoEntity> opt = repository.findById(id);

        if (opt.isPresent()) {
            FinanciamentoEntity entity = opt.get();
            convidadoDto = financiamentoEntityToDto(entity);
        }

        return convidadoDto;
    }

    public void excluirFinanciamento(Long id) {
        repository.deleteById(id);
    }


    private FinanciamentoDto financiamentoEntityToDto(FinanciamentoEntity entity) {

        FinanciamentoDto dto = new FinanciamentoDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setLogradouro(entity.getLogradouro());
        dto.setNumero(entity.getNumero());
        dto.setCidade(entity.getCidade());
        dto.setEstado(entity.getEstado());
        dto.setCep(entity.getCep());
        dto.setTelefoneResidencial(entity.getTelefoneResidencial());
        dto.setTelefoneCelular(entity.getTelefoneCelular());
        dto.setEmail(entity.getEmail());
        dto.setCpf(entity.getCpf());
        dto.setRg(entity.getRg());
        dto.setDtNasc(entity.getDtNasc());
        dto.setCategoria(entity.getCategoria());
        dto.setValor(entity.getValor());
        dto.setSalario(entity.getSalario());
        dto.setParcelas(entity.getParcelas());

        return dto;
    }

    private List<FinanciamentoDto> financiamentoDtoToEntity(List<FinanciamentoEntity> listaEntity) {
        List<FinanciamentoDto> financiamentoDtos = new ArrayList<>();

        for (FinanciamentoEntity entity : listaEntity) {
            FinanciamentoDto dto = new FinanciamentoDto();
            dto.setId(entity.getId());
            dto.setNome(entity.getNome());
            dto.setLogradouro(entity.getLogradouro());
            dto.setNumero(entity.getNumero());
            dto.setCidade(entity.getCidade());
            dto.setEstado(entity.getEstado());
            dto.setCep(entity.getCep());
            dto.setTelefoneResidencial(entity.getTelefoneResidencial());
            dto.setTelefoneCelular(entity.getTelefoneCelular());
            dto.setEmail(entity.getEmail());
            dto.setCpf(entity.getCpf());
            dto.setRg(entity.getRg());
            dto.setDtNasc(entity.getDtNasc());
            dto.setCategoria(entity.getCategoria());
            dto.setValor(entity.getValor());
            dto.setSalario(entity.getSalario());
            dto.setParcelas(entity.getParcelas());

            financiamentoDtos.add(dto);
        }
        return financiamentoDtos;
    }
}
