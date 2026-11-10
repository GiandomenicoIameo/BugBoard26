package org.example.demo.view.core.orchestration.user;

import org.example.demo.view.components.bar.Settingsbar;
import org.example.demo.view.components.card.user.definitions.PrompterUserCardView;
import org.example.demo.view.components.card.user.definitions.NewUserCardView;
import org.example.demo.view.components.modal.definitions.NewUserModalView;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public interface UserOrchestration {
    <T extends NewUserCardView> T create(
            NewUserModalView user, Supplier<T> supplier
    )
            throws IOException, InterruptedException;
    <T extends PrompterUserCardView> List<T> getAllSuggested(
            Supplier<T> supplier
    )
            throws IOException, InterruptedException;
    <T extends NewUserCardView> List<T> getAll(
            Supplier<T> supplier
    )
            throws IOException, InterruptedException;
    <T extends Settingsbar> void getMe(
            T bar
    )
            throws IOException, InterruptedException;
}
