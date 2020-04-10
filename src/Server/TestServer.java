package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class TestServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocket ssc = new ServerSocket();
		ssc.bind(new InetSocketAddress("10.0.0.97",9999));
		new Sserver(ssc);
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}