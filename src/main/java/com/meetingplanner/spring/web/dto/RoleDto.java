package com.meetingplanner.spring.web.dto;

import com.meetingplanner.spring.customAnnotations.ValidRoleName;
import lombok.Data;


@Data
public class RoleDto {
    Long id;
    @ValidRoleName
    String name;
}
