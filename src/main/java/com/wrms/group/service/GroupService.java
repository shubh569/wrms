package com.wrms.group.service;

import com.wrms.group.dto.CreateGroupRequest;
import com.wrms.group.dto.GroupResponse;
import com.wrms.group.dto.UpdateGroupRequest;

import java.util.List;
import java.util.UUID;

public interface GroupService {
    GroupResponse createGroup(CreateGroupRequest request);

    List<GroupResponse> getAllGroups();

    GroupResponse updateGroupById(UUID id, UpdateGroupRequest request);

    GroupResponse getGroupById(UUID id);

    void deleteGroup(UUID id);
}
