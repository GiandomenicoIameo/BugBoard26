package org.example.demo.view.orchestrator.notice;

import org.example.demo.view.components.card.notice.definitions.NoticeCardView;
import org.example.demo.view.core.orchestration.notice.NoticeOrchestration;
import org.example.demo.view.mapper.notice.MapperNotice;
import org.example.demo.view.service.notice.NoticeService;
import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class NoticeOrchestrator implements NoticeOrchestration {
    private final NoticeService
            noticeService = new NoticeService();

    public <T extends NoticeCardView> List<T> getAll(
            Supplier<T> supplier) throws IOException,
            InterruptedException {
        return MapperNotice.mapper(noticeService
                .listNoticeRead(), supplier);
    }
}
