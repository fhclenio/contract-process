package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installments;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do contrato");
		System.out.print("numero contrato: ");
		int number = sc.nextInt();
		System.out.print("data contrato: ");
		String strDate = sc.next();
		Date date = sdf.parse(strDate);
		System.out.print("valor total contrato: ");
		double value = sc.nextDouble();
		
		Contract contract = new Contract(number, date, value);
		
		System.out.print("meses parcelamento: ");
		int parcelas = sc.nextInt();
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, parcelas);
		
		System.out.println("Parcelas:");
		for(Installments i : contract.getInstallments()) {
			System.out.println(i.toString());
		}
		
		
		sc.close();
	}

}
