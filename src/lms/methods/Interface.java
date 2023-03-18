package lms.methods;

import lms.classes.Group;

import java.util.List;

public interface Interface {
    void addGroup(List<Group> groups);

    void groupByName(List<Group> groups);

    void updateGroupName(List<Group> groups);

    void getAllGroups(List<Group> groups);

    void addNewStudentToGroup(List<Group> groups);

    void updateStudent(List<Group> groups);

    void findStudentByFirstname(List<Group> groups);

    void getAllStudentsByGroupNam(List<Group> groups);

    void getAllStudentsLesson(List<Group> groups);

    void deleteStudent(List<Group> groups);

    void addNewLessonToGroup(List<Group> groups);

    void getLessonByName(List<Group> groups);

    void getAllLessonByGroupName(List<Group> groups);

    void deleteLesson(List<Group> groups);

    void deleteGroup(List<Group> groups);


}
