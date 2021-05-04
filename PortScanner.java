/*
 * A simple PortScanner
 * Checks if the port is open for connections
 */
package ru.ncedu.tsarev.portscanner;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Tsarev Alexey
 */

public class PortScanner {
    private String ip;
    private int startingPort,
                endingPort;
    private Socket socket;
            
    /**
     * Default constructor
     */
    public PortScanner(){
        setHost("192.169.1.1");
        setStartingPort("0");
        setEndingPort("65535");
    }
    
    /**
     * Constructor for host parameter
     * @param Host ip address or domain name
     */
    public PortScanner(String Host){
        setHost(Host);
        setStartingPort("0");
        setEndingPort("65535");
    }

    /**
     * Constructor for host and one port parameter
     * @param Host ip address or domain name
     * @param port1 port with which scanning begins 
     */
    public PortScanner(String Host, String port1){
        setHost(Host);
        setStartingPort(port1);
        setEndingPort(port1);
    }
    
    /**
     * Constructor for host and ports range
     * @param Host ip address or domain name
     * @param port1 port with which scanning begins 
     * @param port2 port with witch scanning ends
     */
    public PortScanner(String Host, String port1, String port2){
        setHost(Host);
        setStartingPort(port1);
        setEndingPort(port2);
        if ( startingPort > endingPort){
            swapPort(startingPort, endingPort);
        }
    }

    /**
     * Constructor for parameters from console
     * @param data arguments from console
     */
    public PortScanner(String[] data){
        if (data.length < 1){
            System.out.println("You need at least one argument (address of host)!");
            System.exit(0);
        }
        if (data.length == 1){
            setHost(data[0]);
            setStartingPort("0");
            setEndingPort("65535");
            System.out.println("All ports (0-65535) will be scanned at host " + ip);            
        }
        if (data.length == 2){
            setHost(data[0]);
            setStartingPort(data[1]);
            setEndingPort(data[1]);
        }
        if (data.length == 3){
            setHost(data[0]);
            setStartingPort(data[1]);
            setEndingPort(data[2]);
        }        
        if (data.length > 3){
            System.out.println("Will be used just first three arguments!"); 
            setHost(data[0]);
            setStartingPort(data[1]);
            setEndingPort(data[2]);
        }   
    }
    /**
     * Scan ports of host
     * If there is no exception then the port is opened 
     */
    public void scan(){
        if ( startingPort > endingPort){                
            swapPort(startingPort, endingPort);
        }        
        for (int port =  Integer.valueOf(startingPort); port <= Integer.valueOf(endingPort); port++){
            try {
                socket = new Socket(ip, port);                            
                System.out.println("Server " + ip + " on port " + port + " is opened");
                socket.close();
            } catch (IOException exception){
                System.out.println("Server " + ip + " on port " + port + " is not opened");
            }
        }
    }
        
    /**
     * Set host for ports scanning
     * @param host ip address or domain name of host
     */
    public void setHost( String host){
        ip = host;
    }

    /**
     * Set the first port of host for scanning
     * @param port port with which scanning starts
     */
    public void setStartingPort(String port){
        startingPort = Integer.parseInt(port);
    }
    
    /**
     * Set the last port of host for scanning
     * @param port port with witch scanning ends
     */
    public void setEndingPort(String port){
        endingPort = Integer.parseInt(port);
    }
    /**
     * Set the first port of host for scanning
     * @param port port with which scanning starts
     */
    public void setStartingPort(int port){
        startingPort = port;
    }
    
    /**
     * Set the last port of host for scanning
     * @param port port with witch scanning ends
     */
    public void setEndingPort(int port){
        endingPort = port;
    }    
    /**
     * Swaps starting and ending ports if starting port > ending port
     * @param port1 starting port
     * @param port2 ending port
     */
    private void swapPort(int port1, int port2){
        int tempPort = port1;
        startingPort = port2;
        endingPort = tempPort;
    }    

}
