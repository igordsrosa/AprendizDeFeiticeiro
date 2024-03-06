/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MongoCrud;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

/**
 *
 * @author igoor
 */
public class conectaMongo {
   //CONECTAR LOGIN -----------------------------------------------------------------------------------------------------------------------
    
    public void getValues() {
        System.out.println("Método getValues()");
        //Conexão Mongo
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("HPGame");
        MongoCollection<Document> docs = db.getCollection("HPGame");
        for (Document doc : docs.find()) {
            System.out.println("item: " + doc);
        }
        System.out.println("getValues() -  ok - Finalizou");
    }

    public void insertValue(String nome, String senha) {
        System.out.println("Método insertValues()");
        //Conexão Mongo
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("HPGame");
        MongoCollection<Document> docs = db.getCollection("HPGame");

        Entrada user = createUser(nome,senha);
        //Cria um user obj da classe conectar, chamando o metodo createUser() - logo abaixo
        Document doc = createDocument(user);
        //Cria um doc que referencia o conteudo de user do createDocument(), obs: o Banco só entende objetos do tipo Document
        docs.insertOne(doc);//Insere no mongo o conteúdo de doc
        getValues();
        System.out.println("insertValues() - ok");
    }

    public Entrada createUser(String nome, String senha) {
        //Esse metodo deve ser uma entrada externa (interface, scanner ou JOptionPanel
        Entrada entrada = new Entrada();
        entrada.setNome(nome);
        entrada.setSenha(senha);
        return entrada;
    }

    public Document createDocument(Entrada user) {
        Document docBuilder = new Document();
        docBuilder.append("nome", user.getNome());
        docBuilder.append("senha",user.getSenha());
        return docBuilder;
    }

    public void findValuesName(String nome) {
        System.out.println("Método findName()");
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("HPGame");
        MongoCollection<Document> docs = db.getCollection("HPGame");

        for (Document doc : docs.find(Filters.eq("nome", nome))) {
            System.out.println("Achou pelo nome: " + doc);
        }
        System.out.println("findName() - finalizou");
    }

    public void findValuessenha(String senha) {
        System.out.println("Método findName()");
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("HPGame");
        MongoCollection<Document> docs = db.getCollection("HPGame");

        for (Document doc : docs.find(Filters.eq("senha", senha))) {
            System.out.println("Achou pelo senha: " + doc);
        }
        System.out.println("findName() - finalizou");
    }

    public boolean findValuesSignUP(String email) {
        int x = 0;
        boolean t = false;

        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("HPGame");
        MongoCollection<Document> docs = db.getCollection("HPGame");

        for (Document doc : docs.find(Filters.eq("email", email))) {
            System.out.println("Achou pelo email: " + doc);
            Document z = doc;
            if (z.isEmpty()) {
                x = 1;
            }
        }

        System.out.println("findValuesSignUP() - finalizou");
        return t;
    }

    public void updateValues() {

        System.out.println("updateValues");
        //Entrada user = createUser();
        MongoClient mongo = new MongoClient("localhost", 27017);

        MongoDatabase db = mongo.getDatabase("HPGame");
        MongoCollection<Document> docs = db.getCollection("harrypotterjava");

        docs.updateOne(Filters.eq("nome", "admin"), Updates.set("senha", "1234"));
        System.out.println("Documento teve sucesso no update...");
        for (Document doc : docs.find()) {
            System.out.println("item update: " + doc);
        }

    }

    public boolean verificarLogin(String nome, String senha) {
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("HPGame");
        MongoCollection<Document> docs = db.getCollection("HPGame");

        // Consulta o banco de dados para verificar se as informações de login existem
        Document query = new Document("nome", nome).append("senha", senha);
        Document resultado = docs.find(query).first();

        // Se resultado não for nulo, as informações de login existem no banco de dados
        return resultado != null;
    }
    
}
