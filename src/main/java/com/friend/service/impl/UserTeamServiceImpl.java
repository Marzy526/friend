package com.friend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.friend.service.UserTeamService;
import com.friend.model.domain.UserTeam;
import com.friend.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
        implements UserTeamService {

}




