package pl.edu.agh.soa.lab2.resources;

import io.swagger.annotations.*;
import pl.edu.agh.soa.lab2.auth.JWTRequired;
import pl.edu.agh.soa.lab2.model.Course;
import pl.edu.agh.soa.lab2.service.CourseService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/")
@Api(value = "Courses API")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

    private CourseService courseService = new CourseService();

    @GET
    @ApiOperation("Returns list of all courses")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No courses found"),
            @ApiResponse(code = 200, message = "Courses found",
                    response = Course.class,
                    responseContainer = "List")
    })
    public List<Course> getAllCourses(@PathParam("studentId") int studentId) {
        return courseService.getAllCourses(studentId);
    }

    @JWTRequired
    @POST
    @ApiOperation("Adds course to student")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    @ApiResponses({
            @ApiResponse(code = 201, message = "Course added"),
            @ApiResponse(code = 401, message = "Unauthenticated")})
    public Response addCourse(@PathParam("studentId") int studentId, @Valid Course course, @Context UriInfo uriInfo) {
        Course newCourse = courseService.addCourse(studentId, course);
        String newId = String.valueOf(newCourse.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newCourse)
                .build();
        //return courseService.addCourse(studentId, course);
    }

    @JWTRequired
    @PUT
    @Path("/{courseId: [0-9]*}")
    @ApiOperation("Updates course with given ID")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header") })
    @ApiResponses({
            @ApiResponse(code = 200, message = "Course updated"),
            @ApiResponse(code = 404, message = "Course with given id does not exist"),
            @ApiResponse(code = 401, message = "Unauthenticated")
    })
    public Response updateCourse(@PathParam("studentId") int studentId,
                               @PathParam("courseId") int id, Course course) {
        //course.setId(id);
        //return courseService.updateCourse(studentId, course);
        if(courseService.getAllCourses(studentId).size() < id) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        course.setId(id);
        courseService.updateCourse(studentId, course);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{courseId: [0-9]*}")
    @ApiOperation("Deletes course with given ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Course deleted")})
    public void deleteCourse(@PathParam("studentId") int studentId,
                             @PathParam("courseId") int courseId) {
        courseService.removeCourse(studentId, courseId);
    }

    @GET
    @Path("/{courseId}")
    @ApiOperation("Returns course with given ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Course found"),
            @ApiResponse(code = 404, message = "Course with given id not found")
    })
    public Course getCourse(@PathParam("studentId") int studentId,
                            @PathParam("courseId") int courseId) {
        return courseService.getCourse(studentId, courseId);
    }
}

