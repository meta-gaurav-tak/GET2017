package SocialNetwork;

public class Connection {
	
	Entity connectionNode1;
	Entity connectionNode2;
	
	public Connection() {	
	}

	public Connection(Entity connectionNode1, Entity connectionNode2) {
		this.connectionNode1 = connectionNode1;
		this.connectionNode2 = connectionNode2;
	}
	
	public Entity getConnectionNode1() {
		return connectionNode1;
	}

	public void setConnectionNode1(Entity connectionNode1) {
		this.connectionNode1 = connectionNode1;
	}

	public Entity getConnectionNode2() {
		return connectionNode2;
	}

	public void setConnectionNode2(Entity connectionNode2) {
		this.connectionNode2 = connectionNode2;
	}

	public static void createConnection(Entity connectionNode1,Entity connectionNode2) {
		boolean flag=true;
		if(connectionNode1==connectionNode2) {        //check if source and destination are same
			System.out.println("Connection to self not possible");
			return;
		}
		Connection newConnection=null;	
		for(Connection connection:Graph.getConnectedEntities()) {         // loop through existing connections
			
			/*check if the connection entry already exists in our connection list
			 * overriden equals method for node comparison */
			
			if( (connection.getConnectionNode1().equals(connectionNode1) && 
			        connection.getConnectionNode2().equals(connectionNode2) ) 
			        ||
				( connection.getConnectionNode1().equals(connectionNode2) &&
					connection.getConnectionNode2().equals(connectionNode1)) ) {
				flag=false;
				break;
			} 
		}
		if(flag) {                            //if no such connection already exists
			newConnection=new Connection(connectionNode1,connectionNode2);
			Graph.getConnectedEntities().add(newConnection);
			System.out.println("Succesfully created connection");
		} else {
			System.out.println("Duplicate connection entry");
		}
	}	
}
