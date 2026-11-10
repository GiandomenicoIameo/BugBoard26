package org.example.demo.view.mapper.user;

import org.example.demo.view.components.card.user.definitions.PrompterUserCardView;
import org.example.demo.view.dto.user.UserResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MapperPrompterUser {
    private static void mapperId(PrompterUserCardView prompter,
                                 UserResponseDTO response) {
        prompter.setId(response.getId());
    }

    private static void mapperNameSurname(PrompterUserCardView prompter,
                                          UserResponseDTO response) {
        prompter.setNameSurname(response.getName() +
                " " + response.getSurname());
    }

    private static void mapperName(PrompterUserCardView prompter,
                                   UserResponseDTO response) {
        prompter.setName(response.getName());
    }

    private static void mapperEmail(PrompterUserCardView prompter,
                                    UserResponseDTO response) {
        prompter.setEmail(response
                .getEmail());
    }

    public static <T extends PrompterUserCardView> T mapper(
            UserResponseDTO response, Supplier<T> supplier) {
        T prompter = supplier.get();

        mapperId(prompter,
                response);
        mapperNameSurname(prompter,
                response);

        mapperName(prompter,
                response);
        mapperEmail(prompter,
                response);

        return prompter;
    }

    public static <T extends PrompterUserCardView> List<T> mapper(
            List<UserResponseDTO> response, Supplier<T> supplier) {
        List<T> list = new ArrayList<>();

        for(UserResponseDTO regular : response)
            list.add(mapper(regular, supplier));
        return list;
    }
}
