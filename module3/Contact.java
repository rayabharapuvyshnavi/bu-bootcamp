public class Contact{
    String name;
    String phone_number;

    public Contact(String name, String phone_number){
        this.name = name;
        this.phone_number = phone_number;
    }

    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phone_number;
    }

    public String toString(){
        return String.format("%s | %s", getName(), getPhoneNumber());
    }

}