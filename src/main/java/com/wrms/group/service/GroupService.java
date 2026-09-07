package com.wrms.group.service;

import com.wrms.group.dto.CreateGroupRequest;
import com.wrms.group.dto.GroupResponse;

public interface GroupService {
    GroupResponse createGroup(CreateGroupRequest request);
}
