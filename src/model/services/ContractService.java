package model.services;

import java.util.Calendar;

import model.entities.Contract;
import model.entities.Installments;

public class ContractService {
	private OnlinePaymentService paymentService; 
	
	
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}


	public void processContract(Contract contract, int months) {
		double monthValue = contract.getTotalValue() / months;
		double quota, total;
		Calendar cal = Calendar.getInstance();
		
		for(int i=1; i<=months; i++) {
			quota = paymentService.interest(monthValue, i);
			total = monthValue + quota;
			quota = paymentService.paymentFee(total);
			total += quota;
			
			cal.setTime(contract.getDate());
			cal.add(Calendar.MONTH, i);
			
			contract.addInstallment(new Installments(cal.getTime(), total));
		}
		
	}
}
