package npl;

import java.rmi.*;
import java.io.*;
import java.rmi.server.*;

class CalciImp extends UnicastRemoteObject implements Calci
{
	CalciImp()throws RemoteException
	{
	}
	int res;
	public int add(int n1,int n2)
	{
		return n1+n2;
	}
	public int sub(int n1,int n2)
	{
		return n1-n2;
	}
	public float div(int n1,int n2)
	{
		return n1/n2;
	}

}

