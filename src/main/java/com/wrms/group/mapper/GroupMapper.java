package com.wrms.group.mapper;

import com.wrms.group.dto.GroupResponse;
import com.wrms.group.dto.UpdateGroupRequest;
import com.wrms.group.entity.Group;

public class GroupMapper {

    public static GroupResponse groupToGroupResponse(Group group)
    {
        GroupResponse groupResponse = GroupResponse.builder()
                .id(group.getId())
                .name(group.getName())
                .description(group.getDescription())
                .createdAt(group.getCreatedAt())
                .build();
        return groupResponse;
    }

    public static Group groupResponseToGroup(GroupResponse groupResponse) {
        return null;
    }

    public static void updateEntity(Group group, UpdateGroupRequest request) {
        group.setName(request.name());
        group.setDescription(request.description());
    }
}
