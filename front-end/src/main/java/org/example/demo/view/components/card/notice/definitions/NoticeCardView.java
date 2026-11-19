package org.example.demo.view.components.card.notice.definitions;

import java.time.LocalDateTime;

public interface NoticeCardView {
    void setId(Integer id);
    void setDescription(String description);
    void setDate(LocalDateTime date);
}
