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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="user_roles")
public class UserRole implements Serializable {

	 private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		@GenericGenerator(name = "native",strategy = "native")
		@Column(name = "user_role_id")
	    private Integer id;
		
		@Column(name = "authority")
		private String authority;
		
	    
	    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id")
	    private UserMaster userId;
	    
	    private String permission;

		public Integer getId()
	    {
	        return id;
	    }

	    public void setId(Integer id)
	    {
	        this.id = id;
	    } 	    

		public UserMaster getUserId() {
			userId = null;
			return userId;
		}

		public void setUserId(UserMaster userId) {
			this.userId = userId;
		}
		
		public String getAuthority() {
	        return authority;
		}
	
		public void setAuthority(String authority) {
		        this.authority = authority;
		}

		public String getPermission() {
			return permission;
		}

		public void setPermission(String permission) {
			this.permission = permission;
		}
		
		



}
