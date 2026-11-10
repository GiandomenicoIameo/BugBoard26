package org.example.demo.view.mapper.user;

import org.example.demo.view.components.card.user.NewUserCard;
import org.example.demo.view.components.card.user.definitions.NewUserCardView;
import org.example.demo.view.dto.user.UserResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MapperUser {
    private static void mapperName(NewUserCardView user,
                                   UserResponseDTO response) {
        user.setUsernameBold(response.getName() +
                " " + response.getSurname());
        user.setUsernameRegular(response.getSurname());
    }

    private static void mapperEmail(NewUserCardView user,
                                    UserResponseDTO response) {
        user.setEmail(response
                .getEmail());
    }

    private static void mapperRole(NewUserCardView user,
                                   UserResponseDTO response) {
        user.setRole(response.getRole());
    }

    public static <T extends NewUserCardView> T mapper(
            UserResponseDTO response, Supplier<T> supplier) {
        T user = supplier.get();

        mapperName(user,
                response);
        mapperRole(user,
                response);
        mapperEmail(user,
                response);

        return user;
    }

    public static void mapper(NewUserCard newUserCard,
                              UserResponseDTO response) {
        mapperName(newUserCard, response);
        mapperRole(newUserCard, response);

        mapperEmail(newUserCard, response);
    }

    public static <T extends NewUserCardView> List<T> mapper(
            List<UserResponseDTO> response, Supplier<T> supplier) {
        List<T> list = new ArrayList<>();

        for(UserResponseDTO user : response)
            list.add(mapper(user, supplier));
        return list;
    }
}
