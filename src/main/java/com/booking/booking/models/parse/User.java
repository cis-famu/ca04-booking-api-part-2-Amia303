package edu.famu.booking.models.parse;

import edu.famu.booking.models.serializable.SerializableUser;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("User")
public class User extends ParseObject {
    private final String ID = "id";
    private final String USERNAME = "username";
    private final String EMAIL = "email";
    private final String COUNTRY = "country";
    private final String IMG = "img";
    private final String CITY = "city";
    private final String PHONE = "phone";
    private final String ADMIN = "isAdmin";

    public String getId(){
        return getString(ID);
    }
    public void setId(String id){
        put(ID, id);
    }

    public String getUsername(){
        return getString(USERNAME);
    }
    public void setUsername(String username){
        put(USERNAME, username);
    }

    public String getEmail(){
        return getString(EMAIL);
    }
    public void setEmail(String email){
        put(EMAIL, email);
    }

    public String getCountry(){
        return getString(COUNTRY);
    }
    public void setCountry(String country){
        put(COUNTRY, country);
    }

    public String getImg(){
        return getString(IMG);
    }
    public void setImg(String img){
        put(IMG, img);
    }

    public String getCity(){
        return getString(CITY);
    }
    public void setCity(String city){
        put(CITY, city);
    }

    public String getPhone(){
        return getString(PHONE);
    }
    public void setPhone(String phone){
        put(PHONE, phone);
    }

    public boolean getIsAdmin(){
        return getBoolean(ADMIN);
    }
    public void setIsAdmin(String isAdmin){
        put(ADMIN, isAdmin);
    }

    public SerializableUser getSerializable(){
        return new SerializableUser(
                getId(), getUsername(), getEmail(), getCountry(),
                getImg(), getCity(), getPhone(), getIsAdmin());
    }
}
