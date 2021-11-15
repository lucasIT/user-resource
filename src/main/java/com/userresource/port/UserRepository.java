package com.userresource.port;

import com.userresource.domain.model.User;

public interface UserRepository {

    User findByUserName(String userName);
}
