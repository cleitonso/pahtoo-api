package br.com.pahtoo.service;

import java.util.List;

import br.com.pahtoo.entity.Voo;

public interface VooService {
	
	public List<Voo> listarTodos();
	
	public Voo buscarPorId(Voo voo);
	
	public Voo salvar(Voo voo);
	
	public Voo excluir(Voo voo);
	
	public Voo cancelar(Voo voo);
}
