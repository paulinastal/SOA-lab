
package pl.edu.agh.soa.lab1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa.lab1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudent_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "addStudent");
    private final static QName _AddStudentAvatar_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "addStudentAvatar");
    private final static QName _AddStudentAvatarResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "addStudentAvatarResponse");
    private final static QName _AddStudentClasses_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "addStudentClasses");
    private final static QName _AddStudentClassesResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "addStudentClassesResponse");
    private final static QName _AddStudentResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "addStudentResponse");
    private final static QName _ChangeStudentName_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "changeStudentName");
    private final static QName _ChangeStudentNameResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "changeStudentNameResponse");
    private final static QName _DeleteStudent_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "deleteStudent");
    private final static QName _DeleteStudentResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "deleteStudentResponse");
    private final static QName _FilterStudents_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "filterStudents");
    private final static QName _FilterStudentsResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "filterStudentsResponse");
    private final static QName _GetStudentAvatar_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "getStudentAvatar");
    private final static QName _GetStudentAvatarResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "getStudentAvatarResponse");
    private final static QName _GetStudents_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "getStudents");
    private final static QName _GetStudentsResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "getStudentsResponse");
    private final static QName _Hello_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://lab1.soa.agh.edu.pl/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa.lab1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentAvatar }
     * 
     */
    public AddStudentAvatar createAddStudentAvatar() {
        return new AddStudentAvatar();
    }

    /**
     * Create an instance of {@link AddStudentAvatarResponse }
     * 
     */
    public AddStudentAvatarResponse createAddStudentAvatarResponse() {
        return new AddStudentAvatarResponse();
    }

    /**
     * Create an instance of {@link AddStudentClasses }
     * 
     */
    public AddStudentClasses createAddStudentClasses() {
        return new AddStudentClasses();
    }

    /**
     * Create an instance of {@link AddStudentClassesResponse }
     * 
     */
    public AddStudentClassesResponse createAddStudentClassesResponse() {
        return new AddStudentClassesResponse();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link ChangeStudentName }
     * 
     */
    public ChangeStudentName createChangeStudentName() {
        return new ChangeStudentName();
    }

    /**
     * Create an instance of {@link ChangeStudentNameResponse }
     * 
     */
    public ChangeStudentNameResponse createChangeStudentNameResponse() {
        return new ChangeStudentNameResponse();
    }

    /**
     * Create an instance of {@link DeleteStudent }
     * 
     */
    public DeleteStudent createDeleteStudent() {
        return new DeleteStudent();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

    /**
     * Create an instance of {@link FilterStudents }
     * 
     */
    public FilterStudents createFilterStudents() {
        return new FilterStudents();
    }

    /**
     * Create an instance of {@link FilterStudentsResponse }
     * 
     */
    public FilterStudentsResponse createFilterStudentsResponse() {
        return new FilterStudentsResponse();
    }

    /**
     * Create an instance of {@link GetStudentAvatar }
     * 
     */
    public GetStudentAvatar createGetStudentAvatar() {
        return new GetStudentAvatar();
    }

    /**
     * Create an instance of {@link GetStudentAvatarResponse }
     * 
     */
    public GetStudentAvatarResponse createGetStudentAvatarResponse() {
        return new GetStudentAvatarResponse();
    }

    /**
     * Create an instance of {@link GetStudents }
     * 
     */
    public GetStudents createGetStudents() {
        return new GetStudents();
    }

    /**
     * Create an instance of {@link GetStudentsResponse }
     * 
     */
    public GetStudentsResponse createGetStudentsResponse() {
        return new GetStudentsResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentAvatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "addStudentAvatar")
    public JAXBElement<AddStudentAvatar> createAddStudentAvatar(AddStudentAvatar value) {
        return new JAXBElement<AddStudentAvatar>(_AddStudentAvatar_QNAME, AddStudentAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentAvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "addStudentAvatarResponse")
    public JAXBElement<AddStudentAvatarResponse> createAddStudentAvatarResponse(AddStudentAvatarResponse value) {
        return new JAXBElement<AddStudentAvatarResponse>(_AddStudentAvatarResponse_QNAME, AddStudentAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentClasses }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentClasses }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "addStudentClasses")
    public JAXBElement<AddStudentClasses> createAddStudentClasses(AddStudentClasses value) {
        return new JAXBElement<AddStudentClasses>(_AddStudentClasses_QNAME, AddStudentClasses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentClassesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentClassesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "addStudentClassesResponse")
    public JAXBElement<AddStudentClassesResponse> createAddStudentClassesResponse(AddStudentClassesResponse value) {
        return new JAXBElement<AddStudentClassesResponse>(_AddStudentClassesResponse_QNAME, AddStudentClassesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeStudentName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeStudentName }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "changeStudentName")
    public JAXBElement<ChangeStudentName> createChangeStudentName(ChangeStudentName value) {
        return new JAXBElement<ChangeStudentName>(_ChangeStudentName_QNAME, ChangeStudentName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeStudentNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeStudentNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "changeStudentNameResponse")
    public JAXBElement<ChangeStudentNameResponse> createChangeStudentNameResponse(ChangeStudentNameResponse value) {
        return new JAXBElement<ChangeStudentNameResponse>(_ChangeStudentNameResponse_QNAME, ChangeStudentNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "deleteStudent")
    public JAXBElement<DeleteStudent> createDeleteStudent(DeleteStudent value) {
        return new JAXBElement<DeleteStudent>(_DeleteStudent_QNAME, DeleteStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "deleteStudentResponse")
    public JAXBElement<DeleteStudentResponse> createDeleteStudentResponse(DeleteStudentResponse value) {
        return new JAXBElement<DeleteStudentResponse>(_DeleteStudentResponse_QNAME, DeleteStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "filterStudents")
    public JAXBElement<FilterStudents> createFilterStudents(FilterStudents value) {
        return new JAXBElement<FilterStudents>(_FilterStudents_QNAME, FilterStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "filterStudentsResponse")
    public JAXBElement<FilterStudentsResponse> createFilterStudentsResponse(FilterStudentsResponse value) {
        return new JAXBElement<FilterStudentsResponse>(_FilterStudentsResponse_QNAME, FilterStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentAvatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "getStudentAvatar")
    public JAXBElement<GetStudentAvatar> createGetStudentAvatar(GetStudentAvatar value) {
        return new JAXBElement<GetStudentAvatar>(_GetStudentAvatar_QNAME, GetStudentAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentAvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "getStudentAvatarResponse")
    public JAXBElement<GetStudentAvatarResponse> createGetStudentAvatarResponse(GetStudentAvatarResponse value) {
        return new JAXBElement<GetStudentAvatarResponse>(_GetStudentAvatarResponse_QNAME, GetStudentAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "getStudents")
    public JAXBElement<GetStudents> createGetStudents(GetStudents value) {
        return new JAXBElement<GetStudents>(_GetStudents_QNAME, GetStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "getStudentsResponse")
    public JAXBElement<GetStudentsResponse> createGetStudentsResponse(GetStudentsResponse value) {
        return new JAXBElement<GetStudentsResponse>(_GetStudentsResponse_QNAME, GetStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lab1.soa.agh.edu.pl/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
