package com.wrms.group.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;
@Builder
public record GroupResponse(
        UUID id,
        String name,
        String description,
        LocalDateTime createdAt
) {}