package com.sys.management.services.muser;

import com.sys.management.dto.RegisterDto;
import com.sys.management.entities.MUser;
import com.sys.management.enums.Role;
import com.sys.management.repositories.MUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MUserServiceImpl implements MUserService {
    private final MUserRepository mUserRepository;

    public MUserServiceImpl(MUserRepository mUserRepository) {
        this.mUserRepository = mUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MUser user = mUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }

    @Override
    public void register(RegisterDto request) {
        try {
            if (mUserRepository.findByUsername(request.username).isPresent()) {
                throw new UsernameNotFoundException("Username already exists");
            }
            MUser mUser = new MUser();
            mUser.setFullName(request.fullName);
            mUser.setUsername(request.username);
            mUser.setEmail(request.email);
            mUser.setPassword(new BCryptPasswordEncoder().encode(request.password));
            mUser.setPhone(request.phone);
            mUser.setAddress(request.address);
            mUser.setGender(request.gender);
            mUser.setRole(request.role != null ? request.role : Role.USER);
            mUserRepository.save(mUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
