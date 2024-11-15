package com.example.empresas.service;

import com.example.empresas.domain.Empresa;
import com.example.empresas.exception.EmpresaNotFoundException;
import org.springframework.stereotype.Service;
import com.example.empresas.repository.EmpresaRepository;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> all() {
        return this.empresaRepository.findAll();
    }

    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    public Empresa one(Long id) {
        return this.empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundException(id));
    }

    public Empresa replace(Long id, Empresa empresa) {

        return this.empresaRepository.findById(id).map( p -> (id.equals(empresa.getId())  ?
                        this.empresaRepository.save(empresa) : null))
                .orElseThrow(() -> new EmpresaNotFoundException(id));
    }

    public void delete(Long id) {
        this.empresaRepository.findById(id).map(p -> {this.empresaRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new EmpresaNotFoundException(id));
    }

}
