package com.wrms.group.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateGroupRequest(

        @NotBlank
        String name,
        String description

) {
}