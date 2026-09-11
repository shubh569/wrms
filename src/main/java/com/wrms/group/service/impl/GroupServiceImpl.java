package com.wrms.group.service.impl;

import com.wrms.common.exception.ResourceNotFoundException;
import com.wrms.group.dto.CreateGroupRequest;
import com.wrms.group.dto.GroupResponse;
import com.wrms.group.dto.UpdateGroupRequest;
import com.wrms.group.entity.Group;
import com.wrms.group.mapper.GroupMapper;
import com.wrms.group.repository.GroupRepository;
import com.wrms.group.service.GroupService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
        return GroupMapper.groupToGroupResponse(group);
    }

    @Override
    public List<GroupResponse> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        List<GroupResponse> responseList = groups.stream()
                .map(GroupMapper::groupToGroupResponse).toList();
        return responseList;
    }

    @Override
    public GroupResponse updateGroupById(UUID id, UpdateGroupRequest request) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Group",id));
        GroupMapper.updateEntity(group, request);
        Group updatedGroup = groupRepository.save(group);
        return GroupMapper.groupToGroupResponse(updatedGroup);
    }

    @Override
    public GroupResponse getGroupById(UUID id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Group",id));
        return GroupMapper.groupToGroupResponse(group);
    }

    @Override
    public void deleteGroup(UUID id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Group",id));
        groupRepository.deleteById(id);
    }
}
