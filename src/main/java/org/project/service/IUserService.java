package org.project.service;

import org.project.entity.User;

public interface IUserService {

    User findUserByName(String username);
}
