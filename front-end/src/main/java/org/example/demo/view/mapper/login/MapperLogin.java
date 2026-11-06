package org.example.demo.view.mapper.login;

import org.example.demo.view.core.contract.Role;

public class MapperLogin {

    public static Role getRole(String role) {
        if("AMMINISTRATORE".equals(role))
            return Role.AMMINISTRATORE;
        else if("NORMALE".equals(role))
            return Role.NORMALE;
        return null;
    }
}
