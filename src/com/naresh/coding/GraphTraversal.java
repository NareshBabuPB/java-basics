package com.naresh.coding;

import java.util.*;


public class GraphTraversal {
	
	    static class Graph{
	        Set<Node> nodes = new HashSet<Node>();
	        List<Edge> edges = new ArrayList<Edge>();
	        
	        Set<Node> getNodes(){
	            return nodes;
	        }
	        
	        List<Edge> getEdges(){
	            return edges;
	        }
	        
	        Node getNode(int value){
	            for(Node n : getNodes()){
	                if(value == n.getData()){
	                    return n;
	                }
	            }
	            return null;
	        }
	    }
	    
	    static class Node{
	        int data;
		    List<Edge> neighbours = new ArrayList<Edge>();
		    
		    Node(int value){
		        data = value;
		    }
		    
		    int getData(){
		        return data;
		    }
		    
		    List<Edge> getNeighbours(){
		        return neighbours;
		    }
		    
		    public int hashCode(){
		        return data;
		    }
		    
		    public boolean equals(Node node){
		        return this.data == node.data;
		    }
	    }
	    
	    static class Edge{
	        Node A, B;
		    
		    Edge(Node start, Node end){
		        A = start;
		        B = end;
		    }
		    
		    Node getStart(){
		        return A;
		    }
		    
		    Node getEnd(){
		        return B;
		    }
	    }
	    
	    public static void main(String args[] ) throws Exception {
	        try{
	        /*
	         * Read input from stdin and provide input before running
	         * Use either of these methods for input
	        
	        //BufferedReader
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        */
	        //Scanner
	        Scanner s = new Scanner(System.in);
	        int N = s.nextInt();  // #Nodes
	        int M = s.nextInt(); // #Edges
	        
	        GraphTraversal.Graph g = new GraphTraversal.Graph();

	        for (int i = 1; i <= M; i++) {
	        	GraphTraversal.Node start = new GraphTraversal.Node(s.nextInt());
	        	GraphTraversal.Node end = new GraphTraversal.Node(s.nextInt());
	            
	        	GraphTraversal.Edge e = new GraphTraversal.Edge(start, end);
	            
	            g.getNodes().add(start);
	            g.getNodes().add(end);
	            g.getEdges().add(e);
	            
	            g.getNode(start.getData()).getNeighbours().add(e);
	        }
	        
	        int Q = s.nextInt();

	        OuterLoop:
	        for (int i = 1; i <= Q; i++) {
	        	GraphTraversal.Node A = g.getNode(s.nextInt());
	        	GraphTraversal.Node B = g.getNode(s.nextInt());
	            
	            if(A != null && B != null){
	                
	                for(GraphTraversal.Edge e : A.getNeighbours()){
	                    if(e.getStart().equals(A)
	                    && e.getEnd().equals(B)){
	                       System.out.println("YES"); 
	                       continue OuterLoop;
	                    }
	                }
	                
	                /*for(GraphTraversal.Edge e : B.getNeighbours()){
	                    if(e.getStart().equals(B)
	                    && e.getEnd().equals(A)){
	                       System.out.println("YES"); 
	                       continue;
	                    }
	                }*/
	            }
	            
	            System.out.println("NO");
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    }   

}
