package org.example.demo.view.assembler.user;

import org.example.demo.view.components.modal.definitions.NewUserModalView;
import org.example.demo.view.dto.user.UserRequestDTO;

public class AssembleUser {
    private static void assembleName(NewUserModalView user,
                                     UserRequestDTO request) {
        request.setName(user.getName());
    }

    private static void assembleSurname(NewUserModalView user,
                                        UserRequestDTO request) {
        request.setSurname(user.getSurname());
    }

    private static void assembleRole(NewUserModalView user,
                                     UserRequestDTO request) {
        request.setRole(user.getRole());
    }

    private static void assembleCredentials(NewUserModalView user,
                                            UserRequestDTO request) {
        request.setEmail(user.getEmail());
        request.setPassword(user.getPassword());
    }

    public static UserRequestDTO assemble(NewUserModalView user) {
        UserRequestDTO request =
                new UserRequestDTO();

        assembleName(user, request);
        assembleSurname(user, request);
        assembleRole(user, request);
        assembleCredentials(user, request);

        return request;
    }
}
