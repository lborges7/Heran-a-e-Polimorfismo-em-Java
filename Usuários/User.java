public abstract sealed class User permits Manager, Salesman, Cashier {

    private String name;
    private String email;
    protected String password;
    private boolean isAdmin;
    private boolean loggedIn;

    public User(String name, String email, String password, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean login(String inputEmail, String inputPassword) {
        return this.loggedIn = getEmail().equals(inputEmail) && getPassword().equals(inputPassword);
    }

    public boolean logoff() {
        if (!login(email, password)) {
            return false;
        }
        return true;
    }

    // Alteração de Dados
    public void changeData(String newName, String newEmail) {
        setName(newName);
        setEmail(newEmail);
    }

    public void changePassword(String newPassword) {
        setPassword(newPassword);
    }
}