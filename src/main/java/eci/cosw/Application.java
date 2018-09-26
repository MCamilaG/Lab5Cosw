package eci.cosw;

import eci.cosw.data.CustomerRepository;
import eci.cosw.data.model.Customer;
import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import eci.cosw.data.AppConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import eci.cosw.data.TodoRepository;
import eci.cosw.data.UserRepository;
import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;



    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        todoRepository.deleteAll();

        todoRepository.save(new Todo("Tarea ACFI",5,new Date(2018-1900,9,27),"Camila","Completo"));
        todoRepository.save(new Todo("Tarea SEGI",2,new Date(2018-1900,9,30),"Nicolas","Pendiente"));
        todoRepository.save(new Todo("Tarea PRON",1,new Date(2018-1900,11,5),"Maria","Completo"));
        todoRepository.save(new Todo("Tarea COSW",3,new Date(2018-1900,12,1),"Tatiana","Pendiente"));
        todoRepository.save(new Todo("Tarea APMU",4,new Date(2018-1900,11,6),"Juan David","Pendiente"));
        todoRepository.save(new Todo("Recoge todos los documentos para sacar el pase esta semana",5,new Date(2018-1900,10,3),"Alfonso","Completo"));
        todoRepository.save(new Todo("Tarea ARQC",5,new Date(2018-1900,10,10),"Gloria","Pendiente"));
        todoRepository.save(new Todo("Salir con amigos",2,new Date(2018-1900,11,20),"Julieta","Pendiente"));
        todoRepository.save(new Todo("Lavra el carro",4,new Date(2018-1900,10,1),"Ricardo","Pendiente"));
        todoRepository.save(new Todo("Hacer planos de obra",3,new Date(2018-1900,11,20),"Angel","Completo"));
        todoRepository.save(new Todo("Tarea IMER",1,new Date(2018-1900,12,15),"Camila","Completo"));
        todoRepository.save(new Todo("Ir a reunion de trabajo",4,new Date(2018-1900,10,25),"Nicolas","Pendiente"));
        todoRepository.save(new Todo("Concierto Banda Favorita",5,new Date(2018-1900,11,11),"Maria","Pendiente"));
        todoRepository.save(new Todo("Almuerzo amigas del colegio",3,new Date(2018-1900,9,28),"Tatiana","Pendiente"));
        todoRepository.save(new Todo("Tarea ECDI",2,new Date(2018-1900,10,2),"Juan David","Completo"));
        todoRepository.save(new Todo("Comprar regalo mamá",5,new Date(2018-1900,11,26),"Alfonso","Completo"));
        todoRepository.save(new Todo("Tarea ARSW",1,new Date(2018-1900,11,4),"Gloria","Completo"));
        todoRepository.save(new Todo("Comprar utiles colegio",4,new Date(2018-1900,10,9),"Julieta","Pendiente"));
        todoRepository.save(new Todo("Tarea MAPA",3,new Date(2018-1900,12,2),"Ricardo","Completo"));
        todoRepository.save(new Todo("Hacer presentacion COSW",2,new Date(2018-1900,10,24),"Angel","Pendiente"));
        todoRepository.save(new Todo("Tarea PMLI",1,new Date(2018-1900,12,24),"Camila","Pendiente"));
        todoRepository.save(new Todo("Comprar arbol de navidad",2,new Date(2018-1900,12,20),"Nicolas","Completo"));
        todoRepository.save(new Todo("Tarea AREM",5,new Date(2018-1900,11,13),"Maria","Pendiente"));
        todoRepository.save(new Todo("Recoger paquete de Canada",4,new Date(2018-1900,10,2),"Tatiana","Completo"));
        todoRepository.save(new Todo("Tarea SPPC",2,new Date(2018-1900,12,3),"Juan David","Pendiente"));

        userRepository.deleteAll();

        userRepository.save(new User("100","Camila","camila@gmail.com"));
        userRepository.save(new User("101","Nicolas","nicolas@gmail.com"));
        userRepository.save(new User("102","Maria","maria@gmail.com"));
        userRepository.save(new User("103","Tatiana","tatiana@gmail.com"));
        userRepository.save(new User("104","Juan David","juandavid@gmail.com"));
        userRepository.save(new User("105","Alfonso","alfonso@gmail.com"));
        userRepository.save(new User("106","Gloria","gloria@gmail.com"));
        userRepository.save(new User("107","Julieta","julieta@gmail.com"));
        userRepository.save(new User("108","Ricardo","ricardo@gmail.com"));
        userRepository.save(new User("109","Angel","angel@gmail.com"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();


    }

}