import ExAcro.*;
import ExEmo.*;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;

public class ExClient {
	  public static void main(String [] args) {
		  int text;
		  int output;

		  try {
		      TTransport transport;
		     
		        transport = new TSocket("localhost", 9072);
		        transport.open();
		      
		        TProtocol protocol = new  TBinaryProtocol(transport);
		      extractionservices.Client client = new extractionservices.Client(protocol);

		      perform(client);

		      transport.close();
		    } catch (TException x) {
		      x.printStackTrace();
		    } 
		  }

		  private static void perform(extractionservices.Client client) throws TException
		  {
		    client.ping();
		    System.out.println("ping()");

 String text = "hey hello :p , today is tuesday :) rofl and LOL the weather is :p too hot @ chennai and i lysm :( :p lol , ok ciao ";
	String output = client.ExAcro(text);
System.out.println(output);

		    


		  }
		}
