package br.com.feltex.funcionario.graphql;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class FuncionarioService {

    private final Map<String, Funcionario> funcionarios = new HashMap<>();

    public Funcionario criar(String nome, Departamento departamento) {
        var funcionario = new Funcionario(UUID.randomUUID().toString(), nome, departamento);
        funcionarios.put(funcionario.id(), funcionario);
        return funcionario;
    }

    public List<Funcionario> listar() {
        System.out.println(funcionarios.values().stream().toList());
        return funcionarios.values().stream().toList();
    }

    @PostConstruct
    private void startUp(){
        var funcioario1 = new Funcionario(UUID.randomUUID().toString(), "joao", Departamento.DIRETORIA);
        var funcioario2 = new Funcionario(UUID.randomUUID().toString(), "jose", Departamento.RH);
        var funcioario3 = new Funcionario(UUID.randomUUID().toString(), "ana", Departamento.TI);
        var funcioario4 = new Funcionario(UUID.randomUUID().toString(), "maria", Departamento.FINANCEIRO);
        funcionarios.put(funcioario1.id(), funcioario1);
        funcionarios.put(funcioario2.id(), funcioario2);
        funcionarios.put(funcioario3.id(), funcioario3);
        funcionarios.put(funcioario4.id(), funcioario4);
        log.info("Ja chamou aqui");
    }

    public Optional<Funcionario> buscarPorId(String id) {
        log.info("Buscando funcionario por id={}", id);
        return Optional.ofNullable(funcionarios.get(id));
    }

    public Funcionario deletar(String id){
        var funcionarioEncontrado = buscarPorId(id).orElseThrow(()-> new IllegalArgumentException("Funcionário não encontrado"));
        funcionarios.remove(id);
        return funcionarioEncontrado;
    }

    public Funcionario atualizar(final String id, final String nome, final Departamento departamento){
        log.info("Atualizanndo funcionário id={}",id);
        if(funcionarios.containsKey(id)){
            funcionarios.put(id, new Funcionario(id, nome, departamento));
            return funcionarios.get(id);
        }
        throw  new IllegalArgumentException("Funcionario não encontrado");
    }
}
