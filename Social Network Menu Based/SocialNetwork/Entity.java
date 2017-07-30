package SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Entity implements Node {
	private static int entityCount;
	private String userId;
	private String userName;
	private String email;
	private String nameOfEntity;
	private String entityType;
	public Entity() {          // sets userId for each Object: Unique to each instance
        userId=""+(++entityCount);
    }
	private static Map<String,Entity> entityMap;

	public static Map<String, Entity> getEntityMap() {
		return entityMap;
	}
	public static void setEntityMap(HashMap<String, Entity> entityMap) {
		Entity.entityMap = entityMap;
	}
	
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNameOfEntity() {
		return nameOfEntity;
	}
	public void setNameOfEntity(String nameOfEntity) {
		this.nameOfEntity = nameOfEntity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
	
    public static void generateEntityMap() {               //Mapping the entities to their unique userName
        entityMap=new HashMap<String,Entity>();
        for(Entity p:Person.getListOfPerson()) {
            entityMap.put(p.getUserName(),(Person)p);
        }
        for(Entity p:Organisation.getListOfOrganisation()) {
            entityMap.put(p.getUserName(),(Organisation)p);
        }
    }
    
    @Override
	public boolean equals(Object o) {                  //overriding equals method for entity comparison
		 // If the object is compared with itself then return true  
        if (o == this) {
            return true;
        }
 
        // Check if o is an instance of Entity or not 
        if (!(o instanceof Entity)) {
            return false;
        }
         
        // typecast o to Entity so that we can compare data members 
        Entity e = (Entity) o;
        //check if hash bucket is same
         if(!(this.hashCode()==e.hashCode())) {
             return false;
         }
        // Compare the data members and return accordingly 
        return this.userId.equals(e.userId);
    }
	
	public abstract String showSummary();              //to show summary : to be overriden in subclass 
	
	public static List<Entity> searchByName(String name) {        //method to search entities by name
		List<Entity> searchResults=new ArrayList<Entity>();       //holds all entities matching search results
		
		for(Entity p:Person.getListOfPerson()) {                  //search in person list
			if(name.equalsIgnoreCase(p.getNameOfEntity())) {
				searchResults.add(p);
			}
		}
		for(Entity p:Organisation.getListOfOrganisation()) {      // search in organisation list
			if(name.equalsIgnoreCase(p.getNameOfEntity())) {
				searchResults.add(p);
			}
		}
		return searchResults;
	}
	
	@Override                                                     //overriding hashCode method
	public int hashCode() {
	    return userName.hashCode()+email.hashCode();
	}
}
