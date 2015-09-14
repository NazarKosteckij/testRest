package com.test.rest.services.filters;

import com.test.rest.dto.UserDto;

import java.util.List;

/**
 * Created by nkostets on 9/14/2015.
 */
public interface UserFilterService {
    /**
     *
     * @return
     */
    public List<UserDto> getAll();
}
