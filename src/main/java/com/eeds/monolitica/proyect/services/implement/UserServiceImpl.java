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
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailDTO> listAllUsersDetailed() {
        return userRepository.findAll()
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
        userRepository.deleteById(userid);
    }

    @Override
    public UserDTO updateUser(Long id, UserNewDTO userDTO) {
        User userDB = userRepository.findById(id).orElseThrow(()->new NoSuchElementException("No se encontró el rol con ID: " + id));
        userDB.setUserName(userDTO.getUserName());
        userDB.setPassword(userDTO.getPassword());
        userDB.setEmail(userDTO.getEmail());
        userRepository.save(userDB);
        if (userDTO.getUserDetail()!=null) {
            userDetailRepository.save(new UserDetail(userDTO.getUserDetail().getFirstName(),userDTO.getUserDetail().getLastName(),userDTO.getUserDetail().getAge(),userDTO.getUserDetail().getBirthDay(),userDB));
        }
        return userMapper.toDto(userDB);
    }

    @Override
    public Optional<UserDTO> getUserById(Long userId) throws CustomNotFoundException {
        Optional<User> userDB = userRepository.findById(userId);
        if(!userDB.isPresent()){
            throw new CustomNotFoundException("El USER con el ID :"+userId+" NO EXISTE");
        }

        return userRepository.findById(userId).map(userMapper::toDto);
    }

}
