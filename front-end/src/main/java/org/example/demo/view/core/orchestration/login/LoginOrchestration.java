package org.example.demo.view.core.orchestration.login;

import org.example.demo.view.access.definitions.LoginView;
import org.example.demo.view.core.contract.Role;

import java.io.IOException;

public interface LoginOrchestration {
    Role login(LoginView login) throws IOException,
            InterruptedException;
    void setPageLogin(Runnable logout);
    void logout();
}
