package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface UserList extends Remote {

    public void addClient(Client c,String name) throws RemoteException;
    public void removeClient(Client c, String msg) throws RemoteException;
    public Client get(int i) throws RemoteException;
    public int size() throws RemoteException;
}