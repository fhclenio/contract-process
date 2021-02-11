package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installments {
	private Date date;
	private Double amount;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Installments() {
		
	}

	public Installments(Date date, Double amount) {
		this.date = date;
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}
	public String toString() {
		return sdf.format(date) + " - " + String.format("%.2f", amount);
	}
}
