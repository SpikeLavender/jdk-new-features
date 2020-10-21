import com.natsumes.service.IStudentService;

module project.portal {

    requires transitive student.service;    //先写

    uses IStudentService;
}