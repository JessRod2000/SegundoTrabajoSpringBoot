package com.eeds.monolitica.proyect.services.implement;

import com.eeds.monolitica.proyect.domain.entities.Rol;
import com.eeds.monolitica.proyect.domain.entities.User;
import com.eeds.monolitica.proyect.domain.entities.UserDetail;
import com.eeds.monolitica.proyect.dto.UserDTO;
import com.eeds.monolitica.proyect.dto.UserDetailDTO;
import com.eeds.monolitica.proyect.dto.UserNewDTO;
import com.eeds.monolitica.proyect.repositories.data.UserDetailRepository;
import com.eeds.monolitica.proyect.repositories.data.UserRepository;
import com.eeds.monolitica.proyect.services.UserService;
import com.eeds.monolitica.proyect.services.mapper.UserMapper;
import com.eeds.monolitica.proyect.web.exception.CustomNotFoundException;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserDetailRepository userDetailRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserDetailRepository userDetailRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetailRepository = userDetailRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listAllUsers() {
        return userRepository.findAllByActiveOrderByUserNameAsc(Boolean.TRUE)
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailDTO> listAllUsersDetailed() {
        return userRepository.findAllByActiveOrderByUserNameAsc(Boolean.TRUE)
                .stream()
                .map(userMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserNewDTO userDTO) {
        User user = userRepository.save(userMapper.toEntityCreate(userDTO));
        if (userDTO.getUserDetail()!=null) {
            userDetailRepository.save(new UserDetail(userDTO.getUserDetail().getFirstName(),userDTO.getUserDetail().getLastName(),userDTO.getUserDetail().getAge(),userDTO.getUserDetail().getBirthDay(),user));
        }
        return userMapper.toDto(user);
    }

    @Override
    public void delete(Long userid) {
        //userRepository.deleteById(userid);
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new IllegalArgumentException("User with id: " + userid + " is not existed."));
        user.setActive(Boolean.FALSE);
        userRepository.save(user);
    }

    @Override
    public UserDetailDTO updateUser(Long id, UserDetailDTO userDTO) {
        User userDB = userRepository.findById(id).orElseThrow(()->new NoSuchElementException("No se encontró el rol con ID: " + id));
        userDB.setUserName(userDTO.getUserName());
        userDB.setPassword(userDTO.getPassword());
        userDB.setEmail(userDTO.getEmail());
        userRepository.save(userDB);
        if (userDTO.getUserDetailId()!=null) {
            UserDetail userDetail= userDetailRepository.findById(userDTO.getUserDetailId()).orElseThrow(()->new NoSuchElementException("No se encontro el detailed"));
            //userDetail.setId(userDTO.getId());
            userDetail.setFirstName(userDTO.getFirstName());
            userDetail.setLastName(userDTO.getLastName());
            userDetail.setAge(userDTO.getAge());
            userDetail.setBirthDay(userDTO.getBirthDay());
            userDetail.setUser(userDB);
            userDetailRepository.save(userDetail);
            //userDetailRepository.save(new UserDetail(userDTO.getUserDetail().getFirstName(),userDTO.getUserDetail().getLastName(),userDTO.getUserDetail().getAge(),userDTO.getUserDetail().getBirthDay(),userDB));
        }
        return userMapper.toDtoDetailed(userDB);
    }

    @Override
    public Optional<UserDetailDTO> getUserById(Long userId) throws CustomNotFoundException {
        Optional<User> userDB = userRepository.findById(userId);
        if(!userDB.isPresent()){
            throw new CustomNotFoundException("El USER con el ID :"+userId+" NO EXISTE");
        }
        return userDB.map(userMapper::toDtoDetailed);
    }

}
