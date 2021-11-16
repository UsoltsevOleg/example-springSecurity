package trainee.spring.securityjwt.config;

public enum ApplicationUserPermission {
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write"),
    TASK_READ("task:read"),
    TASK_WRITE("task:write"),
    TASK_CREATE("task:create");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
