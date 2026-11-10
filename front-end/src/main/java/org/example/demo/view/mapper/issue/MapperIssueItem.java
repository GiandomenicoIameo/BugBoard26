package org.example.demo.view.mapper.issue;

import org.example.demo.view.components.card.issue.definitions.issueItemCard.IssueItemCardView;
import org.example.demo.view.core.contract.IssuePriority;
import org.example.demo.view.dto.issue.IssueResponseDTO;

public class MapperIssueItem {
    private static void mapperId(IssueItemCardView issue,
                                 IssueResponseDTO response) {
        issue.setId(response.getId());
    }

    private static void mapperTitle(IssueItemCardView issue,
                                    IssueResponseDTO response) {
        issue.setTitle(response.getTitle());
    }

    private static void mapperName(IssueItemCardView issue,
                                   IssueResponseDTO response) {
        issue.setName(response
                .getCreatorName());
    }

    private static void mapperPriority(IssueItemCardView card,
                                       IssueResponseDTO response) {
        card.setPriority(toPriority(response
                .getPriority()));
    }

    private static IssuePriority toPriority(String priority) {
        if("ALTA".equals(priority))
            return IssuePriority
                    .ALTA;
        else if("MEDIA".equals(priority))
            return IssuePriority
                    .MEDIA;
        else if("BASSA".equals(priority))
            return IssuePriority
                    .BASSA;
        else
            return null;
    }

    private static void mapperDate(IssueItemCardView issue,
                                   IssueResponseDTO response) {
        issue.setDate(response.getDate());
    }

    public static <T extends IssueItemCardView> T mapper(
            IssueResponseDTO response,
            T issue) {

        mapperId(issue,
                response);
        mapperTitle(issue,
                response);
        mapperName(issue,
                response);

        mapperPriority(issue,
                response);
        mapperDate(issue,
                response);

        return issue;
    }

//    public static List<IssueItemCard> mapper(List<IssueResponseDTO> response) {
//        List<IssueItemCard> list = new ArrayList<>();
//
//        for(IssueResponseDTO issue : response)
//            list.add(mapper(issue));
//        return list;
//    }
}
