package org.example.demo.view.orchestrator.user;

import org.example.demo.view.assembler.user.AssembleUser;
import org.example.demo.view.components.bar.Settingsbar;
import org.example.demo.view.components.card.user.definitions.PrompterUserCardView;
import org.example.demo.view.components.card.user.definitions.NewUserCardView;
import org.example.demo.view.components.modal.definitions.NewUserModalView;
import org.example.demo.view.core.orchestration.user.UserOrchestration;
import org.example.demo.view.dto.user.UserRequestDTO;
import org.example.demo.view.dto.user.UserResponseDTO;
import org.example.demo.view.mapper.user.MapperPrompterUser;
import org.example.demo.view.mapper.user.MapperUser;
import org.example.demo.view.mapper.user.MapperUserSettings;
import org.example.demo.view.service.user.UserService;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class UserOrchestrator implements UserOrchestration {
    private final UserService userService =
            new UserService();

    public <T extends NewUserCardView> T create(
            NewUserModalView user, Supplier<T> supplier)
            throws IOException, InterruptedException {
        UserRequestDTO request = AssembleUser
                .assemble(user);
        UserResponseDTO response = userService
                .createUser(request);
        return MapperUser
                .mapper(response,
                        supplier);
    }

    public <T extends PrompterUserCardView> List<T> getAllSuggested(
            Supplier<T> supplier
    )
            throws IOException, InterruptedException {
        return MapperPrompterUser.mapper(userService
                .suggested(), supplier);
    }

    public <T extends NewUserCardView> List<T> getAll(
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
