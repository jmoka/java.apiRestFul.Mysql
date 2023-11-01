package com.jotaempresas.curso_springBoot.entites.pk;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.annotations.JoinColumnOrFormula;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jotaempresas.curso_springBoot.entites.Order;
import com.jotaempresas.curso_springBoot.entites.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// classe auxiliar , para ser uma chave primaria composta

@Embeddable
public class OrderItemPK implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	// nessa classe auxiliar , não cria os construtores
	
	
	@ManyToOne
	@JoinColumn(name = "order_id" )
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
		
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	// para comparação deve se comparar tanto o pedido quanto o item ( HashCode e equals)
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	


	
	
	
	

}
