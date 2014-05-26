package com.anuacana.web.beans;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class AnucanaAccessAuthority implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = -551056080457219568L;

	private UserRole role;

	public AnucanaAccessAuthority(UserRole role) {
		this.role = role;
	}
	
	@Override
	public String getAuthority() {
		return role.getRoleCode();
	}

    public boolean equals(Object obj) {
        if (obj instanceof String) {
            return obj.equals(this.role);
        }

        if (obj instanceof GrantedAuthority) {
            GrantedAuthority attr = (GrantedAuthority) obj;

            return this.role.equals(attr.getAuthority());
        }

        return false;
    }


    public int hashCode() {
        return this.role.hashCode();
    }

    public String toString() {
        return this.role.toString();
    }
	
}
