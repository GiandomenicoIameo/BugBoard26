package org.example.demo.view.dto.user;

import com.google.gson.annotations.SerializedName;

public class AssignmentRequestDTO {
    @SerializedName("")
    private RegularDTO regularDTO;

    public void setRegularDTO(RegularDTO regularDTO) {
        this.regularDTO = regularDTO;
    }

    public RegularDTO getRegularDTO() {
        return regularDTO;
    }
}
