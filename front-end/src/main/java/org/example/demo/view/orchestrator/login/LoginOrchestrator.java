package org.example.demo.view.orchestrator.login;

import org.example.demo.view.access.definitions.LoginView;
import org.example.demo.view.assembler.login.AssembleLogin;
import org.example.demo.view.core.Session;
import org.example.demo.view.core.contract.Role;
import org.example.demo.view.core.orchestration.login.LoginOrchestration;
import org.example.demo.view.dto.login.LoginRequestDTO;
import org.example.demo.view.dto.login.LoginResponseDTO;
import org.example.demo.view.mapper.login.MapperLogin;
import org.example.demo.view.service.login.Authentication;

import java.io.IOException;

public class LoginOrchestrator implements LoginOrchestration {
    private final Authentication auth =
            new Authentication();
    private Runnable logout;

    public void setPageLogin(Runnable logout) {
        this.logout = logout;
    }

    public void logout() {
        Session.end();
        logout.run();
    }

    public Role login(LoginView login) throws IOException,
            InterruptedException {
        LoginRequestDTO request = AssembleLogin
                .assemble(login);
        LoginResponseDTO response = auth
                .toLogin(request);

        Role role = MapperLogin.getRole(response
                .getRole());
        Session.start(role);

        return role;
    }
}
