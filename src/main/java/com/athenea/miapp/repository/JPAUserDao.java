package com.athenea.miapp.repository;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.athenea.miapp.domain.Role;
import com.athenea.miapp.domain.UserMaster;
import com.athenea.miapp.domain.UserRole;
import com.athenea.miapp.domain.dto.UserMasterDTO;
import com.athenea.miapp.utils.MD5Converter;

@Repository(value = "userDao")
public class JPAUserDao implements UserDao {

    private EntityManager em = null;
    
    private List<UserRole> listRoles;
    private static final String TOKENPARAM ="TokenCliente";

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @SuppressWarnings("unchecked")
    public List<UserMaster> getUserList() {
        return em.createQuery("select u from UserMaster u order by u.id").getResultList();
    }

    @Transactional
    public void saveUser(UserMaster prod) {
        em.merge(prod);
    }

	@Override
	public User verifyLogin(String login) {
		 List<UserMaster> listUser = em.createQuery("SELECT u FROM UserMaster u where u.login = :login")
                .setParameter("login", login).getResultList();
		 if (!listUser.isEmpty()) {
			 listRoles = listUser.get(0).getAuthorities();
			 return new User(listUser.get(0).getLogin(), listUser.get(0).getPassword(), getAuthorities());
		 }
		return null;
	}
	
	public List<Role> getRoles(){
		List<Role> roles = new ArrayList<Role>();
		for(Role role : Role.values()) {
    		roles.add(role);
    	}
		return roles;
	}
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
    	
    	for(UserRole userrole : listRoles) {
    		list.add(new SimpleGrantedAuthority(userrole.getAuthority()));
    	}

        return list;
    }
    
    @Override
	public UserMaster verifyLogin(UserMasterDTO user) throws NoSuchAlgorithmException {
		 List<UserMaster> listUser = em.createQuery("SELECT u FROM UserMaster u where u.login = :login AND u.password= :password AND u.tipoidentificacion = :tipo")
                .setParameter("login", user.getIdentificacion()).setParameter("password", user.getPassword())
                .setParameter("tipo", user.getTipoidentificacion()).getResultList();
		 if (!listUser.isEmpty()) {
			String token = MD5Converter.ENCODEMD5(TOKENPARAM);
			listUser.get(0).setToken(token);
			 return listUser.get(0);
		 }
		return null;
	}
    
    

	

}
