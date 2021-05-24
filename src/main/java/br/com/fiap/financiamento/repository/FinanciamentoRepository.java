package br.com.fiap.financiamento.repository;

import br.com.fiap.financiamento.entity.FinanciamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanciamentoRepository extends JpaRepository<FinanciamentoEntity, Long> {
}
