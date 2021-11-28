package proyecto.Lists;

import proyecto.sampleClasses.User;

/**
 * @author Luis Edo. Hodgson Quesada C13822
 * @time 23:13:05
 * @date 26 nov. 2021
 */
public class UserList {

    private User[] userList;
    private int index = 0;
    private int TAMANO = 10;

    public UserList() {
        this.userList = new User[TAMANO];
    }

    public UserList(User[] userVector) {
        if (userVector == null) {
            this.userList = new User[TAMANO];
        } else {
            this.userList = userVector;
        }
    }
    
    
    public void setUser(User user) {
        if (index < TAMANO) {
            userList[index] = user;
            index++;
        }
    }
    
    public int getTAMANO(){
      return userList.length;  
    }
    
    public User getElemento() {
        int elementoRandom = (int) (Math.random() * index);

        return userList[elementoRandom]; // falta validaciones (null, etc.. )
    }
    
}