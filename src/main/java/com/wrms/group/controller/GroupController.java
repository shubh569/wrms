package com.wrms.group.controller;

import com.wrms.group.dto.CreateGroupRequest;
import com.wrms.group.dto.GroupResponse;
import com.wrms.group.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    @PostMapping
    public GroupResponse createGroup(
            @Valid @RequestBody CreateGroupRequest request) {
        return groupService.createGroup(request);
    }
}
