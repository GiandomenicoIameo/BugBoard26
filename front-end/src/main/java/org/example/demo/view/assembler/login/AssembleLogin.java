package org.example.demo.view.assembler.login;

import org.example.demo.view.access.definitions.LoginView;
import org.example.demo.view.dto.login.LoginRequestDTO;

public class AssembleLogin {
    private static void assembleEmail(LoginView login,
                                      LoginRequestDTO request) {
        request.setEmail(login
                .getEmail());
    }

    private static void assemblePassword(LoginView login,
                                         LoginRequestDTO request) {
        request.setPassword(login
                .getPassword());
    }

    public static LoginRequestDTO assemble(LoginView login) {
        LoginRequestDTO request = new LoginRequestDTO();

        assembleEmail(login, request);
        assemblePassword(login, request);

        return  request;
    }
}
