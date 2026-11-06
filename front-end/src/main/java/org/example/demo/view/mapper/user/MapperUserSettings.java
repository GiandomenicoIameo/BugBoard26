package org.example.demo.view.mapper.user;

import org.example.demo.view.components.bar.Settingsbar;
import org.example.demo.view.dto.user.UserDTO;

public class MapperUserSettings {
    private static <T extends Settingsbar> void mapperName(
            T bar, UserDTO user) {
        bar.setName(user.getName());
    }

    private static <T extends Settingsbar> void mapperEmail(
            T bar, UserDTO user) {
        bar.setEmail(user.getEmail());
    }

    private static <T extends Settingsbar> void mapperRole(T bar) {
        bar.setRole();
    }

    public static <T extends Settingsbar> void mapper(
            T bar, UserDTO user) {
        mapperName(bar,
                user);
        mapperEmail(bar,
                user);
        mapperRole(bar);
    }
}
