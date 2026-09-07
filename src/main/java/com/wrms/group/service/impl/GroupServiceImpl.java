package com.wrms.group.service.impl;

import com.wrms.group.dto.CreateGroupRequest;
import com.wrms.group.dto.GroupResponse;
import com.wrms.group.entity.Group;
import com.wrms.group.repository.GroupRepository;
import com.wrms.group.service.GroupService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public GroupResponse createGroup(CreateGroupRequest request) {
        Group group = Group.builder()
                .id(UUID.randomUUID())
                .name(request.name())
                .description(request.description())
                .createdAt(LocalDateTime.now())
                .build();
        group = groupRepository.save(group);
        return GroupResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .description(group.getDescription())
                .createdAt(group.getCreatedAt())
                .build();
    }
}
