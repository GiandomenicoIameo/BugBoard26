package org.example.demo.view.assembler.user;

import org.example.demo.view.components.modal.definitions.NewUserCardView;
import org.example.demo.view.dto.user.AddUserRequestDTO;

public class AssembleUser {
    private static void assembleName(NewUserCardView user,
                                     AddUserRequestDTO request) {
        request.setName(user.getName());
    }

    private static void assembleSurname(NewUserCardView user,
                                        AddUserRequestDTO request) {
        request.setSurname(user.getSurname());
    }

    private static void assembleRole(NewUserCardView user,
                                     AddUserRequestDTO request) {
        request.setRole(user.getRole());
    }

    private static void assembleCredentials(NewUserCardView user,
                                            AddUserRequestDTO request) {
        request.setEmail(user.getEmail());
        request.setPassword(user.getPassword());
    }

    public static AddUserRequestDTO assemble(NewUserCardView user) {
        AddUserRequestDTO request =
                new AddUserRequestDTO();

        assembleName(user, request);
        assembleSurname(user, request);
        assembleRole(user, request);
        assembleCredentials(user, request);

        return request;
    }
}
