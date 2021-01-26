package com.github.tasktracker.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.tasktracker.backend.dto.NewDepartmentDTO;
import com.github.tasktracker.backend.entities.Department;
import com.github.tasktracker.backend.entities.User;
import com.github.tasktracker.backend.repositories.InvitesRepository;
import com.github.tasktracker.backend.repositories.PasscodeRepository;
import com.github.tasktracker.backend.repositories.DepartmentRepository;
import com.github.tasktracker.backend.repositories.UserRepository;
import com.github.tasktracker.backend.resources.DepartmentListResource;
import com.github.tasktracker.backend.resources.DepartmentResource;

@Service
public class DepartmentService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PasscodeRepository passcodeRepository;
    @Autowired
    private InvitesRepository invitesRepository;

    public boolean addUser(long uid, String code) {
        boolean invited = false;
        User user = userRepository.findById(uid).get();   // get
        Long pidv = passcodeRepository.getPidByCode(code);
        if (!Objects.isNull(pidv)) {
            long pid = pidv.longValue();
            boolean ifInvited = invitesRepository.existsByUid(uid);
            List<Long> invitedPid = invitesRepository.findByUid(uid); // All invited users
            boolean checked = false;
            for (Long id : invitedPid) { //
                if (id == pid) {
                    checked = true;
                    break;
                }
            }

            if (ifInvited && checked) {
                invited = true;
                Department p = departmentRepository.findById(pid).get();
                List<User> users = p.getUsers();
                users.add(user);
                p.setUsers(users);
                departmentRepository.save(p);
            } else {
                invited = false;
            }
        } else {
            invited = false;
        }
        return invited;
    }

    public long createDepartment(NewDepartmentDTO newDepartmentDto, long admin) {
        Department department = new Department();
        department.setId(newDepartmentDto.getId());
        department.setName(newDepartmentDto.getName());
        department.setAdmin(admin);
        User user = userRepository.findById(admin).get();
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        department.setUsers(userList);
        Department savedDepartment = departmentRepository.save(department);

        return savedDepartment.getId();
    }

    public DepartmentListResource getAll() {
        DepartmentListResource list = new DepartmentListResource();
        list.setDepartmentList((List<DepartmentResource>) departmentRepository.findAll().stream()
                .map(p -> new DepartmentResource(p)).collect(Collectors.toList()));
        return list;
    }

    public DepartmentListResource getAllByAdmin(long id) {
        DepartmentListResource list = new DepartmentListResource();
        list.setDepartmentList((List<DepartmentResource>) departmentRepository.findByAdmin(id).stream()
                .map(p -> new DepartmentResource(p)).collect(Collectors.toList()));
        return list;
    }
}
