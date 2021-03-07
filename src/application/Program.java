package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Departamento;
import entidades.Funcionario;
import entidades.enums.Nivel;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner(System.in);
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateformat_mesano = new SimpleDateFormat("MM/yyyy");
		String data;
		
		System.out.printf("Entre com o nome do departamento: ");
		String nomeDepartamento = leia.nextLine();
		System.out.println("Entre com os dados do funcionario:");
		System.out.print("Nome: ");
		String nome = leia.nextLine();
		System.out.print("Nivel: ");
		String nivel = leia.nextLine();
		System.out.print("Salario: ");
		Double salario = leia.nextDouble();
		
		Funcionario funcionario = new Funcionario(nome,Nivel.valueOf(nivel),salario, new Departamento(nomeDepartamento));
		
		System.out.printf("Quantos contratos tem esse funcionario: ");
		double numeroContratos = leia.nextDouble();
		
		for (int i=0;i < numeroContratos;i++) {
			System.out.println("Entre com os dados do contrato #" + (i+1));
			System.out.print("Data (DD/MM/YYYY): ");
			leia.nextLine();
			data = leia.nextLine();
			System.out.print("Valor por hora: ");
			Double valorPorHora = leia.nextDouble();
			System.out.print("Duração (horas): ");
			Integer horasContrato = leia.nextInt();
			Date dataContrato;
			try {
				dataContrato = dateformat.parse(data);
				funcionario.addContrato(new Contrato(dataContrato,valorPorHora,horasContrato));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println();
		System.out.print("Entre com o mes e o ano que quer calcular o rendimento (MM/YYYY): ");
		leia.nextLine();
		data = leia.nextLine();
		try {
			Date dataRendimento = dateformat_mesano.parse(data);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dataRendimento);
			Double rendimento = funcionario.rendimento(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH));
			System.out.printf("Nome: %s%n",funcionario.getNome());
			System.out.printf("Departamento: %s%n",funcionario.getDepartamento().getNome());
			System.out.printf("Rendimento para %s: %.2f ",data,rendimento);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
