import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * Created by Ai Lun on 2020-12-23.
 */
public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
