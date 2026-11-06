package org.example.demo.view.mapper.user;

import org.example.demo.view.components.card.user.User;
import org.example.demo.view.components.card.user.definitions.UserView;
import org.example.demo.view.dto.user.AddUserResponseDTO;
import org.example.demo.view.service.user.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MapperUser {
    private static final UserService userService =
            new UserService();

    public static List<User> convert() throws IOException,
            InterruptedException {
        List<User> list = new ArrayList<>();

        for(AddUserResponseDTO response : userService
                .listUsers()) {
            User user = new User();
            mapper(user, response);

            list.add(user);
        } return list;
    }

    private static void mapperName(UserView user,
                                   AddUserResponseDTO response) {
        user.setUsernameBold(response.getName() +
                " " + response.getSurname());
        user.setUsernameRegular(response.getSurname());
    }

    private static void mapperEmail(UserView user,
                            AddUserResponseDTO response) {
        user.setEmail(response
                .getEmail());
    }

    private static void mapperRole(UserView user,
                           AddUserResponseDTO response) {
        user.setRole(response.getRole());
    }

    public static <T extends UserView> T mapper(
            AddUserResponseDTO response, Supplier<T> supplier) {
        T user = supplier.get();

        mapperName(user,
                response);
        mapperRole(user,
                response);
        mapperEmail(user,
                response);

        return user;
    }

    public static void mapper(User user,
                              AddUserResponseDTO response) {
        mapperName(user, response);
        mapperRole(user, response);

        mapperEmail(user, response);
    }

    public static <T extends UserView> List<T> mapper(
            List<AddUserResponseDTO> response, Supplier<T> supplier) {
        List<T> list = new ArrayList<>();

        for(AddUserResponseDTO user : response)
            list.add(mapper(user, supplier));
        return list;
    }
}
