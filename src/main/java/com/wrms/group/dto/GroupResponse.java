package com.wrms.group.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record GroupResponse(UUID id,
                            String name,
                            LocalDateTime createdAt) {
}
