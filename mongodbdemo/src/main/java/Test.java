import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Test {

    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase accp = client.getDatabase("accp");
        //创建表
        //accp.createCollection("teacher");

        MongoCollection<Document> student = accp.getCollection("teacher");

        //增加
        //Document document = new Document("name", "小三").append("age", 66);
        //student.insertOne(document);



        //修改
        /*student.updateOne(Filters.eq("name","小三"),
                new Document("$set",new Document("name","小四")));*/

        //删除
        student.deleteOne(Filters.regex("name", "小\\w*"));

        //显示数据
        FindIterable<Document> findIterable = student.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }

        client.close();
    }
}
