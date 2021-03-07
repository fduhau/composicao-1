package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.Nivel;

public class Funcionario {
	
	private String nome;
	private Nivel nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<Contrato> contratos = new ArrayList<>();
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, Nivel nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void addContrato(Contrato contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(Contrato contrato) {
		contratos.remove(contrato);
	}
	
	public Double rendimento(Integer ano, Integer mes) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (Contrato c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				sum += c.valorTotal();
			}
		}
		return sum;
	}
	
	
	
}
