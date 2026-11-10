package org.example.demo.view.mapper.user;

import org.example.demo.view.components.card.user.definitions.PrompterView;
import org.example.demo.view.dto.user.RegularDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MapperPrompterUser {
    private static void mapperId(PrompterView prompter,
                                 RegularDTO response) {
        prompter.setId(response.getId());
    }

    private static void mapperNameSurname(PrompterView prompter,
                                          RegularDTO response) {
        prompter.setNameSurname(response.getName() +
                " " + response.getSurname());
    }

    private static void mapperName(PrompterView prompter,
                                   RegularDTO response) {
        prompter.setName(response.getName());
    }

    private static void mapperEmail(PrompterView prompter,
                                    RegularDTO response) {
        prompter.setEmail(response
                .getEmail());
    }

    public static <T extends PrompterView> T mapper(
            RegularDTO response, Supplier<T> supplier) {
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

    public static <T extends PrompterView> List<T> mapper(
            List<RegularDTO> response, Supplier<T> supplier) {
        List<T> list = new ArrayList<>();

        for(RegularDTO regular : response)
            list.add(mapper(regular, supplier));
        return list;
    }
}
