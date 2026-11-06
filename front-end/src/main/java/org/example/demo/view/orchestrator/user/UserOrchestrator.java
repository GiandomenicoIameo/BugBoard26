package org.example.demo.view.orchestrator.user;

import org.example.demo.view.assembler.user.AssembleUser;
import org.example.demo.view.components.bar.Settingsbar;
import org.example.demo.view.components.card.user.definitions.PrompterView;
import org.example.demo.view.components.card.user.definitions.UserView;
import org.example.demo.view.components.modal.definitions.NewUserCardView;
import org.example.demo.view.core.orchestration.user.UserOrchestration;
import org.example.demo.view.dto.user.AddUserRequestDTO;
import org.example.demo.view.dto.user.AddUserResponseDTO;
import org.example.demo.view.mapper.user.MapperRegular;
import org.example.demo.view.mapper.user.MapperUser;
import org.example.demo.view.mapper.user.MapperUserSettings;
import org.example.demo.view.service.user.UserService;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class UserOrchestrator implements UserOrchestration {
    private final UserService userService =
            new UserService();

    public <T extends UserView> T create(
            NewUserCardView user, Supplier<T> supplier)
            throws IOException, InterruptedException {
        AddUserRequestDTO request = AssembleUser
                .assemble(user);
        AddUserResponseDTO response = userService
                .createUser(request);
        return MapperUser
                .mapper(response,
                        supplier);
    }

    public <T extends PrompterView> List<T> getAllSuggested(
            Supplier<T> supplier
    )
            throws IOException, InterruptedException {
        return MapperRegular.mapper(userService
                .suggested(), supplier);
    }

    public <T extends UserView> List<T> getAll(
            Supplier<T> supplier)
            throws IOException, InterruptedException {
        return MapperUser.mapper(userService
                .listUsers(), supplier);
    }

    public <T extends Settingsbar> void getMe(T bar)
            throws IOException, InterruptedException {
        MapperUserSettings.mapper(bar, userService
                .me());
    }
}
