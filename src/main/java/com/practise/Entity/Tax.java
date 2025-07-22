package com.practise.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tax_details")
public class Tax {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double gstPercentage;
	
	private double cessPercentage;
	
	private String taxCode;
	
	@OneToOne(mappedBy = "tax")
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(double gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public double getCessPercentage() {
		return cessPercentage;
	}

	public void setCessPercentage(double cessPercentage) {
		this.cessPercentage = cessPercentage;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Tax [id=" + id + ", gstPercentage=" + gstPercentage + ", cessPercentage=" + cessPercentage
				+ ", taxCode=" + taxCode + ", product=" + product + "]";
	}
	
	
}
