package SocialNetwork;

import java.util.List;

public class Graph {
	private static List<Connection> connectedEntities;     //holds the connection object list for two connected entities

	public static List<Connection> getConnectedEntities() {
		return connectedEntities;
	}

	public static void setConnectedEntities(List<Connection> connectedEntities) {
		Graph.connectedEntities = connectedEntities;
	}
}
