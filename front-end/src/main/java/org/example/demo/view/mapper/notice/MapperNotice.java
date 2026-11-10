package org.example.demo.view.mapper.notice;

import org.example.demo.view.components.card.notice.definitions.NoticeCardView;
import org.example.demo.view.dto.notice.NoticeResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MapperNotice {
    private static void mapperId(NoticeCardView card,
                                 NoticeResponseDTO response) {
        card.setId(response.getId());
    }

    private static void mapperDate(NoticeCardView card,
                                   NoticeResponseDTO response) {
        card.setDate(response.getDate());
    }

    private static void mapperIsRead(NoticeCardView card,
                                     NoticeResponseDTO response) {
        card.setRead(response.isRead());
    }

    private static <T extends NoticeCardView> T mapper(
            NoticeResponseDTO response, T notice) {
        mapperId(notice,
                response);
        mapperDate(notice,
                response);
        mapperIsRead(notice,
                response);
        return notice;
    }

    public static <T extends NoticeCardView> List<T> mapper(List<NoticeResponseDTO> response,
                                                            Supplier<T> supplier) {
        List<T> list = new ArrayList<>();

        for(NoticeResponseDTO card : response)
            list.add(mapper(card, supplier.get()));
        return list;
    }
}
