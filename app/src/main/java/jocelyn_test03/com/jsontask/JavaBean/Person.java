package jocelyn_test03.com.jsontask.JavaBean;

/**
 * Created by Jocelyn on 23/10/2016.
 */

public class Person {

        private int id ;
        private String name ;
        private String address ;
        private String imageIcon;
        private int age ;

        public Person() {
            // TODO Auto-generated constructor stub
        }

        public Person(int id, String name, String address,String imageIcon, int age){
            super();
            this.id = id;
            this.name = name;
            this.address = address;
            this.age = age;
            this.imageIcon = imageIcon;
        }

        public String getImageIcon() {
            return imageIcon;
        }

        public void setImageIcon(String imageIcon) {
            this.imageIcon = imageIcon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString(){

            return "person [id=" + id + "name=" + name+ "address=" + address +"age="
                    + age + "]";
        }

}


