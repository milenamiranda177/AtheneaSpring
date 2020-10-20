package com.athenea.miapp.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "type_product")
	private String typeProduct;
	
	@Column(name = "user_id")
    private Integer userIdProduct;
	
	@Column(name = "valor")
    private String valor;
	
	private Integer enabled = 1;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	

	public Integer getUserIdProduct() {
		return userIdProduct;
	}

	public void setUserIdProduct(Integer userIdProduct) {
		this.userIdProduct = userIdProduct;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("valor: " + valor);
        return buffer.toString();
    }
	
	
	
	
	
	
}
