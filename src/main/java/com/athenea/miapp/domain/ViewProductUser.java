package com.athenea.miapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="view_product_user")
public class ViewProductUser {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@GenericGenerator(name = "native",strategy = "native")
	@Column(name = "id")
	private String id;
	
	@Column(name = "product_id")
    private Integer productId;
	
	@Column(name = "type_product")
    private String typeProduct;
	
	@Column(name = "valor")
    private String valor;
	
	@Column(name = "fullname")
    private String fullname;
	
	@Column(name = "username")
    private String username;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
