package pl.edu.agh.soa.lab2.resources;

import io.swagger.annotations.*;
import pl.edu.agh.soa.lab2.auth.JWTRequired;
import pl.edu.agh.soa.lab2.model.Student;
import pl.edu.agh.soa.lab2.model.StudentProto;
import pl.edu.agh.soa.lab2.resources.beans.StudentFilterBean;
import pl.edu.agh.soa.lab2.service.StudentService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Path("/students")
@Api(value = "Students API")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON, "image/jpg"})
public class StudentResource {

    private StudentService studentService = new StudentService();
    //private static final String FILE_PATH = "C:\\Users\\Paulina\\Desktop\\cat.jpg";

    @GET
    @ApiOperation("Returns list of students")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No students found"),
            @ApiResponse(code = 200, message = "Students found",
                    response = Student.class,
                    responseContainer = "List")
    })
    public List<Student> getStudents(@BeanParam StudentFilterBean filterBean) {
        if(filterBean.getStart() >= 0  && filterBean.getSize() > 0) {
            return studentService.getAllStudentsPaginated(filterBean.getStart(), filterBean.getSize());
        }
        if (filterBean.getName().length() > 0) {
            return studentService.getAllStudentsByName(filterBean.getName());
        } else {
            return studentService.getAllStudents();
        }
    }

    @JWTRequired
    @POST
    @ApiOperation("Adds student to the database")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    @ApiResponses({
            @ApiResponse(code = 201, message = "Student added"),
            @ApiResponse(code = 401, message = "Unauthenticated")})
    public Response addStudent(@Valid Student student, @Context UriInfo uriInfo) {
        Student newStudent = studentService.addStudent(student);
        String newId = String.valueOf(newStudent.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newStudent)
                .build();
        // return studentService.addStudent(student);
    }
// ***************************************************************************
    /*
    @GET
    @Path("{studentId: [0-9]*}/avatar")
    @Produces("image/jpg")
    public Response getAvatar(){
        File file = new File(FILE_PATH);
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
                "attachment; filename=image_from_server.jpg");
        return response.build();
    }
      */
// ***************************************************************************
    @GET
    @Produces("image/jpg")
    @Path("/{studentId}/avatar")
    @ApiOperation("Returns avatar of student with given ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Student found, avatar returned"),
            @ApiResponse(code = 404, message = "Student with given id does not exist"),
            @ApiResponse(code = 500, message = "Something went wrong during loading the image, try again later")
    })
    public Response getAvatarById(@PathParam("studentId") int id) {
        if(studentService.getAllStudents().size() < id) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Student student = studentService.getStudent(id);
        Object result;
        URL resource = getClass().getClassLoader().getResource(student.getAvatar());
        try {
            byte[] bytes = new byte[resource.openConnection().getContentLength()];
            resource.openStream().read(bytes);
            result = bytes;
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        return Response.status(Response.Status.OK).entity(result).build();
    }

    @JWTRequired
    @PUT
    @Path("{studentId: [0-9]*}")
    @ApiOperation("Updates student with given ID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Student updated"),
            @ApiResponse(code = 404, message = "Student with given id does not exist"),
            @ApiResponse(code = 401, message = "Unauthenticated"),
    })
    public Response updateStudent(@PathParam("studentId") int id, Student student) {
        if(studentService.getAllStudents().size() < id) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        student.setId(id);
        studentService.updateStudent(student);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{studentId: [0-9]*}")
    @ApiOperation("Deletes student with given ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Student deleted")})
    public Response deleteStudent(@PathParam("studentId") int id) {
        studentService.removeStudent(id);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @ApiOperation("Returns student with given ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Student found"),
            @ApiResponse(code = 404, message = "Student with given id not found")
    })
    @Path("{studentId: [0-9]*}")
    public Student getStudent(@PathParam("studentId") int id) {
        return studentService.getStudent(id);
    }

    /// --- protobuf ---
    @GET
    @Produces("application/protobuf")
    @Path("/{studentId}/protobuf")
    @ApiOperation("Returns student with given ID (in ProtoBuf)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Student found"),
            @ApiResponse(code = 404, message = "Student with given id not found")
    })
    public Response getStudentByIdProto(@PathParam("studentId") int id) {
        if (studentService.getStudent(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            Student student = studentService.getStudent(id);
            return Response.status(Response.Status.OK).
                    entity(StudentProto.Student.newBuilder()
                            .setId(student.getId())
                            .setName(student.getName())
                            .setSurname(student.getSurname())
                            .setAvatarPath(student.getAvatar())
                            .build())
                    .build();
        }
    }

    @Path("/{studentId: [0-9]*}/courses")
    public CourseResource getCourseResource() {
        return new CourseResource();
    }
}
