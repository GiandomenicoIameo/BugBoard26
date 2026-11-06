package org.example.demo.view.core.orchestration.user;

import org.example.demo.view.components.bar.Settingsbar;
import org.example.demo.view.components.card.user.definitions.PrompterView;
import org.example.demo.view.components.card.user.definitions.UserView;
import org.example.demo.view.components.modal.definitions.NewUserCardView;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public interface UserOrchestration {
    <T extends UserView> T create(
            NewUserCardView user, Supplier<T> supplier
    )
            throws IOException, InterruptedException;
    <T extends PrompterView> List<T> getAllSuggested(
            Supplier<T> supplier
    )
            throws IOException, InterruptedException;
    <T extends UserView> List<T> getAll(
            Supplier<T> supplier
    )
            throws IOException, InterruptedException;
    <T extends Settingsbar> void getMe(
            T bar
    )
            throws IOException, InterruptedException;
}
