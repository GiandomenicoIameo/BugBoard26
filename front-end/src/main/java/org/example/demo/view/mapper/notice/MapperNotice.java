package org.example.demo.view.mapper.notice;

import org.example.demo.view.components.card.notice.definitions.NoticeView;
import org.example.demo.view.dto.notice.NotificationResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MapperNotice {
    private static void mapperId(NoticeView card,
                                 NotificationResponseDTO response) {
        card.setId(response.getId());
    }

    private static void mapperDate(NoticeView card,
                           NotificationResponseDTO response) {
        card.setDate(response.getDate());
    }

    private static void mapperIsRead(NoticeView card,
                             NotificationResponseDTO response) {
        card.setRead(response.isRead());
    }

    private static <T extends NoticeView> T mapper(
            NotificationResponseDTO response,T notice) {
        mapperId(notice,
                response);
        mapperDate(notice,
                response);
        mapperIsRead(notice,
                response);
        return notice;
    }

    public static <T extends NoticeView> List<T> mapper(List<NotificationResponseDTO> response,
                                          Supplier<T> supplier) {
        List<T> list = new ArrayList<>();

        for(NotificationResponseDTO card : response)
            list.add(mapper(card, supplier.get()));
        return list;
    }
}
