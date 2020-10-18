package com.athenea.miapp.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="users")
public class UserMaster implements Serializable {

	 private static final long serialVersionUID = 1L;

	 	@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@GenericGenerator(name = "native",strategy = "native")
	 	@Column(name = "user_id")
	    private Integer id;

	    @Column(name = "username")
	    private String login;
	    private String password;
	    private String fullname;
	    @Column(name = "tipoidentificacion")
	    private String tipoidentificacion;
	    
	    @Column(name = "enabled")
	    private Integer enabled = 1;
	   
	    @OneToMany(
	            fetch = FetchType.EAGER, cascade = CascadeType.ALL,
	            mappedBy = "userId"
	    )
	    private List<UserRole> authorities = new ArrayList<UserRole>();
	    
	    @Transient
	    private String token;

		public Integer getId()
	    {
	        return id;
	    }

	    public void setId(Integer id)
	    {
	        this.id = id;
	    } 
    
		public String getLogin() {
			return login;
		}

		public void setLogin(String login){
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) throws NoSuchAlgorithmException {
			this.password = password;
		}
		
	public Integer getEnabled() {
			return enabled;
		}

		public void setEnabled(Integer enabled) {
			this.enabled = enabled;
		}
		
		

	public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

	public List<UserRole> getAuthorities() {
			return authorities;
		}

		public void setAuthorities(List<UserRole> authorities) {
			this.authorities = authorities;
		}
		
		public void addAuthorities(String authority) {
			UserRole role = new UserRole();
	        role.setAuthority(authority);
			authorities.add(role);
			role.setUserId(this);
		}
		
	public String getTipoidentificacion() {
			return tipoidentificacion;
		}

		public void setTipoidentificacion(String tipoidentificacion) {
			this.tipoidentificacion = tipoidentificacion;
		}
		

	public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

	public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Login: " + login);
        return buffer.toString();
    }
	
	
	
	
}
