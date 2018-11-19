package npl;

import java.rmi.*;
public interface Calci extends Remote	
{
	public int add(int n1,int n2)throws RemoteException;
	public int sub(int n1,int n2)throws RemoteException;
	public float div(int n1,int n2)throws RemoteException;
}