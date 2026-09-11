package com.wrms.group.controller;

import com.wrms.group.dto.CreateGroupRequest;
import com.wrms.group.dto.GroupResponse;
import com.wrms.group.dto.UpdateGroupRequest;
import com.wrms.group.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    @PostMapping
    public ResponseEntity<GroupResponse> createGroup(
            @Valid @RequestBody CreateGroupRequest request) {

        GroupResponse response =
                groupService.createGroup(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<GroupResponse>> getALlGroups()
    {
        List<GroupResponse> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupResponse> getGroupById(@PathVariable UUID id)
    {
        GroupResponse group = groupService.getGroupById(id);
        return ResponseEntity.ok(group);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupResponse> updateGroup(
            @PathVariable UUID id,
            @RequestBody UpdateGroupRequest request) {

        return ResponseEntity.ok(
                groupService.updateGroupById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(
            @PathVariable UUID id) {

        groupService.deleteGroup(id);

        return ResponseEntity.noContent().build();
    }
}
