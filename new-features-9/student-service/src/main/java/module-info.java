import com.natsumes.service.IStudentService;
import com.natsumes.service.impl.StudentServiceImpl;

module student.service {
    exports com.natsumes.service;
    provides IStudentService with StudentServiceImpl;
}