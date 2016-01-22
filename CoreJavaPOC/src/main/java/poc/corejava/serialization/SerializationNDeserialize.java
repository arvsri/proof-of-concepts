package poc.corejava.serialization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializationNDeserialize implements AutoCloseable{

	List<String> filesToRemove = new ArrayList<String>();
	
	// just serialize 
	public void test1() throws Exception{
		MyA a = new MyA();
		a.myA = 10;
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test1.ser"))){
			outputStream.writeObject(a);
		};
	}	

	
	// Serialize and deserialize and verify that different instances are created but object relation ship is maintained 
	public void test2() throws Exception{
		filesToRemove.add("test2.ser");
		
		MyA a = new MyA();
		a.myA = 30;
		
		MyC c1 = new MyC();c1.myC = 10;c1.myA = a;
		MyC c2 = new MyC();c2.myC = 20;c2.myA = a;
		MyC c3 = new MyC();c3.myC = 30;c3.myA = a;
		
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test2.ser"))){
			outputStream.writeObject(new MyC[]{c1,c2,c3});
		};
		
		try(ObjectInputStream inpuStream = new ObjectInputStream(new FileInputStream("test2.ser"))){
			MyC[] carr = (MyC[])inpuStream.readObject();

			System.out.println(carr[0].myC);
			System.out.println(carr[1].myC);
			System.out.println(carr[2].myC);

			System.out.println(carr[0].myA == carr[1].myA);
			System.out.println(carr[1].myA == carr[2].myA);
			
			System.out.println(carr[2].myA.myA);
			
			System.out.println(carr[0].myA == a);
		};
		
	}
	
	// test externalizable
	public void test3() throws Exception{
		filesToRemove.add("test3.ser");
		
		MyD d = new MyD();
		d.myD = 10;

		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test3.ser"))){
			outputStream.writeObject(d);
		};
		
		try(ObjectInputStream inpuStream = new ObjectInputStream(new FileInputStream("test3.ser"))){
			MyD d1 = (MyD)inpuStream.readObject();
			System.out.println(d1.myD);
		};
	}
	
	public static void main(String ... args) throws Exception{
		try(SerializationNDeserialize serNDser = new SerializationNDeserialize()){
			System.out.println(" ----------------- Test 1 ------------------");
			serNDser.test1();
			System.out.println(" ----------------- Test 2 ------------------");
			serNDser.test2();
			System.out.println(" ----------------- Test 3 ------------------");
			serNDser.test3();
		}
	}


	@Override
	public void close() throws Exception {
		for(String fileToRemove : filesToRemove){
			File f = new File(fileToRemove);
			if(f.exists()){
				f.delete();
			}
		}
	}
	
}

class MyA implements Serializable{
	int myA;
}

class MyB extends MyA{
	int myB;
}

class MyC implements Serializable{
	int myC;
	MyA myA;
}

class MyD implements Externalizable{
	
	int myD;

	public MyD(){}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(myD);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException {
		myD = in.readInt();
	}
}
