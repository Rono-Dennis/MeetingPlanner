package com.meetingplanner.spring.service.searching;

import com.meetingplanner.spring.web.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchResult {
    private Page<UserDto> userPage;
    private boolean numberFormatException;
}
