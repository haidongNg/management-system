package com.sys.management.services.muser;

import com.sys.management.dto.RegisterDto;
import com.sys.management.entities.MUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MUserService extends UserDetailsService {
    void register(RegisterDto request);
}
