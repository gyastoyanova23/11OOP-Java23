import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class test{
    @Test
    void testaddStudent() {
        StudentService studentService = new StudentService();
        int count = studentService.getStudentsCount();
        studentService.addStudent("Name");
        assertEquals(count+1, studentService.getStudentsCount());
    }

}